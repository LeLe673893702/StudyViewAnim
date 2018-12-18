package com.newler.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

/**
 * @author 刺雒
 * @what 矩形工具类RectF和Rect
 * @date 2018/5/24
 */
public class PracticeDrawRect extends View {
    private Paint paint;
    private Context mContext;
    public PracticeDrawRect(Context context) {
        super(context);
    }

    public PracticeDrawRect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
    }

    public PracticeDrawRect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        intersects(canvas);
        union(canvas);
    }

    /**
     * 不仅返回是否相交的结果，而且会把相交的部分矩形赋给当前Rect对象
     */
    private void intersects(Canvas canvas) {
        Rect rect_1 = new Rect(10,10,200,200);
        Rect rect_2 = new Rect(190, 10, 250, 200);
        Rect rect_3 = new Rect(10,210,200,300);

        // 分别画出三个矩形
        paint.setColor(Color.RED);
        canvas.drawRect(rect_1, paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(rect_2, paint);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(rect_3, paint);

        // 判断1，2矩形是否相交
        boolean interset1_2 = Rect.intersects(rect_1, rect_2);
        // 判断1,3矩形是否相交
        boolean interset1_3 = Rect.intersects(rect_1, rect_3);

        Toast.makeText(mContext, "1&2:"+interset1_2+ "   "+ "1&3:"+interset1_3, Toast.LENGTH_SHORT).show();
    }

    /**
     * 把两个矩形合并成一个矩形
     * 取两个矩形最小左上角点作为结果矩形的左上角点
     * 取两个矩形最大右下角点组我诶结果矩形的右下角点
     * 合并的两个矩形一方为空，则将有值的一方作为最终结果
     * 相当于结果矩形把这两个矩形包起来
     */
    private void union(Canvas canvas) {
        Rect rect_1 = new Rect(10,10,20,20);
        Rect rect_2 = new Rect(100, 100, 110, 110);

        paint.setColor(Color.RED);
        canvas.drawRect(rect_1, paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(rect_2, paint);

        // 合并之后的矩形rect_1
        paint.setColor(Color.YELLOW);
        rect_1.union(rect_2);
        canvas.drawRect(rect_1, paint);
    }
}
