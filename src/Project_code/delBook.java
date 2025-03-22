package Project_code;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class delBook
{
	//global attributes
	JFrame frame=new JFrame();
	JTextField name=new JTextField();
	public void oper(Database db,Account acc)//function to perform delete book operation
	{
		JLabel label = new JLabel();
		label.setText("Delete Book");
		label.setFont(new Font("Castellar",Font.PLAIN,20));
		label.setPreferredSize(new Dimension(400,20));	
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label2 = new JLabel();
		label2.setText("Book Name:");
		label2.setFont(new Font("Calibri",Font.PLAIN,13));
		label2.setPreferredSize(new Dimension(100,20));	
		label2.setVerticalAlignment(JLabel.TOP);
		label2.setHorizontalAlignment(JLabel.CENTER);
		name=new JTextField(20);
		name.setPreferredSize(new Dimension(140,20));
		name.setText("");
		name.setHorizontalAlignment(JTextField.CENTER);
		
		JButton submit=new JButton("Submit");
		submit.setPreferredSize(new Dimension(90,20));
		submit.addActionListener(e->delete(db,acc));
		
		JButton exit=new JButton("Back");
		exit.setPreferredSize(new Dimension(90,20));
		exit.addActionListener(e-> back(db,acc));
		
		frame=new JFrame(); //frame to enter book name
		FlowLayout flowlayout=new FlowLayout();
		frame.setLayout(flowlayout);
		flowlayout.setVgap(50);
		flowlayout.setHgap(30);
		frame.setTitle("Delete Book");
		frame.setSize(400, 400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label);
		frame.add(label2);
		frame.add(name);
		frame.add(submit);
		frame.add(exit);
		frame.setVisible(true);
	}
	
	private void delete(Database db,Account acc)
	{
		frame.dispose();
		db.removeBook(name.getText(),db,acc);//calls removebook function of database
	}
	
	private void back(Database db,Account acc) //go back to menu
	{
		frame.dispose();
		acc.menu(db,acc);
	}
}
