/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

/**
 *
 * @author LOVE
 */
public class SinhVien {

    public String name;
    public double diem;
    public String course;

    public SinhVien() {
    }

    public SinhVien(String name, double diem, String course) {
        this.name = name;
        this.diem = diem;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String ten) {
        this.name = name;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getXepLoai() {
        if (this.diem < 3) {
            return "Kem";
        } else if (this.diem < 5) {
            return "Yeu";
        } else if (this.diem < 6.5) {
            return "Trung Binh";
        } else if (this.diem < 7.5) {
            return "Kha";
        } else if (this.diem < 9) {
            return "Gioi";
        } else {
            return "Xuat Sac";
        }
    }

    public Boolean isBonus() {
        return this.diem >= 7.5;
    }
}
