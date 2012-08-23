package sistem_alcom;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
        
        
public class frm_penjualan extends javax.swing.JFrame {
    Connection cn=null;
    ResultSet rstransaksi=null;
    DefaultTableModel tabModelTransaksi;
    
    ResultSet rsfaktur=null;
    ResultSet rsFktr=null;
    DefaultTableModel tabModelFaktur;
    
    ResultSet rssma=null;

    public frm_penjualan() {
        initComponents();
        koneksi();
        comboNik();
        comboPlg();
        comboBrg();
        jTextFieldTtlFktr.setText("0");
        fakturakhir();
    }
    
    
    void koneksi(){
        try{
            //aktifkan driver
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/sis_alcom","root","");
            Object[] judul_kolom = {"Kode Barang","Nama Barang","Harga","Qty","Jumlah"};
            tabModelTransaksi=new DefaultTableModel(null,judul_kolom);
            jTableRincian.setModel(tabModelTransaksi);
            
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
        
    void comboNik(){
        try {
            Statement stmCbNik;
            stmCbNik=cn.createStatement();
            rsfaktur=stmCbNik.executeQuery("select * from karyawan");
            while(rsfaktur.next()){
                jComboBoxNikFktr.addItem(rsfaktur.getString("nik"));
                
            }
            rsfaktur.close();
            stmCbNik.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    void comboPlg(){
        try {
            Statement stmCbPlg;
            stmCbPlg=cn.createStatement();
            rsfaktur=stmCbPlg.executeQuery("select * from pelanggan");
            while(rsfaktur.next()){
                jComboBoxKdPelFktr.addItem(rsfaktur.getString("kode_pel"));                         
            }
            rsfaktur.close();
            stmCbPlg.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    void comboBrg(){
        try{
            Statement stmCbBrg;
            stmCbBrg=cn.createStatement();
            rstransaksi=stmCbBrg.executeQuery("select * from barang");
            while(rstransaksi.next()){
                jComboBoxKdBrg.addItem(rstransaksi.getString("kode_barang"));
                
            }
            rstransaksi.close();
            stmCbBrg.close();
                    
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    void fakturakhir(){
        try{
            Statement stm;
            stm=cn.createStatement();
            rssma=stm.executeQuery("select no_faktur from faktur where no_faktur=(select max(no_faktur)from faktur)");
            while(rssma.next()){
                jTextFieldAkhrFktr.setText(rssma.getString("no_faktur"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    void tampilrincian(){
        try{
            Statement stmr;
            stmr=cn.createStatement();
            tabModelTransaksi.getDataVector().removeAllElements();
            rstransaksi=stmr.executeQuery("select trans_jual.no_faktur,trans_jual.qty_jual,trans_jual.kode_barang,barang.nama_barang,barang.harga_jual,(barang.harga_jual*trans_jual.qty_jual)as jumlah from trans_jual inner join barang on barang.kode_barang=trans_jual.kode_barang where no_faktur='"+jTextFieldNoFktr.getText()+"'");
            while(rstransaksi.next()){
                Object[] data={rstransaksi.getString("kode_barang"),
                               rstransaksi.getString("nama_barang"),
                               rstransaksi.getString("harga_jual"),
                               rstransaksi.getString("qty_jual"),
                               rstransaksi.getString("jumlah")
                };
                tabModelTransaksi.addRow(data);
            }
            
        
        }catch(Exception e){
            e.printStackTrace();
                    
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNmPelFktr = new javax.swing.JTextField();
        jButtonHpsBrg = new javax.swing.JButton();
        jTextFieldNoFktr = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableRincian = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTglFktr = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonUpdateBrg = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldAkhrFktr = new javax.swing.JTextField();
        jTextFieldPnrmFktr = new javax.swing.JTextField();
        jTextFieldTtlFktr = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxNikFktr = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonAddFktr = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxKdBrg = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldNmBrg = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldQty = new javax.swing.JTextField();
        jTextFieldHrgBrg = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButtonBeliBrg = new javax.swing.JButton();
        jComboBoxKdPelFktr = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jButtonMnUtm = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(214, 214));

        jLabel4.setText("Tanggal Jual");

        jTextFieldNmPelFktr.setEditable(false);

        jButtonHpsBrg.setText("Hapus");
        jButtonHpsBrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHpsBrgActionPerformed(evt);
            }
        });

        jTextFieldNoFktr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNoFktrKeyPressed(evt);
            }
        });

        jTableRincian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama", "Qty", "Harga", "Jumlah"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRincian.setColumnSelectionAllowed(true);
        jTableRincian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRincianMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableRincian);
        jTableRincian.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel1.setText("No Faktur");

        jTextFieldTglFktr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTglFktrKeyPressed(evt);
            }
        });

        jLabel3.setText("Kode Pelanggan");

        jButtonUpdateBrg.setText("Update");
        jButtonUpdateBrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateBrgActionPerformed(evt);
            }
        });

        jLabel5.setText("Nama Pelanggan");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setText("Transaksi Penjualan");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Transaksi");

        jTextFieldAkhrFktr.setEditable(false);
        jTextFieldAkhrFktr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAkhrFktrKeyPressed(evt);
            }
        });

        jTextFieldTtlFktr.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel9.setText("NIK");

        jLabel10.setText("Penerima");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel11.setText("Total");

        jLabel12.setText("Faktur Akhir");

        jButtonAddFktr.setText("Add Faktur");
        jButtonAddFktr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddFktrActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel13.setText("Rincian Transaksi");

        jLabel14.setText("Kode Barang");

        jComboBoxKdBrg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxKdBrgItemStateChanged(evt);
            }
        });
        jComboBoxKdBrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxKdBrgActionPerformed(evt);
            }
        });

        jLabel15.setText("Nama Barang");

        jTextFieldNmBrg.setEditable(false);

        jLabel16.setText("Quantity");

        jTextFieldHrgBrg.setEditable(false);

        jLabel17.setText("Harga Barang");

        jButtonBeliBrg.setText("Beli");
        jButtonBeliBrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBeliBrgActionPerformed(evt);
            }
        });

        jComboBoxKdPelFktr.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxKdPelFktrItemStateChanged(evt);
            }
        });

        jLabel7.setText("yyyy/mm/dd");

        jButtonMnUtm.setText("Menu Utama");
        jButtonMnUtm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMnUtmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel7)
                        .addGap(193, 193, 193))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel6)
                        .addGap(186, 186, 186))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(405, 405, 405))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1)
                                .addComponent(jLabel9))
                            .addGap(4, 4, 4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldTglFktr, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldNoFktr, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxKdPelFktr, 0, 227, Short.MAX_VALUE)
                                .addComponent(jTextFieldPnrmFktr, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxNikFktr, 0, 227, Short.MAX_VALUE)
                                .addComponent(jTextFieldNmPelFktr, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel11)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel12)
                                .addComponent(jTextFieldTtlFktr, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                .addComponent(jTextFieldAkhrFktr))
                            .addGap(65, 65, 65))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonAddFktr)
                            .addGap(96, 96, 96)
                            .addComponent(jButtonMnUtm))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextFieldHrgBrg, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addGap(20, 20, 20)
                                            .addComponent(jTextFieldNmBrg, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addGap(23, 23, 23)
                                            .addComponent(jComboBoxKdBrg, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(jLabel16)
                                            .addGap(10, 10, 10)
                                            .addComponent(jTextFieldQty, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonBeliBrg, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                        .addComponent(jButtonUpdateBrg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonHpsBrg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGap(3, 3, 3))))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxNikFktr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(9, 9, 9)
                        .addComponent(jTextFieldNoFktr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAkhrFktr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jComboBoxKdPelFktr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(jTextFieldNmPelFktr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(jTextFieldTglFktr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldTtlFktr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addComponent(jTextFieldPnrmFktr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAddFktr)
                    .addComponent(jButtonMnUtm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel16))
                                    .addComponent(jTextFieldQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxKdBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButtonBeliBrg)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldNmBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonUpdateBrg))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jTextFieldHrgBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonHpsBrg))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButtonHpsBrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHpsBrgActionPerformed
