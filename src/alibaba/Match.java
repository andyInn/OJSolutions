/**
 * @author Andy
 * @date 2015/7/15
 */
package alibaba;

import java.util.HashMap;
import java.util.Map;

public class Match {
	
	public static int count = 0;
	
	public Match(){
	}
	
	public void BuildMaxHeap(Animal<Integer, Integer>[] arr, int len,
			Map<SingleMatch, Boolean> resultMap) {
		for (int i = (len >> 1); i > 0; i--)				//下标1~len保存了堆的数据，arr[0]为哨兵
			AdjustDown(arr, i, len, resultMap);				//从i=(len>>1)开始,反复调整堆
	}
	
	public void AdjustDown(Animal<Integer, Integer>[] arr, 
			int k, int len, Map<SingleMatch, Boolean> resultMap) {
		arr[0] = arr[k];									//arr[0]暂存调整的这个元素
		for (int i = (k << 1); i <= len; i = (i << 1)) {
			if(i<len){										//取得孩子中较大者的下标
				SingleMatch sm1 = 
					new SingleMatch(arr[i].getName(), arr[i+1].getName());
				SingleMatch sm2 = 
					new SingleMatch(arr[i+1].getName(), arr[i].getName());
				if (resultMap.containsKey(sm1)) {			//查询比赛结果
					if (resultMap.get(sm1) == false) {
						i++;								//查询到了
					}
				}else{										//保存比赛结果
					if(arr[i].getSpeed()<arr[i+1].getSpeed()){
						resultMap.put(sm1, false);
						resultMap.put(sm2, false);
						i++;								//“查询”到了
					}else{
						resultMap.put(sm1, true);
						resultMap.put(sm2, true);
					}
					count++;
				}
			}
			SingleMatch sm3 = new SingleMatch(arr[0].getName(), arr[i].getName());
			SingleMatch sm4 = new SingleMatch(arr[i].getName(), arr[0].getName());
			if (resultMap.containsKey(sm3)) {
				if (resultMap.get(sm3) == true) {			//arr[0].getSpeed()>=arr[i].getSpeed()
					break;
				}
			}else{
				count++;
				if(arr[0].getSpeed()<arr[i].getSpeed()){
					resultMap.put(sm3, false);
					resultMap.put(sm4, false);
				}else{										//arr[0].getSpeed()>=arr[i].getSpeed()
					resultMap.put(sm3, true);
					resultMap.put(sm4, true);
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
			int len, Map<SingleMatch, Boolean> resultMap) {
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
//		for (int i = 1; i < 11; i++) {
//			arr[i] = new Horse<Integer, Integer>(i + 1, i + 1);
//		}//for

		arr[1]=new Horse<Integer, Integer>(1, 55);
		arr[2]=new Horse<Integer, Integer>(2, 2);
		arr[3]=new Horse<Integer, Integer>(3, 33);
		arr[4]=new Horse<Integer, Integer>(4, 66);
		arr[5]=new Horse<Integer, Integer>(5, 101);
		arr[6]=new Horse<Integer, Integer>(6, 14);
		arr[7]=new Horse<Integer, Integer>(7, 27);
		arr[8]=new Horse<Integer, Integer>(8, 9);
		arr[9]=new Horse<Integer, Integer>(9, 22);
		arr[10]=new Horse<Integer, Integer>(10, 89);
		
		Map<SingleMatch, Boolean> resultMap=new HashMap<SingleMatch, Boolean>();
		int len = 10;
		Match t = new Match();
		t.HeapSort(arr, len, resultMap);
		System.out.println("Total matches :" + Match.count);
	}
}
