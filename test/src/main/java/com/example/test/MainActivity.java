package com.example.test;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button insert = findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver resolver = getContentResolver();
                Uri uri = Uri.parse("content://com.example.db/companies");
                ContentValues contentValues = new ContentValues();
                contentValues.put("NAME","小阿三");
                contentValues.put("AGE",13);
                resolver.insert(uri,contentValues);

            }
        });

        Button query_one = findViewById(R.id.query_one);
        query_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver resolver = getContentResolver();
                Uri uri = Uri.parse("content://com.example.db/company/1");
                Cursor cursor = resolver.query(uri,null,null,null
                                         ,null);
                if (cursor.moveToFirst()){
                    do {
                        //处理游标当前所在的位置
                        int id = cursor.getInt(cursor.getColumnIndex("ID"));

                    }while (cursor.moveToFirst());
                }
            }
        });

        Button query_all = findViewById(R.id.query_all);
        query_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver resolver = getContentResolver();
                Uri uri = Uri.parse("content://com.example.db/companies");
                Cursor cursor = resolver.query(uri,null,null,null
                        ,null);
                if (cursor.moveToFirst()){
                    do {
                        //处理游标当前所在的位置
                        int id = cursor.getInt(cursor.getColumnIndex("ID"));

                    }while (cursor.moveToFirst());
                }
            }
        });
    }
}
