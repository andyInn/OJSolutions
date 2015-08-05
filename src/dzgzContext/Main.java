package dzgzContext;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.text.DecimalFormat;
//PKOJ_2388
public class Main {
	public static void main(String[] args)throws Exception {
		StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in))));
		st.nextToken();
		int N=(int)st.nval, temp=0;
		long[] arr=new long[250001];
		for(int i=0;i<N;i++) {
			st.nextToken();
			arr[i]=(long)st.nval;
		}
		Main.QuickSort(arr, 0, N-1);
		DecimalFormat df=new DecimalFormat("0.0");
		temp=N>>1;
		if(N%2==1){
			System.out.println(df.format(arr[temp]));
		}else{
			float flo=((float)arr[temp-1])/2+((float)arr[temp])/2;
			System.out.println(df.format(flo));
		}
	}
	public static void QuickSort(long[] arr,int low,int high) {
		if(low<high){
			int pos=Patition(arr, low, high);
			Main.QuickSort(arr, low, pos-1);
			Main.QuickSort(arr, pos+1, high);
		}
	}
	
	public static int Patition(long[] arr, int low,int high) {
		long pivot=arr[low];
		while(low<high){
			while(low<high&&arr[high]>=pivot)high--;
			arr[low]=arr[high];
			while(low<high&&arr[low]<=pivot)low++;
			arr[high]=arr[low];
		}
		arr[low]=pivot;
		return low;
	}
}