package view.seat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Seat;
import service.SeatSrv;

@WebServlet("/SeatUpdate")
public class SeatUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SeatUpdate() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Seat seat = null;
		String type = request.getParameter("type");
		int seatid = 0;
		try {
			if (type.equals("modify")) {
				seatid = Integer.valueOf(request.getParameter("seatid"));
			}
			int studio_Id = Integer.valueOf(request.getParameter("studio_id"));
			int row = Integer.valueOf(request.getParameter("seat_row"));
			int column = Integer.valueOf(request.getParameter("seat_column"));
			seat = new Seat(seatid,studio_Id, row, column);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			if (type.equals("add")) {
				if(new SeatSrv().add(seat)==1)
					out.write("座位添加成功");
				else
					out.write("座位添加失败，请重试");
			} else{
				if(new SeatSrv().modify(seat)==1)
					out.write("座位修改成功");
				else
					out.write("座位修改失败，请重试");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("操作错误，请重试");
		}
	}
}
