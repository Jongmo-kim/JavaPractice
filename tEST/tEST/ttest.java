package tEST;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
class ttest{
	public static void main(String[] args){
		Myclass f = new Myclass();
		Myclass f2= new Myclass();
		Point p=f.getLocation();
		
		}
}

class Myclass extends JFrame{
	Myclass(){
		Dimension d = new Dimension(600,400);
		setTitle("d");
		setSize(d);
		setVisible(true);
		setLocation(200, 300);
	}
}