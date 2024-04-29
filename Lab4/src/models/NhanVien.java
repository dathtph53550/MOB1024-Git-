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
    private String maNhanVien;
    private String Ten;
    private boolean GioiTinh;
    private String ChucVu;

    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String Ten, boolean GioiTinh, String ChucVu) {
        this.maNhanVien = maNhanVien;
        this.Ten = Ten;
        this.GioiTinh = GioiTinh;
        this.ChucVu = ChucVu;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }
}
