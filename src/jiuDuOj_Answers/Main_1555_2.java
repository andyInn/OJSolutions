package jiuDuOj_Answers;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//1555：重复子串,虽然已经优化了不少，但是还是效率太低，参考优雅的代码Main_1555
public class Main_1555_2 {
	public static void main(String[] args) throws Exception {
		BufferedInputStream bis=new BufferedInputStream(System.in);
		InputStreamReader isr=new InputStreamReader(bis);
		BufferedReader br=new BufferedReader(isr);
		StreamTokenizer st=new StreamTokenizer(br);
		while(st.nextToken()!=StreamTokenizer.TT_EOF){
			String inputString=st.sval; int sumString=0;
			int length=inputString.length();
			Map<String, List<Integer>> map =new HashMap<String, List<Integer>>();
			List<String> strUsed=new ArrayList<String>();
			char[] arr=inputString.toCharArray();
			for(int i=0;i<length;i++){
				for(int j=i;j<length;j++){
					String str=new String(arr,i,j-i+1);
					if (!strUsed.contains(str))
						if (!map.containsKey(str)) {
							List<Integer> li = new ArrayList<Integer>();
							li.add(i); map.put(str, li);
						} else {
							List<Integer> li = new ArrayList<Integer>();
							li = map.get(str); li.add(i);
							// 对结果的判断放在这里，减少循环的次数
							if (li.get(li.size() - 1) > li.get(0) + str.length() - 1)
								for (int ii = 0; ii < li.size() - 1; ii++)
									for (int jj = ii + 1; jj < li.size(); jj++)
										if (li.get(jj) > li.get(ii) + str.length() - 1) {
											sumString++; map.remove(str); strUsed.add(str);
										}
						}
				}
			}
			
			System.out.println(sumString);
		}
	}
}