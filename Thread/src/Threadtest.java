import java.io.*;

public class Threadtest {

	public static void main(String[] args) throws InterruptedException {
		MyThread th = new MyThread();
		th.start();
			for (int List_i = 0; List_i < 500; ++List_i) {
				System.out.print('A');
				Thread.sleep(100);
			}
	}
}

//public void run() throws IntrupttedException�� �ȵǴ� ������
//public void run() �Լ��� �� ����� ����Ǿ� �ְ� throws �� ���ԵȰ� ���⿡ 
//���� ���Ǹ� �� ������ �ʴ��̻� �Լ��� �ǵ���� �������� �ʴ´�.
class MyThread extends Thread {
	public void run() {
		try {
///////////////////////////////////////////		
		for ( int List_i=0; List_i<500;++List_i) {
			sleep(100);// Mythread ������ �����ϹǷ� thread.�� �Ⱥٿ�����
			System.out.print('B');
			}
///////////////////////////////////////
		}catch (InterruptedException e) {
			System.out.println("Intreruptted Exception");
		}
	}
}

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