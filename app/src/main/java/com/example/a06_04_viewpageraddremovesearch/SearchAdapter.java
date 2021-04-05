package com.example.a06_04_viewpageraddremovesearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.a06_04_viewpageraddremovesearch.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends
        RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{
    private List<Product> searchList;

    public SearchAdapter() {
        searchList=new ArrayList<>();
    }

    public void setSearchList(List<Product> searchList) {
        this.searchList = searchList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                               int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_search,parent,false);
        return new SearchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder,
                                 int position) {
        Product p=searchList.get(position);
        if(p!=null) {
            holder.img.setImageResource(p.getResouceImg());
            holder.name.setText(p.getName());
            holder.price.setText(p.getPrice() + "");
            holder.describe.setText(p.getDescribe());
        }else
            return;
    }

    @Override
    public int getItemCount() {
        if(searchList!=null)
            return searchList.size();
        else
            return 0;
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView name;
        private TextView price;
        private TextView describe;
        public SearchViewHolder(@NonNull View v) {
            super(v);
            img= v.findViewById(R.id.img);
            name=v.findViewById(R.id.txtName);
            price=v.findViewById(R.id.txtPrice);
            describe=v.findViewById(R.id.txtDescribe);
        }
    }
}
