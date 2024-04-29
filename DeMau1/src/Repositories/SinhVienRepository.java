/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;
import java.sql.*;
import java.util.ArrayList;
import models.SinhVien;
import ultis.DbConnection;
/**
 *
 * @author LOVE
 */
public class SinhVienRepository {
    private Connection conn;
    
    public SinhVienRepository(){
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<SinhVien> seacher(){
        String SQL = "SELECT * FROM SinhVien";
        ArrayList<SinhVien> ds = new ArrayList<>();
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String ma = rs.getString("MaSinhVien");
                String ten = rs.getString("TenSinhVien");
                Boolean gioiTinh = rs.getBoolean("GioiTinh");
                int tuoi = rs.getInt("Tuoi");
                ds.add(new SinhVien(ma, ten, gioiTinh, tuoi));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
    public void save(SinhVien sv){
        String SQL = "INSERT INTO SinhVien (MaSinhVien,TenSinhVien,GioiTinh,Tuoi) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, sv.getMaSinhVien());
            ps.setString(2, sv.getTenSinhVien());
            ps.setBoolean(3, sv.getGioiTinh());
            ps.setInt(4, sv.getTuoi());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
