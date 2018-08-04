package com.example.rawan.charities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rawan on 8/2/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
public static final String db_name="charity";
    public static final String table_name="charities";
    public static final String id="id";
    public static final String name="name";
    public static final String type="type";
    public static final String descc="descc";
    public static final String pic="pic";

    public DatabaseHelper(Context context) {
        super(context, db_name, null, 1);
    }
  /*  public void Delete_Bus()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM charities");
    }*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create TABLE "+table_name+"(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,type TEXT,descc TEXT,pic TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


    }
    public boolean insertData(String namee,String typee, String dess, String piic) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(name,namee);
        contentValues.put(type,typee);
        contentValues.put(descc,dess);
        contentValues.put(pic,piic);
        long result = db.insert(table_name,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+table_name,null);
        return res;
    }
}
