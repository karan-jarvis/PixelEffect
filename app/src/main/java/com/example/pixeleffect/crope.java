package com.example.pixeleffect;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.pixeleffect.stickerview.StickerView;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;

import static com.example.pixeleffect.R.color.white;

public class crope extends AppCompatActivity implements View.OnClickListener {

    LinearLayout  ll_detail;
    FrameLayout frm_Main, fl_Sticker;
    HorizontalScrollView hs_scrolleffect, hs_scrollPip2;
    ImageView imgAlign ,imgPattern ,imgTextSize ,imgcolor,imgstyle, lin_back,btnsave, btn_addtext_done, back, save, Img_light, ef_original, ef1, ef2, ef3, ef4, ef5, ef6, ef7, ef8, ef9, ef10, ef11, ef12, ef13, ef14, ef15, ef16, ef17, ef18, ef19, ef20, ef21, ef22;
    private BaseAdapter frameAdapter;
    Dialog mDialog;
    public int initColor;
    TwoWayView hl_Frm;
    int[] pattern = {R.drawable.ic_panel_none, R.mipmap.thumb_pattern_01, R.mipmap.thumb_pattern_02, R.mipmap.thumb_pattern_03, R.mipmap.thumb_pattern_04, R.mipmap.thumb_pattern_05, R.mipmap.thumb_pattern_06, R.mipmap.thumb_pattern_07, R.mipmap.thumb_pattern_08, R.mipmap.thumb_pattern_09, R.mipmap.thumb_pattern_10};
    String[] fonts = {"font1.ttf", "font2.ttf", "font3.ttf", "font4.TTF", "font5.ttf", "font6.TTF", "font7.ttf", "font8.ttf", "font9.ttf", "font10.TTF", "font11.ttf", "font12.ttf", "font14.TTF", "font16.TTF", "font17.ttf", "font18.ttf", "font19.ttf", "font20.ttf", "font21.ttf"};
    static int[] COLORS = {Color.parseColor("#b71c1c"), Color.parseColor("#c62828"), Color.parseColor("#d32f2f"), Color.parseColor("#e53935"), Color.parseColor("#f44336"), Color.parseColor("#ef5350"), Color.parseColor("#e57373"), Color.parseColor("#ef9a9a"), Color.parseColor("#ffcdd2"), Color.parseColor("#1b5e20"), Color.parseColor("#2e7d32"), Color.parseColor("#388e3c"), Color.parseColor("#43a047"), Color.parseColor("#4caf50"), Color.parseColor("#66bb6a"), Color.parseColor("#81c784"), Color.parseColor("#a5d6a7"), Color.parseColor("#c8e6c9"), Color.parseColor("#0d47a1"), Color.parseColor("#1565c0"), Color.parseColor("#1976d2"), Color.parseColor("#1e88e5"), Color.parseColor("#2196f3"), Color.parseColor("#42a5f5"), Color.parseColor("#64b5f6"), Color.parseColor("#90caf9"), Color.parseColor("#bbdefb"), Color.parseColor("#f57f17"), Color.parseColor("#f9a825"), Color.parseColor("#fbc02d"), Color.parseColor("#fdd835"), Color.parseColor("#ffeb3b"), Color.parseColor("#ffee58"), Color.parseColor("#fff176"), Color.parseColor("#fff59d"), Color.parseColor("#fff9c4"), Color.parseColor("#e65100"), Color.parseColor("#ef6c00"), Color.parseColor("#f57c00"), Color.parseColor("#fb8c00"), Color.parseColor("#ff9800"), Color.parseColor("#ffa726"), Color.parseColor("#ffb74d"), Color.parseColor("#ffcc80"), Color.parseColor("#ffe0b2"), Color.parseColor("#880e4f"), Color.parseColor("#ad1457"), Color.parseColor("#c2185b"), Color.parseColor("#d81b60"), Color.parseColor("#e91e63"), Color.parseColor("#ec407a"), Color.parseColor("#f06292"), Color.parseColor("#f48fb1"), Color.parseColor("#f8bbd0"), Color.parseColor("#4a148c"), Color.parseColor("#6a1b9a"), Color.parseColor("#7b1fa2"), Color.parseColor("#8e24aa"), Color.parseColor("#9c27b0"), Color.parseColor("#ab47bc"), Color.parseColor("#ba68c8"), Color.parseColor("#ce93d8"), Color.parseColor("#e1bee7"), Color.parseColor("#3e2723"), Color.parseColor("#4e342e"), Color.parseColor("#5d4037"), Color.parseColor("#6d4c41"), Color.parseColor("#795548"), Color.parseColor("#8d6e63"), Color.parseColor("#a1887f"), Color.parseColor("#bcaaa4"), Color.parseColor("#d7ccc8"), Color.parseColor("#212121"), Color.parseColor("#424242"), Color.parseColor("#616161"), Color.parseColor("#757575"), Color.parseColor("#9e9e9e"), Color.parseColor("#bdbdbd"), Color.parseColor("#e0e0e0"), Color.parseColor("#eeeeee"), Color.parseColor("#f5f5f5"), Color.parseColor("#006064"), Color.parseColor("#00838f"), Color.parseColor("#0097a7"), Color.parseColor("#00acc1"), Color.parseColor("#00bcd4"), Color.parseColor("#26c6da"), Color.parseColor("#4dd0e1"), Color.parseColor("#80deea"), Color.parseColor("#b2ebf2")};
    private LinearLayout llFlip ,llRotate,ll_effect_list,llOverView, llText ,llColor ,ll3D,llLight ,llSticker ,llFilter;
    private ImageView orgImage, ImgFrm;
    public boolean isLight = false;
    public ArrayList<Integer> frmList;
    final Context context = this;
    public StickerView mCurrentView;
    public static Bitmap bitmap;
    RelativeLayout relAddText,relAllDrawText,relFontStyle ,relPattern,relTextColor,relTextSize ,relconAlign;
    TextView btn_alignment_done, btn_color_done ,btn_fontstyle_done,btn_pattern_done ,btn_text_done, nav_text1;
    LinearLayout lin_add_text ,lin_alignment ,lin_color,lin_pattern ,lin_style ,lin_text, lin_textSize;
    TextView txt_main;
    ImageView imgtext;
    RadioGroup mRadioGroup;
    GridView grid_color, grid_fontstyle, grid_pattern;
    public ArrayList<View> mViews;
    private SeekBar seekTextSize = null;
    EditText editAddText;
    private int rotate = 1;
    String text = "";
    private boolean flagForFlip = true;
    int textColor = ViewCompat.MEASURED_STATE_MASK;
    float radious = 0.0f;
    float f1727dx = 0.0f;
    float f1728dy = 0.0f;
    Typeface type;
    int textSize = 0;
    private static Bitmap f1725b;
    public int stickerId;
    private static Canvas f1726c;
    public ArrayList<Integer> stickerlist;
    public StickerAdapter stickerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crope);

        initColor = getResources().getColor(R.color.white);
        mViews = new ArrayList<>();
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(this);
        save = (ImageView) findViewById(R.id.save);
        save.setOnClickListener(this);
        ll_detail = (LinearLayout) findViewById(R.id.ll_detail);
        ll_detail.setVisibility(View.GONE);
        ll_effect_list = (LinearLayout) findViewById(R.id.ll_effect_list);
        ll_effect_list.setVisibility(View.GONE);
        llOverView = (LinearLayout) findViewById(R.id.ll_overview);
        llOverView.setOnClickListener(this);
        llText = (LinearLayout) findViewById(R.id.ll_text);
        llText.setOnClickListener(this);
        llColor = (LinearLayout) findViewById(R.id.ll_color);
        llColor.setOnClickListener(this);
        ll3D = (LinearLayout) findViewById(R.id.ll_three_d);
        ll3D.setOnClickListener(this);
        llLight = (LinearLayout) findViewById(R.id.ll_light);
        llLight.setOnClickListener(this);
        frm_Main = (FrameLayout) findViewById(R.id.frm_Main);
        llFilter = (LinearLayout) findViewById(R.id.ll_filter);
        llFilter.setOnClickListener(this);
        llSticker = (LinearLayout) findViewById(R.id.ll_sticker);
        llSticker.setOnClickListener(this);
        llRotate = (LinearLayout) findViewById(R.id.ll_Rotate);
        llRotate.setOnClickListener(this);
        llFlip = (LinearLayout) findViewById(R.id.ll_Flip);
        llFlip.setOnClickListener(this);
        orgImage = (ImageView) findViewById(R.id.org_Img);
        orgImage.setImageBitmap(crope.bitmap);
        hl_Frm = (TwoWayView) findViewById(R.id.hl_Frm);

        fl_Sticker = (FrameLayout) findViewById(R.id.fl_Sticker);
        ImgFrm = (ImageView) findViewById(R.id.Img_Frm);
        Img_light = (ImageView) findViewById(R.id.Img_light);
        ImgFrm.setImageResource(R.drawable.pixel_01);
        hl_Frm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                if (crope.this.isLight) {
                    crope.this.Img_light.setImageResource((crope.this.frmList.get(position)).intValue());
                    return;
                }
                crope.this.ImgFrm.setImageResource((crope.this.frmList.get(position)).intValue());
                crope.this.ImgFrm.setColorFilter(ContextCompat.getColor(crope.this.context, white));
            }
        });


        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAspectRatio(1, 1)
                .start(crope.this);

        setFrmList();
        bindEffectIcon();
        createDir();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                orgImage.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }


    }



    public void onClick(View v) {
        isLight = false;
        switch (v.getId()) {
            case R.id.back:
                finish();
                return;
            case R.id.save:

                return;
            case R.id.frm_Main:
                if (mCurrentView != null) {
                    mCurrentView.setInEdit(false);
                    return;
                }
                return;
            case R.id.ef_original:
                Effects.applyEffectNone(orgImage);
                return;
            case R.id.ef1:
                Effects.applyEffect1(orgImage);
                return;
            case R.id.ef2:
                Effects.applyEffect2(orgImage);
                return;
            case R.id.ef3:
                Effects.applyEffect3(orgImage);
                return;
            case R.id.ef4:
                Effects.applyEffect4(orgImage);
                return;
            case R.id.ef5:
                Effects.applyEffect5(orgImage);
                return;
            case R.id.ef6:
                Effects.applyEffect6(orgImage);
                return;
            case R.id.ef7:
                Effects.applyEffect7(orgImage);
                return;
            case R.id.ef8:
                Effects.applyEffect8(orgImage);
                return;
            case R.id.ef9:
                Effects.applyEffect9(orgImage);
                return;
            case R.id.ef10:
                Effects.applyEffect10(orgImage);
                return;
            case R.id.ef11:
                Effects.applyEffect11(orgImage);
                return;
            case R.id.ef12:
                Effects.applyEffect12(orgImage);
                return;
            case R.id.ef13:
                Effects.applyEffect13(orgImage);
                return;
            case R.id.ef14:
                Effects.applyEffect14(orgImage);
                return;
            case R.id.ef15:
                Effects.applyEffect15(orgImage);
                return;
            case R.id.ef16:
                Effects.applyEffect16(orgImage);
                return;
            case R.id.ef17:
                Effects.applyEffect17(orgImage);
                return;
            case R.id.ef18:
                Effects.applyEffect18(orgImage);
                return;
            case R.id.ef19:
                Effects.applyEffect19(orgImage);
                return;
            case R.id.ef20:
                Effects.applyEffect20(orgImage);
                return;
            case R.id.ef21:
                Effects.applyEffect21(orgImage);
                return;
            case R.id.ef22:
                Effects.applyEffect22(orgImage);
                return;
            case R.id.ll_three_d:
                overView3dList();
                return;
            case R.id.ll_overview:
                overViewList();
                return;
            case R.id.ll_color:
                ColorPickerDialogBuilder.with(this).setTitle("Choose Background color").initialColor(this.initColor).wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE).density(12).setOnColorSelectedListener(new OnColorSelectedListener() {
                    public void onColorSelected(int selectedColor) {
                    }
                }).setPositiveButton((CharSequence) "ok", (ColorPickerClickListener) new ColorPickerClickListener() {
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                        crope.this.initColor = selectedColor;
                        crope.this.ImgFrm.setColorFilter(selectedColor);
                    }
                }).setNegativeButton((CharSequence) "cancel", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).build().show();

                return;
            case R.id.ll_light:
                isLight = true;
                overViewLightList();
                return;
            case R.id.ll_filter:
                FilterList();
                return;
            case R.id.ll_text:
                AddText2();
                return;
            case R.id.ll_sticker:
                showStickerDialog();
                return;
            case R.id.ll_Rotate:
                if (rotate == 1) {
                    orgImage.setRotation(90.0f);
                    rotate = 2;
                    return;
                } else if (this.rotate == 2) {
                    orgImage.setRotation(180.0f);
                    rotate = 3;
                    return;
                } else if (rotate == 3) {
                    orgImage.setRotation(270.0f);
                    rotate = 4;
                    return;
                } else if (rotate == 4) {
                    orgImage.setRotation(360.0f);
                    rotate = 1;
                    return;
                } else {
                    return;
                }
            case R.id.ll_Flip:
                if (flagForFlip) {
                    orgImage.setRotationY(180.0f);
                    flagForFlip = false;
                    return;
                }
                orgImage.setRotationY(360.0f);
                flagForFlip = true;
                return;
            default:
                return;
        }
    }

    public static void closeInput(final View caller) {
        caller.postDelayed(new Runnable() {
            public void run() {

            }
        }, 100);
    }

    public void addTextView(String srt, float radious2, float dx, float dy) {
        this.txt_main.setText(srt);
        this.txt_main.setShadowLayer(radious2, dx, dy, this.textColor);
    }

    public void applyBlurMaskFilter(TextView txt_main2, BlurMaskFilter.Blur style) {
        BlurMaskFilter filter = new BlurMaskFilter(txt_main2.getTextSize() / 10.0f, style);
        txt_main2.setLayerType(1, null);
        txt_main2.getPaint().setMaskFilter(filter);
    }


    public void addTextStickerView(Bitmap bitmap) {
        final StickerView stickerView = new StickerView(this);
        stickerView.setBitmap(bitmap);
        stickerView.setOperationListener(new StickerView.OperationListener() {
            public void onDeleteClick() {
                crope.this.mViews.remove(stickerView);
                crope.this.fl_Sticker.removeView(stickerView);
            }

            public void onEdit(StickerView stickerView) {
                crope.this.mCurrentView.setInEdit(false);
                crope.this.mCurrentView = stickerView;
                crope.this.mCurrentView.setInEdit(true);
            }

            public void onTop(StickerView stickerView) {
                int position = crope.this.mViews.indexOf(stickerView);
                if (position != crope.this.mViews.size() - 1) {
                    crope.this.mViews.add(crope.this.mViews.size(), (StickerView) crope.this.mViews.remove(position));
                }
            }
        });
        fl_Sticker.addView(stickerView, new RelativeLayout.LayoutParams(-1, -1));
        mViews.add(stickerView);
        setContentView(stickerView);
    }

    public static Bitmap loadBitmapFromView(View v) {
        if (v.getMeasuredHeight() <= 0) {
            v.measure(-2, -2);
            f1725b = Bitmap.createBitmap(v.getMeasuredWidth(), v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            f1726c = new Canvas(f1725b);
            v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
            v.draw(f1726c);
            return f1725b;
        }
        f1725b = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        f1726c = new Canvas(f1725b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(f1726c);
        return f1725b;
    }

    public Bitmap CropBitmapTransparency(Bitmap sourceBitmap) {
        int minX = sourceBitmap.getWidth();
        int minY = sourceBitmap.getHeight();
        int maxX = -1;
        int maxY = -1;
        for (int y = 0; y < sourceBitmap.getHeight(); y++) {
            for (int x = 0; x < sourceBitmap.getWidth(); x++) {
                if (((sourceBitmap.getPixel(x, y) >> 24) & 255) > 0) {
                    if (x < minX) {
                        minX = x;
                    }
                    if (x > maxX) {
                        maxX = x;
                    }
                    if (y < minY) {
                        minY = y;
                    }
                    if (y > maxY) {
                        maxY = y;
                    }
                }
            }
        }
        if (maxX < minX || maxY < minY) {
            return null;
        }
        return Bitmap.createBitmap(sourceBitmap, minX, minY, (maxX - minX) + 1, (maxY - minY) + 1);
    }


    public void addStickerView(int id) {
        final StickerView stickerView = new StickerView(this);
        stickerView.setImageResource(id);
        stickerView.setOperationListener(new StickerView.OperationListener() {
            public void onDeleteClick() {
                crope.this.mViews.remove(stickerView);
                crope.this.fl_Sticker.removeView(stickerView);
            }

            public void onEdit(StickerView stickerView) {
                crope.this.mCurrentView.setInEdit(false);
                crope.this.mCurrentView = stickerView;
                crope.this.mCurrentView.setInEdit(true);
            }

            public void onTop(StickerView stickerView) {
                int position = crope.this.mViews.indexOf(stickerView);
                if (position != crope.this.mViews.size() - 1) {
                    crope.this.mViews.add(crope.this.mViews.size(), (StickerView) crope.this.mViews.remove(position));
                }
            }
        });
        this.fl_Sticker.addView(stickerView, new RelativeLayout.LayoutParams(-1, -1));
        this.mViews.add(stickerView);
        setContentView(stickerView);
    }

    public void showStickerDialog() {
        final Dialog dial = new Dialog(context);
        dial.requestWindowFeature(1);
        dial.setContentView(R.layout.sticker_dialog);
        dial.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dial.setCanceledOnTouchOutside(true);
        ((ImageView) dial.findViewById(R.id.back_dialog)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dial.dismiss();
            }
        });
        ImageView c1 =  dial.findViewById(R.id.c1);
        ImageView c2 =  dial.findViewById(R.id.c2);
        ImageView c3 =  dial.findViewById(R.id.c3);
        ImageView c4 =  dial.findViewById(R.id.c4);
        ImageView c5 =  dial.findViewById(R.id.c5);
        ImageView c6 = dial.findViewById(R.id.c6);
        stickerlist = new ArrayList<>();
        final GridView grid_sticker = (GridView) dial.findViewById(R.id.gridStickerList);
        setStickerList1();
        stickerAdapter = new StickerAdapter(getApplicationContext(),stickerlist);
        grid_sticker.setAdapter(stickerAdapter);
        c1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                crope.this.stickerlist.clear();
                crope.this.setStickerList1();
                crope.this.stickerAdapter = new StickerAdapter(crope.this.getApplicationContext(), crope.this.stickerlist);
                grid_sticker.setAdapter(crope.this.stickerAdapter);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                crope.this.stickerlist.clear();
                crope.this.setStickerList2();
                crope.this.stickerAdapter = new StickerAdapter(crope.this.getApplicationContext(), crope.this.stickerlist);
                grid_sticker.setAdapter(crope.this.stickerAdapter);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                crope.this.stickerlist.clear();
                crope.this.setStickerList3();
                crope.this.stickerAdapter = new StickerAdapter(crope.this.getApplicationContext(), crope.this.stickerlist);
                grid_sticker.setAdapter(crope.this.stickerAdapter);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                crope.this.stickerlist.clear();
                crope.this.setStickerList4();
                crope.this.stickerAdapter = new StickerAdapter(crope.this.getApplicationContext(), crope.this.stickerlist);
                grid_sticker.setAdapter(crope.this.stickerAdapter);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                crope.this.stickerlist.clear();
                crope.this.setStickerList5();
                crope.this.stickerAdapter = new StickerAdapter(crope.this.getApplicationContext(), crope.this.stickerlist);
                grid_sticker.setAdapter(crope.this.stickerAdapter);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                crope.this.stickerlist.clear();
                crope.this.setStickerList6();
                crope.this.stickerAdapter = new StickerAdapter(crope.this.getApplicationContext(), crope.this.stickerlist);
                grid_sticker.setAdapter(crope.this.stickerAdapter);
            }
        });
        grid_sticker.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                crope.this.stickerId = (crope.this.stickerlist.get(i)).intValue();
                crope.this.addStickerView(crope.this.stickerId);
                dial.dismiss();
            }
        });
        dial.show();
    }
    private void createDir() {
        Glob.createDirIfNotExists(Glob.Edit_Folder_name);
    }
    public void openDetail() {
        ll_detail.setVisibility(View.VISIBLE);
        TranslateAnimation anim = new TranslateAnimation(0.0f, 0.0f, llOverView.getY() + 70.0f,llOverView.getY());
        anim.setDuration(300);
        anim.setFillAfter(true);
        ll_detail.startAnimation(anim);
    }


    public void FilterList() {
        hl_Frm.setVisibility(View.GONE);
        ll_effect_list.setVisibility(View.VISIBLE);
        openDetail();
    }

    public void overViewList() {
        setArraylistForFrm();
        frameAdapter = new FrameAdapter(this,frmList);
        hl_Frm.setAdapter(frameAdapter);
        hl_Frm.setVisibility(View.VISIBLE);
        ll_effect_list.setVisibility(View.GONE);
        openDetail();
    }

    public void overView3dList() {
        frmList = new ArrayList<>();
        frmList.add(Integer.valueOf(R.drawable.bg_3d_1_black));
        frmList.add(Integer.valueOf(R.drawable.bg_3d_3_black));
        frmList.add(Integer.valueOf(R.drawable.bg_3d_4_black));
        frmList.add(Integer.valueOf(R.drawable.bg_3d_5_black));
        frmList.add(Integer.valueOf(R.drawable.bg_3d_6_black));
        frmList.add(Integer.valueOf(R.drawable.pixel_mask_1));
        frmList.add(Integer.valueOf(R.drawable.pixel_mask_2));
        frmList.add(Integer.valueOf(R.drawable.splash_06));
        frmList.add(Integer.valueOf(R.drawable.splash_01));
        frmList.add(Integer.valueOf(R.drawable.splash_02));
        frmList.add(Integer.valueOf(R.drawable.splash_03));
        frmList.add(Integer.valueOf(R.drawable.splash_04));
        frmList.add(Integer.valueOf(R.drawable.splash_05));
        frameAdapter = new FrameAdapter(this,frmList);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        hl_Frm.setAdapter(frameAdapter);
        hl_Frm.setVisibility(View.VISIBLE);
        ll_effect_list.setVisibility(View.GONE);
        openDetail();
    }

    public void overViewLightList() {
        setArraylistForLight();
        frameAdapter = new GlareAdapter(this,frmList);
        hl_Frm.setAdapter(frameAdapter);
        hl_Frm.setVisibility(View.VISIBLE);
        ll_effect_list.setVisibility(View.GONE);
        openDetail();
    }

    private void setFrmList() {
        setArraylistForFrm();
        frameAdapter = new FrameAdapter(this,frmList);
        hl_Frm.setAdapter(frameAdapter);
    }
    private void setArraylistForFrm() {
        frmList = new ArrayList<>();
        frmList.add(Integer.valueOf(R.drawable.pixel_2));
        frmList.add(Integer.valueOf(R.drawable.pixel_3));
        frmList.add(Integer.valueOf(R.drawable.pixel_01));
        frmList.add(Integer.valueOf(R.drawable.pixel_02));
        frmList.add(Integer.valueOf(R.drawable.pixel_03));
        frmList.add(Integer.valueOf(R.drawable.pixel_4));
        frmList.add(Integer.valueOf(R.drawable.pixel_6));
        frmList.add(Integer.valueOf(R.drawable.pixel_7));
        frmList.add(Integer.valueOf(R.drawable.pixel_8));
        frmList.add(Integer.valueOf(R.drawable.pixel_04));
        frmList.add(Integer.valueOf(R.drawable.pixel_05));
        frmList.add(Integer.valueOf(R.drawable.pixel_06));
        frmList.add(Integer.valueOf(R.drawable.pixel_9));
        frmList.add(Integer.valueOf(R.drawable.pixel_13));
        frmList.add(Integer.valueOf(R.drawable.pixel_14));
        frmList.add(Integer.valueOf(R.drawable.pixel_15));
        frmList.add(Integer.valueOf(R.drawable.pixel_16));
        frmList.add(Integer.valueOf(R.drawable.pixel_17));
        frmList.add(Integer.valueOf(R.drawable.pixel_18));
        frmList.add(Integer.valueOf(R.drawable.pixel_19));
        frmList.add(Integer.valueOf(R.drawable.pixel_20));
        frmList.add(Integer.valueOf(R.drawable.pixel_21));
        frmList.add(Integer.valueOf(R.drawable.pixel_22));
        frmList.add(Integer.valueOf(R.drawable.pixel_23));
        frmList.add(Integer.valueOf(R.drawable.pixel_24));
        frmList.add(Integer.valueOf(R.drawable.pixel_25));
        frmList.add(Integer.valueOf(R.drawable.pixel_26));
        frmList.add(Integer.valueOf(R.drawable.pixel_27));
        frmList.add(Integer.valueOf(R.drawable.pixel_28));
        frmList.add(Integer.valueOf(R.drawable.pixel_31));
        frmList.add(Integer.valueOf(R.drawable.pixel_32));
        frmList.add(Integer.valueOf(R.drawable.pixel_33));
        frmList.add(Integer.valueOf(R.drawable.pixel_34));
    }


    private void bindEffectIcon() {
        ef_original = (ImageView) findViewById(R.id.ef_original);
        ef_original.setOnClickListener(this);
        ef1 = (ImageView) findViewById(R.id.ef1);
        ef1.setOnClickListener(this);
        ef2 = (ImageView) findViewById(R.id.ef2);
        ef2.setOnClickListener(this);
        ef3 = (ImageView) findViewById(R.id.ef3);
        ef3.setOnClickListener(this);
        ef4 = (ImageView) findViewById(R.id.ef4);
        ef4.setOnClickListener(this);
        ef5 = (ImageView) findViewById(R.id.ef5);
        ef5.setOnClickListener(this);
        ef6 = (ImageView) findViewById(R.id.ef6);
        ef6.setOnClickListener(this);
        ef7 = (ImageView) findViewById(R.id.ef7);
        ef7.setOnClickListener(this);
        ef8 = (ImageView) findViewById(R.id.ef8);
        ef8.setOnClickListener(this);
        ef9 = (ImageView) findViewById(R.id.ef9);
        ef9.setOnClickListener(this);
        ef10 = (ImageView) findViewById(R.id.ef10);
        ef10.setOnClickListener(this);
        ef11 = (ImageView) findViewById(R.id.ef11);
        ef11.setOnClickListener(this);
        ef12 = (ImageView) findViewById(R.id.ef12);
        ef12.setOnClickListener(this);
        ef13 = (ImageView) findViewById(R.id.ef13);
        ef13.setOnClickListener(this);
        ef14 = (ImageView) findViewById(R.id.ef14);
        ef14.setOnClickListener(this);
        ef15 = (ImageView) findViewById(R.id.ef15);
        ef15.setOnClickListener(this);
        ef16 = (ImageView) findViewById(R.id.ef16);
        ef16.setOnClickListener(this);
        ef17 = (ImageView) findViewById(R.id.ef17);
        ef17.setOnClickListener(this);
        ef18 = (ImageView) findViewById(R.id.ef18);
        ef18.setOnClickListener(this);
        ef19 = (ImageView) findViewById(R.id.ef19);
        ef19.setOnClickListener(this);
        ef20 = (ImageView) findViewById(R.id.ef20);
        ef20.setOnClickListener(this);
        ef21 = (ImageView) findViewById(R.id.ef21);
        ef21.setOnClickListener(this);
        ef22 = (ImageView) findViewById(R.id.ef22);
        ef22.setOnClickListener(this);
        Effects.applyEffectNone(ef_original);
        Effects.applyEffect1(ef1);
        Effects.applyEffect2(ef2);
        Effects.applyEffect3(ef3);
        Effects.applyEffect4(ef4);
        Effects.applyEffect5(ef5);
        Effects.applyEffect6(ef6);
        Effects.applyEffect7(ef7);
        Effects.applyEffect8(ef8);
        Effects.applyEffect9(ef9);
        Effects.applyEffect10(ef10);
        Effects.applyEffect11(ef11);
        Effects.applyEffect12(ef12);
        Effects.applyEffect13(ef13);
        Effects.applyEffect14(ef14);
        Effects.applyEffect15(ef15);
        Effects.applyEffect16(ef16);
        Effects.applyEffect17(ef17);
        Effects.applyEffect18(ef18);
        Effects.applyEffect19(ef19);
        Effects.applyEffect20(ef20);
        Effects.applyEffect21(ef21);
        Effects.applyEffect22(ef22);
    }
    private void setArraylistForLight() {
        frmList = new ArrayList<>();
        frmList.add(Integer.valueOf(R.drawable.flare_06));
        frmList.add(Integer.valueOf(R.drawable.flare_02));
        frmList.add(Integer.valueOf(R.drawable.flare_03));
        frmList.add(Integer.valueOf(R.drawable.flare_04));
        frmList.add(Integer.valueOf(R.drawable.flare_05));
        frmList.add(Integer.valueOf(R.drawable.flare_01));
    }
    public void setStickerList1() {
        stickerlist.add(Integer.valueOf(R.drawable.a4));
        stickerlist.add(Integer.valueOf(R.drawable.a2));
        stickerlist.add(Integer.valueOf(R.drawable.a3));
        stickerlist.add(Integer.valueOf(R.drawable.a6));
        stickerlist.add(Integer.valueOf(R.drawable.a9));
        stickerlist.add(Integer.valueOf(R.drawable.a7));
        stickerlist.add(Integer.valueOf(R.drawable.a1));
        stickerlist.add(Integer.valueOf(R.drawable.a10));
        stickerlist.add(Integer.valueOf(R.drawable.a16));
        stickerlist.add(Integer.valueOf(R.drawable.a8));
        stickerlist.add(Integer.valueOf(R.drawable.a14));
        stickerlist.add(Integer.valueOf(R.drawable.a15));
        stickerlist.add(Integer.valueOf(R.drawable.a12));
        stickerlist.add(Integer.valueOf(R.drawable.a21));
        stickerlist.add(Integer.valueOf(R.drawable.a18));
        stickerlist.add(Integer.valueOf(R.drawable.a19));
        stickerlist.add(Integer.valueOf(R.drawable.a20));
        stickerlist.add(Integer.valueOf(R.drawable.a26));
        stickerlist.add(Integer.valueOf(R.drawable.a22));
        stickerlist.add(Integer.valueOf(R.drawable.a24));
        stickerlist.add(Integer.valueOf(R.drawable.a17));
        stickerlist.add(Integer.valueOf(R.drawable.a28));
        stickerlist.add(Integer.valueOf(R.drawable.a25));
        stickerlist.add(Integer.valueOf(R.drawable.a29));
        stickerlist.add(Integer.valueOf(R.drawable.a30));
        stickerlist.add(Integer.valueOf(R.drawable.a32));
        stickerlist.add(Integer.valueOf(R.drawable.a34));
        stickerlist.add(Integer.valueOf(R.drawable.a35));
        stickerlist.add(Integer.valueOf(R.drawable.a36));
    }


    public void setStickerList2() {
        stickerlist.add(Integer.valueOf(R.drawable.monster_02));
        stickerlist.add(Integer.valueOf(R.drawable.monster_07));
        stickerlist.add(Integer.valueOf(R.drawable.monster_01));
        stickerlist.add(Integer.valueOf(R.drawable.monster_04));
        stickerlist.add(Integer.valueOf(R.drawable.monster_05));
        stickerlist.add(Integer.valueOf(R.drawable.monster_03));
        stickerlist.add(Integer.valueOf(R.drawable.monster_11));
        stickerlist.add(Integer.valueOf(R.drawable.monster_08));
        stickerlist.add(Integer.valueOf(R.drawable.monster_06));
        stickerlist.add(Integer.valueOf(R.drawable.monster_10));
        stickerlist.add(Integer.valueOf(R.drawable.monster_14));
        stickerlist.add(Integer.valueOf(R.drawable.monster_12));
        stickerlist.add(Integer.valueOf(R.drawable.monster_13));
        stickerlist.add(Integer.valueOf(R.drawable.monster_18));
        stickerlist.add(Integer.valueOf(R.drawable.monster_15));
        stickerlist.add(Integer.valueOf(R.drawable.monster_09));
        stickerlist.add(Integer.valueOf(R.drawable.monster_17));
        stickerlist.add(Integer.valueOf(R.drawable.monster_16));
        stickerlist.add(Integer.valueOf(R.drawable.monster_19));
        stickerlist.add(Integer.valueOf(R.drawable.monster_25));
        stickerlist.add(Integer.valueOf(R.drawable.monster_20));
        stickerlist.add(Integer.valueOf(R.drawable.monster_22));
        stickerlist.add(Integer.valueOf(R.drawable.monster_23));
        stickerlist.add(Integer.valueOf(R.drawable.monster_24));
        stickerlist.add(Integer.valueOf(R.drawable.monster_21));
    }


    public void setStickerList3() {
        stickerlist.add(Integer.valueOf(R.drawable.l8));
        stickerlist.add(Integer.valueOf(R.drawable.l9));
        stickerlist.add(Integer.valueOf(R.drawable.l7));
        stickerlist.add(Integer.valueOf(R.drawable.l15));
        stickerlist.add(Integer.valueOf(R.drawable.l10));
        stickerlist.add(Integer.valueOf(R.drawable.l12));
        stickerlist.add(Integer.valueOf(R.drawable.l13));
        stickerlist.add(Integer.valueOf(R.drawable.l11));
        stickerlist.add(Integer.valueOf(R.drawable.l17));
        stickerlist.add(Integer.valueOf(R.drawable.l16));
        stickerlist.add(Integer.valueOf(R.drawable.l14));
        stickerlist.add(Integer.valueOf(R.drawable.l21));
        stickerlist.add(Integer.valueOf(R.drawable.l19));
        stickerlist.add(Integer.valueOf(R.drawable.l18));
        stickerlist.add(Integer.valueOf(R.drawable.l20));
        stickerlist.add(Integer.valueOf(R.drawable.l22));
        stickerlist.add(Integer.valueOf(R.drawable.l26));
        stickerlist.add(Integer.valueOf(R.drawable.l23));
        stickerlist.add(Integer.valueOf(R.drawable.l24));
        stickerlist.add(Integer.valueOf(R.drawable.l28));
        stickerlist.add(Integer.valueOf(R.drawable.l25));
        stickerlist.add(Integer.valueOf(R.drawable.l27));
        stickerlist.add(Integer.valueOf(R.drawable.l35));
        stickerlist.add(Integer.valueOf(R.drawable.l40));
        stickerlist.add(Integer.valueOf(R.drawable.l37));
        stickerlist.add(Integer.valueOf(R.drawable.l36));
        stickerlist.add(Integer.valueOf(R.drawable.l38));
        stickerlist.add(Integer.valueOf(R.drawable.l39));
        stickerlist.add(Integer.valueOf(R.drawable.l42));
        stickerlist.add(Integer.valueOf(R.drawable.cm_sticker_11));
        stickerlist.add(Integer.valueOf(R.drawable.cm_sticker_15));
        stickerlist.add(Integer.valueOf(R.drawable.cm_sticker_12));
        stickerlist.add(Integer.valueOf(R.drawable.cm_sticker_13));
        stickerlist.add(Integer.valueOf(R.drawable.cm_sticker_10));
        stickerlist.add(Integer.valueOf(R.drawable.cm_sticker_14));
        stickerlist.add(Integer.valueOf(R.drawable.cm_sticker_16));
        stickerlist.add(Integer.valueOf(R.drawable.cm_sticker_17));
        stickerlist.add(Integer.valueOf(R.drawable.cm_sticker_21));
        stickerlist.add(Integer.valueOf(R.drawable.cm_sticker_19));
        stickerlist.add(Integer.valueOf(R.drawable.cm_sticker_20));
        stickerlist.add(Integer.valueOf(R.drawable.cm_sticker_18));
    }


    public void setStickerList4() {
        stickerlist.add(Integer.valueOf(R.drawable.wedding06));
        stickerlist.add(Integer.valueOf(R.drawable.wedding02));
        stickerlist.add(Integer.valueOf(R.drawable.wedding03));
        stickerlist.add(Integer.valueOf(R.drawable.wedding01));
        stickerlist.add(Integer.valueOf(R.drawable.wedding05));
        stickerlist.add(Integer.valueOf(R.drawable.wedding12));
        stickerlist.add(Integer.valueOf(R.drawable.wedding04));
        stickerlist.add(Integer.valueOf(R.drawable.wedding08));
        stickerlist.add(Integer.valueOf(R.drawable.wedding09));
        stickerlist.add(Integer.valueOf(R.drawable.wedding10));
        stickerlist.add(Integer.valueOf(R.drawable.wedding11));
        stickerlist.add(Integer.valueOf(R.drawable.wedding16));
        stickerlist.add(Integer.valueOf(R.drawable.wedding13));
        stickerlist.add(Integer.valueOf(R.drawable.wedding14));
        stickerlist.add(Integer.valueOf(R.drawable.wedding07));
        stickerlist.add(Integer.valueOf(R.drawable.wedding19));
        stickerlist.add(Integer.valueOf(R.drawable.wedding17));
        stickerlist.add(Integer.valueOf(R.drawable.wedding18));
        stickerlist.add(Integer.valueOf(R.drawable.wedding22));
        stickerlist.add(Integer.valueOf(R.drawable.wedding20));
        stickerlist.add(Integer.valueOf(R.drawable.wedding21));
        stickerlist.add(Integer.valueOf(R.drawable.wedding15));
    }


    public void setStickerList5() {
        stickerlist.add(Integer.valueOf(R.drawable.s3));
        stickerlist.add(Integer.valueOf(R.drawable.s2));
        stickerlist.add(Integer.valueOf(R.drawable.s8));
        stickerlist.add(Integer.valueOf(R.drawable.s1));
        stickerlist.add(Integer.valueOf(R.drawable.s5));
        stickerlist.add(Integer.valueOf(R.drawable.s6));
        stickerlist.add(Integer.valueOf(R.drawable.s4));
        stickerlist.add(Integer.valueOf(R.drawable.s7));
        stickerlist.add(Integer.valueOf(R.drawable.s9));
        stickerlist.add(Integer.valueOf(R.drawable.s13));
        stickerlist.add(Integer.valueOf(R.drawable.s10));
        stickerlist.add(Integer.valueOf(R.drawable.s12));
        stickerlist.add(Integer.valueOf(R.drawable.s16));
        stickerlist.add(Integer.valueOf(R.drawable.s14));
        stickerlist.add(Integer.valueOf(R.drawable.s11));
        stickerlist.add(Integer.valueOf(R.drawable.s20));
        stickerlist.add(Integer.valueOf(R.drawable.s17));
        stickerlist.add(Integer.valueOf(R.drawable.s15));
        stickerlist.add(Integer.valueOf(R.drawable.s18));
        stickerlist.add(Integer.valueOf(R.drawable.s19));
    }

    public void setStickerList6() {
        stickerlist.add(Integer.valueOf(R.drawable.b3));
        stickerlist.add(Integer.valueOf(R.drawable.b2));
        stickerlist.add(Integer.valueOf(R.drawable.b7));
        stickerlist.add(Integer.valueOf(R.drawable.b1));
        stickerlist.add(Integer.valueOf(R.drawable.b6));
        stickerlist.add(Integer.valueOf(R.drawable.b8));
        stickerlist.add(Integer.valueOf(R.drawable.b16));
        stickerlist.add(Integer.valueOf(R.drawable.b9));
        stickerlist.add(Integer.valueOf(R.drawable.b10));
        stickerlist.add(Integer.valueOf(R.drawable.b12));
        stickerlist.add(Integer.valueOf(R.drawable.b4));
        stickerlist.add(Integer.valueOf(R.drawable.b15));
        stickerlist.add(Integer.valueOf(R.drawable.b20));
        stickerlist.add(Integer.valueOf(R.drawable.b17));
        stickerlist.add(Integer.valueOf(R.drawable.b14));
        stickerlist.add(Integer.valueOf(R.drawable.b19));
        stickerlist.add(Integer.valueOf(R.drawable.b18));
    }
    @SuppressLint("ResourceType")
    public void AddText2() {
        mDialog = new Dialog(this, 16973833);
        mDialog.requestWindowFeature(1);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        mDialog.getWindow().setSoftInputMode(32);
        mDialog.setContentView(R.layout.text_dialog);
        nav_text1 = (TextView) mDialog.findViewById(R.id.nav_text);
        txt_main = (TextView) mDialog.findViewById(R.id.txt_main);
        mRadioGroup = (RadioGroup) mDialog.findViewById(R.id.rg);
        imgtext = (ImageView) mDialog.findViewById(R.id.text);
        imgtext.setImageResource(R.mipmap.btn_add_text_hover);
        btn_text_done = (TextView) mDialog.findViewById(R.id.btn_text_done);
        btn_alignment_done = (TextView) mDialog.findViewById(R.id.btn_alignment_done);
        btn_pattern_done = (TextView) mDialog.findViewById(R.id.btn_pattern_done);
        btn_fontstyle_done = (TextView) mDialog.findViewById(R.id.btn_fontstyle_done);
        btn_addtext_done = (ImageView) mDialog.findViewById(R.id.btn_addtext_done);
        btn_color_done = (TextView) mDialog.findViewById(R.id.btn_color_done);
        relAllDrawText = (RelativeLayout) mDialog.findViewById(R.id.relAllDrawText);
        relTextSize = (RelativeLayout) mDialog.findViewById(R.id.relTextSize);
        relconAlign = (RelativeLayout) mDialog.findViewById(R.id.relconAlign);
        relPattern = (RelativeLayout) mDialog.findViewById(R.id.relPattern);
        relFontStyle = (RelativeLayout) mDialog.findViewById(R.id.relFontStyle);
        relAddText = (RelativeLayout) mDialog.findViewById(R.id.relAddText);
        relTextColor = (RelativeLayout) mDialog.findViewById(R.id.relTextColor);
        lin_add_text = (LinearLayout) mDialog.findViewById(R.id.lin_add_text);
        lin_text = (LinearLayout) mDialog.findViewById(R.id.lin_text);
        lin_textSize = (LinearLayout) mDialog.findViewById(R.id.lin_textSize);
        lin_color = (LinearLayout) mDialog.findViewById(R.id.lin_color);
        lin_pattern = (LinearLayout) mDialog.findViewById(R.id.lin_pattern);
        lin_style = (LinearLayout) mDialog.findViewById(R.id.lin_style);
        lin_alignment = (LinearLayout) mDialog.findViewById(R.id.lin_alignment);
        lin_back = (ImageView) mDialog.findViewById(R.id.lin_back);
        btnsave = (ImageView) mDialog.findViewById(R.id.main_img_save);
        seekTextSize = (SeekBar) mDialog.findViewById(R.id.sekTextSize);
        imgcolor = (ImageView) mDialog.findViewById(R.id.color);
        imgstyle = (ImageView) mDialog.findViewById(R.id.style);
        imgPattern = (ImageView) mDialog.findViewById(R.id.pattern);
        imgAlign = (ImageView) mDialog.findViewById(R.id.imgAlignment);
        imgTextSize = (ImageView) mDialog.findViewById(R.id.textSize);
        grid_pattern = (GridView) mDialog.findViewById(R.id.grid_pattern);
        grid_fontstyle = (GridView) mDialog.findViewById(R.id.grid_fontstyle);
        grid_color = (GridView) mDialog.findViewById(R.id.grid_color);
        editAddText = (EditText) mDialog.findViewById(R.id.edt_text);
        lin_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                crope.this.mDialog.dismiss();
            }
        });
        relAddText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (crope.this.relAddText.getVisibility() ==View.GONE) {
                    crope.this.relAddText.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                    crope.this.relAddText.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                    crope.this.relAddText.setVisibility(View.VISIBLE);
                }
                crope.this.relAddText.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                crope.this.relAddText.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                crope.this.relAddText.setVisibility(View.GONE);
                crope.closeInput(crope.this.relAddText);
            }
        });
        relAddText.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_up_out));
        this.relAddText.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_up_in));
        this.relAddText.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_up_in));
        this.relAddText.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_up_out));
        this.lin_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (crope.this.txt_main.getText().toString().equalsIgnoreCase("")) {
                    if (crope.this.relAddText.getVisibility() == View.GONE) {
                        crope.this.relAddText.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                        crope.this.relAddText.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                        crope.this.relAddText.setVisibility(View.VISIBLE);
                    } else {
                        crope.this.relAddText.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                        crope.this.relAddText.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                        crope.this.relAddText.setVisibility(View.GONE);
                        crope.closeInput(crope.this.imgtext);
                    }
                    crope.this.imgtext.setImageResource(R.mipmap.btn_add_text_hover);
                    crope.this.imgcolor.setImageResource(R.mipmap.btn_color);
                    crope.this.imgTextSize.setImageResource(R.mipmap.btn_text_size);
                    crope.this.imgPattern.setImageResource(R.mipmap.btn_pattern);
                    crope.this.imgstyle.setImageResource(R.mipmap.btn_style);
                    crope.this.imgAlign.setImageResource(R.mipmap.btn_alignment);
                    crope.this.relconAlign.setVisibility(View.GONE);
                    crope.this.relTextSize.setVisibility(View.GONE);
                    crope.this.relPattern.setVisibility(View.GONE);
                    crope.this.relFontStyle.setVisibility(View.GONE);
                }
            }
        });
        final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent e) {
                return true;
            }
        });
        txt_main.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });
        btn_text_done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                crope.this.relTextSize.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                crope.this.relTextSize.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                crope.this.relTextSize.setVisibility(View.GONE);
            }
        });
        btn_alignment_done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                crope.this.relconAlign.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                crope.this.relconAlign.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                crope.this.relconAlign.setVisibility(View.GONE);
            }
        });
        btn_pattern_done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                crope.this.relPattern.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                crope.this.relPattern.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                crope.this.relPattern.setVisibility(View.GONE);
            }
        });
        btn_fontstyle_done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                crope.this.relFontStyle.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                crope.this.relFontStyle.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                crope.this.relFontStyle.setVisibility(View.GONE);
            }
        });
        btn_color_done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                crope.this.relTextColor.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                crope.this.relTextColor.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                crope.this.relTextColor.setVisibility(View.GONE);
            }
        });
        btn_addtext_done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                crope.closeInput(crope.this.btn_text_done);
                crope.this.relAddText.setVisibility(View.GONE);
                crope.this.btnsave.setVisibility(View.VISIBLE);
                crope.this.relAddText.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                crope.this.relAddText.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                if (crope.this.editAddText.getText().toString().equals("")) {
                    Toast.makeText(crope.this.context, "add text first", Toast.LENGTH_SHORT).show();
                } else {
                    crope.this.text = crope.this.editAddText.getText().toString();
                    crope.this.addTextView(crope.this.text, crope.this.radious, crope.this.f1727dx, crope.this.f1728dy);
                }
                crope.this.editAddText.setText("");
            }
        });
        lin_color.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (crope.this.txt_main.getText().toString().equalsIgnoreCase("f1728dy")) {
                }
                if (crope.this.relTextColor.getVisibility() == View.GONE) {
                    crope.this.relTextColor.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                    crope.this.relTextColor.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                    crope.this.relTextColor.setVisibility(View.VISIBLE);
                } else {
                    crope.this.relTextColor.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                    crope.this.relTextColor.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                    crope.this.relTextColor.setVisibility(View.GONE);
                }
                crope.this.imgtext.setImageResource(R.mipmap.btn_add_text);
                crope.this.imgcolor.setImageResource(R.mipmap.btn_color_hover);
                crope.this.imgTextSize.setImageResource(R.mipmap.btn_text_size);
                crope.this.imgPattern.setImageResource(R.mipmap.btn_pattern);
                crope.this.imgstyle.setImageResource(R.mipmap.btn_style);
                crope.this.imgAlign.setImageResource(R.mipmap.btn_alignment);
                crope.this.relconAlign.setVisibility(View.GONE);
                crope.this.relTextSize.setVisibility(View.GONE);
                crope.this.relFontStyle.setVisibility(View.GONE);
                crope.this.relPattern.setVisibility(View.GONE);
                crope.this.grid_color.setAdapter(new CardColorAdapter(crope.this, crope.COLORS));
                crope.this.grid_color.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        crope.this.txt_main.getPaint().setShader(null);
                        crope.this.txt_main.setTextColor(crope.COLORS[i]);
                        crope.this.addTextView(crope.this.text, crope.this.radious, crope.this.f1727dx, crope.this.f1728dy);
                    }
                });
            }
        });
        lin_style.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (crope.this.txt_main.getText().toString().equalsIgnoreCase("")) {
                }
                if (crope.this.relFontStyle.getVisibility() == View.GONE) {
                    crope.this.relFontStyle.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                    crope.this.relFontStyle.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                    crope.this.relFontStyle.setVisibility(View.VISIBLE);
                } else {
                    crope.this.relFontStyle.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                    crope.this.relFontStyle.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                    crope.this.relFontStyle.setVisibility(View.GONE);
                }
                crope.this.imgtext.setImageResource(R.mipmap.btn_add_text);
                crope.this.imgcolor.setImageResource(R.mipmap.btn_color);
                crope.this.imgTextSize.setImageResource(R.mipmap.btn_text_size);
                crope.this.imgPattern.setImageResource(R.mipmap.btn_pattern);
                crope.this.imgstyle.setImageResource(R.mipmap.btn_style_hover);
                crope.this.imgAlign.setImageResource(R.mipmap.btn_alignment);
                crope.this.relconAlign.setVisibility(View.GONE);
                crope.this.relTextSize.setVisibility(View.GONE);
                crope.this.relTextColor.setVisibility(View.GONE);
                crope.this.relPattern.setVisibility(View.GONE);
                crope.this.grid_fontstyle.setAdapter(new CardFontStyleAdapter(crope.this, crope.this.fonts));
                crope.this.grid_fontstyle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        crope.this.type = Typeface.createFromAsset(crope.this.getAssets(), crope.this.fonts[i]);
                        crope.this.txt_main.setTypeface(crope.this.type);
                        crope.this.addTextView(crope.this.text, crope.this.radious, crope.this.f1727dx, crope.this.f1728dy);
                    }
                });
            }
        });
        lin_pattern.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (crope.this.txt_main.getText().toString().equalsIgnoreCase("")) {
                }
                if (crope.this.relPattern.getVisibility() == View.GONE) {
                    crope.this.relPattern.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                    crope.this.relPattern.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                    crope.this.relPattern.setVisibility(View.VISIBLE);
                } else {
                    crope.this.relPattern.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                    crope.this.relPattern.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                    crope.this.relPattern.setVisibility(View.VISIBLE);
                }
                crope.this.imgtext.setImageResource(R.mipmap.btn_add_text);
                crope.this.imgcolor.setImageResource(R.mipmap.btn_color);
                crope.this.imgTextSize.setImageResource(R.mipmap.btn_text_size);
                crope.this.imgPattern.setImageResource(R.mipmap.btn_pattern_hover);
                crope.this.imgstyle.setImageResource(R.mipmap.btn_style);
                crope.this.imgAlign.setImageResource(R.mipmap.btn_alignment);
                crope.this.relconAlign.setVisibility( View.GONE);
                crope.this.relTextSize.setVisibility(View.GONE);
                crope.this.relFontStyle.setVisibility(View.GONE);
                crope.this.relTextColor.setVisibility(View.GONE);
                crope.this.grid_pattern.setAdapter(new CardPatternAdapter(crope.this, crope.this.pattern));
                crope.this.grid_pattern.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        crope.this.txt_main.getPaint().setShader(new BitmapShader(BitmapFactory.decodeResource(crope.this.getResources(), crope.this.pattern[i]), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        crope.this.addTextView(crope.this.text, crope.this.radious, crope.this.f1727dx, crope.this.f1728dy);
                    }
                });
            }
        });
        lin_textSize.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (crope.this.txt_main.getText().toString().equalsIgnoreCase("")) {
                }
                if (crope.this.relTextSize.getVisibility() == View.GONE) {
                    crope.this.relTextSize.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                    crope.this.relTextSize.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                    crope.this.relTextSize.setVisibility(View.VISIBLE );
                } else {
                    crope.this.relTextSize.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                    crope.this.relTextSize.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                    crope.this.relTextSize.setVisibility(View.GONE);
                }
                crope.this.imgtext.setImageResource(R.mipmap.btn_add_text);
                crope.this.imgcolor.setImageResource(R.mipmap.btn_color);
                crope.this.imgTextSize.setImageResource(R.mipmap.btn_text_size_hover);
                crope.this.imgPattern.setImageResource(R.mipmap.btn_pattern);
                crope.this.imgstyle.setImageResource(R.mipmap.btn_style);
                crope.this.imgAlign.setImageResource(R.mipmap.btn_alignment);
                crope.this.relconAlign.setVisibility(View.GONE);
                crope.this.relPattern.setVisibility(View.GONE);
                crope.this.relFontStyle.setVisibility(View.GONE);
                crope.this.relTextColor.setVisibility(View.GONE);
            }
        });
        lin_alignment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (crope.this.txt_main.getText().toString().equalsIgnoreCase("")) {
                }
                if (crope.this.relconAlign.getVisibility() == View.GONE) {
                    crope.this.relconAlign.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                    crope.this.relconAlign.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                    crope.this.relconAlign.setVisibility(View.VISIBLE);
                } else {
                    crope.this.relconAlign.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_in));
                    crope.this.relconAlign.startAnimation(AnimationUtils.loadAnimation(crope.this.getApplicationContext(), R.anim.push_up_out));
                    crope.this.relconAlign.setVisibility(View.GONE);
                }
                crope.this.imgtext.setImageResource(R.mipmap.btn_add_text);
                crope.this.imgcolor.setImageResource(R.mipmap.btn_color);
                crope.this.imgTextSize.setImageResource(R.mipmap.btn_text_size);
                crope.this.imgPattern.setImageResource(R.mipmap.btn_pattern);
                crope.this.imgstyle.setImageResource(R.mipmap.btn_style);
                crope.this.imgAlign.setImageResource(R.mipmap.btn_alignment_hover);
                crope.this.relTextSize.setVisibility(View.GONE);
                crope.this.relPattern.setVisibility(View.GONE);
                crope.this.relFontStyle.setVisibility(View.GONE);
                crope.this.relTextColor.setVisibility(View.GONE);
            }
        });
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_none) {
                    crope.this.txt_main.setLayerType(1, null);
                    crope.this.txt_main.getPaint().setMaskFilter(null);
                }
                if (i == R.id.rb_inner) {
                    crope.this.applyBlurMaskFilter(crope.this.txt_main, BlurMaskFilter.Blur.INNER);
                }
                if (i == R.id.rb_normal) {
                    crope.this.applyBlurMaskFilter(crope.this.txt_main, BlurMaskFilter.Blur.NORMAL);
                }
                if (i == R.id.rb_outer) {
                    crope.this.applyBlurMaskFilter(crope.this.txt_main, BlurMaskFilter.Blur.OUTER);
                }
                if (i == R.id.rb_solid) {
                    crope.this.applyBlurMaskFilter(crope.this.txt_main, BlurMaskFilter.Blur.SOLID);
                }
            }
        });
        seekTextSize.setProgress(10);
        seekTextSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                crope.this.textSize = progress + 30;
                crope.this.txt_main.setTextSize((float) crope.this.textSize);
            }
        });
        txt_main.setDrawingCacheEnabled(true);
        btnsave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (crope.this.txt_main.getText().toString().equals("")) {
                    Toast.makeText(crope.this.context, "add text first to continue", Toast.LENGTH_SHORT).show();
                    return;
                }
                ImageView img = new ImageView(crope.this.getApplicationContext());
                crope.this.txt_main.buildDrawingCache();
                img.setImageBitmap(crope.this.txt_main.getDrawingCache());
                img.setVisibility(View.GONE);
                Glob.txtBitmap = crope.loadBitmapFromView(img);
                Glob.txtBitmap = crope.this.CropBitmapTransparency(Glob.txtBitmap);
                crope.this.addTextStickerView(Glob.txtBitmap);
                crope.this.mDialog.dismiss();
            }
        });
        mDialog.show();
        mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode != 4 || event.getAction() != 1 || event.isCanceled()) {
                    return false;
                }
                crope.this.mDialog.dismiss();
                return true;
            }
        });
    }

}