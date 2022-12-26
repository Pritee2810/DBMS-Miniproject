package com.rspc;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Register extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response)
throws IOException,ServletException
{
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();

	String uid,ps,nm,dob,qr;
	uid=request.getParameter("email");
	ps=request.getParameter("psw");
	nm=request.getParameter("nm");
	dob=request.getParameter("dob");	
	qr="insert into usre values(?,?,?,?)";
	
	try {
		
		//JDBC coading here
		Connection con=null;
		PreparedStatement pst=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/user?user=root123&password=root");
		pst=con.prepareStatement(qr);
		pst.setString(1,uid);
		pst.setString(2,ps);
		pst.setString(3,nm);
		pst.setString(4,dob);
		int n=pst.executeUpdate();
		if(n>0)
		{
			out.println("User Data Added...!");
			out.println("<br><a href='index.html'>Home</a>");
		}
		else
		{
			out.println("Sorry Try Again...!");
			out.println("<br><a href='index.html'>Home</a>");	
		}
		pst.close();
		con.close();
		}
		catch(Exception e)
		{
		out.println(e);	
		}
		out.close();
		}//dopost
	
}//class

