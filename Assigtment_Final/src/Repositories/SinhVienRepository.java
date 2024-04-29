/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;


import utlis.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import models.SinhVien;

/**
 *
 * @author LOVE
 */
public class SinhVienRepository {
    private Connection conn;
    
    public SinhVienRepository(){
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<SinhVien> seacher(String keyWord){
        String SQL = "SELECT * FROM SinhVien";
        ArrayList<SinhVien> ds = new ArrayList<>();
        
        if(keyWord.trim().length() != 0){
            SQL += " WHERE MaSinhVien LIKE ? OR HoTen LIKE ? OR TiengAnh LIKE ? OR TinHoc LIKE ? OR GDTC LIKE ?";
        }
        
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            if(keyWord.trim().length() != 0){
                ps.setString(1, "%" + keyWord + "%");
                ps.setString(2, "%" + keyWord + "%");
                ps.setString(3, "%" + keyWord + "%");
                ps.setString(4, "%" + keyWord + "%");
                ps.setString(5, "%" + keyWord + "%");
            }
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String maSinhVien = rs.getString("MaSinhVien");
                String tenSinhVien = rs.getString("HoTen");
                int  tiengAnh = rs.getInt("TiengAnh");
                int tinHoc = rs.getInt("TinHoc");
                int giaoDuc = rs.getInt("GDTC");
                ds.add(new SinhVien(maSinhVien,tenSinhVien, tiengAnh, tinHoc, giaoDuc));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    } 
    
    public void save(SinhVien sv){
        String SQL = "INSERT INTO SinhVien (MaSinhVien,HoTen,TiengAnh,TinHoc,GDTC) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, sv.getMa());
            ps.setString(2, sv.getTen());
            ps.setInt(3, sv.getTiengAnh());
            ps.setInt(4, sv.getTinHoc());
            ps.setInt(5, sv.getGiaoDucTheChat());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String maSinhVien){
        String SQL = "DELETE FROM SinhVien WHERE MaSinhVien = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, maSinhVien);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(SinhVien sv){
        String SQL = "UPDATE SinhVien SET HoTen = ?,TiengAnh = ?,TinHoc = ?,GDTC = ? WHERE MaSinhVien = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, sv.getTen());
            ps.setInt(2, sv.getTiengAnh());
            ps.setInt(3, sv.getTinHoc());
            ps.setInt(4, sv.getGiaoDucTheChat());
            ps.setString(5, sv.getMa());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<SinhVien> sort(){
        String SQL = "SELECT * FROM SinhVien";
        ArrayList<SinhVien> list = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String maSinhVien = rs.getString("MaSinhVien");
                String tenSinhVien = rs.getString("HoTen");
                int  tiengAnh = rs.getInt("TiengAnh");
                int tinHoc = rs.getInt("TinHoc");
                int giaoDuc = rs.getInt("GDTC");
                list.add(new SinhVien(maSinhVien,tenSinhVien, tiengAnh, tinHoc, giaoDuc));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
 