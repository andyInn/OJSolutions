package com.cun.java.searchFind;

public class HeapSort {
	public static void main(String[] args) {
	}

	/**
	 * 通常，取一堆数据中的k个最大或最小的元素，都优先采用堆排序～
	 * 堆的定义如下(要求是完全二叉树)：
	 * n个关键字序列L[1...n]成为堆，当且仅当该序列满足：
	 * 一，L[i]<=L[2*i]且L[i]<=L[2*i+1]或二，L[i]>=L[2*i]且L[i]>=L[2*i+1]  ,(1<=i<=n>>1)
	 * 满足第一中情况的堆称为小根堆（小顶堆），满足第二中情况的堆称为大根堆（大顶堆）
	 * 
	 * 大根堆和小根堆建堆区别在于AdjustDown函数
	 * 真正保存数据的是arr[1]~arr[n]区域的元素，arr[0]暂存调整的某个元素
	 * 
	 * 堆排序建堆时间为O(n),之后有n-1次向下调整操作，每次调整的时间复杂度为O(h),
	 * 故在最好，最坏，平均情况下，堆排序的时间复杂度为O(nlogn)，以2为底。
	 */
	public void buildMaxHeap(int[] arr, int len) {
		for(int i=(len>>1);i>0;i--)							//下标1~len保存了堆的数据，arr[0]为哨兵
			adjustDown(arr, i, len);						//从i=(len>>1)开始,反复调整堆
	}
	
	public void adjustDown(int[] arr, int k, int len) {		//将元素arr[k]向下进行调整，下标1~len保存了堆的数据，arr[0]为哨兵
		arr[0] = arr[k];									//arr[0]暂存调整的这个元素
		for(int i=(k<<1);i<=len;i=(i<<1)){
			if(i<len && arr[i]<arr[i+1]) i++;				//取得孩子中较大者的下标
			if(arr[0]>=arr[i]) break;
			arr[k]=arr[i]; k = i;							//将arr[i]调整到双亲的结点上；修改k值，继续向下筛选
		}//for
		arr[k]=arr[0];
	}
	
	/**
	 * 这里对排好序的大顶堆进行层序遍历，即得到从小到大的数据list。
	 * 若求前N大的值，则对HeapSort堆排序算法内for循环做N-1次就得到了，可以将结果保存到list中。
	 * @param arr
	 * @param len
	 */
	public void heapSort(int[] arr, int len) {
		if (arr == null || arr.length == 0)
			return;
		buildMaxHeap(arr, len);								//初始建堆
		for(int i=len;i>1;i--){								//对所有1~len范围的数据——结点值进行排序,只剩一个结点时当然不用排序～
			arr[i]=arr[i]^arr[1];							//此处交换arr[1]和arr[i]的值
			arr[1]=arr[i]^arr[1];							//此时arr[1]保存的arr[i]的值
			arr[i]=arr[i]^arr[1];							//此时arr[i]保存的arr[1]的值
			adjustDown(arr, 1, i-1);						//整理，把剩余的i-1个元素整理成堆
		}//for
	}
	
	/**
	 * 堆顶元素等价于根元素～
	 * 在最大堆或最小堆中执行插入操作，就会需要AdjustUp向上调整了。
	 * 先将新结点放在堆的末端，再对这个新结点执行AdjustUp向上调整操作即可。
	 * 
	 * 由于堆顶元素或为最大值或为最小值，删除堆顶元素时，先将堆的最后一个元素与堆顶元素交换，
	 * 由于此时堆的性质被破坏，需对此时的根节点进行AdjustDown向下调整操作。
	 * @param arr
	 * @param k
	 */
	public void adjustUp(int[] arr, int k) {
		arr[0]=arr[k];										//参数k为向上调整的起点，也为堆的元素个数
		int i=0;											//若结点值大于双亲结点，则将双亲结点向下调，并继续向上比较
		while((i=(k>>1))>0 && arr[i]<arr[0]){				//这里arr[i]是双亲结点
			arr[k]=arr[i]; k=i;								//arr[i]双亲结点向下调整，实质为arr[k]目标元素向上调整了，因为这句k=i;
		}//while
		arr[k]=arr[0];										//复制到最终位置
	}
}
