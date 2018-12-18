package com.newler.practiceViewAnimation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.newler.studyview.R;

/**
 * @author newler
 * @what
 * @date 2018/12/3
 */
public class PracticeRipple extends FrameLayout {

    public PracticeRipple(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        for (int i = 0; i < 3; i++) {
            addImageView(30 * 2 * (i+1), i);
        }
        ImageView imageView = new ImageView(getContext());
        LayoutParams layoutParams = new LayoutParams(280, 280);
        layoutParams.gravity = Gravity.CENTER;
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.mipmap.music);
        addView(imageView);

    }

    private void addImageView(int margin, int offest) {
        LayoutParams layoutParams = new LayoutParams(280, 280);
        layoutParams.setMargins(margin, margin, margin, margin);
        layoutParams.gravity = Gravity.CENTER;
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.ic_circle_music);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setDuration(6000);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 3f, 1f, 3f,
                 Animation.RELATIVE_TO_SELF, 0.5f, AnimationSet.RELATIVE_TO_SELF,0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.4f, 0f);
        animationSet.setStartOffset(600 * offest);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        imageView.startAnimation(animationSet);
        addView(imageView);
    }

}
