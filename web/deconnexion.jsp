

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deconnexion</title>
    </head>
    <body>
        <% 
           session.invalidate(); 
        %>
        <jsp:forward page="login.jsp"> 
            <jsp:param name="msg" value="msg" /> 
        </jsp:forward> 
    </body>
</html>

