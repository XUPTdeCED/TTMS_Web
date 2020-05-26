package view.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserSrv;

/**
 * Servlet implementation class UserUpdata
 */
@WebServlet("/UserUpdate")
public class UserUpdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdata() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		User user = null;
		String jsonStr = null;
		System.out.println("1000");
		String type = request.getParameter("type");
		int id = 0;
		try {
			if (type.equals("modify")) {
				id = Integer.valueOf(request.getParameter("userid"));
			}
			String name = request.getParameter("username");
			name=new String(name.getBytes("ISO-8859-1"),"utf-8");
			String account = request.getParameter("account");
			account =new String(account.getBytes("ISO-8859-1"),"utf-8");
			String password = request.getParameter("password");
			password = new String(password.getBytes("ISO-8859-1"),"utf-8");
			user = new User(id, name, account, password);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String condt  = "user_account = '" + user.getAccount()+"'" ;
			if(new UserSrv().Fetch(condt).size() != 0) {
				out.write("repeat");
			}
			else {
				if (type.equals("add")) {
					if(new UserSrv().add(user)==1)
						
						out.write("success");
					else
						out.write("failed");
				} else{
					if(new UserSrv().modify(user)==1)
						out.write("success");
					else
						out.write("failed");
				}
			}
			
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("操作错误，请重试");
		}
	}

}
