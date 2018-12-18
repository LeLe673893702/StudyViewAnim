package com.newler.practiceValueAnimator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.TextView;

/**
 * @author newler
 * @what
 * @date 2018/12/11
 */
public class PracticeAnimatorSet extends android.support.v7.widget.AppCompatTextView {
    public PracticeAnimatorSet(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        //playTogether();
        //playSequentially();
//        playAnimBuilder();
        animSetDelay();
    }

    private void init() {
        setBackgroundColor(Color.BLACK);
    }

    /**
     * 先开始第一个动画，知道第一个动画执行结束，才会执行第二个动画
     */
    private void playSequentially() {
        AnimatorSet animationSet = new AnimatorSet();
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(this, "alpha", (float) 0.5, 1);
        alphaAnimator.setStartDelay(2000);
        // 会被覆盖无效
        alphaAnimator.setDuration(2000000);
        ObjectAnimator transAnimator = ObjectAnimator.ofFloat(this, "translationX", 200, 0, 300);
        animationSet.playSequentially(alphaAnimator, transAnimator);
        animationSet.setDuration(10000);
        animationSet.start();
    }

    /**
     * 同时开始执行动画，每个动画按照自己设置执行，不会同时结束动画，
     */
    private void playTogether() {
        AnimatorSet animationSet = new AnimatorSet();
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(this, "alpha", (float) 0.5, 1);
        alphaAnimator.setStartDelay(1000);
        // 如果AnimationSet设置了Duration，同理会被覆盖，否则不会被覆盖
        alphaAnimator.setDuration(20000);
        ObjectAnimator transAnimator = ObjectAnimator.ofFloat(this, "translationX", 200, 0, 300);
        transAnimator.setDuration(1000000);
        animationSet.playTogether(alphaAnimator, transAnimator);
        // 如果没有设置Duration，动画则根据自己设置的Duration执行
        animationSet.setDuration(1000);
        animationSet.start();
    }

    /**
     * AnimatorSet.Builder 可以灵活的控制动画的执行顺序，比如先执行一个动画，再让两个动画同时执行
     */
    private void playAnimBuilder() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(this, "alpha", (float) 0.5, 1);
        ObjectAnimator transAnimator = ObjectAnimator.ofFloat(this, "translationX", 200, 0, 300);

        // 构建builder唯一方法
        AnimatorSet.Builder builder = animatorSet.play(alphaAnimator);
        // 在这个动画执行完之后再执行前一个动画
//        builder.after(transAnimator);
        // 在这个动画执行完之前再执行上一个动画
        builder.before(transAnimator);
        // 两个动画一起执行
//        builder.with(transAnimator);

        animatorSet.setDuration(5000);

        // 还是需要调用start
        animatorSet.start();

    }

    /**
     * setStartDelay：表示延时动画的激活时间，对单个动画延时没有影响
     * 真正激活延时= 延时时间+第一个动画延时时间, 如果使用playWith(A,B)根据传入动画的顺序，来判断是否是第一个动画
     */
    private void animSetDelay() {
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(this, "alpha", (float) 0.5, 1);
        ObjectAnimator transAnimator = ObjectAnimator.ofFloat(this, "translationX", 200, 0, 300);
        alphaAnimator.setStartDelay(5000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(transAnimator,alphaAnimator);
//        animatorSet.play(transAnimator).with(alphaAnimator);
        animatorSet.setStartDelay(2000);
        animatorSet.setDuration(5000);
        animatorSet.start();
    }
}
