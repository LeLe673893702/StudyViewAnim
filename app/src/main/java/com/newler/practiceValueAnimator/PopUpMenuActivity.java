package com.newler.practiceValueAnimator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.newler.studyview.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PopUpMenuActivity extends AppCompatActivity {
    private ImageView iv1, iv2, iv3, iv4, iv5, ivBase;
    private int radius = 10000;
    private int[] location = new int[2];

    private List<ImageView> menus = new ArrayList<>(5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_menu);
        ivBase = findViewById(R.id.ivMenuBase);
        iv1 = findViewById(R.id.ivMenu1);
        iv2 = findViewById(R.id.ivMenu2);
        iv3 = findViewById(R.id.ivMenu3);
        iv4 = findViewById(R.id.ivMenu4);
        iv5 = findViewById(R.id.ivMenu5);
        menus.add(iv1);
        menus.add(iv2);
        menus.add(iv3);
        menus.add(iv4);
        menus.add(iv5);

        init();
    }

    private void init() {
        ivBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLayout();
                popUp();
            }
        });
    }

    private void popUp() {
        AnimatorSet animatorSet = new AnimatorSet();
        Collection<Animator> objectAnimators = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (menus.get(i).getVisibility() != View.VISIBLE) {
                menus.get(i).setVisibility(View.VISIBLE);
            }
            objectAnimators.add(getTranslateXAnim(menus.get(i), i));
            objectAnimators.add(getTranslateYAnim(menus.get(i), i));
            objectAnimators.add(getAlphaAnim(menus.get(i)));
            objectAnimators.add(getScaleXAnim(menus.get(i)));
            objectAnimators.add(getScaleYAnim(menus.get(i)));
        }
        animatorSet.playTogether(objectAnimators);
        animatorSet.setDuration(5000);
        animatorSet.start();
    }

    private ObjectAnimator getTranslateXAnim(ImageView iv, int num) {
        return ObjectAnimator.ofFloat(iv,
                "translationX",
                0, (float)-getMoveX(num));
    }

    private ObjectAnimator getTranslateYAnim(ImageView iv,  int num) {
        return ObjectAnimator.ofFloat(iv,
                "translationY",
                0, (float)-getMoveY(num));
    }

    private ObjectAnimator getAlphaAnim(ImageView iv) {
        return ObjectAnimator.ofFloat(iv, "alpha", 0, 1);
    }

    private ObjectAnimator getScaleXAnim(ImageView iv) {
        return ObjectAnimator.ofFloat(iv, "scaleX", 0F, 1F);
    }

    private ObjectAnimator getScaleYAnim(ImageView iv) {
        return ObjectAnimator.ofFloat(iv, "scaleY", 0F, 1F);
    }

    private double getMoveX(int num) {
        double moveX = radius * Math.toRadians(Math.sin(Math.PI/8.0 * num));
        Log.e("getMoveX",moveX+"");

        return moveX ;
    }

    private double getMoveY(int num) {
        double moveY = radius * Math.toRadians(Math.cos(Math.PI/8.0 * num));
        Log.e("getMoveY",moveY+"");

        return moveY;
    }

    private void getLayout() {
        location = new int[2];
        ivBase.getLocationInWindow(location);
        ivBase.getLocationOnScreen(location);
    }

}
