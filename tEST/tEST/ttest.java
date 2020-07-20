package tEST;
/*
 * JLabel에 대한 기본적인 사용방법을 배우고 문자열안에 HTML 코드를 넣어서 활용할수도 있다.
 */

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
class ttest{
	public static void main(String[] args){
		Myclass f = new Myclass();
		
		}
}

class Myclass extends JFrame{
	Myclass(){
		setSize(300,200);
		setTitle("myname");
		setVisible(true);
		JLabel lb=new JLabel(
				"<html><font color=red>Hello</font></html>)");
		add(lb,BorderLayout.CENTER);
		lb.setHorizontalAlignment(JLabel.CENTER);
		
	}
}