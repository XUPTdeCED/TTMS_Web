/**
 * 
 */
package idao;
import java.util.List;

import domain.Ticket;

/**
 * @author Administrator
 *
 */
public interface ITicketDAO {
	public int insert(Ticket tic);
	public int update(Ticket tic);
	public int delete(int Id);
	public List<Ticket> select(String condt); 
}
