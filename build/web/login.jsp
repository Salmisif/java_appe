
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 
     <head>
   	    <meta charset="utf-8">
   	    <meta name="viewport" content="width=device-width,initial-scale=1">
   	    <title>	Login page</title>
   	    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/login.css">
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

                <ul class="nav navbar-nav">

                    <li class="active">
                        <a href="home.jsp"><b><span class="link"> Home</span> </b><span class="glyphicon glyphicon-home"></span></b></a>
                    </li>
                    
                </ul>
            </div>
        </nav>
    	

    	<div class="container">

        <h1 align="center"> Welcome To Library System </h1> <br>  
    		<div class="form">    
                    <p align="center"> <strong>LOGIN</strong> AS AN ADMINSTRATOR</p>   
                    <form  role="form" action="login" method="post">
                        <div class="form-groyp">
                            <input class="form-control" type="text" name="username" id="username" placeholder="Username" required="required">
                        </div>
                       <div class="form-group">
                            <input class="form-control" type="password" name="password" id="password" placeholder="Password" required="required">
                        </div>
                        <div class="row">
                            <div class="  col-md-12 col-sm-12">
                                <div class="form-group">
                                    <input class="form-control btn btn-primary btn-block" type="submit" name="login" value="Login">
                                </div>
                            </div>
                        </div>
                    </form>
               	</div>	
    	</div>
    		
    	

     
           <%@ include file="footer.jsp"%>  
                 
   </body>
  
</html>






