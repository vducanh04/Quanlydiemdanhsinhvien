/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class databaseconect {

    public static Connection getconnect() throws SQLException {
        String url = "jdbc:sqlserver://LAPTOP-4RI0T2UJ:1433;databaseName=DiemDanhSinhVien;encrypt=true;trustServerCertificate=true;";
        String dbUsername = "sa";
        String dbPassword = "123456789";
        Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
        return conn;
    }
}
