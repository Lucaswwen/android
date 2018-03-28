package com.example.ziyuan2;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        iv = findViewById();

    }

    private class MyListener implements View.OnClickListener{
        private int id;
        MyListener(int id){
            this.id = id;
        }

        @Override
        public void onClick(View e){

        }

        /**
         * 绘制
         * */
        public void drawLine(){
            //图形对象
            Bitmap bitmap = Bitmap.createBitmap(400,400,Bitmap.Config.ARGB_8888);
            //画布
            Canvas canvas = new Canvas(bitmap);
            //画笔
            Paint paint = new Paint();
            //打开抗锯齿
            paint.setAntiAlias(true);
            //设置线宽
            paint.setStrokeWidth(50);
            //颜色
            paint.setColor(Color.parseColor("#00ff00"));
            //线帽
            paint.setStrokeCap(Paint.Cap.BUTT);
            //绘制
            canvas.drawLine(100,100,300,100,paint);
        }

        private void drawPath(){
            //图形对象
            Bitmap bitmap = Bitmap.createBitmap(400,400,Bitmap.Config.ARGB_8888);
            //画布
            Canvas canvas = new Canvas(bitmap);
            //画笔
            Paint paint = new Paint();
            //打开抗锯齿
            paint.setAntiAlias(true);
            //设置线宽
            paint.setStrokeWidth(50);
            //颜色
            paint.setColor(Color.parseColor("#00ff00"));
            //线帽
            paint.setStrokeCap(Paint.Cap.BUTT);

            //折角风格 ROUND圆角 MITER 直角  BEVE直线
            paint.setStrokeJoin(Paint.Join.ROUND);

            //画笔风格
            //stroke 只绘制轮廓
            //FILL 只内部填充
            //FILL_AND_STROKE
            Path path = new Path();
            path.moveTo(100,100);
            path.lineTo(200,200);
            path.lineTo(300,100);
            //绘制路径
            canvas.drawPath(path,paint);
        }

        /**
         * 绘制带效果的折线
         * */
        public void draw(){
            //图形对象
            Bitmap bitmap = Bitmap.createBitmap(400,400,Bitmap.Config.ARGB_8888);
            //画布
            Canvas canvas = new Canvas(bitmap);
            //画笔
            Paint paint = new Paint();
            //打开抗锯齿
            paint.setAntiAlias(true);
            //设置线宽
            paint.setStrokeWidth(50);
            //颜色
            paint.setColor(Color.parseColor("#00ff00"));
            //线帽
            paint.setStrokeCap(Paint.Cap.BUTT);
            paint.setStyle(Paint.Style.STROKE);


            //1虚线
            paint.setPathEffect(new DashPathEffect(new float[] {10,15},10));
            //2圆滑
            paint.setPathEffect(new CornerPathEffect(50));
            //3锯齿
            paint.setPathEffect(new DiscretePathEffect(10,10));

            Path path = getPath();
            canvas.drawPath(path,paint);
        }

        private Path getPath(){
            Path path = new Path();
            path.moveTo(0,0);
            for (int i = 1;i<=50;++i){
                path.lineTo(20*i,(float)((Math.random()*50*i)%200));
            }
            return path;
        }
        /**
         * 加载assets资源
         * */
        public void loadAssetsImage(){
            AssetManager manager = getAssets();
            try{
                InputStream strem = manager.open("123.jpg");
                Bitmap bitmap = BitmapFactory.decodeStream(strem);
                strem.close();
                iv.setImageBitmap(bitmap);
            }catch(Exception e){

            }
        }
    }
}
