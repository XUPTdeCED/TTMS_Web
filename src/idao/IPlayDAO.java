/**
 * 
 */
package idao;
import java.util.List;

import domain.Play;

/**
 * @author Administrator
 *
 */
public interface IPlayDAO {
	public int insert(Play play);
	public int update(Play play);
	public int delete(int ID);
	public List<Play> select(String condt); 
}
