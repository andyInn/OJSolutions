package com.cun.netDB;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

/*【例 13-9】Java应用程序访问数据库。应用程序打开考生信息表ksInfo，从中取出考生的各项信息。
 * 设考生信息数据库的结构如下：
类型		字符串	字符串	整数		字符串	字符串
字段名	考号		姓名		成绩		地址		简历

public class Demo_ReadDB extends JFrame implements ActionListener{
    public static Connection connectByJdbcodbc(String url, String username,String password){
        Connection con = null;
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //加载ODBC驱动程序
        }
        catch (Exception e){
            e.printStackTrace();
            return null; //加载失败，连接不成功
        }
        try{
            con = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e){
            e.printStackTrace();
            return null; //连接失败
        }
        return con; //连接成功
    }
    String title[] ={"考号", "姓名", "成绩", "地址", "简历"};
    JTextField txtNo = new JTextField(8);
    JTextField txtName = new JTextField(10);
    JTextField txtScore = new JTextField(3);
    JTextField txtAddr = new JTextField(30);
    JTextArea txtresume = new JTextArea();
    JButton prev = new JButton("前一个");
    JButton next = new JButton("后一个");
    JButton first = new JButton("第一个");
    JButton last = new JButton("最后一个");
    Statement sql; //SQL语句对象
    ResultSet rs; //存放查询结果对象
    Demo_ReadDB(Connection connect){
        super("考生信息查看窗口");
        setSize(450, 350);
        try{
            sql = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("SELECT * FROM ksInfo");
            Container con = getContentPane();
            con.setLayout(new BorderLayout(0, 6));
            JPanel p[] = new JPanel[4];
            for (int i = 0; i < 4; i++){
                p[i] = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
                p[i].add(new JLabel(title[i]));
            }
            p[0].add(txtNo);
            p[1].add(txtName);
            p[2].add(txtScore);
            p[3].add(txtAddr);
            JPanel p1 = new JPane(new GridLayout94, 1, 0, 8);
            JScrollPane jsp = new JScrollPane(txtResume,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                jsp.setPreforredSize(new Dimension(300, 60);
            for (int i = 0; i < 4; i++){
                p1.add(p[i]);
            }
            JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0);
            p2.add(new JLabel(title[4]));
            p2.add(jsp);
            Jpanel p3 = new Jpanel();
            p3.add(prev);
            p3.add(next);
            p3.add(first);
            p3.add(last);
            prev.addActionListener(this);
            next.addActionListener(this);
            first.addActionListener(this);
            last.addActionlistener(this);
            rs.first();
            readRecord();
        }
        catch (Exception e){
            e.printStackTrace():
        }
        setVisible(ture);
    }
    public void modifyRecord(Connection connect){
        String stuNo = (String)JOptionPane.showInputDialog(null,
            "请输入考生考号", "输入考号对话框", JOptionPane.PLAIN_MESSAGE, null,
            null, "");
        try {
            sql = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("SELECT * FROM ksInfo");
            Container con = getContentPane();
            con.setLayout(new Boarderlayout(0, 6));
            Jpanel p[] = new JPanel[4];
            for (int i = 0; i < ; i++){
                p[i] = new JPane(new FlowLayout(flowLayout.LEFT, 8, 0));
                p[i].add(new JLabel(title[i]));
            }
            p[0].add(txtNo);
            p[1].add(txtName);
            p[2].add(txtScore);
            p[3].add(txtAddr);
            Jpanel p1 = new Jpane(new GridLayout(4, 1, 0, 8));
            JScrollPane jsp = new JScrollPane(txtResume,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            jsp.setPreferredSize (new dimension(300, 60));
            for (int i = 0; i < 4; i++){
                p1.add(p[i]);
            }
            Jpanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
            p2.add(new JLableI(title[4]));
            p2.add(jsp);
            JPanel p3 = new JPanel();
            p3.add(prev);
            p3.add(next);
            p3.add(first);
            p3.add(last);
            prev.addActionListener(this);
            next.addActionListener(this);
            first.addActionListenerIthis);
            last.addActionListener(this);
            rs.first();
            readRecord();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    boolean readRecord(){
        try{
            txtNo.setText(rs.getString("考号")); txtName.setText(rs.getString("姓名")); txtScore.setText(rs.getString("成绩"));
            txtAddr.setText(rs.getString("地址")); txtResume.setText(rs.getString("简历"));
        }
        catch (SQLException e){
            e.printStackTrace(); return false;
        }
        return true;
    }
    public void actionPerformed(ActionEvent e){
        try{
            if (e.getSource() == prev)rs.previous();
            else if (e.getSource() == next)rs.next();
            else if (e.getSource() == first)rs.first();
            else if (e.getSource() == last)rs.last(); readRecord();
        }
        catch (Exception e2){}
    }
    public static void main(String args[]){
        Connection connect = null;
        JFrame .setDefaultLookAndFeeDecorated(true);
        Font font = new Font("JFrame", Font.PLAIN, 14);
        if ((connect =connectByJdbcOdbc("jdbc:odbc:redsun", "xia", "1234")) == null){
            JOptionPane.showMessageDialog(null, "数据库连接失败!");
            System.exit ( - 1);
        }
        new Demo_ReadDB(connect); //创建对象
    }
}*/