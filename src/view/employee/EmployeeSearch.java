package view.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Employee;
import service.EmployeeSrv;

@WebServlet("/EmployeeSearch")
public class EmployeeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeSearch() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		id=new String(id.getBytes("ISO-8859-1"),"utf-8");
		List<Employee> result = null;
		if(id!=null && id.length()>0)
			result = new EmployeeSrv().Fetch("emp_id LIKE '%" + Integer.valueOf(id) +"%'");			
		else
			result = new EmployeeSrv().FetchAll();
		String jsonStr = "[";		
		for (Employee s : result) {
			jsonStr += "{\"id\":\""+s.getId() + 
					"\",\"no\":\""+s.getNo() +
					"\",\"name\":\""+s.getName() +
					"\",\"telNum\":\""+s.getTelNum()+
					"\",\"address\":\""+s.getAddress()+
					"\",\"email\":\""+s.getEmail()+ "\"}";
			jsonStr += ",";
		}
		if(result.size()==0)
			jsonStr += "]";
		else
		    jsonStr = jsonStr.substring(0, jsonStr.length()-1)+"]";
		response.setContentType("application/json;charset=utf-8");  // 鎸囧畾杩斿洖鐨勬牸寮忎负JSON鏍煎紡
		response.setCharacterEncoding("UTF-8");  // setContentType涓巗etCharacterEncoding鐨勯『搴忎笉鑳借皟鎹紝鍚﹀垯鏃犳硶瑙ｅ喅涓枃涔辩爜鐨勯棶棰�
		PrintWriter out = response.getWriter();
		out.write(jsonStr);
		out.close();
	}

}
