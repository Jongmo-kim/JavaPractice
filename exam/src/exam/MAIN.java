package exam;
import java.awt.*;
import javax.swing.*;
public class MAIN {

	public static void main(String[] args) {
		MyFrame f = new MyFrame("Java Exam");
		
	}

}
class MyFrame extends JFrame{
	MyFrame(String t){
		super(t);
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		add(new MyPanel(),BorderLayout.CENTER);
		makeUI();
	}
	private void makeUI() {

	}
}
class MyPanel extends JPanel{

	MyPanel(){
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(new P1());
		add(new P2());
		add(new P3());
		add(new P4());
		
		
	}

}
class P1 extends JPanel{
	P1(){
		JLabel p =new JLabel("Java Programming");
		add(p);
	}
}
class P2 extends JPanel{
	P2(){
		String[] arg= {"RED","BLUE","BLACK","ORANGE","GREEN"};
		JComboBox p=new JComboBox(arg);
		p.setSize(100, 20);
		add(p);
	}
}
class P3 extends JPanel{
	private Image img;
	P3(){
		ImageIcon ic = new ImageIcon("img/pic.jpg");
		img=ic.getImage();

	
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 5, 5, null);
	}
	public Dimension getPreferredSize() {
		return new Dimension(200,200);
	}
}
class P4 extends JPanel{
	P4(){
		setLayout(new GridLayout(2,4));
		setBorder(BorderFactory.createTitledBorder("Items"));
		
		JCheckBox one = new JCheckBox("One");
		JCheckBox two = new JCheckBox("Two");
		one.setSelected(true);
		two.setSelected(true);
		add(one);
		add(two);
		add(new JCheckBox("three"));
		add(new JCheckBox("four"));
		add(new JCheckBox("five"));
		add(new JCheckBox("six"));
		add(new JCheckBox("seven"));
		add(new JCheckBox("eight"));
		
	}
}