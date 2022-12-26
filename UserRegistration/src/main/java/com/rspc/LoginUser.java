package com.rspc;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class LoginUser extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response)
throws IOException,ServletException
{
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String uid,qr,ps;
	uid=request.getParameter("email");
	ps=request.getParameter("pass");
	qr="select id from usre where id=? and pass=?";
	
	try
	{
	HttpSession session=request.getSession();
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost/user?user=root123&password=root");
	pst=con.prepareStatement(qr);
	pst.setString(1,uid);
	pst.setString(2,ps);
	rs=pst.executeQuery();

	if(rs.next())
	{
		session.setAttribute("userid", uid);
		RequestDispatcher dis=getServletContext().getRequestDispatcher("/JSP/UserHome.jsp");
		dis.forward(request, response);
	}
	else
	{
		RequestDispatcher dis=getServletContext().getRequestDispatcher("/index.html");
		dis.include(request, response);
		out.println("<font color='red'>Password Failed...!</font>");
	}
	rs.close();
	pst.close();
	con.close();
	}
	catch(Exception e)
	{
	out.println(e);	
	}
	out.close();
	}
}

