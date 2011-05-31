package com.iappsam.database;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class BackupDatabaseTool{

    private File backupfile;
    private static String MySQLDumpPath = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; 
    //"C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\mysqldump.exe";
    private static final String DATE_FORMAT_NOW = "[HH'h'-mm'm'-ss's'] MM-dd-yyyy";
    private String password = "123456";
    private String username = "root";
    String dbname = "IAPPSAM";
    public String fileName= "IAPPSAMS DB Backup ";
    public String filePath = "C:\\IAPPSAMS DB backup\\";
    String backupURL = filePath;

    @SuppressWarnings("static-access")
    public BackupDatabaseTool(){
        initBackUp();
        writeDBBackUpFile();
        new javax.swing.JOptionPane().showMessageDialog(null, "Back-Up Database Successful.", null, javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    private void initBackUp(){
        fileName = fileName.concat(getCurrentDate());
        backupURL = backupURL.concat(fileName);
        File tempfile= new File(backupURL);
        this.backupfile= tempfile;
    }

    public String getFilePath(){
        return filePath;
    }

    public String getFileName(){
        return fileName;
    }

    private static String getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }

    private void writeDBBackUpFile(){
        FileWriter fw = null;
        try {
            fw = new FileWriter(backupfile+".sql");
            Process child = Runtime.getRuntime().exec(MySQLDumpPath+" -u "+username+""+(password.equals("") ? " " : " -p"+password+" ")+ dbname);
            InputStream in = child.getInputStream();
            InputStreamReader reader = new InputStreamReader(in, "latin1");
            int ibyte = 0;
            while ((ibyte = reader.read()) != -1) {
                fw.write((char)ibyte);
            }
            fw.close();
        } catch( Exception ex ) {}

        try{
            Thread.sleep(20);
        }catch(InterruptedException ex){}
    }
}
