/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AncolApps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class TransaksiAnnualPass extends javax.swing.JFrame {

    private Connection con;

    /**
     * Creates new form TransaksiAncol
     */
    public TransaksiAnnualPass() {
        initComponents();
        tampildata();
        id_auto();
        piket.setText("Ancol - AnnualPass");
        haket.setText("600000");

        // ... (Bagian inisialisasi lainnya)
        // Memanggil updateSubtotal saat juket dan juken berubah
        juket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSubtotal();
            }
        });
        // Add ActionListener to txtbayar for Enter key
        txtbayar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enterPressed");
        txtbayar.getActionMap().put("enterPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateChange();
            }
        });
        String url = "jdbc:mysql://localhost/loginapps";
        String user = "root";
        String pass = "";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            System.out.println("error : " + ex.getMessage());
        }
    }

    private void updateSubtotal() {
        try {
            int jumlahTiket = Integer.parseInt(juket.getText());

            // Subtotal tiket (updated calculation)
            int subtotalTiket = Integer.parseInt(haket.getText()) * jumlahTiket;

            int totalTiket = subtotalTiket;

            // Hitung total keseluruhan
            int total = totalTiket;

            txttotal.setText(String.valueOf(total));

            // Pemanggilan updateChange() setelah subtotal diperbarui
            updateChange();
        } catch (NumberFormatException ex) {
            // Handle the exception (e.g., show an error message)
            txttotal.setText("");
        }
    }

    private void updateChange() {
        try {
            int total = Integer.parseInt(txttotal.getText());
            int bayar = Integer.parseInt(txtbayar.getText());

            // Validate that the payment is sufficient
            if (bayar < total) {
                JOptionPane.showMessageDialog(null, "Uang kurang! Harap masukkan uang yang sesuai.");
                txtkembali.setText("");
                return; // Exit the method if the payment is insufficient
            }

            // Calculate change
            int kembali = bayar - total;

            if (kembali < 0) {
                // If the amount is less than the total, show a message dialog
                JOptionPane.showMessageDialog(null, "Uang kurang! Harap masukkan uang yang sesuai.");
                txtkembali.setText("");
            } else {
                // Display the change
                txtkembali.setText(String.valueOf(kembali));

                // Update the "Kembalian" value in the table model
                int selectedRow = tbl_data.getSelectedRow();
                if (selectedRow != -1) {
                    tbl_data.setValueAt(String.valueOf(kembali), selectedRow, 8); // Assuming "Kembalian" is at index 8
                }
            }

            // Tambahkan log untuk memeriksa nilai kembali
        } catch (NumberFormatException ex) {
            // Handle the exception (e.g., show an error message)
            txtkembali.setText("Invalid Input");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        haket = new javax.swing.JTextField();
        juket = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        txtkembali = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtbayar = new javax.swing.JTextField();
        txttanggal = new com.toedter.calendar.JDateChooser();
        piket = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        CetakLaporan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1220, 775));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("NO. TRANSAKSI                :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(40, 240, 164, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("MASUKAN NAMA ANDA     :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(40, 300, 165, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("PILIH TANGGAL                 :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(40, 360, 166, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("PILIH TIKET");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(440, 240, 139, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("HARGA TIKET");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(440, 300, 170, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("JUMLAH TIKET");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(440, 360, 88, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("SUBTOTAL");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(850, 240, 63, 30);

        txtno.setBackground(new java.awt.Color(102, 102, 102));
        txtno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtno.setEnabled(false);
        txtno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoActionPerformed(evt);
            }
        });
        jPanel2.add(txtno);
        txtno.setBounds(40, 270, 300, 30);

        txtnama.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });
        jPanel2.add(txtnama);
        txtnama.setBounds(40, 330, 300, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("KEMBALIAN");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(850, 360, 90, 30);

        haket.setBackground(new java.awt.Color(153, 153, 153));
        haket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        haket.setEnabled(false);
        haket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haketActionPerformed(evt);
            }
        });
        jPanel2.add(haket);
        haket.setBounds(440, 330, 300, 30);

        juket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(juket);
        juket.setBounds(440, 390, 300, 30);

        txttotal.setBackground(new java.awt.Color(153, 153, 153));
        txttotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttotal.setEnabled(false);
        jPanel2.add(txttotal);
        txttotal.setBounds(850, 270, 300, 30);

        txtkembali.setBackground(new java.awt.Color(153, 153, 153));
        txtkembali.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtkembali.setEnabled(false);
        txtkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkembaliActionPerformed(evt);
            }
        });
        jPanel2.add(txtkembali);
        txtkembali.setBounds(850, 390, 300, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("BAYAR");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(850, 300, 60, 30);

        txtbayar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txtbayar);
        txtbayar.setBounds(850, 330, 300, 30);
        jPanel2.add(txttanggal);
        txttanggal.setBounds(40, 390, 300, 30);

        piket.setBackground(new java.awt.Color(153, 153, 153));
        piket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        piket.setEnabled(false);
        jPanel2.add(piket);
        piket.setBounds(440, 270, 300, 30);

        jButton1.setBackground(new java.awt.Color(51, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CARI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(10, 200, 80, 30);

        txtcari.setBackground(new java.awt.Color(51, 0, 51));
        txtcari.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcari.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtcari);
        txtcari.setBounds(100, 200, 130, 30);

        jButton2.setBackground(new java.awt.Color(51, 0, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(750, 190, 80, 30);

        jButton3.setBackground(new java.awt.Color(51, 0, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("HAPUS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(850, 190, 80, 30);

        jButton4.setBackground(new java.awt.Color(51, 0, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("EXCEL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(950, 190, 80, 30);

        CetakLaporan.setBackground(new java.awt.Color(51, 0, 51));
        CetakLaporan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CetakLaporan.setForeground(new java.awt.Color(255, 255, 255));
        CetakLaporan.setText("CETAK LAPORAN");
        CetakLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakLaporanActionPerformed(evt);
            }
        });
        jPanel2.add(CetakLaporan);
        CetakLaporan.setBounds(1050, 190, 140, 30);

        tbl_data.setAutoCreateRowSorter(true);
        tbl_data.setBackground(new java.awt.Color(0, 102, 102));
        tbl_data.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbl_data.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbl_data.setForeground(new java.awt.Color(255, 255, 255));
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No_Transaksi ", "Nama", "Pilih_Tanggal", "Pilh_Tiket", "Harga_Tiket", "Jumlah_Tiket", "SubTotal", "Bayar", "Kembalian"
            }
        ));
        tbl_data.setGridColor(new java.awt.Color(0, 0, 0));
        tbl_data.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 490, 1200, 170);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bgancol1.jpg"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 100, 1200, 630);

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TRANSAKSI ANNUALPASS");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(340, 20, 540, 70);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BACK.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 0, 40, 40);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rumah.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel13);
        jLabel13.setBounds(1130, 10, 64, 64);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        new JenisTiket().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked
    void tampildata() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("No_Transaksi");
        tbl.addColumn("Nama");
        tbl.addColumn("Pilih_Tanggal");
        tbl.addColumn("Pilh_Tiket");
        tbl.addColumn("Harga_Tiket");
        tbl.addColumn("Jumlah_Tiket");
        tbl.addColumn("SubTotal");
        tbl.addColumn("Bayar");
        tbl.addColumn("Kembalian");

        try {
            String sql = "select * from t_annualpass";
            try (Connection con = LoginAndSignUp.GetConnection(); Statement stat = con.createStatement(); ResultSet rs = stat.executeQuery(sql)) {
                while (rs.next()) {
                    tbl.addRow(new Object[]{
                        rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8),
                        rs.getString(9) // Kembalian
                    });
                }
            }
            tbl_data.setModel(tbl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        int baris = tbl_data.getSelectedRow();
        if (baris != -1) {
            txtno.setText(tbl_data.getValueAt(baris, 0).toString());
            txtnama.setText(tbl_data.getValueAt(baris, 1).toString());

            // Ganti bagian ini untuk menetapkan nilai tanggal pada JDateChooser
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tbl_data.getValueAt(baris, 2).toString());
                txttanggal.setDate(date);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            piket.setText(tbl_data.getValueAt(baris, 3).toString());
            haket.setText(tbl_data.getValueAt(baris, 4).toString());
            juket.setText(tbl_data.getValueAt(baris, 5).toString());
            txttotal.setText(tbl_data.getValueAt(baris, 6).toString());
            txtbayar.setText(tbl_data.getValueAt(baris, 7).toString());
            txtkembali.setText(tbl_data.getValueAt(baris, 8).toString());

            // Anda mungkin perlu menyesuaikan indeks untuk komponen lainnya berdasarkan struktur tabel
            // Pastikan bahwa indeks sesuai dengan kolom yang benar di tabel Anda
        }


    }//GEN-LAST:event_tbl_dataMouseClicked
    public void id_auto() {
        try (Connection con = LoginAndSignUp.GetConnection()) {

            if (!con.isClosed()) {
                String sql = "SELECT MAX(RIGHT(No_Transaksi, 5)) AS no FROM t_annualpass";
                try (Statement stat = con.createStatement();
                        ResultSet rs = stat.executeQuery(sql)) {

                    if (rs.next()) {
                        if (rs.isFirst() && rs.isLast() && rs.getInt(1) == 0) {
                            // Handle the case where the table is empty
                            txtno.setText("00001");
                        } else {
                            int set_no = rs.getInt(1) + 1;
                            String no = String.format("%05d", set_no);
                            txtno.setText(no);
                        }
                    }
                }
            } else {
                // Handle the case where the connection is closed
                System.err.println("Database connection is closed.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void txtnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnoActionPerformed
        // TODO add your handling code here:
        id_auto();
    }//GEN-LAST:event_txtnoActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void haketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_haketActionPerformed

    private void txtkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkembaliActionPerformed
    void cariData() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("No_Transaksi");
        tbl.addColumn("Nama");
        tbl.addColumn("Pilih_Tanggal");
        tbl.addColumn("Pilh_Tiket");
        tbl.addColumn("Harga_Tiket");
        tbl.addColumn("Jumlah_Tiket");
        tbl.addColumn("SubTotal");
        tbl.addColumn("Bayar");
        tbl.addColumn("Kembalian");

        try (Connection con = LoginAndSignUp.GetConnection()) {
            // Correct the table name to 't_annualpass'
            String sql = "SELECT * FROM t_annualpass WHERE nama LIKE '%" + txtcari.getText() + "%'";
            try (Statement stat = con.createStatement(); ResultSet rs = stat.executeQuery(sql)) {
                while (rs.next()) {
                    tbl.addRow(new Object[]{
                        rs.getString(1), // No_Transaksi
                        rs.getString(2), // Nama
                        rs.getString(3), // Pilih_Tanggal
                        rs.getString(4), // Pilh_Tiket
                        rs.getString(5), // Harga_Tiket
                        rs.getString(6), // Jumlah_Tiket
                        rs.getString(7), // SubTotal
                        rs.getString(8), // Bayar
                        rs.getString(9) // Kembalian
                    });
                }
                tbl_data.setModel(tbl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cariData();
    }//GEN-LAST:event_jButton1ActionPerformed
    void updatedata() {
        try {
            // Pemeriksaan untuk memastikan semua kolom diisi
            if (isEmptyField(txtnama) || isEmptyField(piket) || isEmptyField(haket)
                    || isEmptyField(juket) || isEmptyField(txttotal) || isEmptyField(txtbayar)
                    || isEmptyField(txtkembali) || isEmptyField(txtno) || txttanggal.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
                return; // Keluar dari metode jika ada kolom yang tidak diisi
            }

            java.util.Date dateUtil = txttanggal.getDate();
            java.sql.Date sqlDate = new java.sql.Date(dateUtil.getTime());
            Connection con = LoginAndSignUp.GetConnection();

            if (con != null) {
                String query = "UPDATE t_annualpass SET `Nama` = ?, `pilih_tanggal` = ?, `pilh_tiket` = ?, "
                        + "`Harga_tiket` = ?, `Jumlah_tiket` = ?, `SubTotal` = ?, `bayar` = ?, `Kembalian` = ? WHERE `No_Transaksi` = ?";

                try (PreparedStatement stat = con.prepareStatement(query)) {
                    stat.setString(1, txtnama.getText());
                    stat.setDate(2, sqlDate);
                    stat.setString(3, piket.getText());
                    stat.setString(4, haket.getText());
                    stat.setString(5, juket.getText());
                    stat.setString(6, txttotal.getText());
                    stat.setString(7, txtbayar.getText());
                    stat.setString(8, txtkembali.getText());
                    stat.setString(9, txtno.getText());

                    stat.executeUpdate();
                }

                tampildata();
                JOptionPane.showMessageDialog(null, "Update Berhasil");
            } else {
                JOptionPane.showMessageDialog(null, "Koneksi ke database gagal.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

// Metode bantu untuk memeriksa apakah JTextField kosong
    private boolean isEmptyField(JTextField field) {
        return field.getText().trim().isEmpty();
    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        updatedata();
    }//GEN-LAST:event_jButton2ActionPerformed
    void deletedata() {
        try {
            Connection con = LoginAndSignUp.GetConnection();
            String query = "DELETE FROM t_annualpass WHERE No_Transaksi = ?";

            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, txtno.getText());
                pst.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Delete Berhasil");
            txtno.setText("");
            txtnama.setText("");
            txttanggal.setDate(null);
            piket.setText("");
            haket.setText("");
            juket.setText("");
            txttotal.setText("");
            txtbayar.setText("");
            txtkembali.setText("");
            tampildata();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        deletedata();
    }//GEN-LAST:event_jButton3ActionPerformed
    void exportExcel() {

        FileWriter fileWriter;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("[B] export_output/excel[/B]"));
        int retrival = chooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                TableModel tModel = tbl_data.getModel();
                fileWriter = new FileWriter(new File(chooser.getSelectedFile() + ".xls"));
                for (int i = 0; i < tModel.getColumnCount(); i++) {
                    fileWriter.write(tModel.getColumnName(i).toUpperCase() + "\t");
                }
                fileWriter.write("\n");

                for (int i = 0; i < tModel.getRowCount(); i++) {
                    for (int j = 0; j < tModel.getColumnCount(); j++) {
                        fileWriter.write(tModel.getValueAt(i, j).toString() + "\t");
                    }
                    fileWriter.write("\n");
                }
                fileWriter.close();
                JOptionPane.showMessageDialog(null, "Simpan Berhasil!!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        exportExcel();
    }//GEN-LAST:event_jButton4ActionPerformed
    private void setConnection() {
        try {
            con = LoginAndSignUp.GetConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan koneksi database: " + e.getMessage());
        }
    }
    private void CetakLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakLaporanActionPerformed
        // TODO add your handling code here:
        try {
            // Memastikan koneksi tersedia sebelum melanjutkan
            if (con == null || con.isClosed()) {
                setConnection();
            }

            // Membaca file laporan JasperReports
            File namafile = new File("src/CetakLaporan/LaporanAnnualPass.jasper");

            // Menetapkan parameter laporan jika diperlukan
            // Map<String, Object> parameters = new HashMap<>();
            // ... (set parameters if needed)
            // Mengisi dan menampilkan laporan
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, con);
            JasperViewer.viewReport(jp, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan laporan: " + e.getMessage());
        } finally {
            // Pastikan untuk menutup koneksi setelah selesai
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_CetakLaporanActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        new AncolDanDufanHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiAnnualPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CetakLaporan;
    private javax.swing.JTextField haket;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField juket;
    private javax.swing.JTextField piket;
    private javax.swing.JTable tbl_data;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtkembali;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtno;
    private com.toedter.calendar.JDateChooser txttanggal;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
