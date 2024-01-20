<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/css/headerCss.css">
  <title>Header</title>
</head>

<body>
  <div class='header-container'>
    <img class="header-background-image" src="/asset/headerIMG/upper bar image.png" alt="upper bar image">
    <img class="overlay-image" src="/asset/headerIMG/image MBIP.png" alt="image MBIP">

    <div class="login">
      <div style="grid-column: 1/2; grid-row: 1/2;">
        <h4><b>Account</b></h4>
      </div>
      <div style="grid-column: 2/3; grid-row: 1/2;">
        <img class="user-image" src="/asset/headerIMG/userIcon.png" alt="User Icon" onclick="handleImageClick()">
      </div>
      <div style="grid-column: 3/4; grid-row: 1/2;">
        <h4>Ali</h4>
      </div>
    </div>

    <script>
      function handleImageClick() {
        // Add your click handling logic here
        alert("Image clicked!");
      }
    </script>

  </div>
</body>

</html>