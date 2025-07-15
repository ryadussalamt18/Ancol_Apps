/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AncolApps;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author LENOVO
 */
public class TransaksiReguler extends javax.swing.JFrame {

    private int harga;
    private Connection con;

    /**
     * Creates new form TransaksiAncol
     */
    public TransaksiReguler() {
        initComponents();
        tampildata();
        id_auto();
        piket.setText("Ancol - Regular");
        haket.setText("30000");

        // ... (Bagian inisialisasi lainnya)
        // Memanggil updateSubtotal saat juket dan juken berubah
        juket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSubtotal();
            }
        });

        juken.addActionListener(new ActionListener() {
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

        jPanel2 = new JPanel();
        jLabel4 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        txtno = new JTextField();
        txtnama = new JTextField();
        jLabel12 = new JLabel();
        haket = new JTextField();
        juket = new JTextField();
        jLabel13 = new JLabel();
        tiken = new JComboBox<>();
        jLabel14 = new JLabel();
        haken = new JTextField();
        jLabel15 = new JLabel();
        juken = new JTextField();
        txttotal = new JTextField();
        txtkembali = new JTextField();
        jLabel16 = new JLabel();
        txtbayar = new JTextField();
        txttanggal = new JDateChooser();
        piket = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        CetakLaporan = new JButton();
        txtcari = new JTextField();
        jScrollPane1 = new JScrollPane();
        tbl_data = new JTable();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel5 = new JLabel();
        jLabel17 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1220, 775));

        jPanel2.setBackground(new Color(0, 102, 102));
        jPanel2.setLayout(null);

        jLabel4.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("NO. TRANSAKSI                :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(50, 250, 164, 30);

        jLabel6.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("MASUKAN NAMA ANDA     :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(50, 310, 165, 30);

        jLabel7.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("PILIH TANGGAL                 :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(50, 370, 166, 30);

        jLabel8.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("PILIH TIKET");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(50, 430, 139, 30);

        jLabel9.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("HARGA TIKET");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(440, 250, 170, 30);

        jLabel10.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("JUMLAH TIKET");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(440, 310, 88, 30);

        jLabel11.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("SUBTOTAL");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(840, 310, 63, 30);

        txtno.setBackground(new Color(102, 102, 102));
        txtno.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        txtno.setEnabled(false);
        txtno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtnoActionPerformed(evt);
            }
        });
        jPanel2.add(txtno);
        txtno.setBounds(50, 280, 300, 30);

        txtnama.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        txtnama.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });
        jPanel2.add(txtnama);
        txtnama.setBounds(50, 340, 300, 30);

        jLabel12.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("KEMBALIAN");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(840, 430, 90, 30);

        haket.setBackground(new Color(102, 102, 102));
        haket.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        haket.setEnabled(false);
        haket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                haketActionPerformed(evt);
            }
        });
        jPanel2.add(haket);
        haket.setBounds(440, 280, 300, 30);

        juket.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(juket);
        juket.setBounds(440, 340, 300, 30);

        jLabel13.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("TIKET KENDARAAN");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(440, 370, 114, 30);

        tiken.setBackground(new Color(102, 102, 102));
        tiken.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        tiken.setModel(new DefaultComboBoxModel<>(new String[] { "1. Motor", "2. Mobil", "3. Bus" }));
        tiken.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tikenActionPerformed(evt);
            }
        });
        jPanel2.add(tiken);
        tiken.setBounds(440, 400, 300, 30);

        jLabel14.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("HARGA TIKET KENDARAAN");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(440, 430, 162, 30);

        haken.setBackground(new Color(102, 102, 102));
        haken.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        haken.setEnabled(false);
        haken.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hakenActionPerformed(evt);
            }
        });
        jPanel2.add(haken);
        haken.setBounds(440, 460, 300, 30);

        jLabel15.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("JUMLAH KENDARAAN");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(840, 250, 130, 30);

        juken.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        juken.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jukenActionPerformed(evt);
            }
        });
        jPanel2.add(juken);
        juken.setBounds(840, 280, 300, 30);

        txttotal.setBackground(new Color(102, 102, 102));
        txttotal.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        txttotal.setEnabled(false);
        txttotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        jPanel2.add(txttotal);
        txttotal.setBounds(840, 340, 300, 30);

        txtkembali.setBackground(new Color(102, 102, 102));
        txtkembali.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        txtkembali.setEnabled(false);
        txtkembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtkembaliActionPerformed(evt);
            }
        });
        jPanel2.add(txtkembali);
        txtkembali.setBounds(840, 460, 300, 30);

        jLabel16.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("BAYAR");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(840, 370, 60, 30);

        txtbayar.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txtbayar);
        txtbayar.setBounds(840, 400, 300, 30);

        txttanggal.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txttanggal);
        txttanggal.setBounds(50, 400, 300, 30);

        piket.setBackground(new Color(102, 102, 102));
        piket.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        piket.setEnabled(false);
        piket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                piketActionPerformed(evt);
            }
        });
        jPanel2.add(piket);
        piket.setBounds(50, 460, 300, 30);

        jButton1.setBackground(new Color(51, 0, 51));
        jButton1.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("CARI");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(10, 200, 80, 30);

        jButton2.setBackground(new Color(51, 0, 51));
        jButton2.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new Color(255, 255, 255));
        jButton2.setText("EDIT");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(750, 190, 80, 30);

        jButton3.setBackground(new Color(51, 0, 51));
        jButton3.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new Color(255, 255, 255));
        jButton3.setText("HAPUS");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(850, 190, 80, 30);

        jButton4.setBackground(new Color(51, 0, 51));
        jButton4.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new Color(255, 255, 255));
        jButton4.setText("EXCEL");
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(950, 190, 80, 30);

        CetakLaporan.setBackground(new Color(51, 0, 51));
        CetakLaporan.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        CetakLaporan.setForeground(new Color(255, 255, 255));
        CetakLaporan.setText("CETAK LAPORAN");
        CetakLaporan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CetakLaporanActionPerformed(evt);
            }
        });
        jPanel2.add(CetakLaporan);
        CetakLaporan.setBounds(1050, 190, 140, 30);

        txtcari.setBackground(new Color(51, 0, 51));
        txtcari.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        txtcari.setForeground(new Color(255, 255, 255));
        jPanel2.add(txtcari);
        txtcari.setBounds(100, 200, 130, 30);

        tbl_data.setAutoCreateRowSorter(true);
        tbl_data.setBackground(new Color(0, 102, 102));
        tbl_data.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        tbl_data.setFont(new Font("Times New Roman", 1, 14)); // NOI18N
        tbl_data.setForeground(new Color(255, 255, 255));
        tbl_data.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No_Transaksi ", "Nama", "Pilih_Tanggal", "Pilh_Tiket", "Harga_Tiket", "Jumlah_Tiket", "Tiket_Kendaraan", "Harga_TiketKendaraan", "Jumlah_Tiket", "SubTotal", "Bayar", "Kembalian"
            }
        ));
        tbl_data.setGridColor(new Color(0, 0, 0));
        tbl_data.setSelectionForeground(new Color(0, 0, 0));
        tbl_data.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 510, 1200, 170);

        jLabel2.setBackground(new Color(153, 153, 153));
        jLabel2.setIcon(new ImageIcon(getClass().getResource("/icon/bgancol1.jpg"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 100, 1200, 630);

        jLabel3.setFont(new Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("TRANSAKSI REGULER");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(370, 20, 460, 70);

        jLabel5.setIcon(new ImageIcon(getClass().getResource("/icon/BACK.png"))); // NOI18N
        jLabel5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 0, 40, 40);

        jLabel17.setIcon(new ImageIcon(getClass().getResource("/icon/rumah.png"))); // NOI18N
        jLabel17.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel17);
        jLabel17.setBounds(1130, 10, 64, 64);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 1200, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        new JenisTiket().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    void tampildata() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("No_Transaksi");
        tbl.addColumn("Nama");
        tbl.addColumn("Pilih_Tanggal");
        tbl.addColumn("Pilih_Tiket");
        tbl.addColumn("Harga_Tiket");
        tbl.addColumn("Jumlah_Tiket");
        tbl.addColumn("Tiket_Kendaraan");
        tbl.addColumn("Harga_TiketKendaraan");
        tbl.addColumn("Jumlah_Kendaraan");
        tbl.addColumn("SubTotal");
        tbl.addColumn("Bayar");
        tbl.addColumn("Kembalian");

        try {
            String sql = "select * from t_reguler";
            try (Connection con = LoginAndSignUp.GetConnection(); Statement stat = con.createStatement(); ResultSet rs = stat.executeQuery(sql)) {
                while (rs.next()) {
                    tbl.addRow(new Object[]{
                        rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10),
                        rs.getString(11), rs.getString(12)
                    });
                }
            }
            tbl_data.setModel(tbl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tbl_dataMouseClicked(MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
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
            tiken.setSelectedItem(tbl_data.getValueAt(baris, 6).toString());
            haken.setText(tbl_data.getValueAt(baris, 7).toString());
            juken.setText(tbl_data.getValueAt(baris, 8).toString());
            txttotal.setText(tbl_data.getValueAt(baris, 9).toString());
            txtbayar.setText(tbl_data.getValueAt(baris, 10).toString());
            txtkembali.setText(tbl_data.getValueAt(baris, 11).toString());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_dataMouseClicked
    void deletedata() {
        try {
            Connection con = LoginAndSignUp.GetConnection();
            String query = "DELETE FROM t_reguler WHERE No_Transaksi = ?";

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
            tiken.setSelectedItem(null);
            haken.setText("");
            juken.setText("");
            txttotal.setText("");
            txtbayar.setText("");
            txtkembali.setText("");
            tampildata();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jButton3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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

    private void jButton4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        exportExcel();
    }//GEN-LAST:event_jButton4ActionPerformed
// Gantilah bagian deklarasi JDateChooser sesuai dengan deklarasi yang sebenarnya

    void updatedata() {
        try {
            // Pemeriksaan untuk memastikan semua kolom diisi
            if (isEmptyField(txtnama) || isEmptyField(piket) || isEmptyField(haket) || isEmptyField(juket)
                    || isEmptyField((JComboBox<?>) tiken) || isEmptyField(haken) || isEmptyField(juken)
                    || isEmptyField(txttotal) || isEmptyField(txtbayar) || isEmptyField(txtkembali) || isEmptyField(txtno)
                    || txttanggal.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
                return; // Keluar dari metode jika ada kolom yang tidak diisi
            }

            java.util.Date dateUtil = txttanggal.getDate();
            java.sql.Date sqlDate = new java.sql.Date(dateUtil.getTime());
            Connection con = LoginAndSignUp.GetConnection();

            if (con != null) {
                String query = "UPDATE t_reguler SET `Nama` = ?, `pilih_tanggal` = ?, `pilh_tiket` = ?, "
                        + "`Harga_tiket` = ?, `Jumlah_tiket` = ?, `Tiket_Kendaraan` = ?, `Harga_TiketKendaraan` = ?, "
                        + "`Jumlah_Kendaraan` = ?, `SubTotal` = ?, `bayar` = ?, `Kembalian` = ? WHERE `No_Transaksi` = ?";

                try (PreparedStatement stat = con.prepareStatement(query)) {
                    stat.setString(1, txtnama.getText());
                    stat.setDate(2, sqlDate);
                    stat.setString(3, piket.getText());
                    stat.setString(4, haket.getText());
                    stat.setString(5, juket.getText());
                    stat.setString(6, ((JComboBox<?>) tiken).getSelectedItem().toString()); // Assuming tiken is a JComboBox
                    stat.setString(7, haken.getText());
                    stat.setString(8, juken.getText());
                    stat.setString(9, txttotal.getText());
                    stat.setString(10, txtbayar.getText());
                    stat.setString(11, txtkembali.getText());
                    stat.setString(12, txtno.getText());

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

// Metode bantu untuk memeriksa apakah JTextField atau JComboBox kosong
    private boolean isEmptyField(Component component) {
        if (component instanceof JTextField) {
            return ((JTextField) component).getText().trim().isEmpty();
        } else if (component instanceof JComboBox<?>) {
            return ((JComboBox<?>) component).getSelectedItem() == null
                    || ((JComboBox<?>) component).getSelectedItem().toString().trim().isEmpty();
        }
        return true; // Handle other types if needed
    }

    private void setConnection() {
        try {
            con = LoginAndSignUp.GetConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan koneksi database: " + e.getMessage());
        }
    }
    private void CetakLaporanActionPerformed(ActionEvent evt) {//GEN-FIRST:event_CetakLaporanActionPerformed
        // TODO add your handling code here:
        try {
            // Memastikan koneksi tersedia sebelum melanjutkan
            if (con == null || con.isClosed()) {
                setConnection();
            }

            // Membaca file laporan JasperReports
            File namafile = new File("src/CetakLaporan/LaporanReguler.jasper");

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
    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        updatedata();
    }//GEN-LAST:event_jButton2ActionPerformed
    void cariData() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("No_Transaksi");
        tbl.addColumn("Nama");
        tbl.addColumn("Pilih_Tanggal");
        tbl.addColumn("Pilh_Tiket");
        tbl.addColumn("Harga_Tiket");
        tbl.addColumn("Jumlah_Tiket");
        tbl.addColumn("Tiket_Kendaraan");
        tbl.addColumn("Harga_TiketKendaraan");
        tbl.addColumn("Jumlah_Kendaraan"); // Corrected column name
        tbl.addColumn("SubTotal");
        tbl.addColumn("Bayar");
        tbl.addColumn("Kembalian");

        try (Connection con = LoginAndSignUp.GetConnection()) {
            String sql = "SELECT * FROM t_reguler WHERE nama LIKE '%" + txtcari.getText() + "%'";
            try (Statement stat = con.createStatement(); ResultSet rs = stat.executeQuery(sql)) {
                while (rs.next()) {
                    tbl.addRow(new Object[]{
                        rs.getString(1), // No_Transaksi
                        rs.getString(2), // Nama
                        rs.getString(3), // Pilih_Tanggal
                        rs.getString(4), // Pilh_Tiket
                        rs.getString(5), // Harga_Tiket
                        rs.getString(6), // Jumlah_Tiket
                        rs.getString(7), // Tiket_Kendaraan
                        rs.getString(8), // Harga_TiketKendaraan
                        rs.getString(9), // Jumlah_Kendaraan
                        rs.getString(10), // SubTotal
                        rs.getString(11), // Bayar
                        rs.getString(12) // Kembalian
                    });
                }
                tbl_data.setModel(tbl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cariData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtnoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtnoActionPerformed
        // TODO add your handling code here:
        id_auto();
    }//GEN-LAST:event_txtnoActionPerformed

    private void txtnamaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void haketActionPerformed(ActionEvent evt) {//GEN-FIRST:event_haketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_haketActionPerformed

    private void tikenActionPerformed(ActionEvent evt) {//GEN-FIRST:event_tikenActionPerformed
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

    private void hakenActionPerformed(ActionEvent evt) {//GEN-FIRST:event_hakenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hakenActionPerformed

    private void jukenActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jukenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jukenActionPerformed

    private void txttotalActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void txtkembaliActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtkembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkembaliActionPerformed

    private void piketActionPerformed(ActionEvent evt) {//GEN-FIRST:event_piketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_piketActionPerformed

    private void jLabel17MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
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
            java.util.logging.Logger.getLogger(TransaksiReguler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiReguler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiReguler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiReguler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiReguler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton CetakLaporan;
    private JTextField haken;
    private JTextField haket;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTextField juken;
    private JTextField juket;
    private JTextField piket;
    private JTable tbl_data;
    private JComboBox<String> tiken;
    private JTextField txtbayar;
    private JTextField txtcari;
    private JTextField txtkembali;
    private JTextField txtnama;
    private JTextField txtno;
    private JDateChooser txttanggal;
    private JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
