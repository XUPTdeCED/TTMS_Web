package dao;

import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Employee;
import idao.IEmployeeDAO;
import util.DBUtil;

public class EmployeeDAO implements IEmployeeDAO {
	@Override
	public int insert(Employee emp) {
		try {
			String sql = "insert into studio(emp_id, emp_no, emp_name,emp_tel_num,emp_addr,emp_email )"
					+ " values('"
					+ emp.getId()
					+ "', "+ emp.getNo()
					+ ", " + emp.getName() 
					+ ", '" + emp.getTelNum()
					+ ", '" + emp.getAddress()
					+ ", '" + emp.getEmail()
					+ "' )";
			DBUtil db = new DBUtil();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				emp.setId(rst.getInt(1));
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(Employee emp) {

		String sql = "update employee set " +" emp_no = " + emp.getNo() 
				+ " emp_name ='" + emp.getName()
				+ "', " + " emp_tel_num = " + emp.getTelNum() 
				+ ",  " + " emp_addr = " + emp.getAddress() 
				+ ",  " + " emp_email = '" + emp.getEmail() + "' ";

		sql += " where emp_id = " + emp.getId();

		DBUtil db = new DBUtil();

		return db.execCommand(sql);

	}

	@Override
	public int delete(int ID) {
		String sql = "delete from  studio ";
		sql += " where studio_id = " + ID;
		DBUtil db = new DBUtil();
		return db.execCommand(sql);
	}

	@Override
	public List<Employee> select(String condt) {
		List<Employee> empList = null;
		empList=new LinkedList<Employee>();
		try {
			String sql = "select emp_id,emp_no,emp_name,emp_tel_num,emp_addr,emp_email from employee ";
			condt.trim();
			if(!condt.isEmpty())
				sql+= " where " + condt;
			DBUtil db = new DBUtil();
			ResultSet rst = db.execQuery(sql);
			//System.out.print("sql:"+sql);
			if (rst!=null) {
				while(rst.next()){
					Employee emp=new Employee();
					emp.setId(rst.getInt("emp_id"));
					emp.setNo(rst.getString("emp_no"));
					emp.setName(rst.getString("emp_name"));
					emp.setTelNum(rst.getString("emp_Tel_Num"));
					emp.setAddress(rst.getString("emp_addr"));
					emp.setEmail(rst.getString("emp_email"));
					empList.add(emp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empList;
	}
}
