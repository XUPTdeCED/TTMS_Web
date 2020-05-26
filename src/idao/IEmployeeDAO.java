package idao;
import domain.*;

import java.util.List;


/**
 * @author Administrator
 *
 */
public interface IEmployeeDAO {
	public int insert(Employee emp);
	public int update(Employee emp);
	public int delete(int id);
	public List<Employee> select(String condt); 
}
