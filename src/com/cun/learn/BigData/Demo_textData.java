package com.cun.learn.BigData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Demo_textData {

	public void DelWords(String source, String destination) {
		FileInputStream fileInputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;

		FileOutputStream fileOutputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedWriter bufferedWriter = null;
		String dataString = null;

		try {
			fileInputStream = new FileInputStream(source);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputStreamReader = new InputStreamReader(fileInputStream);
		bufferedReader = new BufferedReader(inputStreamReader);
		try {
			fileOutputStream = new FileOutputStream(destination);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		bufferedWriter = new BufferedWriter(outputStreamWriter);
		try {
			while ((dataString = bufferedReader.readLine()) != null) {
				System.out.println(dataString);
//				String[] stringArray = dataString.split(".");
				StringBuffer stringBuffer = new StringBuffer(dataString);
				stringBuffer.insert(0, "Andy: ");
				System.err.println(stringBuffer);
				bufferedWriter.write(stringBuffer.toString());
				bufferedWriter.flush();
			}
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();

			bufferedWriter.close();
			outputStreamWriter.close();
			fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String source="D:\\a.txt";
		String destination="D:\\b.txt";
		Demo_textData demo_textData=new Demo_textData();
		demo_textData.DelWords(source, destination);
	}
}
