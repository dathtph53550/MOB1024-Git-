/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.sql.*;
import java.util.ArrayList;
import models.NhanVien;
import utils.DbConnection;



/**
 *
 * @author LOVE
 */
public class NhanVienRespository {
    private Connection conn;

    public NhanVienRespository() {
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
                String manv = rs.getString("MaNhanVien");
                String ten = rs.getString("Ten");
                int tuoi = rs.getInt("Tuoi");
                String diachi = rs.getString("DiaChi");
                ds.add( new NhanVien(manv, ten, tuoi, diachi));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
}

