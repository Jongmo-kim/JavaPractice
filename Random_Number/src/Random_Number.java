import java.util.Random;

class RandomList{
	private int[] list;
	private Random rand;
	RandomList(int n){
		 rand = new Random();
		list =  new int[n];
		
	}
	int[] getList() { 
		int len = list.length;
		for(int List_i=0;List_i<len;++List_i) {
			int n;
			while (found(n=rand.nextInt(len), List_i)) {};
			list[List_i]=n;
			
		}
		return list;
	}
	private boolean found(int n,int lenght) {
		for(int List_i=0;List_i<lenght;++List_i)
			if(list[List_i] ==n)
				return true;
		return false;
	}
}

public class Random_Number {

	public static void main(String[] args) {
		RandomList rand =  new RandomList(10);
		int[] list_=rand.getList();
		for(int List_i=0; List_i<10;++List_i)
			System.out.println(list_[List_i]);
	}

}
