import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class test {

	public static void main(String[] args) {
		MyFrame f=new MyFrame("Test");
	}

}
////콤보박스 부분
//class MyFrame extends JFrame implements ActionListener{
//	private JComboBox jc;
//	MyFrame(String s){
//		super(s);
//		setSize(300,300);
//		setLocationRelativeTo(null);
//		setVisible(true);
//		makeUI();
//	}
//	private void makeUI() {
//		JPanel p1 = new JPanel();
//		String[] arr = {"RED", "BLUE", "GREEN"};
//		p1.add(jc = new JComboBox(arr));
//		add(p1,BorderLayout.WEST);
//		JPanel p2 = new JPanel();
//		JButton b = new JButton("OK");
//		p2.add(b);
//		b.addActionListener(this);
//		add(p2,BorderLayout.SOUTH);
//		
//	}
//	public void actionPerformed(ActionEvent e) {
//		String s = (String)jc.getSelectedItem();
//		setTitle(s);
//	}
//}
////checkbox 부분
//class MyFrame extends JFrame implements ActionListener{
//	MyFrame(String s){
//		super(s);
//		setSize(300,200);
//		setLocationRelativeTo(null);
//		setVisible(true);
//		makeUI();
//	}
//	private JCheckBox cb1;
//	private JCheckBox cb2;
//	private JCheckBox cb3;
//	private void makeUI() {
//		JPanel p1= new JPanel();
//		p1.setLayout(new GridLayout(1,3,40,0));
//		
//		p1.add(cb1 = new JCheckBox("RED"));
//		p1.add(cb2 = new JCheckBox("BLUE"));
//		p1.add(cb3 = new JCheckBox("GREEN"));
//		add(p1,BorderLayout.NORTH);
//		
//		JPanel p2 = new JPanel();
//		JButton b = new JButton("OK");
//		b.addActionListener(this);
//		p2.add(b);
//		add(p2,BorderLayout.SOUTH);
//	}
//	public void actionPerformed(ActionEvent e) {
//		String s = "";
//		if(cb1.isSelected())
//			s += cb1.getText();
//		if(cb2.isSelected())
//			s += cb2.getText();
//		if(cb3.isSelected())
//			s += cb3.getText();
//		setTitle(s);
//	}
//}
//
////textarea 부분
//class MyFrame extends JFrame implements ActionListener{
//	private JTextArea jt;
//	MyFrame(String s){
//		super(s);
//		setSize(300,200);
//		setLocationRelativeTo(null);
//		setVisible(true);
//		makeUI();
//	}
//	
//	private void makeUI() {
//		//텍스트 에이리어 부분
//		JPanel p1 = new JPanel();
//		p1.add(jt = new JTextArea(5,10));
//		add(p1,BorderLayout.WEST); 
//		
//		//버튼부분
//		JPanel p2 = new JPanel();
//		JButton b = new JButton("OK");
//		b.addActionListener(this);
//		p2.add(b);
//		add(p2,BorderLayout.SOUTH);
//	}
//	public void actionPerformed(ActionEvent e) {
//		String s = jt.getText();
//		
//		jt.setText(s.toUpperCase());
//	}
//}

////Listener 내부 선언 방법
//class MyPanel extends JPanel implements ActionListener{
//	MyPanel(){
//		
//	action event 부분
//		JButton b1=new JButton("RED");
//		JButton b2=new JButton("BLUE");
//		b1.addActionListener(new MyEvent(this,Color.red));
//		b2.addActionListener(new MyEvent(this,Color.blue));
//		add(b1);
//		add(b2);
//		
//		//text filed 부분
//		JTextField tf = new JTextField(10);
//		tf.addActionListener(this);
//		add(tf);
//		
//	}
//	public void actionPerformed(ActionEvent e) {
//		JTextField tf_=(JTextField)e.getSource();
//		String s = tf_.getText();
//		if(s.equals("red"))
//			setBackground(Color.RED);
//		else if(s.equals("blue"))
//			setBackground(Color.blue);
//		
//
//	}
//}
////Text Field action 외부 선언 방법
//class MyEvent implements ActionListener{
//	private MyPanel p;
//	MyEvent(MyPanel p_){
//		p=p_;
//	}
//	public void actionPerformed(ActionEvent e) {
//		JTextField tf_=(JTextField)e.getSource();
//		String s = tf_.getText();
//		if(s.equals("red"))
//			p.setBackground(Color.RED);
//		else if(s.equals("blue"))
//			p.setBackground(Color.blue);
//		
//
//	}
//}


////Text Field action 익명 선언 방법
//class MyPanel extends JPanel{
//	private MyPanel p;
//	MyPanel(){
//		JTextField tf=new JTextField(10);
//		String s = tf.getText();
//		add(tf);
//		
//		//리스너 구문
//		tf.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JTextField tf_=(JTextField)e.getSource();
//				String s = tf_.getText();
//				
//				if(s.equals("red"))
//					setBackground(Color.RED);
//				else if(s.equals("blue"))
//					setBackground(Color.blue);
//			}
//
//		});
//	}
//}
//Button action
//class MyEvent implements ActionListener{
//	private MyPanel p;
//	private Color co;
//	MyEvent(MyPanel e,Color c){
//		p=e;
//		co=c;
//	}
//	
//	public void actionPerformed(ActionEvent a) {
//		//방법1
//		JButton b = (JButton)a.getSource();
//		String s = b.getText();
//		if(s=="RED") //문자열 비교에는 s.equal() 메소드를 사용해서 비교, ==operator는 object같은지 여부를 알려주는거같다.
//			p.setBackground(Color.red);
//		else if(s=="BLUE")
//			p.setBackground(Color.blue);
//		//방법2
//		//	p.setBackground(co);
//	}
//}
