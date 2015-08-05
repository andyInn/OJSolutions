package jiuDuOj_Answers;

import java.util.HashSet;
import java.util.Scanner;
//这个算法代码量少，但是效率不高，因为多了很多不必要的比较，最好的是Main_1555
public class Main_1555_0 {
    public static void main(String[] args) {
        Scanner x=new Scanner(System.in);
        String s;
        HashSet<String> a;
        while(x.hasNext()){
            s=x.next();
            int i,j;
            a=new HashSet<String>();
            for(i=0;i<s.length()-1;i++){
                for(j=i+1;j<s.length();j++){
                    String p=s.substring(i, j);
                    if(s.substring(j,s.length()).contains(p))a.add(p);
                    else break;
                }
            }
            System.out.println(a.size());
        }
    }
}
/**************************************************************
    Problem: 1555
    User: ak4724
    Language: Java
    Result: Accepted
    Time:1070 ms
    Memory:26576 kb
****************************************************************/