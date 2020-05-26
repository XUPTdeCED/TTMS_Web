package domain;

import  java.sql.Date;

public class Sale {
	/*==============================================================
	create table sale
	(
	   sale_ID              bigint not null auto_increment,
	   emp_id               int,
	   sale_time            datetime,
	   sale_payment         decimal(10,2),
	   sale_change          numeric(10,2),
	   sale_type            smallint comment '类别取值含义：
	            1：销售单
	            -1：退款单',
	   sale_status          smallint comment '销售单状态如下：
	            0：代付款
	            1：已付款',
	   primary key (sale_ID)
	); 
	==============================================================*/
	
	private int id;
	private int empId;
	private Date time ;  // ?? 查看datetime对应的java类型
	private float payment;
	private float change;
	private int type;
	private int status;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public float getPayment() {
		return payment;
	}
	public void setPayment(float payment) {
		this.payment = payment;
	}
	public float getChange() {
		return change;
	}
	public void setChange(float change) {
		this.change = change;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
