package com.example.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_select = findViewById(R.id.select);
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = SQLiteDatabase
                        .openOrCreateDatabase("/data/data/com.example.db/database/mydb.db",null);
//                Cursor cursor = db.query("COMPANY",null,null,
//                        null,null,
//                        null,null,
//                        null);
                Cursor cursor = db.rawQuery("SELECT * FROM COMPANY",null);

                if (cursor.moveToFirst()){
                    do {
                        //处理游标当前所在的位置
                        int id = cursor.getInt(cursor.getColumnIndex("ID"));

                    }while (cursor.moveToFirst());
                }

                db.close();
            }
        });

        Button btn_updata = findViewById(R.id.update);
        btn_updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = SQLiteDatabase
                        .openOrCreateDatabase("/data/data/com.example.db/database/mydb.db",null);
                ContentValues contentValues = new ContentValues();
                contentValues.put("NAME","xiaoli");
                db.update("COMPANY",contentValues,"id=?",new String[]{"1"});
                db.close();
            }
        });

        Button btn_delete = findViewById(R.id.delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = SQLiteDatabase
                        .openOrCreateDatabase("/data/data/com.example.db/database/mydb.db",null);
                String [] whereArgs = {"xiaoli"};

                db.delete("COMPANY","NAME=?",whereArgs);
                db.close();
            }
        });

        Button btn_insert2 = findViewById(R.id.insert2);
        btn_insert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("NAME","xiaoli");
                contentValues.put("AGE",45);
                contentValues.put("ADDRESS","SHIJIAZHUANG");
                contentValues.put("SALARY",123);
                //打开数据库
                SQLiteDatabase db = SQLiteDatabase
                        .openOrCreateDatabase("/data/data/com.example.db/database/mydb.db",null);
                db.insert("COMPANY",null,contentValues);
                db.close();
            }
        });


        Button btn_insert = findViewById(R.id.insert);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sql = "INSERT INTO COMPANY"+
                        "(NAME,AGE,ADDRESS,SALARY)"
                        +"VALUES('xiaozhao','20','shijiazhuang',123.4)";
                //打开数据库
                SQLiteDatabase db = SQLiteDatabase
                        .openOrCreateDatabase("/data/data/com.example.db/database/mydb.db",null);
                db.execSQL(sql);
                db.close();
            }
        });

        Button btn_create_table = findViewById(R.id.createtable);
        btn_create_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        String sql = "CREATE TABLE COMPANY("+
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        "NAME TEXT NOT NULL,"+
                        "AGE TEXT NOT NULL,"+
                        "ADDRESS CHAR(50),SALARY REAL"
                        +")";
                //打开数据库
                SQLiteDatabase db = SQLiteDatabase
                        .openOrCreateDatabase("/data/data/com.example.db/database/mydb.db",null);
                db.execSQL(sql);
                db.close();
            }
        });


        Button btn = findViewById(R.id.createdb);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建路径
                String path = "/data/data/"
                        +MainActivity.this.getPackageName()
                        +"/database/";
                File dir = new File(path);
                if (!dir.exists()){
                    dir.mkdirs();
                }
                //创建数据库
                SQLiteDatabase db = SQLiteDatabase
                         .openOrCreateDatabase("/data/data/com.example.db/database/mydb.db",null);
            }
        });
    }
}
