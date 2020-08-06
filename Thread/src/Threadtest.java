import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * ������, ����� ����� ����ؼ� �����尡 �����ڿ��� ���ÿ� ����ϴ°� ���� ����
 * �����ʰ� �׳� ����� �ϸ� ���� �̻��ϰ� �ζڴ�.
 */
//��ũ�� ��� Synchronized
class Threadtest {
	public static void main(String[] args) {
		Counter c = new Counter();
		MyThread up = new MyThread(c, 1);
		MyThread down = new MyThread(c, -1);
		up.start();
		down.start();
		try {
		up.join(); 
		} catch ( InterruptedException e) {}
		try {
		down.join();
		} catch ( InterruptedException e) {}
		System.out.println("Count :" + c.getCount());
	}
}

class Counter {
	private int cnt;
	boolean bool;
  private Semaphore mutex;
  Counter() {
  	cnt = 0;
  	mutex = new Semaphore(1);
  	bool=true;
  }
	synchronized void increment(int i) {
		cnt = cnt + i;
	}

	int getCount() {
		return cnt;
	}
}

class MyThread extends Thread {
	private Counter c;
	private int amount;

	MyThread(Counter c, int amount) {
		this.c = c;
		this.amount = amount;
	}

	public void run() {
		for (int List_i = 0; List_i < 100000000; ++List_i){
			c.increment(amount);
		}
	}
}
////������ ���
//class Threadtest {
//	public static void main(String[] args) {
//		Counter c = new Counter();
//		MyThread up = new MyThread(c, 1);
//		MyThread down = new MyThread(c, -1);
//		up.start();
//		down.start();
//		try {
//		up.join(); 
//		} catch ( InterruptedException e) {}
//		try {
//		down.join();
//		} catch ( InterruptedException e) {}
//		System.out.println("Count :" + c.getCount());
//	}
//}
//
//class Counter {
//	private int cnt;
//    private Semaphore mutex;
//    Counter() {
//    	cnt = 0;
//    	mutex = new Semaphore(1);
//    }
//	void increment(int i) {
//		try {
//		mutex.acquire();
//		}catch(InterruptedException e) {}
//		cnt = cnt + i;
//		mutex.release();
//	}
//
//	int getCount() {
//		return cnt;
//	}
//}
//
//class MyThread extends Thread {
//	private Counter c;
//	private int amount;
//
//	MyThread(Counter c, int amount) {
//		this.c = c;
//		this.amount = amount;
//	}
//
//	public void run() {
//		for (int List_i = 0; List_i < 100000000; ++List_i){
//			c.increment(amount);
//		}
//	}
//}
////����� sychornized�� ����� ����
//public class Threadtest {
//
//	public static void main(String[] args) {
//		RestRoom room = new RestRoom();
//		MyThread kim = new MyThread(room, "Kim");
//		MyThread lee = new MyThread(room, "Lee");
//		kim.start(); lee.start();
//	}
//}
//class RestRoom {
//    private boolean first;
//    RestRoom() {
//    	first = true;
//    }
//
//    //ȭ����� ������ ����Ҽ� �ְԲ� ���� �ڵ�.
//	synchronized void use(String name) {
//		if (first && name.equals("Kim") || !first && name.equals("Lee")) {
//			try {
//				wait();//�����带 ����
//			} catch (InterruptedException e) {
//
//			}
//		}
//		System.out.print(name + "Entered");
//		System.out.print(name + "Used");
//		System.out.println(name + "Exited");
//		first = !first;
//		notify(); //�����带 �ƿ��
//	}
//}
//class MyThread extends Thread {
//	private RestRoom room;
//	private String name;
//	MyThread(RestRoom room,String name){
//		this.room = room;
//		this.name = name;
//	}
//	public void run() {
//		for ( int List_i=0;List_i<3;++List_i)
//			room.use(name);
//	}
//}
////����� sychornized�� ����� ����
//public class Threadtest {
//	public static void main(String[] args) {
//		RestRoom room = new RestRoom();
//		MyThread kim = new MyThread(room, "Kim");
//		MyThread lee = new MyThread(room, "Lee");
//		kim.start(); lee.start();
//	}
//}
//class RestRoom {
//
//	synchronized void use(String name) {
//		
//		System.out.print(name + "Entered");
//		System.out.print(name + "Used");
//		System.out.println(name + "Exited");
//	
//	}
//}
//class MyThread extends Thread {
//	private RestRoom room;
//	private String name;
//	MyThread(RestRoom room,String name){
//		this.room = room;
//		this.name = name;
//	}
//	public void run() {
//		for ( int List_i=0;List_i<13;++List_i)
//			room.use(name);
//	}
//}
//���߽����� ��ȣ��Ÿ �����ڿ� ��빮���� �����ϱ� ���� ����
//�������� ����� ����
//public class Threadtest {
//	public static void main(String[] args) {
//		RestRoom room = new RestRoom();
//		MyThread kim = new MyThread(room, "Kim");
//		MyThread lee = new MyThread(room, "Lee");
//		kim.start(); lee.start();
//	}
//}
//class RestRoom {
//	private Semaphore mutex;
//	RestRoom() {
//		mutex = new Semaphore(1);
//	}
//	void use(String name) {
//		try {
//		mutex.acquire();	
//		} catch (InterruptedException e) {}
//		System.out.print(name + "Entered");
//		System.out.print(name + "Used");
//		System.out.println(name + "Exited");
//		mutex.release();
//	
//	}
//}
//class MyThread extends Thread {
//	private RestRoom room;
//	private String name;
//	MyThread(RestRoom room,String name){
//		this.room = room;
//		this.name = name;
//	}
//	public void run() {
//		for ( int List_i=0;List_i<3;++List_i)
//			room.use(name);
//	}
//}
////Ÿ���� �ӵ� �����ϰ� ����ϴ� ���α׷�
//public class Threadtest {
//
//	public static void main(String[] args) {
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Type: programming");
//			
//			long t1 = System.currentTimeMillis();
//			String s = sc.next();
//			long t2 = System.currentTimeMillis();
//			
//			if(s.equals("programming"))
//				System.out.println("Elapsed Time: " + (t2-t1) + "msec");
//			else
//				System.out.println("Incorrect");
//	}
//}
//// �ð��� ��� ���α׷�
//public class Threadtest {
//
//	public static void main(String[] args) {
//			JFrame f = new JFrame();
//			f.setSize(300,200);
//			f.setLocationRelativeTo(null);
//			f.setVisible(true);
//			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			f.add(new MyPanel());
//	}
//}
//class MyPanel extends JPanel implements Runnable {
//	private JLabel lb;
//	private int cnt;
//	MyPanel(){
//		add(lb = new JLabel("1"));
//		lb.setFont(new Font("Dialog", Font.BOLD, 80));
//		lb.setForeground(Color.green);
//		cnt =  0;
//		Thread th = new Thread(this);
//		th.start();
//	}
//	void update() {
//		lb.setText(String.valueOf(++cnt));
//	}
//	public void run() {
//		while(true) {
//			try {
//				update();
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//
//			}
//		}
//	}
//}
//
//public class Threadtest {
//
//	public static void main(String[] args) throws InterruptedException {
//		MyThread th = new MyThread();
//		th.start();
//			for (int List_i = 0; List_i < 500; ++List_i) {
//				System.out.print('A');
//				Thread.sleep(100);
//			}
//	}
//}
////public void run() throws IntrupttedException�� �ȵǴ� ������
////public void run() �Լ��� �� ����� ����Ǿ� �ְ� throws �� ���ԵȰ� ���⿡ 
////���� ���Ǹ� �� ������ �ʴ��̻� �Լ��� �ǵ���� �������� �ʴ´�.
//class MyThread extends Thread {
//	public void run() {
//		try {
/////////////////////////////////////////////		
//		for ( int List_i=0; List_i<500;++List_i) {
//			sleep(100);// Mythread ������ �����ϹǷ� thread.�� �Ⱥٿ�����
//			System.out.print('B');
//			}
/////////////////////////////////////////
//		}catch (InterruptedException e) {
//			System.out.println("Intreruptted Exception");
//		}
//	}
//}
//���߽����� ���� ����� ����
/*
 * Thread�� new���� ���ϰ� ���� �ִ� ������ Thread.sleep�� static ���� ����Ǿ 
 * �ٷ� ����Ҽ� �ִ� C++�� �������� ���� �����ϵ�.
 */
