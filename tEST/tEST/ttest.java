package tEST;
/*
 * JLabel에 대한 기본적인 사용방법을 배우고 문자열안에 HTML 코드를 넣어서 활용할수도 있다.
 */

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
class ttest{
	public static void main(String[] args){
		Myclass f = new Myclass();
		
		Myclass f2 = new Myclass("hello");

		}
}

class Myclass extends JFrame{
	Myclass(String title){
		super(title); //부모클래스 생성자에게 string전달 
		setResizable(false);
		setSize(400,700);
		setVisible(true);
	}
	Myclass(){
		setSize(800,800);
		setTitle("myname");
		setVisible(true);
		//초기화를 위한 배열
		String[] arr = new String[99];
		for(int List_i=0;List_i<99;++List_i)
		{
			arr[List_i]=Integer.toString(List_i+1);
		}
		
		//라벨부분
		JLabel lb=new JLabel(
				"<html><font color=red>Hello</font></html>)");
		add(lb,BorderLayout.CENTER);
		lb.setHorizontalAlignment(JLabel.CENTER);
		
		//버튼부분
		JButton b1, b2;
		b1=new JButton("<html><i>Hello</i></html>");
		b2=new JButton("<html><i>World</i></html>");
		add(b1,BorderLayout.WEST);
		add(b2,BorderLayout.EAST);
		
		//체크박스부분
		JCheckBox bc1,bc2,bc3;
		bc1=new JCheckBox("korea");
		bc2=new JCheckBox("japan");
		bc3=new JCheckBox("usa");
		bc1.setSelected(true);
		bc2.setSelected(true);
		bc3.setSelected(false);
		add(bc1,BorderLayout.SOUTH);
		add(bc2,BorderLayout.NORTH);
		add(bc3,BorderLayout.WEST);
		
		//라디오버튼부분
		JRadioButton rb1,rb2;
		ButtonGroup bg=new ButtonGroup();
		rb1=new JRadioButton("Male");
		rb2=new JRadioButton("Female");
		bg.add(rb1);
		bg.add(rb2);
		add(rb1,BorderLayout.CENTER);
		add(rb2,BorderLayout.CENTER);
		
		//콤보박스부분
		JComboBox cb=new JComboBox(arr);
		add(cb,BorderLayout.CENTER);
		cb.setSelectedIndex(7);
		
		//리스트부분
		JList jl=new JList(arr);
		jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//add(jl,BorderLayout.SOUTH);
		
		//스크롤 부분 + 리스트
		JScrollPane p=new JScrollPane(jl);
		add(p,BorderLayout.CENTER);
		
		//텍스트필드
		JTextField tf = new JTextField(30);
		add(tf,BorderLayout.CENTER);
		tf.setText("Hello");
		tf.setEditable(false);
		
		//텍스트 에어리아
		JTextArea ta=new JTextArea(5,20);
		JScrollPane sp1=new JScrollPane(ta);
		sp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(sp1,BorderLayout.CENTER);
		
		
	}
}