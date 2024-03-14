
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LOVE
 */
public class bai2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Nhap a: ");
        double a = s.nextDouble();
        System.out.print("Nhap b: ");
        double b = s.nextDouble();
        System.out.print("Nhap c: ");
        double c = s.nextDouble();
        double p = ( a + b + c)/2;
        double heRon = Math.sqrt(p*(p - a) * (p - b) * (p -c));
        System.out.printf("Cong thuc Heron la: %.2f",heRon);
    }
}
