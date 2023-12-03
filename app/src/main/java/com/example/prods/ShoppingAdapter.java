package com.example.prods;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder> {

    private List<ShoppingItem> shoppingList;

    static class ShoppingViewHolder extends RecyclerView.ViewHolder {
        TextView shoppingItem;
        Button deleteButton;

        ShoppingViewHolder(@NonNull View itemView) {
            super(itemView);
            shoppingItem = (TextView) itemView.findViewById(R.id.product);
            deleteButton = (Button) itemView.findViewById(R.id.removeButton);
        }

        public TextView getShoppingItem(){
            return shoppingItem;
        }

        public Button getDeleteButton(){
            return deleteButton;
        }

    }


    public ShoppingAdapter(List<ShoppingItem> shoppingList) {
        this.shoppingList = shoppingList;
    }

    @NonNull
    @Override
    public ShoppingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shopping, parent, false);
        return new ShoppingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ShoppingViewHolder holder, int position) {
        holder.getShoppingItem().setText(shoppingList.get(position).getName());
        holder.getDeleteButton().setOnClickListener(v -> deleteNote(position));
    }

    @Override
    public int getItemCount() {
        return shoppingList.size();
    }

    public void deleteNote(int position){
        shoppingList.remove(position);
        notifyDataSetChanged();
    }

    public void addNote(String name){
        ShoppingItem item = new ShoppingItem(name);
        shoppingList.add(item);
        notifyItemInserted(shoppingList.size() - 1);
    }

}
