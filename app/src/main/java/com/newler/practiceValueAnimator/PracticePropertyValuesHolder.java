package com.newler.practiceValueAnimator;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author newler
 * @what
 * @date 2018/12/13
 */
public class PracticePropertyValuesHolder extends android.support.v7.widget.AppCompatTextView {
    public PracticePropertyValuesHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
//        play();
        playChar();
    }

    private void init() {
    }

    public void setCharText(Character character) {
        setText(String.valueOf(character));
    }

    private PropertyValuesHolder[] buildPropertyValueHolder() {
        PropertyValuesHolder translationXHolder = PropertyValuesHolder.ofFloat("translationX", 0, 200, 0);
        PropertyValuesHolder translationYHolder = PropertyValuesHolder.ofFloat("translationY", 0, 200, 0);
        return new PropertyValuesHolder[] {translationXHolder, translationYHolder};
    }

    private void play() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, buildPropertyValueHolder());
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    private void playChar() {
        PropertyValuesHolder charHolder = PropertyValuesHolder.ofObject("CharText", new CharTypeEvaluator(),
                Character.valueOf('A'),Character.valueOf('Z'));
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, charHolder);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }

    private static class CharTypeEvaluator implements TypeEvaluator<Character> {

        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int s = (int) (startValue + fraction * (endValue - startValue));
            Log.e("evaluate", (char)s+"");
            return (char) s;
        }
    }
}
