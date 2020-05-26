package service;

import java.util.List;

import domain.DataDict;
import idao.*;

public class DataDictSrv {
	private IDataDictDAO dictDAO=DAOFactory.creatDataDictDAO();
	
	public int add(DataDict dict){
		return dictDAO.insert(dict); 		
	}
	
	public int modify(DataDict dict){
		return dictDAO.update(dict); 		
	}
	
	public int delete(int ID){
		return dictDAO.delete(ID); 		
	}
	
	public List<DataDict> Fetch(String condt){
		return dictDAO.select(condt);		
	}
	
	public List<DataDict> FetchAll(){
		return dictDAO.select("");		
	}
}
