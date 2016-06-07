package com.example.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;

public class MyTextView extends View {

    public static final int RADIUS = 5;//半径
    private Paint iconPaint;
    private Paint textPaint;
    private Paint bgPaint;
    private String text;
    private Paint.FontMetrics fm;
    private int textHeight;
    private int width;
    private int height;

    //设置要在左侧显示的图标
    public MyTextView(Context context){
        super(context);
        init();
    }
    private void init() {
        iconPaint = new Paint();
        iconPaint.setColor(Color.BLACK);

        bgPaint = new Paint();
        bgPaint.setColor(Color.GREEN);
        bgPaint.setStyle(Paint.Style.STROKE);

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(25);

        fm = textPaint.getFontMetrics();
        textHeight = ((int) Math.ceil(fm.descent - fm.ascent))/2;
    }

    @Override
    public void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        Log.e("MyTextView","width = "+width);
        Log.e("MyTextView","height = "+height);
    }
    @Override
    public void onDraw(Canvas canvas){
        Rect rect = new Rect(0,0,width,height);
        float textY = rect.centerY() - (fm.bottom - fm.top) / 2 - fm.top;
        canvas.drawRect(rect,bgPaint);
        canvas.drawCircle(6,height/2,RADIUS,iconPaint);
        canvas.drawText(text,20f,textY,textPaint);

    }

    public void setMyText(String text){
        this.text = text;
        invalidate();
    }
}