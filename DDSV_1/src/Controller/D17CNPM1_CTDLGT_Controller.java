/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.databaseconect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Class_model;
import model.lichhocmodel;

/**
 *
 * @author ADMIN
 */
public class D17CNPM1_CTDLGT_Controller {

    private Connection conn;

    public D17CNPM1_CTDLGT_Controller() throws SQLException {
        conn = new databaseconect().getconnect();
    }

    public List<Class_model> getDS(String lopHoc, String monHoc) {
        List<Class_model> ds = new ArrayList();
        try {
            String query = "SELECT * FROM Danh_Sach_Sinh_Vien" + " WHERE lop_hoc = ? AND mon_hoc = ?"; 
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, lopHoc);
            ps.setString(2, monHoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maSinhVien = String.valueOf(rs.getInt("ma_sinh_vien"));
                String hoTen = rs.getString("ho_ten");
                String lopHoc1 = rs.getString("lop_hoc");
                String monHoc1 = rs.getString("mon_hoc");
                int soTinChi = rs.getInt("so_tin_chi");
                int soTietNghi = rs.getInt("so_tiet_nghi");
                float tiLeNghi = rs.getFloat("ti_le_nghi");

                ds.add(new Class_model(maSinhVien, hoTen, lopHoc1, monHoc1, soTinChi, soTietNghi, tiLeNghi));

            }

            return ds;
        } catch (SQLException ex) {
            System.err.println("Lỗi khi tải dữ liệu: " + ex.getMessage());
            return ds;
        }
    }

    public void Luu_ttdd(Integer maSinhVien, String tenLop, String tenMon, Integer soTietNghi, Float tiLeNghi, String ngayNghi, Boolean vang) throws SQLException {
        // Cập nhật bảng D17CNPM1_CTDLGT (số tiết nghỉ và tỷ lệ nghỉ)
        String updateQuery = "UPDATE Danh_Sach_Sinh_Vien SET so_tiet_nghi = ?, ti_le_nghi = ? WHERE ma_sinh_vien = ? AND lop_hoc = ? AND mon_hoc = ?";
        PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
        updateStmt.setInt(1, soTietNghi);
        updateStmt.setFloat(2, tiLeNghi);
        updateStmt.setInt(3, maSinhVien);
        updateStmt.setString(4, tenLop);
        updateStmt.setString(5, tenMon);
        updateStmt.executeUpdate();

        // Nếu cột "Vắng" được tích và có ngày nghỉ, cập nhật vào bảng D17CNPM1_CTDLGT_ngay_nghi
        if (vang != null && vang && ngayNghi != null && !ngayNghi.isEmpty()) {
            // Kiểm tra xem có bản ghi với ma_sinh_vien và ngay_nghi đã tồn tại hay không
            String checkExistingQuery = "SELECT COUNT(*) FROM Thong_tin_ngay_nghi WHERE ma_sinh_vien = ? AND ngay_nghi = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkExistingQuery);
            checkStmt.setInt(1, maSinhVien);
            checkStmt.setDate(2, Date.valueOf(ngayNghi)); // Chuyển đổi String thành Date
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                // Không có bản ghi, thực hiện insert
                String insertNgayNghiQuery = "INSERT INTO Thong_tin_ngay_nghi (ma_sinh_vien, ngay_nghi) VALUES (?, ?)";
                PreparedStatement insertNgayNghiStmt = conn.prepareStatement(insertNgayNghiQuery);
                insertNgayNghiStmt.setInt(1, maSinhVien);
                insertNgayNghiStmt.setDate(2, Date.valueOf(ngayNghi)); // Chuyển đổi String thành Date
                insertNgayNghiStmt.executeUpdate();
            }
        }
    }

   
}
