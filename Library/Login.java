import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login{
	
	static JFrame f2;
	
	private JLabel name;
	private JTextField nameinput;
	private JLabel passwd;
	private JPasswordField passwdinput;
	private JButton loginbutton;
	String[][] userlist  = { {"root","root"}, {"admin", "admin"}, {"",""} };
	
	Login(){
		f2 = new JFrame();
		name = new JLabel("�˺ţ�");
		nameinput = new JTextField(13);
		passwd = new JLabel("���룺");
		passwdinput = new JPasswordField(13);
		loginbutton = new JButton("��½");
		
		loginbutton.addActionListener(new loginsystem());
		
		f2.setLayout(new GridLayout(3,1));
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1.add(name);
		p1.add(nameinput);
		p2.add(passwd);
		p2.add(passwdinput);
		p3.add(loginbutton);
		
		f2.add(p1);
		f2.add(p2);
		f2.add(p3);
		
		f2.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		f2.setTitle("��½�˺�");
		f2.setVisible(true);
		f2.setSize(300,250);
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - f2.getWidth() / 2;
		int y = (int) screensize.getHeight() / 2 - f2.getHeight() / 2;	
		f2.setLocation(x, y);
	}
	
	private class loginsystem extends Library implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Confirm confirm = new Confirm();
			int count = 0;
			String nameword = nameinput.getText();
			String passwdword = String.valueOf(passwdinput.getPassword());
			for(int i = 0; i < userlist.length; i++) {
				if(userlist[i][0].equals(nameword)) {
					count++;
					if(userlist[i][1].equals(passwdword)) {
						f2.dispose();
						loginstatus = true;
						username = nameword;
						f1.setVisible(true);
						confirm.lab.setText("��¼�ɹ���");
						confirm.f3.setVisible(true);
						userlab.setText("����Ա"+username+"����ã� Ŀǰ����"+booknum+"��");
					}else{
						confirm.lab.setText("�������");
						confirm.f3.setVisible(true);
					}
				}
			}
			if(count == 0) {
				confirm.lab.setText("�˺Ų����ڣ�");
				confirm.f3.setVisible(true);
			}
		}
	}
}