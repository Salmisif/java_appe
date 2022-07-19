
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class classmaine {
   public static void main(String[] args) throws ClassNotFoundException, SQLException{
       Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/pret","root",""); 
        Statement state = c.createStatement();
        
        String input="re";
        
        
        ResultSet result= state.executeQuery("select l.issn,l.titre,l.resume, l.domaine, a.nom, l.nbr from livre l ,auteur a ,ecrit e where a.num = e.num and e.issn=l.issn and l.titre = '"+input+"';");
        
        while(result.next())
        {
            System.out.println(result.getString(1));
        }
             
        
    }
}
