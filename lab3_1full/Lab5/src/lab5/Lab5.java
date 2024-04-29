/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab5;

import DemoThread.MyThread;



/**
 *
 * @author LOVE
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread t1 = new Thread(new MyThread());
        t1.setName("Chay 1");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        
        Thread t2 = new Thread(new MyThread());      
        t2.setName("Chay 2"); 
        t2.setPriority(Thread.MIN_PRIORITY);       
        t2.start();       
    }
    
}
