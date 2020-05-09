package com.mchuuzi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.textview.MaterialTextView;
import com.mchuuzi.models.ProductsModel;
import com.squareup.picasso.Picasso;

public class ProductDetails_Activity extends AppCompatActivity {
    ProductsModel productsModel;
    private ImageView product_image_view;
    private MaterialTextView productname, productAmount, productDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details_);

        productsModel = (ProductsModel) getIntent().getSerializableExtra("product");
        product_image_view = findViewById(R.id.product_detail_image);
        productAmount = findViewById(R.id.product_details_amount);
        productname = findViewById(R.id.product_details_name);
        productDescription = findViewById(R.id.product_full);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(productsModel.getName());
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        productDescription.setText(productsModel.getDescription());
        productAmount.setText("KSh: " + productsModel.getPrice());
        productname.setText(productsModel.getName());
        Picasso.get()
                .load(productsModel.getImage())

                .into(product_image_view);
    }
}
