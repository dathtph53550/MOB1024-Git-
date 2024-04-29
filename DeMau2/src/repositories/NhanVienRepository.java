/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;
import java.sql.*;
import java.util.ArrayList;
import models.NhanVien;
import ultis.DbConnection;
/**
 *
 * @author LOVE
 */
public class NhanVienRepository {
    private Connection conn;
    
    public NhanVienRepository(){
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<NhanVien> up(){
        String SQL = "SELECT * FROM NhanVien";
        ArrayList<NhanVien> ds = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String ma = rs.getString("MaNhanVien");
                String ten = rs.getString("TenNhanVien");
                String soDienThoai = rs.getString("SoDienThoai");
                int trangThai = rs.getInt("trangThai");
                ds.add(new NhanVien(ma, ten, soDienThoai, trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
    public void update(NhanVien nv){
        String SQL = "UPDATE NhanVien SET TenNhanVien = ?,SoDienThoai = ?, trangThai = ? WHERE MaNhanVien = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, nv.getTen());
            ps.setString(2, nv.getSdt());
            ps.setInt(3, nv.getTrangThai());
            ps.setString(4, nv.getMa());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
