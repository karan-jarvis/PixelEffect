package com.example.pixeleffect;

import android.content.Context;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FrameAdapter extends BaseAdapter {
    ArrayList<Integer> collage;
    Context context;
    private int height;
    ImageView img_editing;
    ImageView img_main;
    LayoutInflater inflater;
    private int width;

    public FrameAdapter(Context context2, ArrayList<Integer> stickers) {
        context = context2;
        collage = stickers;
        inflater=LayoutInflater.from(context2);
    }

    public int getCount() {
        return collage.size();
    }

    public Object getItem(int i) {
        return collage.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.frame_item, null);
        }

        img_main = (ImageView) convertView.findViewById(R.id.iv_main);
        img_editing = (ImageView) convertView.findViewById(R.id.img_editing);
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;
        int resource = ((Integer) collage.get(position)).intValue();
        img_main.setImageBitmap(crope.bitmap);
        Glide.with(context).load(Integer.valueOf(resource)).override(width / 4, height / 7).into(img_editing);
        img_editing.setColorFilter(ContextCompat.getColor(context, R.color.white));
        System.gc();
        return convertView;
    }
}
