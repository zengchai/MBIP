<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <jsp:include page="../common/include-first.jsp" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      type="text/css"
      href="static/staff/css/dashboard.css"
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
    <%@ include file="/WEB-INF/views/common/include-first.jsp" %> 
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
                          <div class="main-title">Dashboard</div>
                          <div class="contentcontainer">
                            <div class="carboncontainer">
                              <div class="carbontitle">Carbon Footprint</div>
                              <div class="graph">
                                <canvas id="acquisitions"></canvas>
                              </div>
                              <div class="carbonvalue">${carbonreduction} kgCo<sub>2</sub></div>
                            </div>
                            <div class="subcontentcontainer">
                              <div class="contentbox">
                                <div class="contentleftbox">
                                  <span class="lets-icons--water-light"></span>
                                </div>
                                <div class="contentrightbox">
                                  <div class="contenttitle">Water Consumption</div>
                                  <div class="contentvalue">${waternum} m<sup>3</sup></div>
                                </div>
                              </div>
                              <div class="contentbox">
                                <div class="contentleftbox">
                                  <span class="pepicons-pencil--electricity"></span>
                                </div>
                                <div class="contentrightbox">
                                  <div class="contenttitle">Electricity Consumption</div>
                                  <div class="contentvalue">${elecnum} kWh</div>
                                </div>
                              </div>
                              <div class="contentbox">
                                <div class="contentleftbox">
                                  <span class="ph--recycle-light"></span>
                                </div>
                                <div class="contentrightbox">
                                  <div class="contenttitle">Recycle Consumption</div>
                                  <div class="contentvalue">${recyclingnum} Kg</div>
                                </div>
                              </div>
                              <div class="contentbox">
                                <div class="contentleftbox">
                                  <span class="fluent--people-20-regular"></span>
                                </div>
                                <div class="contentrightbox">
                                  <div class="contenttitle">People</div>
                                  <div class="contentvalue">${usernum} person</div>
                                </div>
                              </div>
                            </div>
                          </div>
                          <script>
                            const waterConsump = "${waternum}";
                            const elecConsump = "${elecnum}";
                            const recycleConsump = "${recyclingnum}";
                          </script>
                          <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
                          <script src="static/staff/js/acquisitions.js"></script>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>



  </body>
</html>
