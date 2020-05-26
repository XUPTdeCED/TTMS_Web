/**

 * 
 */
package idao;
import java.util.List;


import domain.DataDict;

/**
 * @author Administrator
 *
 */
public interface IDataDictDAO {
	public int insert(DataDict dict);
	public int update(DataDict dict);
	public int delete(int ID);
	public List<DataDict> select(String condt); 
}
