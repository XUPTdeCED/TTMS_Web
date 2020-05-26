/**

 * 
 */
package idao;
import java.util.List;


import domain.SaleItem;

/**
 * @author Administrator
 *
 */
public interface ISaleItemDAO {
	public int insert(SaleItem saleItem);
	public int update(SaleItem saleItem);
	public int delete(int ID);
	public List<SaleItem> select(String condt); 
}
