

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
  	  <meta charset="utf-8">
  	  <meta name="viewport" content="width=device-width,initial-scale=1">
	  <title>Home</title>

      <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
      <link rel="stylesheet" type="text/css" href="css/addauthor.css">
  </head>

   <body>
   	   
       <%@ include file="navbar.jsp"%>
          <div class="form-group-lg">
            <div clas="form-group-lg">
                <div class="col-md-12">
                    <div class="form">
                        <h2 align="center"> Search...</h2>
                       	    <form role="form" action="search" method="get">
                                
                                <label>Withe : </label><br>
                                    <label>&nbsp;&nbsp;titre&nbsp;</label> <input type="radio" name="choix" value="titre" >  
                                    <label>&nbsp;auteur&nbsp;</label><input type="radio" name="choix" value="auteur"> 
                                    <label>&nbsp;domaine</label>  <input type="radio" name="choix" value ="domaine"> 
                                    <br><br>
                                    
                                <div class="form-group">              
                                    <input type="text" name="nom" class="form-control" placeholder="Make research" required="required">
                      		</div>
                      		                 				                                 
                               <div class="form-group">
                                    <input class="form-control btn btn-success btn-block" id="signupButton" type="submit" name="signup" value="Search">
                               </div>
            
                            </form>
                            

                              </div>

                       		</div>
         	      </div>
         	</div>
  

           
           
                   <%@ include file="footer.jsp" %>
                
   </body>

</html>





