package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.member.implMember;
import Model.member;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	 * 1.request接收-->username,password
	 * 2.selectUser(帳號，密碼)
	 * 3.null-->loginError
	 * 4.not null-->loginSuccess
	 */
	String Username=request.getParameter("username");
	String Password=request.getParameter("password");
	member m=new implMember().selectUser(Username, Password);
	if(m!=null)
	{
		HttpSession session=request.getSession();
		session.setAttribute("M", m);
		
		response.sendRedirect("member/loginSuccess.jsp");
	}
	else
	{
		response.sendRedirect("member/loginError.jsp");
	}
	}

}
