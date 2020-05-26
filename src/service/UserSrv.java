package service;

import java.util.List;

import domain.User;
import idao.*;

public class UserSrv {
	private IUserDAO userDAO =DAOFactory.creatUserDAO();
	public int add(User user) {
		return userDAO.insert(user);
	}
	public int modify(User user) {
		return userDAO.updata(user);
	}
	public int delete(int ID) {
		return userDAO.delete(ID);
	}
	public List<User> Fetch(String condt){
		return userDAO.select(condt);
	}
	public List<User> FetchAll(){
		return userDAO.select("");
	}
}
