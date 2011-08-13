package com.iappsam.recovery.util;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class LoadingDialog extends JDialog{

    JLabel backDrop, messageLabel;
    JProgressBar progressBar;

    public LoadingDialog(javax.swing.JFrame parent, boolean modal, String message){
        super(parent,modal);

        initComponents();
        setMessage(message);

        setLocationRelativeTo(parent);
    }

    private void initComponents(){
        setSize(200,80);
        setUndecorated(true);
        setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        backDrop = new JLabel();
        backDrop.setBackground(java.awt.Color.WHITE);
        backDrop.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        backDrop.setOpaque(true);
        backDrop.setBounds(0,0,200,80);
        add(backDrop,-1);

        messageLabel = new JLabel();
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel.setBounds(0,0,200,50);
        messageLabel.setFont(new java.awt.Font("",java.awt.Font.BOLD,12));
        messageLabel.setForeground(java.awt.Color.BLACK);
        add(messageLabel,0);

        progressBar = new JProgressBar();
        progressBar.setBounds(25,50,150,10);
        progressBar.setIndeterminate(true);
        add(progressBar,0);
    }

    private void setMessage(String message){
        messageLabel.setText(message);
        java.awt.FontMetrics fm = messageLabel.getFontMetrics(messageLabel.getFont());

        int width = fm.charsWidth(message.toCharArray(), 0, message.length()) + 50;
        messageLabel.setBounds(0,0,width>200 ? width : 200,50);
        backDrop.setSize(width>200 ? width : 200,80);
        this.setSize(width>200 ? width : 200,80);

        progressBar.setBounds(messageLabel.getWidth()/2-75,50,150,10);
    }

    public void showLoading(){
        setVisible(true);
    }
    
}
