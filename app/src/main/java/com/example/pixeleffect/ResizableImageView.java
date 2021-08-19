package com.example.pixeleffect;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ResizableImageView extends androidx.appcompat.widget.AppCompatImageView {
    public ResizableImageView(Context context) {
        super(context);
    }

    public ResizableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable d = getDrawable();
        if (d != null) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int ceil = (int) Math.ceil((double) ((((float) width) * ((float) d.getIntrinsicHeight())) / ((float) d.getIntrinsicWidth())));
            setMeasuredDimension(width, width);
            return;
        }
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
