package leetcodeOJ;

public class _052N_QueensII {
	public static int upperlim;
	public static int sum;
	
	public int totalNQueens(int n) {
		sum = 0;
		// N个皇后只需N位存储，N列中某列有皇后则对应bit置1。只能处理最多32皇后问题。
		upperlim = (1 << n) - 1;
		helper(0, 0, 0);
		return sum;
    }

	public void helper(final int row, final int ld, final int rd) {
		int pos, p;
		if (row != upperlim) {
			pos = upperlim & (~(row | ld | rd));
			while (pos != 0x0) {// 0 -- 皇后没有地方可放，回溯
				p = pos & (~pos + 1);
				pos -= p;
				helper(row | p, (ld | p) << 1, (rd | p) >> 1);// 设置下一行
			}
		} else {
			sum++;
		}
	}
	
	public static void main(String ...strings){
		long start=System.currentTimeMillis();
		_052N_QueensII o=new _052N_QueensII();
		o.totalNQueens(5);
		System.out.printf("共找到%d种方案！\n", sum);
		long end=System.currentTimeMillis();
		System.out.printf("共耗时%dms.",end-start);
//		int n=3&2;
//		System.out.println(n);
	}
}
