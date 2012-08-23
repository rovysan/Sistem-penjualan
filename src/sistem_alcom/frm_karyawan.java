
package sistem_alcom;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class frm_karyawan extends javax.swing.JFrame {
Connection cn=null;
ResultSet rskrywn=null;
DefaultTableModel tabModel;


    public frm_karyawan() {
        initComponents();
        konek();
    }
    
    void konek(){
        try{
            //aktif driver
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/sis_alcom","root","");
            Object[] judul_kolom={"NIK","Nama","Alamat","JK"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            jTableKaryawan.setModel(tabModel);
            tampilData();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    void tampilData(){
        try{
            Statement stm; //membuat statemen stm
            stm=cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            rskrywn=stm.executeQuery("select * from karyawan");//mengambil data karyawan
            while (rskrywn.next()){
                Object[] data={rskrywn.getString("nik"),
                               rskrywn.getString("nama"),
                               rskrywn.getString("alamat"),
                               rskrywn.getString("jk")
                           
                };
            tabModel.addRow(data);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    void kosongkanform(){
        jTextFieldNik.setText("");
        jTextFieldNm.setText("");
        jTextFieldAlamat.setText("");
        jComboBoxJk.setSelectedItem("");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCari = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButtonHapus = new javax.swing.JButton();
        jTextFieldNik = new javax.swing.JTextField();
        jButtonUpdate = new javax.swing.JButton();
        jTextFieldAlamat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNm = new javax.swing.JTextField();
        jTextFieldCari = new javax.swing.JTextField();
        jButtonSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKaryawan = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxJk = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jButtonMnUtm = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonCari.setText("Cari");
        jButtonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCariActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setText("Entry Data Karyawan");

        jButtonHapus.setText("Hapus");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jTextFieldNik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNikKeyPressed(evt);
            }
        });

        jButtonUpdate.setText("Perbarui");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jLabel4.setText("Jenis Kelamin");

        jLabel3.setText("Alamat");

        jLabel2.setText("Nama Lengkap");

        jButtonSimpan.setText("Simpan");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

        jTableKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIK", "Nama Lengkap", "Alamat", "JK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableKaryawan.setColumnSelectionAllowed(true);
        jTableKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKaryawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableKaryawan);
        jTableKaryawan.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel7.setText("Cari Berdasarkan Nama");

        jComboBoxJk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L", "P" }));
        jComboBoxJk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJkActionPerformed(evt);
            }
        });

        jLabel5.setText("NIK");

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
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButtonSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonHapus)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUpdate))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNm, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNik, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(157, 157, 157)
                                        .addComponent(jButton1)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(41, 41, 41))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonCari)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jButtonMnUtm))))
                            .addComponent(jComboBoxJk, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldNik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2))
                            .addComponent(jTextFieldNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCari)
                            .addComponent(jTextFieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxJk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSimpan)
                    .addComponent(jButtonHapus)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButton1)
                    .addComponent(jButtonMnUtm))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButtonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCariActionPerformed
try{
    Statement stm=cn.createStatement();
    tabModel.getDataVector().removeAllElements();
    rskrywn=stm.executeQuery("select * from karyawan where nama like '%"+jTextFieldCari.getText()+"%'");
    while (rskrywn.next()){
        Object[] data={rskrywn.getString("NIK"),
                       rskrywn.getString("nama"),
                       rskrywn.getString("alamat"),
                       rskrywn.getString("jk")
        };
        tabModel.addRow(data);
    }
}catch(Exception e){
    e.printStackTrace();
}
}//GEN-LAST:event_jButtonCariActionPerformed

private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
try{
    Statement stm=cn.createStatement();
    stm.executeUpdate("delete from karyawan where nik='"+
            tabModel.getValueAt(jTableKaryawan.getSelectedRow(),0)+"'");
    tampilData();
}catch(Exception e){
    e.printStackTrace();
}
}//GEN-LAST:event_jButtonHapusActionPerformed

private void jTextFieldNikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNikKeyPressed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldNikKeyPressed

private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
try{
    Statement stm=cn.createStatement();
    stm.executeUpdate("update karyawan set nik='"+jTextFieldNik.getText()+"',"+
                       "nama='"+jTextFieldNm.getText()+"',"+
                       "alamat='"+jTextFieldAlamat.getText()+"',"+
                       "jk='"+jComboBoxJk.getSelectedItem()+"'where nik='"+
                       tabModel.getValueAt(jTableKaryawan.getSelectedRow(),0)+"'");
    tampilData();
    kosongkanform();
}catch(Exception e){
    e.printStackTrace();
}
}//GEN-LAST:event_jButtonUpdateActionPerformed

private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
try{
    Statement stm=cn.createStatement();
    stm.executeUpdate("insert into karyawan set nik='"+jTextFieldNik.getText()+"',"+
                      "nama='"+jTextFieldNm.getText()+"',"+
                      "alamat='"+jTextFieldAlamat.getText()+"',"+
                      "jk='"+jComboBoxJk.getSelectedItem()+"'");
    
    tampilData();
    kosongkanform();
}catch(Exception e){
    e.printStackTrace();
}
}//GEN-LAST:event_jButtonSimpanActionPerformed

private void jTableKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableKaryawanMouseClicked
jTextFieldNik.setText(tabModel.getValueAt(jTableKaryawan.getSelectedRow(),0)+"");
jTextFieldNm.setText(tabModel.getValueAt(jTableKaryawan.getSelectedRow(),1)+"");
jTextFieldAlamat.setText(tabModel.getValueAt(jTableKaryawan.getSelectedRow(),2)+"");
jComboBoxJk.setSelectedItem(tabModel.getValueAt(jTableKaryawan.getSelectedRow(),3)+"");
}//GEN-LAST:event_jTableKaryawanMouseClicked

    private void jComboBoxJkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxJkActionPerformed

    }//GEN-LAST:event_jComboBoxJkActionPerformed

    private void jButtonMnUtmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMnUtmActionPerformed
this.dispose();
        this.dispose();     }//GEN-LAST:event_jButtonMnUtmActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    jTextFieldNik.setText(null);
    jTextFieldNm.setText(null);
    jTextFieldAlamat.setText(null);
}//GEN-LAST:event_jButton1ActionPerformed

  
    public static void main(String args[]) {
       
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
            java.util.logging.Logger.getLogger(frm_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frm_karyawan().setVisible(true);
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
    private javax.swing.JComboBox jComboBoxJk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableKaryawan;
    private javax.swing.JTextField jTextFieldAlamat;
    private javax.swing.JTextField jTextFieldCari;
    private javax.swing.JTextField jTextFieldNik;
    private javax.swing.JTextField jTextFieldNm;
    // End of variables declaration//GEN-END:variables
}
