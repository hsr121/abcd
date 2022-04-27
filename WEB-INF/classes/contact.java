import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;

public class contact extends HttpServlet {
    public void doPost (HttpServletRequest req, HttpServletResponse rsp) throws IOException, ServletException{
    	PrintWriter out = rsp.getWriter();
    	try{
	    	Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ManasShreya", "hsr", "Harshal@1212");
	    	String name = req.getParameter("name");
	    	String email = req.getParameter("email");
	    	String subject = req.getParameter("subject");
	    	String message = req.getParameter("message");
	    	PreparedStatement prepState = con.prepareStatement("INSERT INTO ContactDetails VALUES (?,?,?,?);");
	    	prepState.setString(1,name);
	    	prepState.setString(2, email);
	    	prepState.setString(3, subject);
	    	prepState.setString(4, message);
	    	prepState.executeUpdate();
	    	rsp.sendRedirect("index.html");
    	}catch(Exception e){
    		rsp.sendRedirect("contact.html");
    	}
    }
}
