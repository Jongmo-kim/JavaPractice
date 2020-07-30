import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Character.*;
public class guesstest {

	public static void main(String[] args) {
		MyFrame f = new MyFrame("���� ���߱�");

	}
}

class MyFrame extends JFrame implements ActionListener{
	JTextField tf;
	String Word;
	JLabel goal,p3_CurrentTimes;
	
	int CurrentCount,LimitCount;
	
	MyFrame(String s){
		super(s);
		setSize(400,250);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		makeUI();
	}
	private void makeUI() {
		//word �κ�
		JPanel p1 = new JPanel();
		Word="programming";
		p1.add(new JLabel("Word : "));
		p1.add(goal = new JLabel(Word));
		add(p1,BorderLayout.NORTH);
		
		//Guess �κ�
		JPanel p2 = new JPanel();
		tf = new JTextField(1);
		JButton b = new JButton("Enter");
		b.addActionListener(this);
		p2.add(new JLabel("Guess :"));
		p2.add(tf);
		p2.add(b);
		
		add(p2,BorderLayout.CENTER);
		
		//Progress �κ�
		JPanel p3 = new JPanel();
		JLabel p3_l1,p3_LimitTimes;
		CurrentCount = 0;
		LimitCount = Word.length();
		
		p3.add(p3_l1=new JLabel("Progress :"));
		p3.add(p3_CurrentTimes=new JLabel(Integer.toString(CurrentCount)));
		p3.add(p3_LimitTimes=new JLabel("/" + Integer.toString(LimitCount)));
		add(p3,BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e) {
		String TempToButtonString = tf.getText();
		tf.setText("");
		if(TempToButtonString.isEmpty() || TempToButtonString.isBlank()) {
			JOptionPane.showMessageDialog(this, "�߸� �Է��ϼ̽��ϴ�.","Alert",JOptionPane.OK_OPTION);
		} 
		else {
		if(CompareWord(TempToButtonString))
			System.out.println("�¾ҽ��ϴ�!");
		else
			System.out.println("Ʋ�Ƚ��ϴ�!");
		if(isAllMatched())
				JOptionPane.showMessageDialog(this, "��� �¾ҽ��ϴ�.", "Congrats", JOptionPane.OK_OPTION);
		if(isLimitReached()){
			JOptionPane.showMessageDialog(this, "������ȸ�� �����ϴ�.\n���α׷��� �����մϴ�.", "Alert", JOptionPane.OK_OPTION);
			System.exit(0);
		}
		}
		
	}
	private boolean CompareWord(String input) {
		int count=0;

		for (int List_i = 0; List_i < Word.length(); ++List_i) {
			char des = input.charAt(0);
			des=java.lang.Character.toLowerCase(des);
			if (des ==Word.charAt(List_i)) {
				Word = Word.replace(des, '*');
				++count;
			}
		}
		++CurrentCount;
		p3_CurrentTimes.setText(Integer.toString(CurrentCount));
			if (count>0){
				goal.setText(Word);;
				return true;
			}
			return false;

		}
	private boolean isAllMatched() {
		for(int List_i=0;List_i<Word.length();++List_i) {
			if(Word.charAt(List_i)!='*') {
				return false;
			}
			
		}
		return true;
	}
	private boolean isLimitReached() { 
		if(CurrentCount<LimitCount)
			return false;
		return true;
	}
	
}