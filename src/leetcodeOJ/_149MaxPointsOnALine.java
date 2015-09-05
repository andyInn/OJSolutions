package leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

public class _149MaxPointsOnALine {
	public static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public static int maxPoints(Point[] points) {
		if(points==null)
			return 0;
		int maxNum = 0;
		int len = points.length;
		int i, j;
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		if (len <= 2) // 如果点的个数小于3个，则最大数目为点的个数
			return len;
		for (i = 0; i < len; i++) {
			int cnt = 0;
			map.clear();
			for (j = 0; j < len; j++) {
				if (i == j)
					continue;
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					cnt++;
					continue;
				}
				// 注意当直线与y轴平行的情况
				double slope = points[i].x == points[j].x ? Integer.MAX_VALUE
						: (double) (points[j].y - points[i].y) / (points[j].x - points[i].x);
				if(!map.containsKey(slope))
					map.put(slope, 1);
				else
					map.put(slope, map.get(slope) + 1);
			}

			if (map.size() == 0) // 防止mp为空时，下面的for循环不执行
				map.put(0.0, 0);
			for (Map.Entry<Double, Integer> entry : map.entrySet()) {
				if (entry.getValue() + cnt > maxNum)
					maxNum = entry.getValue() + cnt;
			}
		}
		return maxNum + 1;
	}
	
	public static void main(String ...strings){
		Point[] points={};
//		Point[] points={
//				new Point(1, 1), new Point(1, 2), new Point(1, 3),
//				new Point(2, 4), new Point(5, 5), new Point(6, 6)
//				};
		System.out.println(maxPoints(points));
	}
}