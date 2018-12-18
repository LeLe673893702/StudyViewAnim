package com.newler.practiceViewAnimation;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

import com.newler.studyview.R;

/**
 * @author newler
 * @what
 * @date 2018/12/1
 */
public class PracticeInterpolator extends android.support.v7.widget.AppCompatTextView {
    public PracticeInterpolator(Context context) {
        super(context);
        startTranslateAnimByInterpolator(context);
    }

    public PracticeInterpolator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        startTranslateAnimByInterpolator(context);
    }

    /**
     * 动画使用不同插值器动画都固定为duration设置的，动画速率是不同的
     */
    private void startTranslateAnimByInterpolator(Context context) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_practice_translate);
        startAnimation(animation);

        // 开始速率慢，先加速到中间速率最大再减速
        animation.setInterpolator(new AccelerateDecelerateInterpolator());

        // 开始速率慢，一直加速
        animation.setInterpolator(new AccelerateInterpolator());

        // 开始速率快，一直减速
        animation.setInterpolator(new DecelerateInterpolator());

        // 匀速插值器，一直保持匀速
        animation.setInterpolator(new LinearInterpolator());

        // 弹跳加速插值器，小球掉落在地上一样有个回弹的动作
        animation.setInterpolator(new BounceInterpolator());

        // 初始偏移插值器，动画开始会向前偏移一段距离,tension表示向上偏移量，偏移量越大下落速度越快
        animation.setInterpolator(new AnticipateInterpolator(100));

        // 结束偏移插值器，动画结束会沿动画方向继续运动一段激励后再结束动画,tension表示向下偏移量，偏移量越大下落速度越快
        animation.setInterpolator(new OvershootInterpolator(10));

        // 初始和结束插值器，是上述两个的结合体，初始往前偏移，结束往后偏移
        animation.setInterpolator(new AnticipateOvershootInterpolator(5));

        // 循环插值器，速率沿正弦波其曲线改变，cycles表示动画循环次数，如为2即translate动画就是下上下上
        animation.setInterpolator(new CycleInterpolator(2));
    }
}
