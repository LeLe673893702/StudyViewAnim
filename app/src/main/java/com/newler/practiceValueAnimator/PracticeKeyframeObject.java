package com.newler.practiceValueAnimator;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * @author newler
 * @what
 * @date 2018/12/14
 */
public class PracticeKeyframeObject extends android.support.v7.widget.AppCompatTextView {
    public PracticeKeyframeObject(Context context, AttributeSet attrs) {
        super(context, attrs);
        playOfObject();
    }

    private void playOfObject() {
        Keyframe keyframe1 = Keyframe.ofObject(0, 'A');
        Keyframe keyframe2 = Keyframe.ofObject(0.5f, 'M');
        Keyframe keyframe3 = Keyframe.ofObject(1f, 'Z');
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder
                .ofKeyframe("CharText", keyframe1, keyframe2, keyframe3);
        propertyValuesHolder.setEvaluator(new CharTypeEvaluator());
        ObjectAnimator objectAnimator = ObjectAnimator
                .ofPropertyValuesHolder(this, propertyValuesHolder);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }

    public void setCharText(Character charText) {
        setText(String.valueOf(charText));
    }

    private static class CharTypeEvaluator implements TypeEvaluator<Character> {
        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int s = (int) (startValue + fraction * (endValue - startValue));
            return (char) s;
        }
    }
}
