/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;
import java.sql.*;
import java.util.ArrayList;
import models.NhanVien;
import utlis.DbConnection;
/**
 *
 * @author LOVE
 */
public class NhanVienRepository {
    private Connection conn;

    public NhanVienRepository() {
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<NhanVien> seacher(){
        String SQL = "SELECT * FROM NhanVien";
        ArrayList<NhanVien> ds = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String ma = rs.getString("MaNhanVien");
                String ten = rs.getString("HoTen");
                Boolean gioiTinh = rs.getBoolean("GioiTinh");
                String chucVu = rs.getString("ChucVu");
                ds.add(new NhanVien(ma, ten, gioiTinh, chucVu));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
    public void create(NhanVien nv){
        String SQL = "INSERT INTO NhanVien (MaNhanVien,HoTen,GioiTinh,ChucVu) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, nv.getMaNhanVien());
            ps.setString(2, nv.getTen());
            ps.setBoolean(3, nv.isGioiTinh());
            ps.setString(4, nv.getChucVu());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String ma){
        String SQL = "DELETE FROM NhanVien WHERE MaNhanVien = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, ma);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(NhanVien nv){
        String SQL = "UPDATE NhanVien SET HoTen = ?, GioiTinh = ?, ChucVu = ? WHERE MaNhanVien = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, nv.getTen());
            ps.setBoolean(2, nv.isGioiTinh());
            ps.setString(3, nv.getChucVu());
            ps.setString(4, nv.getMaNhanVien());
            ps.execute();
        } catch (Exception e) {
        }
    }
        
    
}
