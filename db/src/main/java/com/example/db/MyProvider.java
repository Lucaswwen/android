package com.example.db;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by 王伟健 on 2018-04-03.
 */

public class MyProvider extends ContentProvider {

    private SQLiteDatabase db;
    private UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
    private final int COMPANY = 1;
    private final int COMPANIES = 2;
    private final int COMPANYADD = 3;

    @Override
    public boolean onCreate() {
        matcher.addURI("com.example.db",
                "company/#",COMPANY);
        matcher.addURI("com.example.db","companies",COMPANIES);

        //打开数据库
        db = SQLiteDatabase.openOrCreateDatabase("/data/data/com.example.db/database/mydb.db",
                null);
        Log.e("db","数据库被打开");

        return true;
    }

    @Nullable
    @Override
    public Cursor query(
                        //
                        @NonNull Uri uri,
                        @Nullable String[] projection,
                        @Nullable String selection,
                        @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {
        switch (matcher.match(uri)){
            case COMPANY:
                long id = ContentUris.parseId(uri);
                String where = "where" + id;
                if (selection!=null && !selection.equals("")){
                    where = where + " and " + selection;
                }
                return db.query("COMPANY",projection,where,selectionArgs,
                        null,null,sortOrder);
            case COMPANIES:
                return db.query("COMPANY",projection,selection,selectionArgs,
                        null,null,sortOrder);
            default:
                throw new IllegalArgumentException("未知的Uri"+uri);
        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        switch (matcher.match(uri)){
            case COMPANIES:
                long id = db.insert("COMPANY",null,values);
                if (id>0){
                    Uri uri1 = Uri.parse("content://com.example.db/company/"+id);
                }
                return null;
            default:
                throw new IllegalArgumentException("未知的Uri"+uri);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
