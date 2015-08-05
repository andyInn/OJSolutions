package alibaba2;

public class Test1 {
	
	public Test1(){
	}
	
	public void BuildMaxHeap(int[] arr, int len) {
		for (int i = (len >> 1); i > 0; i--)				//下标1~len保存了堆的数据，arr[0]为哨兵
			AdjustDown(arr, i, len);						//从i=(len>>1)开始,反复调整堆
	}
	
	public void AdjustDown(int[] arr, int k, int len) {		//将元素arr[k]向下进行调整
		arr[0] = arr[k];									//arr[0]暂存调整的这个元素
		for (int i = (k << 1); i <= len; i = (i << 1)) {
			if(i<len && arr[i]<arr[i+1]) 					//取得孩子中较大者的下标
				i++;										
			if(arr[0]>=arr[i]) 
				break;
			arr[k]=arr[i];									//将arr[i]调整到双亲的结点上；修改k值，继续向下筛选
			k = i;											
		}//for
		arr[k] = arr[0];
	}
	
	/**
	 * 若求前N大的值，则对HeapSort堆排序算法内for循环做N-1次就得到了，可以将结果保存到list中。
	 * @param arr
	 * @param len
	 */
	public void HeapSort(int[] arr, int len) {
		System.out.print("The fastest three horses are :");
		BuildMaxHeap(arr, len);								//初始建堆
		for (int i = len; i > len-3; i--) {					//对所有1~len范围的数据——结点值进行排序,只剩一个结点时当然不用排序～
			arr[i]=arr[i]^arr[1];							//此处交换arr[1]和arr[i]的值
			arr[1]=arr[i]^arr[1];							//此时arr[1]保存的arr[i]的值
			arr[i]=arr[i]^arr[1];							//此时arr[i]保存的arr[1]的值
			AdjustDown(arr, 1, i-1);						//整理，把剩余的i-1个元素整理成堆
			System.out.println(arr[i]);
		}//for
	}
	
	public static void main(String[] args){
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int len = 10;
		Test1 t = new Test1();
		t.HeapSort(arr, len);
	}
}
