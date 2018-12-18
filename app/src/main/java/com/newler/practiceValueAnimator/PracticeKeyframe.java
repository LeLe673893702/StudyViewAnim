package com.newler.practiceValueAnimator;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author newler
 * @what
 * @date 2018/12/13
 */
public class PracticeKeyframe extends android.support.v7.widget.AppCompatTextView {
    public PracticeKeyframe(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.BLACK);

        playKeyframe();
    }

    private void playKeyframe() {
        Keyframe keyframe1 =Keyframe.ofFloat(0f, 0f);
        Keyframe keyframe2 =Keyframe.ofFloat(0.5f, 200f);
        Keyframe keyframe3 =Keyframe.ofFloat(1f, 0f);
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder
                .ofKeyframe("translationX", keyframe1, keyframe2, keyframe3);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, propertyValuesHolder);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }
}
