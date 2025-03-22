package Project_code;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Driver
{
	//Starting page
	JRadioButton seladmin; //Radio Button to select admin or user
	JRadioButton seluser;  //Radio Button to select admin or user
	JFrame frame;
	Database database;
	int flag=0;
	
	//Login/Signup page
	JFrame frame2;
	JTextField mailTF; //Textbox for email
	JPasswordField passTF;  //Textbox for password
	JTextField nameTF;  //Textbox for name
	JButton submit;
	String m;
	String n;
	char[] p;
	
	JFrame frame3;
	
	Database db=new Database(); //creating database object
	
	private void start()
	{
		JLabel label=new JLabel();
		Dimension d1=new Dimension(400,30);
		label.setPreferredSize(d1);
		label.setText("Welcome Readers!");
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Castellar",Font.PLAIN,30));
		
		JLabel label2 = new JLabel();
		label2.setText("\nSelect preferred option:");
		label2.setFont(new Font("Calibri",Font.PLAIN,20));
		Dimension d2=new Dimension(400,20);
		label2.setPreferredSize(d2);	
		label2.setVerticalAlignment(JLabel.TOP);
		label2.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label3 = new JLabel();
		label3.setText("~Group 12");
		label3.setFont(new Font("Calibri",Font.PLAIN,13));
		Dimension d3=new Dimension(400,20);
		label3.setPreferredSize(d3);	
		label3.setVerticalAlignment(JLabel.TOP);
		label3.setHorizontalAlignment(JLabel.LEFT);
		

		JButton loginbutton=new JButton();
		Dimension b1=new Dimension(250,60);
		loginbutton.setPreferredSize(b1);
		loginbutton.setFont(new Font("Times New Roman",Font.BOLD,20));
		loginbutton.setText("LOGIN");
		loginbutton.setFocusable(false);
		loginbutton.addActionListener(e -> log());
		
		
		JButton signbutton=new JButton();
		Dimension b2=new Dimension(250,60);
		signbutton.setPreferredSize(b2);
		signbutton.setFont(new Font("Times New Roman",Font.BOLD,20));
		signbutton.setText("SIGN UP");
		signbutton.setFocusable(false);
		signbutton.addActionListener(e -> signup());
		
		seladmin=new JRadioButton("Admin");
		seladmin.addActionListener(e -> flag=2);
		seluser=new JRadioButton("User");
		seluser.addActionListener(e -> flag=1);
		ButtonGroup group=new ButtonGroup();
		group.add(seladmin);
		group.add(seluser);
		
		
		frame=new JFrame();  //Frame for front page
		FlowLayout flowlayout=new FlowLayout();
		flowlayout.setVgap(30);
		flowlayout.setHgap(50);
		frame.setLayout(flowlayout);
		frame.setTitle("Library Management System");
		frame.setSize(420, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label);
		frame.add(label2);
		frame.add(loginbutton);
		frame.add(signbutton);
		frame.add(seladmin);
		frame.add(seluser);
		frame.setVisible(true);
	}
	
	private void log() //if login button is pressed
	{
		if(flag!=1 && flag!=2) //if neither user nor admin is selected
		{
			frame.dispose();
			JLabel label = new JLabel();
			label.setText("Select Admin or User");
			label.setFont(new Font("Times New Roman",Font.PLAIN,15));
			label.setPreferredSize(new Dimension(400,50));	
			label.setVerticalAlignment(JLabel.TOP);
			label.setHorizontalAlignment(JLabel.CENTER);
			
			JButton exit=new JButton("Back");
			exit.setPreferredSize(new Dimension(90,20));
			exit.addActionListener(e-> tryagain());
			
			frame3=new JFrame();
			FlowLayout flowlayout=new FlowLayout();
			frame3.setLayout(flowlayout);
			flowlayout.setVgap(50);
			flowlayout.setHgap(30);
			frame3.setTitle("ERROR");
			frame3.setSize(300, 300);
			frame3.setResizable(false);
			frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame3.add(label);
			frame3.add(exit);
			frame3.setVisible(true);
		}
		
		else //login page
		{
			frame.dispose();
			JLabel label = new JLabel();
			label.setText("LOGIN:");
			label.setFont(new Font("Castellar",Font.PLAIN,20));
			label.setPreferredSize(new Dimension(400,20));	
			label.setVerticalAlignment(JLabel.TOP);
			label.setHorizontalAlignment(JLabel.CENTER);
			
			
			JLabel label2 = new JLabel();
			label2.setText("E-Mail ID:");
			label2.setFont(new Font("Calibri",Font.PLAIN,13));
			label2.setPreferredSize(new Dimension(100,20));	
			label2.setVerticalAlignment(JLabel.TOP);
			label2.setHorizontalAlignment(JLabel.CENTER);
			mailTF=new JTextField(20);
			mailTF.setPreferredSize(new Dimension(140,20));
			mailTF.setText("");
			mailTF.setHorizontalAlignment(JTextField.CENTER);

			
			JLabel label3 = new JLabel();
			label3.setText("Password:");
			label3.setFont(new Font("Calibri",Font.PLAIN,13));
			label3.setPreferredSize(new Dimension(100,20));	
			label3.setVerticalAlignment(JLabel.TOP);
			label3.setHorizontalAlignment(JLabel.CENTER);
			passTF=new JPasswordField(20);
			passTF.setPreferredSize(new Dimension(140,20));
			passTF.setText("");
			passTF.setHorizontalAlignment(JPasswordField.CENTER);

			
			submit=new JButton("Submit");
			submit.setPreferredSize(new Dimension(90,20));
			submit.addActionListener(e->retrieve());
			
			frame2=new JFrame();
			FlowLayout flowlayout=new FlowLayout();
			frame2.setLayout(flowlayout);
			flowlayout.setVgap(50);
			flowlayout.setHgap(30);
			frame2.setTitle("LOGIN");
			frame2.setSize(400, 400);
			frame2.setResizable(false);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.add(label);
			frame2.add(label2);
			frame2.add(mailTF);
			frame2.add(label3);
			frame2.add(passTF);
			frame2.add(submit);
			frame2.setVisible(true);
			
		}
	}
	
	private void retrieve() //login
	{
		m=mailTF.getText(); //retrieve data from textboxes
		p=passTF.getPassword();
		String pass=new String(p);
		Account current=null;
		
		
			if(flag==1) //user is selected
			{
				Account user=new User();
				user.email=m;
				user.password=pass;
				current=db.login(user);
			}
			
			if(flag==2) //admin is selected
			{
				Account admin=new Admin();
				admin.email=m;
				admin.password=pass;
				current=db.login(admin);
			}

			
			if(current == null) //account not found
			{
				JLabel label = new JLabel();
				label.setText("Incorrect Credentials");
				label.setFont(new Font("Times New Roman",Font.PLAIN,15));
				label.setPreferredSize(new Dimension(100,100));	
				label.setVerticalAlignment(JLabel.TOP);
				label.setHorizontalAlignment(JLabel.LEFT);
				
				JFrame frame=new JFrame();
				FlowLayout flowlayout=new FlowLayout();
				frame.setLayout(flowlayout);
				flowlayout.setVgap(50);
				flowlayout.setHgap(30);
				frame.setTitle("LOGIN");
				frame.setSize(500, 200);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(label);
				frame.setVisible(true);
			}
			
			else
			{
				frame2.dispose();
				current.menu(db,current);
			}			
		
	}
	
	private void signup() //create new account
	{
		
		if(flag!=1 && flag!=2)
		{
			frame.dispose();
			JLabel label = new JLabel();
			label.setText("Select Admin or User");
			label.setFont(new Font("Times New Roman",Font.PLAIN,15));
			label.setPreferredSize(new Dimension(200,50));	
			label.setVerticalAlignment(JLabel.TOP);
			label.setHorizontalAlignment(JLabel.CENTER);
			
			JButton exit=new JButton("Back");
			exit.setPreferredSize(new Dimension(90,20));
			exit.addActionListener(e-> tryagain());
			
			frame3=new JFrame();
			FlowLayout flowlayout=new FlowLayout();
			frame3.setLayout(flowlayout);
			flowlayout.setVgap(50);
			flowlayout.setHgap(30);
			frame3.setTitle("ERROR");
			frame3.setSize(300, 300);
			frame3.setResizable(false);
			frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame3.add(label);
			frame3.add(exit);
			frame3.setVisible(true);
		}
		
		else 
		{
			frame.dispose();
			JLabel label = new JLabel();
			label.setText("SIGN UP:");
			label.setFont(new Font("Castellar",Font.PLAIN,20));
			label.setPreferredSize(new Dimension(400,20));	
			label.setVerticalAlignment(JLabel.TOP);
			label.setHorizontalAlignment(JLabel.CENTER);
					
			JLabel label2 = new JLabel();
			label2.setText("E-Mail ID:");
			label2.setFont(new Font("Calibri",Font.PLAIN,13));
			label2.setPreferredSize(new Dimension(100,20));	
			label2.setVerticalAlignment(JLabel.TOP);
			label2.setHorizontalAlignment(JLabel.CENTER);
			mailTF=new JTextField(20);
			mailTF.setPreferredSize(new Dimension(140,20));
			mailTF.setText("");
			mailTF.setHorizontalAlignment(JTextField.CENTER);

			
			JLabel label3 = new JLabel();
			label3.setText("Password:");
			label3.setFont(new Font("Calibri",Font.PLAIN,13));
			label3.setPreferredSize(new Dimension(100,20));	
			label3.setVerticalAlignment(JLabel.TOP);
			label3.setHorizontalAlignment(JLabel.CENTER);
			passTF=new JPasswordField(20);
			passTF.setPreferredSize(new Dimension(140,20));
			passTF.setText("");
			passTF.setHorizontalAlignment(JPasswordField.CENTER);

			
			JLabel label4 = new JLabel();
			label4.setText("Name:");
			label4.setFont(new Font("Calibri",Font.PLAIN,13));
			label4.setPreferredSize(new Dimension(100,20));	
			label4.setVerticalAlignment(JLabel.TOP);
			label4.setHorizontalAlignment(JLabel.CENTER);
			nameTF=new JTextField(20);
			nameTF.setPreferredSize(new Dimension(140,20));
			nameTF.setText("");
			nameTF.setHorizontalAlignment(JTextField.CENTER);

			
			submit=new JButton("Sign Up");
			Dimension b2=new Dimension(90,20);
			submit.setPreferredSize(b2);
			submit.addActionListener(e->signin());
			
			frame2=new JFrame();
			FlowLayout flowlayout=new FlowLayout();
			frame2.setLayout(flowlayout);
			flowlayout.setVgap(50);
			flowlayout.setHgap(30);
			frame2.setTitle("SIGN UP");
			frame2.setSize(400, 400);
			frame2.setResizable(false);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.add(label);
			frame2.add(label4);
			frame2.add(nameTF);
			frame2.add(label2);
			frame2.add(mailTF);
			frame2.add(label3);
			frame2.add(passTF);
			frame2.add(submit);
			frame2.setVisible(true);
		}

	}
	
	private void signin()
	{
		m=mailTF.getText(); //retrieve data from textboxes
		p=passTF.getPassword();
		n=nameTF.getText();
		String pass=new String(p);
		
		if(flag==1) //is user is selected
		{
			Account user=new User();
			user.email=m;
			user.name=n;
			user.password=pass;
			db.addAcc(user);
			frame2.dispose();
			user.menu(db,user);
		}
		
		if(flag==2) //is admin is selected
		{
			Account admin=new Admin();
			admin.email=m;
			admin.name=n;
			admin.password=pass;
			db.addAcc(admin);
			frame2.dispose();
			admin.menu(db,admin);
		}
		
	}
	
	private void tryagain() //is incorrect credentials are provided, this function restarts the program
	{
		frame3.dispose();
		start();
	}
	
	public static void main(String[] args)
	{
		Driver obj=new Driver(); //creaet Driver object to start execution of start method
		obj.start();
	}
}
