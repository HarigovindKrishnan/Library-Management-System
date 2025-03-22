package Project_code;

abstract public class Account
{
	protected String name; //name of account holder
	protected String email; 
	protected String password;
	
	
	
	public String getName() //getters and setters
	{
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	abstract public void menu(Database db,Account acc); //method to be overridden
	abstract public String toString(); //method to be overridden
}
