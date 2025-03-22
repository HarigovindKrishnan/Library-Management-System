package Project_code;

import java.awt.*;
import java.util.prefs.BackingStoreException;

import javax.swing.*;

public class addBook
{
	//global variables
	JFrame frame;
	JFrame frame2;

	JTextField name;
	JTextField author;
	JTextField pub;
	JTextField adress;
	JTextField qty;
	JTextField price;
	JTextField brwcopies;
	JButton submit;
	JButton exit;
	
	String n;
	String a;
	String publisher;
	String ad;
	int q;
	double p;
	int bc;
	
	
	public void oper(Database db,Account acc)
	{
		
		JLabel label = new JLabel(); //Jframe to input info from user
		label.setText("Add Book");
		label.setFont(new Font("Castellar",Font.PLAIN,20));
		label.setPreferredSize(new Dimension(400,20));	
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		
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

		
		JLabel label3 = new JLabel();
		label3.setText("Author: ");
		label3.setFont(new Font("Calibri",Font.PLAIN,13));
		label3.setPreferredSize(new Dimension(100,20));	
		label3.setVerticalAlignment(JLabel.TOP);
		label3.setHorizontalAlignment(JLabel.CENTER);
		author=new JTextField(20);
		author.setPreferredSize(new Dimension(140,20));
		author.setText("");
		author.setHorizontalAlignment(JTextField.CENTER);
		
		JLabel label4 = new JLabel();
		label4.setText("Publisher ");
		label4.setFont(new Font("Calibri",Font.PLAIN,13));
		label4.setPreferredSize(new Dimension(100,20));	
		label4.setVerticalAlignment(JLabel.TOP);
		label4.setHorizontalAlignment(JLabel.CENTER);
		pub=new JTextField(20);
		pub.setPreferredSize(new Dimension(140,20));
		pub.setText("");
		pub.setHorizontalAlignment(JTextField.CENTER);
		
		JLabel label5 = new JLabel();
		label5.setText("Address: ");
		label5.setFont(new Font("Calibri",Font.PLAIN,13));
		label5.setPreferredSize(new Dimension(100,20));	
		label5.setVerticalAlignment(JLabel.TOP);
		label5.setHorizontalAlignment(JLabel.CENTER);
		adress=new JTextField(20);
		adress.setPreferredSize(new Dimension(140,20));
		adress.setText("");
		adress.setHorizontalAlignment(JTextField.CENTER);

		JLabel label6 = new JLabel();
		label6.setText("Quantity: ");
		label6.setFont(new Font("Calibri",Font.PLAIN,13));
		label6.setPreferredSize(new Dimension(100,20));	
		label6.setVerticalAlignment(JLabel.TOP);
		label6.setHorizontalAlignment(JLabel.CENTER);
		qty=new JTextField(20);
		qty.setPreferredSize(new Dimension(140,20));
		qty.setText("");
		qty.setHorizontalAlignment(JTextField.CENTER);
		
		JLabel label7 = new JLabel();
		label7.setText("Price: ");
		label7.setFont(new Font("Calibri",Font.PLAIN,13));
		label7.setPreferredSize(new Dimension(100,20));	
		label7.setVerticalAlignment(JLabel.TOP);
		label7.setHorizontalAlignment(JLabel.CENTER);
		price=new JTextField(20);
		price.setPreferredSize(new Dimension(140,20));
		price.setText("");
		price.setHorizontalAlignment(JTextField.CENTER);
		
		JLabel label8= new JLabel();
		label8.setText("No. of Borrowing copies: ");
		label8.setFont(new Font("Calibri",Font.PLAIN,13));
		label8.setPreferredSize(new Dimension(100,20));	
		label8.setVerticalAlignment(JLabel.TOP);
		label8.setHorizontalAlignment(JLabel.CENTER);
		brwcopies=new JTextField(20);
		brwcopies.setPreferredSize(new Dimension(140,20));
		brwcopies.setText("");
		brwcopies.setHorizontalAlignment(JTextField.CENTER);

		
		submit=new JButton("Submit");
		submit.setPreferredSize(new Dimension(90,20));
		submit.addActionListener(e->retrieve(db,acc));
		
		exit=new JButton("Back"); //button to return to menu page
		exit.setPreferredSize(new Dimension(90,20));
		exit.addActionListener(e-> back(db,acc));
		
		frame=new JFrame(); //Adding all elements to the JFrame
		FlowLayout flowlayout=new FlowLayout();
		frame.setLayout(flowlayout);
		flowlayout.setVgap(20);
		flowlayout.setHgap(30);
		frame.setTitle("LOGIN");
		frame.setSize(400, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label);
		frame.add(label2);
		frame.add(name);
		frame.add(label3);
		frame.add(author);
		frame.add(label4);
		frame.add(pub);
		frame.add(label5);
		frame.add(adress);
		frame.add(label6);
		frame.add(qty);
		frame.add(label7);
		frame.add(price);
		frame.add(label8);
		frame.add(brwcopies);
		frame.add(exit); 
		frame.add(submit);
		frame.setVisible(true);
	}
	
	private void retrieve(Database db,Account acc) //execute if submit button is pressed
	{
		n=name.getText(); //retrieve info from textboxes
		a=author.getText();
		publisher=pub.getText();
		ad=adress.getText();
		q=Integer.parseInt(qty.getText()); //convert the values in textbox to int
		p=Double.valueOf(price.getText());
		bc=Integer.parseInt(brwcopies.getText());
		
		Book book=new Book(n,a,publisher,ad,q,p,bc); //create new book object
		db.addBook(book);	//add this book object to database
		
		frame.dispose();
		JLabel label = new JLabel();
		label.setText("Book Added Successfully");
		label.setFont(new Font("Calibri",Font.BOLD,20));
		label.setPreferredSize(new Dimension(400,20));	
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		frame2=new JFrame();
		FlowLayout flowlayout=new FlowLayout();
		frame2.setLayout(flowlayout);
		flowlayout.setVgap(20);
		flowlayout.setHgap(30);
		frame2.setTitle("Add Book");
		frame2.setSize(400, 200);
		frame2.setResizable(false);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.add(label);
		frame2.add(exit);
		frame2.setVisible(true);
	}
	
	private void back(Database db,Account acc) //to go back to menu
	{
		frame2.dispose();
		acc.menu(db,acc);
	}

}
