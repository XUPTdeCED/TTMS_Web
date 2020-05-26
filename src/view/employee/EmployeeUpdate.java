package view.employee;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Employee;
import service.EmployeeSrv;

@WebServlet("/EmployeeUpdate")
public class EmployeeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeUpdate() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Employee emp = null;
		String type = request.getParameter("type");
		int id = 0;
		try {
			if (type.equals("modify")) {
				id = Integer.valueOf(request.getParameter("Employeeid"));
			}
			String no = request.getParameter("no");
			no=new String(no.getBytes("ISO-8859-1"),"utf-8");
			String name = request.getParameter("Employeename");
			name=new String(name.getBytes("ISO-8859-1"),"utf-8");
			String telNum = request.getParameter("telNum");
			telNum=new String(telNum.getBytes("ISO-8859-1"),"utf-8");
			String address = request.getParameter("address");
			address=new String(address.getBytes("ISO-8859-1"),"utf-8");
			String email = request.getParameter("email");
			email=new String(email.getBytes("ISO-8859-1"),"utf-8");
			emp = new Employee(id, name, telNum, address, email, email);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			if (type.equals("add")) {
				if(new EmployeeSrv().add(emp)==1)
					out.write("数据添加成功");
				else
					out.write("数据添加失败，请重试");
			} else{
				if(new EmployeeSrv().modify(emp)==1)
					out.write("数据修改成功");
				else
					out.write("数据修改失败，请重试");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("操作错误，请重试");
		}
	}
}
