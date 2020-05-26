package dao;

import java.util.LinkedList;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Play;
import idao.IPlayDAO;
import util.DBUtil;

public class PlayDAO implements IPlayDAO {
	@Override
	public int insert(Play play) {
		try {
			String sql = "insert into play(play_name, play_introduction, play_image, play_length, play_ticketPrice, play_status )"
					+ " values('"
					+ play.getName() 
					+ "', " + play.getIntroduction()
					+ "', " + play.getImage()
					+ "', " + play.getLength()
					+ "', " + play.getTicketPrice()
					+ "', " + play.getStatus()
					+ "' )";
			DBUtil db = new DBUtil();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				play.setId(rst.getInt(1));
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(Play play) {

		String sql = "update play set " + " play_name ='" + play.getName()
				+ "', " + " play_introduction = " + play.getIntroduction() + ", "
				+ " play_image = " + play.getImage() + ", "
				+ " play_length = '" + play.getLength() + ", "
				+ " play_ticketPrice = '" + play.getTicketPrice() + ", "
				+ " play_status = '" + play.getStatus() + "' ";

		sql += " where play_id = " + play.getId();

		DBUtil db = new DBUtil();

		return db.execCommand(sql);

	}

	@Override
	public int delete(int Id) {
		String sql = "delete from  play ";
		sql += " where play_id = " + Id;
		DBUtil db = new DBUtil();
		return db.execCommand(sql);
	}

	@Override
	public List<Play> select(String condt) {
		List<Play> playList = null;
		playList=new LinkedList<Play>();
		try {
			String sql = "select play_id, play_name, play_introduction, play_image, play_length, play_ticketPrice, play_status from play ";
			condt.trim();
			if(!condt.isEmpty())
				sql+= " where " + condt;
			DBUtil db = new DBUtil();
			ResultSet rst = db.execQuery(sql);
			//System.out.print("sql:"+sql);
			if (rst!=null) {
				while(rst.next()){
					Play play=new Play();
					play.setId(rst.getInt("play_id"));
					play.setName(rst.getString("play_name"));
					play.setIntroduction(rst.getString("play_introduction"));
					play.setImage(rst.getString("play_image"));
					play.setLength(rst.getInt("play_length"));
					play.setTicketPrice(rst.getInt("play_ticketPrice"));
					play.setStatus(rst.getInt("play_status"));
					playList.add(play);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return playList;
	}
}
