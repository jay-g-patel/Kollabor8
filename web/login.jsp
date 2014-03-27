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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> title</h1>
        <form method="POST" action="/kollabor8/do/login">
            Username : <input type="text" id="login_username" name="username" value=""/>
            Password: <input type="password" id="login_password" name="password" value=""/>
            <input type="submit" id="login_btn" value="Click to login"/>
        </form>
    </body>
</html>
