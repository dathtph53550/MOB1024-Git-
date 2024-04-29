/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author LOVE
 */
public class SinhVien {
    private String maSinhVien;
    private String tenSinhVien;
    private Boolean gioiTinh;
    private int tuoi;

    public SinhVien() {
    }

    public SinhVien(String maSinhVien, String tenSinhVien, Boolean gioiTinh, int tuoi) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    
    
}
