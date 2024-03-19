/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;


import utils.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import models.NhanVien;

/**
 *
 * @author LOVE
 */
public class NhanVienRepository {
    private Connection conn;
    
    public NhanVienRepository(){
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<NhanVien> seacher(){
        String SQL = "SELECT * FROM NhanVien";
        ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String MaNv = rs.getString("MaNhanVien");
                String Ten = rs.getString("Ten");
                int Tuoi = rs.getInt("Tuoi");
                String diaChi = rs.getString("DiaChi");
                ds.add(new NhanVien(MaNv, Ten, Tuoi, diaChi));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
}
