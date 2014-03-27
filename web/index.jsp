<%-- 
    Document   : index
    Created on : 15-Mar-2010, 14:47:22
    Author     : bastinl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <script type="text/javascript">
            
            var request = null;
            
            //client side validation of the entered username, needs to be more than 7 characters
            function nameChange()
            {
                var username = document.getElementById("usernameid").value;
                var n = username.length;
                if(username != null && n > 7)
                {
                    document.getElementById("login_btn").style.visibility = "visible";
                }
                else
                    {
                        document.getElementById("login_btn").style.visibility = "none";
                    }
            }
            
            //checks if a username entered in the new username box already exists
            function checkIfUserExists()
            {
               //username is more than 7 therefore carry on
                    var newUsername = document.getElementById("newUsernameid").value;
                    request = new XMLHttpRequest();
                    if(request!=null)
                        {
                            request.open("POST","/coursework/do/addUser", true);
                            request.onreadystatechange = processHTTPResponse;
                            request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                            request.send("action=checkName&nUsername="+ newUsername.toString());

                        }
                   
                
            }
            
            function processHTTPResponse() {
                var newusername = document.getElementById("newUsernameid").value
                if (request.readyState == 4 && request.status == 200) 
                {
                    var div = document.getElementById("messageBox");
                    var userExistsValue = request.responseXML.documentElement.childNodes[0].textContent;
                    if("true" == (userExistsValue))
                    {
                        div.innerHTML ="<p>Username Already exists</p>";
                        document.getElementById("newUserBtn").style.visibility = "none"
                    }
                    else
                    {
                        div.innerHTML ="<p></p>";
                        document.getElementById("newUserBtn").style.visibility = "visible";
                    }
                    
                }
            }
            
            
            
            
        </script>
       
        <title>Login / sign up page</title>
    </head>
    <body>
        <h2>Please log in!</h2>
              <form method="POST" action="/coursework/do/login">
                Username:<input type="text" id="usernameid" name="username" value="" onchange="nameChange()" />----
                Password:<input type="password" name="password" value="" />        
        <input type="submit" id="login_btn" value="Click to log in" style="visibility:hidden" />
        </form>
        
        <form method="POST" action="/coursework/do/addUser">
            <h2> Don't yet have an account? </h2>
            Username:<input type="text" name="newUsername" id="newUsernameid" value="" onChange="checkIfUserExists()"/>----
                Password:<input type="password" name="newPassword" value="" />      
                <input type="submit" id="newUserBtn" value="Sign up as a new user" style="visibility:hidden"/>
        </form>
        
        <div id ="messageBox">
            
        </div>
        
    </body>
</html>
