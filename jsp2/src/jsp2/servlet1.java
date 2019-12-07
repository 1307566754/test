package jsp2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String uname=req.getParameter("uname");
		String upass=req.getParameter("upass");
		String sex=req.getParameter("sex");
		String ageStr=req.getParameter("age");
		int age=Integer.parseInt(ageStr);
		
		DBTest db=new DBTest();
		boolean isOk=db.add(uname, upass, sex, age);
		
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		if(isOk){
			out.println("<h1>¹§Ï²Äã£¬×¢²á³É¹¦£¡</h1>");
		}else{
			out.println("<h1>¶Ô²»Æð£¬×¢²áÊ§°Ü£¡</h1>");
			out.println("<a href='reg.jsp'>¼ÌÐø×¢²á</a>");
		}
		out.close();
	}
}
