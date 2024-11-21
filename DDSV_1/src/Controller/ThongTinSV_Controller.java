/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import DAO.databaseconect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ThongTinSV_model;

/**
 *
 * @author ADMIN
 */
public class ThongTinSV_Controller {
    private Connection conn;
    
    public ThongTinSV_Controller() throws SQLException{
        conn = new databaseconect().getconnect();
    }
    
    public List<ThongTinSV_model> getDS(int maSinhVien, String lopHoc, String monHoc) {
        List<ThongTinSV_model> ds = new ArrayList();
        try {
            // Tạo tên bảng động dựa trên lớp học và môn học
            

            String query = "SELECT sv.ho_ten, sv.lop_hoc, sv.mon_hoc, sv.so_tin_chi, nn.ngay_nghi " +
                           "FROM Danh_Sach_Sinh_Vien sv " +
                           "JOIN Thong_tin_ngay_nghi nn ON sv.ma_sinh_vien = nn.ma_sinh_vien " +
                           "WHERE sv.ma_sinh_vien = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, maSinhVien);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String hoTen = rs.getString("ho_ten");
                String lopHoc1 = rs.getString("lop_hoc");
                String monHoc1 = rs.getString("mon_hoc");
                int soTinChi = rs.getInt("so_tin_chi");
                String ngayNghi = rs.getDate("ngay_nghi").toString();
                ds.add(new ThongTinSV_model(hoTen, lopHoc1, monHoc1, soTinChi, ngayNghi));
            }
            return ds;
        } catch (SQLException ex) {
            System.err.println("Lỗi khi tải dữ liệu: " + ex.getMessage());
            return ds;
        }
    }
}