package com.example.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 王伟健 on 2018-03-16.
 */

public class MyButton extends android.support.v7.widget.AppCompatButton {
    public MyButton(Context context,AttributeSet attrs){
        super(context,attrs);
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("Mybutton", "按下了.....");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("Mybutton", "动了.....");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("Mybutton", "起来了.....");
                break;
        }
        return false;
    }
}
