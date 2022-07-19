
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 
     <head>
   	    <meta charset="utf-8">
   	    <meta name="viewport" content="width=device-width,initial-scale=1">
   	    <title>	add page</title>
   	    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
            <link rel="stylesheet" type="text/css" href="css/ajout.css">
            <link rel="stylesheet" type="text/css" href="css/navbar.css">

     </head>
     <body>
          <style type="text/css">
            nav
            {
                background-color:none;
                margin:none;
            }
            a
            {
                color:black;
            }
            a:hover
            {
	 	font-size:20px;
	 	font-family:cursive;;
	 	color:blue;
	 	border-radius:10px;
	 	
            }
            

          </style>
           <nav class="navbar" >
            <div class="container-fluid" >
                <ul class="nav navbar-nav navbar-right">                   
	            <li>
			<a href="deconnexion.jsp"><b><span class="link">SignOut</span><span class="glyphicon glyphicon-link"></span></b></a>
                    </li>	            
	        </ul> 
		<ul class="nav navbar-nav">
                    <li class="active">
			<a href="home.jsp"><b><span class="link"> Home</span> </b><span class="glyphicon glyphicon-home"></span></b></a>
                    </li>         
                </ul>
            </div>
        </nav>
        


          <div class="container">

              <div clas="row">

                  <div class="col-md-12">

                        <div class="form">
                            <h2 align="center">Here you Can ADD</h2>
                              <h2 align="center">Book or Author</h2>

                             
                                   <div class="form-group content" align="center">         
                                       <a class="btn btn-primary btn-lg" href="addbook_nv.jsp">ADD Book</a>
                                      <a class="btn btn-primary btn-lg" href="addauthor.jsp">ADD Author</a>
                                     
                                     
                                    </a>

                                   </div>
                                         
                               
                          

                              </div>

                          </div>
                </div>
          </div>
          </div>
    	      
           
             
      <%@ include file="footer.jsp" %>          
   </body>
  
</html>
