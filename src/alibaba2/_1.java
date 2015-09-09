package alibaba2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1 {
	
	public static List<String> grayCode(int N){
		List<String> li=new ArrayList<String>();
		if(N==0){
			li.clear();
			return li;
		}
		return li;
	}
	
	public static float findMoreThanHalf(float[] A) {
		if (A == null || A.length == 0)
			return -1.0f;
		if (A.length == 1)
			return A[0];
		Map<Float, Integer> m = new HashMap<Float, Integer>();
		int tmp = 0, len = A.length;
		for (int i = 0; i < len; i++) {
			if (!m.containsKey(A[i])) {
				m.put(A[i], 1);
			} else {
				tmp = m.get(A[i]) + 1;
				if (tmp > (len >> 1))
					return A[i];
				m.put(A[i], tmp);
			}
		}
		return 0.0f;
	}

	public static void main(String ...strings){
		float[] A={2.0f,1.0f,0.5f,0.6f,0.5f,0.5f,0.5f};
		System.out.println(findMoreThanHalf(A));
	}
}
