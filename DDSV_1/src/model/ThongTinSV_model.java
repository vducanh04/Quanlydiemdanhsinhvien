/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class ThongTinSV_model {
    String hoTen;
    String lopHoc;
    String monHoc;
    int soTinChi;
    String ngayNghi;

    public ThongTinSV_model(String hoTen, String lopHoc, String monHoc, int soTinChi, String ngayNghi) {
        this.hoTen = hoTen;
        this.lopHoc = lopHoc;
        this.monHoc = monHoc;
        this.soTinChi = soTinChi;
        this.ngayNghi = ngayNghi;
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

    public String getNgayNghi() {
        return ngayNghi;
    }

    public void setNgayNghi(String ngayNghi) {
        this.ngayNghi = ngayNghi;
    }
    
    
}
