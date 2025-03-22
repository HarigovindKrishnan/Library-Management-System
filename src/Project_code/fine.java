package Project_code;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class fine
{
	JFrame frame;
	JTextField name;
	
	JFrame frame2;
	JFrame frame3;
	
	public void oper(Database db,Account acc)//method to display JFrame to enter book name
	{
		JLabel label = new JLabel();
		label.setText("Calculate Fine");
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
	
	private void search(Database db,Account acc)//search for book in hashmap
	{
		String s=name.getText(); //retrieve info from textbox
		Borrow brw=db.checkborrowexists(acc.name, s); //create borrow object
		JButton exit=new JButton("Back");
		exit.setPreferredSize(new Dimension(90,20));
		exit.addActionListener(e-> back(db,acc));
		if(brw==null)//if borrow object doesnt exist in list
		{
			frame.dispose();
			JLabel label = new JLabel();
			label.setText("Book has not been borrowed by user");
			label.setFont(new Font("Calibri",Font.BOLD,20));
			label.setPreferredSize(new Dimension(400,20));	
			label.setVerticalAlignment(JLabel.TOP);
			label.setHorizontalAlignment(JLabel.CENTER);
			
			frame2=new JFrame();
			FlowLayout flowlayout=new FlowLayout();
			frame2.setLayout(flowlayout);
			flowlayout.setVgap(20);
			flowlayout.setHgap(30);
			frame2.setTitle("Order");
			frame2.setSize(400, 200);
			frame2.setResizable(false);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.add(label);
			frame2.add(exit);
			frame2.setVisible(true);
		}
		else
		{
			frame.dispose();
						
			LocalDate current=LocalDate.now();
			LocalDate end=brw.end;
			double amt;

			if (current.isBefore(end)) //check if due date is passed
			{
				amt=0.0;
			}
			else
			{
				long daysBetween = ChronoUnit.DAYS.between(current, end);
				amt=daysBetween*2.5;// calculate fine at 2.5 rupees per day delayed
			}
			
			JLabel label = new JLabel();
			label.setText("Fine owed: Rs."+amt);
			label.setFont(new Font("Calibri",Font.BOLD,20));
			label.setPreferredSize(new Dimension(400,20));	
			label.setVerticalAlignment(JLabel.TOP);
			label.setHorizontalAlignment(JLabel.CENTER);
			
			frame2=new JFrame();
			FlowLayout flowlayout=new FlowLayout();
			frame2.setLayout(flowlayout);
			flowlayout.setVgap(20);
			flowlayout.setHgap(30);
			frame2.setTitle("Order");
			frame2.setSize(400, 200);
			frame2.setResizable(false);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.add(label);
			frame2.add(exit);
			frame2.setVisible(true);
						
		}
	}
	
	private void back(Database db,Account acc)//back to menu
	{
		frame.dispose();
		acc.menu(db,acc);
	}
}
