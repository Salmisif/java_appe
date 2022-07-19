<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
        <link rel="stylesheet" href="bootstrap-3.3.2-dist/css/bootstrap.min.css">
        <style>
            h1{background:rgba(22,33,20,0.4);padding: 3%}
            .inpt{margin-left: 15%;}
            .tbl{margin-top: 5%; background: rgba(33,33,33,0.3)}
            td{font-family: serif;font-size:120%;color:white;font-style: italic;}  
            label{color:white;font-size:110%}
            th{color:white;}
            b{color:red;font-size:150%;font-family:cursive;background:rgba(55,1 3,20,0.8);padding:2%;margin-top:5%}
        </style>
    </head>
    <body style="background-image:url('img/a.jpg')">
        <div class="row">
        
            
        <div class="col-lg-9 milieu ">
         
       <%
             ResultSet result=(ResultSet) request.getAttribute("result");
             if(result==null)
                out.print("");
             
             else
             {
                 
                 while(result.next())
                {
                %>
                <table class="table table-condensed table-responsive tbl">
      
        
        
             <tr><th>ISSN</th>  <td><% out.print(result.getInt(1)); %></td></tr>
              <tr><th>titre</th>  <td><% out.print(result.getString(2)); %></td> </tr>
              <tr><th>resumé</th> <td><% out.print(result.getString(3)); %></td> </tr>
              <tr><th>domaine</th> <td><% out.print(result.getString(4)); %></td></tr>
              <tr><th>auteur</th> <td><% out.print(result.getString(5)); %></td> </tr>
               <tr><th>nombre PAges</th>  <td><% out.print(result.getInt(6)); %></td> </tr>
               
                
        <hr>
        <%  }%>   
          </table>
        <%
             }
             %><center>
                <%                
               String msg=(String) request.getAttribute("message");
                if(msg==null)
                   out.print("");
                else 
                { %>
                   <hr><b> <% out.print(msg);%> </b>  
                <% } %>
            </center>         
    </div>
        </div>
    </body>
</html>
