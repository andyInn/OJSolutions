package com.cun.learn.merge;

import java.io.BufferedReader;   

/**  
 *   
 * 文件信息  
 * http://blog.csdn.net/gameover8080/article/details/7054248
 * 多路归并排序 外排序 大文件排序 java实现
 * @author Andy
 *  
 * @version $Id: FileInfo.java, v 0.1 2009-8-1 上午02:11:30 Exp $  
 */  
public class FileInfo {   
  
    /**  
     * 文件号  
     */  
    private int            fileNum;   
  
    /**  
     * 当前行号  
     */  
    private int            lineNum = 0;   
  
    /**  
     * 当前值  
     */  
    private String         value;   
  
    /**  
     * BufferedReader引用  
     */  
    private BufferedReader bufferedReader;   
  
    public boolean readNextValue() throws Exception {   
        String value;   
        if ((value = this.bufferedReader.readLine()) != null) {   
            this.value = value;   
            this.lineNum++;   
            return true;   
        } else {   
            this.bufferedReader.close();   
            return false;   
        }   
    }   
  
    public int getFileNum() {   
        return fileNum;   
    }   
  
    public void setFileNum(int fileNum) {   
        this.fileNum = fileNum;   
    }   
  
    public int getLineNum() {   
        return lineNum;   
    }   
  
    public void setLineNum(int lineNum) {   
        this.lineNum = lineNum;   
    }   
  
    public String getValue() {   
        return value;   
    }   
  
    public void setValue(String value) {   
        this.value = value;   
    }   
  
    public BufferedReader getReader() {   
        return bufferedReader;   
    }   
  
    public void setReader(BufferedReader reader) {   
        this.bufferedReader = reader;   
    }   
} 