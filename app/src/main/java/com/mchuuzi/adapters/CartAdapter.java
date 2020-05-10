package com.mchuuzi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mchuuzi.R;
import com.mchuuzi.models.OrderItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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
      OrderItem orderItem=orderItems.get(position);
      holder.quantity.setText(String.valueOf(orderItem.getQuantity()));
      double total=orderItem.getQuantity()*orderItem.getPrice();

      String amount = "KSh: " + total;
      holder.price.setText(amount);
      holder.product_name.setText(String.valueOf(orderItem.getName()));
        Picasso.get().load(orderItem.getImage())

                .into(holder.image);


    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }
}


 class CartViewHolder extends RecyclerView.ViewHolder {
      TextView quantity, product_name,price;
      CircleImageView image;


    private List<OrderItem> orderItems;


     CartViewHolder(@NonNull View itemView, List<OrderItem> orderItems) {
        super(itemView);
        quantity=itemView.findViewById(R.id.quantity);
        price=itemView.findViewById(R.id.price);

        image=itemView.findViewById(R.id.image);
        product_name=itemView.findViewById(R.id.name);

    }
}
