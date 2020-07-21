
import java.awt.*;
import javax.swing.*;

public class graphics {

	public static void main(String[] args) {
		MyFrame f = new MyFrame("Main Frame");

	}

}
class MyFrame extends JFrame {
	MyFrame(String title){
		super(title);
		setSize(1300,1200);
		setLocationRelativeTo(null);
		add(new MyPanel(),BorderLayout.CENTER);
		setVisible(true);
	//	setBackground(Color.black);
	}
}
class MyPanel extends JPanel {
	private Image img;
	private Toolkit tk;
	MyPanel(){
		setBackground(Color.black);
		JButton b1 = new JButton("OK");
		JButton b2 = new JButton("CANCEL");
		b1.setBackground(Color.yellow);
		b1.setForeground(Color.red);
		
		add(b1);
		add(b2);
		
		ImageIcon icon = new ImageIcon("img/pic.jpg");
		img = icon.getImage(); //이미지 가져오는 방법1
//		
		//툴킷쓰는 이미지가져오는 방법 2 
//		tk=Toolkit.getDefaultToolkit();
//		tk.getImage("img/pic.jpg");

	}
	public void paintComponent(Graphics g) {
		g.setFont(new Font("한컴바탕",Font.PLAIN,20));
		g.drawString("Hello World", 1000, 50);
		g.setFont(new Font("Monospaced",Font.BOLD,15));
		g.drawString("Java Programming", 1000, 200);
		g.setFont(new Font("Serif",Font.BOLD | Font.ITALIC,30));
		g.drawString("Java Programming", 1000, 300);
		
		
		g.setColor(new Color(254,254,254));//하얀색
		g.drawRoundRect(50, 50, 100, 100, 5, 5);;
		g.fillRect(50, 50, 100,100);
		g.drawOval(400, 500, 100, 100);
		g.setColor(Color.RED);
		g.fillOval(600, 700, 100, 200);
		g.drawArc(100, 450, 100, 100, 0, 90);
		g.setColor(new Color((float)0.5,(float)0.5,(float)0.5));//회색
		g.drawImage(img, 0, 500,this);
		
	}
}