try{
    Statement stmr;
    stmr=cn.createStatement();
    stmr.executeUpdate("delete from trans_jual where kode_barang='"+tabModelTransaksi.getValueAt(jTableRincian.getSelectedRow(),0)+"'");
    tampilrincian();
}catch(Exception e){
    e.printStackTrace();
}
}//GEN-LAST:event_jButtonHpsBrgActionPerformed

private void jTextFieldNoFktrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNoFktrKeyPressed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldNoFktrKeyPressed

private void jTableRincianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRincianMouseClicked
jComboBoxKdBrg.setSelectedItem(tabModelTransaksi.getValueAt(jTableRincian.getSelectedRow(),0));
jTextFieldQty.setText(tabModelTransaksi.getValueAt(jTableRincian.getSelectedRow(),3)+"");
}//GEN-LAST:event_jTableRincianMouseClicked

private void jTextFieldTglFktrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTglFktrKeyPressed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldTglFktrKeyPressed

private void jButtonUpdateBrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateBrgActionPerformed
try{
    Statement stmr;
    stmr=cn.createStatement();
    stmr.executeUpdate("update trans_jual set kode_barang='"+jComboBoxKdBrg.getSelectedItem()+"',"+
                       "qty_jual='"+jTextFieldQty.getText()+"' where no_faktur='"+jTextFieldNoFktr.getText()+"' and kode_barang ='"+jComboBoxKdBrg.getSelectedItem()+"'");
    tampilrincian();
    //hapus view rincian
        try{
            Statement stm;
            stm=cn.createStatement();
            stm.executeUpdate("drop view rincian");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        //buat view rincian nested query
        try{
            Statement stm;
            stm=cn.createStatement();
            stm.executeUpdate("create view rincian as select trans_jual.no_faktur,trans_jual.qty_jual,trans_jual.kode_barang,barang.nama_barang,barang.harga_jual,(barang.harga_jual*trans_jual.qty_jual)as jumlah from trans_jual inner join barang on barang.kode_barang=trans_jual.kode_barang where no_faktur='"+jTextFieldNoFktr.getText()+"'");
        
        }catch(Exception e){
            e.printStackTrace();
                    
        }
         //nested query
        try{
            Statement stm;
            stm=cn.createStatement();
            rstransaksi=stm.executeQuery("select sum(jumlah) as total from rincian");
            while (rstransaksi.next()){
                jTextFieldTtlFktr.setText(rstransaksi.getString("total"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
}catch(Exception e){
    e.printStackTrace();
}
}//GEN-LAST:event_jButtonUpdateBrgActionPerformed

    private void jTextFieldAkhrFktrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAkhrFktrKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAkhrFktrKeyPressed

    private void jButtonAddFktrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddFktrActionPerformed
    try{
        Statement stm=cn.createStatement();
        stm.executeUpdate("insert into faktur set no_faktur='"+jTextFieldNoFktr.getText()+"',"+
                           "kode_pelanggan='"+jComboBoxKdPelFktr.getSelectedItem()+"',"+
                           "tgl_jual='"+jTextFieldTglFktr.getText()+"',"+
                           "total_Jual='"+jTextFieldTtlFktr.getText()+"',"+
                           "nik='"+jComboBoxNikFktr.getSelectedItem()+"',"+
                           "penerima='"+jTextFieldPnrmFktr.getText()+"'");
        jTextFieldQty.requestFocus();
        
    }catch(Exception e){
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButtonAddFktrActionPerformed

    private void jButtonBeliBrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBeliBrgActionPerformed
    try{
        Statement stm=cn.createStatement();
        stm.executeUpdate("insert into trans_jual set no_faktur='"+jTextFieldNoFktr.getText()+"',"+
                           "kode_barang='"+jComboBoxKdBrg.getSelectedItem()+"',"+
                           "qty_jual='"+jTextFieldQty.getText()+"'");
        
        tampilrincian();
        //hapus view rincian
        try{
            Statement stmr;
            stmr=cn.createStatement();
            stmr.executeUpdate("drop view rincian");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        //buat view rincian nested query
        try{
            Statement stmr;
            stmr=cn.createStatement();
            stmr.executeUpdate("create view rincian as select trans_jual.no_faktur,trans_jual.qty_jual,trans_jual.kode_barang,barang.nama_barang,barang.harga_jual,(barang.harga_jual*trans_jual.qty_jual)as jumlah from trans_jual inner join barang on barang.kode_barang=trans_jual.kode_barang where no_faktur='"+jTextFieldNoFktr.getText()+"'");
        
        }catch(Exception e){
            e.printStackTrace();
                    
        }
        
        //nested query
        try{
            Statement stmr;
            stmr=cn.createStatement();
            rstransaksi=stmr.executeQuery("select sum(jumlah) as total from rincian");
            while (rstransaksi.next()){
                jTextFieldTtlFktr.setText(rstransaksi.getString("total"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //Update Total_jual ke tabel faktur
        try{
            Statement stmr;
            stmr=cn.createStatement();
            stmr.executeUpdate("update faktur set total_jual='"+jTextFieldTtlFktr.getText()+"' where no_faktur='"+jTextFieldNoFktr.getText()+"'");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }catch(Exception e){
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButtonBeliBrgActionPerformed

    private void jComboBoxKdBrgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxKdBrgItemStateChanged
    try{
        Statement stm=cn.createStatement();
        rssma=stm.executeQuery("select nama_barang,harga_jual from barang where kode_barang='"+jComboBoxKdBrg.getSelectedItem()+"'");
        while(rssma.next()){
            jTextFieldNmBrg.setText(rssma.getString("nama_barang"));
            jTextFieldHrgBrg.setText(rssma.getString("harga_jual"));
        }
    
    }catch(Exception e){
        e.printStackTrace();
    }
    }//GEN-LAST:event_jComboBoxKdBrgItemStateChanged

    private void jComboBoxKdBrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxKdBrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxKdBrgActionPerformed

    private void jComboBoxKdPelFktrItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxKdPelFktrItemStateChanged
    try{
        Statement stm=cn.createStatement();
        rssma=stm.executeQuery("select nama_pel from pelanggan where kode_pel='"+jComboBoxKdPelFktr.getSelectedItem()+"'");
        while(rssma.next()){
            jTextFieldNmPelFktr.setText(rssma.getString("nama_pel"));
        }
                
    }catch(Exception e){
        e.printStackTrace();
    }
    }//GEN-LAST:event_jComboBoxKdPelFktrItemStateChanged

    private void jButtonMnUtmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMnUtmActionPerformed
this.dispose();
        this.dispose();     }//GEN-LAST:event_jButtonMnUtmActionPerformed

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
            java.util.logging.Logger.getLogger(frm_penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frm_penjualan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddFktr;
    private javax.swing.JButton jButtonBeliBrg;
    private javax.swing.JButton jButtonHpsBrg;
    private javax.swing.JButton jButtonMnUtm;
    private javax.swing.JButton jButtonUpdateBrg;
    private javax.swing.JComboBox jComboBoxKdBrg;
    private javax.swing.JComboBox jComboBoxKdPelFktr;
    private javax.swing.JComboBox jComboBoxNikFktr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableRincian;
    private javax.swing.JTextField jTextFieldAkhrFktr;
    private javax.swing.JTextField jTextFieldHrgBrg;
    private javax.swing.JTextField jTextFieldNmBrg;
    private javax.swing.JTextField jTextFieldNmPelFktr;
    private javax.swing.JTextField jTextFieldNoFktr;
    private javax.swing.JTextField jTextFieldPnrmFktr;
    private javax.swing.JTextField jTextFieldQty;
    private javax.swing.JTextField jTextFieldTglFktr;
    private javax.swing.JTextField jTextFieldTtlFktr;
    // End of variables declaration//GEN-END:variables
}
