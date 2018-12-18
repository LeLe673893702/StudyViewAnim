package com.newler.practiceValueAnimator;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import com.newler.studyview.R;

/**
 * @author newler
 * @what
 * @date 2018/12/14
 */
public class PracticeTelephoneRingAnim extends android.support.v7.widget.AppCompatImageView {

    public PracticeTelephoneRingAnim(Context context, AttributeSet attrs) {
        super(context, attrs);
//        playByInterpolator();
        setBackgroundResource(R.drawable.ic_telephone);
        play();
    }

    private void play() {
        Keyframe[] keyframes = new Keyframe[11];
        for (int i = 0; i < 10; i++) {
            float value;
            if (i % 2 == 0) {
                value = -20;
            } else {
                value = 20;
            }
            keyframes[i] = Keyframe.ofFloat((float) ((i+1)*0.1), value);
        }
        keyframes[10] = Keyframe.ofFloat(1);
        PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofKeyframe("rotation", keyframes);

        Keyframe scaleKeyframeX0 = Keyframe.ofFloat(0f, 1);
        Keyframe scaleKeyframeX1 = Keyframe.ofFloat(0.1f, 1.5f);
        Keyframe scaleKeyframeX2 = Keyframe.ofFloat(0.9f, 1.5f);
        Keyframe scaleKeyframeX3 = Keyframe.ofFloat(1f, 1);
        PropertyValuesHolder scaleXValuesHolder = PropertyValuesHolder
                .ofKeyframe("scaleX", scaleKeyframeX0, scaleKeyframeX1, scaleKeyframeX2, scaleKeyframeX3);
        PropertyValuesHolder scaleYValuesHolder = PropertyValuesHolder
                .ofKeyframe("scaleY", scaleKeyframeX0, scaleKeyframeX1, scaleKeyframeX2, scaleKeyframeX3);

        ObjectAnimator objectAnimator = ObjectAnimator
                .ofPropertyValuesHolder(this, rotationHolder, scaleXValuesHolder);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }

    /**
     * keyframe设置的插值器只能在两个帧之间作用
     * 至少要有两帧，否则有应用会被崩溃
     */
    private void playByInterpolator() {
        Keyframe keyframe1 = Keyframe.ofFloat(0);
        Keyframe keyframe2 = Keyframe.ofFloat(0.5f, 100f);
        keyframe2.setInterpolator(new BounceInterpolator());
        Keyframe keyframe3 = Keyframe.ofFloat(0.8f,200f);

        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder
                .ofKeyframe("rotation",keyframe1, keyframe2, keyframe3);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, propertyValuesHolder);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }
    @Override
    public void setRotation(float rotation) {
        super.setRotation(rotation);
    }

}
