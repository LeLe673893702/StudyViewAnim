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
public class PracticeRotate extends android.support.v7.widget.AppCompatTextView {
    public PracticeRotate(Context context) {
        super(context);
    }

    public PracticeRotate(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        startRotateAnimByCode(context);
        startRotateAnimByXml(getContext());
    }

    private void startRotateAnimByXml(Context context) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_practice_rotate);
        startAnimation(animation);
    }

    private void startRotateAnimByCode(Context context) {

    }
}
