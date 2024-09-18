package com.northcoders.fruityvice;

import android.app.Application;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.fruityvice.databinding.ActivityMainBinding;
import com.northcoders.fruityvice.model.Fruit;
import com.northcoders.fruityvice.model.FruitRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Fruit> fruitList;
    private FruitAdapter fruitAdapter;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This is just to see if it's showing in LogCat
        //Application application = new Application();
        //FruitRepository fruitRepository = new FruitRepository(application);
        //fruitRepository.getMutableLiveData();

        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main);

        viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        getAllFruits();
    }

    private void getAllFruits() {
        viewModel.getAllFruit().observe(this, new Observer<List<Fruit>>() {
            @Override
            public void onChanged(List<Fruit> fruits) {
                fruitList = (ArrayList<Fruit>) fruits;

                displayFruitsInRecyclerView();
            }
        });
    }

    private void displayFruitsInRecyclerView() {
        recyclerView = binding.recyclerView;
        fruitAdapter = new FruitAdapter(this, fruitList);
        recyclerView.setAdapter(fruitAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        fruitAdapter.notifyDataSetChanged();
    }
}