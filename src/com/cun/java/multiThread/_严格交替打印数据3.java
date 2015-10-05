package com.cun.java.multiThread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * cvte面试中的一道题求解，队列由两个线程取出处理，然后按照原来的队列顺序放入新队列中
 * 此方法可以插入新队列并打印出结果
 * @author Andy
 *
 */
public class _严格交替打印数据3{
	public static void main(String ...strings){
		Queue<Integer> q=new LinkedList<Integer>();
		Queue<Integer> qNew = new LinkedList<Integer>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		TwoThread tt=new TwoThread();
		tt.q=q;
		
		Thread t1=new Thread1_3(tt);//多态实现
		Thread t2=new Thread2_3(tt);//多态实现
		t1.start();
		t2.start();
		/*
		//法一：
		Thread t1=new Thread(new Thread1(tt));
		Thread t2=new Thread(new Thread2(tt));
		t1.start();
		t2.start();*/
		
		/*
		//法二：
		Thread1 t1=new Thread1(tt);
		Thread2 t2=new Thread2(tt);
		ExecutorService exe=Executors.newCachedThreadPool();
		exe.execute(t1);
		exe.execute(t2);
		exe.shutdown();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(!exe.isTerminated());*/
		while(!tt.q.isEmpty());
		qNew=TwoThread.qNew;
		int i = 0;
		while (qNew.peek() != null) {
			System.out.println(i++ +": " + qNew.poll());
		}
	}
}

class TwoThread_3 {
	private static boolean flag = true;
	public Queue<Integer> q;
	public static Queue<Integer> qNew = new LinkedList<Integer>();
	
	public synchronized void pushOdd(){
		while(!flag){
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (q.peek() != null) {
			System.out.println("thread: Odd-"+q.peek());
			qNew.offer(q.poll());
		}
		flag=false;
		notify();
	}
	
	public synchronized void pushEven(){
		while(flag){
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (q.peek() != null) {
			System.out.println("thread: Even-"+q.peek());
			qNew.offer(q.poll());
		}
		flag=true;
		notify();
	}
}

class Thread1_3 extends Thread {
	private TwoThread tt;
	
	public Thread1_3(TwoThread tt){
		this.tt=tt;
	}
	@Override
	public void run() {
		while (tt.q.peek() != null) {
			tt.pushOdd();
		}
	}
}

class Thread2_3 extends Thread {
	private TwoThread tt;
	
	public Thread2_3(TwoThread tt){
		this.tt=tt;
	}
	@Override
	public void run() {
		while (tt.q.peek() != null) {
			tt.pushEven();
		}
	}
}