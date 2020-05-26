package view.play;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Play;
import service.PlaySrv;

@WebServlet("/PlayUpdate")
public class PlayUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PlayUpdate() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Play play = null;
		String type = request.getParameter("type");
		int id = 0;
		try {
			if (type.equals("modify")) {
				id = Integer.valueOf(request.getParameter("playid"));
			}
			int typeId = Integer.valueOf(request.getParameter("typeId"));
			int langId = Integer.valueOf(request.getParameter("langId"));
			String name = request.getParameter("playname");
			name=new String(name.getBytes("ISO-8859-1"),"utf-8");
			String introduction = request.getParameter("introduction");
			introduction=new String(introduction.getBytes("ISO-8859-1"),"utf-8");
			String image = request.getParameter("image");
			image=new String(image.getBytes("ISO-8859-1"),"utf-8");
			int length = Integer.valueOf(request.getParameter("length"));
			int ticketPrice= Integer.valueOf(request.getParameter("length"));
			int status = Integer.valueOf(request.getParameter("status"));
			play = new Play( id, typeId, langId, name, introduction, image, length, ticketPrice, status);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			if (type.equals("add")) {
				if(new PlaySrv().add(play)==1)
					out.write("数据添加成功");
				else
					out.write("数据添加失败，请重试");
			} else{
				if(new PlaySrv().modify(play)==1)
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
