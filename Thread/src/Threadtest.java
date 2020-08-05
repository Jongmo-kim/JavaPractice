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

//public void run() throws IntrupttedException가 안되는 이유는
//public void run() 함수가 저 모양대로 선언되어 있고 throws 가 포함된건 없기에 
//따로 정의를 해 만들지 않는이상 함수가 의도대로 동작하지 않는다.
class MyThread extends Thread {
	public void run() {
		try {
///////////////////////////////////////////		
		for ( int List_i=0; List_i<500;++List_i) {
			sleep(100);// Mythread 내에서 정의하므로 thread.를 안붙여도됨
			System.out.print('B');
			}
///////////////////////////////////////
		}catch (InterruptedException e) {
			System.out.println("Intreruptted Exception");
		}
	}
}

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