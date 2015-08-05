/**
 * 
 */
package com.cun.thread;

/**
 * @author Andy
 * @date 20150302
 */
public class Demo_constructor{
    public static void main(String[] args){
        B b = new B(new A());
    }
}

class A{
    public A(){
    	System.out.println("这是构造方法A");
        new B(this).print();  // 匿名对象
    }
    public void print(){
        System.out.println("Hello from A!");
    }
}

class B{
    A a;
    public B(A a){
    	System.out.println("这是构造方法B");
        this.a = a;
    }
    public void print() {
        a.print();
        System.out.println("Hello from B!");
    }
}