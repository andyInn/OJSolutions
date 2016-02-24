/*package com.cun.java.learning;
//本文件测试了直接弹出Java对话框选择文件等内容
import javax.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;//添加鼠标事件必备引用
import java.awt.event.ActionListener;//添加鼠标事件必备引用
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
//	// extends JPanel implements ActionListener
//	static JFrame frame = new JFrame("");
//	static JPanel p = new JPanel();
//	JButton jb = new JButton("上传");
//	JFileChooser chooser;
//	String choosertitle;

	public static void main(String s[]) {
//		new Test().Show();
//		System.err.println(Arrays.toString(getPath()));
		String command="cmd.exe /c D: "
				+"& cd D:/about_work/Workspaces/MyEclipse_10/tibetanWordSplit/crfpp0.58/ "
				+"& crf_test.exe -m model D:/result/to_split_source/article1.txt ";
//				+"> D:/result/after_split_source/article1.txt";
		String line="";
		FileIO fIo=new FileIO();
		List<StringBuilder> list=new ArrayList<StringBuilder>();
		try {
			Process proc = Runtime.getRuntime().exec(command);
			InputStream is1 = proc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is1));
			try {
				while ((line=br.readLine()) != null){
					System.out.println(line);
					list.add(new StringBuilder(line+"\n"));
				}
				fIo.writeBackToFile(new File("D:/result/after_split_source/article1.txt"), list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			proc.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	public void Show() {
//		jb.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				chooser = new JFileChooser();
//				chooser.setCurrentDirectory(new java.io.File("."));
//				chooser.setDialogTitle(choosertitle);
//				System.out.println("---" + choosertitle);
//				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//				chooser.setAcceptAllFileFilterUsed(false);
//				if (chooser.showOpenDialog(p) == JFileChooser.APPROVE_OPTION) {
//					System.out.println("getCurrentDirectory(): "
//							+ chooser.getCurrentDirectory());
//					System.out.println("getSelectedFile() : "
//							+ chooser.getSelectedFile());
//				} else {
//					System.out.println("No Selection ");
//				}
//			}
//		});
//		// frame.addWindowListener(new WindowAdapter() {
//		// public void windowClosing(WindowEvent e) {
//		// System.exit(0);
//		// }
//		// });
//		p.add(jb);
//		frame.add(p, "Center");
//		frame.setSize(320, 240);
//		frame.setVisible(true);
//	}
	
	public static File[] getPath(){
		JPanel p = new JPanel();
		JFileChooser chooser = new JFileChooser();
		
		String choosertitle="Please choose a folder";
		File[] res={};
		
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle(choosertitle);
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setAcceptAllFileFilterUsed(true);
		chooser.setMultiSelectionEnabled(true);
		
		if (chooser.showOpenDialog(p) == JFileChooser.APPROVE_OPTION) {
			System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
			res=chooser.getSelectedFiles();
		} else {
			JOptionPane.showMessageDialog(null,"请选择一个文件或目录!","ALERT",JOptionPane.ERROR_MESSAGE);
		}
		return res;
	}
}*/