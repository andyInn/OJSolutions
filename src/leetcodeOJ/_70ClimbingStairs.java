package leetcodeOJ;

public class _70ClimbingStairs {
    public int climbStairs(int n) {
        if(n<1) return 1;
        if(n<3) return n;
        int f1 = 1, f2 = 2, fn=0;
        for(int i=3;i<=n;i++){
            fn = f1+f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }
}
