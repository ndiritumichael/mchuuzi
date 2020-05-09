package com.mchuuzi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mchuuzi.adapters.CartAdapter;
import com.mchuuzi.models.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    private CartAdapter adapter;
    private RecyclerView recyclerView;
    private List<OrderItem> orderItemList;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.products_recycler);
        initComponents();

       /* view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CartFragment.this)
                        .navigate(R.id.action_CartFragment_to_ProductFragment);
            }
        });*/
    }


   private void initComponents(){

        ///repository = new Repository();
        orderItemList =  new ArrayList<>();

        adapter = new CartAdapter(orderItemList,getActivity());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    public static CartFragment newInstance() {

        Bundle args = new Bundle();

        CartFragment fragment = new CartFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
