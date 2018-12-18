package com.newler.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author newler
 * @what
 * @date 2018/11/25
 */
public class PracticeDrawRegion extends View {
    private Paint paint;
    private Region mRegion;

    public PracticeDrawRegion(Context context) {
        super(context);

        init();
    }

    public PracticeDrawRegion(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);

        mRegion = new Region(new Rect(100, 200, 500, 800));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        setRegionByPath(canvas);

    }

    private void setRegionByPath(Canvas canvas) {
        Path ovalPath = new Path();
        // 先构建一个椭圆
        RectF rectF = new RectF(50,50,200,500);
        ovalPath.addOval(rectF, Path.Direction.CCW);

        // 再传入一个比椭圆区域小的矩形区域，用来取交集
        Region rgn = new Region();
        rgn.setPath(ovalPath, new Region(50,50,200,200));

        Rect rect = new Rect();
        rgn.getBounds(rect);
        canvas.drawRect(rect, paint);
//        drawRegion(canvas, rgn, paint);
    }

    /**
     * 两块区域的并集
     */
    private void union(Canvas canvas) {
        Region region = new Region(10, 10, 200, 100);
        region.union(new Rect(10, 10, 50, 300));
        drawRegion(canvas, region, paint);
    }

    /**
     * 判断方法
     */
    private void judge() {
        // 判断区域是否为空
        mRegion.isEmpty();

        // 判断区域是否是个矩形
        mRegion.isRect();

        // 判断区域是否是多个矩形的组合
        mRegion.isComplex();

        // 判断有没有和指定矩形相交
        mRegion.quickReject(new Rect(10,200,100,500));
        mRegion.quickReject(10,200,500,100);

        //判断有没有和指定的区域相交
        mRegion.quickReject(new Region());
    }

    private void translate() {
        // 将当前的Region对象x轴平移dx距离，Y轴平移dy距离
        mRegion.translate(5,10);
        // 将平移后的结果赋值给dst对象
        mRegion.translate(20,10,new Region());
    }

    /**
     * getBound系列函数, 返回一个Region的边界
     **/
    private void getBounds(Canvas canvas) {
        // 也就是最上、最下、最左、最右组成的边界矩形
        mRegion.getBounds();
        // 将组成的边界矩形赋值给这个传入的矩形
        mRegion.getBounds(new Rect());
    }

    /**
     * 区域操作op,
     * 前三个重载方法，当前的Region对象与指定的一个Rect对象或者Region对象执行相交操作，并将结果赋值给当前的Region对象
     * 后面两个重载方法，表示传入的Region1和Region2或者Rect进行区域操作，并将结果赋给当前的Region对象
     */
    private void op(Canvas canvas) {
        Region region = new Region(10, 10, 200, 100);
        // 补集
        region.op(new Rect(10, 10, 50, 300), Region.Op.DIFFERENCE);

    }

    /**
     * 系统没有提供绘制区域的方法，如果想绘制区域按照如下方法
     * 一定数量的矩形所合成的形状也可以代表区域的形状
     * RegionIterator实现了获取组成区域的矩形集（一定数量的矩形所合成的形状）的功能
     * 从下面的日志信息打印来看，跟准确的说是是有很小的长所构成的
     */
    private void drawRegion(Canvas canvas, Region rgn, Paint paint) {
        RegionIterator iterator = new RegionIterator(rgn);
        Rect rect = new Rect();
        // next方法就是获取下一个矩形，并将结果保留在结果r当中
        while (iterator.next(rect)) {
            Log.e("next", rect.left+"---"+rect.top+"---"+rect.right+"----"+rect.bottom);
            canvas.drawRect(rect, paint);
        }
    }
     /**
      117---51---133----52
      114---52---136----53
      112---53---138----54
      110---54---140----55
      109---55---141----56
      107---56---143----57
      106---57---144----58
      105---58---145----59
      103---59---147----60
      102---60---148----62
      101---62---149----63
      100---63---150----64
      99---64---151----65
      98---65---152----66
      97---66---153----67
      96---67---154----68
      95---68---155----70
      94---70---156----71
      93---71---157----72
      92---72---157----73
      92---73---158----74
      90---75---160----77
      89---77---161----79
      88---79---162----80
      87---80---163----82
      86---82---164----84
      85---84---165----86
      84---86---166----88
      83---88---167----90
      82---90---168----92
      81---92---169----94
      80---94---170----96
      79---96---171----99
      78---99---172----101
      77---101---173----103
      76---103---173----104
      76---104---174----106
      75---106---175----109
      74---109---176----112
      73---112---177----114
      72---114---178----117
      71---117---179----121
      70---121---180----124
      69---124---181----127
      68---127---182----131
      67---131---183----134
      66---134---184----138
      65---138---185----142
      64---142---185----143
      64---143---186----146
      63---146---186----147
      62---151---188----156
      61---156---189----161
      60---161---190----166
      59---166---191----171
      58---171---192----177
      57---177---192----178
      57---178---193----184
      56---184---194----190
      55---190---194----191
      55---191---195----198
      54---198---196----200
      */
}
