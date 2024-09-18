package com.northcoders.fruityvice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.fruityvice.databinding.FruitItemBinding;
import com.northcoders.fruityvice.model.Fruit;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FruitItemBinding binding = DataBindingUtil
                .inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.fruit_item,
                        parent,
                        false);
        return new FruitViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        holder.fruitItemBinding.setFruit(fruit);
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder {

        private final FruitItemBinding fruitItemBinding;

        public FruitViewHolder(FruitItemBinding fruitItemBinding) {
            super(fruitItemBinding.getRoot());
            this.fruitItemBinding = fruitItemBinding;
        }
    }

    List<Fruit> fruitList;
    Context context;
    public FruitAdapter(Context context, List<Fruit> fruitList) {
        this.context = context;
        this.fruitList = fruitList;
    }

}
