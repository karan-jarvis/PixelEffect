package com.example.pixeleffect;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.zip.Inflater;


public class CardFontStyleAdapter extends BaseAdapter {
    private Context context;
    private final String[] mobileValues;
    Inflater inflater;

    static class RecordHolder {
        TextView txt_font;
        Typeface type;

        RecordHolder() {
        }
    }

    public CardFontStyleAdapter(Context context2, String[] mobileValues2) {
        context = context2;
        mobileValues = mobileValues2;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        RecordHolder holder;
        View row = convertView;
        if (row == null) {
            row = ((Activity) context).getLayoutInflater().inflate(R.layout.listitem_fontstyle, parent, false);
            holder = new RecordHolder();
            holder.txt_font = (TextView) row.findViewById(R.id.img_grid_item);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }
        holder.type = Typeface.createFromAsset(context.getAssets(), mobileValues[position]);
        holder.txt_font.setTypeface(holder.type);
        return row;
    }

    public int getCount() {
        return mobileValues.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }
}
