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
    private String ma;
    private String ten;
    private int tiengAnh;
    private int tinHoc;
    private int GiaoDucTheChat;

    public SinhVien() {
    }

    public SinhVien(String ma, String ten, int tiengAnh, int tinHoc, int GiaoDucTheChat) {
        this.ma = ma;
        this.ten = ten;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GiaoDucTheChat = GiaoDucTheChat;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(int tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public int getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(int tinHoc) {
        this.tinHoc = tinHoc;
    }

    public int getGiaoDucTheChat() {
        return GiaoDucTheChat;
    }

    public void setGiaoDucTheChat(int GiaoDucTheChat) {
        this.GiaoDucTheChat = GiaoDucTheChat;
    }
    
    public int getDiemTB(){
        return (tiengAnh + tinHoc + GiaoDucTheChat)/ 3;
    }
}
