/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package md19301buoi13;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author LOVE
 */
public class DemoClient {
    public static void main(String[] args) throws Exception{
        String cauNoi;
        
        System.out.println("Vui Long nhap cau noi: ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        cauNoi = input.readLine();
        
        Socket connectToServer = new Socket("localhost",6789);
        DataOutputStream outToServer = 
                new DataOutputStream(connectToServer.getOutputStream());
        outToServer.writeBytes(cauNoi + "\n");
        
        BufferedReader result = 
                new BufferedReader(new InputStreamReader(connectToServer.getInputStream()));
        System.out.println(result.readLine());
        connectToServer.close();
    }
}
