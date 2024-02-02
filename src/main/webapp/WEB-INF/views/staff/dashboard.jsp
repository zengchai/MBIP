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
  </head>
  <body>
    <jsp:include page="../common/header.jsp" />

    <div class="main-container">
      <jsp:include page="../common/sidebar.jsp" />

      <!-- Main Content Section -->
      <div class="main-content-container">
        <div class="body-container">
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
  </body>
</html>
