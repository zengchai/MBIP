<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="static/user/css/home.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
    </head>
    <body>
        <div class="body-container">
            <div class="login-container">
                <div class="logintitle">Register</div>
                <form action="registervalidation" method="post"><hr>
                    <div class="input-container">
                        <input type="text" id="username" name="username" placeholder="Username">
                        <input type="text" id="email" name="email" placeholder="Email">
                        <input type="password" id="password" name="password" placeholder="Password">
                  <button id="submitbutton" type="submit">Submit</button>
                  <div class="log-container">Already Have An Account? <a href="editprofile">Log In</a></div>
                </div>
                </form>
              </div>
        </div>
    </body>
</html>