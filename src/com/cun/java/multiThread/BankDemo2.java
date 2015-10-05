package com.cun.java.multiThread;

class Bank2 {
	private int sum;
	public synchronized void add(int n) {
		Object obj = new Object();
		sum += n;
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("sum=" + sum);
	}
}

class Cus2 implements Runnable {
	private Bank2 b = new Bank2();
	public void run() {
		for (int x = 0; x < 3; x++) {
			b.add(100);
		}
	}
}

public class BankDemo2 {
	public static void main(String[] args) {
		Cus2 c = new Cus2();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}
/*
总结：

1.在一个类中定义要处理的问题，方法。
2.在实现Runnable的类中重写run方法中去调用已经定义的类中的要处理问题的方法。
在synchronized块中接受要处理问题那个类的对象。
3.在main方法中去定义多个线程去执行。
*/