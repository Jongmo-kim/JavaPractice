import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//Ÿ���� �ӵ� �����ϰ� ����ϴ� ���α׷�
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