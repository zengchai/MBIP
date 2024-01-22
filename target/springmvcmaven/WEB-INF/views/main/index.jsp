<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>

    <link rel="stylesheet" href="static/user/css/home.css">
  </head>

<body>
		<c:if test="${sessionScope.user.getAuthenticated()== true}">
            <c:out value="Authenticated: ${sessionScope.user.getAuthenticated()}" />
			<c:redirect url="editprofile"/>
		</c:if>
			<div class="body-container">
                <div class="login-container">
                    <div class="logintitle">Login</div>
                    <form action="login" method="post"><hr>
                        <div class="input-container">
                      <input type="text" id="username" name="username" placeholder="Username">
                      <input type="password" id="password" name="password" placeholder="Password">
                      <div class="forgotpassword">
                        <a>Forget password?</a>
                      </div>
                      <button id="loginbutton" type="submit">Login</button>
                      <a href="register" id="registerbut">Register</a>
                    </div>
                    </form>
                  </div>
            </div>
            Hello <p>${name}</p>. Welcome to the system!
    
            <!-- Href links -->
            <ul>
                <li><a href="/electricitybill">Electricity Bill</a></li>
                <li><a href="/recyclingbill">Recycling Bill</a></li>
                <li><a href="/waterbill">Water Bill</a></li>
                <li><a href="/electricity">Electricity form</a></li>
                <li><a href="/recycling">Recycling form</a></li>
                <li><a href="/water">Water form</a></li>
                <li><a href="/pertandinganadmin">Adminview pertandingan</a></li>
                <li><a href="/timeline">Timeline</a></li>
                <li><a href="/reportviewanalysis">Adminview report analysis</a></li>
                <li><a href="/reportcalculation">Adminview report calculation</a></li>
                <li><a href="/competitionUser">userview pertandingan</a></li>
                <li><a href="/certificate">certificate</a></li>
            </ul>
    </body>

</html>
