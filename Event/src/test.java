import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class test {

	public static void main(String[] args) {
		MyFrame f=new MyFrame("Test");
	}

}
//------------------------MOUSE EVENT 이것외에 MouseMotionListener도 있음
class MyFrame extends JFrame{
	
	MyFrame(String s){
		super(s);
		setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		add(new MyPanel(),BorderLayout.CENTER);
		
	}
}
class MyPanel extends JPanel {
	private int x, y;

	MyPanel(){
		x=y=-1;
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				repaint();
				System.out.println("mouseClicked");
			}}
		);
		
	}

	public void paintComponent(Graphics g) {

		if(x >= 0 && y>= 0)
			g.fillOval(x-10, y-10, 20, 20);
	}
}
////MouseListener
//class MyFrame extends JFrame{
//
//MyFrame(String s){
//	super(s);
//	setSize(300,200);
//	setLocationRelativeTo(null);
//	setDefaultCloseOperation(EXIT_ON_CLOSE);
//	
//	setVisible(true);
//	add(new MyPanel(),BorderLayout.CENTER);
//	
//}
//}
//class MyPanel extends JPanel implements MouseListener{
//	private int x, y;
//
//	MyPanel(){
//		addMouseListener(this);
//		x=y=-1;
//	}
//
//	public void paintComponent(Graphics g) {
//		if(x >= 0 && y>= 0)
//			g.fillOval(x-10, y-10, 20, 20);
//	}
//
//	public void mousePressed(MouseEvent e) {
//		System.out.println("mousePressed");
//	}
//
//	public void mouseReleased(MouseEvent e) {
//		System.out.println("mouseReleased");
//
//	}
//
//	public void mouseClicked(MouseEvent e) {
//		x = e.getX();
//		y = e.getY();
//		repaint();
//		System.out.println("mouseClicked");
//	}
//
//	public void mouseEntered(MouseEvent e) {
//		System.out.println("mouseEntered");
//		setBackground(Color.green);
//	}
//
//	public void mouseExited(MouseEvent e) {
//		System.out.println("mouseExited");
//		setBackground(Color.white);
//	}
//
//}
//-------------------------------Window Event
////어댑터 클래스 java는 다중상속을 지원하지 않으므로 외부클래스 또는 내부에 어댑터 클래스 지정
////익명의 내부 클래스
//class MyFrame extends JFrame {
//
//	MyFrame(String s) {
//		super(s);
//		setSize(300, 200);
//		setLocationRelativeTo(null);
//		//WindowAdapter or WindowListener 둘중하나로 선언하여 사용
//		//WindowListener는 다 구현 해야하고 Adapter는 부분만 오버라이드가능.
//		addWindowListener(new WindowAdapter() {
//
//			@Override
//			public void windowOpened(WindowEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void windowIconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void windowClosing(WindowEvent e) {
//				if (JOptionPane.showConfirmDialog(getContentPane(), "Really Quit?", "Confirm",
//						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
//					System.exit(0);
//			}
//
//			@Override
//			public void windowClosed(WindowEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			public void windowActivated(WindowEvent e) {
//
//			}
//		});
//		setVisible(true);
//	}
//}
//
//class MyFrame extends JFrame{
//	
//	MyFrame(String s){
//		super(s);
//		setSize(300,200);
//		setLocationRelativeTo(null);
//		addWindowListener(new MyListener());
//		setVisible(true);
//		
//	}
//	
//	// 내부 클래스 방법
//	class MyListener extends WindowAdapter {
//		public void windowClosing(WindowEvent e) {
//			// showConfirmDialog의 첫번쨰 객채로 this 는 MyListener을 가르키키때문에
//			// JFrame.getcontentPane() 메소드로 가져온다 혹은 MyFrame을 전역변수로 선언해서 사용
//			if (JOptionPane.showConfirmDialog(getContentPane(), "Really Quit?", "Confirm",
//					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
//				System.exit(0);
//
//		}
//	}
//}
////외부 클래스 방법
//class MyListener extends WindowAdapter{
//	private MyFrame f;
//	MyListener(MyFrame f_){
//		f=f_;
//	}
//	public void windowClosing(WindowEvent e) {
//		
//		if(JOptionPane.showConfirmDialog(f, "Really Quit?",
//				"Confirm", JOptionPane.YES_NO_OPTION
//				)==JOptionPane.YES_OPTION) {
//			System.exit(0);}
//	}
//}
////윈도우 이벤트 기초 및 종료방법
//class MyFrame extends JFrame implements WindowListener{
//	
//	MyFrame(String s){
//		super(s);
//		setSize(300,200);
//		addWindowListener(this);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //JFRAME상속햇으므로 해당 enum 온점없이 가져올수잇음
//		//setDefaultCloseOperation(EXIT_ON_CLOSE);//바로 종료하는 방법 2 
//		/*
//		 * EXIT_ON_CLOSE - 바로 종료
//		 * DO_NOTHING_ON_CLOSE - 닫을때 아무것도 하지 않기
//		 * HIDE_ON_CLOSE(DEFAULT) - 기본값
//		 * DISPOSE_ON_CLOSE - 창이 가진 리소스를 제거한다
//		 */
//		setVisible(true);
//		makeUI();
//	}
//	private void makeUI() {
//		
//	}
//	public void windowActivated(WindowEvent e) {
//		System.out.println("Activated");
//	}
//	public void windowDeactivated(WindowEvent e) {
//		System.out.println("Deactiveated");
//	}
//	public void windowIconified(WindowEvent e) {
//		System.out.println("Iconified");
//	}
//
//	public void windowDeiconified(WindowEvent e) {
//		System.out.println("Deiconified");
//	}
//
//	public void windowOpened(WindowEvent e) {
//		System.out.println("Opened");
//	}
//
//	public void windowDeopend(WindowEvent e) {
//		System.out.println("Deopened");
//	}
//
//	public void windowClosed(WindowEvent e) {
//		System.out.println("Closed");
//	}
//	public void windowClosing(WindowEvent e) {
//		if(JOptionPane.showConfirmDialog(this, "Really Quit?"
//				,"Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
//			System.exit(0); //종료방법3	
//		//System.exit(0);//종료방법1 묻지않고 종료
//	}//프로그램 종료
//}
//----------------------ITEM EVENT
////JCheckBox + JButton 
//class MyFrame extends JFrame implements ItemListener,ActionListener{
//	private JCheckBox jc;
//	MyFrame(String s){
//		super(s);
//		setSize(300,200);
//		setLocationRelativeTo(null);
//		setVisible(true);
//		makeUI();
//	}
//	private void makeUI() {
//		JPanel p1 = new JPanel();
//		p1.add(jc = new JCheckBox("CHECK"));
//		jc.addItemListener(this);
//		add(p1,BorderLayout.WEST);
//		
//		JPanel p2 = new JPanel();
//		JButton b =new JButton("OK");
//		b.addActionListener(this);
//		p2.add(b);
//		add(p2,BorderLayout.SOUTH);
//	}
//	public void itemStateChanged(ItemEvent e) {
//		JCheckBox jc_= (JCheckBox)e.getSource();
//		if(jc_.isSelected())
//			setTitle(jc_.getText());
//		else
//			setTitle("Not "+jc_.getText());
//	}
//	public void actionPerformed(ActionEvent e) {
//		setTitle("OK");
//	}
//}
////JCheckBox 
//class MyFrame extends JFrame implements ItemListener{
//	JCheckBox c1;
//	MyFrame(String s){
//		super(s);
//		setSize(300,200);
//		setLocationRelativeTo(null);
//		setVisible(true);
//		makeUI();
//	}
//	private void makeUI() {
//		JPanel p1 = new JPanel();
//		p1.add(c1 = new JCheckBox("CHECK"));
//		c1.addItemListener(this);
//		add(p1,BorderLayout.WEST);
//	}
//	public void itemStateChanged(ItemEvent e) {
//		JCheckBox t1 =  (JCheckBox)e.getSource();
//		
//		if(t1.isSelected())
//			setTitle(t1.getText());
//		else
//			setTitle("Not " + t1.getText());
//	}
//}
////ComboBox
//class MyFrame extends JFrame implements ItemListener{
//	private JComboBox jc;
//	private String[] s = { "red", "green", "blue" };
//	MyFrame(String s){
//		super(s);
//		setSize(300,300);
//		setLocationRelativeTo(null);
//		setVisible(true);
//		makeUI();
//	}
//	private void makeUI() {
//		JPanel p1 = new JPanel();
//		p1.add(jc=new JComboBox(s));
//		jc.addItemListener(this);
//		add(p1,BorderLayout.WEST);
//		
//		JPanel p2 = new JPanel();
//		p2.add(new JButton("OK"));
//		add(p2,BorderLayout.SOUTH);
//		
//	}
//	public void itemStateChanged(ItemEvent e) {
//		JComboBox jc_ = (JComboBox)e.getSource();
//		int idx = jc_.getSelectedIndex();
//		setTitle(s[idx]);
//	}
//}
////Jradio 버튼 
//class MyFrame extends JFrame implements ItemListener {
//	private JRadioButton b1, b2, b3;
//	
//
//	MyFrame(String s) {
//		super(s);
//		setSize(300, 300);
//		setLocationRelativeTo(null);
//		setVisible(true);
//		makeUI();
//	}
//
//	private void makeUI() {
//		JPanel p1 = new JPanel();
//
//		p1.add(b1 = new JRadioButton("RED"));
//		p1.add(b2 = new JRadioButton("BLUE"));
//		p1.add(b3 = new JRadioButton("GREEN"));
//		b1.addItemListener(this);
//		b2.addItemListener(this);
//		b3.addItemListener(this);
//		ButtonGroup g = new ButtonGroup();
//		g.add(b1);
//		g.add(b2);
//		g.add(b3);
//		add(p1, BorderLayout.NORTH);
//
//		JPanel p2 = new JPanel();
//		JButton b = new JButton("OK");
//		p2.add(b);
//		
//		add(p2, BorderLayout.SOUTH);
//
//	}
//	public void itemStateChanged(ItemEvent e) {
//		JRadioButton b = (JRadioButton)e.getSource();
//		setTitle(b.getText());
//	}
//}

