package view.seat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Seat;
import service.SeatSrv;

@WebServlet("/SeatSearch")
public class SeatSearch extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public SeatSearch() {
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException  {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String studio_id;
		System.out.println("66666");
		studio_id = request.getParameter("studioid");
		studio_id=new String(studio_id.getBytes("ISO-8859-1"),"utf-8");
		List<Seat> result = null;
		if(studio_id!=null && studio_id.length()>0)
			result = new SeatSrv().Fetch("studio_id = " + studio_id);			
		else
			result = new SeatSrv().FetchAll();
		String jsonStr = "[";		
		for (Seat s : result) {
			jsonStr += "{\"seat_id\":\""+s.getId() + 
					"\",\"studio_id\":\""+s.getStudioId() +
					"\",\"seat_row\":\""+s.getRow()+
					"\",\"seat_column\":\""+s.getColumn()+
					"\"}";
			jsonStr += ",";
		}
		if(result.size()==0)
			jsonStr += "]";
		else
		    jsonStr = jsonStr.substring(0, jsonStr.length()-1)+"]";
		response.setContentType("application/json;charset=utf-8");  // 指定返回的格式为JSON格式
		response.setCharacterEncoding("UTF-8");  // setContentType与setCharacterEncoding的顺序不能调换，否则无法解决中文乱码的问题
		PrintWriter out = response.getWriter();
		out.write(jsonStr);
		out.close();
	}
	
}
