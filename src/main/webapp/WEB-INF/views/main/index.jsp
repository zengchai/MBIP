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
		<c:if test="${sessionScope.user.getAuthenticated() == true && sessionScope.user.getLevel() == 1}">
			<c:redirect url="BillPage"/>
		</c:if>
    <c:if test="${sessionScope.user.getAuthenticated() == true && sessionScope.user.getLevel() == 2}">
			<c:redirect url="dashboard"/>
		</c:if>
			<div class="body-container">
                <div class="login-container">
                    <div class="logintitle">Login</div>
                    <form action="loginvalidation" method="post"><hr>
                        <div class="input-container">
                      <input type="text" id="username" name="username" placeholder="Username" required>
                      <input type="password" id="password" name="password" placeholder="Password" required>
                      <c:if test="${not empty error}">
                        <div class="error">
                            ${error}
                        </div>
                      </c:if>
                      <button id="loginbutton" type="submit">Login</button>
                      <a href="register" id="registerbut">Register</a>
                    </div>
                    </form>
                  </div>
            </div>

    </body>

</html>
