package dao;

import java.util.LinkedList;

import java.util.List;

import domain.Sale;
import idao.ISaleDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBUtil;

public class SaleDAO implements ISaleDAO {
	@Override
	public int insert(Sale sale) {
		try {
			String sql = "insert into sale(sale_ID, emp_id, sale_name, sale_payment,sale_change,sale_type,sale_status )"
					+ " values('"
					+ sale.getId()
					+ "', "
					+ sale.getId()
					+ ", " + sale.getTime()
					+ ", " + sale.getPayment()
					+ ", " + sale.getChange()
					+ ", " + sale.getType()
					+ ", '" + sale.getStatus()
					+ "' )";
			DBUtil db = new DBUtil();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				sale.setId(rst.getInt(1));
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int update(Sale sale) {

		String sql = "update sale set " + " sale_ID ='" + sale.getId()
				+ "', " + " emp_id = " + sale.getId() + ", "
				+ " sale_time = " + sale.getTime() + ", "
				+ " sale_payment = " + sale.getPayment() + ", "
				+ " sale_change = " + sale.getChange() + ", "
				+ " sale_type = " + sale.getType() + ", "
				+ " sale_status = '" + sale.getStatus() + "' ";

		sql += " where sale_id = " + sale.getId();

		DBUtil db = new DBUtil();

		return db.execCommand(sql);

	}
	
	@Override
	public int delete(int Id) {
		String sql = "delete from  sale ";
		sql += " where sale_id = " + Id;
		DBUtil db = new DBUtil();
		return db.execCommand(sql);
	}

	@Override
	public List<Sale> select(String condt) {
		List<Sale> saleList = null;
		saleList=new LinkedList<Sale>();
		try {
			String sql = "select sale_id, emp_id, sale_time, sale_payment, sale_change,sale_type,sale_status from sale ";
			condt.trim();
			if(!condt.isEmpty())
				sql+= " where " + condt;
			DBUtil db = new DBUtil();
			ResultSet rst = db.execQuery(sql);
			//System.out.print("sql:"+sql);
			if (rst!=null) {
				while(rst.next()){
					Sale sale=new Sale();
					sale.setId(rst.getInt("sale_id"));
					sale.setEmpId(rst.getInt("emp_id"));
					sale.setTime(rst.getDate("sale_time"));
					sale.setPayment(rst.getFloat("sale_payment"));
					sale.setChange(rst.getFloat("sale_change"));
					sale.setType(rst.getInt("sale_type"));
					sale.setStatus(rst.getInt("sale_status"));
					saleList.add(sale);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return saleList;
	}
}
