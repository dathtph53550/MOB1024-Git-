/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm;

import java.text.DecimalFormat;

/**
 *
 * @author LOVE
 */
public class SinhVien {
    private String masv;
    private String ten;
    private double tiengAnh;
    private double tinHoc;
    private double giaoDucTC;

    public SinhVien() {
    }

    public SinhVien(String masv, String ten, double tiengAnh, double tinHoc, double giaoDucTC) {
        this.masv = masv;
        this.ten = ten;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.giaoDucTC = giaoDucTC;
    }
    
    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(double tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public double getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(double tinHoc) {
        this.tinHoc = tinHoc;
    }

    public double getGiaoDucTC() {
        return giaoDucTC;
    }

    public void setGiaoDucTC(double giaoDucTC) {
        this.giaoDucTC = giaoDucTC;
    }
    
    public String TrungBinh(){
        double tong = (tiengAnh + tinHoc + giaoDucTC) / 3;
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(tong);
    }
    
    
}
