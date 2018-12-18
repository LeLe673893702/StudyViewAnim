package com.newler.practiceViewAnimation;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.newler.studyview.R;

/**
 * @author newler
 * @what
 * @date 2018/12/1
 */
public class PracticeTranslate extends android.support.v7.widget.AppCompatTextView {
    public PracticeTranslate(Context context) {
        super(context);
        startTranslateAnim(context);
    }

    public PracticeTranslate(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        startTranslateAnim(context);
        setBackgroundColor(Color.BLACK);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startTranslateAnim(Context context) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_practice_translate);
        startAnimation(animation);
    }

}
