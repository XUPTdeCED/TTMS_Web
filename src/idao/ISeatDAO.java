/**
 * 
 */
package idao;
import domain.*;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface ISeatDAO {
	public int insert(Seat seat);
	public int update(Seat seat);
	public int delete(int id);
	public List<Seat> select(String condt); 
}
