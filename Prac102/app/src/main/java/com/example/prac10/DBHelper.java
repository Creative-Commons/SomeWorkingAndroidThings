package com.example.prac10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_Name = "employee.db";
    public static final String TB_Name = "emp";
    public static final String COL_1 = "name";
    public static final String COL_2 = "password";

    public DBHelper(@Nullable Context context){
        super(context, DB_Name, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table emp(name text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists emp");
        onCreate(db);
    }

    public Cursor showData(){
        Cursor res = getWritableDatabase().rawQuery("select * from emp", null);
        return res;
    }

    public boolean insertData(String name, String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1, name);
        cv.put(COL_2, password);
        long i = db.insert(TB_Name, null, cv);

        if(i == 0){
            return false;
        } else{
            return  true;
        }
    }

    public boolean updateData(String name, String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1, name);
        cv.put(COL_2, password);
        db.update(TB_Name, cv, "name=?", new String[]{name});
        return true;
    }

    public boolean deleteData(String name, String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1, name);
        cv.put(COL_2, password);
        int i = db.delete(TB_Name, "name=?", new String[] {name});
        if(i >= 0){
            return true;
        } else{
            return false;
        }
    }
}
