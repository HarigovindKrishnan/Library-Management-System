package Project_code;

import java.awt.*;
import javax.swing.*;

public class searchBook
{
	JFrame frame;
	JTextField name;
	
	JFrame frame2;
	
	
	public void oper(Database db,Account acc)//method to display JFrame to search book
	{
		JLabel label = new JLabel();
		label.setText("Search Book");
		label.setFont(new Font("Castellar",Font.PLAIN,20));
		label.setPreferredSize(new Dimension(400,20));	
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		JButton submit=new JButton("Submit");
		submit.setPreferredSize(new Dimension(90,20));
		submit.addActionListener(e->search(db,acc));
		
		JButton exit=new JButton("Back");
		exit.setPreferredSize(new Dimension(90,20));
		exit.addActionListener(e-> back(db,acc));
		
		JLabel label2 = new JLabel();
		label2.setText("Book name:");
		label2.setFont(new Font("Calibri",Font.PLAIN,13));
		label2.setPreferredSize(new Dimension(100,20));	
		label2.setVerticalAlignment(JLabel.TOP);
		label2.setHorizontalAlignment(JLabel.CENTER);
		name=new JTextField(20);
		name.setPreferredSize(new Dimension(140,20));
		name.setText("");
		name.setHorizontalAlignment(JTextField.CENTER);
		
		frame=new JFrame();
		FlowLayout flowlayout=new FlowLayout();
		frame.setLayout(flowlayout);
		flowlayout.setVgap(20);
		flowlayout.setHgap(30);
		frame.setTitle("Search");
		frame.setSize(400, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label);
		frame.add(label2);
		frame.add(name);
		frame.add(submit);
		frame.add(exit);
		frame.setVisible(true);
	}
	
	private void search(Database db,Account acc)//function called when button is pressed
	{
		String n=name.getText();//retrieve data from textbox
		Book book=db.srchbook(n);//search book in hashmap and store book in object
		if(book==null)//book not found 
		{
			frame.dispose();
			JLabel label2 = new JLabel();
			label2.setText("Book not Found!");
			label2.setFont(new Font("Calibri",Font.BOLD,17));
			label2.setPreferredSize(new Dimension(300,20));	
			label2.setVerticalAlignment(JLabel.TOP);
			label2.setHorizontalAlignment(JLabel.CENTER);
			
			JButton exit=new JButton("Back");
			exit.setPreferredSize(new Dimension(90,20));
			exit.addActionListener(e-> back2(db,acc));
			
			frame2=new JFrame();
			FlowLayout flowlayout=new FlowLayout();
			frame2.setLayout(flowlayout);
			flowlayout.setVgap(20);
			flowlayout.setHgap(30);
			frame2.setTitle("LOGIN");
			frame2.setSize(400, 200);
			frame2.setResizable(false);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.add(label2);
			frame2.add(exit);
			frame2.setVisible(true);
		}
		
		else//JFrame to display searched book info
		{
			frame.dispose();		
			JLabel label = new JLabel();
			label.setText("Name: "+book.name+"     Author: "+book.author+"     Publisher: "+book.publisher);
			label.setFont(new Font("Calibri",Font.BOLD,17));
			label.setPreferredSize(new Dimension(500,20));	
			label.setVerticalAlignment(JLabel.CENTER);
			label.setHorizontalAlignment(JLabel.CENTER);
			
			JLabel label2 = new JLabel();
			label2.setText("     Address: "+book.adress+"     Price: "+book.price+"     Qty: "+book.brwcopies);
			label2.setFont(new Font("Calibri",Font.BOLD,17));
			label2.setPreferredSize(new Dimension(500,20));	
			label2.setVerticalAlignment(JLabel.CENTER);
			label2.setHorizontalAlignment(JLabel.CENTER);
			
			JButton exit=new JButton("Back");
			exit.setPreferredSize(new Dimension(90,20));
			exit.addActionListener(e-> back2(db,acc));
			
			frame2=new JFrame();
			FlowLayout flowlayout=new FlowLayout();
			frame2.setLayout(flowlayout);
			flowlayout.setVgap(20);
			flowlayout.setHgap(30);
			frame2.setTitle("LOGIN");
			frame2.setSize(600, 200);
			frame2.setResizable(false);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.add(label);
			frame2.add(label2);
			frame2.add(exit);
			frame2.setVisible(true);
		}
	}
	
	private void back(Database db,Account acc)//back to menu
	{
		frame.dispose();
		acc.menu(db,acc);
	}
	
	private void back2(Database db,Account acc)
	{
		frame2.dispose();
		acc.menu(db,acc);
	}
}
