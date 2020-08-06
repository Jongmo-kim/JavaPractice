import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * 세마포, 모니터 방법을 사용해서 스레드가 공유자원을 동시에 사용하는걸 막는 예제
 * 막지않고 그냥 사용을 하면 값이 이상하게 널뛴다.
 */
//싱크로 방법 Synchronized
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
////세마포 방법
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
////모니터 sychornized를 사용한 예제
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
//    //화장실을 번갈아 사용할수 있게끔 만든 코드.
//	synchronized void use(String name) {
//		if (first && name.equals("Kim") || !first && name.equals("Lee")) {
//			try {
//				wait();//스레드를 재운다
//			} catch (InterruptedException e) {
//
//			}
//		}
//		System.out.print(name + "Entered");
//		System.out.print(name + "Used");
//		System.out.println(name + "Exited");
//		first = !first;
//		notify(); //스레드를 꺠운다
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
////모니터 sychornized를 사용한 예제
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
//다중스레드 상호베타 공유자원 사용문제를 이해하기 위한 예제
//세마포를 사용한 예제
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
////타이핑 속도 간단하게 계산하는 프로그램
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
//// 시간초 재는 프로그램
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
////public void run() throws IntrupttedException가 안되는 이유는
////public void run() 함수가 저 모양대로 선언되어 있고 throws 가 포함된건 없기에 
////따로 정의를 해 만들지 않는이상 함수가 의도대로 동작하지 않는다.
//class MyThread extends Thread {
//	public void run() {
//		try {
/////////////////////////////////////////////		
//		for ( int List_i=0; List_i<500;++List_i) {
//			sleep(100);// Mythread 내에서 정의하므로 thread.를 안붙여도됨
//			System.out.print('B');
//			}
/////////////////////////////////////////
//		}catch (InterruptedException e) {
//			System.out.println("Intreruptted Exception");
//		}
//	}
//}
//다중스레드 슬립 사용한 예제
/*
 * Thread를 new선언 안하고 쓸수 있는 이유는 Thread.sleep이 static 으로 선언되어서 
 * 바로 사용할수 있다 C++의 전역변수 같은 느낌일듯.
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
////다중스레드 예제 2
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
////다중스레드 예제 1
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