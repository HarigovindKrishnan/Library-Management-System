package Project_code;

import java.util.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.*;
import javax.swing.*;

public class viewBooks
{
	JButton exit;
	JFrame frame;
	private File booksFile=new File("C:\\DATA\\books.dat");//file on disk to store books

	public void oper(Database db,Account acc)
	{
		List<String> text = new ArrayList<String>(); //String list to store book data
		try
		{
			BufferedReader br1 = new BufferedReader(new FileReader(booksFile));
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
		
		JTextArea textArea = new JTextArea(); //Print book data
        textArea.setEditable(false);
        for (String str : text) {
            textArea.append(str + "\n");
        }
		
		
        JLabel label = new JLabel();
		label.setText("Name         Author       Publisher       Adress       Qty         Price       Available");
		label.setFont(new Font("Times New Roman",Font.PLAIN,15));
		label.setPreferredSize(new Dimension(600,15));	
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
		frame.setTitle("View Books");
		frame.setSize(510, 500);
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
