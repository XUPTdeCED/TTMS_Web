package dao;

import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Ticket;
import idao.ITicketDAO;
import util.DBUtil;

public  class TicketDAO implements ITicketDAO {
	@Override
	public int insert(Ticket tic) {
		try {
			String sql = "insert into ticket(ticket_id, seat_id, sched_id, ticket_price,  ticket_status)"
					+ " values('"
					+ tic.getId()
					+ "', "
					+ tic.getSeatId()
					+ ", " + tic.getScheduleId() 
					+ ", '" + tic.getPrice()
					+ "'.'"+ tic.getStatus()
					+ "' )";
			DBUtil db = new DBUtil();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				tic.setId(rst.getInt(1));
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(Ticket tic) {

		String sql = "update ticket set " + " ticket_id ='" + tic.getId()
				+ "', " + " seat_id = " + tic.getSeatId() + ", "
				+ " sched_id = " + tic.getScheduleId() + ", "
				+ " ticket_price = '" + tic.getPrice() + ","
				+ "ticket_status  = " + tic.getStatus() + " ";

		sql += " where ticket_id = " + tic.getId();

		DBUtil db = new DBUtil();

		return db.execCommand(sql);

	}

	@Override
	public int delete(int ID) {
		String sql = "delete from  ticket ";
		sql += " where ticket_id = " + ID;
		DBUtil db = new DBUtil();
		return db.execCommand(sql);
	}

	@Override
	public List<Ticket> select(String condt) {
		List<Ticket> ticList = null;
		ticList=new LinkedList<Ticket>();
		try {
			String sql = "select ticket_id, seat_id, sched_id, ticket_price,  ticket_status ";
			condt.trim();
			if(!condt.isEmpty())
				sql+= " where " + condt;
			DBUtil db = new DBUtil();
			ResultSet rst = db.execQuery(sql);
			//System.out.print("sql:"+sql);
			if (rst!=null) {
				while(rst.next()){
					Ticket tic=new Ticket();
					tic.setId(rst.getInt("ticket_id"));
					tic.setSeatId(rst.getInt("seat_id"));
					tic.setScheduleId(rst.getInt("sched_id"));
					tic.setPrice(rst.getFloat("ticket_price"));
					tic.setStatus(rst.getInt("ticket_status"));
					ticList.add(tic);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ticList;
	}
}
