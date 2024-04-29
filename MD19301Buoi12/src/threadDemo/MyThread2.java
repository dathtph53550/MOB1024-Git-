/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadDemo;

/**
 *
 * @author LOVE
 */
public class MyThread2 extends Thread{
    @Override
    public void run(){
        int i = 0;
        while(true){
            try {
                System.out.println("Tien trinh thu hai: " + i);
                i++;
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
