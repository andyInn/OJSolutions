package com.cun.java.multiThread;

class Bank {
	private int sum;
	public void add(int n) {
		sum += n;
		System.out.println("sum=" + sum);
	}
}

class Cus implements Runnable {
	private Bank b = new Bank();
	public void run() {
		synchronized (b) {
			for (int x = 0; x < 3; x++) {
				b.add(100);
			}
		}
	}
}

public class BankDemo {
	public static void main(String[] args) {
		Cus c = new Cus();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}