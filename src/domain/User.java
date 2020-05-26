package domain;

public class User {
	private int id = 0;
	private String name="";
	private String account="";
	private String password="";
	
	
	public User(){
		
	}
	
	public User(int id, String name,String account,String password){
		super();
		this.id=id;
		this.name=name;
		this.account=account;
		this.password=password;
	}
	public void setID(int ID) {
		this.id=ID;
	}
	public int getID() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public void setAccount(String account) {
		this.account=account;
	}
	public String getAccount() {
		return account;
	}
}
