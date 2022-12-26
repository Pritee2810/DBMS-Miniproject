package com.rspc;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ForgetPassword extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response)
throws IOException,ServletException
{
response.setContentType("text/html");
PrintWriter out=response.getWriter();

String uid,dob,qr,psw="";
uid=request.getParameter("email");
dob=request.getParameter("dob");
psw=uid.substring(0,3)+dob.substring(8,10);
qr="update usre set pass='"+psw+"' where id=? and dob=?";
try
{
Connection con=null;
PreparedStatement pst=null;
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/user?user=root123&password=root");
pst=con.prepareStatement(qr);
pst.setString(1,uid);
pst.setString(2,dob);
int n=pst.executeUpdate();
if(n>0)
{
	out.println("Password Updated Successfully...!");
	out.println("<br><a href='../index.html'>Home</a>");
}
else
{
	out.println("Sorry Try Again...!");
	out.println("<br><a href='../index.html'>Home</a>");	
}
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
