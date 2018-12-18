package com.newler.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * @author newler
 * @what
 * @date 2018/11/22
 */
public class PracticeDrawText extends AppCompatTextView {
    private Paint mPaint;

    private String drawText = "刘乐是个大天才";

    public PracticeDrawText(Context context) {
        super(context);
        init();
    }

    public PracticeDrawText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(1);
        mPaint.setAntiAlias(true);
        // 居左、中、右对齐
        mPaint.setTextSize(45);
        mPaint.setColor(Color.BLACK);
        // 样式设置，粗体文字
//        mPaint.setFakeBoldText(true);
        // 设置下划线
//        mPaint.setUnderlineText(true);
        // 设置字体水平倾斜
//        mPaint.setTextSkewX((float) -0.25);
        // 设置删除线
//        mPaint.setStrikeThruText(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        setTextStyle(canvas);
//        setTextAlign(canvas);
//        drawTextOnPath(canvas);
//        setTextFont(canvas);
//        defaultFromStyle(canvas);
        createTypeFace(canvas);
    }

    private void setTextStyle(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawText(drawText, 400, 100, mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(drawText, 400, 200, mPaint);

        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText(drawText, 400, 300, mPaint);
    }

    /**
     * 设置文字绘制位置
     * center：（400，100）是中间线
     * left：从（400,200）这个点开始绘制文字
     * right: 绘制文字到（400,300）这个点为止
     */
    private void setTextAlign(Canvas canvas) {
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSkewX((float) 0.5);
        canvas.drawText(drawText, 400, 100, mPaint);

        mPaint.setTextAlign(Paint.Align.RIGHT);
        mPaint.setTextSkewX((float) -0.25);
        canvas.drawText(drawText, 400, 200, mPaint);

        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextScaleX(2);
        canvas.drawText(drawText,2,4, 400, 300, mPaint);
    }


    /**
     * 逐个指定文字位置, 过时废弃不用了
     */
    private void drawPosText(Canvas canvas) {
        float[] pos =new float[] {80, 100, 80, 200, 80, 300, 80, 400};
        canvas.drawPosText("床前明月", pos, mPaint);
    }

    /**
     * 沿路径绘制
     * hOffset:与路径起始点的水平偏移量
     * vOffset：与路径中心的垂直偏移量
     * 可以把路径拉成一条直线，hOffset就是距X轴的距离，vOffset就是距Y轴的距离
     */
    private void drawTextOnPath(Canvas canvas) {
        Path noOffsetCirclePath = new Path();
        mPaint.setStyle(Paint.Style.STROKE);
        noOffsetCirclePath.addCircle(220, 300, 150, Path.Direction.CCW);
        canvas.drawPath(noOffsetCirclePath, mPaint);

        Path offsetCirclePath = new Path();
        offsetCirclePath.addCircle(600, 300, 150, Path.Direction.CCW);
        canvas.drawPath(offsetCirclePath, mPaint);

        canvas.drawTextOnPath(drawText, noOffsetCirclePath, 0, 0, mPaint);
        canvas.drawTextOnPath(drawText, offsetCirclePath, 80, 45, mPaint);
    }

    /**
     * 设置字体样式,得出结论对英文支持可以，对中文支持的不好
     */
    private void setTextFont(Canvas canvas) {
        String testEnglishText = "I love my Mom";
        String testChineseText = "我爱我家";
        mPaint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText(testChineseText, 400, 100, mPaint);
        mPaint.setTypeface(Typeface.MONOSPACE);
        canvas.drawText(testChineseText, 400, 200, mPaint);
        mPaint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText(testChineseText, 400, 300, mPaint);
    }

    /**
     * 根据字体的样式获取系统对应的默认字体，如果系统对应的是宋体那获取的就是宋体样式
     */
    private void defaultFromStyle(Canvas canvas) {
        // 粗体
        Typeface typeface1 = Typeface.defaultFromStyle(Typeface.BOLD);
        // 正常字体
        Typeface typeface2 = Typeface.defaultFromStyle(Typeface.NORMAL);
        mPaint.setTypeface(typeface2);
        canvas.drawText(drawText, 400, 100, mPaint);
        // 斜体
        Typeface typeface3 = Typeface.defaultFromStyle(Typeface.ITALIC);
        // 粗斜体
        Typeface typeface4 = Typeface.defaultFromStyle(Typeface.BOLD_ITALIC);
    }

    /**
     * 通过字体名来加载系统中自带的字体样式，如果字体不存在就会用我们手机默认的系统样式返回
     */
    private void createTypeFace(Canvas canvas) {
        String familyName = "宋体";
        Typeface font = Typeface.create(familyName, Typeface.NORMAL);
        mPaint.setTypeface(font);
        canvas.drawText(drawText, 100, 200, mPaint);
    }

}
