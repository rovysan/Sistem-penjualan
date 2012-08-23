package sistem_alcom;
import java.awt.Frame;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class frm_barang extends javax.swing.JFrame {
    Connection cn=null;
    ResultSet rsbarang=null;
    DefaultTableModel tabModel;

    public frm_barang() {
        initComponents();
        konek();
        tampilData();
        
    }
       
    void konek(){
        try{
            //aktif driver
            Class.forName("com.mysql.jdbc.Driver");
            //konek database
            cn=DriverManager.getConnection("jdbc:mysql://localhost/sis_alcom","root","");
            Object[] judul_kolom = {"Kode Barang","Nama Barang","Harga Beli","Harga Jual","Quantity"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            jTableBrg.setModel(tabModel);
     //       tampilData();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    void tampilData(){
        try{
            Statement stm; //buat stm
            stm=cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            rsbarang=stm.executeQuery("select * from barang");//mengambil data barang
            while(rsbarang.next()){
                Object[] data={rsbarang.getString("kode_barang"),
                               rsbarang.getString("nama_barang"),
                               rsbarang.getString("harga_beli"),
                               rsbarang.getString("harga_jual"),
                               rsbarang.getString("quantity")
                };
                tabModel.addRow(data);
            }
        }catch(Exception e){
            e.printStackTrace();
                    
        }
    }
    void tblKeForm(){
        jTextFieldKdBrg.setText(tabModel.getValueAt(jTableBrg.getSelectedRow(),0)+"");
        jTextFieldNmBrg.setText(tabModel.getValueAt(jTableBrg.getSelectedRow(),1)+"");
        jTextFieldHgBeli.setText(tabModel.getValueAt(jTableBrg.getSelectedRow(),2)+"");
        jTextFieldHgJual.setText(tabModel.getValueAt(jTableBrg.getSelectedRow(),3)+"");
        jTextFieldQty.setText(tabModel.getValueAt(jTableBrg.getSelectedRow(),4)+"");
    }
    
    void kosongkanForm(){
        jTextFieldKdBrg.setText("");
        jTextFieldNmBrg.setText("");
        jTextFieldHgBeli.setText("");
        jTextFieldHgJual.setText("");
        jTextFieldQty.setText("");
    }

       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jButtonSimpan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonHapus = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBrg = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldKdBrg = new javax.swing.JTextField();
        jTextFieldHgBeli = new javax.swing.JTextField();
        jTextFieldHgJual = new javax.swing.JTextField();
        jTextFieldQty = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNmBrg = new javax.swing.JTextField();
        jTextFieldCari = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButtonMnUtm = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonSimpan.setText("Simpan");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

        jLabel1.setText("Kode Barang");

        jLabel2.setText("Nama Barang");

        jLabel4.setText("Harga Jual");

        jLabel5.setText("Quantity");

        jButtonHapus.setText("Hapus");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Perbarui");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonCari.setText("Cari");
        jButtonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCariActionPerformed(evt);
            }
        });

        jTableBrg.setModel(new javax.swing.table.DefaultTableModel(
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
                "Kode Barang", "Nama Barang", "Harga Beli", "Harga Jual", "Quantity"
            }
        ));
        jTableBrg.setColumnSelectionAllowed(true);
        jTableBrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBrgMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBrg);
        jTableBrg.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setText("Entry Data Barang");

        jTextFieldKdBrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldKdBrgKeyPressed(evt);
            }
        });

        jLabel3.setText("Harga Beli");

        jLabel7.setText("Cari Berdasarkan Nama Barang");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButtonSimpan)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonHapus)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUpdate)
                        .addGap(41, 41, 41)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonMnUtm))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldQty, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHgBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldKdBrg)
                                    .addComponent(jTextFieldNmBrg, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonCari)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7)))
                            .addComponent(jTextFieldHgJual, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldKdBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNmBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCari)
                    .addComponent(jTextFieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldHgBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldHgJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSimpan)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonUpdate)
                        .addComponent(jButtonHapus)
                        .addComponent(jButton1)
                        .addComponent(jButtonMnUtm)))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
