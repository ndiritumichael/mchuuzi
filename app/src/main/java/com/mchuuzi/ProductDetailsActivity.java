package com.mchuuzi;

import android.os.Bundle;

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
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,ProductDetailsFragment.newInstance(new ProductsModel())).commit();





    }

}
