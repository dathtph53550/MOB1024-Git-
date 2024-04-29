/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import Repositories.KhachHangRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.KhachHang;

/**
 *
 * @author LOVE
 */
public class QuanLyKhachHang extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyKhachHang
     */
    KhachHangRepository khRepo = new KhachHangRepository();
    public QuanLyKhachHang() {
        initComponents();
        loadTable(khRepo.seacher(""));
        hienCuoi();
        initComboBox();
    }
    
    public void initComboBox(){
        String[] nghe = {"Bac si","Phu Ho","Van Hoang"};
        DefaultComboBoxModel cboModel = new DefaultComboBoxModel(nghe);
        cboNghe.setModel(cboModel);

    }
    
    public Boolean checkPrimaryKey(){
        String khoa = txtMa.getText();
        for(int i = 0; i < tblKhachHang.getRowCount();i++){
            if(khoa.equalsIgnoreCase((String)tblKhachHang.getValueAt(i, 0))){
                JOptionPane.showMessageDialog(this, "Trung Khoa Chinh Vui Long nhap ma khac !!");
                txtMa.requestFocus();
                return false;
            }
        }
        return true;
    }
    
    public void sort(){
        ArrayList<KhachHang> ds = khRepo.seacher("");
        Comparator<KhachHang> comp = new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                if(o1.getGioiTinh() > o2.getGioiTinh()){
                    return -1;
                }
                else return 1;
            }
        };
        Collections.sort(ds, comp);
        DefaultTableModel tblModel = (DefaultTableModel) tblKhachHang.getModel();
        tblModel.setRowCount(0);
        for(KhachHang x : ds){
            Object[] thongtin = {x.getMa(),x.getTen(),x.getSDT(),x.getGioiTinh() == 0 ? "Nam" : "Nu"};
            tblModel.addRow(thongtin);
        }
    }
    
    public Boolean checkForm(){
        if(txtMa.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Chua nhap ma !!");
            txtMa.requestFocus();
            return false;
        }
        else if(txtTen.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Chua nhap ten !!");
            txtTen.requestFocus();
            return false;
        }
        else if(txtSDT.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Chua nhap SDT !!");
            txtSDT.requestFocus();
            return false;
        }
        else return true;
    }
    
    public KhachHang getForm(){
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        String SDT = txtSDT.getText();
        int gioiTinh;
        if(rdoNam.isSelected()){
            gioiTinh = 0;
        }
        else gioiTinh = 1;
        return new KhachHang(ma, ten, SDT, gioiTinh);
    }
    
    public void loadTable(ArrayList<KhachHang> list){
        DefaultTableModel tblModel = (DefaultTableModel) tblKhachHang.getModel();
        tblModel.setRowCount(0);
        for(KhachHang x : list){
            Object[]  thongtin = {x.getMa(),x.getTen(),x.getSDT(),x.getGioiTinh() == 0 ? "Nam": "Nu"};
            tblModel.addRow(thongtin);
        }
    }
    
    public void hienCuoi(){
        int index = tblKhachHang.getRowCount() - 1;
        txtMa.setText((String)tblKhachHang.getValueAt(index, 0));
        txtTen.setText((String)tblKhachHang.getValueAt(index, 1));
        txtSDT.setText((String)tblKhachHang.getValueAt(index, 2));
        String gioiTinh = (String)tblKhachHang.getValueAt(index, 3);
        if(gioiTinh.equalsIgnoreCase("Nam")){
            rdoNam.setSelected(true);
        }
        else rdoNu.setSelected(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lblMa = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        txtTim = new javax.swing.JTextField();
        cboNghe = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quan Ly Khach Hang");

        lblMa.setText("Ma");

        lblTen.setText("Ten");

        jLabel4.setText("SDT");

        lblGioiTinh.setText("GioiTinh");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nu");

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnTim.setText("Tim");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnSapXep.setText("Sap Xep");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Ma", "Ten", "SDT", "GioiTinh"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        cboNghe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Nghe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTen)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTen))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblMa)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblGioiTinh)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa)
                                .addGap(28, 28, 28)
                                .addComponent(btnSua)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoNu)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNam)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTim)
                                .addGap(18, 18, 18)
                                .addComponent(btnSapXep)))))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboNghe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMa)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboNghe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTen)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNam)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(38, 38, 38)
                        .addComponent(lblGioiTinh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoNu)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnTim)
                    .addComponent(btnSapXep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(checkPrimaryKey()){
            if(checkForm()){
                KhachHang kh = this.getForm();
                khRepo.them(kh);
                loadTable(khRepo.seacher(""));
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        khRepo.xoa(txtMa.getText());
        loadTable(khRepo.seacher(""));
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        int index = tblKhachHang.getSelectedRow();
        if(index != -1){
            txtMa.setText((String)tblKhachHang.getValueAt(index, 0));
            txtTen.setText((String)tblKhachHang.getValueAt(index, 1));
            txtSDT.setText((String)tblKhachHang.getValueAt(index, 2));
            String gioiTinh = (String)tblKhachHang.getValueAt(index, 3);
            if(gioiTinh.equalsIgnoreCase("Nam")){
                rdoNam.setSelected(true);
            }
            else rdoNu.setSelected(true);
        }
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if(checkForm()){
            KhachHang kh = this.getForm();
            khRepo.update(kh);
            loadTable(khRepo.seacher(""));
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        loadTable(khRepo.seacher(txtTim.getText()));
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        // TODO add your handling code here:
        sort();
        hienCuoi();
    }//GEN-LAST:event_btnSapXepActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboNghe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblMa;
    private javax.swing.JLabel lblTen;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
