package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    private Path mPath;

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        Paint paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Path path=new Path();
        //方法一
      /*  path.moveTo(400, 300);
        path.addArc(new RectF(400,200,535,335),140,220);
        path.lineTo(535,430);
        path.addArc(new RectF(535,200,670,335),180,220);
        path.lineTo(535,430);
        canvas.drawPath(path,paint);*/

        //方法二
        path.moveTo(400, 300);
        path.addArc(new RectF(400,200,535,335),140,220);
        path.arcTo(new RectF(535,200,670,335),180,220,false);
        path.lineTo(535,430);
        canvas.drawPath(path,paint);

    }
}
