/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fix_stki;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fachrian Anugerah
 */
public class DocumentParser {
    //This variable will hold all terms of each document in an array.
    private List<String[]> termsDocsArray = new ArrayList<String[]>();
    private List<String> allTerms = new ArrayList<String>(); //to hold all terms
    private List<double[]> tfidfDocsVector = new ArrayList<double[]>();
    Connection koneksi;
    String usernamedb = "root";
    String passworddb = "";
    String namaDB = "stki";
    int jumlahDokumen=0;
    String [] dokumen;
    double [] rangking;
    int [] idDoc;
    private Statement stat;
    private ResultSet res;
    private ResultSet ris;
    private String[] judul = new String[100];
    int []a= new int[20];
    
    
      public void set(String query) throws SQLException{
        koneksi x = new koneksi();
        koneksi = x.getConnectionTB(usernamedb, passworddb, namaDB);
        jumlahDokumen=getJumlahDokumen(koneksi)+1;
        
        dokumen = new String[jumlahDokumen];
        rangking = new double[jumlahDokumen];
        idDoc = new int[jumlahDokumen];
        dokumen[0]=query;
        getData(koneksi, dokumen);
    }
      
      
      
      
      public void set2(String query) throws SQLException{
        koneksi x = new koneksi();
        koneksi = x.getConnectionTB(usernamedb, passworddb, namaDB);
        jumlahDokumen=getJumlahDokumen2(koneksi)+1;
        
        dokumen = new String[jumlahDokumen];
        rangking = new double[jumlahDokumen];
        idDoc = new int[jumlahDokumen];
        dokumen[0]=query;
        getData2(koneksi, dokumen);
    }
      
      
      
    public void getData (Connection koneksi , String [] temp) throws SQLException{
        int urutan=1;
        try {
            
            stat=koneksi.createStatement();
            res=stat.executeQuery("SELECT `fonetik_BK_1` FROM `fonetik_buku`");
            while (res.next()) {
                temp[urutan]=res.getString("FONETIK_BK_1");
                urutan++;
            }
        }
        catch(Exception e) {
             }
      
    }
    
    
    
