import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Confirm extends Library{
	
	JFrame f3;
	JLabel lab;
	
	Confirm(){
		f3 = new JFrame();
		lab = new JLabel(" ");
		JButton confirm = new JButton("È·¶¨");
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		confirm.addActionListener(new confirmbutton());
			
		f3.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				f1.validate();
		        f1.repaint();
				f3.dispose();
			}
		});
			
		p1.add(lab);
		p2.add(confirm);
		f3.setLayout(new GridLayout(2,1));
		f3.add(p1);
		f3.add(p2);
		f3.setTitle("");
		f3.setSize(200,100);
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - f3.getWidth() / 2;
		int y = (int) screensize.getHeight() / 2 - f3.getHeight() / 2;	
		f3.setLocation(x, y);
	}
		
	private class confirmbutton implements ActionListener{
		public void actionPerformed(ActionEvent e){
	        f1.validate();
	        f1.repaint();
			f3.dispose();
		}
	}
}
