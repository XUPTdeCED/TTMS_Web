package dao;

import java.util.LinkedList;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.DataDict;
import idao.IDataDictDAO;
import util.DBUtil;

public class DataDictDAO implements IDataDictDAO {
	@Override
	public int insert(DataDict dict) {
		try {
			String sql = "insert into studio(dict_id, dat_dict_id, dict_index, dict_name,dict_value )"
					+ " values('"
					+ dict.getId()
					+ "', "
					+ dict.getId()
					+ ", " + dict.getIndex() 
					+ ", " + dict.getName()
					+ ", '" + dict.getValue()
					+ "' )";
			DBUtil db = new DBUtil();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				dict.setId(rst.getInt(1));
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(DataDict stu) {

		String sql = "update DataDict set " + " dict_id ='" + stu.getId()
				+ "', " + " dat_dict_id = " + stu.getId() + ", "
				+ " dict_index = " + stu.getIndex() + ", "
				+ " dict_name = " + stu.getName() + ", "
				+ " dict_value = '" + stu.getValue() + "' ";

		sql += " where DataDict_id = " + stu.getId();

		DBUtil db = new DBUtil();

		return db.execCommand(sql);

	}

	@Override
	public int delete(int Id) {
		String sql = "delete from  DataDict ";
		sql += " where DataDict_id = " + Id;
		DBUtil db = new DBUtil();
		return db.execCommand(sql);
	}

	@Override
	public List<DataDict> select(String condt) {
		List<DataDict> dictList = null;
		dictList=new LinkedList<DataDict>();
		try {
			String sql = "select dict_id, dat_dict_id, dict_index, dict_name, dict_value from DataDict ";
			condt.trim();
			if(!condt.isEmpty())
				sql+= " where " + condt;
			DBUtil db = new DBUtil();
			ResultSet rst = db.execQuery(sql);
			//System.out.print("sql:"+sql);
			if (rst!=null) {
				while(rst.next()){
					DataDict dict=new DataDict();
					dict.setId(rst.getInt("dict_id"));
					dict.setSuperId(rst.getInt("dat_dict_id"));
					dict.setIndex(rst.getInt("dict_index"));
					dict.setName(rst.getString("dict_name"));
					dict.setValue(rst.getString("dict_value"));
					dictList.add(dict);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dictList;
	}
}
