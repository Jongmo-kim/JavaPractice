import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Menu {

	public static void main(String[] args) {
		new MyFrame();

	}

}
//팝업 메뉴
class MyFrame extends JFrame implements MouseListener{
MyFrame() { 
	setSize(300,200);
	setLocationRelativeTo(null);
	setTitle("My Frame");
	addMouseListener(this);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	makePopupMenu();
}
private JPopupMenu pm;
private void makePopupMenu() {
	
	pm = new JPopupMenu();
	pm.addMouseListener(this);
	pm.add(new JMenuItem("One"));
	pm.add(new JMenuItem("Two"));
	pm.add(new JMenuItem("Three"));
	pm.add(new JMenuItem("Four"));
	pm.add(new JMenuItem("Five"));
}
public void mousePressed(MouseEvent e) {
	
}
public void mouseReleased(MouseEvent e) {
	if ( e.isPopupTrigger()){
		pm.show(this, e.getX(), e.getY());
	}
}
public void mouseClicked(MouseEvent e) {
	
}
public void mouseEntered(MouseEvent e) {
	
}
public void mouseExited(MouseEvent e) {
	
}
}
///직렬메뉴 ( 메뉴 후 메뉴 )
//class MyFrame extends JFrame{
//MyFrame() { 
//	setSize(300,200);
//	setLocationRelativeTo(null);
//	setTitle("My Frame");
//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	setVisible(true);
//	makeMenu();
//}
//JCheckBoxMenuItem red, green, blue;
//private void makeMenu() {
//	//menu bar
//	JMenuBar mb = new JMenuBar();
//	setJMenuBar(mb);
//	
//	// menus
//	JMenu file;
//	mb.add(file =new JMenu("Color"));
//	mb.add(new JMenu("Edit"));
//	mb.add(new JMenu("Help"));
//	
//	JMenu color;
//	file.add(color = new JMenu("Color"));
//	file.add(new JMenuItem("Quit"));
//	color.add(new JMenuItem("RED"));
//	color.add(new JMenuItem("Blue"));
//	color.add(new JMenuItem("Green"));
//}
//}
//class MyFrame extends JFrame implements ActionListener{
//	MyFrame() { 
//		setSize(300,200);
//		setLocationRelativeTo(null);
//		setTitle("My Frame");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
//		makeMenu();
//	}
//	JCheckBoxMenuItem red, green, blue;
//	private void makeMenu() {
//		//menu bar
//		JMenuBar mb = new JMenuBar();
//		setJMenuBar(mb);
//		
//		// menus
//		JMenu color;
//		mb.add(color =new JMenu("Color"));
//		mb.add(new JMenu("Edit"));
//		mb.add(new JMenu("Help"));
//		
//		// menu items
//		color.add(red = new JCheckBoxMenuItem("Red"));
//		color.add(green = new JCheckBoxMenuItem("Blue"));
//		color.add(blue = new JCheckBoxMenuItem("Green"));
//		red.addActionListener(this);
//		green.addActionListener(this);
//		blue.addActionListener(this);
//		
//		
//	}
//	//implements actionListener 일때
//	public void actionPerformed (ActionEvent e) {
//		String s = "";
//		if(red.isSelected())
//			s+=red.getText();
//		if(blue.isSelected())
//			s+=blue.getText();
//		if(green.isSelected())
//			s+=green.getText();
//		setTitle(s);
//	}
//}
////JMenuitems 테스트
//class MyFrame extends JFrame implements ActionListener{
//	MyFrame() { 
//		setSize(300,200);
//		setLocationRelativeTo(null);
//		setTitle("My Frame");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
//		makeMenu();
//	}
//	private void makeMenu() {
//		JMenuBar mb = new JMenuBar();
//		setJMenuBar(mb);
//		
//		JMenu file;
//		mb.add(file =new JMenu("File"));
//		mb.add(new JMenu("Edit"));
//		mb.add(new JMenu("Help"));
//		
//		JMenuItem mNew,mOpen,mClose,mQuit;
//		file.add(mNew = new JMenuItem("New"));
//		file.add(mOpen = new JMenuItem("Open"));
//		file.add(mClose = new JMenuItem("Close"));
//		file.addSeparator();
//		file.add(mQuit = new JMenuItem("Exit"));
//		mNew.addActionListener(this);
//		mQuit.addActionListener(this);
//		mClose.addActionListener(this);
//		mOpen.addActionListener(this);
//	}	
//	public void actionPerformed (ActionEvent e) {
//		JMenuItem item = (JMenuItem)e.getSource();
//		setTitle(item.getText());
//	}
//}