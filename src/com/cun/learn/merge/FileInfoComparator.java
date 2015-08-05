package com.cun.learn.merge;

import java.util.Comparator;   

/**  
 *   
 * 文件比较器  
 * http://blog.csdn.net/gameover8080/article/details/7054248
 * 多路归并排序 外排序 大文件排序 java实现
 * @author Andy
 *  
 * @version $Id: FileInfoComparator.java, v 0.1 2009-8-7 下午01:42:05 Exp $  
 */  
public class FileInfoComparator implements Comparator<FileInfo> {   
  
    public int compare(FileInfo o1, FileInfo o2) {   
        if (Integer.parseInt(o1.getValue()) != Integer.parseInt(o2.getValue())) {   
            return Integer.parseInt(o1.getValue()) - Integer.parseInt(o2.getValue());   
        }   
        //如果存在重复值则使用文件号比较   
        else {   
            return o1.getFileNum() - o2.getFileNum();   
        }   
    }   
  
}  