//------------------ACTION EVENTS-----------------
////Jradio 버튼
//class MyFrame extends JFrame implements ActionListener{
//private JRadioButton b1,b2,b3;
//private String[] s =  { "red","green","blue"};
//MyFrame(String s){
//	super(s);
//	setSize(300,300);
//	setLocationRelativeTo(null);
//	setVisible(true);
//	makeUI();
//}
//private void makeUI() {
//	JPanel p1 = new JPanel();
//	p1.setLayout(new GridLayout(1, 3));
//	p1.add(b1=new JRadioButton("RED"));
//	p1.add(b2=new JRadioButton("BLUE"));
//	p1.add(b3=new JRadioButton("GREEN"));
//	ButtonGroup g = new ButtonGroup();
//	g.add(b1);g.add(b2);g.add(b3);
//	add(p1,BorderLayout.NORTH);
//	
//	
//	JPanel p2 = new JPanel();
//	JButton b = new JButton("OK");
//	p2.add(b);
//	b.addActionListener(this);
//	add(p2,BorderLayout.SOUTH);
//	
//}
//public void actionPerformed(ActionEvent e) {
//	if(b1.isSelected()) {
//		setTitle(b1.getText());
//	}
//	else if(b2.isSelected()) {
//		setTitle(b2.getText());
//	}
//	else if(b3.isSelected()) {
//		setTitle(b3.getText());
//	}
//	
//	
//}
//}
////JLIST 버튼
//class MyFrame extends JFrame implements ActionListener{
//private JList list;
//private String[] s =  { "red","green","blue"};
//MyFrame(String s){
//	super(s);
//	setSize(300,300);
//	setLocationRelativeTo(null);
//	setVisible(true);
//	makeUI();
//}
//private void makeUI() {
//	JPanel p1 = new JPanel();
//	String[] arr = {"RED", "BLUE", "GREEN"};
//	p1.add(list = new JList(s));
//	add(p1,BorderLayout.WEST);
//	JPanel p2 = new JPanel();
//	JButton b = new JButton("OK");
//	p2.add(b);
//	b.addActionListener(this);
//	add(p2,BorderLayout.SOUTH);
//	
//}
//public void actionPerformed(ActionEvent e) {
//	int[] idx =  list.getSelectedIndices();
//	String t = "";
//	for ( int List_i=0;List_i<idx.length;++List_i) {
//		t=t+s[idx[List_i]];
//	}
//	setTitle(t);
//}
//}

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
