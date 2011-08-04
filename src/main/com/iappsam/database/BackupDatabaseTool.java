package com.iappsam.database;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BackupDatabaseTool {

	private File backupfile;
	private static String MySQLDumpPath = "";//"C:/Program Files (x86)/MySQL/MySQL Server 5.5/bin/mysqldump.exe";
	private String password = "123456";
	private String username = "root";
	String dbname = "iappsam";
	public String fileName = "IAPPSAMS DB Backup";
	public String filePath = "C:/IAPPSAMS DB backup/";
	String backupURL = filePath;

	public BackupDatabaseTool() {
	}

	public File initBackUp() {
		File DBBackupDir = new File(filePath);
		if (!DBBackupDir.exists()) {
			DBBackupDir.mkdir();
		}
		backupURL = backupURL.concat(fileName);
		File tempfile = new File(backupURL);
		this.backupfile = tempfile;
		writeDBBackUpFile();
		return backupfile;
	}

	public String getFileName() {
		return fileName;
	}

	private void writeDBBackUpFile() {
		FileWriter fw = null;
		try {
			FileInputStream fis = new FileInputStream("MySQLDumpPath.txt");
			DataInputStream dis = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(dis));
			while ((MySQLDumpPath = br.readLine()) != null) {
				// Print the content on the console
				//	System.out.println(strLine);
				break;
			}

			System.out.println("MySQLDumpPath is::::::::::"+MySQLDumpPath);
			fw = new FileWriter(backupfile + ".sql");
			Process child = Runtime.getRuntime().exec(
					MySQLDumpPath + " -u " + username + "" + (password.equals("") ? " " : " -p" + password + " ") + dbname);
			InputStream in = child.getInputStream();
			InputStreamReader reader = new InputStreamReader(in, "latin1");
			int ibyte = 0;
			while ((ibyte = reader.read()) != -1) {
				fw.write((char) ibyte);
			}
			fw.close();
		} catch (Exception ex) {
		}

		try {
			Thread.sleep(20);
		} catch (InterruptedException ex) {
		}
	}
}
