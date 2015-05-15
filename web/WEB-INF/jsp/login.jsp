<%-- 
    Document   : loginview
    Created on : Mar 19, 2015, 8:33:28 AM
    Author     : vladimir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Log-In</h1>
               
        <form name="login" action="verify.htm" method="POST">    
            <input type ="text" name ="username" maxlength="50"/><br>
            <input type ="password" name ="password" maxlength="50"/><br>
            <input type ="submit" value="Log-in"/>
        </form>
        
    </body>
</html>
