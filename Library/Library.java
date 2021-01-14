import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

import java.awt.event.*;

public class Library{

	static boolean loginstatus;
	static String username;
	static String books[][] = new String[99][4];
	static int booknum = 0;
	static JFrame f1 = new JFrame();
	private JMenuBar menu;
	private JMenu arrange, exit;
	private JMenuItem add, del, edit, search, logout, exitsystem;
	static JLabel userlab = new JLabel("");
	static JTable result;
	static String[] bookindex = {"���","����","����","�ɷ����"}; 
	static JScrollPane resultpane;
	
	Library(){
		menu = new JMenuBar();
		arrange = new JMenu("����ͼ��");
		exit = new JMenu("�˳�");
		add = new JMenuItem("���ͼ��");
		del = new JMenuItem("ɾ��ͼ��");
		edit = new JMenuItem("�༭ͼ��");
		search = new JMenuItem("����ͼ��");
		logout = new JMenuItem("�ǳ��˺�");
		exitsystem = new JMenuItem("�˳�ϵͳ");
		result = new JTable(books, bookindex){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
            	return false;
            }
        };
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		result.setDefaultRenderer(Object.class, r);
		resultpane = new JScrollPane(result);
		
		add.addActionListener(new book());
		del.addActionListener(new book());
		edit.addActionListener(new book());
		search.addActionListener(new book());
		logout.addActionListener(new logout());
		exitsystem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		arrange.add(add);
		arrange.add(del);
		arrange.add(edit);
		arrange.add(search);
		
		exit.add(logout);
		exit.add(exitsystem);
		
		menu.add(arrange);
		menu.add(exit);
		
		f1.add(menu,BorderLayout.NORTH);
		f1.add(userlab,BorderLayout.SOUTH);
		f1.add(resultpane);
		
		f1.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		f1.setTitle("ͼ��ݹ���ϵͳ");
		f1.setSize(500,400);

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - f1.getWidth() / 2;
		int y = (int) screensize.getHeight() / 2 - f1.getHeight() / 2;	
		f1.setLocation(x, y);
	}
	
	public static void main(String args[]){
		loginstatus = false;
		username = "";
		new Login();
	}
	
	private class book implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == add){
				Book add = new Book();
				add.add();
			}
			if(e.getSource() == del){
				Book del = new Book();
				del.del();
			}
			if(e.getSource() == edit) {
				Book edit = new Book();
				edit.edit();
			}
			if(e.getSource() == search){
				Book search = new Book();
				search.search();
			}
		}
	}
	
	
	private class logout implements ActionListener{
		public void actionPerformed(ActionEvent e){
			loginstatus = false;
			username = "";
			f1.dispose();
			new Login();
			Confirm confirm = new Confirm();
			confirm.lab.setText("�˳���¼�ɹ���");
			confirm.f3.setVisible(true);
		}
	}
}