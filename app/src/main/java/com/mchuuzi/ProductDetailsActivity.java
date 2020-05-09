package com.mchuuzi;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.mchuuzi.models.ProductsModel;

public class ProductDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //here get the passed product
        ///clicked by use
        // fr now its hard coded
        ProductsModel product=(ProductsModel) getIntent().getSerializableExtra("product");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(product.getName());
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,ProductDetailsFragment.newInstance(product)).commit();





    }

}
