
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LOVE
 */
public class main {
    public static void main(String[] args) {
        Product a[] = new Product[5];
        for(int i = 0; i < 5 ;i++){
            Scanner s = new Scanner(System.in);
            Product sp = new Product();
            System.out.printf("Nhap ten san pham %d: ",i + 1);
            String name = s.nextLine();
            System.out.printf("Nhap gia san pham %d: ",i + 1);
            double gia = s.nextDouble();
            a[i] = new Product(name, gia);
        }
        for(int i = 0; i < 5;i++){
            System.out.printf("Ten SP: %s\nGia SP: %.2f\nThue: %.2f\n\n", a[i].getName(),a[i].getPrice(),a[i].getImportTax());
        }
    }
}