//public class Threadtest {
//
//	public static void main(String[] args) {
//		try {
/////////////////////////////////////////////
//			for (int List_i = 0; List_i < 500; ++List_i) {
//				System.out.print('A');
//				Thread.sleep(100);
//			}
/////////////////////////////////////
//		} catch (InterruptedException e) {
//			System.out.println("InterruptedException");
//		}
//	}
//}
////���߽����� ���� 2
//public class Threadtest {
//
//	public static void main(String[] args) {
//		MyThread th = new MyThread();
//		th.start();
//		for (int List_i = 0; List_i < 500; ++List_i)
//			System.out.print('A');
//	}
//
//}
//
//class MyThread extends Thread {
//	boolean flag;
//
//	public void run() {
//		for(int List_i=0;List_i<500;++List_i)
//			System.out.print('B');
//	}
//}
//
////���߽����� ���� 1
//public class Threadtest {
//
//	public static void main(String[] args) {
//		MyThread th = new MyThread();
//		th.start();
//		
//		while (th.flag == false)
//			System.out.print('A');
//
//	}
//
//}
//
//class MyThread extends Thread{
//	boolean flag;
//	public void run() {
//		try {
//			///////////////////////
//			if(System.in.read()>0)
//				flag=true;
//		}
//		catch(IOException e) {
//			System.out.println("IOException");
//		}
//		
//	}
//}