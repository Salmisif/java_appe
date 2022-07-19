
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.mysql.jdbc.Driver;


public class delete_book extends HttpServlet{
   public void doGet(HttpServletRequest r, HttpServletResponse s) throws IOException, ServletException{
      
       PrintWriter p = s.getWriter();
       int issn = Integer.parseInt(r.getParameter("issn"));
       String titre = r.getParameter("titre");
       String nom = r.getParameter("nom");
       
        try{
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pret","root","");  
            Statement st = c.createStatement();
            ResultSet result= st.executeQuery("select * from livre where issn ="+issn+";");
          
           if (result.next()){
               
               
                PreparedStatement st1 = c.prepareStatement("delete from ecrit where issn="+issn+";");
                st1.executeUpdate();
                
                 PreparedStatement st2 = c.prepareStatement("delete from livre where issn="+issn+";");
                st2.executeUpdate();
                

                 RequestDispatcher rd=r.getRequestDispatcher("deletebook.jsp");
                    rd.include(r, s);
                    
                    p.print("<html><body><h1 align ='center'>livre suprime</h1></body></html>");
          
           }
           else {
           RequestDispatcher rd=r.getRequestDispatcher("deletebook.jsp");
                    rd.include(r, s);
                   
                    p.print("<html><body><h1 align ='center'>ce livre n'existe pas</h1></body></html>");
           }
        }catch(SQLException e)
            {e.printStackTrace();}
        catch(ClassNotFoundException e)
            {e.printStackTrace();}
    }
}
