package service;

import java.util.List;

import domain.Seat;
import idao.*;

public class SeatSrv {
	private ISeatDAO seatDAO=DAOFactory.creatSeatDAO();
	
	public int add(Seat seat){
		return seatDAO.insert(seat); 		
	}
	
	public int modify(Seat seat){
		return seatDAO.update(seat); 		
	}
	
	public int delete(int seatid){
		return seatDAO.delete(seatid); 		
	}
	
	public List<Seat> Fetch(String condt){
		return seatDAO.select(condt);		
	}
	
	public List<Seat> FetchAll(){
		return seatDAO.select("");		
	}
}
