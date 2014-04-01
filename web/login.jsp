<%-- 
    Document   : login
    Created on : 12-Feb-2014, 14:07:55
    Author     : Jayshree
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" href="styleSheets/main.css" type="text/css"/>
        <link rel="stylesheet" href="styleSheets/login.css" type="text/css"/>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kollabor8 - Login</title>
    </head>
       <body>
           <div id="pageTitle"><h1> Title</h1></div>
        
        <form method="POST" action="/kollabor8/do/login">
            <div>
                Username : <input type="text" id="login_username" name="username" value=""/></div>
            <div>
                Password : <input type="password" id="login_password" name="password" value=""/></div>
            <div>
            <input type="submit" id="login_btn" value="Click to login"/>
            </div>
        </form>
    </body>
</html>
