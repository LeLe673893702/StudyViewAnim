package com.newler.practiceViewAnimation;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;

import com.newler.studyview.R;

/**
 * @author newler
 * @what
 * @date 2018/12/1
 */
public class PracticeScale extends android.support.v7.widget.AppCompatTextView {
    public PracticeScale(Context context) {
        super(context);
        startScaleAnimByCode(context);
    }

    public PracticeScale(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        startScaleAnimByCode(context);
    }

    private void startScaleAnimByXml(Context context) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_practice_scale);
        startAnimation(animation);
    }

    /**
     * Animation.ABSOLUTE：表示数值50
     * Animation.RELATIVE_TO_SELF 表示50%，相当于自身大小
     * Animation.RELATIVE_TO_PARENT 表示50%p，相当于父控件大小
     */
    private void startScaleAnimByCode(Context context) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 0, 1, 1,
                50, 50, Animation.RELATIVE_TO_SELF, Animation.RELATIVE_TO_PARENT);
        scaleAnimation.setDuration(1000);

    }
}
