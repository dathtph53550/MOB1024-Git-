/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import utlis.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import models.Model_SinhVien;
/**
 *
 * @author LOVE
 */
public class SinhVienRepository {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String SQL = null;
    
    public ArrayList<Model_SinhVien> getAll(){
        SQL = "SELECT * FROM SINHVIEN";
        ArrayList<Model_SinhVien> ds = new ArrayList<>();
        try {
            conn = DbConnection.getConnection();
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                String ma,ten,nganh;
                int tuoi;
                double diemTB;
                boolean gioiTinh;
                ma = rs.getString(1);
                ten = rs.getString(2);
                tuoi = rs.getInt(3);
                gioiTinh = rs.getBoolean(4);
                nganh = rs.getString(5);
                diemTB = rs.getDouble(6);
                Model_SinhVien sv = new Model_SinhVien(ma, ten, tuoi, gioiTinh, nganh, diemTB);
                ds.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return ds;
    }
}
