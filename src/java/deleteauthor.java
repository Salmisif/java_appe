
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.mysql.jdbc.Driver;


public class deleteauthor extends HttpServlet{
   public void doGet(HttpServletRequest r, HttpServletResponse s) throws IOException, ServletException{
      
       PrintWriter p = s.getWriter();
       int num = Integer.parseInt(r.getParameter("num"));
       String nom = r.getParameter("nom");
       String prenom = r.getParameter("prenom");
       
        try{
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pret","root","");  
            Statement st = c.createStatement();
            ResultSet result= st.executeQuery("select * from auteur where num ="+num+";");
           
            Statement stat = c.createStatement();
            ResultSet resulta= stat.executeQuery("select * from ecrit where num ="+num+";");
          
           if ((resulta.next())&&(result.next())){
               
               
                PreparedStatement st1 = c.prepareStatement("delete from ecrit where num="+num+";");
                st1.executeUpdate();
                
                 PreparedStatement st2 = c.prepareStatement("delete from auteur where num="+num+";");
                st2.executeUpdate();
                

                 RequestDispatcher rd=r.getRequestDispatcher("deleteauthor.jsp");
                    rd.include(r, s);
                    p.print("auteur suprime");
          
           }
           else  if ((!resulta.next())&&(result.next())){
               
                PreparedStatement st2 = c.prepareStatement("delete from auteur where num="+num+";");
                st2.executeUpdate();
                

                 RequestDispatcher rd=r.getRequestDispatcher("deleteauthor.jsp");
                    rd.include(r, s);
                    p.print("<html><body><h1 align ='center'>auteur suprime</h1></body></html>");   
           }
           else if ((!resulta.next())&&(!result.next())){
           RequestDispatcher rd=r.getRequestDispatcher("deleteauthor.jsp");
                    rd.include(r, s);
                   
                    p.print("<html><body><h1 align ='center'>cet auteur n'existe pas</h1></body></html>");
           }
        }catch(SQLException e)
            {e.printStackTrace();}
        catch(ClassNotFoundException e)
            {e.printStackTrace();}
    }
}
