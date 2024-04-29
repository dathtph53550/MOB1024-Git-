/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;
import java.sql.*;
import java.util.ArrayList;
import models.SinhVien;
import utils.DbConnection;

/**
 *
 * @author LOVE
 */
public class SinhVienRepository {
    private Connection conn;
    
    public SinhVienRepository(){
        this.conn = DbConnection.getConnection();
    }
    
//    public ArrayList<SinhVien> seacher(){
//        String SQL = "SELECT * FROM SinhVien";
//        ArrayList<SinhVien> ds = new ArrayList<>();
//        try {
//            PreparedStatement ps = this.conn.prepareStatement(SQL);
//            ps.execute();
//            
//            ResultSet rs = ps.getResultSet();
//            while(rs.next()){
//                String masv = rs.getString("MaSinhVien");
//                String ten = rs.getString("TenSinhVien");
//                int diem = rs.getInt("Diem");
//                ds.add(new SinhVien(masv, ten, diem));     
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ds;
//    }
    
    public ArrayList<SinhVien> seacher(String keyWord){
        String SQL = "SELECT * FROM SinhVien";
        ArrayList<SinhVien> ds = new ArrayList<>();
        if(keyWord.trim().length() != 0){
            SQL += " WHERE MaSinhVien LIKE ? OR TenSinhVien LIKE ? OR Diem LIKE ?";           
        }
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            if(keyWord.trim().length() != 0){
                ps.setString(1, "%" + keyWord + "%");
                ps.setString(2, "%" + keyWord + "%");
                ps.setString(3, "%" + keyWord + "%");
            }     
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String masv = rs.getString("MaSinhVien");
                String ten = rs.getString("TenSinhVien");
                int diem = rs.getInt("Diem");
                ds.add(new SinhVien(masv, ten, diem));     
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
    public void create(SinhVien sv){
        String SQL = "INSERT INTO SinhVien (MaSinhVien,TenSinhVien,Diem) VALUES (?,?,?)";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getTenSV());
            ps.setInt(3, sv.getDiem());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String maSinhVien){
        String SQL ="DELETE FROM SinhVien WHERE MaSinhVien = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, maSinhVien);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(SinhVien sv){
       String SQL = "UPDATE SinhVien SET TenSinhVien = ?, Diem = ? WHERE MaSinhVien = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, sv.getTenSV());
            ps.setInt(2, sv.getDiem());
            ps.setString(3, sv.getMaSV());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public ArrayList<SinhVien> seacher(String keyword){
//        String SQL = "SELECT * FROM SinhVien";
//        ArrayList<SinhVien> ds = new ArrayList<>();
//        if(keyword != null){
//            SQL += "WHERE TenSinhVien LIKE '%"
//            + keyword
//            + "%'";
//        }
//        try {
//            PreparedStatement ps = this.conn.prepareStatement(SQL);
//            ps.execute();
//            
//            ResultSet rs = ps.getResultSet();
//            while(rs.next()){
//                String masv = rs.getString("MaSinhVien");
//                String ten = rs.getString("TenSinhVien");
//                int diem = rs.getInt("Diem");
//                ds.add(new SinhVien(masv, ten, diem));     
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ds;
//    }
}
