package com.newler.practiceValueAnimator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

/**
 * @author newler
 * @what
 * @date 2018/12/8
 */
public class PracticeObjectAnimator extends android.support.v7.widget.AppCompatTextView {
    public PracticeObjectAnimator(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setBackgroundColor(Color.BLACK);
        startScale();
    }

    /**
     * target表示动画应用的控件对象
     * propertyName 表示属性名对应控件set函数
     * values 表示变化的值对应控件set函数的值类型
     */
    private void startAnimRotation() {
        //propertyName是根据控件的set函数找的 比如setRotation();
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(this, "rotation", 0, 180,0);
        rotationAnimator.setDuration(5000);
        rotationAnimator.start();
    }

    /**
     * 根据控件的set函数，对应控件的setTranslationX
     */
    private void startAnimTranslation() {
        ObjectAnimator translationAnim = ObjectAnimator.ofFloat(this, "translationX", 0, 180, 0);
        translationAnim.setDuration(5000);
        translationAnim.start();
    }

    /**
     * 对应控件的setScaleY
     */
    private void startScale() {
        ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(this, "scaleY", 0, 3, 1);
        scaleAnim.setDuration(5000);
        scaleAnim.start();
    }

 }
