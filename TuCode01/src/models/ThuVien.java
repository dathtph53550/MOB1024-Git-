/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author LOVE
 */
public class ThuVien {
    private String MaSach;
    private String TenSach;
    private int GiaSach;

    public ThuVien() {
    }

    public ThuVien(String MaSach, String TenSach, int GiaSach) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.GiaSach = GiaSach;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public int getGiaSach() {
        return GiaSach;
    }

    public void setGiaSach(int GiaSach) {
        this.GiaSach = GiaSach;
    }
    
    
}
