package sistem_alcom;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class frm_pelanggan extends javax.swing.JFrame {
    Connection cn=null;
    ResultSet rspelanggan=null;
    DefaultTableModel tabModel;

    
    public frm_pelanggan() {
        initComponents();
        konek();
    }
    
    void konek(){
    try{
            //aktif driver
        Class.forName("com.mysql.jdbc.Driver");
        cn=DriverManager.getConnection("jdbc:mysql://localhost/sis_alcom","root","");
        Object [] judul_kolom={"Kd Pelanggan","Nama","Alamat","Telp"};
        tabModel=new DefaultTableModel(null,judul_kolom);
        jTablePlg.setModel(tabModel);
        tampilData();
        
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
    
    void tampilData(){
    try{
        Statement stm; //buat stm
        stm=cn.createStatement();
        tabModel.getDataVector().removeAllElements();
        rspelanggan=stm.executeQuery("select * from pelanggan");
        while(rspelanggan.next()){
            Object [] data={rspelanggan.getString("kode_pel"),
                            rspelanggan.getString("nama_pel"),
                            rspelanggan.getString("alt_pel"),
                            rspelanggan.getString("telp_pel")};
            tabModel.addRow(data);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    
        void kosongkanform(){
        jTextFieldKdPlg.setText("");
        jTextFieldNmPel.setText("");
        jTextFieldAltPlg.setText("");
        jTextFieldTelp.setText("");
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonCari = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePlg = new javax.swing.JTable();
        jTextFieldKdPlg = new javax.swing.JTextField();
        jButtonUpdate = new javax.swing.JButton();
        jTextFieldCari = new javax.swing.JTextField();
        jTextFieldAltPlg = new javax.swing.JTextField();
        jButtonSimpan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNmPel = new javax.swing.JTextField();
        jButtonHapus = new javax.swing.JButton();
        jTextFieldTelp = new javax.swing.JTextField();
        jButtonMnUtm = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Entry Data Pelanggan");

        jLabel7.setText("Cari Berdasarkan Nama");

        jButtonCari.setText("Cari");
        jButtonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCariActionPerformed(evt);
            }
        });

        jLabel3.setText("Alamat");

        jLabel1.setText("Kode Pelanggan");

        jTablePlg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Pel", "Nama Lengkap", "Alamat", "Telp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePlg.setColumnSelectionAllowed(true);
        jTablePlg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePlgMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePlg);
        jTablePlg.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jTextFieldKdPlg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldKdPlgKeyPressed(evt);
            }
        });

        jButtonUpdate.setText("Perbarui");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonSimpan.setText("Simpan");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

        jLabel4.setText("Telp");

        jLabel2.setText("Nama Lengkap");

        jButtonHapus.setText("Hapus");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jTextFieldTelp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTelpKeyPressed(evt);
            }
        });

        jButtonMnUtm.setText("Menu Utama");
        jButtonMnUtm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMnUtmActionPerformed(evt);
            }
        });

        jButton1.setText("Kosongkan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonHapus)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonMnUtm)
                        .addGap(100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldKdPlg, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNmPel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonCari)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7))
                                .addGap(78, 78, 78))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAltPlg, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addContainerGap(257, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldKdPlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldNmPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonCari)
                                    .addComponent(jTextFieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addComponent(jTextFieldAltPlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jTextFieldTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSimpan)
                    .addComponent(jButtonHapus)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButton1)
                    .addComponent(jButtonMnUtm))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButtonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCariActionPerformed
try{
    Statement stm=cn.createStatement();
    tabModel.getDataVector().removeAllElements();
    rspelanggan=stm.executeQuery("select * from pelanggan where kode_pel like '%"+jTextFieldCari.getText()+"%'");
    while (rspelanggan.next()){
        Object[] data={rspelanggan.getString("kode_pel"),
                       rspelanggan.getString("nama_pel"),
                       rspelanggan.getString("alt_pel"),
                       rspelanggan.getString("telp_pel")
        };
        tabModel.addRow(data);
    }
}catch(Exception e){
    e.printStackTrace();
}
}//GEN-LAST:event_jButtonCariActionPerformed

private void jTablePlgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePlgMouseClicked
jTextFieldKdPlg.setText(tabModel.getValueAt(jTablePlg.getSelectedRow(),0)+"");
jTextFieldNmPel.setText(tabModel.getValueAt(jTablePlg.getSelectedRow(),1)+"");
jTextFieldAltPlg.setText(tabModel.getValueAt(jTablePlg.getSelectedRow(),2)+"");
jTextFieldTelp.setText(tabModel.getValueAt(jTablePlg.getSelectedRow(),3)+"");
}//GEN-LAST:event_jTablePlgMouseClicked

private void jTextFieldKdPlgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldKdPlgKeyPressed

}//GEN-LAST:event_jTextFieldKdPlgKeyPressed

private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
try{
    Statement stm=cn.createStatement();
    stm.executeUpdate("update pelanggan set kode_pel='"+jTextFieldKdPlg.getText()+"',"+
                       "nama_pel='"+jTextFieldNmPel.getText()+"',"+
                       "alt_pel='"+jTextFieldAltPlg.getText()+"',"+
                       "telp_pel='"+jTextFieldTelp.getText()+"'where kode_pel='"+
                       tabModel.getValueAt(jTablePlg.getSelectedRow(),0)+"'");
    tampilData();
    kosongkanform();
}catch(Exception e){
    e.printStackTrace();
}
}//GEN-LAST:event_jButtonUpdateActionPerformed

private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
try{
    Statement stm=cn.createStatement();
    stm.executeUpdate("insert into pelanggan set kode_pel='"+jTextFieldKdPlg.getText()+"',"+
                      "nama_pel='"+jTextFieldNmPel.getText()+"',"+
                      "alt_pel='"+jTextFieldAltPlg.getText()+"',"+
                      "telp_pel='"+jTextFieldTelp.getText()+"'");
    
    tampilData();
    kosongkanform();
}catch(Exception e){
    e.printStackTrace();
}
}//GEN-LAST:event_jButtonSimpanActionPerformed

private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
try{
    Statement stm=cn.createStatement();
    stm.executeUpdate("delete from pelanggan  where kode_pel='"+
                       tabModel.getValueAt(jTablePlg.getSelectedRow(),0)+"'");
    tampilData();
}catch(Exception e){
    e.printStackTrace();
}
}//GEN-LAST:event_jButtonHapusActionPerformed

private void jTextFieldTelpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelpKeyPressed

}//GEN-LAST:event_jTextFieldTelpKeyPressed

    private void jButtonMnUtmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMnUtmActionPerformed
this.dispose();
        this.dispose();     }//GEN-LAST:event_jButtonMnUtmActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
   jTextFieldKdPlg.setText(null); 
    jTextFieldNmPel.setText(null);
    jTextFieldAltPlg.setText(null);
    jTextFieldTelp.setText(null);
}//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frm_pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frm_pelanggan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCari;
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonMnUtm;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePlg;
    private javax.swing.JTextField jTextFieldAltPlg;
    private javax.swing.JTextField jTextFieldCari;
    private javax.swing.JTextField jTextFieldKdPlg;
    private javax.swing.JTextField jTextFieldNmPel;
    private javax.swing.JTextField jTextFieldTelp;
    // End of variables declaration//GEN-END:variables
}
