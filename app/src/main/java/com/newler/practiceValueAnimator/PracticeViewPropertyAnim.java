package com.newler.practiceValueAnimator;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * @author newler
 * @what
 * @date 2018/12/15
 */
public class PracticeViewPropertyAnim extends android.support.v7.widget.AppCompatTextView {
    public PracticeViewPropertyAnim(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.BLACK);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });
    }

    public void play() {
        animate().scaleX(1.5f).scaleXBy(1.5f).rotation(100).rotationBy(200).setDuration(3000).start();
    }
}
