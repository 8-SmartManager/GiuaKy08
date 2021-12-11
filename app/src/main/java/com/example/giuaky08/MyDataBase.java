package com.example.giuaky08;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBase  extends SQLiteOpenHelper {
    public  static  final int DB_VERSION =1;
    public  static  final String DB_NAME="product.sqlite";
    public  static  final String TBL_NAME= "Product";
    public  static  final String COL_W_ID= "wId";
    public  static  final String COL_W_NAME= "wName";
    public  static  final String COL_W_DES= "wDes";
    public  static  final String COL_W_IMAGE= "wImage";
    public MyDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE IF NOT EXISTS "+TBL_NAME + "("+ COL_W_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_W_IMAGE+" INT,"+
                COL_W_NAME+" VARCHAR(100), "+COL_W_DES+ " VARCHAR(200)) ";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TBL_NAME);
        onCreate(sqLiteDatabase);

    }
    public void  queryExec(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase db= getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    public void  execSql(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
}
