import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Character.*;

public class guesstest {

	public static void main(String[] args) {
		MyFrame f = new MyFrame("글자 맞추기");
	}
}

class HangManPanel extends JPanel {
	int CurrentCount;
	HangManPanel(){
		
		setPreferredSize(new Dimension(100,100));
		CurrentCount = 6;
		setBorder(BorderFactory.createLineBorder(Color.red));
		setForeground(Color.black);
	}
	public boolean DrawNext() {
		CurrentCount--;
		repaint();
		if (CurrentCount > 6)
			return true;
		return false;
	}
	public void paintComponent(Graphics g) {
		DrawHangman(g);
	}
	private void DrawHangman(Graphics g) {
		MakeGallow(g);
		MakeHead(g);
		MakeBody(g);
		MakeLeftArm(g);
		MakeRightArm(g);
		MakeLeftLeg(g);
		MakeRightLeg(g);
	}
	private void MakeGallow(Graphics g) {
		g.drawLine(50, 40, 50, 10);
		g.drawLine(50, 10, 95, 10);
		g.drawLine(95, 10, 95, 140);
		g.drawLine(80, 140, 110, 140);
	}
	private void MakeHead(Graphics g) {
		if (CurrentCount<6)
			g.drawOval(40, 40, 20, 20);
	}
	private void MakeBody(Graphics g) {
		if (CurrentCount<5)
			g.drawLine(50, 60, 50, 90);
	}
	private void MakeLeftArm(Graphics g) {
		if (CurrentCount<4)
			g.drawLine(50,75, 70, 60);
	}
	private void MakeRightArm(Graphics g) {
		if (CurrentCount<3)
			g.drawLine(50, 75, 30, 65);
	}

	private void MakeLeftLeg(Graphics g) {
		if (CurrentCount<2)
			g.drawLine(50, 90, 70, 115);
	}

	private void MakeRightLeg(Graphics g) {
		if (CurrentCount<1)
			g.drawLine(50, 90, 30, 115);
	}
	


}
class GuessPanel extends JPanel implements ActionListener{
	JTextField tf;
	String Word,Current_Word;
	JLabel goal, p3_CurrentTimes, Misses_Label,WordPanelCharCountLabel;
	HangManPanel hm;
	int CurrentCount_Progress;

	GuessPanel(HangManPanel hm) {
		SetWord();
		this.hm=hm;
		//setPreferredSize(new Dimension(300,100));
		makeUI();
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	private void SetWord() {
		worder w = new worder();
		Word = w.getWord();
		System.out.println(Word);
		Current_Word = new String();
		for(int List_i=0;List_i<Word.length();++List_i) //글자수만큼 빈칸추가
			Current_Word+="_";
		}
	private void makeUI() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		// word 부분
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		goal = new JLabel(Current_Word);
		goal.setHorizontalAlignment(JLabel.CENTER); // 라벨속 가운데정렬
		goal.setBorder(BorderFactory.createLoweredBevelBorder());
		goal.setPreferredSize(new Dimension(100,20));//라벨 외곽선 사이즈조절
		p1.add(new JLabel("Word: "));
		p1.add(goal);
		p1.add(WordPanelCharCountLabel = new JLabel("   char "+Current_Word.length()));
		

		// Guess 부분
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		tf = new JTextField(1);
		tf.addActionListener(this);
		p2.add(new JLabel("Guess :"));
		p2.add(tf);
		
		// Misses 부분
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		p4.add(new JLabel("Misses :"));
		p4.add(Misses_Label = new JLabel());
		
		
		// CountDown 부분
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel p3_l1;
		CurrentCount_Progress = 6;

		p3.add(p3_l1 = new JLabel("CountDown :"));
		p3.add(p3_CurrentTimes = new JLabel(Integer.toString(CurrentCount_Progress)));
		
		add(p1);add(p2);add(p3);add(p4);

	}
	private void Reset() {
		SetWord();
		Misses_Label.setText("");
		CurrentCount_Progress=6;
		p3_CurrentTimes.setText(Integer.toString(CurrentCount_Progress));
		goal.setText(Current_Word);
		WordPanelCharCountLabel.setText("   char "+Current_Word.length());
		hm.CurrentCount=6;
		hm.repaint();
	}
	public void actionPerformed(ActionEvent e) {
		String TempToButtonString = tf.getText();
		tf.setText("");
		
		if (TempToButtonString.isEmpty() || TempToButtonString.isBlank()) {
			JOptionPane.showMessageDialog(this, "잘못 입력하셨습니다.", "Alert", JOptionPane.OK_OPTION);
		} else {
			if (CompareWord(TempToButtonString))
				System.out.println("맞았습니다!");
			else {
				System.out.println("틀렸습니다!");
				Misses_Label.setText((TempToButtonString.charAt(0)+
						" "+(Misses_Label.getText())));// Misses Label 변경 구문
				hm.DrawNext();
			}
			if (isAllMatched()) {
				JOptionPane.showMessageDialog(this, "모두 맞았습니다.", "Congrats", JOptionPane.OK_OPTION);
				Reset();
			}
			
			if (isLimitReached()) {
				JOptionPane.showMessageDialog(this, "남은기회가 없습니다.\n답 : "+Word+"\n다시 게임을 시작합니다.", "Alert", JOptionPane.OK_OPTION);
				Reset();
			}
		}

	}

