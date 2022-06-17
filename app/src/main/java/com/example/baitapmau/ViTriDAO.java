package com.example.baitapmau;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ViTriDAO extends SQLiteOpenHelper {
    private static final String DATABASENAME = "database.db";
    private static final String TABLENAME = "vitri";
    private static final String KEY_ID = "id";
    private static final String KEY_TEN = "ten";
    private static final String KEY_MOTA = "mota";


    public ViTriDAO(Context context) {
        super(context, DATABASENAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLENAME + "(id integer PRIMARY KEY AUTOINCREMENT, ten text, mota text)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
        onCreate(sqLiteDatabase);
    }

    public List<ViTri> getAllVitri() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLENAME, null);
        c.moveToFirst();
        List<ViTri> res = new ArrayList<>();

        while (c.isAfterLast() == false) {
            ViTri nv = new ViTri(c.getInt(0), c.getString(1), c.getString(2));
            res.add(nv);
            c.moveToNext();
        }
        return res;
    }

    public boolean addViTri (ViTri vt) {
        SQLiteDatabase db2 = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_TEN, vt.getTen());
        cv.put(KEY_MOTA, vt.getMoTa());
        long res = db2.insert(TABLENAME,null, cv);
        if (res == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
