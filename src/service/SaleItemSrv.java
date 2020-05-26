package service;

import java.util.List;

import domain.SaleItem;
import idao.*;

public class SaleItemSrv {
	private ISaleItemDAO saleItemDAO=DAOFactory.creatSaleItemDAO();
	
	public int add(SaleItem saleItem){
		return saleItemDAO.insert(saleItem); 		
	}
	
	public int modify(SaleItem saleItem){
		return saleItemDAO.update(saleItem); 		
	}
	
	public int delete(int ID){
		return saleItemDAO.delete(ID); 		
	}
	
	public List<SaleItem> Fetch(String condt){
		return saleItemDAO.select(condt);		
	}
	
	public List<SaleItem> FetchAll(){
		return saleItemDAO.select("");		
	}
}
