/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DemoThread;

/**
 *
 * @author LOVE
 */
public class MyThread implements Runnable{

    @Override
    public void run() {
        for(int i = 1; i <= 10;i++){
            try {
                System.out.println("Ten: " + Thread.currentThread().getName()+ ": " + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    
}
