package Project_code;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class viewBorrow
{
	JButton exit;
	JFrame frame;
	private File borrowsFile=new File("C:\\DATA\\borrows.dat");//create file on disk

	public void oper(Database db,Account acc)
	{
		List<String> text = new ArrayList<String>(); //String list to store borrowing data
		try
		{
			BufferedReader br1 = new BufferedReader(new FileReader(borrowsFile));
			String s1;
			while ((s1 = br1.readLine()) != null)
			{
				String s2 = s1.replace("#","\t");
				String s3 = s2.replace("Next","");
				text.add(s3);
				
			}
			br1.close();
		}
		catch (Exception e)
		{
			System.err.println(e.toString());
		}
		
		JTextArea textArea = new JTextArea();//Print book data
        textArea.setEditable(false);
        for (String str : text) {
            textArea.append(str + "\n");
        }
		
		
        JLabel label = new JLabel();
		label.setText("Book        User           From date    Due date");
		label.setFont(new Font("Times New Roman",Font.PLAIN,15));
		label.setPreferredSize(new Dimension(500,15));	
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.CENTER);
        
        exit=new JButton("Back");
		exit.setPreferredSize(new Dimension(90,20));
		exit.addActionListener(e-> back(db,acc));
		
        frame=new JFrame();
		FlowLayout flowlayout=new FlowLayout();
		frame.setLayout(flowlayout);
		flowlayout.setVgap(50);
		flowlayout.setHgap(30);
		frame.setTitle("View Borrows");
		frame.setSize(450, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label);
		frame.add(new JScrollPane(textArea));
		frame.add(exit);
		frame.setVisible(true);

	}
	
	private void back(Database db,Account acc)
	{
		frame.dispose();
		acc.menu(db,acc);
	}



}
