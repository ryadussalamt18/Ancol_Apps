/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AncolApps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Tirta Ryadussalam
 */
public class AncolReguler extends javax.swing.JFrame {

    private int harga;

    /**
     * Creates new form HalamanUtama
     */
    public AncolReguler() {
        initComponents();
        id_auto();
        piket.setText("Ancol - Regular");

        // Set the initial value of haket to "30000"
        haket.setText("30000");

        // Add DocumentListener to juket
        juket.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSubtotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSubtotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSubtotal();
            }
        });

        // Add DocumentListener to juken
        juken.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateSubtotal();
            }

            public void removeUpdate(DocumentEvent e) {
                updateSubtotal();
            }

            public void changedUpdate(DocumentEvent e) {
                updateSubtotal();
            }
        });
        // Add DocumentListener to txtbayar
        txtbayar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateChange();
            }
        });

        // Add ActionListener to txtbayar for Enter key
        txtbayar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enterPressed");
        txtbayar.getActionMap().put("enterPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insert();
            }
        });
    }

    private void updateSubtotal() {
        try {
            int jumlahTiket = Integer.parseInt(juket.getText());
            int jumlahKendaraan = Integer.parseInt(juken.getText());

            // Subtotal tiket (updated calculation)
            int subtotalTiket = Integer.parseInt(haket.getText()) * jumlahTiket;

            // Subtotal kendaraan
            int hargaKendaraan = Integer.parseInt(haken.getText());
            int subtotalKendaraan = hargaKendaraan * jumlahKendaraan;

            int totalTiket = subtotalTiket + subtotalKendaraan;

            // Hitung total keseluruhan
            int total = totalTiket;

            txttotal.setText(String.valueOf(total));

            // Tambahkan log untuk memeriksa nilai total
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
                txtkembali.setText("Uang yang dimasukan kurang");
            } else {
                // Calculate change
                int kembali = bayar - total;
                txtkembali.setText(String.valueOf(kembali));
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        jLabel13 = new javax.swing.JLabel();
        tiken = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        haken = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        juken = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        txtkembali = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtbayar = new javax.swing.JTextField();
        input = new javax.swing.JButton();
        txttanggal = new com.toedter.calendar.JDateChooser();
        piket = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bodoni MT Black", 1, 36)); // NOI18N
        jLabel1.setText("WELCOME TO");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 60, 320, 70);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/welcome.jpeg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(470, 10, 290, 160);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NO. TRANSAKSI                :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(220, 60, 164, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MASUKAN NAMA ANDA     :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(220, 100, 165, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PILIH TANGGAL                 :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(220, 140, 166, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PILIH TIKET                      :");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(220, 180, 164, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("HARGA TIKET                    :");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(220, 220, 170, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("JUMLAH TIKET                   :");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(220, 260, 170, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("SUBTOTAL                         :");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(220, 420, 167, 30);

        txtno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtno.setEnabled(false);
        txtno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoActionPerformed(evt);
            }
        });
        jPanel2.add(txtno);
        txtno.setBounds(440, 60, 300, 30);

        txtnama.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });
        jPanel2.add(txtnama);
        txtnama.setBounds(440, 100, 300, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("KEMBALIAN                       :");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(220, 510, 180, 30);

        haket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        haket.setEnabled(false);
        haket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haketActionPerformed(evt);
            }
        });
        jPanel2.add(haket);
        haket.setBounds(440, 220, 300, 30);

        juket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(juket);
        juket.setBounds(440, 260, 300, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("TIKET KENDARAAN            :");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(220, 300, 180, 30);

        tiken.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tiken.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1. Motor", "2. Mobil", "3. Bus" }));
        tiken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tikenActionPerformed(evt);
            }
        });
        jPanel2.add(tiken);
        tiken.setBounds(440, 300, 300, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("HARGA TIKET KENDARAAN :");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(220, 340, 180, 30);

        haken.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        haken.setEnabled(false);
        haken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hakenActionPerformed(evt);
            }
        });
        jPanel2.add(haken);
        haken.setBounds(440, 340, 300, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("JUMLAH KENDARAAN        :");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(220, 380, 170, 30);

        juken.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        juken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jukenActionPerformed(evt);
            }
        });
        jPanel2.add(juken);
        juken.setBounds(440, 380, 300, 30);

        txttotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttotal.setEnabled(false);
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        jPanel2.add(txttotal);
        txttotal.setBounds(440, 420, 300, 30);

        txtkembali.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtkembali.setEnabled(false);
        txtkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkembaliActionPerformed(evt);
            }
        });
        jPanel2.add(txtkembali);
        txtkembali.setBounds(440, 510, 300, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("BAYAR                              :");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(220, 460, 170, 30);

        txtbayar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txtbayar);
        txtbayar.setBounds(440, 460, 300, 30);

        input.setText("INPUT");
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });
        jPanel2.add(input);
        input.setBounds(660, 570, 80, 30);
        jPanel2.add(txttanggal);
        txttanggal.setBounds(440, 140, 300, 30);

        piket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        piket.setEnabled(false);
        piket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                piketActionPerformed(evt);
            }
        });
        jPanel2.add(piket);
        piket.setBounds(440, 180, 300, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 180, 1000, 700);

        jLabel6.setIcon(new javax.swing.ImageIcon("E:\\ProgUpbo\\src\\icon\\BACK.png")); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 40, 30);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rumah.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel17);
        jLabel17.setBounds(930, 10, 64, 64);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void id_auto() {
        try (Connection con = LoginAndSignUp.GetConnection()) {

            if (!con.isClosed()) {
                String sql = "SELECT MAX(RIGHT(No_Transaksi, 5)) AS no FROM t_reguler";
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

    private void tikenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tikenActionPerformed
        // TODO add your handling code here:                                     
        if (tiken.getSelectedIndex() == 0) {
            harga = 30000; // Motor
        } else if (tiken.getSelectedIndex() == 1) {
            harga = 50000; // Mobil
        } else if (tiken.getSelectedIndex() == 2) {
            harga = 100000; // Bus
        }
        haken.setText(String.valueOf(harga));
        updateSubtotal();

        // Tambahkan log untuk memeriksa nilai harga
    }//GEN-LAST:event_tikenActionPerformed

    private void jukenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jukenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jukenActionPerformed

    private void txtkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkembaliActionPerformed

    private void haketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_haketActionPerformed

// ...
    void insert() {
        try {
            Connection con = LoginAndSignUp.GetConnection();
            Statement stat = con.createStatement();

            // Validate that required fields are not empty
            if (txtnama.getText().isEmpty() || txttanggal.getDate() == null || piket.getText().isEmpty()
                    || haket.getText().isEmpty() || juket.getText().isEmpty() || tiken.getSelectedItem().toString().isEmpty()
                    || haken.getText().isEmpty() || juken.getText().isEmpty() || txttotal.getText().isEmpty()
                    || txtbayar.getText().isEmpty() || txtkembali.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!");
                return; // Exit the method if any field is empty
            }

            int total = Integer.parseInt(txttotal.getText());
            int bayar = Integer.parseInt(txtbayar.getText());

            // Validate that the payment is sufficient
            if (bayar < total) {
                JOptionPane.showMessageDialog(null, "Uang kurang! Harap masukkan uang yang sesuai.");
                txtkembali.setText("");  // Set txtkembali to empty when payment is insufficient
                return; // Exit the method if the payment is insufficient
            }

            int kembali = bayar - total;
            txtkembali.setText(String.valueOf(kembali));

            java.util.Date date = txttanggal.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = dateFormat.format(date);

            stat.executeUpdate("INSERT INTO t_reguler (No_Transaksi, Nama, Pilih_Tanggal, Pilh_Tiket, Harga_Tiket, Jumlah_Tiket, Tiket_Kendaraan, Harga_TiketKendaraan, Jumlah_Kendaraan, SubTotal, Bayar, Kembalian) VALUES ('"
                    + txtno.getText() + "','"
                    + txtnama.getText() + "','"
                    + tanggal + "','"
                    + piket.getText() + "','"
                    + haket.getText() + "','"
                    + juket.getText() + "','"
                    + tiken.getSelectedItem() + "','"
                    + haken.getText() + "','"
                    + juken.getText() + "','"
                    + txttotal.getText() + "','"
                    + txtbayar.getText() + "','"
                    + kembali + "')");

            JOptionPane.showMessageDialog(null, "Simpan Berhasil");

            // Clear input fields
            txtno.setText("");
            txtnama.setText("");
            txttanggal.setDate(null);
            piket.setText("");
            haket.setText("");
            juket.setText("");
            tiken.setSelectedItem("");
            haken.setText("");
            juken.setText("");
            txttotal.setText("");
            txtbayar.setText("");
            txtkembali.setText("");

            // Navigate to TransaksiReguler frame
            TransaksiReguler transaksiRegulerFrame = new TransaksiReguler();
            transaksiRegulerFrame.setVisible(true);
            this.dispose();  // Close the current frame

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data ke database.");
        }
    }


    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_inputActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        new JenisTiket().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void piketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_piketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_piketActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void hakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hakenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hakenActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        new AncolDanDufanHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel17MouseClicked

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
            java.util.logging.Logger.getLogger(AncolReguler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AncolReguler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AncolReguler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AncolReguler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AncolReguler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField haken;
    private javax.swing.JTextField haket;
    private javax.swing.JButton input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField juken;
    private javax.swing.JTextField juket;
    private javax.swing.JTextField piket;
    private javax.swing.JComboBox<String> tiken;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtkembali;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtno;
    private com.toedter.calendar.JDateChooser txttanggal;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
