package com.example.pixeleffect;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;



public class CardColorAdapter extends BaseAdapter {
    private Context context;
    private final int[] mobileValues;

    static class RecordHolder {
        ImageView imageItem;

        RecordHolder() {
        }
    }

    public CardColorAdapter(Context context2, int[] mobileValues2) {
        context = context2;
        mobileValues = mobileValues2;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        RecordHolder holder;
        View row = convertView;
        if (row == null) {
            row = ((Activity) context).getLayoutInflater().inflate(R.layout.listitem_color, parent, false);
            holder = new RecordHolder();
            holder.imageItem = (ImageView) row.findViewById(R.id.imgbutton);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }
        holder.imageItem.setTag(holder);
        holder.imageItem.setColorFilter(mobileValues[position]);
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
