<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/auth.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="static/user/css/editprofile.css">
        <jsp:include page="../common/include-first.jsp" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
    </head>
    <body>

        <%@ include file="/WEB-INF/views/header.jsp" %> 

        <div class="main-container">
            <%@ include file="/WEB-INF/views/userSideBar.jsp" %> 
    
            <!-- Main Content Section -->
            <div class='main-content-container'>
                <div class="body-container">
                    <h1 class="main-title">
                        Profile
                    </h1>
                    <form action="updateprofile" method="post">
                    <div>
                        <div class="title">
                            Full Name
                        </div>
                        <div>
                            <input type="text" id="fullname" name="fullname" value="${sessionScope.user.getFullname()}"/>
                        </div>
                    </div>
                    <div>
                        <div class="title">
                            Nick Name
                        </div>
                        <div>
                            <input type="text" id="nickname" name="nickname" value="${sessionScope.user.getNickname()}"/>
                        </div>
                    </div>
                    <div>
                        <div class="title">Email</div>
                        <div>
                            <input type="text" id="email" name="email" value="${sessionScope.user.getEmail()}"/>
                        </div>
                    </div>
                    <div class="rows">
                    <div class="column">
                        <div>
                            <div class="title">Phone Number</div>
                            <div>
                                <input type="text" id="phonenum" name="phonenum" value="${sessionScope.user.getPhoneNum()}"/>
                            </div>
                        </div>
                        <div>
                            <div class="title">Category</div>
                            <div>
                                <select id="category" name="category" value="${sessionScope.user.getCategory()}">
                                    <option value="B1">B1</option>
                                    <option value="B2">B2</option>
                                    <option value="B3">B3</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="column">
                        <div>
                            <div class="title">Language</div>
                            <div>
                                <select id="language" name="language" value="${sessionScope.user.getPreferredLanguage()}">
                                    <option value="Mandarin">Mandarin</option>
                                    <option value="English">English</option>
                                    <option value="Malay">Malay</option>
                                </select>
                            </div>
                        </div>
                        <div>
                            <div class="title">Poscode</div>
                            <div>
                                <input type="text" id="poscode" name="poscode" value="${sessionScope.user.getPoscode()}"/>
                            </div>
                        </div>
                    </div>
                    </div>
                    <div>
                        <div  class="title">School / Institution address</div>
                        <div>
                            <input type="text" id="address" name="address" value="${sessionScope.user.getAddress()}"/>
                        </div>
                    </div>
                    <div class="center">
                        <button class="submitbutton">submit</button>
                    </div>
                </form>
                </div>
        </div>
    </div>
    <a href="logout">logout</a>
    </body>
</html>