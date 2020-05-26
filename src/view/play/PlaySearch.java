package view.play;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Play;
import service.PlaySrv;

@WebServlet("/PlaySearch")
public class PlaySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PlaySearch() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		id=new String(id.getBytes("ISO-8859-1"),"utf-8");
		List<Play> result = null;
		if(id!=null && id.length()>0)
			result = new PlaySrv().Fetch("play_id LIKE '%" + Integer.valueOf(id) +"%'");			
		else
			result = new PlaySrv().FetchAll();
		String jsonStr = "[";		
		for (Play s : result) {
			jsonStr += "{\"id\":\""+s.getId() + 
					"\",\"type_id\":\""+s.getTypeId() +
					"\",\"lang_id\":\""+s.getLangId() +
					"\",\"name\":\""+s.getName() +
					"\",\"introduction\":\""+s.getIntroduction()+
					"\",\"image\":\""+s.getImage()+
					"\",\"length\":\""+s.getLength()+
					"\",\"ticketPrice\":\""+s.getTicketPrice()+
					"\",\"status\":\""+s.getStatus()+"\"}";
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
