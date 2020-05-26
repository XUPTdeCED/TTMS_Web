/**

 * 
 */
package idao;
import java.util.List;


import domain.Sale;

/**
 * @author Administrator
 *
 */
public interface ISaleDAO {
	public int insert(Sale sale);
	public int update(Sale sale);
	public int delete(int ID);
	public List<Sale> select(String condt); 
}
