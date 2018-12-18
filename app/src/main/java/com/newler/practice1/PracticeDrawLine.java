package com.newler.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 刺雒
 * @what
 * @date 2018/5/24
 */
public class PracticeDrawLine extends View {
    public PracticeDrawLine(Context context) {
        super(context);
    }

    public PracticeDrawLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeDrawLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 单条直线
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(50);
//        canvas.drawLine(0,100 , 0,200, paint);

        // 多条直线
        float[] pts = {10,10,20,20,30,30,50,50,80,80,100,100};
        /*
        * offset: 集合中跳过的数值个数，不是点的个数
        * count:参与绘制的数值个数，pts数组中数值的个数
        *
        * 所参与绘制的点为[2.2+4=6]也就是[20,20,30,30]参与绘制
        * */
        canvas.drawLines(pts, 2,8,paint);
    }
}
