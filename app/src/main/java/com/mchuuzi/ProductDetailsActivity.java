package com.mchuuzi;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.mchuuzi.models.ProductsModel;

public class ProductDetailsActivity extends AppCompatActivity {
    private ProductsModel productsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        productsModel = (ProductsModel) getIntent().getSerializableExtra("product");
        Log.d("productsdetails", productsModel.getDescription() + "dcdcdcdc");

        //here get the passed product
        ///clicked by use
        // fr now its hard coded
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, ProductDetailsFragment.newInstance(productsModel)).commit();





    }

}
