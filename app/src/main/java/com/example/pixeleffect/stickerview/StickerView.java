package com.example.pixeleffect.stickerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;

import androidx.core.view.MotionEventCompat;

import com.example.pixeleffect.R;



public class StickerView extends androidx.appcompat.widget.AppCompatImageView {
    private static final float BITMAP_SCALE = 0.7f;
    private static final String TAG = "StickerView";
    private float MAX_SCALE = 1.2f;
    private float MIN_SCALE = 0.5f;
    private Bitmap deleteBitmap;
    private int deleteBitmapHeight;
    private int deleteBitmapWidth;

    /* renamed from: dm */
    private DisplayMetrics f1780dm;
    private Rect dst_delete;
    private Rect dst_flipV;
    private Rect dst_resize;
    private Rect dst_top;
    private Bitmap flipVBitmap;
    private int flipVBitmapHeight;
    private int flipVBitmapWidth;
    private double halfDiagonalLength;
    private boolean isHorizonMirror = false;
    private boolean isInEdit = true;
    private boolean isInResize = false;
    private boolean isInSide;
    private boolean isPointerDown = false;
    private float lastLength;
    private float lastRotateDegree;
    private float lastX;
    private float lastY;
    private Paint localPaint;
    private Bitmap mBitmap;
    private int mScreenHeight;
    private int mScreenwidth;
    private Matrix matrix = new Matrix();
    private PointF mid = new PointF();
    private float oldDis;
    private OperationListener operationListener;
    private float oringinWidth = 0.0f;
    private final float pointerLimitDis = 20.0f;
    private final float pointerZoomCoeff = 0.09f;
    private Bitmap resizeBitmap;
    private int resizeBitmapHeight;
    private int resizeBitmapWidth;
    private final long stickerId = 0;
    private Bitmap topBitmap;
    private int topBitmapHeight;
    private int topBitmapWidth;

    public interface OperationListener {
        void onDeleteClick();

        void onEdit(StickerView stickerView);

        void onTop(StickerView stickerView);
    }

    public StickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StickerView(Context context) {
        super(context);
        init();
    }

