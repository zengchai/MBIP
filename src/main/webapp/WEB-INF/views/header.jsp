<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/static/css/headerCss.css">
  <style>
    .dropdown {
      position: relative;
      display: inline-block;
    }

    .dropdown-content {
      display: none;
      position: absolute;
      background-color: #f9f9f9;
      min-width: 160px;
      box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
      z-index: 1;
    }

    .dropdown-content a {
      color: black;
      padding: 12px 16px;
      text-decoration: none;
      display: block;
    }

    .dropdown-content a:hover {
      background-color: #f1f1f1;
    }
  </style>
  <title>Header</title>
</head>

<body>
  <div class='header-container'>
    <img class="header-background-image" src="/static/asset/headerIMG/upper bar image.png" alt="upper bar image">
    <img class="overlay-image" src="/static/asset/headerIMG/image MBIP.png" alt="image MBIP">

    <div class="login">
      <div style="grid-column: 1/2; grid-row: 1/2;">
        <h4><b>Account</b></h4>
      </div>
      <div style="grid-column: 2/3; grid-row: 1/2;" class="dropdown">
        <img class="user-image" src="/static/asset/headerIMG/userIcon.png" alt="User Icon" onclick="toggleDropdown()">
        <div id="dropdown-menu" class="dropdown-content">
          <a href="/updateprofile?fullname=${sessionScope.user.getFullname()}
          &nickname=${sessionScope.user.getNickname()}&email=${sessionScope.user.getEmail()}
          &phonenum=${sessionScope.user.getPhoneNum()}&language=${sessionScope.user.getPreferredLanguage()}
          &category=${sessionScope.user.getCategory()}&poscode=${sessionScope.user.getPoscode()}
          &address=${sessionScope.user.getAddress()}">Profile</a>
          <a href="/logout">Logout</a>
        </div>
      </div>
      <div style="grid-column: 3/4; grid-row: 1/2;" class="dropdown">
        <h4>${sessionScope.user.getUsername()}</h4>
      </div>
    </div>

    <script>
      var dropdownVisible = false;
    
      function toggleDropdown() {
        var dropdown = document.getElementById("dropdown-menu");
        dropdown.style.display = dropdownVisible ? 'none' : 'block';
        dropdownVisible = !dropdownVisible;
      }
    
      // Close the dropdown if the user clicks outside of it
      window.onclick = function(event) {
        if (!event.target.matches('.user-image')) {
          var dropdowns = document.getElementsByClassName("dropdown-content");
          for (var i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.style.display === 'block') {
              openDropdown.style.display = 'none';
              dropdownVisible = false;
            }
          }
        }
      }
    </script>
    
  </div>
</body>
</html>