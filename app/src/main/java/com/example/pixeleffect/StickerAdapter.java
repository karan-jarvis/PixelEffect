package com.example.pixeleffect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class StickerAdapter extends BaseAdapter {
    Context context;
    ImageView img_editing;
    private LayoutInflater inflater;
    ArrayList<Integer> stickers;
    private ViewHolder viewholder;



    public class ViewHolder {
        ResizableImageView img_gallery;

        public ViewHolder() {
        }
    }

    public StickerAdapter(Context context2, ArrayList<Integer> stickers2) {
        context = context2;
        stickers = stickers2;
        inflater = LayoutInflater.from(context2);
    }

    public int getCount() {
        return stickers.size();
    }

    public Object getItem(int i) {
        return stickers.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sticker_item, null);
        }
        img_editing = convertView.findViewById(R.id.img_editing);

        Picasso.get().load(((Integer) stickers.get(position)).intValue()).into(img_editing);
        System.gc();
        return convertView;
    }
}
