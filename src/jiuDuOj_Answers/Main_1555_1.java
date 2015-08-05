package jiuDuOj_Answers;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
//1555：重复子串
public class Main_1555_1 {
	public static void main(String[] args) throws Exception {
		BufferedInputStream bis=new BufferedInputStream(System.in);
		InputStreamReader isr=new InputStreamReader(bis);
		BufferedReader br=new BufferedReader(isr);
		StreamTokenizer st=new StreamTokenizer(br);
		while(st.nextToken()!=StreamTokenizer.TT_EOF){
			String inputString=st.sval; int sumString=0;
			int length=inputString.length();
			Map<String, List<Integer>> map =new HashMap<String, List<Integer>>();
			char[] arr=inputString.toCharArray();
			for(int i=0;i<length;i++){
				for(int j=i;j<length;j++){
					String str=new String(arr,i,j-i+1);
					if(!map.containsKey(str)){
						List<Integer> li= new ArrayList<Integer>();
						li.add(i); map.put(str, li);
					}else{
						List<Integer> li=new ArrayList<Integer>();
						li=map.get(str); li.add(i);
					}
				}
			}
			
			Set<Map.Entry<String, List<Integer>>> set=map.entrySet();
			Iterator<Map.Entry<String, List<Integer>>> it=set.iterator();
			while(it.hasNext()){
				Map.Entry<String, List<Integer>> entry= it.next();
				String strEntry=entry.getKey();
				List<Integer> list=entry.getValue();
				int lengthStr=strEntry.length();
				boolean flag=false;
				
				for(int i=0;i<list.size()-1;i++){
					for(int j=i+1;j<list.size();j++){
						if(list.get(j)>list.get(i)+lengthStr-1){
							sumString++; flag=true; break;
						}
					}
					if(flag) break;
				}
			}
			System.out.println(sumString);
		}
	}
}