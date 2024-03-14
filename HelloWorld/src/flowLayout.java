
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicArrowButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LOVE
 */
public class flowLayout extends JFrame{
    public flowLayout(){
        this.setTitle("ViDu_FlowLayout");
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        FlowLayout flow = new FlowLayout();
        FlowLayout flow_1 = new FlowLayout(FlowLayout.RIGHT);
        FlowLayout flow_2 = new FlowLayout(FlowLayout.CENTER, 100 , 100);
        this.setLayout(flow_2);
        JButton jb1 = new JButton("1");
        JButton jb2 = new JButton("2");
        JButton jb3 = new JButton("3");
           
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        flowLayout fl = new flowLayout();
    }
}
