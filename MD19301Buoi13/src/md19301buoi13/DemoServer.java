/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package md19301buoi13;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author LOVE
 */
public class DemoServer {
    public static void main(String[] args) throws Exception{
        String chuThuong;
        String chuInHoa;
        
        ServerSocket welcomeSocket = new ServerSocket(6789);
        
        while(true){
            Socket client = welcomeSocket.accept();
            BufferedReader inputFromClient = 
                    new BufferedReader(new InputStreamReader(client.getInputStream()));
            chuThuong = inputFromClient.readLine();
            
            DataOutputStream outToClient = new DataOutputStream(client.getOutputStream());
            outToClient.writeBytes(chuThuong.toUpperCase() + "\n");
        }
    }
}
