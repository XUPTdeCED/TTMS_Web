package dao;

import java.util.LinkedList;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.SaleItem;
import idao.ISaleItemDAO;
import util.DBUtil;

public class SaleItemDAO implements ISaleItemDAO {
	public int insert(SaleItem saleItem) {
		try {
			String sql = "insert into saleItem(sale_item_id, ticket_id, sale_ID, sale_item_price )"
					+ " values('"
					+ saleItem.getId()
					+ "', "
					+ saleItem.getTicketId()
					+ ", " + saleItem.getSaleId() 
					+ ", '" + saleItem.getPrice()
					+ "' )";
			DBUtil db = new DBUtil();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				saleItem.setId(rst.getInt(1));
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(SaleItem saleItem) {

		String sql = "update saleItem set " + " sale_item_id ='" + saleItem.getId()
				+ "', " + " ticket_id = " + saleItem.getTicketId() + ", "
				+ " sale_Id = " + saleItem.getSaleId() + ", "
				+ " sale_item_price = '" + saleItem.getPrice() + "' ";

		sql += " where saleItem_id = " + saleItem.getId();

		DBUtil db = new DBUtil();

		return db.execCommand(sql);

	}

	@Override
	public int delete(int Id) {
		String sql = "delete from  saleItem ";
		sql += " where saleItem_id = " + Id;
		DBUtil db = new DBUtil();
		return db.execCommand(sql);
	}

	@Override
	public List<SaleItem> select(String condt) {
		List<SaleItem> saleItemList = null;
		saleItemList=new LinkedList<SaleItem>();
		try {
			String sql = "select sale_item_id, ticket_id, sale_ID, sale_item_price ";
			condt.trim();
			if(!condt.isEmpty())
				sql+= " where " + condt;
			DBUtil db = new DBUtil();
			ResultSet rst = db.execQuery(sql);
			//System.out.print("sql:"+sql);
			if (rst!=null) {
				while(rst.next()){
					SaleItem saleItem=new SaleItem();
					saleItem.setId(rst.getInt("select sale_item_id"));
					saleItem.setTicketId(rst.getInt("ticket_id"));
					saleItem.setSaleId(rst.getFloat("sale_ID"));
					saleItem.setPrice(rst.getInt("sale_item_price"));
					saleItemList.add(saleItem);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return saleItemList;
	}
}
