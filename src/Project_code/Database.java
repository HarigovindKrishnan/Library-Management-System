package Project_code;

import java.awt.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.util.*;
import javax.swing.*;

public class Database
{
	HashMap<String, Account> accMap = new HashMap<>(); //create hashmap to store Account objects
	HashMap<String, Book> bookMap = new HashMap<>(); //create hashmap to store Book objects
	private ArrayList<Borrow> borrowList=new ArrayList<>(); //create array to store Borrow objects
	private File accountsFile=new File("C:\\DATA\\accounts.dat"); //create files on disk to store data
	private File booksFile=new File("C:\\DATA\\books.dat");
	private File borrowFile=new File("C:\\DATA\\borrows.dat");


	public Database() //constructor that creates files on disk if they already do not exist
	{
		if (!accountsFile.exists())
		{
			try
			{
				accountsFile.createNewFile();
			} catch (Exception e) {}
		}
		if (!booksFile.exists())
		{
			try
			{
				booksFile.createNewFile();
			} catch (Exception e) {}
		}
		
		if (!borrowFile.exists())
		{
			try
			{
				borrowFile.createNewFile();
			} catch (Exception e) {}
		}
		
		
		getAccs(); //load data from files to the data structure(hashaps and list)
		getBooks();
		getBorrow();
	}
	
//-------------------------------------------------------------------------------------
	public void addAcc(Account acc) //add new object to account hashmap
	{
		accMap.put(acc.email,acc);
		saveAcc();
		for (String key : accMap.keySet())
		{
		    System.out.println("Key: " + key + ", Value: " + accMap.get(key));
		}
	}
	
	public void addBook(Book book) //add new object to book hashmap
	{
		if(bookMap.get(book.name)==null)
		{
			bookMap.put(book.name,book);
			saveBook();
		}
		
		else
		{
			JLabel label = new JLabel();
			label.setFont(new Font("Times New Roman",Font.PLAIN,15));
			label.setPreferredSize(new Dimension(125,50));	
			label.setVerticalAlignment(JLabel.TOP);
			label.setHorizontalAlignment(JLabel.LEFT);
			label.setText("Book already exists");
			
			JFrame frame=new JFrame();
			FlowLayout flowlayout=new FlowLayout();
			frame.setLayout(flowlayout);
			flowlayout.setVgap(50);
			flowlayout.setHgap(30);
			frame.setTitle("LOGIN");
			frame.setSize(300, 200);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(label);
			frame.setVisible(true);
			
		}
		
		for (String key : bookMap.keySet())
		{
		    System.out.println("Key: " + key + ", Value: " + bookMap.get(key));
		}
	}
	
	public void addBorrow(Borrow b,Book boo,int q) //add new object to borrow list
	{
		borrowList.add(b);
		bookMap.get(boo.name).setQty(q);
		saveBorrow();
		saveBook();
	}
//--------------------------------------------------------------------------------------
	private void saveAcc()//save the newly added object of hashmap to the file on disk
	{
		String list="";
		for (String key : accMap.keySet())
		{
			list=list+accMap.get(key).toString()+"Next\n";
		}
		try
		{
			PrintWriter pw = new PrintWriter(accountsFile);
			pw.print(list);
			pw.close();
		}
		catch  (Exception e)
		{
			System.err.println(e.toString());
		}
	}
	
	
	private void saveBook() //save the newly added object of hashmap to the file on disk
	{
		String list="";
		for (String key : bookMap.keySet())
		{
			list=list+bookMap.get(key).toString2()+"Next\n";
		}
		try
		{
			PrintWriter pw = new PrintWriter(booksFile);
			pw.print(list);
			pw.close();
		}
		catch  (Exception e)
		{
			System.err.println(e.toString());
		}
	}
	
	private void saveBorrow() //save the newly added object of list to the file on disk
	{
		String list="";
		for (int i=0;i<borrowList.size();i++)
		{
			list=list+borrowList.get(i).toString2()+"Next\n";
		}
		try
		{
			PrintWriter pw = new PrintWriter(borrowFile);
			pw.print(list);
			pw.close();
		}
		catch  (Exception e)
		{
			System.err.println(e.toString());
		}
	}
//--------------------------------------------------------------------------------------
	
