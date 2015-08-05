package alibaba2;
/*package taobao2;

public class Match2 {
	
	public Match2(){
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
	
	*//**
	 * @param arr
	 * @param len
	 *//*
	public void HeapSort(int[] arr, int len) {
		System.out.print("The fastest three horses are :");
		BuildMaxHeap(arr, len);								//初始建堆
		for (int i = len; i > len-3; i--) {					//对所有1~len范围的数据——结点值进行排序
			arr[i]=arr[i]^arr[1];							
			arr[1]=arr[i]^arr[1];							
			arr[i]=arr[i]^arr[1];							
			AdjustDown(arr, 1, i-1);						
			System.out.println(arr[i]);
		}//for
	}
	
	public static void main(String[] args){
		@SuppressWarnings("unchecked")
		Animal<Integer>[] a = new Horse[10];
		for (int i = 0; i < 10; i++) {
			a[i] = new Horse<Integer>(i + 1);
		}//for

		int[] arr = new int[11];
		for (int i = 1; i < 11; i++) {
			arr[i] = (Integer) a[i - 1].getSpeed();
		}//for
		
		int len = 10;
		Match2 t = new Match2();
		t.HeapSort(arr, len);
	}
}
*/