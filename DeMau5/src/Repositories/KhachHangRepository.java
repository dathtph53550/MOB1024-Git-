/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;
import java.sql.*;
import java.util.ArrayList;
import models.KhachHang;
import utils.DbConnection;
/**
 *
 * @author LOVE
 */
public class KhachHangRepository {
    private Connection conn;
    
    public KhachHangRepository(){
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<KhachHang> seacher(String keyWord){
        String SQL = "SELECT Ma,Ten,SDT,GioiTinh FROM KhachHang";
        ArrayList<KhachHang> ds = new ArrayList<>();
        if(keyWord.trim().length() != 0){
            SQL += " WHERE Ma LIKE ? OR Ten LIKE ? OR SDT LIKE ? OR GioiTinh LIKE ?";
        }
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            if(keyWord.trim().length() != 0){
                ps.setString(1, "%"+ keyWord + "%");
                ps.setString(2, "%"+ keyWord + "%");
                ps.setString(3, "%"+ keyWord + "%");
                ps.setString(4, "%"+ keyWord + "%");
            }
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String SDT = rs.getString("SDT");
                int gioiTinh = rs.getInt("GioiTinh");
                ds.add(new KhachHang(ma, ten, SDT, gioiTinh));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
    public void them(KhachHang kh){
        String SQL = "INSERT INTO KhachHang (Ma,Ten,SDT,GioiTinh) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getSDT());
            ps.setInt(4, kh.getGioiTinh());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void xoa(String ma){
        String SQL = "DELETE FROM KhachHang WHERE Ma = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, ma);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(KhachHang kh){
        String SQL ="UPDATE KhachHang SET Ten = ?,SDT = ?,GioiTinh = ? WHERE Ma = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, kh.getTen());
            ps.setString(2, kh.getSDT());
            ps.setInt(3, kh.getGioiTinh());
            ps.setString(4, kh.getMa());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
