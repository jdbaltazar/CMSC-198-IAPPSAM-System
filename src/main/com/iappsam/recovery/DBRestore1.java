package com.iappsam.recovery;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.iappsam.recovery.util.LoadThread;

public class DBRestore1 extends javax.swing.JFrame {

	private javax.swing.JTextArea LogTextArea;
	private javax.swing.JPasswordField PasswordField;
	private javax.swing.JLabel PasswordLabel;
	private javax.swing.JButton StartRecoveryButton;
	private javax.swing.JLabel UsernameLabel;
	private javax.swing.JTextField UsernameTextField;
	private javax.swing.JScrollPane jScrollPane1;

	public static final String DATE_FORMAT_NOW = "MM-dd-yyyy [HH:mm:ss]";
	private Connection connection;
	private String hostname, username, password;
	private File file;
	public Thread RecoverDBThread;
	public Thread UpdateLogThread;
	public LoadThread loadingThread;

	public DBRestore1() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		StartRecoveryButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		LogTextArea = new javax.swing.JTextArea();
		UsernameTextField = new javax.swing.JTextField();
		PasswordField = new javax.swing.JPasswordField();
		UsernameLabel = new javax.swing.JLabel();
		PasswordLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("IAPPSAM System Database Recovery  Tool");

		setBackground(new java.awt.Color(255, 255, 255));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setForeground(new java.awt.Color(255, 255, 255));
		setLocationByPlatform(true);

		StartRecoveryButton.setText("Start Recovery");
		StartRecoveryButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						StartRecoveryButtonActionPerformed(evt);
					}
				});

		jScrollPane1.setAutoscrolls(true);
		jScrollPane1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11));

		LogTextArea.setColumns(20);
		LogTextArea.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
		LogTextArea.setLineWrap(true);
		LogTextArea.setRows(5);
		LogTextArea
				.setToolTipText("Current status of database recovery process.");
		LogTextArea.setWrapStyleWord(true);
		LogTextArea.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		LogTextArea.setDisabledTextColor(new java.awt.Color(255, 255, 255));
		LogTextArea.setFocusable(false);
		jScrollPane1.setViewportView(LogTextArea);

		UsernameLabel.setText("Username");

		PasswordLabel.setText("Password");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														380, Short.MAX_VALUE)
												.addComponent(
														StartRecoveryButton,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														380, Short.MAX_VALUE)
												.addGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						PasswordLabel,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						UsernameLabel,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						UsernameTextField,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						328,
																						Short.MAX_VALUE)
																				.addComponent(
																						PasswordField,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						328,
																						Short.MAX_VALUE))))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														UsernameTextField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(UsernameLabel))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														PasswordField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(PasswordLabel))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(StartRecoveryButton)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										197, Short.MAX_VALUE).addContainerGap()));

		pack();
	}// </editor-fold>

	private void StartRecoveryButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		Thread conThread = new Thread(con);
		conThread.start();
	}

	private void startConnection() {
		hostname = "localhost";
		username = UsernameTextField.getText().trim();
		password = PasswordField.getText();

		if (connect()) {
			AddLog("Logged in as: " + username + "");
			PopMsg("Login Verified, Connection Successful.");
			PopWarn("WARNING: The current database will be replaced by the database contained in the backup file.\n"
					+ "Any changes on the current database done after the backup file was made will be LOST.\nPlease CANCEL the file selection if you want"
					+ " to KEEP those changes.");
			javax.swing.JFileChooser jfc = new javax.swing.JFileChooser();
			if (jfc.showDialog(this, "Select Database File(.sql)") == javax.swing.JFileChooser.APPROVE_OPTION
					&& jfc.getSelectedFile() != null) {
				AddLog("Opening file: "
						+ (file = jfc.getSelectedFile()).getAbsoluteFile());
				loadingThread = new com.iappsam.recovery.util.LoadThread(
						(javax.swing.JFrame) this, true, "Restoring Database.");
				loadingThread.start();
				Thread recstart = new Thread(rec);
				recstart.start();
			} else
				AddLog(username + " has cancelled database file selection.");
		} else {
			AddLog("Login attempt failed with following login details:\n      username: "
					+ username + "\n      password: " + password + "");
			PopMsg("Login Failed, Check Username and Password.");
		}
	}

	Runnable rec = new Runnable() {
		public void run() {
			restoreDB();
		}
	};

	Runnable con = new Runnable() {
		public void run() {
			startConnection();
		}
	};

	@SuppressWarnings("static-access")
	private void PopWarn(String popwarning) {
		new javax.swing.JOptionPane().showMessageDialog(this, popwarning, null,
				javax.swing.JOptionPane.WARNING_MESSAGE);
	}

	@SuppressWarnings("static-access")
	private void PopMsg(String popmessage) {
		new javax.swing.JOptionPane().showMessageDialog(this, popmessage, null,
				javax.swing.JOptionPane.INFORMATION_MESSAGE);
	}

	private void AddLog(final String logmessage) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LogTextArea.append(timedate() + "\n   " + logmessage + "\n");
			}
		});
	}

	private void AddLog1(final String logmessage) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LogTextArea.append(logmessage + "\n");
			}
		});

	}

	private boolean connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("" + e);
			AddLog("" + e);
			return false;
		} catch (InstantiationException e) {
			System.out.println("" + e);
			AddLog("" + e);
			return false;
		} catch (IllegalAccessException e) {
			System.out.println("" + e);
			AddLog("" + e);
			return false;
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + hostname
					+ "/", username, password);
			return true;
		} catch (SQLException e) {
			if (e.toString().startsWith(
					"java.sql.SQLException: Access denied for user")) {
				System.out.println("" + e);
				AddLog("" + e);
				return false;
			} else {
				System.out.println("" + e);
				AddLog("" + e);
				return false;
			}
		}
	}

	public boolean checkInventoryDatabase() {
		try {
			connection.createStatement().executeUpdate("use iappsam;");
		} catch (SQLException ex) {
			return false;
		}
		return true;
	}

	public void createInventoryDatabase() {
		invoke("drop database if exists iappsam;");
		invoke("create database if not exists iappsam;");
	}

	protected void invoke(String statement) {
		try {
			connection.createStatement().executeUpdate(statement);
		} catch (SQLIntegrityConstraintViolationException ex) {
			System.err.println(ex);
		} catch (SQLException exception) {
			System.err.println(exception);
		}
	}

	private void restoreDB() {
		createInventoryDatabase();
		if (checkInventoryDatabase()) {
			String command = "";
			try {
				java.util.Scanner scanner = new java.util.Scanner(file);
				while (scanner.hasNextLine()) {
					String currentLine = scanner.nextLine();
					if (currentLine.endsWith(";")) {
						command += '\n' + currentLine;
						invoke(command);
						command = "";
					} else {
						command += '\n' + currentLine;
					}
					AddLog1(command);
					repaint();
				}
			} catch (Exception ex) {
				AddLog("Database Restoration Failed!");
				PopMsg("Database Restoration Failed. Database File Possibly Invalid.");
			}
		}
		loadingThread.closeLoading();
		invoke("insert into log(description) values('Database was restored using the file "
				+ file.getName() + " by " + username + "');");
		AddLog("Database Restoration Successful.");
		PopMsg("Database Restoration Complete.");
	}

	public static String timedate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}

	public static void main(String[] args) {

		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		DBRestore1 dbr = new DBRestore1();
		dbr.setVisible(true);
	}

}