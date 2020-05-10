package com.mchuuzi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.mchuuzi.R;
import com.mchuuzi.Vendors_Fragment;
import com.mchuuzi.models.Vendors;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class VendorsAdapter extends RecyclerView.Adapter<VendorsAdapter.VendorViewHolder> {
    private List<Vendors> vendorsList;

    public VendorsAdapter(List<Vendors> vendorsList) {
        this.vendorsList = vendorsList;
    }

    public interface OnItemClickListener{
        void openVendor(int position);
    }
    private OnItemClickListener itemClickListener;

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
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if(itemClickListener != null && position != RecyclerView.NO_POSITION){
                itemClickListener.openVendor(position);
            }
        }
    }

    public void addItemClickListener(OnItemClickListener listener){
        itemClickListener = listener;
    }
    public void removeItemClickListener(){
        itemClickListener = null;
    }

}
