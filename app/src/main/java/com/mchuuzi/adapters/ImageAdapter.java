package com.mchuuzi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mchuuzi.models.Images;
import com.mchuuzi.R;

import java.util.List;

public class ImageAdapter extends PagerAdapter {
    private Context context;

    public ImageAdapter(Context context, List<Images> images) {
        this.context = context;
        this.images = images;
    }

    //the images to show in the view pager
    private List<Images> images;


    @Override
    public int getCount() {
        return this.images.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.image_carousel, container);
        Images image= images.get(position);
        CircularProgressDrawable circularProgressDrawable =new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(  5f);
        circularProgressDrawable.setCenterRadius(30f);
        circularProgressDrawable.start();
        ///RequestOptions options=new RequestOptions.diskCacheStrategyOf(Dis

       Glide.with(context)
                .load(image.getImage_url())
                .placeholder(circularProgressDrawable)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE).dontAnimate()
               .into((ImageView) view.findViewById(R.id.image));

        container.addView(view);


        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    ///addAll will update the images in our list
    public void addAll(List<Images> images) {
        this.images.addAll(images);
        notifyDataSetChanged();


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}