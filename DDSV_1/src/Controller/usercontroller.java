/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.databaseconect;
import ddsv.LichHoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class usercontroller {

    private Connection conn;

    public usercontroller() throws SQLException {
        conn = new databaseconect().getconnect();
    }

    public boolean login(String email, String password) {
        try {

            // Truy vấn kiểm tra tài khoản
            String sql = "SELECT * FROM dangnhap WHERE email = ? AND matkhau = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                // Đăng nhập thất bại
                JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu sai!");
                return false;
            }

            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối: " + e.getMessage());
            return false;
        }
    }

}
