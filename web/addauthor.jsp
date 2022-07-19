

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
  	  <meta charset="utf-8">
  	  <meta name="viewport" content="width=device-width,initial-scale=1">
	  <title>add author</title>

      <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
      <link rel="stylesheet" type="text/css" href="css/addauthor.css">
  </head>

   <body>
   	   
       <%@ include file="navbar.jsp"%>
          <div class="container">
            <div clas="row">
                <div class="col-md-12">
                    <div class="form">
                        <h2 align="center"> ADD Author...</h2>
                       	    <form role="form" action="addauthor" method="get">
                                <div class="form-group">              
                                    <input type="number" name="num" class="form-control" placeholder="num" required="required">
                                </div>
                                <div class="form-group">              
                                    <input type="text" name="nom" class="form-control" placeholder="name" required="required">
                      		</div>
                      		<div class="form-group">
                                    <input type="text" required="required" name="prenom" class="form-control" placeholder="first name">
                                </div>
                      		     <div class="form-group">
                                    <input type="date" name="date_de_naissance" required="required" class="form-control" placeholder="birth date" >	  
                      		</div>                               
                               <div class="form-group">
                                    <input class="form-control btn btn-success btn-block" id="signupButton" type="submit" name="signup" value="ADD">
                               </div>
                            </form>
                    </div>

                       		</div>
         	      </div>
         	</div>
          </div>

           
           
                   <%@ include file="footer.jsp" %>
                
   </body>

</html>





