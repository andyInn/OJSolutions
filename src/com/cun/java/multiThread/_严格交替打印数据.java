package com.cun.java.multiThread;

import java.util.LinkedList;
import java.util.Queue;
/**
 * cvte面试中的一道题求解，队列由两个线程取出处理，然后按照原来的队列顺序放入新队列中。
 * 此方法可以插入新队列并打印出结果
 * @author Andy
 *
 */
public class _严格交替打印数据{
	public static int state=1;
	public static Queue<Integer> qSource = new LinkedList<Integer>();
	public static Queue<Integer> qNew = new LinkedList<Integer>();
	
	public _严格交替打印数据(){
		qSource.offer(1);
		qSource.offer(2);
		qSource.offer(3);
		qSource.offer(4);
		qSource.offer(5);
	}
	
	public static void main(String ...strings){
		final _严格交替打印数据 t=new _严格交替打印数据();
		final Object lock=new Object();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(qSource.peek()!=null){
					synchronized(lock){
						while(state==2){
							try {
								lock.wait();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						if(qSource.peek()!=null){
							System.out.println("thread:1");
							qNew.offer(qSource.poll());
						}
						state=2;
						lock.notifyAll();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(qSource.peek()!=null){
					synchronized(lock){
						while(state==1){
							try {
								lock.wait();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						if(qSource.peek()!=null){
							System.out.println("thread:2");
							qNew.offer(qSource.poll());
						}
						state=1;
						lock.notifyAll();
					}
				}
			}
		}).start();
		while(!qSource.isEmpty());//wait till qSource is empty
		int i = 0;
		while (qNew.peek() != null) {
			System.out.println(i++ +": " + qNew.poll());
		}
	}
}