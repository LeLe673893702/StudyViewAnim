package com.newler.practiceValueAnimator;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * @author newler
 * @what
 * @date 2018/12/8
 */
public class PracticeFallingBallObjectAnim extends AppCompatImageView {
    public PracticeFallingBallObjectAnim(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        setBackgroundColor(Color.BLACK);
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(this, "fallingLayout", new PointEvaluator(),
                new Point(0,0), new Point(10000, 50));
        objectAnimator.setDuration(20000);
        objectAnimator.start();
    }

    public void setFallingLayout(Point point) {
        layout(point.x, point.y, point.x+getWidth(), point.y+getHeight());
    }

    private static class Point {
        public Point() {
        }

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class PointEvaluator implements TypeEvaluator<PracticeFallingBallObjectAnim.Point> {
        private PracticeFallingBallObjectAnim.Point mPoint = new PracticeFallingBallObjectAnim.Point();
        @Override
        public PracticeFallingBallObjectAnim.Point evaluate(float fraction, PracticeFallingBallObjectAnim.Point startValue, PracticeFallingBallObjectAnim.Point endValue) {
            mPoint.x = (int) (startValue.x + fraction * (endValue.x - startValue.x));
            mPoint.y = (int) (mPoint.x * 3);
            return mPoint;
        }
    }
}
