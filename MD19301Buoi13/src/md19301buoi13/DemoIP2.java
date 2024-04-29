/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package md19301buoi13;

import java.net.InetAddress;

/**
 *
 * @author LOVE
 */
public class DemoIP2 {
    public static void main(String[] args) {
        try {
            InetAddress []address = InetAddress.getAllByName("laptrinhonline.club"
                    + "");
            for(int i = 0; i < address.length;i++){
                System.out.println(address[i].getHostAddress());
            }
        } catch (Exception e) {
        }
    }
}
