package com.rspc;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ChangePassword extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response)
throws IOException,ServletException
{
response.setContentType("text/html");
PrintWriter out=response.getWriter();

String ps,cps,qr,id,psw="";

ps=request.getParameter("cpsw");
cps=request.getParameter("psw");

HttpSession session=request.getSession();
id=(String)session.getAttribute("userid");

qr="select * from usre where id=? and pass=?";

try
{
Connection con=null;
PreparedStatement pst=null;
ResultSet rs=null;
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root123","root");
pst=con.prepareStatement(qr);

pst.setString(1,id);
pst.setString(2,ps);

rs=pst.executeQuery();
if(rs.next())
{
qr="update usre set pass=? where id=?";
pst=con.prepareStatement(qr);
pst.setString(1,cps);
pst.setString(2,id);
int n=pst.executeUpdate();
if(n>0)
{
	out.println("Password Updated...!");
	out.println("<input type='button' value='Back' onclick='history.back()'>");
}
else
{
	out.println("Password Mismatched...!");
	out.println("<input type='button' value='Back' onclick='history.back()'>");
}

}
else
{
	out.println("Password Mismatched...!");
	out.println("<input type='button' value='Back' onclick='history.back()'>");
}	
}
catch(Exception e)
{
out.println(e);	
}
out.close();
}
}
