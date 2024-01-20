<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/css/certificate.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
        <title>Certificate</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <div class="main-container">
            <jsp:include page="userSideBar.jsp" />
    
            <!-- Main Content Section -->
            <div class='main-content-container'>
                <!-- Your main content goes here -->
                <div class="title">
                    <a href="#" class="btn btn-outline-primary mb-2 position-absolute rounded-circle bg-black-hover" style="color: black; border-color: black; margin-left:-50px;">
                        <i class="fas fa-arrow-left"></i>
                    </a>
                    <h3 style="margin-left:30px;"><b>Certificate for Participation</b></h3>
                </div>

                <div class="image-container">
                    <img src="/asset/certificateIMG/image certificates.png" alt="Your certificate">
                    <a href="#" class="download-button" style="text-decoration: none;">Download</a>
                </div>
            </div>
        </div>
    
    </body>
</html>