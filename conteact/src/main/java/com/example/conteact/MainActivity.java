package com.example.conteact;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSelect = findViewById(R.id.readcontacts);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver resolver = getContentResolver();
                Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI,
                        null,null,null,null);
                if (cursor.moveToFirst()){
                    do{
                        StringBuffer stringBuffer = new StringBuffer();
                        //获取ID
                        int indexId = cursor.getColumnIndex(ContactsContract.Contacts._ID);
                        String strId  = cursor.getString(indexId);
                        //获取姓名
                        int indexName = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                        String strName  = cursor.getString(indexName);
                        stringBuffer.append(strId+"-"+strName+"\t");
                        //根据ID获取电话号
                        Cursor cursorPhone = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                                +"=" + strId,
                                null,null);
                        if (cursorPhone.moveToFirst()){
                            do {
                                int indexPhonenum = cursorPhone.
                                        getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                                String phonenum = cursorPhone.getString(indexPhonenum);
                                stringBuffer.append(phonenum+"|");
                            }while (cursorPhone.moveToNext());
                        }

                        Log.e("Data",stringBuffer.toString());
                    }while (cursor.moveToNext());
                }
            }

        });
    }
}
