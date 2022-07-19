import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.mysql.jdbc.Driver;


public class search extends HttpServlet{
   public void doGet(HttpServletRequest r, HttpServletResponse s) throws IOException, ServletException{
      
       PrintWriter p = s.getWriter();
       String choix = r.getParameter("choix");
       
       String input = r.getParameter("nom");
       
       
        try
        {
           
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/pret","root",""); 
        Statement state = c.createStatement();
        
        //par titre       
        if(choix.equals("titre"))
        {
              ResultSet result= state.executeQuery("select l.issn,l.titre,l.resume, l.domaine, a.nom, l.nbr"
                      + " from livre l ,auteur a ,ecrit e where "
                      + "a.num = e.num and e.issn=l.issn and l.titre = '"+input+"';");

             
             
             if (!result.next()){
                 RequestDispatcher rd=r.getRequestDispatcher("search.jsp");
                    rd.include(r, s);
                    
                    p.print("<html><body><h1 align ='center' >ce livre n'existe pas</h1></body></html>");
            }
            else{
             
             p.print("<html><body bgcolor='lightblue'><br><br><br><br><br><br><br><center><h2>Résultat</h2>");
              p.print("<table border='1px solid black'><tr>");
             p.print("<th bgcolor ='yellow' width='15%'>issn</th>");
             p.print("<th bgcolor ='yellow' width='15%'>titre</th>");
             p.print("<th bgcolor ='yellow' width='15%'>resume</th>");
             p.print("<th bgcolor ='yellow'width='15%' >domaine</th>");
             p.print("<th bgcolor ='yellow' width='15%'>auteur</th>");
             p.print("<th width='15%' bgcolor ='yellow'>nbr de page </th>");
             p.print("</tr>");
              p.print("<tr>");
                for(int i= 1;i<=6;i++ ){
                    p.print("<td>");
                    p.print(result.getObject(i).toString());
                    p.print("<br>");
                    p.print("</td>");

                }
                p.print("</tr>");
                
             
             
            while(result.next()){
               
                for(int i= 1;i<=6;i++ ){
                    p.print("<td>");
                    p.print(result.getObject(i).toString());
                    p.print("<br>");
                    p.print("</td>");

                }
                p.print("</tr>");
                
            }
            p.println("</table></center></body></html>");
            }
        }
        
        
        
        
        
        
        
        
        
        
        // par auteur
        
        else if(choix.equals("auteur"))
        {
            ResultSet result= state.executeQuery("select l.issn,l.titre,l.resume, l.domaine, a.nom, l.nbr from livre l ,auteur a ,ecrit e where a.num = e.num and e.issn=l.issn and a.nom = '"+input+"';");

             
             if (!result.next()){
                 RequestDispatcher rd=r.getRequestDispatcher("search.jsp");
                    rd.include(r, s);
                    
                    p.print("<html><body><h1 align ='center'>ce livre n'existe pas</h1></body></html>");
            }
            else{
             
             p.print("<html><body bgcolor='lightblue' ><br><br><br><br><br><br><br><center><h2>Résultat</h2>");
             p.print("<table border='1'><tr>");
             p.print("<th bgcolor ='yellow' width='15%'>issn</th>");
             p.print("<th bgcolor ='yellow' width='15%'>titre</th>");
             p.print("<th bgcolor ='yellow' width='15%'>resume</th>");
             p.print("<th bgcolor ='yellow' width='15%'>domaine</th>");
             p.print("<th bgcolor ='yellow' width='15%'>auteur</th>");
             p.print("<th width='15%' bgcolor ='yellow'>nbr de page </th>");
             p.print("</tr>");
              p.print("<tr>");
                for(int i= 1;i<=6;i++ ){
                    p.print("<td>");
                    p.print(result.getObject(i).toString());
                    p.print("<br>");
                    p.print("</td>");

                }
                p.print("</tr>");
                
             
             
            while(result.next()){
                
                for(int i= 1;i<=6;i++ ){
                    p.print("<td>");
                    p.print(result.getObject(i).toString());
                    p.print("<br>");
                    p.print("</td>");

                }
                p.print("</tr>");
                
            }
            p.println("</table></center></body></html>");
            }
        }
        
        
        
        
        
        
        // par domaine
        
        else{
             ResultSet result= state.executeQuery("select l.issn,l.titre,l.resume,"
                     + " l.domaine, a.nom, l.nbr from livre l ,auteur a ,ecrit e where a.num = e.num and e.issn=l.issn and l.domaine = '"+input+"';");
        
            
                if (!result.next()){
                 RequestDispatcher rd=r.getRequestDispatcher("search.jsp");
                    rd.include(r, s);
                    p.print("<html><body><h1 align ='center'>ce livre n'existe pas</h1></body></html>");
            }
            else{
                    
            p.print("<html><body bgcolor='lightblue' ><br><br><br><br><br><br><br><center><h2>Résultat</h2>");
             p.print("<table border='1'><tr>");
             p.print("<th bgcolor ='yellow' width='15%'>issn</th>");
             p.print("<th bgcolor ='yellow' width='15%'>titre</th>");
             p.print("<th bgcolor ='yellow' width='15%'>resume</th>");
             p.print("<th bgcolor ='yellow' width='15%'>domaine</th>");
             p.print("<th bgcolor ='yellow' width='15%'>auteur</th>");
             p.print("<th width='15%' bgcolor ='yellow'>nbr de page </th>");
             p.print("</tr>");
              p.print("<tr>");;
            for(int i= 1;i<=6;i++ ){
                p.print("<td>");
                p.print(result.getObject(i).toString());
                p.print("<br>");
                p.print("</td>");
                 
        }
            p.print("</tr>");
            
            
        while(result.next()){
           
            for(int i= 1;i<=6;i++ ){
                p.print("<td>");
                p.print(result.getObject(i).toString());
                p.print("<br>");
                p.print("</td>");
                 
        }
            p.print("</tr>");
            
        }
                p.println("</table></body></html>");
                }
         
        }
        
        
         
        }
        catch(SQLException e){e.printStackTrace();}
        catch(ClassNotFoundException e){e.printStackTrace();}
    }
   
   
}
