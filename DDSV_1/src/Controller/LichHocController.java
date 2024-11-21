/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.databaseconect;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.lichhocmodel;

/**
 *
 * @author ADMIN
 */
public class LichHocController {

    private Connection conn;

    public LichHocController() throws SQLException {
        conn = new databaseconect().getconnect();
    }

    public List<lichhocmodel> getDS() {
        List<lichhocmodel> ds = new ArrayList();
        try {
            // Câu truy vấn lấy dữ liệu từ bảng LichHoc, kết hợp với bảng LopHoc và MonHoc
            String query = "SELECT l.ten_lop, m.ten_mon, lh.ngay_hoc, lh.so_tiet "
                + "FROM LichHoc lh "
                + "JOIN LopHoc l ON lh.ma_lop = l.ma_lop "
                + "JOIN MonHoc m ON lh.ma_mon = m.ma_mon "
                + "ORDER BY lh.ngay_hoc";
                    
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenLop = rs.getString("ten_lop");
                String tenMon = rs.getString("ten_mon");
                String ngayHoc = rs.getString("ngay_hoc");
                int soTiet = rs.getInt("so_tiet");
                ds.add(new lichhocmodel(tenLop, tenMon, ngayHoc, soTiet));
            }
            return ds;
        } catch (SQLException ex) {
            System.err.println("Lỗi khi tải dữ liệu: " + ex.getMessage());
            return ds;
        }
    }

    public List<lichhocmodel> getDS(String searchText) {
        List<lichhocmodel> ds = new ArrayList();
        try {
            // Câu truy vấn lấy dữ liệu từ bảng LichHoc, kết hợp với bảng LopHoc và MonHoc
            String query = "SELECT l.ten_lop, m.ten_mon, lh.ngay_hoc, lh.so_tiet "
                + "FROM LichHoc lh "
                + "JOIN LopHoc l ON lh.ma_lop = l.ma_lop "
                + "JOIN MonHoc m ON lh.ma_mon = m.ma_mon "
                + "WHERE LOWER(l.ten_lop) LIKE ? OR LOWER(m.ten_mon) LIKE ? OR LOWER(lh.ngay_hoc) LIKE ?";
                
            PreparedStatement pst = conn.prepareStatement(query);
            String searchPattern = "%" + searchText + "%"; // Thêm dấu % vào để tìm kiếm phần tử chứa chuỗi
            pst.setString(1, searchPattern);
            pst.setString(2, searchPattern);
            pst.setString(3, searchPattern);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String tenLop = rs.getString("ten_lop");
                String tenMon = rs.getString("ten_mon");
                String ngayHoc = rs.getString("ngay_hoc");
                int soTiet = rs.getInt("so_tiet");
                ds.add(new lichhocmodel(tenLop, tenMon, ngayHoc, soTiet));
            }
            return ds;
        } catch (SQLException ex) {
            System.err.println("Lỗi khi tải dữ liệu: " + ex.getMessage());
            return ds;
        }
    }

    public boolean delete_lichhoc(String tenLop, String tenMon, String ngayHoc, int soTiet) {
        try {
            // Câu truy vấn SQL để xóa dữ liệu khỏi cơ sở dữ liệu
            String query = "DELETE FROM LichHoc "
                    + "WHERE ma_lop = ( "
                    + "    SELECT ma_lop FROM LopHoc WHERE ten_lop = ? "
                    + ") "
                    + "AND ma_mon = ( "
                    + "    SELECT ma_mon FROM MonHoc WHERE ten_mon = ? "
                    + ") "
                    + "AND ngay_hoc = ? "
                    + "AND so_tiet = ?;";
            PreparedStatement stmt = conn.prepareStatement(query);

            // Chỉ số của PreparedStatement bắt đầu từ 1
            stmt.setString(1, tenLop);   // Dùng chỉ số 1 cho tenLop
            stmt.setString(2, tenMon);   // Dùng chỉ số 2 cho tenMon
            stmt.setString(3, ngayHoc);  // Dùng chỉ số 3 cho ngayHoc
            stmt.setInt(4, soTiet);      // Dùng chỉ số 4 cho soTiet

            // Thực thi câu lệnh
            stmt.executeUpdate();
            System.out.println("Xóa dữ liệu thành công từ cơ sở dữ liệu.");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
