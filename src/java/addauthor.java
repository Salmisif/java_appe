import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.mysql.jdbc.Driver;



public class addauthor extends HttpServlet{
   public void doGet(HttpServletRequest r, HttpServletResponse s) throws IOException, ServletException{
      
       PrintWriter p = s.getWriter();
       int num = Integer.parseInt(r.getParameter("num"));
       String nom = r.getParameter("nom");
       String prenom = r.getParameter("prenom");
       String date_de_naissance = r.getParameter("date_de_naissance");
       
       
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pret","root",""); 
          Statement state = c.createStatement();
             ResultSet result= state.executeQuery("select * from auteur where num="+num+";");
        
    
            
                 
                if(result.next()){                  
                    RequestDispatcher rd=r.getRequestDispatcher("addauthor.jsp");
                    rd.include(r, s);
                    p.print("<html><body><h1 align ='center'>cet auteur  existe deja</h1></body></html>");
                }   
                     else {
                        PreparedStatement st = c.prepareStatement("insert into auteur values(?, ?, ?,?);");
                        st.setInt(1, num);
                        st.setString(2, nom);
                        st.setString(3, prenom);
                        st.setString(4, date_de_naissance);
                        st.executeUpdate();
                        RequestDispatcher rd=r.getRequestDispatcher("addauthor.jsp");
                        rd.include(r, s);
                        p.print("<html><body><h1 align ='center'>insertion reussite</h1></body></html>");
                     }
             
                
                    
            
           
        }catch(SQLException e)
            {e.printStackTrace();}
        catch(ClassNotFoundException e)
            {e.printStackTrace();}
    }
}
