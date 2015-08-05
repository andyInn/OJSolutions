package HDOJ;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Scanner;

public class _2026 {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		String s = null;
		int n;
		char ch;
		while(sc.hasNext()){
			s=sc.nextLine();
			StreamTokenizer st=new StreamTokenizer(new StringReader(s));
			st.ordinaryChar('\"');
			st.ordinaryChar('\'');
			st.ordinaryChar(':');
			st.ordinaryChar(' ');
			while((n=st.nextToken())!=StreamTokenizer.TT_EOF){
				if(st.ttype==StreamTokenizer.TT_WORD){
					s=st.sval;
					ch=s.charAt(0);
					System.out.print(ch<97?ch:(char)(ch-32));
					System.out.print(s.substring(1));
				}else{
					System.out.print((char)n);
				}
			}//while
			System.out.println();
		}
	}
}
