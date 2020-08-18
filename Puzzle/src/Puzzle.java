import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Puzzle {
	boolean count;
	public static void main(String[] args) {
		new MyFrame("test");
	}
}

class MyFrame extends JFrame{
	private CountPanel cp;
	private MainPanel mp;
	MyFrame(String s){
		super(s);
		setDefaultOptions();
		add(mp = new MainPanel(),BorderLayout.CENTER);
		add(cp = new CountPanel(mp),BorderLayout.NORTH);
	}
	private void setDefaultOptions() {
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class CountPanel extends JPanel implements Runnable {
	private JLabel lb;
	private MainPanel mp;
	private float ElapsedTimer;
	private boolean CheckComplete;
	CountPanel(MainPanel mp) {
		setFont(new Font("«—ƒƒπŸ≈¡", Font.BOLD, 20));
		setElapsedTimePanel();
		ElapsedTimer = 0;
		CheckComplete = false;
		this.mp=mp;
		Thread th = new Thread(this);
		th.start();
	}
	void setElapsedTimePanel() {
		add(new JLabel("Elapsed Time :"));
		add(lb = new JLabel(String.valueOf(ElapsedTimer)));
		add(new JLabel("√ "));
	}
	void update() {
		ElapsedTimer += 0.1;
		lb.setText(String.format("%.1f",ElapsedTimer));
			
	}

	public void run() {
		while (true) {
			try {
				update();
				Thread.sleep(100);
				if(mp.CheckComplete) {
					JOptionPane.showConfirmDialog(this, "Congrats " + "You Just made it in " + String.format("%.1f",ElapsedTimer) + "sec", "You made it", JOptionPane.PLAIN_MESSAGE);
					JOptionPane.showConfirmDialog(this, "Program exit", "alert", JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
					Thread.sleep(12000000);
					
				}
			} catch (InterruptedException e) {}}}
}
class MainPanel extends JPanel implements ActionListener{
	private	MyButton[] btns;
	private String[] str;
	private int[] arr;
	public boolean CheckComplete;
	MainPanel(){
		setLayout(new GridLayout(4, 4));
		btns = new MyButton[16];
		arr = (new RandomList(15).getList());
		
		CheckComplete = false;
		for(int List_i=0;List_i<15;++List_i) {
			add(btns[List_i]=new MyButton(Integer.toString(List_i),List_i));
			btns[List_i].setFont(new Font("«—ƒƒπŸ≈¡",Font.BOLD,20));
			btns[List_i].addActionListener(this);
			btns[List_i].setText(Integer.toString(arr[List_i]));//Randomize
		}
		add(btns[15]= new MyButton("15",15));
		btns[15].addActionListener(this);
		btns[15].setFont(new Font("«—ƒƒπŸ≈¡",Font.BOLD,20));
		btns[15].setEnabled(false);
		btns[15].setVisible(false);
	}
	public boolean isCheckComplete() {
		return CheckComplete;
	}
	private void ButtonEnableSwitch(MyButton b1,MyButton b2) {
		String s;
		
		if(b1.isEnabled()) {
			s=b1.getText();
			b2.setText(s);
			b1.setEnabled(false);
			b1.setVisible(false);
			b2.setEnabled(true);
			b2.setVisible(true);
		} else {
			s=b2.getText();
			b1.setText(s);
			b1.setEnabled(true);
			b1.setVisible(true);
			b2.setEnabled(false);
			b2.setVisible(false);
		}
	}
	
	public MyButton FindDisabledButton(MyButton src,MyButton[] arr) {
		int temp;
		
		//up
		if(src.GetLocation()>=4) {
			temp=src.GetLocation()-4;
			if(!arr[temp].isEnabled()) 
				return arr[temp];
		}
		
		//down
		if(src.GetLocation()<12) {
			temp=src.GetLocation()+4;
			if(!arr[temp].isEnabled())
				return arr[temp];
		}
		
		//left 0, 4 , 8 , 12 
		if((src.GetLocation()%4)!=0) {
			temp=src.GetLocation()-1;
			if(!arr[temp].isEnabled())
				return arr[temp];
		}
		
		//right 3,7,11,15
		if((src.GetLocation()%4)!=3) {
			temp=src.GetLocation()+1;
			if(!arr[temp].isEnabled())
				return arr[temp];
		}
		
		return src;
	}
	private boolean CheckCheckComplete() {
		for(int List_i=0;List_i<15;++List_i) {
			if(Integer.parseInt(btns[List_i].getText())==(List_i))
				continue;
			else
				return false;
		}
		return true;
	}
	public void actionPerformed(ActionEvent e) {
		MyButton act,deact,temp;
		temp = FindDisabledButton((MyButton)e.getSource(),btns);
		if(temp.GetLocation() != ((MyButton)e.getSource()).GetLocation()) {
			act = (MyButton)e.getSource();
			deact = temp;
			ButtonEnableSwitch(act,deact);
		}
		if(CheckCheckComplete()) {
			CheckComplete=true;
		}
			
	}
}
class MyButton extends JButton {
	private int Location;
	MyButton(String s,int Lo){
		super(s);
		Location = Lo;
	}
	public int GetLocation() {
		return Location;
	}
	public void SetLocation(int Lo) { 
		Location = Lo;
	}
}