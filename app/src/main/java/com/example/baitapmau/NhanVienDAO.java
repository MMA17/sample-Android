package com.example.baitapmau;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "database.db";
    private static final String TABLE_NAME = "nhanvien";
    private static final String KEY_ID = "id";
    private static final String KEY_TEN = "ten";
    private static final String KEY_DOB = "dob";
    private static final String KEY_QUEQUAN = "quequan";
    private static final String KEY_TRINHDO = "trinhdo";


    public NhanVienDAO(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( id integer PRIMARY KEY AUTOINCREMENT, ten text, dob text, quequan text, trinhdo text)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void create() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS nhanvien (id integer PRIMARY KEY AUTOINCREMENT, ten text, dob text, quequan text, trinhdo text)");
    }

    public List<NhanVien> getAllNhanVien() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        c.moveToFirst();
        List<NhanVien> res = new ArrayList<>();

        while (c.isAfterLast() == false) {
            NhanVien nv = new NhanVien(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
            res.add(nv);
            c.moveToNext();
        }
        c.close();
        db.close();
        return res;
    }

    public boolean addNhanVien(NhanVien nv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_TEN, nv.getTen());
        cv.put(KEY_DOB, nv.getDob());
        cv.put(KEY_QUEQUAN, nv.getQueQuan());
        cv.put(KEY_TRINHDO, nv.getTrinhdo());
        long res = db.insert(TABLE_NAME,null, cv);
        db.close();
        if (res == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public List<NhanVien> getNV1995() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<NhanVien> res = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien WHERE dob = '1995' AND ten = 'Nam'";
        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            NhanVien nv = new NhanVien(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
            res.add(nv);
            c.moveToNext();
        }
        c.close();
        return res;
    }
}
