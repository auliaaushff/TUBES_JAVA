/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tiketkereta;

import javax.swing.JOptionPane;

/**
 *
 * @author Aulia Aushaf Abidah
 */
interface TicketCalculable {
    int calculateTotal();
}
class TicketCalculator implements TicketCalculable {
    protected int harga;
    protected int beli;

    public TicketCalculator(int harga, int beli) {
        this.harga = harga;
        this.beli = beli;
    }
    @Override
    public int calculateTotal() {
        return harga * beli;
    }
    
    public int calculateTotal(String promoCode) {
        int total = harga * beli;

        // Logika perhitungan promo
        if ("PROMO20".equals(promoCode)) {
            // Contoh: diskon 20%
            double diskon = 0.2;
            total = (int) (total - (total * diskon));
        }
        return total;
    }
}

// Extend the base class for specific ticket types
class EkonomiTicketCalculator extends TicketCalculator {
    public EkonomiTicketCalculator(String tujuan, int beli) {
        super(getHargaEkonomiByTujuan(tujuan), beli);
    }

    // Metode untuk mendapatkan harga ekonomi berdasarkan tujuan
    private static int getHargaEkonomiByTujuan(String tujuan) {
        switch (tujuan) {
            case "GAMBIR":
                return 150000; // Sesuaikan dengan harga untuk Gambir
            case "YOGYAKARTA":
                return 260000; // Sesuaikan dengan harga untuk Yogyakarta
            case "SURABAYA":
                return 360000; // Sesuaikan dengan harga untuk Surabaya
            case "PASAR SENEN":
                return 45000;  // Sesuaikan dengan harga untuk Pasar Senen
            case "MALANG":
                return 290000; // Sesuaikan dengan harga untuk Malang
            default:
                return 0; // Nilai default jika tujuan tidak dikenali
        }
    }
}

class BisnisTicketCalculator extends TicketCalculator {
    public BisnisTicketCalculator(String tujuan, int beli) {
        super(getHargaBisnisByTujuan(tujuan), beli);
    }
        private static int getHargaBisnisByTujuan(String tujuan) {
        switch (tujuan) {
            case "GAMBIR":
                return 250000; // Sesuaikan dengan harga untuk Gambir
            case "YOGYAKARTA":
                return 320000; // Sesuaikan dengan harga untuk Yogyakarta
            case "SURABAYA":
                return 475000; // Sesuaikan dengan harga untuk Surabaya
            case "PASAR SENEN":
                return 150000;  // Sesuaikan dengan harga untuk Pasar Senen
            case "MALANG":
                return 360000; // Sesuaikan dengan harga untuk Malang
            default:
                return 0; // Nilai default jika tujuan tidak dikenali
        }
    }
}

class EksekutifTicketCalculator extends TicketCalculator {
    public EksekutifTicketCalculator(String tujuan, int beli) {
        super(getHargaEksekutifByTujuan(tujuan), beli);
    }
     private static int getHargaEksekutifByTujuan(String tujuan) {
        switch (tujuan) {
            case "GAMBIR":
                return 510000;
            case "YOGYAKARTA":
                return 640000;
            case "SURABAYA":
                return 750000;
            case "PASAR SENEN":
                return 350000;
            case "MALANG":
                return 680000;
            default:
                return 0; // Default jika tujuan tidak dikenali
        }
    }
}

