<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recycling Page</title>
    <link rel="stylesheet" type="text/css" href="/css/recycling.css">
</head>
<body>
        <jsp:include page="header.jsp" />    
    <main>
        <div class="main-content">
            <jsp:include page="userSideBar.jsp" />
            <div class="left-container">
                <div class="logo-container">
                    <img src="/asset/back.png" alt="Back Logo" class="logo">
                </div>    
            </div>
            <div class="right-container">
                <div class="title">
                    <h1>Recycling bill</h1>
                    <p>Please enter the recycling bill data values</p>
                </div>
                <div class="form">
                    <form>
                        <label for="weight">Weight of recycling material (kg):</label>
                        <input type="text" id="weight" name="weight" required>
                        
                        <label for="days">Days:</label>
                        <input type="text" id="days" name="days" required>
                        

                    </form>
                </div>
                <div class="button">
                    <button class="next-button">Next</button>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
