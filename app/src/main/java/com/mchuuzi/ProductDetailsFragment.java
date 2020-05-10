package com.mchuuzi;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.mchuuzi.models.ProductsModel;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailsFragment extends Fragment {
    private TextView productName, productAmount, productDescription;
    private ImageView productImage;
    private ProductsModel product;
   private MaterialButton addToCart  ;

    public ProductDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_details, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        product = (ProductsModel) getArguments().getSerializable("product");


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productName = view.findViewById(R.id.name);
        productAmount = view.findViewById(R.id.price);
        productDescription = view.findViewById(R.id.description);
        productImage = view.findViewById(R.id.image);
        addToCart=view.findViewById(R.id.add_to_cart);
        initComponents();

    }

    public static ProductDetailsFragment newInstance(ProductsModel product) {

        Bundle args = new Bundle();
        args.putSerializable("product", product);

        ProductDetailsFragment fragment = new ProductDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void initComponents() {

        productName.setText(product.getName());
        productDescription.setText(product.getDescription());
        String amount = "KSh: " + product.getPrice();

        productAmount.setText(amount);
        Picasso.get().load(product.getImage())

                .into(productImage);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Repository.addOrderItem(product);
                ((ProductDetailsActivity)getActivity()).updateCart();
                Log.e("order items list", Repository.orderItems.toString());
                Log.e("added item items list", Repository.orderItems.get(0).toString());
                ///Toast.makeText(getActivity(), String.valueOf(Repository.orderItems.size()), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
