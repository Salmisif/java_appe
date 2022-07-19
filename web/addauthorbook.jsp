

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
                         <%
                                Object c=request.getAttribute("nbr");
                                Object c1=request.getAttribute("issn");
                                Object c2=request.getAttribute("titre");
                                Object c3=request.getAttribute("resume");
                                Object c4=request.getAttribute("nb_pages");
                                Object c5=request.getAttribute("domaine");
                                if(c==null&&c1==null&&c2==null&&c3==null&&c4==null&&c5==null){
                                    String msg=request.getAttribute("msg").toString();
                                    out.println(msg);
                                }else{
                                
                                %>
                        <h2 align="center"> ADD Author...</h2>
                       	    <form role="form" action="insertion" method="get">
                               
                                
                                <div class="form-group">              
                                    <input type="number" name="issn" value ="<%out.print(c1);%>"class="form-control" placeholder="Issn" required="required">
                                     </div>
                                    <div class="form-group">              
                                         <input type="text" name="titre" value ="<%out.print(c2);%>" class="form-control" placeholder="Title" required="required">
                                    </div>		    
                                    <div class="form-group">
                      			<input type="text"  name="resume" value ="<%out.print(c3);%>" class="form-control" placeholder="abstract">  
                                    </div>		    
                                    <div class="form-group">
                                          <input type="number" name="nb_pages" value ="<%out.print(c4);%>" class="form-control" placeholder="number of pages" >	  
                                     </div>
                                    <div class="form-group">
                                          <input type="text" name="domaine" value ="<%out.print(c5);%>" class="form-control" placeholder="Field" >	  
                                    
                                    </div>
                                    
                                    
                                       
                               
                                         
                       		    
                                
                                
                                
                                <%
                                int nbr=Integer.parseInt(c.toString());
                                for(int i=0;i<nbr;i++){
                                    
                                %>
                                <label>New author : </label>
                                
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
                                <% }%>                                
                               <div class="form-group">
                                    <input class="form-control btn btn-success btn-block" id="signupButton" type="submit" name="signup" value="ADD">
                               </div>
            
                            </form>
                            

                    </div>
<%}%>
                       		</div>
         	      </div>
         	</div>
          

           
           
                   <%@ include file="footer.jsp" %>
                
   </body>

</html>





