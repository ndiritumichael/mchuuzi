package com.mchuuzi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mchuuzi.R;
import com.mchuuzi.models.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter  extends RecyclerView.Adapter <CartViewHolder>{
    private List<OrderItem> orderItems;
    private Context context;

    public CartAdapter(List<OrderItem> orderItems, Context context) {
        this.orderItems = orderItems;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item, parent,false);



        return new CartViewHolder(view,this.orderItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}


class CartViewHolder extends RecyclerView.ViewHolder {


    private List<OrderItem> orderItems;


    public CartViewHolder(@NonNull View itemView,List<OrderItem> orderItems) {
        super(itemView);
    }
}