    public StickerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        dst_delete = new Rect();
        dst_resize = new Rect();
        dst_flipV = new Rect();
        dst_top = new Rect();
        localPaint = new Paint();
        localPaint.setColor(getResources().getColor(R.color.colorPrimary));
        localPaint.setAntiAlias(true);
        localPaint.setDither(true);
        localPaint.setStyle(Style.STROKE);
        localPaint.setStrokeWidth(2.0f);
        f1780dm = getResources().getDisplayMetrics();
        mScreenwidth = f1780dm.widthPixels;
        mScreenHeight = f1780dm.heightPixels;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (mBitmap != null) {
            float[] arrayOfFloat = new float[9];
            matrix.getValues(arrayOfFloat);
            float f1 = (0.0f * arrayOfFloat[0]) + (0.0f * arrayOfFloat[1]) + arrayOfFloat[2];
            float f2 = (0.0f * arrayOfFloat[3]) + (0.0f * arrayOfFloat[4]) + arrayOfFloat[5];
            float f3 = (arrayOfFloat[0] * ((float) mBitmap.getWidth())) + (0.0f * arrayOfFloat[1]) + arrayOfFloat[2];
            float f4 = (arrayOfFloat[3] * ((float) mBitmap.getWidth())) + (0.0f * arrayOfFloat[4]) + arrayOfFloat[5];
            float f5 = (0.0f * arrayOfFloat[0]) + (arrayOfFloat[1] * ((float) mBitmap.getHeight())) + arrayOfFloat[2];
            float f6 = (0.0f * arrayOfFloat[3]) + (arrayOfFloat[4] * ((float) mBitmap.getHeight())) + arrayOfFloat[5];
            float f7 = (arrayOfFloat[0] * ((float) mBitmap.getWidth())) + (arrayOfFloat[1] * ((float) mBitmap.getHeight())) + arrayOfFloat[2];
            float f8 = (arrayOfFloat[3] * ((float) mBitmap.getWidth())) + (arrayOfFloat[4] * ((float) mBitmap.getHeight())) + arrayOfFloat[5];
            canvas.save();
            canvas.drawBitmap(mBitmap, matrix, null);
            dst_delete.left = (int) (f3 - ((float) (deleteBitmapWidth / 2)));
            dst_delete.right = (int) (((float) (deleteBitmapWidth / 2)) + f3);
            dst_delete.top = (int) (f4 - ((float) (deleteBitmapHeight / 2)));
            dst_delete.bottom = (int) (((float) (deleteBitmapHeight / 2)) + f4);
            dst_resize.left = (int) (f7 - ((float) (resizeBitmapWidth / 2)));
            dst_resize.right = (int) (((float) (resizeBitmapWidth / 2)) + f7);
            dst_resize.top = (int) (f8 - ((float) (resizeBitmapHeight / 2)));
            dst_resize.bottom = (int) (((float) (resizeBitmapHeight / 2)) + f8);
            dst_top.left = (int) (f1 - ((float) (flipVBitmapWidth / 2)));
            dst_top.right = (int) (((float) (flipVBitmapWidth / 2)) + f1);
            dst_top.top = (int) (f2 - ((float) (flipVBitmapHeight / 2)));
            dst_top.bottom = (int) (((float) (flipVBitmapHeight / 2)) + f2);
            dst_flipV.left = (int) (f5 - ((float) (topBitmapWidth / 2)));
            dst_flipV.right = (int) (((float) (topBitmapWidth / 2)) + f5);
            dst_flipV.top = (int) (f6 - ((float) (topBitmapHeight / 2)));
            dst_flipV.bottom = (int) (((float) (topBitmapHeight / 2)) + f6);
            if (isInEdit) {
                canvas.drawLine(f1, f2, f3, f4, localPaint);
                canvas.drawLine(f3, f4, f7, f8, localPaint);
                canvas.drawLine(f5, f6, f7, f8, localPaint);
                canvas.drawLine(f5, f6, f1, f2, localPaint);
                canvas.drawBitmap(deleteBitmap, null, dst_delete, null);
                canvas.drawBitmap(resizeBitmap, null, dst_resize, null);
                canvas.drawBitmap(flipVBitmap, null, dst_flipV, null);
                canvas.drawBitmap(topBitmap, null, dst_top, null);
            }
            canvas.restore();
        }
    }

    public void setImageResource(int resId) {
        setBitmap(BitmapFactory.decodeResource(getResources(), resId));
    }

    public void setBitmap(Bitmap bitmap) {
        matrix.reset();
        mBitmap = bitmap;
        setDiagonalLength();
        initBitmaps();
        int w = mBitmap.getWidth();
        int h = mBitmap.getHeight();
        oringinWidth = (float) w;
        float f = (MIN_SCALE + MAX_SCALE) / 2.0f;
        matrix.postTranslate((float) ((mScreenwidth / 2) - (w / 2)), (float) ((mScreenHeight / 2) - (h / 2)));
        invalidate();
    }

    private void setDiagonalLength() {
        halfDiagonalLength = Math.hypot((double) mBitmap.getWidth(), (double) mBitmap.getHeight()) / 2.0d;
    }

    private void initBitmaps() {
        if (mBitmap.getWidth() >= mBitmap.getHeight()) {
            float minWidth = (float) (mScreenwidth / 8);
            if (((float) mBitmap.getWidth()) < minWidth) {
                MIN_SCALE = 1.0f;
            } else {
                MIN_SCALE = (1.0f * minWidth) / ((float) mBitmap.getWidth());
            }
            if (mBitmap.getWidth() > mScreenwidth) {
                MAX_SCALE = 1.0f;
            } else {
                MAX_SCALE = (((float) mScreenwidth) * 1.0f) / ((float) mBitmap.getWidth());
            }
        } else {
            float minHeight = (float) (mScreenwidth / 8);
            if (((float) mBitmap.getHeight()) < minHeight) {
                MIN_SCALE = 1.0f;
            } else {
                MIN_SCALE = (1.0f * minHeight) / ((float) mBitmap.getHeight());
            }
            if (mBitmap.getHeight() > mScreenwidth) {
                MAX_SCALE = 1.0f;
            } else {
                MAX_SCALE = (((float) mScreenwidth) * 1.0f) / ((float) mBitmap.getHeight());
            }
        }
        topBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.icon_top_enable);
        deleteBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_delete);
        flipVBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.icon_flip);
        resizeBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.icon_resize);
        deleteBitmapWidth = (int) (((float) deleteBitmap.getWidth()) * BITMAP_SCALE);
        deleteBitmapHeight = (int) (((float) deleteBitmap.getHeight()) * BITMAP_SCALE);
        resizeBitmapWidth = (int) (((float) resizeBitmap.getWidth()) * BITMAP_SCALE);
        resizeBitmapHeight = (int) (((float) resizeBitmap.getHeight()) * BITMAP_SCALE);
        flipVBitmapWidth = (int) (((float) flipVBitmap.getWidth()) * BITMAP_SCALE);
        flipVBitmapHeight = (int) (((float) flipVBitmap.getHeight()) * BITMAP_SCALE);
        topBitmapWidth = (int) (((float) topBitmap.getWidth()) * BITMAP_SCALE);
        topBitmapHeight = (int) (((float) topBitmap.getHeight()) * BITMAP_SCALE);
    }

    public boolean onTouchEvent(MotionEvent event) {
        float scale;
        boolean handled = true;
        switch (MotionEventCompat.getActionMasked(event)) {
            case 0:
                if (!isInButton(event, dst_delete)) {
                    if (!isInResize(event)) {
                        if (!isInButton(event, dst_flipV)) {
                            if (!isInButton(event, dst_top)) {
                                if (!isInBitmap(event)) {
                                    handled = false;
                                    break;
                                } else {
                                    isInSide = true;
                                    lastX = event.getX(0);
                                    lastY = event.getY(0);
                                    break;
                                }
                            } else {
                                bringToFront();
                                if (operationListener != null) {
                                    operationListener.onTop(this);
                                    break;
                                }
                            }
                        } else {
                            PointF localPointF = new PointF();
                            midDiagonalPoint(localPointF);
                            matrix.postScale(-1.0f, 1.0f, localPointF.x, localPointF.y);
                            isHorizonMirror = !isHorizonMirror;
                            invalidate();
                            break;
                        }
                    } else {
                        isInResize = true;
                        lastRotateDegree = rotationToStartPoint(event);
                        midPointToStartPoint(event);
                        lastLength = diagonalLength(event);
                        break;
                    }
                } else if (operationListener != null) {
                    operationListener.onDeleteClick();
                    break;
                }
                break;
            case 1:
            case 3:
                isInResize = false;
                isInSide = false;
                isPointerDown = false;
                break;
            case 2:
                if (!isPointerDown) {
                    if (!isInResize) {
                        if (isInSide) {
                            float x = event.getX(0);
                            float y = event.getY(0);
                            matrix.postTranslate(x - lastX, y - lastY);
                            lastX = x;
                            lastY = y;
                            invalidate();
                            break;
                        }
                    } else {
                        matrix.postRotate((rotationToStartPoint(event) - lastRotateDegree) * 2.0f, mid.x, mid.y);
                        lastRotateDegree = rotationToStartPoint(event);
                        float scale2 = diagonalLength(event) / lastLength;
                        if ((((double) diagonalLength(event)) / halfDiagonalLength > ((double) MIN_SCALE) || scale2 >= 1.0f) && (((double) diagonalLength(event)) / halfDiagonalLength < ((double) MAX_SCALE) || scale2 <= 1.0f)) {
                            lastLength = diagonalLength(event);
                        } else {
                            scale2 = 1.0f;
                            if (!isInResize(event)) {
                                isInResize = false;
                            }
                        }
                        matrix.postScale(scale2, scale2, mid.x, mid.y);
                        invalidate();
                        break;
                    }
                } else {
                    float disNew = spacing(event);
                    if (disNew == 0.0f || disNew < 20.0f) {
                        scale = 1.0f;
                    } else {
                        scale = (((disNew / oldDis) - 1.0f) * 0.09f) + 1.0f;
                    }
                    float scaleTemp = (((float) Math.abs(dst_flipV.left - dst_resize.left)) * scale) / oringinWidth;
                    if ((scaleTemp > MIN_SCALE || scale >= 1.0f) && (scaleTemp < MAX_SCALE || scale <= 1.0f)) {
                        lastLength = diagonalLength(event);
                    } else {
                        scale = 1.0f;
                    }
                    matrix.postScale(scale, scale, mid.x, mid.y);
                    invalidate();
                    break;
                }
                break;
            case 5:
                if (spacing(event) > 20.0f) {
                    oldDis = spacing(event);
                    isPointerDown = true;
                    midPointToStartPoint(event);
                } else {
                    isPointerDown = false;
                }
                isInSide = false;
                isInResize = false;
                break;
        }
        if (handled && operationListener != null) {
            operationListener.onEdit(this);
        }
        return handled;
    }

    public StickerPropertyModel calculate(StickerPropertyModel model) {
        float[] v = new float[9];
        matrix.getValues(v);
        float tx = v[2];
        Log.d(TAG, "tx : " + tx + " ty : " + v[5]);
        float scalex = v[0];
        float skewy = v[3];
        float rScale = (float) Math.sqrt((double) ((scalex * scalex) + (skewy * skewy)));
        Log.d(TAG, "rScale : " + rScale);
        float rAngle = (float) Math.round(Math.atan2((double) v[1], (double) v[0]) * 57.29577951308232d);
        Log.d(TAG, "rAngle : " + rAngle);
        PointF localPointF = new PointF();
        midDiagonalPoint(localPointF);
        Log.d(TAG, " width  : " + (((float) mBitmap.getWidth()) * rScale) + " height " + (((float) mBitmap.getHeight()) * rScale));
        float minX = localPointF.x;
        float minY = localPointF.y;
        Log.d(TAG, "midX : " + minX + " midY : " + minY);
        model.setDegree((float) Math.toRadians((double) rAngle));
        model.setScaling((((float) mBitmap.getWidth()) * rScale) / ((float) mScreenwidth));
        model.setxLocation(minX / ((float) mScreenwidth));
        model.setyLocation(minY / ((float) mScreenwidth));
        model.setStickerId(stickerId);
        if (isHorizonMirror) {
            model.setHorizonMirror(1);
        } else {
            model.setHorizonMirror(2);
        }
        return model;
    }

    private boolean isInBitmap(MotionEvent event) {
        float[] arrayOfFloat1 = new float[9];
        matrix.getValues(arrayOfFloat1);
        float f7 = (arrayOfFloat1[0] * ((float) mBitmap.getWidth())) + (arrayOfFloat1[1] * ((float) mBitmap.getHeight())) + arrayOfFloat1[2];
        float f8 = (arrayOfFloat1[3] * ((float) mBitmap.getWidth())) + (arrayOfFloat1[4] * ((float) mBitmap.getHeight())) + arrayOfFloat1[5];
        return pointInRect(new float[]{(0.0f * arrayOfFloat1[0]) + (0.0f * arrayOfFloat1[1]) + arrayOfFloat1[2], (arrayOfFloat1[0] * ((float) mBitmap.getWidth())) + (0.0f * arrayOfFloat1[1]) + arrayOfFloat1[2], f7, (0.0f * arrayOfFloat1[0]) + (arrayOfFloat1[1] * ((float) mBitmap.getHeight())) + arrayOfFloat1[2]}, new float[]{(0.0f * arrayOfFloat1[3]) + (0.0f * arrayOfFloat1[4]) + arrayOfFloat1[5], (arrayOfFloat1[3] * ((float) mBitmap.getWidth())) + (0.0f * arrayOfFloat1[4]) + arrayOfFloat1[5], f8, (0.0f * arrayOfFloat1[3]) + (arrayOfFloat1[4] * ((float) mBitmap.getHeight())) + arrayOfFloat1[5]}, event.getX(0), event.getY(0));
    }

    private boolean pointInRect(float[] xRange, float[] yRange, float x, float y) {
        double a1 = Math.hypot((double) (xRange[0] - xRange[1]), (double) (yRange[0] - yRange[1]));
        double a2 = Math.hypot((double) (xRange[1] - xRange[2]), (double) (yRange[1] - yRange[2]));
        double a3 = Math.hypot((double) (xRange[3] - xRange[2]), (double) (yRange[3] - yRange[2]));
        double a4 = Math.hypot((double) (xRange[0] - xRange[3]), (double) (yRange[0] - yRange[3]));
        double b1 = Math.hypot((double) (x - xRange[0]), (double) (y - yRange[0]));
        double b2 = Math.hypot((double) (x - xRange[1]), (double) (y - yRange[1]));
        double b3 = Math.hypot((double) (x - xRange[2]), (double) (y - yRange[2]));
        double b4 = Math.hypot((double) (x - xRange[3]), (double) (y - yRange[3]));
        double u1 = ((a1 + b1) + b2) / 2.0d;
        double u2 = ((a2 + b2) + b3) / 2.0d;
        double u3 = ((a3 + b3) + b4) / 2.0d;
        double u4 = ((a4 + b4) + b1) / 2.0d;
        return Math.abs((a1 * a2) - (((Math.sqrt((((u1 - a1) * u1) * (u1 - b1)) * (u1 - b2)) + Math.sqrt((((u2 - a2) * u2) * (u2 - b2)) * (u2 - b3))) + Math.sqrt((((u3 - a3) * u3) * (u3 - b3)) * (u3 - b4))) + Math.sqrt((((u4 - a4) * u4) * (u4 - b4)) * (u4 - b1)))) < 0.5d;
    }

    private boolean isInButton(MotionEvent event, Rect rect) {
        int left = rect.left;
        int right = rect.right;
        int top = rect.top;
        int bottom = rect.bottom;
        if (event.getX(0) < ((float) left) || event.getX(0) > ((float) right) || event.getY(0) < ((float) top) || event.getY(0) > ((float) bottom)) {
            return false;
        }
        return true;
    }

    private boolean isInResize(MotionEvent event) {
        int top = dst_resize.top - 20;
        int right = dst_resize.right + 20;
        int bottom = dst_resize.bottom + 20;
        if (event.getX(0) < ((float) (dst_resize.left - 20)) || event.getX(0) > ((float) right) || event.getY(0) < ((float) top) || event.getY(0) > ((float) bottom)) {
            return false;
        }
        return true;
    }

    private void midPointToStartPoint(MotionEvent event) {
        float[] arrayOfFloat = new float[9];
        matrix.getValues(arrayOfFloat);
        mid.set(((((arrayOfFloat[0] * 0.0f) + (arrayOfFloat[1] * 0.0f)) + arrayOfFloat[2]) + event.getX(0)) / 2.0f, ((((arrayOfFloat[3] * 0.0f) + (arrayOfFloat[4] * 0.0f)) + arrayOfFloat[5]) + event.getY(0)) / 2.0f);
    }

    private void midDiagonalPoint(PointF paramPointF) {
        float[] arrayOfFloat = new float[9];
        matrix.getValues(arrayOfFloat);
        float f3 = (arrayOfFloat[0] * ((float) mBitmap.getWidth())) + (arrayOfFloat[1] * ((float) mBitmap.getHeight())) + arrayOfFloat[2];
        paramPointF.set(((((arrayOfFloat[0] * 0.0f) + (arrayOfFloat[1] * 0.0f)) + arrayOfFloat[2]) + f3) / 2.0f, ((((arrayOfFloat[3] * 0.0f) + (arrayOfFloat[4] * 0.0f)) + arrayOfFloat[5]) + (((arrayOfFloat[3] * ((float) mBitmap.getWidth())) + (arrayOfFloat[4] * ((float) mBitmap.getHeight()))) + arrayOfFloat[5])) / 2.0f);
    }

    private float rotationToStartPoint(MotionEvent event) {
        float[] arrayOfFloat = new float[9];
        matrix.getValues(arrayOfFloat);
        return (float) Math.toDegrees(Math.atan2((double) (event.getY(0) - (((arrayOfFloat[3] * 0.0f) + (arrayOfFloat[4] * 0.0f)) + arrayOfFloat[5])), (double) (event.getX(0) - (((arrayOfFloat[0] * 0.0f) + (arrayOfFloat[1] * 0.0f)) + arrayOfFloat[2]))));
    }

    private float diagonalLength(MotionEvent event) {
        return (float) Math.hypot((double) (event.getX(0) - mid.x), (double) (event.getY(0) - mid.y));
    }

    private float spacing(MotionEvent event) {
        if (event.getPointerCount() != 2) {
            return 0.0f;
        }
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    public void setOperationListener(OperationListener operationListener2) {
        operationListener = operationListener2;
    }

    public void setInEdit(boolean isInEdit2) {
        isInEdit = isInEdit2;
        invalidate();
    }
}
