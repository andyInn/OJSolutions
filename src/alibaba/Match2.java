/**
 * @author Andy
 * @date 2015/7/15
 */
package alibaba;

import java.util.HashMap;
import java.util.Map;

public class Match2 {
	
	public static int count = 0;
	
	public Match2(){
	}
	
	public void BuildMaxHeap(Animal<Integer, Integer>[] arr, int len,
			Map<String, Boolean> resultMap) {
		for (int i = (len >> 1); i > 0; i--)				//下标1~len保存了堆的数据，arr[0]为哨兵
			AdjustDown(arr, i, len, resultMap);				//从i=(len>>1)开始,反复调整堆
	}
	
	public void AdjustDown(Animal<Integer, Integer>[] arr, 
			int k, int len, Map<String, Boolean> resultMap) {
		arr[0] = arr[k];									//arr[0]暂存调整的这个元素
		for (int i = (k << 1); i <= len; i = (i << 1)) {
			if(i<len){										//取得孩子中较大者的下标
				String s1 = String.valueOf(arr[i].getName())
						+ String.valueOf(arr[i + 1].getName());
				String s2 = String.valueOf(arr[i + 1].getName())
						+ String.valueOf(arr[i].getName());
				if (resultMap.containsKey(s1)) {			//查询比赛结果
					if (resultMap.get(s1) == false) {
						i++;								//查询到了
					}
				}else{										//保存比赛结果
					if(arr[i].getSpeed()<arr[i+1].getSpeed()){
						resultMap.put(s1, false);
						resultMap.put(s2, false);
						i++;								//“查询”到了
					}else{
						resultMap.put(s1, true);
						resultMap.put(s2, true);
					}
					count++;
				}
			}
			String s3 = String.valueOf(arr[0].getName())
					+ String.valueOf(arr[i].getName());
			String s4 = String.valueOf(arr[i].getName())
					+ String.valueOf(arr[0].getName());
			if (resultMap.containsKey(s3)) {
				if (resultMap.get(s3) == true) {			//arr[0].getSpeed()>=arr[i].getSpeed()
					break;
				}
			}else{
				count++;
				if(arr[0].getSpeed()<arr[i].getSpeed()){
					resultMap.put(s3, false);
					resultMap.put(s4, false);
				}else{										//arr[0].getSpeed()>=arr[i].getSpeed()
					resultMap.put(s3, true);
					resultMap.put(s4, true);
					break;
				}
			}
			arr[k]=arr[i];									//将arr[i]调整到双亲的结点上；修改k值，继续向下筛选
			k = i;
		}//for
		arr[k] = arr[0];
	}
	
	/**
	 * @param arr
	 * @param len
	 */
	public void HeapSort(Animal<Integer, Integer>[] arr, 
			int len, Map<String, Boolean> resultMap) {
		System.out.println("The fastest three horses are :");
		BuildMaxHeap(arr, len, resultMap);					//初始建堆
//		for(Animal<Integer, Integer> a:arr){
//			System.out.print(a.getSpeed()+",");
//		}
//		System.out.println();
		for (int i = len; i > len-3; i--) {
			Animal<Integer, Integer> tmp = arr[1];
			arr[1] = arr[i];
			arr[i] = tmp;
			AdjustDown(arr, 1, i-1, resultMap);
//			for(Animal<Integer, Integer> a:arr){
//				System.out.print(a.getSpeed()+",");
//			}
//			System.out.println();
			System.out.println("Horse:" + arr[i].getName());
		}//for
	}
	
	public static void main(String[] args){
		@SuppressWarnings("unchecked")
		Animal<Integer, Integer>[] arr = new Horse[11];
		for (int i = 1; i < 11; i++) {
			arr[i] = new Horse<Integer, Integer>(i + 1, i + 1);
		}//for

//		arr[1]=new Horse<Integer, Integer>(1, 55);
//		arr[2]=new Horse<Integer, Integer>(2, 2);
//		arr[3]=new Horse<Integer, Integer>(3, 33);
//		arr[4]=new Horse<Integer, Integer>(4, 66);
//		arr[5]=new Horse<Integer, Integer>(5, 101);
//		arr[6]=new Horse<Integer, Integer>(6, 14);
//		arr[7]=new Horse<Integer, Integer>(7, 27);
//		arr[8]=new Horse<Integer, Integer>(8, 9);
//		arr[9]=new Horse<Integer, Integer>(9, 22);
//		arr[10]=new Horse<Integer, Integer>(10, 89);
		
		Map<String, Boolean> resultMap=new HashMap<String, Boolean>();
		int len = 10;
		Match2 t = new Match2();
		t.HeapSort(arr, len, resultMap);
		System.out.println("Total matches :" + Match2.count);
	}
}
