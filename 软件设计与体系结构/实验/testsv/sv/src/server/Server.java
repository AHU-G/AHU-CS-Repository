/*
 * Server.java
 *
 * Created on 2007��6��6��, ����6:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package server;

import java.net.*;
import java.io.*;
import java.sql.*;
import dbManager.DBConnectionManager;
/**
 *
 *
 */
public class Server extends Thread{
    
    private Socket socket;
    /** Creates a new instance of Server */
    public Server(Socket socket) {
        try {
            this.socket = socket;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void run(){
    	
    	System.out.println("�û�"+socket.getInetAddress().toString()+"����������"+"���ݿ����ӳɹ���");
        DataOutputStream out;
        try {
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("��¼�ɹ���");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//        
//        boolean ok = false;
//	Statement stmt;
//	ResultSet rs;
//        System.out.println("�û�"+socket.getInetAddress().toString()+"����������"+"���ݿ����ӳɹ���");
//        String name = "";
//        String password = "";
//        DataInputStream in;
//        DataOutputStream out;
//        out.writeUTF("��¼�ɹ���");
//        try {
//            in = new DataInputStream(socket.getInputStream());
//            out = new DataOutputStream(socket.getOutputStream());
//            name = in.readUTF();
//            password = in.readUTF();
//            try {
//                stmt = con.createStatement();
//                rs = stmt.executeQuery("select * from users where username=\'"+name+"\' and password=\'"+password+"\'");
//                if(rs.next()){
//                    ok = true;
//                }
//                else ok = false;
//                rs.close();
//                stmt.close();
//            } catch (SQLException e) {
//                    ok = false;
//            }
//            if(ok==true){
//                out.writeUTF("��¼�ɹ���");
//            }
//            else{
//                out.writeUTF("��¼ʧ�ܣ�");
//            }
//            out.close();
//            in.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }
    public static void main(String args[]){
        int port = 1033;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
        System.out.println("���������������ȴ��û����ӣ�");
        while(true){
            try {
                new Server(server.accept()).run();
            } catch (IOException ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
