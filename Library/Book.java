import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Book{

	private JLabel num;
	private JTextField numinput;
	private JLabel bookname;
	private JTextField booknameinput;
	private JLabel author;
	private JTextField authorinput;
	private JLabel status;
	private JComboBox<String> statusbox;
	private JButton confirm, cancel;
	String[] statusarr = {"是", "否"};
	
	Book(){
		num = new JLabel("编号");
		bookname = new JLabel("书名：");
		author = new JLabel("作者：");
		status = new JLabel("可否借阅：");
		confirm = new JButton("确定");
		cancel = new JButton("取消");
		booknameinput = new JTextField(13);
		authorinput = new JTextField(13);
		numinput = new JTextField(8);
		statusbox = new JComboBox<String>(statusarr);
	}
	
	public void add() {
		addBook addBook = new addBook();
		addBook.addframe.setVisible(true);
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - addBook.addframe.getWidth() / 2;
		int y = (int) screensize.getHeight() / 2 - addBook.addframe.getHeight() / 2;	
		addBook.addframe.setLocation(x, y);
	}
	
	public void del() {
		delBook delBook = new delBook();
		delBook.delframe.setVisible(true);
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - delBook.delframe.getWidth() / 2;
		int y = (int) screensize.getHeight() / 2 - delBook.delframe.getHeight() / 2;	
		delBook.delframe.setLocation(x, y);
	}
	
	public void edit() {
		editBook editBook = new editBook();
		editBook.editframe.setVisible(true);
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - editBook.editframe.getWidth() / 2;
		int y = (int) screensize.getHeight() / 2 - editBook.editframe.getHeight() / 2;	
		editBook.editframe.setLocation(x, y);
	}
	
	public void search() {
		searchBook searchBook = new searchBook();
		searchBook.searchframe.setVisible(true);
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - searchBook.searchframe.getWidth() / 2;
		int y = (int) screensize.getHeight() / 2 - searchBook.searchframe.getHeight() / 2;	
		searchBook.searchframe.setLocation(x, y);
	}
	
	public class addBook extends Library{
		
		JFrame addframe;
		JRadioButton can, cant;
		
		addBook(){
			addframe = new JFrame();
			can = new JRadioButton("是",true);
			cant = new JRadioButton("否",false);
			ButtonGroup statusgroup = new ButtonGroup();
			statusgroup.add(can);
			statusgroup.add(cant);
			
			addframe.setLayout(new GridLayout(4,1));
			JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p1.add(bookname);
			p1.add(booknameinput);
			JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p2.add(author);
			p2.add(authorinput);
			JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p3.add(status);
			p3.add(can);
			p3.add(cant);
			JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p4.add(confirm);
			p4.add(cancel);
			
			confirm.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String status;
					if(can.isSelected()) {
						status = "是";
					}else {
						status = "否";
					}
					int num;
					if(booknum == 0) {
						num = booknum + 1;
					}else {
						num = Integer.parseInt(books[booknum - 1][0]) + 1;
					}
					books[booknum][0] = String.valueOf(num);
					books[booknum][1] = booknameinput.getText();
					books[booknum][2] = authorinput.getText();
					books[booknum][3] = status;
					booknum++;
					addframe.dispose();
					Confirm confirm = new Confirm();
					confirm.lab.setText("添加成功！现在有"+booknum+"本！");
					confirm.f3.setVisible(true);
					userlab.setText("管理员"+username+"，你好！ 目前藏书"+booknum+"本");
				}
			});
			
			cancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					addframe.dispose();
				}
			});
			
			addframe.add(p1);
			addframe.add(p2);
			addframe.add(p3);
			addframe.add(p4);
			
			addframe.setSize(350,300);
			addframe.setTitle("添加图书");
			
		}
	}
	
	public class delBook extends Library{
		
		JFrame delframe;
		JRadioButton c1;
		JRadioButton c2;
		JPanel p, s1, s2;
		
		delBook(){
			delframe = new JFrame();
			c1 = new JRadioButton("编号",true);
			c2 = new JRadioButton("书名作者",false);
			ButtonGroup choice = new ButtonGroup();
			choice.add(c1);
			choice.add(c2);
			
			delframe.setLayout(new GridLayout(3,1));
			JPanel c = new JPanel(new FlowLayout(FlowLayout.CENTER));
			c.add(c1);
			c.add(c2);
			p = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p.add(num);
			p.add(numinput);
			s1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			s1.add(bookname);
			s1.add(booknameinput);
			s2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			s2.add(author);
			s2.add(authorinput);
			JPanel bpane = new JPanel(new FlowLayout(FlowLayout.CENTER));
			bpane.add(confirm);
			bpane.add(cancel);
			
			confirm.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Confirm confirm = new Confirm();
					if(c1.isSelected()) {
						String input = numinput.getText();
						int count = 0;
						for(int i = 0; i < booknum; i++) {
							if(input.equals(books[i][0])) {
								count++;
								if(booknum == 1 | i == booknum - 1) {
									books[i][0] = null;
									books[i][1] = null;
									books[i][2] = null;
									books[i][3] = null;
								}else {
									for(int j = i; j < booknum - 1; j++) {
										books[j][0] = books[j + 1][0];
										books[j][1] = books[j + 1][1];
										books[j][2] = books[j + 1][2];
										books[j][3] = books[j + 1][3];
									}
									books[booknum - 1][0] = "";
									books[booknum - 1][1] = "";
									books[booknum - 1][2] = "";
									books[booknum - 1][3] = "";
								}
								booknum--;
								delframe.dispose();
								confirm.lab.setText("删除成功！现在有"+booknum+"本书！");
								confirm.f3.setVisible(true);
								userlab.setText("管理员"+username+"，你好！ 目前藏书"+booknum+"本");
							}
						}
						if(count == 0) {
							confirm.lab.setText("未找到为此编号的书！");
							confirm.f3.setVisible(true);
						}
					}else {
						String input1 = booknameinput.getText();
						String input2 = authorinput.getText();
						int count = 0;
						for(int i = 0; i < booknum; i++) {
							if(input1.equals(books[i][1]) ) {
								if(input2.equals(books[i][2])) {
									count++;
									if(booknum == 1 | i == booknum - 1) {
										books[i][0] = null;
										books[i][1] = null;
										books[i][2] = null;
										books[i][3] = null;
									}else {
										for(int j = i; j < booknum - 1; j++) {
											books[j][0] = books[j + 1][0];
											books[j][1] = books[j + 1][1];
											books[j][2] = books[j + 1][2];
											books[j][3] = books[j + 1][3];
										}
										books[booknum - 1][0] = "";
										books[booknum - 1][1] = "";
										books[booknum - 1][2] = "";
										books[booknum - 1][3] = "";
									}
									booknum--;
									delframe.dispose();
									confirm.lab.setText("删除成功！现在有"+booknum+"本书！");
									confirm.f3.setVisible(true);
									userlab.setText("管理员"+username+"，你好！ 目前藏书"+booknum+"本");
								}
							}
						}
						if(count == 0) {
							confirm.lab.setText("未找到为此书名作者的书！");
							confirm.f3.setVisible(true);
						}
					}
				}
			});
			
			cancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					delframe.dispose();
				}
			});
			
			c1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(c1.isSelected()) {
						p.removeAll();
						p.add(num);
						p.add(numinput);
						p.validate();
						p.repaint();
					}
				}
			});
			
			c2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(c2.isSelected()) {
						p.removeAll();
						p.add(s1);
						p.add(s2);
						p.validate();
						p.repaint();
					}
				}
			});
			delframe.add(c);
			delframe.add(p);
			delframe.add(bpane);
			
			delframe.setSize(350,300);
			delframe.setTitle("删除图书");
		}
	}
	
	public class editBook extends Library{
		
		JFrame editframe;
		JComboBox<String> numbox;
		JPanel p1, p2, p3, p4, button;
		int index = -1;
		
		editBook(){
			editframe = new JFrame();
			String numarr[] = new String[100];
			for(int i = 0; i < booknum; i++) {
				numarr[i + 1] = books[i][0];
			}
			numbox = new JComboBox<String>(numarr);
			editframe.setLayout(new GridLayout(5,1));
			p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p1.add(num);
			p1.add(numbox);
			p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p2.add(bookname);
			p2.add(booknameinput);
			p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p3.add(author);
			p3.add(authorinput);
			p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p4.add(status);
			p4.add(statusbox);
			button = new JPanel(new FlowLayout(FlowLayout.CENTER));
			button.add(confirm);
			button.add(cancel);
			
			numbox.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(numbox.getSelectedItem() != null) {
						for(int i = 0; i < booknum; i++) {
							if(numbox.getSelectedItem() .equals(books[i][0])) {
								index = i;
								booknameinput.setText(books[i][1]);
								authorinput.setText(books[i][2]);
								if(books[i][3].equals("是")) {
									statusbox.setSelectedIndex(0);
								}else {
									statusbox.setSelectedIndex(1);
								}
							}
						}
					}
				}
			});
			
			confirm.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Confirm confirm = new Confirm();
					if(index == -1) {
						confirm.lab.setText("请选择图书编号进行编辑！");
						confirm.f3.setVisible(true);
					}else {
						books[index][1] = booknameinput.getText();
						books[index][2] = authorinput.getText();
						books[index][3] = statusarr[statusbox.getSelectedIndex()];
						editframe.dispose();
						confirm.lab.setText("编辑成功！");
						confirm.f3.setVisible(true);
					}
				}
			});
			
			cancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					editframe.dispose();
				}
			});
			
			editframe.add(p1);
			editframe.add(p2);
			editframe.add(p3);
			editframe.add(p4);
			editframe.add(button);
			
			editframe.setSize(350,300);
			editframe.setTitle("编辑图书");
		}
	}
	
	public class searchBook extends Library{
		
		JFrame searchframe;
		JRadioButton c1, c2, c3, c4;
		JPanel p, p1, p2, p3, p4;
		
		
		searchBook(){
			searchframe = new JFrame();
			c1 = new JRadioButton("编号", true);
			c2 = new JRadioButton("书名", false);
			c3 = new JRadioButton("作者", false);
			c4 = new JRadioButton("可否借阅", false);
			ButtonGroup choice = new ButtonGroup();
			choice.add(c1);
			choice.add(c2);
			choice.add(c3);
			choice.add(c4);
			
			searchframe.setLayout(new GridLayout(3,1));
			JPanel c = new JPanel(new FlowLayout(FlowLayout.CENTER));
			c.add(c1);
			c.add(c2);
			c.add(c3);
			c.add(c4);
			
			p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p1.add(num);
			p1.add(numinput);
			p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p2.add(bookname);
			p2.add(booknameinput);
			p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p3.add(author);
			p3.add(authorinput);
			p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p4.add(status);
			p4.add(statusbox);
			JPanel button = new JPanel(new FlowLayout(FlowLayout.CENTER));
			button.add(confirm);
			button.add(cancel);
			p = new JPanel(new FlowLayout(FlowLayout.CENTER));
			
			confirm.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Confirm confirm = new Confirm();
					String[][] resultarr = new String[99][4];
					String input;
					int count = 0;
					if(c1.isSelected()){
						input = numinput.getText();
						count = 0;
						resultarr = new String[99][4];
						for(int i = 0; i < booknum; i++) {
							if(input.equals(books[i][0])) {
								resultarr[count] = books[i];
								searchframe.dispose();
								count++;
							}
						}
					}else if(c2.isSelected()){
						input = booknameinput.getText();
						count = 0;
						resultarr = new String[99][4];
						for(int i = 0; i < booknum; i++) {
							if(input.equals(books[i][1])) {
								resultarr[count] = books[i];
								searchframe.dispose();
								count++;
							}
						}
					}else if(c3.isSelected()){
						input = authorinput.getText();
						count = 0;
						resultarr = new String[99][4];
						for(int i = 0; i < booknum; i++) {
							if(input.equals(books[i][2])) {
								resultarr[count] = books[i];
								searchframe.dispose();
								count++;
							}
						}
					}else{
						input = statusarr[statusbox.getSelectedIndex()];
						count = 0;
						resultarr = new String[99][4];
						for(int i = 0; i < booknum; i++) {
							if(input.equals(books[i][3])) {
								resultarr[count] = books[i];
								searchframe.dispose();
								count++;
							}
						}
					}
					if(count == 0) {
						confirm.lab.setText("无结果！");
						confirm.f3.setVisible(true);
					}else{
						JFrame resultframe = new JFrame();
						JTable searchresulttable = new JTable(resultarr, bookindex){
							private static final long serialVersionUID = 1L;
							
							public boolean isCellEditable(int row, int column){
				            	return false;
				            }
				        };
				        JScrollPane searchresultpane = new JScrollPane(searchresulttable);
				        resultframe.add(searchresultpane);
						resultframe.setTitle("查询结果");
						resultframe.setSize(500,400);
						Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
						int x = (int) screensize.getWidth() / 2 - resultframe.getWidth() / 2;
						int y = (int) screensize.getHeight() / 2 - resultframe.getHeight() / 2;	
						resultframe.setLocation(x, y);
						resultframe.setVisible(true);
					}
				}
			});
			
			cancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					searchframe.dispose();
				}
			});
			
			c1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(c1.isSelected()) {
						p.removeAll();
						p.add(p1);
						p.validate();
						p.repaint();
					}
				}
			});
			
			c2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(c2.isSelected()) {
						p.removeAll();
						p.add(p2);
						p.validate();
						p.repaint();
					}
				}
			});
			
			c3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(c3.isSelected()) {
						p.removeAll();
						p.add(p3);
						p.validate();
						p.repaint();
					}
				}
			});
			
			c4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(c4.isSelected()) {
						p.removeAll();
						p.add(p4);
						p.validate();
						p.repaint();
					}
				}
			});
		
			p.add(p1);
			
			searchframe.add(c);
			searchframe.add(p);
			searchframe.add(button);
			
			searchframe.setSize(350,300);
			searchframe.setTitle("查找图书");
		}
	}
}