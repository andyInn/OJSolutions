package jiuDuOJ;
import java.util.Scanner;

public class OtherPersonCode {
	public static void main(String[] args) {
		int n, s, e, k;
		int arr[] = new int[10001];
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			n = scanner.nextInt();
			int min = n + 1, max = n;
			int i = 0, j;
			for (i = 0; i < n; i++)
				arr[i] = scanner.nextInt();
			k = scanner.nextInt();
			for (i = 0; i < n; i++) {
				long tmp = 0;
				int flag = 0;
				for (j = i; j < n; j++) {
					tmp += arr[j];
					if (tmp == k) {
						s = i + 1;
						e = j + 1;
						if (min > s && max >= e) {
							min = s;
							max = e;
						}
						flag = 1;
						tmp = 0;
						break;
					}
				}
				if (flag == 1)
					break;
			}
			if (min <= max)
				System.out.println(min + " " + max);
			else
				System.out.println("No");
		}
	}
}
