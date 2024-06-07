package com.example.tiendafake.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiendafake.R;
import com.example.tiendafake.models.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.viewHolder>{

    ArrayList<Product>plist;
    Context context;

    public ProductAdapter(ArrayList<Product> plist, Context context) {
        this.plist = plist;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_layout, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final Product products = plist.get(position);
        holder.pimage.setImageResource(products.getImage());
        holder.detail.setText(products.getTitle());
        holder.price.setText(products.getPrice() + " USD");

    }

    @Override
    public int getItemCount() {
        return plist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView pimage;
        TextView detail ,price;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            pimage = itemView.findViewById(R.id.productimage);
            detail = itemView.findViewById(R.id.productdetails);
            price = itemView.findViewById(R.id.productprice);

        }
    }
}
