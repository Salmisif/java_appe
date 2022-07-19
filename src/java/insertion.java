import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.mysql.jdbc.Driver;
import java.util.ArrayList;



public class insertion extends HttpServlet{
   public void doGet(HttpServletRequest r, HttpServletResponse s) throws IOException, ServletException{
       
       PrintWriter p = s.getWriter();
       // livre
       int issn = Integer.parseInt(r.getParameter("issn"));
        String titre = r.getParameter("titre");
       String resume = r.getParameter("resume");
       int nb_pages = Integer.parseInt(r.getParameter("nb_pages"));
       String domaine = r.getParameter("domaine");
       // les auteurs 
       String msg;
       String[] num  = r.getParameterValues("num");
       String[] nom = r.getParameterValues("nom");
       String[] prenom = r.getParameterValues("prenom");
       String[] date_de_naissance = r.getParameterValues("date_de_naissance");
       RequestDispatcher rd = r.getRequestDispatcher("addauthorbook.jsp");
       try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pret","root",""); 
            Statement state = c.createStatement();
            ResultSet result1= state.executeQuery("select * from livre l where l.issn="+issn+";");
            Statement state2 = c.createStatement();
            for(int i =0 ; i<num.length;i++){
                int numAutt=Integer.parseInt(num[i]);
                ResultSet result2= state2.executeQuery("select * from auteur a where a.num="+numAutt+";");
                 Statement state3 = c.createStatement();
                ResultSet result3= state3.executeQuery("select * from ecrit e where e.num="+numAutt+" and e.issn="+issn+";");
                p.println(numAutt +" "+issn);


                if(result3.next()){


                         msg="Livre exist deja";
                        r.setAttribute("msg", msg);
                        rd.forward(r, s);
                        p.print("Ce livre existe déja");
                        break;
                }else{
                   
                    if(!result2.next()){
                        
                        PreparedStatement st1 = c.prepareStatement("insert into auteur values(?, ?, ?,?);");
                            st1.setInt(1, numAutt);
                            st1.setString(2, nom[i]);
                            st1.setString(3, prenom[i]);
                            st1.setString(4, date_de_naissance[i]);
                            st1.executeUpdate();
                            if(i==0){
                        PreparedStatement st2 = c.prepareStatement("insert into livre values(?, ?, ?,?,?);");
                            st2.setInt(1, issn);
                            st2.setString(2, titre);
                            st2.setString(3, resume);
                            st2.setInt(4, nb_pages);
                            st2.setString(5, domaine);
                            st2.executeUpdate();}
                        PreparedStatement st3 = c.prepareStatement("insert into ecrit values(?, ?);");
                            st3.setInt(1, issn);
                            st3.setInt(2, numAutt);
                            st3.executeUpdate();


                    }else{
                        if(!result1.next()){
                            if (i==0){
                            PreparedStatement st2 = c.prepareStatement("insert into livre values(?, ?, ?,?,?);");
                                st2.setInt(1, issn);
                                st2.setString(2, titre);
                                st2.setString(3, resume);
                                st2.setInt(4, nb_pages);
                                st2.setString(5, domaine);
                                st2.executeUpdate();}
                            
                            PreparedStatement st3 = c.prepareStatement("insert into ecrit values(?, ?);");
                                st3.setInt(1, issn);
                                st3.setInt(2, numAutt);
                                st3.executeUpdate();
                        }

                    }


                }   
            }
            
            msg="insertion reussite";
            r.setAttribute("msg", msg);
            rd.forward(r, s);
           
        }catch(SQLException | ClassNotFoundException e)
            {p.println(e);}
       
   }
}