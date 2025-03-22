package Project_code;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Borrow
{
	//global variables
	Book book;
	Account account;
	LocalDate start;
	LocalDate end;
	int daysleft;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //format in which date must be saved
	
	public Borrow(Book b, Account a)
	{
		start = LocalDate.now();
		end = start.plusDays(14);
		daysleft = Period.between(start, end).getDays();
		book = b;
		account = a;
	}
	
	public Borrow(Book b, Account a,LocalDate start, LocalDate finish)//constructor to initialize borrow

	{
		this.start = start;
		this.end = finish;
		this.daysleft = Period.between(finish, LocalDate.now()).getDays();
		book = b;
		account = a;
	}

	public Borrow() //empty constructor
	{
	}
	

	public LocalDate getStart()
	{
		return start;
	}

	public void setStart(LocalDate start)
	{
		this.start = start;
	}

	public LocalDate getEnd()
	{
		return end;
	}

	public void setEnd(LocalDate end)
	{
		this.end = end;
	}

	public int getDaysleft()
	{
		return daysleft;
	}

	public void setDaysleft(int daysleft)
	{
		this.daysleft = daysleft;
	}

	public Book getBook() {
		return book;
	}

	public void setBook1(Book book)
	{
		this.book = book;
	}

	public Account getAccount()
	{
		return account;
	}

	public void setAccount(Account account)
	{
		this.account = account;
	}

	public String toString2()
	{
		String n=book.name;
		return n+"#"+account.name+"#"+getStart()+"#"+getEnd();
	}
	
	
}
