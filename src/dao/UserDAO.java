package dao;

import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.User;
import idao.IUserDAO;
import util.DBUtil;

public class UserDAO implements IUserDAO {
	public int insert(User user) {
			String sql = "insert into user1(user_name,user_account , user_password)"
					+ " values('"
					+ user.getName()
					+ "', '"
					+ user.getAccount()
					+ "', '" + user.getPassword()
					+ "' )";
			DBUtil db = new DBUtil();			
			ResultSet rst = db.getInsertObjectIDs(sql);			
			if ( rst!=null )
			{ 
				sql= "select * from user1 where user_name = '"+ user.getName()+"'";
				ResultSet rs = db.execQuery(sql);
				try {
					while(rs.next()) {
						int n = rs.getInt("user_ID");
						user.setID(n);			
					}
					System.out.println(user.getID());
					return 1;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		
		return 0;
	}

public int updata(User user) {
	String sql = "update user1 set " + " user_name ='" + user.getName()
		+ "', " + " user_account = '" + user.getAccount() + "', "
		+ " user_password = '" + user.getPassword()+ "'";
	sql +="where user_ID = "+ user.getID();
	DBUtil db = new DBUtil();

	return db.execCommand(sql);
}
public int delete(int ID) {
	String sql = "delete from user1";
	sql += "where user_ID="+ID;
	DBUtil db = new DBUtil();
	return db.execCommand(sql);
}
public List<User> select(String condt){
	List<User> userList = null;
	userList = new LinkedList<User>();
	try {
		String sql = "select * from user1 ";
		condt.trim();	
		if(!condt.isEmpty()) {
			sql+="where "+condt;
		}
		System.out.println(sql);
		DBUtil db = new DBUtil();
		ResultSet rst = db.execQuery(sql);
		if( rst !=null) {
			while(rst.next()) {
				User user = new User();
				user.setID(rst.getInt("user_ID"));
				user.setName(rst.getString("user_name"));
				user.setAccount(rst.getString("user_account"));
				user.setPassword(rst.getString("user_password"));
				userList.add(user);
			}
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return userList;
}

}
