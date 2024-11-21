/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Class_model {
    String maSinhVien;
    String hoTen;
    String lopHoc; 
    String monHoc;
    int soTinChi;
    int soTietNghi; 
    float tiLeNghi;

    public Class_model(String maSinhVien, String hoTen, String lopHoc, String monHoc, int soTinChi, int soTietNghi, float tiLeNghi) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.lopHoc = lopHoc;
        this.monHoc = monHoc;
        this.soTinChi = soTinChi;
        this.soTietNghi = soTietNghi;
        this.tiLeNghi = tiLeNghi;
    }

    
    
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public int getSoTietNghi() {
        return soTietNghi;
    }

    public void setSoTietNghi(int soTietNghi) {
        this.soTietNghi = soTietNghi;
    }

    public float getTiLeNghi() {
        return tiLeNghi;
    }

    public void setTiLeNghi(float tiLeNghi) {
        this.tiLeNghi = tiLeNghi;
    }
}
