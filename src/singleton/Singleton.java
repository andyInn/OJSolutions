package singleton;
 
/**
 * @author lei
 * 单例模式的五种写法：
 * 1、懒汉
 * 2、恶汉
 * 3、静态内部类
 * 4、枚举
 * 5、双重校验锁
 * 2011-9-6
 */
/**
 *五、 双重校验锁，在当前的内存模型中无效
 */
class LockSingleton{
    private volatile static LockSingleton singleton;
    private LockSingleton(){}
     
    //详见：http://www.ibm.com/developerworks/cn/java/j-dcl.html
    public static LockSingleton getInstance(){
        if(singleton==null){
            synchronized(LockSingleton.class){
                if(singleton==null){
                    singleton=new LockSingleton();
                }
            }
        }
        return singleton;
    }
     
}
/**
 * 四、枚举，《Effective Java》作者推荐使用的方法，优点：不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 */
enum EnumSingleton{
    INSTANCE;
    public void doSomeThing(){
    }
}
/**
 * 三、静态内部类 优点：加载时不会初始化静态变量INSTANCE，因为没有主动使用，达到Lazy loading
 */
class InternalSingleton{
    private static class SingletonHolder{
        private final static  InternalSingleton INSTANCE=new InternalSingleton();
    }   
    private InternalSingleton(){}
    public static InternalSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
/**
 * 二、恶汉,缺点：没有达到lazy loading的效果
 */
class HungrySingleton{
    private static HungrySingleton singleton=new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return singleton;
    }
}
/**
 * 一、懒汉，常用的写法
 */
class LazySingleton{
    private static LazySingleton singleton;
    private LazySingleton(){
    }
    public static LazySingleton getInstance(){
        if(singleton==null){
            singleton=new LazySingleton();
        }
        return singleton;
    }   
}