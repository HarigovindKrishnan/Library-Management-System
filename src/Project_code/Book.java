package Project_code;

public class Book
{
	protected String name;		//title
	protected String author;		//author
	protected String publisher;	//publisher
	protected String adress;		//Collection location
	protected String status;		//Borrowing Status
	protected int qty;			//Copies available
	protected double price;		//Price
	protected int brwcopies;		//total copies
	
	public Book() {}; //empty constructor
	
	//constructor to initialize book
	public Book(String name, String author, String publisher,String adress, int qty, double price, int brwcopies)
	{
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.adress = adress;
		this.qty = qty;
		this.price = price;
		this.brwcopies = brwcopies;
	}
	
	public String toString()
	{
		String text = "Book Name: " + name+"\n"+
				"Book Author: " + author+"\n"+
				"Book Publisher: " + publisher+"\n"+
				"Book Collection Adress: " + adress+"\n"+
				"Qty: " + String.valueOf(qty)+"\n"+
				"Price: " + String.valueOf(price)+"\n"+
				"Borrowing Copies: " + String.valueOf(brwcopies);
		return text;
	}

	public String getName() //getters and setters
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getPublisher()
	{
		return publisher;
	}

	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

	public String getAdress()
	{
		return adress;
	}

	public void setAdress(String adress)
	{
		this.adress = adress;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public int getQty()
	{
		return qty;
	}

	public void setQty(int qty)
	{
		this.qty = qty;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getBrwcopies()
	{
		return brwcopies;
	}

	public void setBrwcopies(int brwcopies)
	{
		this.brwcopies = brwcopies;
	}
	
	public String toString2()// string to be saved on PC's disk
	{
		String text = name+"#"+author+"#"+publisher+"#"+adress+"#"+String.valueOf(qty)+
				"#"+String.valueOf(price)+"#"+String.valueOf(brwcopies);
		return text;
	}
}
