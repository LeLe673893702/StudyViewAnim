package com.newler.practiceValueAnimator;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.newler.studyview.ScreenUtil;

/**
 * @author newler
 * @what
 * @date 2018/12/15
 */
public class PracticeLayoutTransition extends LinearLayout {
    public PracticeLayoutTransition(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                addView(getButton());
            }
        });
    }

   private void init() {
       LayoutTransition layoutTransition = new LayoutTransition();
       ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(null, "rotation", 0, 90f, 0);
      // 这里设置的动画时长是不起作用的
       objectAnimator.setDuration(100000);
       layoutTransition.setAnimator(LayoutTransition.APPEARING ,objectAnimator);
       // 动画持续时间以这个为准
       layoutTransition.setDuration(2000);
       setLayoutTransition(layoutTransition);


    }

    private Button getButton() {
        Button button = new Button(getContext());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(ScreenUtil.dip2px(getContext(),50),
                ScreenUtil.dip2px(getContext(), 80));
        button.setLayoutParams(layoutParams);
        button.setText("button");
        button.setBackgroundColor(Color.RED);
        return button;
    }
}
