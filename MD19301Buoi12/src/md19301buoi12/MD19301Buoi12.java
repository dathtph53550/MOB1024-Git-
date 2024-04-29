/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package md19301buoi12;

import threadDemo.MyThread;
import threadDemo.MyThread2;
import threadDemo.MyThread2Cach2;
import threadDemo.MyThreadCach2;

/**
 *
 * @author LOVE
 */
public class MD19301Buoi12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        MyThread t1 = new MyThread();
//        t1.start();
//        MyThread2 t2 = new MyThread2();
//        t2.start();
        Thread t1 = new Thread(new MyThreadCach2());
        t1.start();
        Thread t2 = new Thread(new MyThread2Cach2());
        t2.start();
        
    }
    
}