	private boolean CompareWord(String input) {
		boolean Answer_Check= false;

		for (int List_i = 0; List_i < Word.length(); ++List_i) {
			char des = input.charAt(0);
			des = java.lang.Character.toLowerCase(des);
			if (des == Word.charAt(List_i)) {
			
				Current_Word = Current_Word.substring(0, List_i)+des+ Current_Word.substring(List_i+1);
				Answer_Check = true;
			}
		}
		
		
		if (Answer_Check) {
			goal.setText(Current_Word);
			p3_CurrentTimes.setText(Integer.toString(CurrentCount_Progress));
			return true;
		}
		--CurrentCount_Progress; // 맞으면 감소하지 않고 틀리면 카운트 갯수 감소
		p3_CurrentTimes.setText(Integer.toString(CurrentCount_Progress));
		return false;

	}

	private boolean isAllMatched() {
			if (Word.equals(Current_Word)) 
				return true;
		return false;
	}

	private boolean isLimitReached() {
		if (CurrentCount_Progress != 0)
			return false;
		return true;
	}
}
class MyFrame extends JFrame implements ActionListener {
	JTextField tf;
	String Word;
	JLabel goal, p3_CurrentTimes;
	int CurrentCount_Progress;

	MyFrame(String s) {
		super(s);
		setSize(400, 190);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		makeUI();
		gbc.weightx = 0.1;
		gbc.weighty = 0;
		HangManPanel hp = new HangManPanel();
		hp.setPreferredSize(new Dimension(100,150));
		add(hp,gbc);
		
		GuessPanel gp = new GuessPanel(hp);
		gp.setPreferredSize(new Dimension(200,150));
		gbc.weightx = 0.3 ; 
		gbc.weighty = 0;
		add(gp,gbc);
	}

	private void makeUI() {
//		// Menu 부분
//		JMenuBar mb = new JMenuBar();
//		JMenu file;
//		JMenuItem quit;
//		setJMenuBar(mb);
//		mb.add(file = new JMenu("File"));
//		mb.add(new JMenu("New"));
//		mb.add(new JMenu("Help"));
//
//		file.add(new JMenuItem("Open"));
//		file.add(new JMenuItem("Save"));
//		file.addSeparator();
//		file.add(quit = new JMenuItem("Quit"));
//		quit.addActionListener(this);
	}
		public void actionPerformed(ActionEvent e) {
			if ((JOptionPane.showConfirmDialog(this, "종료 하시겠습니까?", "Question",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) == JOptionPane.OK_OPTION)
				System.exit(0);
		}
}