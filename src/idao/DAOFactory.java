package idao;
import dao.*;

public class DAOFactory {
	
	public static IStudioDAO creatStudioDAO(){
		return new StudioDAO();
	}
	public static IPlayDAO creatPlayDAO(){
		return new PlayDAO();
	}
	public static ISeatDAO creatSeatDAO(){
		return new SeatDAO();
	}
	public static IUserDAO creatUserDAO(){
		return new UserDAO();
	}
	public static IEmployeeDAO creatEmployeeDAO(){
		return new EmployeeDAO();
	}
	public static ITicketDAO creatTicketDAO(){
		return new TicketDAO();
	}
	public static ISaleDAO creatSaleDAO(){
		return new SaleDAO();
	}
	public static IDataDictDAO creatDataDictDAO(){
		return new DataDictDAO();
	}
	public static ISaleItemDAO creatSaleItemDAO(){
		return new SaleItemDAO();
	}
}
