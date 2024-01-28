<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <jsp:include page="../common/include-first.jsp" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="static/staff/css/dashboard.css">
        <title>Home</title>
    </head>
    <body>

      <jsp:include page="../common/header.jsp" />

      <div class="main-container">
          <jsp:include page="../common/sidebar.jsp" />
  
          <!-- Main Content Section -->
          <div class='main-content-container'>
              <div class="body-container">
                  <div class="main-title">
                      Dashboard
                  </div>
                <div class="contentcontainer">
                  <div class="carboncontainer">
                    <div>Carbon Footprint</div>
                    <div style="width: 100%;">
                      <canvas id="acquisitions"></canvas>
                    </div>
                  </div>
                  <div class="subcontentcontainer">
                    <div class="contentbox">
                      <div>Water Consumption</div>
                      <div>?</div>
                    </div>
                    <div class="contentbox">
                      <div>Electricity Consumption</div>
                      <div>?</div>
                    </div>
                    <div class="contentbox">
                      <div>Recycle Consumption</div>
                      <div>?</div>
                    </div>
                    <div class="contentbox">
                      <div>People</div>
                      <div>?</div>
                    </div>
                  </div>
                </div>
                  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
                  <script src="static/staff/js/acquisitions.js"></script>
              </div>
      </div>
  </div>
  </body>
    </html>
