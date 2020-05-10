package com.mchuuzi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mchuuzi.R;
import com.mchuuzi.Repository;
import com.mchuuzi.adapters.VendorsAdapter;
import com.mchuuzi.models.Vendors;

import java.util.List;


public class Vendors_Fragment extends Fragment {
    private List<Vendors> vendorsList;
    private RecyclerView recyclerView;
    private Repository repository;
    private VendorsAdapter vendorsAdapter;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.vendorslist);
        repository = new Repository();
        vendorsList = repository.getVendorsList();
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        vendorsAdapter = new VendorsAdapter(vendorsList);
        recyclerView.setAdapter(vendorsAdapter);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vendors_, container, false);
    }


}
