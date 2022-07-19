

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
  	  <meta charset="utf-8">
  	  <meta name="viewport" content="width=device-width,initial-scale=1">
	  <title>ADD BOOk</title>

      <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
      <link rel="stylesheet" type="text/css" href="css/addauthor.css">
  </head>

   <body>
   	   
       <%@ include file="navbar.jsp"%>
        
          <div class="form-group-lg">
              <div clas="row">
                  <div class="col-md-12">
                       	<div class="form form1">
                              <h2 align="center"> ..ADD ur Book..</h2>
                       	     	<form role="form" action="addauthorbook" method="Get">
                                     <div class="form-group">              
                                        <input type="number" name="issn" class="form-control" placeholder="Issn" required="required">
                                     </div>
                                    <div class="form-group">              
                                         <input type="text" name="titre" class="form-control" placeholder="Title" required="required">
                                    </div>		    
                                    <div class="form-group">
                      			<input type="text" required="required" name="resume" class="form-control" placeholder="abstract">  
                                    </div>		    
                                    <div class="form-group">
                                          <input type="number" name="nb_pages" required="required" class="form-control" placeholder="number of pages" >	  
                                     </div>
                                    <div class="form-group">
                                          <input type="text" name="domaine" required="required" class="form-control" placeholder="Field" >	  
                                    
                                    </div>
                                    <div class="form-group">
                                          <input type="number" name="auteur" required="required" class="form-control" placeholder="author number" >	  
                                    
                                    </div>
                                    <div id="iddiv"> </div>
                                    
                                    
                                    
                                           				                                 
                               
                                     <div class="form-group">
                                       <input class="form-control btn btn-success btn-block" id="signupButton" type="submit" name="signup" value="ADD BOOK">
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





