package com.example.crudsv.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper  extends SQLiteOpenHelper {
    public static final String DB_NAME = "HAnh";
    public static final int DB_VERSION = 4;

    public DBHelper( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql1 = "CREATE TABLE Computer(idCom TEXT primary key, name TEXT not null)";
        String sql2 = "CREATE TABLE Category(idCate TEXT primary key, idCom TEXT not null, Des TEXT not null)";
        sqLiteDatabase.execSQL(sql1);
        sqLiteDatabase.execSQL(sql2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            String sql1 = " DROP TABLE IF EXISTS Computer";
            String sql2 = " DROP TABLE IF EXISTS Category";
            sqLiteDatabase.execSQL(sql1);
            sqLiteDatabase.execSQL(sql2);
            onCreate(sqLiteDatabase);
    }
}
