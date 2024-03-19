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
    private String manv;
    private String ten;
    private int tuoi;
    private String diachi;

    public NhanVien() {
    }

    public NhanVien(String manv, String ten, int tuoi, String diachi) {
        this.manv = manv;
        this.ten = ten;
        this.tuoi = tuoi;
        this.diachi = diachi;
    }

    
    
    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
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
        return diachi;
    }

    public void setDiaChi(String diachi) {
        this.diachi = diachi;
    }
    
    
}
