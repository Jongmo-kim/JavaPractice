import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;



class worder {
	private Random rand;
	private String[] words;
	private int Inn;
	static final int MAX = 2999;

	worder() { 
		try {
			///////////////////////////////
			rand = new Random();
			words = new String[MAX];
			Scanner sc = new Scanner(new BufferedReader(
					new FileReader("data.txt")));
			for (int List_i=0; List_i<MAX;++List_i) {
				if (sc.hasNext() == false)
					break;
				words[List_i]=sc.next();
			}
		
			Inn = 1;
		}
		///////////////////////////
		catch (IOException e) {
			System.out.println("cant open file");
			System.exit(0);
		}
	}
	String getWord() {
		return words[rand.nextInt(MAX)];
	}
}