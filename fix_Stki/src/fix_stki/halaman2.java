package fix_stki;


import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import fix_stki.DocumentParser;
import fix_stki.fungsi;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author toshiba
 */
public class halaman2 extends javax.swing.JFrame {

    String usernamedb = "root";
    String passworddb = "";
    String namaDB = "stki";
    
    DefaultTableModel model;
    DefaultTableModel model2;
    DefaultTableModel model3;
            /**
     * Creates new form Halaman_Awal
     */
    public halaman2() {
        initComponents();
        try {
            generate();
        } catch (SQLException ex) {
            Logger.getLogger(halaman2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        jInternalFrame1.setVisible(false);
    
    
    
    
    
    }
public void generate() throws SQLException{
    
     koneksi x = new koneksi();
     Connection koneksi = x.getConnectionTB(usernamedb, passworddb, namaDB);
     
    
        
        
     DefaultTableModel isitabel = new DefaultTableModel();
        
        tabel_buku.setModel(isitabel);
       Object[] tabel_buku2={"NOMOR","JUDUL BUKU","KETERANGAN","SEGMENTASI","UKURAN","JENIS COVER","TAHUN TERBIT","TEBAL BUKU","ISBN",};
        isitabel=new DefaultTableModel(null, tabel_buku2);
        tabel_buku.setModel(isitabel);
        try {
            
            Statement stat=koneksi.createStatement();
            ResultSet res=stat.executeQuery("SELECT  b.ID_BUKU, b.JUDUL_BUKU, b.KATERANGAN, b.SEGMENTASI, b.UKURAN, b.JENIS_COVER, b.TAHUN_TERBIT, b.TEBAL_BUKU, b.ISBN FROM buku b");
            while (res.next()) {
                String[] dataField = {res.getString("ID_BUKU"),res.getString("JUDUL_BUKU"),res.getString("KATERANGAN"),res.getString("SEGMENTASI"),res.getString("UKURAN"),res.getString("JENIS_COVER"),res.getString("TAHUN_TERBIT"),res.getString("TEBAL_BUKU"),res.getString("ISBN"),};
                
                isitabel.addRow(dataField);
               
            }
        }
        catch(Exception e) {
             }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        isFon = new javax.swing.JComboBox();
        search = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_buku = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pict/opac.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame1.setVisible(true);

        jPanel4.setLayout(null);

        jLabel6.setText("TreesHold 70");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(20, 200, 100, 20);

        jLabel7.setText("TreesHold 80");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(20, 310, 100, 30);

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
        jScrollPane2.setViewportView(jTable1);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(20, 230, 930, 60);

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
        jScrollPane3.setViewportView(jTable2);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(20, 350, 930, 60);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(810, 140, 110, 40);

        jLabel8.setText("tidak ada treshold");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(30, 430, 180, 10);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable3);

        jPanel4.add(jScrollPane4);
        jScrollPane4.setBounds(20, 460, 930, 70);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pict/opac.jpg"))); // NOI18N
        jPanel4.add(jLabel5);
        jLabel5.setBounds(-180, 0, 1160, 760);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1000, 650));

        isFon.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fonetik 1", "Fonetik 2" }));
        jPanel1.add(isFon, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 220, 40));

        search.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SEARCH BY", "JUDUL BUKU", "PENULIS", "PENERBIT" }));
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 229, 40));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(halaman2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(halaman2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 122, 50));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 463, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pict/Background_2022.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-170, -110, 1250, 820));

        jTabbedPane1.addTab("   Pencarian    ", jPanel1);

        jPanel2.setLayout(null);

        tabel_buku.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_buku);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(24, 276, 950, 260);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pict/Background_2022.jpg"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(-170, -110, 1250, 820);

        jTabbedPane1.addTab("   Koleksi Buku   ", jPanel2);

        jPanel3.setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pict/Background_2022new.jpg"))); // NOI18N
        jPanel3.add(jLabel4);
        jLabel4.setBounds(-170, -110, 1250, 820);

        jTabbedPane1.addTab("    Developer    ", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
DocumentParser dp;
fungsi fungsi = new fungsi();
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException, FileNotFoundException, SQLException {                                         
        jInternalFrame1.setVisible(true);
    

        
         //jTextArea1.setText("");
          dp = new DocumentParser();
          String a= jTextField1.getText();
        if (isFon.getSelectedIndex()==0) {
            dp.parseFiles(fungsi.konverterPrimary(a), true);
            System.out.println("fon 1" +fungsi.konverterPrimary(a));
        } else {
            dp.parseFiles(fungsi.konverterSecondary(a), false);
            System.out.println("fon 2" +fungsi.konverterSecondary(a));
        }
      
        dp.tfIdfCalculator(); //calculates tfidf
        dp.getCosineSimilarity(); //calculated cosine similarity  
        DocumentParser doc = new DocumentParser();
        
        
        
        model = dp.tabelRank(model);
        jTable1.setModel(model);
        model2 = dp.tabelRank2(model2);
        jTable2.setModel(model2);
        //dp.rangking(jTextArea1);
          model3= dp.tabelRank3(model3);
        jTable3.setModel(model3);
        
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
jInternalFrame1.setVisible(false);
    }                                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

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
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new halaman2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JComboBox isFon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox search;
    private javax.swing.JTable tabel_buku;
    // End of variables declaration                   
}
