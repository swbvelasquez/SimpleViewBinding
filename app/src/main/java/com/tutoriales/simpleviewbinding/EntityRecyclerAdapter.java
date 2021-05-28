package com.tutoriales.simpleviewbinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tutoriales.simpleviewbinding.databinding.EntityRecyclerRowBinding;

import java.util.ArrayList;
import java.util.List;

public class EntityRecyclerAdapter extends RecyclerView.Adapter<EntityRecyclerAdapter.EntityViewHolder> {

    private List<Entity> entityList;

    public EntityRecyclerAdapter(List<Entity> entityList) {
        this.entityList = entityList;
    }

    @Override
    public EntityViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        EntityRecyclerRowBinding binding = EntityRecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        EntityViewHolder holder = new EntityViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull  EntityRecyclerAdapter.EntityViewHolder holder, int position) {
        holder.onBindViewHolder(entityList.get(position));
    }

    @Override
    public int getItemCount() {
        return entityList.size();
    }

    public class EntityViewHolder extends RecyclerView.ViewHolder{
        private EntityRecyclerRowBinding binding;

        public EntityViewHolder(EntityRecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void onBindViewHolder(Entity entity){
            binding.tvDescription.setText(entity.getName());
        }
    }
}
