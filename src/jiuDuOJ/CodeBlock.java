package jiuDuOJ;

/**
 * 普通代码块中的局部变量
 * @author zendao
 */
public class CodeBlock {

    public static void main(String args[]) {

        int x = 100;
        String str=null;
        {
            //  普通代码块
            x = 30;
            str="我爱你～";
            System.out.println("in str="+str);
            System.out.println("in x="+x);
        }
        System.out.println("out str="+str);
        System.out.println("out x="+x);
    }
}