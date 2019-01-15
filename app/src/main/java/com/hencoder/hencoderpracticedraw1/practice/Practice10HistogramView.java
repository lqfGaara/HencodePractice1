package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        Paint paint=new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        Paint paint1=new Paint();
        paint1.setColor(Color.WHITE);
        paint1.setAntiAlias(true);
        paint1.setTextSize(36);
        paint1.setStrokeWidth(2);
        canvas.drawLine(100,100,100,600,paint);
        canvas.drawLine(100,600,1000,600,paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(new RectF(120,590,220,600),paint);
        canvas.drawText("abc",125,630,paint1);
        canvas.drawRect(new RectF(240,580,340,600),paint);
        canvas.drawText("efg",245,630,paint1);
        canvas.drawRect(new RectF(360,580,460,600),paint);
        canvas.drawText("hij",365,630,paint1);
        canvas.drawRect(new RectF(480,380,580,600),paint);
        canvas.drawText("klm",485,630,paint1);
        canvas.drawRect(new RectF(600,280,700,600),paint);
        canvas.drawText("nop",605,630,paint1);
        canvas.drawRect(new RectF(720,220,820,600),paint);
        canvas.drawText("qrs",725,630,paint1);
        canvas.drawRect(new RectF(840,180,940,600),paint);
        canvas.drawText("tuv",845,630,paint1);
    }
}
