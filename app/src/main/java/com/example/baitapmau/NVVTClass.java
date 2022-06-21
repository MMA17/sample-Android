package com.example.baitapmau;

import java.io.Serializable;

public class NVVTClass implements Serializable {
    private String tenNhanVien;
    private String tenViTri;

    public NVVTClass() {
    }

    public NVVTClass(String tenNhanVien, String tenViTri) {
        this.tenNhanVien = tenNhanVien;
        this.tenViTri = tenViTri;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }
}
