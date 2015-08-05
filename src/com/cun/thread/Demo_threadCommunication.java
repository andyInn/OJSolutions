package com.cun.thread;

public class Demo_threadCommunication {
	public static void main(String args[]) {
		Q q = new Q();
		Producer pro = new Producer(q);
		Consumer con = new Consumer(q);
		try {
			pro.t.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("生产者子线程出错啦～");
			System.out.println(e.getMessage());
		} finally {
			System.out.println("生产者 is alive:" + pro.t.isAlive());
			System.out.println("消费者 is alive:" + con.t.isAlive());
		}
		try {
			con.t.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("消费者子线程出错啦～");
		} finally {
			System.out.println("生产者 is alive:" + pro.t.isAlive());
			System.out.println("消费者 is alive:" + con.t.isAlive());
		}

		System.err.println("Press Control-C to stop.");
	}
}

// A correct implementation of a producer and consumer.
class Q {
	int n;
	boolean valueSet = false;

	synchronized int get(Thread t_con) {
		if (!valueSet && n == 4) {
			//这里的if块多余，懒得删了
			System.err.println("生产者已死!!!");

			try {
				t_con.interrupt();
//				System.exit(0);
			} catch (SecurityException e) {
				// TODO: handle exception
				System.out.println("消费者 SecurityException caught!");
			}
		}else {
			if (!valueSet) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("InterruptedException caught");
				}
			}
			System.out.println("Got: " + n);
			valueSet = false;
			notify();
		}
		
		return n;
	}

	synchronized void put(int n) {
		if (valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		this.n = n;
		valueSet = true;
		System.out.println("Put: " + n);
		notify();
	}
}

class Producer implements Runnable {
	Q q;
	Thread t;

	Producer(Q q) {
		this.q = q;
		t = new Thread(this, "Producer");
		t.start();
	}

	public void run() {
		int i = 0;
		while (i < 5) {
			q.put(i++);
		}
		try {
			this.t.interrupt();
		} catch (SecurityException e) {
			// TODO: handle exception
			System.out.println("生产者 SecurityException caught!");
		}
	}
}

class Consumer implements Runnable {
	Q q;
	Thread t;

	Consumer(Q q) {
		this.q = q;
		t = new Thread(this, "Consumer");
		t.start();
	}

	public void run() {
		while (true) {
			int tmp_n= q.get(t);
			if(tmp_n==4)
				break;
		}
	}
}
/*
 * class PCFixed { public static void main(String args[]) { Q q = new Q(); new
 * Producer(q); new Consumer(q); System.out.println("Press Control-C to stop.");
 * } }
 */