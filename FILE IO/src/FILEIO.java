import java.io.*;
import java.util.*; //for scanner
import java.util.Random;

public class FILEIO{
	
	public static void main(String[] args) throws IOException { 
		worder w = new worder();
		for(int List_i=0; List_i < 10 ;++List_i)
			System.out.println(w.getWord());
	}
}
//// scaner ����ȭ�� �Է� �б� 
//public class FILEIO {
//
//	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(new BufferedReader(new FileReader("data.txt")));
//
//		while (sc.hasNext() == true) {
//			String name = sc.next();
//			int mid = sc.nextInt();
//			int fin = sc.nextInt();
//			System.out.print(name + " " + (mid + fin) + "��\n");
//		}
//
//	}
//}
////���� ����� ���� ��� 2
//public class FILEIO {
//
//	public static void main(String[] args) throws IOException {
//		//FileReader rd = new FileReader("data.txt"); filereader ���� BufferedReader �� ����� �ӵ�,ȿ�� �鿡��
//		BufferedReader rd = new BufferedReader(new FileReader("data.txt")); 
//		String s;
//		while ((s=rd.readLine())!=null)
//			System.out.println(s);
//		rd.close();
//		
//	}
//
//}
//
//
//
////���� ����� ���� ��� 1
//public class FILEIO {
//
//	public static void main(String[] args) {
//		/////////////////////
//		try {
//		FileReader rd = new FileReader("data.txt");
//		int c;
//		while ((c=rd.read())!=-1)
//			System.out.println((char)(c));
//		rd.close();
//		}
//		///////////////////
//		catch (FileNotFoundException e){
//			System.out.println("not found");
//		}
//		catch (IOException e) {
//			System.out.println("IO exception");
//		}
//	}
//
//}
