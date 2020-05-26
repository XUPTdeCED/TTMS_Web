package service;

import java.util.List;

import domain.Ticket;
import idao.*;

public class TicketSrv {
	private ITicketDAO ticDAO=DAOFactory.creatTicketDAO();
	
	public int add(Ticket tic){
		return ticDAO.insert(tic); 		
	}
	
	public int modify(Ticket tic){
		return ticDAO.update(tic); 		
	}
	
	public int delete(int ID){
		return ticDAO.delete(ID); 		
	}
	
	public List<Ticket> Fetch(String condt){
		return ticDAO.select(condt);		
	}
	
	public List<Ticket> FetchAll(){
		return ticDAO.select("");		
	}
}
