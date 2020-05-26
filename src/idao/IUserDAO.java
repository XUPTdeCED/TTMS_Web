package idao;
import java.util.List;

import domain.User;

public interface IUserDAO {
	public int insert(User user);
	public int updata(User user);
	public int delete(int ID);
	public List<User> select(String condt);
}
