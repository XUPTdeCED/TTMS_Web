package domain;

public class Ticket {

	/*==============================================================
	create table ticket
	(
	   ticket_id            bigint not null auto_increment,
	   seat_id              int,
	   sched_id             int,
	   ticket_price         numeric(10,2),
	   ticket_status        smallint comment '�������£�
	            0��������
	            1������
	            9������',
	   primary key (ticket_id)
	);
	
	==============================================================*/
	
	private int id;
	private int seatId;
	private int scheduleId;
	private float price;
	private int status;
	
	
	public Ticket(int id, int seatId, int scheduleId, float price, int status) {
		super();
		this.id = id;
		this.seatId = seatId;
		this.scheduleId = scheduleId;
		this.price = price;
		this.status = status;
	}
	
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
