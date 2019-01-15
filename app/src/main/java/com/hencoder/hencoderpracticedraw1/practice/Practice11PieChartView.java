package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("Range")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        Paint paint=new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawLines(new float[] {100,40,200,40,200,40,250,80},paint);
        Path path=new Path();
        path.addArc(new RectF(200,80,700,580),180,110);
        path.lineTo(450,330);
        canvas.drawPath(path,paint);

        Path path1=new Path();
        path1.addArc(new RectF(200,80,700,580),300,60);
        path1.lineTo(455,340);
        paint.setColor(Color.YELLOW);
        canvas.drawPath(path1,paint);


        Path path2=new Path();
        path2.addArc(new RectF(200,80,700,580),5,15);
        path2.lineTo(455,340);
        paint.setColor(Color.MAGENTA);
        canvas.drawPath(path2,paint);

        Path path3=new Path();
        path3.addArc(new RectF(200,80,700,580),20,15);
        path3.lineTo(455,340);
        paint.setColor(Color.DKGRAY);
        canvas.drawPath(path3,paint);

        Path path4=new Path();
        path4.addArc(new RectF(200,80,700,580),30,60);
        path4.lineTo(455,340);
        paint.setColor(Color.GREEN);
        canvas.drawPath(path4,paint);

        Path path5=new Path();
        path5.addArc(new RectF(200,80,700,580),95,90);
        path5.lineTo(455,340);
        paint.setColor(Color.BLUE);
        canvas.drawPath(path5,paint);
    }
}
