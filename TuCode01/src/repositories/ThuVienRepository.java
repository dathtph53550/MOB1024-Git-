/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;
import java.sql.*;
import java.util.ArrayList;
import models.ThuVien;
import utlis.DbConnection;
/**
 *
 * @author LOVE
 */
public class ThuVienRepository {
    private Connection conn;

    public ThuVienRepository() {
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<ThuVien> seacher(){
        String SQL = "SELECT * FROM ThuVien";
        ArrayList<ThuVien> ds = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String ma = rs.getString("MaSach");
                String ten = rs.getString("TenSach");
                int gia = rs.getInt("GiaSach");
                ds.add(new ThuVien(ma, ten, gia));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
    public void create(ThuVien tv){
        String SQL = "INSERT INTO ThuVien (MaSach,TenSach,GiaSach) VALUES (?,?,?)";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, tv.getMaSach());
            ps.setString(2, tv.getTenSach());
            ps.setInt(3, tv.getGiaSach());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String ma){
        String SQL = "DELETE FROM ThuVien WHERE MaSach = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, ma);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(ThuVien sv){
        String SQL = "UPDATE ThuVien SET TenSach = ?,GiaSach = ? WHERE MaSach = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, sv.getTenSach());
            ps.setInt(2, sv.getGiaSach());
            ps.setString(3, sv.getMaSach());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
