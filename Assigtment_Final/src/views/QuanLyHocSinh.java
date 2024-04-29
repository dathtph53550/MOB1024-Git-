/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import Repositories.SinhVienRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.SinhVien;

/**
 *
 * @author LOVE
 */
public class QuanLyHocSinh extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyHocSinh
     */
    SinhVienRepository svRepo = new SinhVienRepository();
    public QuanLyHocSinh() {
        initComponents();
        load(svRepo.seacher(""));
        setLocationRelativeTo(null);
        hienCuoi();
    }
    
    public void SortTop3(){
        ArrayList<SinhVien> list = svRepo.sort();
        Comparator<SinhVien> comp = new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if(o1.getDiemTB() > o2.getDiemTB()) 
                    return -1;
                else 
                    return 1;
            }
        };
        Collections.sort(list, comp);
        DefaultTableModel tblModel = (DefaultTableModel) tblSinhVien.getModel();
        tblModel.setRowCount(0);
        int dem = 0;
        for (SinhVien x : list) {
            if(dem < 3){
                Object[] tt = {x.getMa(),x.getTen(),x.getTiengAnh(),x.getTinHoc(),x.getGiaoDucTheChat(),x.getDiemTB()};
                tblModel.addRow(tt);
                dem++;
            }          
        }
    }
    
    public void hienDau(){
        if(tblSinhVien.getRowCount() >= 0){
            txtMaSV.setText((String)tblSinhVien.getValueAt(0, 0));
            txtHoTen.setText((String)tblSinhVien.getValueAt(0, 1));
            int tiengAnh = (Integer)tblSinhVien.getValueAt(0, 2);
            int tinHoc = (Integer)tblSinhVien.getValueAt(0, 3);
            int gdtc = (Integer)tblSinhVien.getValueAt(0, 4);
            int tb = (Integer)tblSinhVien.getValueAt(0, 5);
            txtTiengAnh.setText(String.valueOf(tiengAnh));
            txtTinHoc.setText(String.valueOf(tinHoc));
            txtGiaoDucTC.setText(String.valueOf(gdtc));      
            lblResult.setText(String.valueOf(tb));            
        }
                   
    }
    
    public boolean checkKhoaChinh(){     
        String ma = txtMaSV.getText();
        for(int i = 0; i < tblSinhVien.getRowCount() ;i++){
            if(ma.equalsIgnoreCase((String)tblSinhVien.getValueAt(i, 0))){
                JOptionPane.showMessageDialog(this, "Trung Ma Vui Long nhap ma khac");
                txtMaSV.requestFocus();
                return false;
            }
        }
        return true;
    }
    
    public void hienThi(){
        int index = tblSinhVien.getSelectedRow();
        if(index != -1){
            txtMaSV.setText((String)tblSinhVien.getValueAt(index, 0));
            txtHoTen.setText((String)tblSinhVien.getValueAt(index, 1));
            int tiengAnh = (Integer)tblSinhVien.getValueAt(index, 2);
            int tinHoc = (Integer)tblSinhVien.getValueAt(index, 3);
            int gdtc = (Integer)tblSinhVien.getValueAt(index, 4);
            int tb = (Integer)tblSinhVien.getValueAt(index, 5);
            txtTiengAnh.setText(String.valueOf(tiengAnh));
            txtTinHoc.setText(String.valueOf(tinHoc));
            txtGiaoDucTC.setText(String.valueOf(gdtc));      
            lblResult.setText(String.valueOf(tb));
        }
    }
    
    public void hienThi2(){
        int index = tblSinhVien.getSelectedRow() + 1;     
        if(index != -1){
            txtMaSV.setText((String)tblSinhVien.getValueAt(index, 0));
            txtHoTen.setText((String)tblSinhVien.getValueAt(index, 1));
            int tiengAnh = (Integer)tblSinhVien.getValueAt(index, 2);
            int tinHoc = (Integer)tblSinhVien.getValueAt(index, 3);
            int gdtc = (Integer)tblSinhVien.getValueAt(index, 4);
            int tb = (Integer)tblSinhVien.getValueAt(index, 5);
            txtTiengAnh.setText(String.valueOf(tiengAnh));
            txtTinHoc.setText(String.valueOf(tinHoc));
            txtGiaoDucTC.setText(String.valueOf(gdtc));      
            lblResult.setText(String.valueOf(tb));
        }
    }
    
    public void hienThi3(){
        int index = tblSinhVien.getSelectedRow() - 1;     
        if(index != -1){
            txtMaSV.setText((String)tblSinhVien.getValueAt(index, 0));
            txtHoTen.setText((String)tblSinhVien.getValueAt(index, 1));
            int tiengAnh = (Integer)tblSinhVien.getValueAt(index, 2);
            int tinHoc = (Integer)tblSinhVien.getValueAt(index, 3);
            int gdtc = (Integer)tblSinhVien.getValueAt(index, 4);
            int tb = (Integer)tblSinhVien.getValueAt(index, 5);
            txtTiengAnh.setText(String.valueOf(tiengAnh));
            txtTinHoc.setText(String.valueOf(tinHoc));
            txtGiaoDucTC.setText(String.valueOf(gdtc));      
            lblResult.setText(String.valueOf(tb));
        }
    }
    
    public boolean checkForm(){
        if(txtMaSV.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ban chua nhap ma sv !!");
            txtMaSV.requestFocus();
            return false;
        }
        else if(txtHoTen.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ban chua nhap ten !!");
            txtHoTen.requestFocus();
            return false;
        }
        else if(txtTiengAnh.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ban chua nhap diem Tieng Anh !!");
            txtTiengAnh.requestFocus();
            return false;
        }
        else if(txtTinHoc.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ban chua nhap diem tin hoc !!");
            txtTinHoc.requestFocus();
            return false;
        }
        else if(txtGiaoDucTC.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ban chua nhap diem GDTC !!");
            txtGiaoDucTC.requestFocus();
            return false;
        }
        else return true;
    }
    
    public void hienCuoi(){
        int index = tblSinhVien.getRowCount() - 1;
        if(index != -1){
            txtMaSV.setText((String)tblSinhVien.getValueAt(index, 0));
            txtHoTen.setText((String)tblSinhVien.getValueAt(index, 1));
            int tiengAnh = (Integer)tblSinhVien.getValueAt(index, 2);
            int tinHoc = (Integer)tblSinhVien.getValueAt(index, 3);
            int gdtc = (Integer)tblSinhVien.getValueAt(index, 4);
            int tb = (Integer)tblSinhVien.getValueAt(index, 5);
            txtTiengAnh.setText(String.valueOf(tiengAnh));
            txtTinHoc.setText(String.valueOf(tinHoc));
            txtGiaoDucTC.setText(String.valueOf(gdtc));      
            lblResult.setText(String.valueOf(tb));
        }
    }
    
    public SinhVien getForm(){
        String ma = txtMaSV.getText();
        String ten = txtHoTen.getText();
        int tiengAnh = Integer.parseInt(txtTiengAnh.getText());
        int tinHoc = Integer.parseInt(txtTinHoc.getText());
        int giaoDuc= Integer.parseInt(txtGiaoDucTC.getText());
        SinhVien sv = new SinhVien(ma, ten, tiengAnh, tinHoc, giaoDuc);
        return sv;
    }
    
    public void load(ArrayList<SinhVien> list){
        
        DefaultTableModel tblModel = (DefaultTableModel) tblSinhVien.getModel();
        tblModel.setRowCount(0);
        for (SinhVien x : list) {
            Object []thongTinSV = {x.getMa(),x.getTen(),x.getTiengAnh(),x.getTinHoc(),x.getGiaoDucTheChat(),x.getDiemTB()};
            tblModel.addRow(thongTinSV);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSapXep = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDau = new javax.swing.JButton();
        btnLen = new javax.swing.JButton();
        btnXuong = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();
        lblQuanLyDiemSinhVien = new javax.swing.JLabel();
        lblTimKiem = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTimKiemMaSV = new javax.swing.JLabel();
        txtTimKiemMaSV = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblHoTen = new javax.swing.JLabel();
        lblMaSV = new javax.swing.JLabel();
        lblTiengAnh = new javax.swing.JLabel();
        lblTinHoc = new javax.swing.JLabel();
        lblGiaoDucTC = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtMaSV = new javax.swing.JTextField();
        txtTiengAnh = new javax.swing.JTextField();
        txtTinHoc = new javax.swing.JTextField();
        txtGiaoDucTC = new javax.swing.JTextField();
        lblDiemTB = new javax.swing.JLabel();
        lblResult = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        lbl3SinhVienCoDiemCaoNhat = new javax.swing.JLabel();
        btnSapXep1 = new javax.swing.JButton();

        btnSapXep.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSapXep.setForeground(new java.awt.Color(0, 0, 204));
        btnSapXep.setText("Sắp Xếp");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNew.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnNew.setForeground(new java.awt.Color(0, 0, 255));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dau_1.png"))); // NOI18N
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });

        btnLen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/down_1.png"))); // NOI18N
        btnLen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLenActionPerformed(evt);
            }
        });

        btnXuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/next.png"))); // NOI18N
        btnXuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuongActionPerformed(evt);
            }
        });

        btnCuoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cuoi_1.png"))); // NOI18N
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });

        lblQuanLyDiemSinhVien.setFont(new java.awt.Font("Sitka Display", 0, 28)); // NOI18N
        lblQuanLyDiemSinhVien.setForeground(new java.awt.Color(0, 0, 255));
        lblQuanLyDiemSinhVien.setText("Quản Lý Điểm Sinh Viên");

        lblTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblTimKiem.setText("Tìm Kiếm");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        lblTimKiemMaSV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTimKiemMaSV.setText("Mã SV : ");

        txtTimKiemMaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemMaSVActionPerformed(evt);
            }
        });

        btnsearch.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnsearch.setForeground(new java.awt.Color(51, 51, 255));
        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTimKiemMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiemMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimKiemMaSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKiemMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        lblHoTen.setText("Họ Tên SV : ");

        lblMaSV.setText("Mã SV : ");

        lblTiengAnh.setText("Tiếng Anh :");

        lblTinHoc.setText("Tin Học :");

        lblGiaoDucTC.setText("Giáo Dục TC :");

        lblDiemTB.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblDiemTB.setForeground(new java.awt.Color(0, 0, 255));
        lblDiemTB.setText("Điểm TB :");

        lblResult.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblResult.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGiaoDucTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTinHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTiengAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMaSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtGiaoDucTC, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblDiemTB, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGiaoDucTC, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaoDucTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "MaSinhVien", "TenSinhVien", "TiengAnh", "TinHoc","GiaoDucTheChat","DiemTB"
            }
        ));
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSinhVien);

        lbl3SinhVienCoDiemCaoNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl3SinhVienCoDiemCaoNhat.setForeground(new java.awt.Color(51, 51, 255));
        lbl3SinhVienCoDiemCaoNhat.setText("3 Sinh Viên Có Điểm Cao Nhất : ");

        btnSapXep1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSapXep1.setForeground(new java.awt.Color(0, 0, 204));
        btnSapXep1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Favourites.png"))); // NOI18N
        btnSapXep1.setText("Sắp Xếp");
        btnSapXep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXep1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnDau, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnLen, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXuong, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSapXep1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblQuanLyDiemSinhVien)
                        .addGap(164, 164, 164))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl3SinhVienCoDiemCaoNhat))
                        .addContainerGap(39, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblQuanLyDiemSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLen, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(btnXuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCuoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSapXep1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl3SinhVienCoDiemCaoNhat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtTiengAnh.setText("");
        txtTinHoc.setText("");
        txtGiaoDucTC.setText("");
        lblResult.setText("");
        txtTimKiemMaSV.setText("");
        load(svRepo.seacher(""));
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(checkKhoaChinh()){
            if(checkForm()){
               SinhVien sv = this.getForm();
               lblResult.setText(String.valueOf(sv.getDiemTB()));
               svRepo.save(sv);
               load(svRepo.seacher(""));
               hienCuoi();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
       if(!txtMaSV.getText().trim().isEmpty()){
           svRepo.delete(txtMaSV.getText());
           load(svRepo.seacher(""));
           hienCuoi();
           
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(checkForm()){
            SinhVien sv = this.getForm();
            svRepo.update(sv);
            lblResult.setText(String.valueOf(sv.getDiemTB()));
            load(svRepo.seacher(""));
        }      
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauActionPerformed
        // TODO add your handling code here:
        int dong = 0;
        if(dong == 0){
            hienThi();
            tblSinhVien.setRowSelectionInterval(dong, dong);
        }
    }//GEN-LAST:event_btnDauActionPerformed

    private void btnLenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLenActionPerformed
        // TODO add your handling code here:
       int dong = tblSinhVien.getSelectedRow();
        if(dong > 0 ){
            dong--;
            hienThi3();
            tblSinhVien.setRowSelectionInterval(dong, dong);
        }

    }//GEN-LAST:event_btnLenActionPerformed

    private void btnXuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuongActionPerformed
        // TODO add your handling code here:
        int dong = tblSinhVien.getSelectedRow();
        if(dong < tblSinhVien.getRowCount() - 1){
            hienThi2();
            dong++;
            tblSinhVien.setRowSelectionInterval(dong , dong );
        }
    }//GEN-LAST:event_btnXuongActionPerformed

    private void btnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiActionPerformed
        // TODO add your handling code here:
        int dong = tblSinhVien.getRowCount() - 1;
        if(dong == tblSinhVien.getRowCount() - 1){
            hienThi();
            tblSinhVien.setRowSelectionInterval(dong, dong );
        }
    }//GEN-LAST:event_btnCuoiActionPerformed

    private void txtTimKiemMaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemMaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemMaSVActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        load(svRepo.seacher(txtTimKiemMaSV.getText()));
     
    }//GEN-LAST:event_btnsearchActionPerformed

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        // TODO add your handling code here:
        hienThi();
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void btnSapXep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXep1ActionPerformed
        // TODO add your handling code here:
       SortTop3();
       hienDau();
    }//GEN-LAST:event_btnSapXep1ActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyHocSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyHocSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyHocSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyHocSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyHocSinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLen;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnSapXep1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnXuong;
    private javax.swing.JButton btnsearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl3SinhVienCoDiemCaoNhat;
    private javax.swing.JLabel lblDiemTB;
    private javax.swing.JLabel lblGiaoDucTC;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblMaSV;
    private javax.swing.JLabel lblQuanLyDiemSinhVien;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblTiengAnh;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTimKiemMaSV;
    private javax.swing.JLabel lblTinHoc;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextField txtGiaoDucTC;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtTiengAnh;
    private javax.swing.JTextField txtTimKiemMaSV;
    private javax.swing.JTextField txtTinHoc;
    // End of variables declaration//GEN-END:variables
}
