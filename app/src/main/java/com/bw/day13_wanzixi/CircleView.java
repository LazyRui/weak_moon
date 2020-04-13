package com.bw.day13_wanzixi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.ImageView;

/**
 * @ClassName: CircleView
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/4/13 19:40
 */
public class CircleView extends androidx.appcompat.widget.AppCompatImageView {

    private Paint mPaint;
    private int mRadius;
    private float mScale;

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        mPaint = new Paint();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.aaaaaa);

        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);


        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());

        mPaint.setShader(bitmapShader);

        canvas.drawCircle(bitmap.getWidth()/2,bitmap.getHeight()/2,min/2,mPaint);



    }


}
