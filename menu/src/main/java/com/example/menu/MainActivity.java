package com.example.menu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPopWin = findViewById(R.id.btn_popupwindow);
        btnPopWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View popWindowView = getLayoutInflater()
                        .inflate(R.layout.layout_popupmenu,null);
                PopupWindow popupWindow = new PopupWindow
                        (popWindowView,dp2px(getApplicationContext(),100),
                                dp2px(getApplicationContext(),100),
                                true);
                popupWindow.showAsDropDown(v);

            }
        });

        //弹出菜单
        Button btnPop = findViewById(R.id.btn_popupmenu);
        btnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),v);
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu_item,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.popupmenu_item_1:
                                Toast.makeText(getApplicationContext(),
                                        "弹出菜单选项一",Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.popupmenu_item_2:
                                Toast.makeText(getApplicationContext(),
                                        "弹出菜单选项二",Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return false;
                    }
                });
            }
        });

        EditText et = findViewById(R.id.eidttext_resource);
        TextView tv = findViewById(R.id.textview_copy);
        registerForContextMenu(et);
        registerForContextMenu(tv);
    }

    private  int dp2px(Context context,float dpValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ClipboardManager cm=
                (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        switch (item.getItemId()){
            case R.id.contextmenu_copy:
                EditText et = findViewById(R.id.eidttext_resource);
                String strMsg = et.getText().toString();
                ClipData clipData = ClipData.newPlainText("test",strMsg);
                cm.setPrimaryClip(clipData);
                return true;
            case R.id.contextmenu_paste:
                String strPaste = cm.getPrimaryClip().getItemAt(0).getText().toString();
                TextView tv = findViewById(R.id.textview_copy);
                tv.setText(strPaste);
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.optionmenu_item_1:
                Toast.makeText(this,"第一个选项",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.optionmenu_item_2:
                Toast.makeText(this,"第二个选项",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.optionmenu_subitem_1:
                Toast.makeText(this,"子菜单第一个选项",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.optionmenu_subitem_2:
                Toast.makeText(this,"子菜单第二个选项",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
