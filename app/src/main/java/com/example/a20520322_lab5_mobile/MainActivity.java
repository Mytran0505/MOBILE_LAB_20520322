package com.example.a20520322_lab5_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode, btnBlinkXml,
            btnBlinkCode, btnZoomInXml, btnZoomInCode, btnZoomOutXml, btnZoomOutCode, btnRotateXml,
            btnRotateCode, btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode, btnBounceXml,
            btnBounceCode, btnCombineXml, btnCombineCode;
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;
    private void findViewsByIds() {
        ivUitLogo = (ImageView) findViewById(R.id.iv_uit_logo);
        btnFadeInXml = (Button) findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = (Button) findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = (Button) findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = (Button) findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = (Button) findViewById(R.id.btn_blink_xml);
        btnBlinkCode = (Button) findViewById(R.id.btn_blink_code);
        btnZoomInXml = (Button) findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = (Button) findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = (Button) findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = (Button) findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = (Button) findViewById(R.id.btn_rotate_xml);
        btnRotateCode = (Button) findViewById(R.id.btn_rotate_code);
        btnMoveXml = (Button) findViewById(R.id.btn_move_xml);
        btnMoveCode = (Button) findViewById(R.id.btn_move_code);
        btnSlideUpXml = (Button) findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = (Button) findViewById(R.id.btn_slide_up_code);
        btnBounceXml = (Button) findViewById(R.id.btn_bounce_xml);
        btnBounceCode = (Button) findViewById(R.id.btn_bounce_code);
        btnCombineXml = (Button) findViewById(R.id.btn_combine_xml);
        btnCombineCode = (Button) findViewById(R.id.btn_combine_code);
    }
    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };
    }
    private void handleClickAnimationXml(Button btn, int animId)
    {
        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, animId);
        animation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivUitLogo.startAnimation(animation);
            }
        });
    }
    private void handleClickAnimationCode(Button btn, final Animation animation) {

        // Handle onclickListenner to start animation
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });

    }

    private Animation initFadeInAnimation(){
        Animation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initFadeOutAnimation(){
        AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
        fadeOut.setDuration(800);
        fadeOut.setFillAfter(true);
        return fadeOut;
    }

    private Animation initBlinkAnimation(){
        ScaleAnimation blink = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        blink.setDuration(300);
        blink.setRepeatMode(Animation.REVERSE);
        blink.setRepeatCount(3);
        blink.setAnimationListener(animationListener);
        return blink;
    }
    private Animation initZoomInAnimation()
    {
        Animation animation = new ScaleAnimation(
                1f, 3f,
                1f, 3f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(1000);
        return animation;
    }
    private Animation initZoomOutAnimation()
    {
        Animation animation = new ScaleAnimation(
                1f, 0.5f,
                1f, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(1000);
        return animation;
    }
    private Animation initRotateAnimation()
    {
        RotateAnimation animation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        animation.setRepeatMode(Animation.RESTART);
        animation.setRepeatCount(2);
        animation.setDuration(600);
        return animation;
    }
    private Animation initMoveAnimation()
    {
        TranslateAnimation animation = new TranslateAnimation(0f, 1000f, 0f, 0f);
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private static Animation initSlideUpAnimation() {
        Animation animation = new ScaleAnimation(1f, 1f, 1f, 0f);
        animation.setFillAfter(true);
        animation.setDuration(500);
        return animation;
    }
    private Animation initBounceAnimation() {
        Animation animation = new ScaleAnimation(1f, 1f, 0f, 1f);
        animation.setFillAfter(true);
        animation.setDuration(500);
        animation.setInterpolator(new BounceInterpolator());
        return animation;
    }

    private AnimationSet initCombineAnimation() {
        AnimationSet animationSet = new AnimationSet(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1f, 3f,
                1f, 3f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(4000);

        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setRepeatMode(Animation.RESTART);
        rotateAnimation.setRepeatCount(2);
        rotateAnimation.setDuration(500);

        animationSet.setFillAfter(true);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);

        return animationSet;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view;
        findViewsByIds();
        initVariables();

        //handleClickAnimationXml
        handleClickAnimationXml(btnFadeInXml, R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml, R.anim.anim_fade_out);
        handleClickAnimationXml(btnBlinkXml, R.anim.anim_blink);
        handleClickAnimationXml(btnZoomInXml, R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml, R.anim.anim_zoom_out);
        handleClickAnimationXml(btnRotateXml, R.anim.anim_rotate);
        handleClickAnimationXml(btnMoveXml, R.anim.anim_move);
        handleClickAnimationXml(btnSlideUpXml, R.anim.anim_slide_up);
        handleClickAnimationXml(btnBounceXml, R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml, R.anim.anim_combine);

        //handleClickAnimationCode
        handleClickAnimationCode(btnFadeInCode, initFadeInAnimation());
        handleClickAnimationCode(btnFadeOutCode, initFadeOutAnimation());
        handleClickAnimationCode(btnBlinkCode, initBlinkAnimation());
        handleClickAnimationCode(btnZoomInCode, initZoomInAnimation());
        handleClickAnimationCode(btnZoomOutCode, initZoomOutAnimation());
        handleClickAnimationCode(btnRotateCode, initRotateAnimation());
        handleClickAnimationCode(btnMoveCode, initMoveAnimation());
        handleClickAnimationCode(btnSlideUpCode, initSlideUpAnimation());
        handleClickAnimationCode(btnBounceCode, initBounceAnimation());
        handleClickAnimationCode(btnCombineCode, initCombineAnimation());

        ivUitLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNewActivity = new Intent(MainActivity.this, NewActivity.class);
                startActivity(iNewActivity);
                overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out);
            }
        });
        StartAct = 1;
        if (savedInstanceState == null) // 1st time
        {
            this.overridePendingTransition(R.anim.anim_slide_in_left,
                    R.anim.anim_slide_out_left);
        } else
        {
            StartAct = 2;
        }
    }
    int StartAct = 0;
    @Override
    protected void onStart() {
        super.onStart();
        if (StartAct > 1) {
            this.overridePendingTransition(R.anim.anim_slide_in_right,
                    R.anim.anim_slide_out_right);

        } else if (StartAct == 1) {
            StartAct++;
        }
    }
}