try{
    Statement stm=cn.createStatement();
    stm.executeUpdate("insert into barang set kode_barang='"+jTextFieldKdBrg.getText()+"',"+
                      "nama_barang='"+jTextFieldNmBrg.getText()+"',"+
                      "harga_beli='"+jTextFieldHgBeli.getText()+"',"+
                      "harga_jual='"+jTextFieldHgJual.getText()+"',"+
                      "quantity='"+jTextFieldQty.getText()+"'");
    
    kosongkanForm();
    //set Focus Kode Barang
    jTextFieldKdBrg.requestFocus();
    
    tampilData();
}catch(Exception e){
    e.printStackTrace();
}
}//GEN-LAST:event_jButtonSimpanActionPerformed

private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
try{
    Statement stm=cn.createStatement();
    stm.executeUpdate("delete from barang where kode_barang='"+
            tabModel.getValueAt(jTableBrg.getSelectedRow(),0)+"'");
    
    tampilData();
    
}catch(Exception e){
    e.printStackTrace();
}
}//GEN-LAST:event_jButtonHapusActionPerformed

private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
try{
    Statement stm=cn.createStatement();
    stm.executeUpdate("update barang set kode_barang='"+jTextFieldKdBrg.getText()+"',"+
                      "nama_barang='"+jTextFieldNmBrg.getText()+"',"+
                      "harga_beli='"+jTextFieldHgBeli.getText()+"',"+
                      "harga_jual='"+jTextFieldHgJual.getText()+"',"+
                      "quantity='"+jTextFieldQty.getText()+"'where kode_barang='"+
                      tabModel.getValueAt(jTableBrg.getSelectedRow(),0)+"'");
    tampilData();
    kosongkanForm();
}catch(Exception e){
    e.printStackTrace();
}

}//GEN-LAST:event_jButtonUpdateActionPerformed

private void jTableBrgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBrgMouseClicked
tblKeForm();

}//GEN-LAST:event_jTableBrgMouseClicked

private void jButtonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCariActionPerformed
    try{
        Statement stm=cn.createStatement();
        tabModel.getDataVector().removeAllElements();
        rsbarang=stm.executeQuery("select * from barang where kode_barang like '%"+jTextFieldCari.getText()+"%'");
        while (rsbarang.next()){
        Object [] data={rsbarang.getString("kode_barang"),
                        rsbarang.getString("nama_barang"),
                        rsbarang.getString("harga_beli"),
                        rsbarang.getString("harga_beli"),
                        rsbarang.getString("quantity"),
            };
        tabModel.addRow(data);
        }

    
    }catch(Exception e){
           e.printStackTrace();
     }
}//GEN-LAST:event_jButtonCariActionPerformed

private void jTextFieldKdBrgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldKdBrgKeyPressed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldKdBrgKeyPressed

    private void jButtonMnUtmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMnUtmActionPerformed
this.dispose();
    }//GEN-LAST:event_jButtonMnUtmActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    jTextFieldKdBrg.setText(null);
    jTextFieldNmBrg.setText(null);
    jTextFieldHgBeli.setText(null);
    jTextFieldHgJual.setText(null);
    jTextFieldQty.setText(null);
}//GEN-LAST:event_jButton1ActionPerformed

  
    public static void main(String args[]) {
    
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frm_barang().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBrg;
    private javax.swing.JTextField jTextFieldCari;
    private javax.swing.JTextField jTextFieldHgBeli;
    private javax.swing.JTextField jTextFieldHgJual;
    private javax.swing.JTextField jTextFieldKdBrg;
    private javax.swing.JTextField jTextFieldNmBrg;
    private javax.swing.JTextField jTextFieldQty;
    // End of variables declaration//GEN-END:variables
}
