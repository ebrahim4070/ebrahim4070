package com.ebrahim;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			
			
	throws ServletException, IOException 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebrahimproject","root","ebrahim");
		

			String name=request.getParameter("textname");
			String password=request.getParameter("textpwd");
			PreparedStatement pst=con.prepareStatement("SELECT * FROM Login where username=? AND password=?")
			pst.setString(1,name);	
			pst.setString(1,name);	
			pst.setString(2,password);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				response.sendRedirect("success.jsp");
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
