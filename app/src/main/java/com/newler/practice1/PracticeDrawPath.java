package com.newler.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 刺雒
 * @what
 * @date 2018/5/24
 */
public class PracticeDrawPath extends View {
    private Paint paint;

    public PracticeDrawPath(Context context) {
        super(context);
    }

    public PracticeDrawPath(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
    }

    public PracticeDrawPath(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        addPath(canvas);
    }

    /**
     * 直线路径
     */
    private void lineTo(Canvas canvas) {
        Path path = new Path();
        // 起始点
        path.moveTo(10,10);
        // 第一条直线终点，第二条直线起点
        path.lineTo(60,10);
        // 画第二条直线
        path.lineTo(35, 60);
        // 闭环
        path.close();
        canvas.drawPath(path, paint);
    }

    /**
     * 弧线路径
     */
    private void arcTo(Canvas canvas) {
        Path path = new Path();
        // 用于创建椭圆的矩形
        RectF rectF = new RectF(10,10,200,200);
        // 起始角度，x轴正方向为0度
        float startAngle = 10;
        // 弧跨越的角度
        float sweepAngle = 90;
        // 默认情况下具备连贯性会带上半径执行，即一条直线+弧线
        path.arcTo(rectF, startAngle, sweepAngle);
        canvas.drawPath(path, paint);

        // 这种情况下只有弧线
        paint.setColor(Color.RED);
        path.arcTo(rectF, 100, 190, true);
        canvas.drawPath(path, paint);
    }


    /**
     * addXXX 系列函数不具备连贯性
     */
   private void addPath(Canvas canvas) {
       addRoundRectPath(canvas);
   }

   /**
    * 添加矩形路径
    */
   private void addRectPath(Canvas canvas) {
       Path CCWRectPath = new Path();
       RectF rectF1 = new RectF(50,50,240,200);
       // CCW即counter-clockwise，创建逆时针方向的矩形路径
       CCWRectPath.addRect(rectF1, Path.Direction.CCW);

       Path CWRectPath = new Path();
       // CW即clockwise， 创建顺势正方向的矩形路径
       RectF rectF2 = new RectF(290, 50 , 480, 200);
       CWRectPath.addRect(rectF2, Path.Direction.CW);

       // 生成方向的区别依据生成方向排版的文字
      String text = "苦心人天不负，有志者事竟成";
      paint.setTextSize(35);
      canvas.drawTextOnPath(text, CCWRectPath, 0, 18 , paint);
      canvas.drawTextOnPath(text, CWRectPath, 0 , 18 ,paint);
   }

   /**
    * 添加圆角矩形路径
    */
   private void addRoundRectPath(Canvas canvas) {
       Path sameCircleRoundPath =  new Path();
       RectF rectF1 = new RectF(50, 50 , 240 ,200);
       // rx，rx分别为生成圆角椭圆的横半径和纵半径, 四个角圆角均相同
       sameCircleRoundPath.addRoundRect(rectF1, 10, 15, Path.Direction.CCW);
       canvas.drawPath(sameCircleRoundPath, paint);

       Path differentCirclePath = new Path();
       RectF rectF2 = new RectF(290, 50, 480, 200);
       // 传入8个数值，分为4组，分别对应每个角所使用椭圆的横半径和纵半径,
       // 按照顺时针走下来依次是左上，右上，右下，左下
       float radii[] = {10, 15, 20, 25, 30, 35, 100, 105};
       differentCirclePath.addRoundRect(rectF2, radii, Path.Direction.CW);
       canvas.drawPath(differentCirclePath, paint);
   }

   /**
    * 添加圆形路径
    */
   private void addCirclePath(Canvas canvas) {
       Path circlePath = new Path();
       // x，y圆心坐标，50为半径
       circlePath.addCircle(100, 100, 50, Path.Direction.CW);
        canvas.drawPath(circlePath, paint);
   }

   /**
    * 添加椭圆半径
    */
   private void addOvalPath(Canvas canvas) {
       Path ovalPath = new Path();
       // 用于生成椭圆的矩形
       RectF rectF = new RectF(500, 800, 800, 1000);
       ovalPath.addOval(rectF, Path.Direction.CW);
       canvas.drawOval(rectF, paint);
   }

   /**
    * 添加弧形半径
    */
   private void addArcPath(Canvas canvas) {
       Path arcPath = new Path();
       // 先生成椭圆
       RectF rectF = new RectF(400, 330, 500, 550);
       arcPath.addArc(rectF, 10, 90);
       canvas.drawPath(arcPath, paint);
   }

   /**
    * 填充模式
    */
   private void pathFillMode(Canvas canvas) {
       Path fillPath = new Path();
       fillPath.addRect(100,100,300,300, Path.Direction.CW);
       fillPath.addCircle(300, 300, 100, Path.Direction.CW);
       //  默认值，多个图形相交时，取全部区域
       fillPath.setFillType(Path.FillType.WINDING);
       // path的外部区域，即相反集合
       fillPath.setFillType(Path.FillType.INVERSE_WINDING);
       // path全部区域除去相交区域
        fillPath.setFillType(Path.FillType.EVEN_ODD);
        // 取path的外部区域和相交区域
       fillPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);

       canvas.drawPath(fillPath, paint);
   }

   /**
    * 重置路径, 不会清除内存，但清除FileType，即保留数据结构，快速重用提高性能
    */
   private void restPath(Canvas canvas) {
        Path path = new Path();
        path.setFillType(Path.FillType.INVERSE_WINDING);
        path.reset();
        path.addCircle(100,100,50, Path.Direction.CW);
        canvas.drawPath(path, paint);
   }

   /**
    * 重置路径，清除内存，但不会清除FilType
    */
   private void rewindPath(Canvas canvas) {
       Path path = new Path();
       path.setFillType(Path.FillType.INVERSE_WINDING);
       path.rewind();
       path.addCircle(300,300,50, Path.Direction.CW);
       canvas.drawPath(path, paint);
   }
}
