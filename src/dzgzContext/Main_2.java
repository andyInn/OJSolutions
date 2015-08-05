package dzgzContext;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;
//POJ 2623 Sequence Median
public class Main_2 {
	public static void main(String[] args) throws IOException {
		StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in))));
		st.nextToken();
		int N=(int) st.nval;
		PriorityQueue<Long> pq=new PriorityQueue<Long>();
		for(int i=0;i<N/2+1;i++){
			st.nextToken();
			pq.add((long) st.nval);
		}
	}
}