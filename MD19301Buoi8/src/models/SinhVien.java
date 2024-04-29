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
    private String MaSV;
    private String TenSV;
    private int diem;

    public SinhVien() {
    }

    public SinhVien(String MaSV, String TenSV, int diem) {
        this.MaSV = MaSV;
        this.TenSV = TenSV;
        this.diem = diem;
    }

    
    
    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String TenSV) {
        this.TenSV = TenSV;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
    
    
}
