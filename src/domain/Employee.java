package domain;

import java.io.Serializable;

public class Employee implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * create table employee
    (
        emp_id               int not null auto_increment,
        emp_no               char(20) not null,
        emp_name             varchar(100) not null,
        emp_tel_num          char(20),
        emp_addr             varchar(200),
        emp_email            varchar(100),
         primary key (emp_id)
      );
	 * 
	 * 
	 */
	
	private int id;
	private String no;
	private String name;
	private String telNum;
	private String address;
	private String email;

	public Employee(int id, String no, String name, String telNum,
			String address, String email) {
		super();
		this.id = id;
		this.no = no;
		this.name = name;
		this.telNum = telNum;
		this.address = address;
		this.email = email;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void showValue() {
		System.out.println("编号：" + id + "\t姓名：" + name);
	}

}
