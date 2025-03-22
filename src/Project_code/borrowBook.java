package Project_code;

import java.awt.*;
import java.time.LocalDate;
import java.time.*;

import javax.swing.*;

public class borrowBook
{
	//Global attributes
	JFrame frame;
	JTextField name;
	
	JFrame frame2;
	public void oper(Database db,Account acc) //function to borrow book
	{
		JLabel label = new JLabel();
		label.setText("Borrow Book");
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
		
		
		frame=new JFrame(); //frame to enter book name to borrow
		FlowLayout flowlayout=new FlowLayout();
		frame.setLayout(flowlayout);
		flowlayout.setVgap(20);
		flowlayout.setHgap(30);
		frame.setTitle("Order");
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
	
	
	private void search(Database db,Account acc) // function to search the book name in hashmap in database
	{
		String n=name.getText(); //retrieve info from textbox
		Book book=db.srchbook(n); //search book in database and store the returned object in book
		if(book==null) //if book not found
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
			frame2.setTitle("Borrow Book");
			frame2.setSize(400, 200);
			frame2.setResizable(false);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.add(label2);
			frame2.add(exit);
			frame2.setVisible(true);
		}
		
		if(book!=null)
		{
			Borrow brw=new Borrow(book,acc,LocalDate.now(),LocalDate.now().plusDays(14)); //create borrow object with the book object and current account
			JLabel label = new JLabel();
			JLabel label2 = new JLabel();

			if(book.getQty()>0) //check if book is available
			{
				db.addBorrow(brw, book, book.getQty()-1);
				frame.dispose();		
				label.setText("Borrowed Successfully!");
				label.setFont(new Font("Calibri",Font.BOLD,20));
				label.setPreferredSize(new Dimension(300,20));	
				label.setVerticalAlignment(JLabel.TOP);
				label.setHorizontalAlignment(JLabel.CENTER);
				
				label2.setText("Book must be returned on or before"+brw.getEnd());
				label2.setFont(new Font("Calibri",Font.PLAIN,20));
				label2.setPreferredSize(new Dimension(800,50));	
				label2.setVerticalAlignment(JLabel.BOTTOM);
				label2.setHorizontalAlignment(JLabel.CENTER);

			}
			
			else
			{
				frame.dispose();		
				
				label.setText("Borrow Unsuccessful!");
				label.setFont(new Font("Calibri",Font.BOLD,20));
				label.setPreferredSize(new Dimension(300,20));	
				label.setVerticalAlignment(JLabel.TOP);
				label.setHorizontalAlignment(JLabel.CENTER);
				
				label2.setText("Copies not available at the moment");
				label2.setFont(new Font("Calibri",Font.PLAIN,20));
				label2.setPreferredSize(new Dimension(400,100));	
				label2.setVerticalAlignment(JLabel.BOTTOM);
				label2.setHorizontalAlignment(JLabel.CENTER);
			}
						
			
			
			JButton exit=new JButton("Back"); //button to go back to menu
			exit.setPreferredSize(new Dimension(90,20));
			exit.addActionListener(e-> back2(db,acc));
			
			frame2=new JFrame();
			FlowLayout flowlayout=new FlowLayout();
			frame2.setLayout(flowlayout);
			flowlayout.setVgap(20);
			flowlayout.setHgap(200);
			frame2.setTitle("Order Success");
			frame2.setSize(700, 200);
			frame2.setResizable(false);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.add(label);
			frame2.add(label2);
			frame2.add(exit);
			frame2.setVisible(true);
		}
	}
	
	private void back(Database db,Account acc)// to go back to menu
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
