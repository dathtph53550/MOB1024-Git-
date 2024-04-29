/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author LOVE
 */
public class NhanVien {
    private String MaNhanVien;
    private String ten;
    private int tuoi;
    private String DiaChi;

    public NhanVien() {
    }

    public NhanVien(String MaNhanVien, String ten, int tuoi, String DiaChi) {
        this.MaNhanVien = MaNhanVien;
        this.ten = ten;
        this.tuoi = tuoi;
        this.DiaChi = DiaChi;
    }

    
    
    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
    
}
