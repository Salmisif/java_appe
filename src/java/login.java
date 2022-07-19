
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.mysql.jdbc.Driver;



public class login extends HttpServlet{
   public void doPost(HttpServletRequest r, HttpServletResponse s) throws IOException, ServletException{
      
       PrintWriter p = s.getWriter();
    
       String user = r.getParameter("username");
       String password = r.getParameter("password");
       
       try{
       Class.forName("com.mysql.jdbc.Driver");
       Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pret","root",""); 
       Statement state = c.createStatement();
       ResultSet result= state.executeQuery("select * from admin");
        while(result.next()){
 
                if (user.equals(result.getString(1)) && password.equals(result.getString(2))){
                    RequestDispatcher rd=r.getRequestDispatcher("ajout.jsp");
                    rd.forward(r, s);
                }         
        }
        
                    RequestDispatcher rd=r.getRequestDispatcher("login.jsp");
            
            rd.include(r, s); 
            p.print("<html><body><h1 align ='center'>erreur</h1></body></html>");
                 
       }
        catch(SQLException e){e.printStackTrace();}
        catch(ClassNotFoundException e){e.printStackTrace();}
        
       
   }
}