package com.example.dongluong.democustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomClock extends View{
    private Paint mPaint;
    private SimpleDateFormat mFormatDate;
    private SimpleDateFormat mFormatTime;
    private int mColorStrock;
    private int mWidthStrock;
    private int mXTitle;
    private int yTitle;
    private int mTextSizeTitle;

    public CustomClock(Context context, AttributeSet attrs) {
        super(context, attrs);
        inits(context, attrs);
    }

    public CustomClock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inits(context, attrs);
    }

    private void inits(Context context, AttributeSet attrs){
        TypedArray typedArray = context
                .obtainStyledAttributes(attrs, R.styleable.CustomClock_XML);
        mColorStrock = typedArray.getColor(R.styleable.CustomClock_XML_color_strock,
                Color.GREEN);
        mWidthStrock = typedArray
                .getDimensionPixelOffset(R.styleable.CustomClock_XML_width_strock_circle,
                        20);
        mXTitle = typedArray.getDimensionPixelOffset(R.styleable.CustomClock_XML_x_title, 200);
        yTitle = typedArray.getDimensionPixelOffset(R.styleable.CustomClock_XML_y_title, 200);
        typedArray.recycle();

        mFormatDate = new SimpleDateFormat("dd/MM/yyyy");
        mFormatTime = new SimpleDateFormat("hh:mm");
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        //set style cho paint
        mPaint.setStyle(Paint.Style.STROKE);
//        Rect rect = new Rect();
//        mPaint.getTextBounds("Smile", 0, "Smile".length(), rect);
//        rect.width()

        //set size text
        mPaint.setTextSize(150);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectOval = new RectF(mWidthStrock/2, mWidthStrock/2,
                getWidth()-mWidthStrock/2, getHeight()-mWidthStrock/2);
        //set do rong cho strock
        mPaint.setStrokeWidth(mWidthStrock);
        //set mau strock
        mPaint.setColor(mColorStrock);
        canvas.drawOval(rectOval, mPaint);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.parseColor("#8BC34A"));
        canvas.drawText("Smile", mXTitle, yTitle, mPaint);
        TextPaint mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        canvas.drawText("ha",mXTitle,yTitle,mTextPaint);
        mPaint.setColor(Color.parseColor("#000"));
        drawDate(canvas);

    }

    private void drawDate(Canvas canvas) {
        Date date = new Date();
        String strDate = mFormatDate.format(date);
        mPaint.setTextSize(100);
        canvas.drawText(strDate, 250, 450, mPaint);
        String strTime = mFormatTime.format(date);
        canvas.drawText(strTime, 250, 600, mPaint);
    }

}