    public String ambildata(int id){
        String hasil=null;
        
       
        try {
            res=stat.executeQuery("SELECT `JUDUL_BUKU` FROM `BUKU` WHERE ID_BUKU = " +id);
            stat=koneksi.createStatement();
            
            while(res.next()){
                hasil = res.getString("JUDUL_BUKU");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DocumentParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hasil;
    }
    
    
    public void getData2 (Connection koneksi , String [] temp) throws SQLException{
        int urutan=1;
        try {
            
            stat=koneksi.createStatement();
            res=stat.executeQuery("SELECT `fonetik_BK_2` FROM `fonetik_buku`");
            while (res.next()) {
                temp[urutan]=res.getString("FONETIK_BK_2");
                urutan++;
            }
        }
        catch(Exception e) {
             }
      
    }
    
    public int getJumlahDokumen (Connection koneksi ) throws SQLException{
        int hasil=0;
        try {
            
            stat=koneksi.createStatement();
            res=stat.executeQuery("SELECT `FONETIK_BK_1` FROM `fonetik_buku`");
            while (res.next()) {
                hasil++;
            }
        }
        catch(Exception e) {
             }
      return hasil;
    }
    public int getJumlahDokumen2 (Connection koneksi ) throws SQLException{
        int hasil=0;
        try {
            
            stat=koneksi.createStatement();
            res=stat.executeQuery("SELECT `FONETIK_BK_2` FROM `fonetik_buku`");
            while (res.next()) {
                hasil++;
            }
        }
        catch(Exception e) {
             }
      return hasil;
    }

    /**
     * Method to read files and store in array.
     * @param filePath : source file path
     * @throws FileNotFoundException
     * @throws IOException
     */
    
    

    public void parseFiles(String query, boolean isFon1) throws FileNotFoundException, IOException, SQLException {
        if (isFon1) {
            set(query);
        } else {
            set2(query);
        }
        
        
        for (int i=0; i< jumlahDokumen; i++) {
           StringBuilder sb = new StringBuilder();
                String s = null;
                sb.append(dokumen[i]);
                
                String[] tokenizedTerms = sb.toString().replaceAll("[\\W&&[^\\s]]", "").split("\\W+");
                for (String term : tokenizedTerms) {
                    if (!allTerms.contains(term)) {
                        allTerms.add(term);
                        
                    }
                }
                termsDocsArray.add(tokenizedTerms);
           
        }

    }
   

//      
    
    /**
     * Method to create termVector according to its tfidf score.
     */
    public void tfIdfCalculator() {
        double tf; //term frequency
        double idf; //inverse document frequency
        double tfidf; //term requency inverse document frequency        
        for (String[] docTermsArray : termsDocsArray) {
            double[] tfidfvectors = new double[allTerms.size()];
            int count = 0;
            for (String terms : allTerms) {
                tf = new Tfidf().tfCalculator(docTermsArray, terms);
                idf = new Tfidf().idfCalculator(termsDocsArray, terms);
                tfidf = tf * idf;
                tfidfvectors[count] = tfidf;
               count++;
//                System.out.println("term = "+terms);
//                System.out.println("tf = "+tf);
//                System.out.println("idf = "+idf);
//                System.out.println("tfidf = "+tfidf);
            }
            tfidfDocsVector.add(tfidfvectors);            
        }
    }

    /**
     * Method to calculate cosine similarity between all the documents.
     */
    public void getCosineSimilarity() {
       int i=0;
       
       DecimalFormat df = new DecimalFormat(",##");
         for (int j = 1; j < tfidfDocsVector.size(); j++) {
                rangking[j]=Double.valueOf((new CosineSimilarity().cosineSimilarity(tfidfDocsVector.get(i), tfidfDocsVector.get(j) )));
                idDoc[j]=j;
            }
  
   
        for (int j = 1; j < tfidfDocsVector.size(); j++) {
            //System.out.println(j+" dokumen "+idDoc[j]+"  "+rangking[j] );
        }
    }
    
   
    
    
    
    public DefaultTableModel tabelRank(DefaultTableModel model){
        double temp1=0;
        int temp2=0;
        for (int j = 1; j < tfidfDocsVector.size(); j++) {
            for (int i = 2; i < tfidfDocsVector.size(); i++) {
                if (rangking[i-1]<rangking[i]){
                    temp1=rangking[i-1];
                    rangking[i-1]=rangking[i];
                    rangking[i]=temp1;
                    
                    temp2=idDoc[i-1];
                    idDoc[i-1]=idDoc[i];
                    idDoc[i]=temp2;
                    
                    
                }
            }
        }
        model = new DefaultTableModel();
        model.addColumn("Rangking");
        model.addColumn("Dokumen ke");
        model.addColumn("Persentase");
        model.addColumn("Nama Buku");
        //menghapus seluruh data di table
        model.getDataVector().removeAllElements();
        //memberi tahu bahwa data telah kosong
        model.fireTableDataChanged();
//          text.append("Rangking\tDokumen\tPersentase \t\tNAMA BUKU" );
       
       
        
        for (int j = 1; j < 3; j++) {
            if (rangking[j]>=0.7){
                
//            text.append("\n "+j+"\t"+idDoc[j]+" \t "+rangking[j] +"    "+ ambildata(idDoc[j]));
            Object o [] = new Object[4];
            o[0] = j;
            o[1] = idDoc[j];
            o[2] = rangking[j];
            o[3] = ambildata(idDoc[j]);
            model.addRow(o);
            
            
           
//      
            }
        }
          return model;
    }
    
      public DefaultTableModel tabelRank2(DefaultTableModel model2){
        double temp1=0;
        int temp2=0;
        for (int j = 1; j < tfidfDocsVector.size(); j++) {
            for (int i = 2; i < tfidfDocsVector.size(); i++) {
                if (rangking[i-1]<rangking[i]){
                    temp1=rangking[i-1];
                    rangking[i-1]=rangking[i];
                    rangking[i]=temp1;
                    
                    temp2=idDoc[i-1];
                    idDoc[i-1]=idDoc[i];
                    idDoc[i]=temp2;
                    
                    
                }
            }
        }  
        model2 = new DefaultTableModel();
        model2.addColumn("Rangking");
        model2.addColumn("Dokumen ke");
        model2.addColumn("Persentase");
        model2.addColumn("Nama Buku");
        //menghapus seluruh data di table
        model2.getDataVector().removeAllElements();
        //memberi tahu bahwa data telah kosong
        model2.fireTableDataChanged();
//          text.append("Rangking\tDokumen\tPersentase \t\tNAMA BUKU" );
       
       
        
        for (int j = 1; j < 3; j++) {
            if (rangking[j]>=0.8){
                
//            text.append("\n "+j+"\t"+idDoc[j]+" \t "+rangking[j] +"    "+ ambildata(idDoc[j]));
            Object o [] = new Object[4];
            o[0] = j;
            o[1] = idDoc[j];
            o[2] = rangking[j];
            o[3] = ambildata(idDoc[j]);
            model2.addRow(o);
            
            
           
//      
            }
        }
          return model2;
    }
      
      
      public DefaultTableModel tabelRank3(DefaultTableModel model3){
        double temp1=0;
        int temp2=0;
        for (int j = 1; j < tfidfDocsVector.size(); j++) {
            for (int i = 2; i < tfidfDocsVector.size(); i++) {
                if (rangking[i-1]<rangking[i]){
                    temp1=rangking[i-1];
                    rangking[i-1]=rangking[i];
                    rangking[i]=temp1;
                    
                    temp2=idDoc[i-1];
                    idDoc[i-1]=idDoc[i];
                    idDoc[i]=temp2;
                    
                    
                }
            }
        }  
        model3 = new DefaultTableModel();
        model3.addColumn("Rangking");
        model3.addColumn("Dokumen ke");
        model3.addColumn("Persentase");
        model3.addColumn("Nama Buku");
        //menghapus seluruh data di table
        model3.getDataVector().removeAllElements();
        //memberi tahu bahwa data telah kosong
        model3.fireTableDataChanged();
//          text.append("Rangking\tDokumen\tPersentase \t\tNAMA BUKU" );
       
       
        
        for (int j = 1; j < 3; j++) {
            if (rangking[j]!=0){
                
//            text.append("\n "+j+"\t"+idDoc[j]+" \t "+rangking[j] +"    "+ ambildata(idDoc[j]));
            Object o [] = new Object[4];
            o[0] = j;
            o[1] = idDoc[j];
            o[2] = rangking[j];
            o[3] = ambildata(idDoc[j]);
            model3.addRow(o);
            
            
    }           
//      
            //}
        }
          return model3;

      
}
    
    
    
    public void rangking(JTextArea text){
        double temp1=0;
        int temp2=0;
        for (int j = 1; j < tfidfDocsVector.size(); j++) {
            for (int i = 2; i < tfidfDocsVector.size(); i++) {
                if (rangking[i-1]<rangking[i]){
                    temp1=rangking[i-1];
                    rangking[i-1]=rangking[i];
                    rangking[i]=temp1;
                    
                    temp2=idDoc[i-1];
                    idDoc[i-1]=idDoc[i];
                    idDoc[i]=temp2;
                    
                    
                }
            }
        }
        text.append("Rangking\tDokumen\tPersentase " );
       
       
        
        for (int j = 1; j < 5; j++) {
            if (rangking[j]!=0){
                
            text.append("\n "+j+"\t"+idDoc[j]+" \t "+rangking[j] +"    "+ ambildata(idDoc[j]));
            }
        }
        
    }
}
 