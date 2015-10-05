package com.cun.java.multiThread;

//仓库类
public class _生产者与消费者的多线程例子 {// class Store
	
	private final int MAX_SIZE;//仓库的最大容量
	private int count;//当前的货物数量
	public _生产者与消费者的多线程例子(int n){//初始化最大容量的构造方法
		MAX_SIZE = n;
		count = 0;
	}
	
	//往仓库加货物的方法
	public synchronized void add(){
		while(count >= MAX_SIZE){//每次执行都判断仓库是否已满
			System.out.println("已经满了");
			try {
				this.wait();//如果满了，就进入等待池
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		count++;//数量加1
		//打印当前仓库的货物数量
		System.out.println(Thread.currentThread().toString()+"put"+count);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//仓库中已经有东西可以取了，则通知所有的消费者线程来拿
		this.notifyAll();
	}
	
	//从仓库拿走货物的方法
	public synchronized void remove(){
		while(count<=0){
			System.out.println("空了");//每次执行都判断仓库是否为空
			try {
				this.wait();//如果为空，就进入等待池
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//打印当前仓库的货物数量
		System.out.println(Thread.currentThread().toString()+"get"+count);
		count--;//数量减1
		//仓库还没装满，通知生产者添加货物
		this.notifyAll();
	}

	public static void main(String[] args) {
		_生产者与消费者的多线程例子 s = new _生产者与消费者的多线程例子(5);
		//创建两个生产者和两个消费者
		Thread pro1 = new Producer(s);
		Thread con1 = new Consumer(s);
		Thread pro2 = new Producer(s);
		Thread con2 = new Consumer(s);
		pro1.setName("producer1");
		con1.setName("consumer1");
		pro2.setName("producer2");
		con2.setName("consumer2");
		//启动线程
		pro1.start();
		con1.start();
		pro2.start();
		con2.start();
	}
}

class Producer extends Thread{//生产者线程类
	private _生产者与消费者的多线程例子 s;
	public Producer(_生产者与消费者的多线程例子 s){
		this.s = s;
	}
	public void run(){//线程方法
		while(true){//循环
			s.add();//往仓库加货物
			try {
				Thread.sleep(500);//设置线程休息0.5s
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
class Consumer extends Thread{//消费者线程类
	private _生产者与消费者的多线程例子 s;
	public Consumer(_生产者与消费者的多线程例子 s){
		this.s = s;
	}
	public void run(){//线程方法
		while(true){//循环
			s.remove();//从仓库取走货物
			try {
				Thread.sleep(500);//设置线程休息0.5s
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}