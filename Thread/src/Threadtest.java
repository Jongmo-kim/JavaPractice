import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//타이핑 속도 간단하게 계산하는 프로그램
public class Threadtest {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Type: programming");
			
			long t1 = System.currentTimeMillis();
			String s = sc.next();
			long t2 = System.currentTimeMillis();
			
			if(s.equals("programming"))
				System.out.println("Elapsed Time: " + (t2-t1) + "msec");
			else
				System.out.println("Incorrect");
	}
}
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