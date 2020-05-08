package com.mchuuzi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

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
        return super.instantiateItem(container, position);
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