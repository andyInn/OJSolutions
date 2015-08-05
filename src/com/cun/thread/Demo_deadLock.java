package com.cun.thread;
//An example of deadlock.
public class Demo_deadLock implements Runnable {
	A_deadLock a = new A_deadLock();
	B_deadLock b = new B_deadLock();

	Demo_deadLock() {
		Thread.currentThread().setName("MainThread");
		Thread t = new Thread(this, "RacingThread");
		t.start();
		a.foo(b); // get lock on a in this thread.
		System.out.println("Back in main thread");
	}

	public void run() {
		b.bar(a); // get lock on b in other thread.
		System.out.println("Back in other thread");
	}

	public static void main(String args[]) {
		new Demo_deadLock();
	}
}

class A_deadLock {
	synchronized void foo(B_deadLock b) {
		String name = Thread.currentThread().getName();
		System.out.println(name + " entered A.foo");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("A Interrupted");
		}
		System.out.println(name + " trying to call B.last()");
		b.last();
	}

	synchronized void last() {
		System.out.println("Inside A.last");
	}
}

class B_deadLock {
	synchronized void bar(A_deadLock a) {
		String name = Thread.currentThread().getName();
		System.out.println(name + " entered B.bar");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("B Interrupted");
		}
		System.out.println(name + " trying to call A.last()");
		a.last();
	}

	synchronized void last() {
		System.out.println("Inside A.last");
	}
}