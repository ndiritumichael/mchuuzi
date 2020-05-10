package com.mchuuzi.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.mchuuzi.R;
import com.mchuuzi.models.Vendors;
import com.mchuuzi.models.Vendors_Fragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class VendorsAdapter extends RecyclerView.Adapter<VendorsAdapter.VendorViewHolder> {
    private List<Vendors> vendorsList;

    public VendorsAdapter(List<Vendors> vendorsList) {
        this.vendorsList = vendorsList;
    }

    @NonNull
    @Override
    public VendorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vendors_listadapter, parent, false);
        return new VendorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VendorViewHolder holder, int position) {
        holder.vendorname.setText(vendorsList.get(position).getVendor_name());
        holder.vendorlocation.setText(vendorsList.get(position).getVendor_location());
        Picasso.get()
                .load(vendorsList.get(position).getVendorimage())
                .noFade()
                .into(holder.circleImageView);

    }

    @Override
    public int getItemCount() {
        return vendorsList.size();
    }

    public class VendorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private MaterialTextView vendorname, vendorlocation;
        private Vendors_Fragment vendors_fragment;
        private CircleImageView circleImageView;

        public VendorViewHolder(@NonNull View itemView) {
            super(itemView);

            vendorlocation = itemView.findViewById(R.id.vendor_location);
            vendorname = itemView.findViewById(R.id.vendor_name);
            circleImageView = itemView.findViewById(R.id.vendor_image);
        }

        @Override
        public void onClick(View view) {


        }
    }
}
