package tEST;
/*
 * JLabel�� ���� �⺻���� ������� ���� ���ڿ��ȿ� HTML �ڵ带 �־ Ȱ���Ҽ��� �ִ�.
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
class ttest{
	public static void main(String[] args){
		Myclass f = new Myclass();
		Myclass f2= new Myclass();
		Point p=f.getLocation();
		
		
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