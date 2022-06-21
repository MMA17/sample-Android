package com.example.baitapmau;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class NhanVienViTriDAO extends SQLiteOpenHelper {
    private static final String DATABASE = "database.db";
    private static final String TABLE = "nhanvienvitri";
    private static final String KEY_IDNV = "idnv";
    private static final String KEY_IDVT = "idvt";

    public NhanVienViTriDAO(@Nullable Context context) {
        super(context, DATABASE, null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE nhanvienvitri (idnv integer, idvt integer)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS nhanvienvitri";
        onCreate(sqLiteDatabase);
    }

    public void create() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS nhanvienvitri (idnv integer, idvt integer)");
    }

    public boolean addNhanVienViTri(int idnv, int idvt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_IDNV, idnv);
        cv.put(KEY_IDVT, idvt);
        long res = db.insert(TABLE,null , cv);
        if (res == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public List<NVVTClass> getallNVVT() {
        List<NVVTClass> listNVVT = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM nhanvienvitri, nhanvien, vitri WHERE nhanvienvitri.idnv = nhanvien.id AND nhanvienvitri.idvt = vitri.id";
        Cursor c = db.rawQuery(sql,null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            NVVTClass nv = new NVVTClass();
            nv.setTenNhanVien(c.getString(3));
            nv.setTenViTri(c.getString(8));
            listNVVT.add(nv);
            c.moveToNext();
        }
        return listNVVT;
    }
}
