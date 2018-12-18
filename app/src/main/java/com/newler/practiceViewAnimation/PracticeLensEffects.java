package com.newler.practiceViewAnimation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;

import com.newler.studyview.R;

/**
 * @author newler
 * @what
 * @date 2018/12/2
 */
public class PracticeLensEffects extends android.support.v7.widget.AppCompatImageView {
    public PracticeLensEffects(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setImageResource(R.mipmap.splash);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 1.2f, 1f, 1.2f,
                50, Animation.RELATIVE_TO_SELF, 50, Animation.RELATIVE_TO_SELF);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(7000);
        scaleAnimation.setInterpolator(new BounceInterpolator());
        startAnimation(scaleAnimation);
    }
}
