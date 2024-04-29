/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package md19301buoi13;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author LOVE
 */
public class DemoIP {
    public static void main(String[] args) {
        try {
                InetAddress host = InetAddress.getLocalHost();
                System.out.println(host.getHostAddress());
                System.out.println(host.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