	private void getAccs() //load data from file to hashmap
	{
		String text1 = "";
		try
		{
			BufferedReader br1 = new BufferedReader(new FileReader(accountsFile));
			String s1;
			while ((s1 = br1.readLine()) !=null)
			{
				text1 = text1 + s1;
			}
			br1.close();
		}
		catch (Exception e)
		{
			System.err.println(e.toString());
		}
		
		if (!text1.matches("") || !text1.isEmpty())
		{
			String[] a1 = text1.split("Next"); //splitting object info based on format we already set
			for (String s : a1)
			{
				String[] a2 = s.split("#");
				if (a2[3].matches("Admin"))
				{
					Account acc = new Admin();
					acc.name=a2[0];
					acc.email=a2[1];
					acc.password=a2[2];
					accMap.put(acc.email,acc);
				}
				else
				{
					Account acc = new User();
					acc.name=a2[0];
					acc.email=a2[1];
					acc.password=a2[2];
					accMap.put(acc.email,acc);
				}
			}
		}
	}
	
	
	private void getBooks()
	{
		String text1 = "";
		try
		{
			BufferedReader br1 = new BufferedReader(new FileReader(booksFile));
			String s1;
			while ((s1 = br1.readLine()) !=null)
			{
				text1 = text1 + s1;
			}
			br1.close();
		}
		catch (Exception e)
		{
			System.err.println(e.toString());
		}
		
		if (!text1.matches("") || !text1.isEmpty())
		{
			String[] a1 = text1.split("Next");
			for (String s : a1)
			{
				String[] a2 = s.split("#");
				Book boo = new Book();
				boo.name=a2[0];
				boo.author=a2[1];
				boo.publisher=a2[2];
				boo.adress=a2[3];
				boo.qty=Integer.valueOf(a2[4]);
				boo.price=Double.valueOf(a2[5]);
				boo.brwcopies=Integer.valueOf(a2[6]);
				bookMap.put(boo.name,boo);
			}
		}
	}
	
	
	private void getBorrow()
	{
		String text1 = "";
		try
		{
			BufferedReader br1 = new BufferedReader(new FileReader(borrowFile));
			String s1;
			while ((s1 = br1.readLine()) !=null)
			{
				text1 = text1 + s1;
				System.out.println("text: "+text1);
			}
			br1.close();
		}
		catch (Exception e)
		{
			System.err.println(e.toString());
		}
		
		if (!text1.isEmpty())
		{
			String[] a1 = text1.split("Next");
			for (String s : a1)
			{
				String[] a2 = s.split("#");
				System.out.println("DATE: "+LocalDate.now());
				Borrow brw=new Borrow(bookMap.get(a2[0]),accMap.get(a2[1]),LocalDate.parse(a2[2]),LocalDate.parse(a2[3]));
				borrowList.add(brw);
			}
		}
	}
//--------------------------------------------------------------------------------------	
	
	public void removeBook(String s,Database db,Account acc) //function to remove book from book hashmap
	{
		JFrame frame=new JFrame();
		FlowLayout flowlayout=new FlowLayout();
		frame.setLayout(flowlayout);
		flowlayout.setVgap(50);
		flowlayout.setHgap(30);
		frame.setTitle("LOGIN");
		frame.setSize(300, 200);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel();
		label.setFont(new Font("Times New Roman",Font.PLAIN,15));
		label.setPreferredSize(new Dimension(125,50));	
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.LEFT);
		
		JButton submit=new JButton("Back");
		submit.setPreferredSize(new Dimension(90,20));
		submit.addActionListener(e->acc.menu(db,acc));
		
		if(bookMap.get(s)!=null)
		{
			bookMap.remove(s); //remove object from hashmap
			label.setText("Book Removed!");
		}
		
		else
		{
			label.setText("Book not found!");
		}
		
		frame.add(label);
		frame.add(submit);
		frame.setVisible(true);
	}
	
	public Book srchbook(String s) //searches book object using the name as key and returns the book object
	{
		Book b=bookMap.get(s);
		return b;
	}
	
	public int checkborrow(String aname,String bname)//check if the object corresponding to input parameters exists in the list
	{
		int n=0;
		int flag=0;
		for(Borrow brw : borrowList)
		{
			n++;
			if( bname.equals(brw.book.name) && aname.equals(brw.account.name))
			{
				borrowList.remove(brw);
				int q=bookMap.get(brw.book.name).getQty();
				bookMap.get(brw.book.name).setQty(q+1);
				saveBook();
				saveBorrow();
				return n;
			}
		}
		return -1;		
	}
	
	public Borrow checkborrowexists(String aname,String bname)
	{
		int flag=0;
		for(Borrow brw : borrowList)
		{
			if( bname.equals(brw.book.name) && aname.equals(brw.account.name))
			{
				return brw;
			}
		}
		return null;
				
	}
//--------------------------------------------------------------------------------------	
	public Account login(Account acc)//login
	{
		Account temp=accMap.get(acc.email);
		if(temp==null || !accMap.get(acc.email).password.equals(acc.password))
		{
			return temp;
		}
		
		if(accMap.get(acc.email).password.equals(acc.password))
		{
			return temp;
		}
	
		return temp;		
	}
		
}
