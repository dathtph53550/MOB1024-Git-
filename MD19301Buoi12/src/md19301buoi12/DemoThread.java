/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package md19301buoi12;

/**
 *
 * @author LOVE
 */
public class DemoThread {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        System.out.println("" + i++);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        System.out.println("" + i++);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        }).start();
    }
}
