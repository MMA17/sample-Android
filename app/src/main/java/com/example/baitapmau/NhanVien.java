package com.example.baitapmau;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private int id;
    private String ten;
    private String dob;
    private String QueQuan;
    private String trinhdo;

    public  NhanVien() {

    };

    public NhanVien(int id, String ten, String dob, String queQuan, String trinhdo) {
        this.id = id;
        this.ten = ten;
        this.dob = dob;
        this.QueQuan = queQuan;
        this.trinhdo = trinhdo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String queQuan) {
        QueQuan = queQuan;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }
}
