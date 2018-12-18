package com.newler.practiceViewAnimation;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.newler.studyview.R;

/**
 * @author newler
 * @what
 * @date 2018/12/1
 */
public class PracticeAlpha extends android.support.v7.widget.AppCompatTextView {
    public PracticeAlpha(Context context) {
        super(context);
    }

    public PracticeAlpha(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        startScaleAnimByXml(context);
    }

    private void startScaleAnimByXml(Context context) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_practice_alpha);
        startAnimation(animation);
    }


}
