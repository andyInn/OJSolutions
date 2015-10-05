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
	public Queue<Integer> q;
	public static Queue<Integer> qNew = new LinkedList<Integer>();
	
	public _严格交替打印数据(Queue<Integer> q){
		this.q=q;
	}
	
	public static void main(String ...strings){
		Queue<Integer> q=new LinkedList<Integer>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		final _严格交替打印数据 t=new _严格交替打印数据(q);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(t.q.peek()!=null){
					synchronized(t){
						while(state==2){
							try {
								t.wait();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						if(t.q.peek()!=null){
							System.out.println("thread:1");
							qNew.offer(t.q.poll());
						}
						state=2;
						t.notifyAll();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(qNew.peek()!=null){
					synchronized(t){
						while(state==1){
							try {
								t.wait();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						if(t.q.peek()!=null){
							System.out.println("thread:2");
							qNew.offer(t.q.poll());
						}
						state=1;
						t.notifyAll();
					}
				}
			}
		}).start();
		while(!t.q.isEmpty());//wait till q is empty
		int i = 0;
		while (qNew.peek() != null) {
			System.out.println(i++ +": " + qNew.poll());
		}
	}
}