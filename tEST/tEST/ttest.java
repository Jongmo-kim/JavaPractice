package tEST;
/*
 * JLabel에 대한 기본적인 사용방법을 배우고 문자열안에 HTML 코드를 넣어서 활용할수도 있다.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

class ttest {
	public static void main(String[] args) {
		Myclass f2 = new Myclass("hello");

//		//다이얼로그 부분
//		JDialog dl=new JDialog(f2,"Select an option",true);
//		dl.setSize(200,100);
//		dl.setLocationRelativeTo(f2);
//		JPanel p = new JPanel();
//		p.add(new JLabel("Do you want to continue?"));
//		p.add(new JButton("Yes"));
//		p.add(new JButton("No"));
//		dl.add(p,BorderLayout.CENTER);
//		dl.setVisible(true);

		// 자주쓰이는 다이얼로그
//		Object[] options = {"Ok","Cancel"};
//		JOptionPane.showOptionDialog(f2,"Message","Title", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

	}
}

class Myclass extends JFrame {
	Myclass(String title) {
		super(title); // 부모클래스 생성자에게 string전달
		setResizable(true);
		setSize(300, 320);
		setLocationRelativeTo(null); // null :모니터 중앙으로 전달 객체:객체 중앙으로 전달
		setVisible(true);
		// makeUI();
		// makeUI2();
		// makeUI3(); //button test Border 정렬이 기본으로 사용
		// makeUI4(); //panel test Flow 정렬이 기본으로사용
		// makeUI5();//Grid Lay out
		//makeUI6();
	}

	private void makeUI6() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

		p.add(new JButton("1"));
		p.add(new JButton("Long Button"));
		p.add(new JButton("Long Long Button"));
		p.add(new JButton("Button 4"));
		p.add(new JButton("5"));
		add(p, BorderLayout.CENTER);
	}

	private void makeUI5() {
		JPanel p = new JPanel();
		p.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = c.weighty = 1.0;

		putButton(p, c, 0, 0, 1, 1, "A");// 2차 매개변수에 GridBagConstraints를 넣어야 적용

		putButton(p, c, 1, 0, 1, 2, "B");
		putButton(p, c, 0, 1, 1, 1, "C");
		putButton(p, c, 0, 2, 2, 1, "D");
		add(p, BorderLayout.CENTER);
	}

	private void makeUI4() {
		JPanel p = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 50);
		p.setLayout(layout);
		p.add(new JButton("A"));
		p.add(new JButton("B"));
		p.add(new JButton("C"));
		p.add(new JButton("C"));
		p.add(new JButton("C"));
		p.add(new JButton("C"));
		p.add(new JButton("C"));
		add(p, BorderLayout.CENTER);
	}

	private void putButton(JPanel p, GridBagConstraints c, int x, int y, int w, int h, String s) {// grid 적용을 십게하기 위한 함수
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = w;
		c.gridheight = h;
		p.add(new JButton(s), c);
	}

	private void makeUI3() {
		setLayout(new BorderLayout(5, 5));
		add(new JButton("EAST"), BorderLayout.EAST);
		add(new JButton("WEST"), BorderLayout.WEST);
		add(new JButton("CENTER"), BorderLayout.CENTER);
		add(new JButton("NORTH"), BorderLayout.NORTH);
		add(new JButton("SOUTH"), BorderLayout.SOUTH);
	}

	private void makeUI2() {
		JPanel p = new JPanel();
		MyPanel mp = new MyPanel("Hi");
		p.add(mp);
		MyPanel mp2 = new MyPanel("Line");
		mp2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "helo"));
		p.add(mp2);

		MyPanel mp3 = new MyPanel("Line");
		mp3.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "title"));
		p.add(mp3);

		MyPanel mp4 = new MyPanel("Line");
		mp4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "helo"));
		p.add(mp4);

		MyPanel mp5 = new MyPanel("Line");
		mp5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), "helo"));
		p.add(mp5);

		MyPanel mp6 = new MyPanel("Line");
		mp6.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "helo"));

		p.add(mp6);

		add(p, BorderLayout.CENTER);

	}

	class MyPanel extends JPanel {
		MyPanel(String s) {
			add(new JLabel(s));
		}

		public Dimension getPreferredSize() {
			return new Dimension(100, 60);
		}
	}

	private void makeUI() {
		// north
		JLabel head = new JLabel("Enter your name");
		head.setHorizontalAlignment(JLabel.CENTER);
		// add(head,BorderLayout.NORTH);

		// center
		JPanel pc = new JPanel();
		JLabel name = new JLabel("Name :");
		JTextField tf = new JTextField();
		tf.setColumns(10);
		pc.add(name);
		pc.add(tf);
		add(pc, BorderLayout.CENTER);

		// south
		JPanel ps = new JPanel();
		JButton b1 = new JButton("Confirm");
		JButton b2 = new JButton("reset");
		ps.add(b1);
		ps.add(b2);
		// add(ps,BorderLayout.SOUTH);
	}

	Myclass() {
		setSize(800, 800);
		setTitle("myname");
		setVisible(true);
		// 초기화를 위한 배열
		String[] arr = new String[99];
		for (int List_i = 0; List_i < 99; ++List_i) {
			arr[List_i] = Integer.toString(List_i + 1);
		}

		// 라벨부분
		JLabel lb = new JLabel("<html><font color=red>Hello</font></html>)");
		add(lb, BorderLayout.CENTER);
		lb.setHorizontalAlignment(JLabel.CENTER);

		// 버튼부분
		JButton b1, b2;
		b1 = new JButton("<html><i>Hello</i></html>");
		b2 = new JButton("<html><i>World</i></html>");
		add(b1, BorderLayout.WEST);
		add(b2, BorderLayout.EAST);

		// 체크박스부분
		JCheckBox bc1, bc2, bc3;
		bc1 = new JCheckBox("korea");
		bc2 = new JCheckBox("japan");
		bc3 = new JCheckBox("usa");
		bc1.setSelected(true);
		bc2.setSelected(true);
		bc3.setSelected(false);
		add(bc1, BorderLayout.SOUTH);
		add(bc2, BorderLayout.NORTH);
		add(bc3, BorderLayout.WEST);

		// 라디오버튼부분
		JRadioButton rb1, rb2;
		ButtonGroup bg = new ButtonGroup();
		rb1 = new JRadioButton("Male");
		rb2 = new JRadioButton("Female");
		bg.add(rb1);
		bg.add(rb2);
		add(rb1, BorderLayout.CENTER);
		add(rb2, BorderLayout.CENTER);

		// 콤보박스부분
		JComboBox cb = new JComboBox(arr);
		add(cb, BorderLayout.CENTER);
		cb.setSelectedIndex(7);

		// 리스트부분
		JList jl = new JList(arr);
		jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// add(jl,BorderLayout.SOUTH);

		// 스크롤 부분 + 리스트
		JScrollPane p = new JScrollPane(jl);
		add(p, BorderLayout.CENTER);

		// 텍스트필드
		JTextField tf = new JTextField(30);
		add(tf, BorderLayout.CENTER);
		tf.setText("Hello");
		tf.setEditable(false);

		// 텍스트 에어리아
		JTextArea ta = new JTextArea(5, 20);
		JScrollPane sp1 = new JScrollPane(ta);
		sp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(sp1, BorderLayout.CENTER);

	}
}