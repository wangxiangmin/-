package com.bawai.day0321.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bawai.day0321.R;

public class MainActivity extends AppCompatActivity {

    private ImageView image111;
    private int time=7;
    private Handler handler=new Handler();
    private  Runnable runnable=new Runnable() {
        @Override
        public void run() {
            time--;
            if (time>0){
                handler.postDelayed(runnable,1000);

            }else{
                Intent intent=new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image111 = findViewById(R.id.image111);

        handler.post(runnable);
        startanimator();



    }

    private void startanimator() {
        ObjectAnimator translationY = ObjectAnimator.ofFloat(image111, "translationY", 0,300);
        ObjectAnimator jianbian = ObjectAnimator.ofFloat(image111, "Alpha", 1,0);
        ObjectAnimator zhuan = ObjectAnimator.ofFloat(image111, "rotationY", 0,180,-180,0);

        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.play(translationY).with(zhuan).before(jianbian);
        animatorSet.setDuration(5000);
        animatorSet.start();

    }
}
