package Project_code;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

import java.nio.file.attribute.AclEntry;

public class User extends Account
{
	JFrame frame;
		
	public String getName()
	{
		return name;
	}
	
	public String getMail()
	{
		return email;
	}
	
		
	@Override
	public void menu(Database db,Account acc)
	{
		JLabel label=new JLabel();
		label.setPreferredSize(new Dimension(400,30));
		label.setText("User Menu");
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Castellar",Font.PLAIN,30));
		
		JLabel label2=new JLabel();
		label2.setPreferredSize(new Dimension(300,20));
		label2.setText("Welcome "+acc.name+",");
		label2.setVerticalAlignment(JLabel.TOP);
		label2.setHorizontalAlignment(JLabel.LEFT);
		label2.setFont(new Font("Monotype Corsiva",Font.BOLD,20));
		
		JButton viewbookb=new JButton();
		viewbookb.setPreferredSize(new Dimension(250,40));
		viewbookb.setFont(new Font("Times New Roman",Font.BOLD,14));
		viewbookb.setText("View Books");
		viewbookb.setFocusable(false);
		viewbookb.addActionListener(e -> choice(1,db,acc));
		
		JButton searchbookb=new JButton();
		searchbookb.setPreferredSize(new Dimension(250,40));
		searchbookb.setFont(new Font("Times New Roman",Font.BOLD,14));
		searchbookb.setText("Search Book");
		searchbookb.setFocusable(false);
		searchbookb.addActionListener(e -> choice(2,db,acc));
		
		JButton borrowbookb=new JButton();
		borrowbookb.setPreferredSize(new Dimension(250,40));
		borrowbookb.setFont(new Font("Times New Roman",Font.BOLD,14));
		borrowbookb.setText("Place Order");
		borrowbookb.setFocusable(false);
		borrowbookb.addActionListener(e -> choice(3,db,acc));
		
		JButton fineb=new JButton();
		fineb.setPreferredSize(new Dimension(250,40));
		fineb.setFont(new Font("Times New Roman",Font.BOLD,14));
		fineb.setText("Calculate Fine");
		fineb.setFocusable(false);
		fineb.addActionListener(e -> choice(4,db,acc));
		
		JButton returnb=new JButton();
		returnb.setPreferredSize(new Dimension(250,40));
		returnb.setFont(new Font("Times New Roman",Font.BOLD,14));
		returnb.setText("Return Book");
		returnb.setFocusable(false);
		returnb.addActionListener(e -> choice(5,db,acc));
		
		JButton exitb=new JButton();
		exitb.setPreferredSize(new Dimension(250,40));
		exitb.setFont(new Font("Times New Roman",Font.BOLD,14));
		exitb.setText("Exit");
		exitb.setFocusable(false);
		exitb.addActionListener(e -> frame.dispose());
		
		frame=new JFrame();
		FlowLayout flowlayout=new FlowLayout();
		flowlayout.setVgap(30);
		flowlayout.setHgap(50);
		frame.setLayout(flowlayout);
		frame.setTitle("User Menu");
		frame.setSize(400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label);
		frame.add(label2);
		frame.add(viewbookb);
		frame.add(searchbookb);
		frame.add(borrowbookb);
		frame.add(fineb);
		frame.add(returnb);
		frame.add(exitb);
		frame.setVisible(true);
	}
	
	private void choice(int n,Database db,Account acc)
	{
		switch(n)
		{
		case 1:
			viewBooks vbook=new viewBooks(); //creating a string to be stored on the PC's disk
			frame.dispose();
			vbook.oper(db,acc);
			break;
		case 2:
			searchBook sbook=new searchBook();
			frame.dispose();
			sbook.oper(db,acc);
			break;
		case 3:
			borrowBook bbook=new borrowBook();
			frame.dispose();
			bbook.oper(db,acc);
			break;
		case 4:
			fine fc=new fine();
			frame.dispose();
			fc.oper(db,acc);
			break;			
		case 5:
			returnBook rbook=new returnBook();
			frame.dispose();
			rbook.oper(db,acc);
			break;
			
		}
	}
	
	@Override
	public String toString() //creating a string to be stored on the PC's disk
	{
		return name+"#"+email+"#"+password+"#"+"User";
	}
}
