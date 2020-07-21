package tEST;
/*
 * JLabel�� ���� �⺻���� ������� ���� ���ڿ��ȿ� HTML �ڵ带 �־ Ȱ���Ҽ��� �ִ�.
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

//		//���̾�α� �κ�
//		JDialog dl=new JDialog(f2,"Select an option",true);
//		dl.setSize(200,100);
//		dl.setLocationRelativeTo(f2);
//		JPanel p = new JPanel();
//		p.add(new JLabel("Do you want to continue?"));
//		p.add(new JButton("Yes"));
//		p.add(new JButton("No"));
//		dl.add(p,BorderLayout.CENTER);
//		dl.setVisible(true);

		// ���־��̴� ���̾�α�
//		Object[] options = {"Ok","Cancel"};
//		JOptionPane.showOptionDialog(f2,"Message","Title", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

	}
}

class Myclass extends JFrame {
	Myclass(String title) {
		super(title); // �θ�Ŭ���� �����ڿ��� string����
		setResizable(true);
		setSize(300, 320);
		setLocationRelativeTo(null); // null :����� �߾����� ���� ��ü:��ü �߾����� ����
		setVisible(true);
		// makeUI();
		// makeUI2();
		// makeUI3(); //button test Border ������ �⺻���� ���
		// makeUI4(); //panel test Flow ������ �⺻���λ��
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

		putButton(p, c, 0, 0, 1, 1, "A");// 2�� �Ű������� GridBagConstraints�� �־�� ����

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

	private void putButton(JPanel p, GridBagConstraints c, int x, int y, int w, int h, String s) {// grid ������ �ʰ��ϱ� ���� �Լ�
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
		// �ʱ�ȭ�� ���� �迭
		String[] arr = new String[99];
		for (int List_i = 0; List_i < 99; ++List_i) {
			arr[List_i] = Integer.toString(List_i + 1);
		}

		// �󺧺κ�
		JLabel lb = new JLabel("<html><font color=red>Hello</font></html>)");
		add(lb, BorderLayout.CENTER);
		lb.setHorizontalAlignment(JLabel.CENTER);

		// ��ư�κ�
		JButton b1, b2;
		b1 = new JButton("<html><i>Hello</i></html>");
		b2 = new JButton("<html><i>World</i></html>");
		add(b1, BorderLayout.WEST);
		add(b2, BorderLayout.EAST);

		// üũ�ڽ��κ�
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

		// ������ư�κ�
		JRadioButton rb1, rb2;
		ButtonGroup bg = new ButtonGroup();
		rb1 = new JRadioButton("Male");
		rb2 = new JRadioButton("Female");
		bg.add(rb1);
		bg.add(rb2);
		add(rb1, BorderLayout.CENTER);
		add(rb2, BorderLayout.CENTER);

		// �޺��ڽ��κ�
		JComboBox cb = new JComboBox(arr);
		add(cb, BorderLayout.CENTER);
		cb.setSelectedIndex(7);

		// ����Ʈ�κ�
		JList jl = new JList(arr);
		jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// add(jl,BorderLayout.SOUTH);

		// ��ũ�� �κ� + ����Ʈ
		JScrollPane p = new JScrollPane(jl);
		add(p, BorderLayout.CENTER);

		// �ؽ�Ʈ�ʵ�
		JTextField tf = new JTextField(30);
		add(tf, BorderLayout.CENTER);
		tf.setText("Hello");
		tf.setEditable(false);

		// �ؽ�Ʈ �����
		JTextArea ta = new JTextArea(5, 20);
		JScrollPane sp1 = new JScrollPane(ta);
		sp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(sp1, BorderLayout.CENTER);

	}
}