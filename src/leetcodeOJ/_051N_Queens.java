package leetcodeOJ;
//LeetCode OJ 也是多次运行核心函数，所以初始化必须在函数开始处完成，否则一定wa
import java.util.ArrayList;
import java.util.List;

public class _051N_Queens {
	public static int upperlim;
	public static int sum;
	public static List<List<String>> res;
	
	public List<List<String>> solveNQueens(int n) {
		sum = 0;
		res = new ArrayList<List<String>>();
		List<String> cur = new ArrayList<String>();
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append('.');
		}
		String s=sb.toString();
		for (int i = 0; i < n; i++) {
			cur.add(s);
		}
		// N个皇后只需N位存储，N列中某列有皇后则对应bit置1。只能处理最多32皇后问题。
		upperlim = (1 << n) - 1;
		helper(0, 0, 0, cur, 0);
		return res;
    }

	public void helper(final int row, final int ld, final int rd, List<String> cur, final int index) {
		int pos, p, q;
		if (row != upperlim) {
			// row、ld、rd分别表示在列和两个对角线方向的限制条件
			// row，ld，rd进行“或”运算，求得所有可以放置皇后的列,对应位为0，
			// 然后再取反后“与”上全1的数，来求得当前所有可以放置皇后的位置(即pos)，对应列改为1
			// 也就是求取当前哪些列可以放置皇后
			//pos中二进制为1的位，表示可以在当前行的对应列放皇后
			//和upperlim与运算，主要是ld在上一层是通过左移位得到的，它的高位可能有无效的1存在，这样会清除ld高位无效的1
			pos = upperlim & (~(row | ld | rd));
			while (pos != 0x0) {// 0 -- 皇后没有地方可放，回溯
				// 拷贝pos最右边为1的bit，其余bit置0
				// 也就是取得可以放皇后的最右边的列
				//获取pos最右边的1,例如pos = 010110，则p = 000010
				p = pos & (~pos + 1);

				// 将pos最右边为1的bit清零
				// 也就是为获取下一次的最右可用列使用做准备，
				// 程序将来会回溯到这个位置继续试探
				//pos最右边的1清0
				pos -= p;

				// row + p，将当前列置1，表示记录这次皇后放置的列。
				// (ld + p) << 1，标记当前皇后左边相邻的列不允许下一个皇后放置。
				// (ld + p) >> 1，标记当前皇后右边相邻的列不允许下一个皇后放置。
				// 此处的移位操作实际上是记录对角线上的限制，只是因为问题都化归
				// 到一行网格上来解决，所以表示为列的限制就可以了。显然，随着移位
				// 在每次选择列之前进行，原来N×N网格中某个已放置的皇后针对其对角线
				// 上产生的限制都被记录下来了
				int col = 0;// 第row行，第loc1(p)列的位置放置一个queen或者清空queen，loc1(p)表示p中二进制1的位置
				q = p;
				while ((q & 1) == 0x0) {
					q >>= 1;
					col++;
				}
				setQueen(cur, index, col, 'Q');//在当前行，p中1对应的列放置皇后
				helper(row | p, (ld | p) << 1, (rd | p) >> 1, cur, index + 1);// 设置下一行
				setQueen(cur, index, col, '.');//若上一句代码没有得到一个可行解，则在当前行，p中1对应的列保留空白，继续寻找可行解
			}
		} else {
			List<String> cur2=new ArrayList<String>(cur);
			res.add(cur2);//避免出现始终保存同一个对象错误
			// row的所有位都为1，即找到了一个成功的布局，回溯
			sum++;
		}
	}
	
	public void setQueen(List<String> cur, final int row, int col, char val) {
		StringBuilder sb=new StringBuilder(cur.get(row));
		sb.setCharAt(col, val);
		cur.set(row, sb.toString());
	}
	
	public static void main(String ...strings){
		_051N_Queens o=new _051N_Queens();
		o.solveNQueens(2);
		System.out.printf("共找到%d种方案！\n", sum);
		for (List<String> list : res) {
			System.out.println("==========");
			for (String string : list) {
				System.out.println(string);
			}
		}
	}
}