package leetcodeOJ;

public class _1017BaseNeg2 {
    public String baseNeg2(int N) {
        if(N==0) return "0";
        StringBuilder r = new StringBuilder();
        int t=N;
        int k=1;
        while(t!=0){
            if(t%2==1){
                r.append('1');
                t-=k;
            }else r.append('0');
            t/=2;
            k*=-1;
        }
        return r.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new _1017BaseNeg2().baseNeg2(0));
        System.out.println(new _1017BaseNeg2().baseNeg2(1));
        System.out.println(new _1017BaseNeg2().baseNeg2(2));
        System.out.println(new _1017BaseNeg2().baseNeg2(3));
        System.out.println(new _1017BaseNeg2().baseNeg2(4));
    }
}
