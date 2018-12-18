package com.newler.practiceValueAnimator;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * @author newler
 * @what
 * @date 2018/12/8
 */
public class PracticeOfObject extends android.support.v7.widget.AppCompatTextView {
    public PracticeOfObject(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new CharacterEvaluator(),
                'A',
                'Z');
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                setText(String.valueOf(animation.getAnimatedValue()));
            }
        });
        valueAnimator.setDuration(6000);
        valueAnimator.start();
    }

    private static class CharacterEvaluator implements TypeEvaluator<Character> {

        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int a = (int) (Integer.valueOf(startValue) + fraction * (Integer.valueOf(endValue) - Integer.valueOf(startValue)));
            Log.e("evaluate", (char)a+"s");
            return (char)a;
        }
    }
}