public class Main extends javax.swing.JFrame {
    int ekonomi, bisnis, eksekutif;
    public int harga;
    public static String nama,tanggal,tjn,kls,nomor,jumlah;
    public static int hrg,byr;
    public static int jumlahbeli = 1;
    private boolean isEkonomiSelected = false;
    private boolean isBisnisSelected = false;
    private boolean isEksekutifSelected = false;
    public Main() {
        initComponents();
        txt_harga.disable();
        txt_bayar.disable();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tujuanComboBox = new javax.swing.JComboBox<>();
        tgl = new javax.swing.JTextField();
        rb_ekonomi = new javax.swing.JRadioButton();
        rb_bisnis = new javax.swing.JRadioButton();
        rb_eksekutif = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        gerbong = new javax.swing.JLabel();
        npenumpang = new javax.swing.JLabel();
        jmlhBeli = new javax.swing.JLabel();
        ttlBayar = new javax.swing.JLabel();
        cbo_gerbong = new javax.swing.JComboBox<>();
        txt_npenumpang = new javax.swing.JTextField();
        txt_bayar = new javax.swing.JTextField();
        cbo_jmltkt = new javax.swing.JComboBox<>();
        btn_cetak = new javax.swing.JButton();
        btn_hitung = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 246, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 104, 176));
        jLabel1.setText("PENJUALAN TIKET KERETA API ONLINE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jPanel2.setBackground(java.awt.SystemColor.control);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "DATA KERETA ANTAR KOTA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft JhengHei UI Light", 1, 12))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

        jLabel3.setText("Tujuan");

        jLabel4.setText("Tgl-Bln-Thn");

        jLabel5.setText("Kelas");

        tujuanComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tujuan", "GAMBIR", "YOGYAKARTA", "SURABAYA", "PASAR SENEN", "MALANG" }));
        tujuanComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tujuanComboBoxActionPerformed(evt);
            }
        });

        tgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_ekonomi);
        rb_ekonomi.setText("Ekonomi");
        rb_ekonomi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_ekonomiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_bisnis);
        rb_bisnis.setText("Bisnis");
        rb_bisnis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_bisnisActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_eksekutif);
        rb_eksekutif.setText("Eksekutif");
        rb_eksekutif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_eksekutifActionPerformed(evt);
            }
        });

        jLabel2.setText("Harga");

        txt_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rb_ekonomi, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tujuanComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tgl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(rb_bisnis, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rb_eksekutif, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_harga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tujuanComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rb_ekonomi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_bisnis)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_eksekutif, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 260, 260));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "DATA PENUMPANG", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft JhengHei UI Light", 1, 12))); // NOI18N

        gerbong.setText("Nomor Gerbong");

        npenumpang.setText("Nama Penumpang");

        jmlhBeli.setText("Jumlah Beli");

        ttlBayar.setText("Total Bayar");

        cbo_gerbong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Input Nomor Gerbang", "1", "2", "3", "4" }));
        cbo_gerbong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_gerbongActionPerformed(evt);
            }
        });

        txt_npenumpang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_npenumpangActionPerformed(evt);
            }
        });

        txt_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bayarActionPerformed(evt);
            }
        });

        cbo_jmltkt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cbo_jmltkt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_jmltktActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(npenumpang)
                        .addComponent(gerbong, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jmlhBeli, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(ttlBayar))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_bayar)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_gerbong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_npenumpang, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbo_jmltkt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gerbong)
                    .addComponent(cbo_gerbong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(npenumpang)
                    .addComponent(txt_npenumpang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jmlhBeli)
                    .addComponent(cbo_jmltkt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ttlBayar)
                    .addComponent(txt_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 320, 260));

        btn_cetak.setBackground(new java.awt.Color(255, 119, 41));
        btn_cetak.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_cetak.setForeground(new java.awt.Color(255, 255, 255));
        btn_cetak.setText("CETAK TIKET");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, -1));

        btn_hitung.setBackground(new java.awt.Color(255, 119, 41));
        btn_hitung.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_hitung.setForeground(new java.awt.Color(255, 255, 255));
        btn_hitung.setText("HITUNG");
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitungActionPerformed(evt);
            }
        });
        jPanel1.add(btn_hitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("*Beli 5 Tiket Eksekutif Akan Mendapatkan Total Diskon 20%");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tujuanComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tujuanComboBoxActionPerformed
        if(tujuanComboBox.getSelectedItem().equals("Pilih Tujuan")){
            buttonGroup1.clearSelection();
            txt_harga.setText("");   
        }
        else if (tujuanComboBox.getSelectedItem().equals("GAMBIR")){
            ekonomi=150000;
            bisnis=250000;
            eksekutif=510000;
            tjn="GAMBIR";
        }
        else if (tujuanComboBox.getSelectedItem().equals("YOGYAKARTA")){
            ekonomi=260000;
            bisnis=320000;
            eksekutif=640000;
            tjn="YOGYAKARTA";
        }
        else if (tujuanComboBox.getSelectedItem().equals("SURABAYA")){
            ekonomi=360000;
            bisnis=475000;
            eksekutif=750000;
            tjn="SURABAYA";
        }
        else if (tujuanComboBox.getSelectedItem().equals("PASAR SENEN")){
            ekonomi=45000;
            bisnis=150000;
            eksekutif=350000;
            tjn="PASAR SENEN";
        }
        else if (tujuanComboBox.getSelectedItem().equals("MALANG")){
            ekonomi=290000;
            bisnis=360000;
            eksekutif=680000;
            tjn="MALANG";
        }
        txt_harga.setText(String.valueOf(harga));
    }//GEN-LAST:event_tujuanComboBoxActionPerformed

    private void rb_ekonomiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_ekonomiActionPerformed
        // TODO add your handling code here:
        if(rb_ekonomi.isSelected()){
        harga = ekonomi;
        txt_harga.setText(String.valueOf(ekonomi));
        hrg = Integer.parseInt(txt_harga.getText());
        kls="Ekonomi";
        isEkonomiSelected = true;
        } else {
        isEkonomiSelected = false;
    }
    }//GEN-LAST:event_rb_ekonomiActionPerformed

    private void rb_bisnisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_bisnisActionPerformed
        // TODO add your handling code here:
        if(rb_bisnis.isSelected()){
        harga = bisnis;
        txt_harga.setText(String.valueOf(bisnis));
        hrg = Integer.parseInt(txt_harga.getText());
        kls="Bisnis";
        isBisnisSelected = true;
    } else {
        isBisnisSelected = false;
    }
    }//GEN-LAST:event_rb_bisnisActionPerformed

    private void rb_eksekutifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_eksekutifActionPerformed
        // TODO add your handling code here:
        if(rb_eksekutif.isSelected()){
        harga = eksekutif;
        txt_harga.setText(String.valueOf(eksekutif));
        hrg = Integer.parseInt(txt_harga.getText());
        kls="Eksekutif";
        isEksekutifSelected = true;
    } else {
        isEksekutifSelected = false;
        }
    }//GEN-LAST:event_rb_eksekutifActionPerformed

    private void tglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tglActionPerformed

    private void txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaActionPerformed

    private void cbo_gerbongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_gerbongActionPerformed
        // TODO add your handling code here:
        if(cbo_gerbong.getSelectedItem().equals("Input Nomor Gerbong")){
            buttonGroup1.clearSelection();   
        }
        else if (cbo_gerbong.getSelectedItem().equals("1")){
            nomor="1";
        }
        else if (cbo_gerbong.getSelectedItem().equals("2")){
            nomor="2";
        }
        else if (cbo_gerbong.getSelectedItem().equals("3")){
            nomor="3";
        }
        else if (cbo_gerbong.getSelectedItem().equals("4")){
            nomor="4";
        }
    }//GEN-LAST:event_cbo_gerbongActionPerformed

    private void txt_npenumpangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_npenumpangActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_npenumpangActionPerformed

    private void txt_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bayarActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        // TODO add your handling code here:
        nama = txt_npenumpang.getText();
        tanggal = tgl.getText();
        Cetak ct = new Cetak();
        ct.pack();
        ct.setVisible(true);
        ct.setLocationRelativeTo(null);
        ct.setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void cbo_jmltktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_jmltktActionPerformed
        // TODO add your handling code here:
     int selectedIndex = cbo_jmltkt.getSelectedIndex();

    if (selectedIndex >= 0 && selectedIndex <= 5) {
        for (int i = 0; i <= selectedIndex; i++) {
            jumlahbeli = i + 1;
        }
    }
    }//GEN-LAST:event_cbo_jmltktActionPerformed

    private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed
        // TODO add your handling code here:
        String tujuan = tujuanComboBox.getSelectedItem().toString(); 
        int beli = jumlahbeli;
        int total = 0;

        if (isEkonomiSelected) {
            EkonomiTicketCalculator ekonomiCalculator = new EkonomiTicketCalculator(tujuan,beli);
            total = ekonomiCalculator.calculateTotal();
        } else if (isBisnisSelected) {
            BisnisTicketCalculator bisnisCalculator = new BisnisTicketCalculator(tujuan,beli);
            total = bisnisCalculator.calculateTotal();
        } else if (isEksekutifSelected) {
            EksekutifTicketCalculator eksekutifCalculator = new EksekutifTicketCalculator(tujuan,beli);
            
            // Jika jumlah tiket adalah 5, terapkan promo
            if (beli == 5) {
            String promoCode = "PROMO20"; // Contoh promo diskon 20%
            total = eksekutifCalculator.calculateTotal(promoCode);
            } else {
            total = eksekutifCalculator.calculateTotal();
            }
        }

        txt_bayar.setText(String.valueOf(total));
        byr = total;
    }//GEN-LAST:event_btn_hitungActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_hitung;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_gerbong;
    private javax.swing.JComboBox<String> cbo_jmltkt;
    private javax.swing.JLabel gerbong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jmlhBeli;
    private javax.swing.JLabel npenumpang;
    private javax.swing.JRadioButton rb_bisnis;
    private javax.swing.JRadioButton rb_ekonomi;
    private javax.swing.JRadioButton rb_eksekutif;
    private javax.swing.JTextField tgl;
    private javax.swing.JLabel ttlBayar;
    private javax.swing.JComboBox<String> tujuanComboBox;
    private javax.swing.JTextField txt_bayar;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_npenumpang;
    // End of variables declaration//GEN-END:variables
}

