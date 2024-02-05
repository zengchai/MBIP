<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/auth.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <jsp:include page="../common/include-first.jsp" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      type="text/css"
      href="static/common/css/error.css"
    />
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
    <%@ include file="/WEB-INF/views/common/header.jsp" %> 

    <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6"
    data-sidebartype="full" data-sidebar-position="fixed" data-header-position="fixed">
    <main>
        <div class="main-content">
            <%@ include file="/WEB-INF/views/common/adminSideBar.jsp" %>
            <div class="right-container">
                <div class="container-fluid">
                    <div class="card">
                        <div class="card-body">
                            hi
                          </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>



  </body>
</html>
