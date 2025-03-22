package Project_code;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

import java.nio.file.attribute.AclEntry;

public class Admin extends Account //child of Account class
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
	public void menu(Database db,Account acc) //Menu providing functions to be performed
	{
		JLabel label=new JLabel();
		label.setPreferredSize(new Dimension(400,30));
		label.setText("Admin Menu");
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
		
		JButton addb=new JButton();
		addb.setPreferredSize(new Dimension(250,40));
		addb.setFont(new Font("Times New Roman",Font.BOLD,14));
		addb.setText("Add Book");
		addb.setFocusable(false);
		addb.addActionListener(e -> choice(2,db,acc));
		
		JButton delb=new JButton();
		delb.setPreferredSize(new Dimension(250,40));
		delb.setFont(new Font("Times New Roman",Font.BOLD,14));
		delb.setText("Delete Book");
		delb.setFocusable(false);
		delb.addActionListener(e -> choice(3,db,acc));
		
		JButton searchbookb=new JButton();
		searchbookb.setPreferredSize(new Dimension(250,40));
		searchbookb.setFont(new Font("Times New Roman",Font.BOLD,14));
		searchbookb.setText("Search Book");
		searchbookb.setFocusable(false);
		searchbookb.addActionListener(e -> choice(4,db,acc));
		
		JButton viewob=new JButton();
		viewob.setPreferredSize(new Dimension(250,40));
		viewob.setFont(new Font("Times New Roman",Font.BOLD,14));
		viewob.setText("View Orders");
		viewob.setFocusable(false);
		viewob.addActionListener(e -> choice(5,db,acc));
		
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
		frame.setTitle("Admin Menu");
		frame.setSize(400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label);
		frame.add(label2);
		frame.add(viewbookb);
		frame.add(addb);
		frame.add(delb);
		frame.add(searchbookb);
		frame.add(viewob);
		frame.add(exitb);
		frame.setVisible(true);
	}
	
	private void choice(int n,Database db,Account acc) //perform function depending on button pressed
	{
		switch(n)
		{
		case 1:
			viewBooks vbook=new viewBooks(); //creating object of the class and then performing the function
			frame.dispose();
			vbook.oper(db,acc);
			break;
		case 2:
			addBook abook=new addBook();
			frame.dispose();
			abook.oper(db,acc);
			break;
		case 3:
			delBook dbook=new delBook();
			frame.dispose();
			dbook.oper(db,acc);
			break;
		case 4:
			searchBook sbook=new searchBook();
			frame.dispose();
			sbook.oper(db,acc);
			break;
		case 5:
			viewBorrow vb=new viewBorrow();
			frame.dispose();
			vb.oper(db,acc);
			break;	
		}
	}
	
	@Override
	public String toString() //creating a string to be stored on the PC's disk
	{
		return name+"#"+email+"#"+password+"#"+"Admin";
	}
}
