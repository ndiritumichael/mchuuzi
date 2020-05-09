package com.mchuuzi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.mchuuzi.adapters.ProductsAdapter;
import com.mchuuzi.models.ProductsModel;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

public class ProductFragment extends Fragment {
    private  Repository repository;
    private ProductsAdapter adapter;
    private RecyclerView recyclerView;
    private List<ProductsModel> productsModelList;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       recyclerView = view.findViewById(R.id.products_recycler);
       initComponents();



        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ProductFragment.this)
                        .navigate(R.id.action_ProductFragment_to_CartFragment);
                Snackbar.make(view, "To Cart", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

    void initComponents(){

        repository = new Repository();
        productsModelList = repository.getProductsModelList();
        adapter = new ProductsAdapter(productsModelList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL));

    }


}
