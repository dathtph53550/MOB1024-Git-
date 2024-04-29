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
public class SinhVienRespository {
    private Connection conn;
    
    public SinhVienRespository(){
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<SinhVien> seacher(){
        String SQL = "SELECT * FROM SinhVien";
        ArrayList<SinhVien> ds = new ArrayList<SinhVien>();
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String mssv = rs.getString("MSSV");
                String ten = rs.getString("Ten");
                int diem = rs.getInt("Diem");
                ds.add(new SinhVien(mssv, ten, diem));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
}
