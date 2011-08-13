package com.iappsam.recovery.util;

public class LoadThread extends Thread{

    private LoadingDialog loading;
    javax.swing.JFrame parent;
    boolean modal;
    String message;

    public LoadThread(javax.swing.JFrame parent, boolean modal, String message){
        this.parent = parent;
        this.modal = modal;
        this.message = message;
      
    }

    @Override
    public void run(){
        showLoading();
    }

    private void showLoading(){
        loading = new com.iappsam.recovery.util.LoadingDialog(parent,modal,message);
        loading.showLoading();
    }

    public void closeLoading(){
        loading.dispose();
        loading = null;
        System.gc();
    }
}