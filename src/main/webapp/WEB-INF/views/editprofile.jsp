<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="/static/css/editprofile.css">
        <link rel="stylesheet" type="text/css" href="/static/css/recycling.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
    </head>
    <body>
        <header>
            Recycling bill    
        </header>
        <main>
            <div class="main-content">
        <div class="left-container">
            <div class="logo-container">
                <img src="/static/asset/back.png" alt="Back Logo" class="logo">
            </div>    
        </div>
        <div class="right-container">
            <form>
                <div class="body-container">
                    <div class="main-title">
                        Edit Profile
                    </div>
                    <div>
                        <div class="title">
                            Full Name
                        </div>
                        <div>
                            <input type="text" id="fullname" name="fullname"/>
                        </div>
                    </div>
                    <div>
                        <div class="title">
                            Nick Name
                        </div>
                        <div>
                            <input type="text" id="nickname" name="nickname"/>
                        </div>
                    </div>
                    <div>
                        <div class="title">Email</div>
                        <div>
                            <input type="text" id="email" name="email"/>
                        </div>
                    </div>
                    <div class="row">
                    <div class="column">
                        <div>
                            <div class="title">Phone Number</div>
                            <div>
                                <input type="text" id="phonenum" name="phonenum"/>
                            </div>
                        </div>
                        <div>
                            <div class="title">Category</div>
                            <div>
                                <select id="language" name="language">
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
                                <select id="language" name="language">
                                    <option value="Mandarin">Mandarin</option>
                                    <option value="English">English</option>
                                    <option value="Malay">Malay</option>
                                </select>
                            </div>
                        </div>
                        <div>
                            <div class="title">Poscode</div>
                            <div>
                                <input type="text" id="poscode" name="poscode"/>
                            </div>
                        </div>
                    </div>
                    </div>
                    <div>
                        <div  class="title">School / Institution address</div>
                        <div>
                            <input type="text" id="address" name="address"/>
                        </div>
                    </div>
                    <div class="center">
                        <button class="submitbutton">submit</button>
                    </div>
                </div></form>
        </div>
    </div>
</main>
    </body>
</html>