package dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import domain.Seat;
import idao.ISeatDAO;
import util.DBUtil;

public class SeatDAO implements ISeatDAO {
	@Override
	public int insert (Seat seat) {
			String sql = "insert into seat(seat_id, studio_id, seat_row, seat_column )"
					+ " values('"
					+ seat.getId()
					+ "', "
					+ seat.getStudioId()
					+ ", " + seat.getRow()
					+ ", '" + seat.getColumn()
					+ "' )";
			DBUtil db = new DBUtil();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null ) {
				sql= "select * from seat where  studio_id = "+ seat.getStudioId() +"and seat_row = "+ seat.getRow()+" and " + "seat_column = " + seat.getColumn() ;
				ResultSet rs = db.execQuery(sql);
				try {
					while(rs.next()) {
						int n = rs.getInt("seat_id");
						seat.setId(n);		
				}
				System.out.println(seat.getId());
				return 1;
			}
		

		 catch (SQLException e) {
			e.printStackTrace();
		}
			}
			return 0;
	}

	@Override
	public int update(Seat seat) {

		String sql = "update seat set " + " studio_id =" + seat.getStudioId()
			+ ", " + " seat_row = " + seat.getRow() + ", "
			+ " seat_column = " + seat.getColumn();

		sql += " where seat_id = " + seat.getId();

		DBUtil db = new DBUtil();

		return db.execCommand(sql);

	}

	@Override
	public int delete(int ID) {
		String sql = "delete from  seat ";
		sql += " where seat_id = " + ID;
		DBUtil db = new DBUtil();
		return db.execCommand(sql);
	}

	@Override
	public List<Seat> select(String condt) {
		List<Seat> seatList = null;
		seatList=new LinkedList<Seat>();
		try {
			String sql = "select *from seat ";
			condt.trim();
			if(!condt.isEmpty())
				sql+= " where " + condt;
			DBUtil db = new DBUtil();
			ResultSet rst = db.execQuery(sql);
			System.out.print("sql:"+sql);
			if (rst!=null) {
				while(rst.next()){
					Seat seat=new Seat(rst.getInt("seat_id"),rst.getInt("studio_id"),rst.getInt("seat_row"),rst.getInt("seat_column"));
					seat.setId(rst.getInt("seat_id"));
					seat.setStudioId(rst.getInt("studio_id"));
					seat.setRow(rst.getInt("seat_row"));
					seat.setColumn(rst.getInt("seat_column"));
					seatList.add(seat);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return seatList;
	}
}
