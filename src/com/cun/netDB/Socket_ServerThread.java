package com.cun.netDB;
//程序出错了。。。
import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;
/*【例 13-6】对应例10.5客户端小应用程序的服务器端小应用程序。
 * 程序以端4441建立与客户端的套接字连接，服务器端收到客户端的申请后，
 * 以客户的套接字建立一个线程，并启动。
 * 如果没有客户申请，则继续监听客户的申请。
 * 线程按客户的套接字建立输入数据流in和输数据流out。
 * 线程利用in读取客户放入线路里的信息。
 * 如果接受的信息是"结束"， 则服务器回复"结束"后关闭套接字连接；
 * 否则回复："我是服务器你对我说"，以及服务器接收到的信息。*/

@SuppressWarnings("serial")
public class Socket_ServerThread extends Applet implements Runnable,ActionListener{
    JButton button; JTextField textF; JTextArea textA;
    Socket socket; Thread thread;
    DataInputStream in; DataOutputStream out;
    public void init(){
        setBackground(new Color(120,153,137));
        setLayout(new BorderLayout());
        button = new JButton("发送信息");
        textF = new JTextField(20);
        textA = new JTextArea(20,30);
        setSize(450,350);
        JPanel p = new JPanel();
        p.add(textF); p.add(button);
        add(textA,"Center"); add(p,"South");
        button.addActionListener(this);
    }
    public void start(){
        try{
            socket = new Socket(this.getCodeBase().getHost(),4441);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        }catch(IOException e){}
        if(thread==null){
            thread = new Thread(this);
            thread.setPriority(Thread.MIN_PRIORITY);
            thread.start();
        }
    }
    public void run(){
        String s = null;
        while(true){
             try{
                s = in.readUTF();
            }catch(IOException e){}
            if(s.equals("结束")){
                try{
                    socket.close();break;
                }catch(IOException e){}
            }else textA.append(s + "\n");
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            String s = textF.getText();
            if(s!= null){
                try{
                    out.writeUTF(s);
                }catch(IOException e1){}
            }
            else{
                try{
                    out.writeUTF("请说话");
                }catch(IOException e1){}
            }
       }
    }
}