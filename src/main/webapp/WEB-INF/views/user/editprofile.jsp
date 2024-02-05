<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/auth.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="static/user/css/editprofile.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>

    <style>
      .main-content {
        display: flex;
        flex: 1;
        background-color: #fff;
        justify-content: space-between;
        overflow: hidden; /* Prevent content overflow */
      }

      .right-container {
        height: 100%;
        width: 87%;
        /*border: 1px solid black;*/
        display: flex;
        flex-direction: column;
        padding: 20px;
      }
    </style>
  </head>
  <body>
    <%@ include file="/WEB-INF/views/common/include-first.jsp" %><%@ include
    file="/WEB-INF/views/common/header.jsp" %>

    <div
      class="page-wrapper"
      id="main-wrapper"
      data-layout="vertical"
      data-navbarbg="skin6"
      data-sidebartype="full"
      data-sidebar-position="fixed"
      data-header-position="fixed"
    >
      <main>
        <div class="main-content">
          <%@ include file="/WEB-INF/views/common/userSideBar.jsp" %>
          <div class="right-container">
            <div class="container-fluid">
              <div class="card">
                <div class="card-body">
                  <!-- Main Content Section -->

                  <div class="main-title">Edit Profile</div>
                  <form
                    action="updateprofile"
                    method="post"
                    onsubmit="return validateForm()"
                  >
                    <input
                      type="hidden"
                      id="message"
                      name="message"
                      value="true"
                    />
                    <div>
                      <div class="title">Full Name</div>
                      <div>
                        <input
                          type="text"
                          id="fullname"
                          name="fullname"
                          value="${sessionScope.user.getFullname().trim()}"
                        />
                      </div>
                    </div>
                    <div>
                      <div class="title">Nick Name</div>
                      <div>
                        <input
                          type="text"
                          id="nickname"
                          name="nickname"
                          value="${sessionScope.user.getNickname().trim()}"
                        />
                      </div>
                    </div>
                    <div>
                      <div class="title">Email</div>
                      <div>
                        <input
                          type="text"
                          id="email"
                          name="email"
                          value="${sessionScope.user.getEmail().trim()}"
                        />
                      </div>
                    </div>
                    <div class="rows">
                      <div class="column">
                        <div>
                          <div class="title">Phone Number</div>
                          <div>
                            <input
                              type="text"
                              size="60"
                              id="phonenum"
                              name="phonenum"
                              value="${sessionScope.user.getPhoneNum().trim()}"
                            />
                          </div>
                        </div>
                        <div>
                          <div class="title">Category</div>
                          <div>
                            <select
                              id="category"
                              style="min-width: 60"
                              name="category"
                              value="${sessionScope.user.getCategory()}"
                            >
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
                            <select
                              id="language"
                              style="min-width: 60"
                              name="language"
                              value="${sessionScope.user.getPreferredLanguage()}"
                            >
                              <option value="Mandarin">Mandarin</option>
                              <option value="English">English</option>
                              <option value="Malay">Malay</option>
                            </select>
                          </div>
                        </div>
                        <div>
                          <div class="title">Poscode</div>
                          <div>
                            <input
                              type="text"
                              size="60"
                              id="poscode"
                              name="poscode"
                              value="${sessionScope.user.getPoscode().trim()}"
                            />
                          </div>
                        </div>
                      </div>
                    </div>
                    <div>
                      <div class="title">School / Institution address</div>
                      <div>
                        <input
                          type="text"
                          id="address"
                          name="address"
                          value="${sessionScope.user.getAddress().trim()}"
                        />
                      </div>
                    </div>
                    <div class="center">
                      <button class="submitbutton">submit</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
    <c:if test="${message}">
        <div class="overlay" id="popupOverlay">
            <div class="popup">
              <p>The information has updated successfully.</p>
              <button class="close-btn" onclick="closePopup()">OK</button>
            </div>
          </div>
    </c:if>
    
  </body>
</html>

<script>
  function validateForm() {
    var fullname = document.getElementById("fullname").value.trim();
    var phonenum = document.getElementById("phonenum").value.trim();
    var poscode = document.getElementById("poscode").value.trim();

    // Validate phone number - check if it's numeric
    if (isNaN(phonenum)) {
      alert("Phone number must be numeric.");
      return false;
    }

    // Validate postcode - check if it's numeric
    if (isNaN(poscode)) {
      alert("Poscode must be numeric.");
      return false;
    }

    // Validate full name - check if it contains only letters
    if (!/^[a-zA-Z ]+$/.test(fullname)) {
      alert("Full name must contain only letters.");
      return false;
    }

    return true; // Form is valid
  }


  // Function to close the popup
  function closePopup() {
    document.getElementById("popupOverlay").style.display = "none";
  }
</script>
