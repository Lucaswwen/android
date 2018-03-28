package com.example.donghua;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ImageView imageView = findViewById(R.id.iv);
        Button button = findViewById(R.id.kaishi);
        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Animation animation
//                        = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_alpha);
//                imageView.startAnimation(animation);
//            }

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_right_in,R.anim.anim_left_out);
            }
        });
//        ImageView imageView = findViewById(R.id.iv);
//        AnimationDrawable drawable = (AnimationDrawable)imageView.getDrawable();
//        drawable.start();
//        AnimationDrawable drawable = new AnimationDrawable();
//        for (int i=0;i<7;i++){
//            int id = getResources().getIdentifier("x"+i,"drawable",getPackageName());
//            drawable.addFrame(getResources().getDrawable(id),90);
//        }
//        ImageView imageView = findViewById(R.id.iv);
//        imageView.setImageDrawable(drawable);
//        drawable.start();
    }
}
