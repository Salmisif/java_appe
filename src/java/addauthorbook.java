import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.mysql.jdbc.Driver;
import java.util.logging.Level;
import java.util.logging.Logger;




public class addauthorbook extends HttpServlet{
   public void doGet(HttpServletRequest r, HttpServletResponse s) throws IOException, ServletException{
     
        PrintWriter p = s.getWriter();
      
       int issn = Integer.parseInt(r.getParameter("issn"));
        String titre = r.getParameter("titre");
       String resume = r.getParameter("resume");
       int nb_pages = Integer.parseInt(r.getParameter("nb_pages"));
       String domaine = r.getParameter("domaine");
       int num_auteur = Integer.parseInt(r.getParameter("auteur"));
       
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pret","root",""); 
          Statement state = c.createStatement();
             ResultSet result= state.executeQuery("select * from livre where issn="+issn+";");
        
    
            
                 
                if(result.next()){                  
                    RequestDispatcher rd=r.getRequestDispatcher("addbook_nv.jsp");
                    rd.include(r, s);
                    p.print("<html><body><h1 align ='center'>cet livre  existe deja</h1></body></html>");
                }   
                     else {
                        PreparedStatement st = c.prepareStatement("insert into livre values(?, ?, ?,?,?,?);");
                        st.setInt(1, issn);
                        st.setString(2, titre);
                        st.setString(3, domaine);
                        st.setString(4, resume);   
                        st.setInt(5, num_auteur);
                        st.setInt(6, nb_pages);                 
                        
                        st.executeUpdate();
                        RequestDispatcher rd=r.getRequestDispatcher("addbook_nv.jsp");
                        rd.include(r, s);
                        p.print("<html><body><h1 align ='center'>insertion réussite</h1></body></html>");
                     }
             
                
                    
            
           
        }catch(SQLException e)
            {e.printStackTrace();} catch (ClassNotFoundException ex) {
           Logger.getLogger(addauthorbook.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       
    }
}
