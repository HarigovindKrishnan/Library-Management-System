package Project_code;

import java.awt.*;
import javax.swing.*;

public class login
{
	JTextField mailTF;
	JTextField passTF;
	JButton submit;
	String m;
	char[] p;
	int status;
	
	public login(int flag)
	{
		status=flag;
		
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
		JTextField mailTF=new JTextField(20);
		mailTF.setPreferredSize(new Dimension(140,20));
		mailTF.setText("");
		mailTF.setHorizontalAlignment(JTextField.CENTER);
		mailTF.addActionListener(e->m=mailTF.getText());
		
		JLabel label3 = new JLabel();
		label3.setText("Password:");
		label3.setFont(new Font("Calibri",Font.PLAIN,13));
		label3.setPreferredSize(new Dimension(100,20));	
		label3.setVerticalAlignment(JLabel.TOP);
		label3.setHorizontalAlignment(JLabel.CENTER);
		JPasswordField passTF=new JPasswordField(20);
		passTF.setPreferredSize(new Dimension(140,20));
		passTF.setText("");
		passTF.setHorizontalAlignment(JPasswordField.CENTER);
		passTF.addActionListener(e-> p=passTF.getPassword());
		
		JButton submit=new JButton("Submit");
		Dimension b2=new Dimension(90,20);
		submit.setPreferredSize(b2);
		submit.addActionListener(e->retrieve());
		
		JFrame frame2=new JFrame();
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
	
	private void retrieve()
	{
		String pass=new String(p);
		
		if(status==1)
		{
			User user=new User();
			user.email=m;
			user.password=pass;
			user.check();
		}
		
		
	}
}
