package service;

import java.util.List;

import domain.Employee;
import idao.*;

public class EmployeeSrv {
	private IEmployeeDAO empDAO=DAOFactory.creatEmployeeDAO();
	
	public int add(Employee emp){
		return empDAO.insert(emp); 		
	}
	
	public int modify(Employee emp){
		return empDAO.update(emp); 		
	}
	
	public int delete(int Id){
		return empDAO.delete(Id); 		
	}
	
	public List<Employee> Fetch(String condt){
		return empDAO.select(condt);		
	}
	
	public List<Employee> FetchAll(){
		return empDAO.select("");		
	}
}
