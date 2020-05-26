package view.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserSrv;
/**
 * Servlet implementation class UserSearch
 */
@WebServlet("/UserSearch")
public class UserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearch() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String account = null;
		String name =null ;
		String password = null;
		String type = request.getParameter("type");
		System.out.println("成功获取类型");
		name = request.getParameter("name");
		System.out.println("成功获取用户名");
		//name=new String(name.getBytes("ISO-8859-1"),"utf-8");
		account = request.getParameter("account");
		System.out.println("成功获取账户");
		account=new String(account.getBytes("ISO-8859-1"),"utf-8");
		password = request.getParameter("password");
		System.out.println("成功获取密码");
		password = new String(password.getBytes("ISO-8859-1"),"utf-8");
		List<User> result = null;
		if(account!=null && account.length()>0)
			result = new UserSrv().Fetch("user_account = '" + account +"'");			
		else if(name != null && name.length()>0) {
			result = new UserSrv().Fetch("user_name LIKE '%" + name +"%'");
		}
		else
			result = new UserSrv().FetchAll();
		if(type.equals("login")  ) {
			if(result != null)
			{
				User user = result.get(0);
				System.out.println(user.getPassword());
				if(user.getPassword().equals(password)) {
					System.out.println("密码正确");
					out.write("success");
				}
				else {
					System.out.println("密码错误");
					out.write("error");
				}
			}
			else {
				out.write("null");
			}
				
		}
		else {
			String jsonStr = "[";		
			for (User u : result) {
				jsonStr += "{\"id\":\""+u.getID() + 
						"\",\"name\":\""+u.getName() +
						"\",\"account\":\""+u.getAccount()+ 
						"\",\"passerword\":\"" + u.getPassword() +"\"}";
				jsonStr += ",";
			}
			if(result.size()==0)
				jsonStr += "]";
			else
			    jsonStr = jsonStr.substring(0, jsonStr.length()-1)+"]";
			response.setContentType("application/json;charset=utf-8");  // 指定返回的格式为JSON格式
			response.setCharacterEncoding("UTF-8");  // setContentType与setCharacterEncoding的顺序不能调换，否则无法解决中文乱码的问题
			
			out.write(jsonStr);
		}
		
		out.close();
	}

}
