package leetcodeOJ;

public class _134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length < 1) return 0;
        int i = 0, balance = 0, p = 0;
        for (; i < gas.length; i++) {
            if (balance < 0 && gas[i] >= 0) {
                balance = 0;
                p = i;
            }
            gas[i] -= cost[i];
            balance += gas[i];
            if (i > 0) gas[i] += gas[i - 1];
        }
        return p > 0 ? (balance >= (-gas[p - 1]) ? p : -1) : (balance >= 0 ? 0 : -1);
    }
}
