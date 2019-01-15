package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.AppTools;

public class Practice2DrawCircleView extends View {

    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    private Paint paint4;

    public Practice2DrawCircleView(Context context) {
        this(context,null);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        paint1 = new Paint();
        paint1.setColor(Color.BLACK);
        paint1.setStyle(Paint.Style.FILL);
        paint1.setAntiAlias(true);
        paint2 =new Paint();
        paint2.setColor(Color.BLACK);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint3 =new Paint();
        paint3.setColor(Color.BLUE);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setAntiAlias(true);
        paint4 =new Paint();
        paint4.setColor(Color.BLACK);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setAntiAlias(true);
        paint4.setStrokeWidth(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init();
//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        canvas.drawCircle(300,200,150,paint1);
        canvas.drawCircle(700,200,150,paint2);
        canvas.drawCircle(300,520,150,paint3);
        canvas.drawCircle(700,600,160,paint4);
    }
}
