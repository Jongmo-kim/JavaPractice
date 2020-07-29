import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guesstest {

	public static void main(String[] args) {
		MyFrame f = new MyFrame("글자 맞추기");

	}
}

class MyFrame extends JFrame implements ActionListener{
	JTextField tf;
	String Word;
	JLabel goal;
	MyFrame(String s){
		super(s);
		setSize(400,250);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		makeUI();
	}
	private void makeUI() {
		//word 부분
		JPanel p1 = new JPanel();

		Word="Programming";
		p1.add(new JLabel("Word : "));
		p1.add(goal = new JLabel(Word));
		
		add(p1,BorderLayout.NORTH);
		
		//Guess 부분
		JPanel p2 = new JPanel();
		tf = new JTextField(1);
		JButton b = new JButton("Enter");
		b.addActionListener(this);
		p2.add(new JLabel("Guess :"));
		p2.add(tf);
		p2.add(b);
		
		add(p2,BorderLayout.CENTER);
		
		//Progress 부분
		JPanel p3 = new JPanel();
		JLabel p3_l1,p3_CurrentTimes,p3_RemainTimes;
		p3.add(p3_l1=new JLabel("Progress :"));
		p3.add(p3_CurrentTimes=new JLabel("0"));
		p3.add(p3_RemainTimes=new JLabel("/0"));
		add(p3,BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e) {
		String TempToButtonString = tf.getText();
		tf.setText("");
		if(CompareWord(TempToButtonString))
			System.out.println("맞았습니다!");
		else
			System.out.println("틀렸습니다!");
	}
	private boolean CompareWord(String input) {
		int count=0;
		for (int List_i = 0; List_i < input.length(); ++List_i) {
			if (input.charAt(0)==Word.charAt(List_i)) {
				Word.replace(input.charAt(0), '*');
				System.out.println(Word);
				++count;
			}
		}
			if (count>0){
				goal= new JLabel(Word);
				return true;
			}
			return false;

		}
	
}