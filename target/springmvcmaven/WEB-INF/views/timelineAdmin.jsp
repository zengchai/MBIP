<%@ page import="java.util.ArrayList" %>

<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Timeline</title>
        <link rel="stylesheet" type="text/css" href="/static/css/timeline.css">
        <style> 

        </style>
         <% ArrayList<String> event= new ArrayList<String>();
            event.add("Gerak Komuniti 3.0");
            event.add("Gerak Komuniti 2.0"); 
            event.add("Gerak Komuniti 1.0");%>
        <% ArrayList<String> eventdesc= new ArrayList<String>();
            eventdesc.add("Penawaran Geran ini bermula pada tahun 2021 dan diteruskan sehingga kini. Pada tahun 2021, Geran Komuniti Iskandar Puteri Rendah Karbon 1.0 menawarkan sehingga RM200,000.00, manakala penawaran Geran Komuniti Iskandar Puteri Rendah Karbon 2.0 dan 3.0 adalah pada RM500,000.00. ");
            eventdesc.add("Penawaran Geran ini bermula pada tahun 2021 dan diteruskan sehingga kini. Pada tahun 2021, Geran Komuniti Iskandar Puteri Rendah Karbon 1.0 menawarkan sehingga RM200,000.00, manakala penawaran Geran Komuniti Iskandar Puteri Rendah Karbon 2.0 dan 3.0 adalah pada RM500,000.00. "); 
            eventdesc.add("Penawaran Geran ini bermula pada tahun 2021 dan diteruskan sehingga kini. Pada tahun 2021, Geran Komuniti Iskandar Puteri Rendah Karbon 1.0 menawarkan sehingga RM200,000.00, manakala penawaran Geran Komuniti Iskandar Puteri Rendah Karbon 2.0 dan 3.0 adalah pada RM500,000.00. ");%>        
    </head>
    <body>
       
            <jsp:include page="header.jsp" />
            <div class="main-container">
                <jsp:include page="adminSideBar.jsp" />
                <div class="container">
                <div class="title">

                    <h2><U>Timeline</U></h2>
                </div>
                <div class="subhead">
                    <h4><%= getCurrentDate() %></h4>
                    <div class="addbutton" onclick="openModal()">  
                        
                        <img src="/static/asset/plus 1.png" alt="plusbutton">

                    </div>
                </div>
                    

                        <div class="infotable">
                            <table>
                                <tr>
                                    <th class="table-heading">
                                        <div class="event-name"><%= event.get(0) %></div>
                                        <div class="button-container">
                                            <a href="/edit-event">
                                                <img style="width: 36px; height: 36px;" src="/asset/edit.png" alt="editbutton">
                                            </a>
                                            <a href="/delete-event">
                                                <img style="width: 40px; height: 33px; padding-top: 0.1rem;" src="/asset/delete.png"  alt="deletebutton">
                                            </a>
                                        </div>
                                    </th>                     
                                </tr>
                                <tr>
                                    <td><%= eventdesc.get(0) %></td>                  
                                </tr>
                            </table>
                        </div>
                        <div class="infotable">
                            <table>
                                <tr>
                                    <th class="table-heading">
                                        <div class="event-name"><%= event.get(1) %></div>
                                        <div class="button-container">
                                            <a href="/edit-event">
                                                <img style="width: 36px; height: 36px;" src="/asset/edit.png" alt="editbutton">
                                            </a>
                                            <a href="/delete-event">
                                                <img style="width: 40px; height: 33px; padding-top: 0.1rem;" src="/asset/delete.png"  alt="deletebutton">
                                            </a>
                                        </div>
                                    </th>                             
                                </tr>
                                <tr>
                                    <td><%= eventdesc.get(1) %></td>                  
                                </tr>
                            </table>
                        </div>
                        <div class="infotable">
                            <table>
                                <tr>
                                    <th class="table-heading">
                                        <div class="event-name"><%= event.get(2) %></div>
                                        <div class="button-container">
                                            <a href="/edit-event">
                                                <img style="width: 36px; height: 36px;" src="/asset/edit.png" alt="editbutton">
                                            </a>
                                            <a href="/delete-event">
                                                <img style="width: 40px; height: 33px; padding-top: 0.1rem;" src="/asset/delete.png" alt="deletebutton">
                                            </a>
                                        </div>
                                    </th>                            
                                </tr>
                                <tr>
                                    <td><%= eventdesc.get(2) %></td>                  
                                </tr>
                            </table>
                        </div>

                    </div>
                    
                    <div id="myModal" class="modal">

                        <table >
                            <tr>
                                <th>Event Information</th>
                            </tr>
                            <tr>
                                <td>
                                    <form>
                                        <div class="form-title">
                                            <label for="title" style="margin-bottom: 10px;">Title:</label>
                                            <input type="text" id="title" name="title" style="width: 100%;" required>
                                        </div>
                        
                                        <div class="form-desc">
                                            <label for="description" style="margin-bottom: 10px;">Description:</label>
                                            <textarea id="description" name="description" rows="4" style="width: 100%;" required></textarea>
                                        </div>
                        
                                        <div class="form-link">
                                            <label for="link" style="margin-bottom: 10px;" >Link:</label>
                                            <input type="text" id="link" name="link" style="width: 100%;" required>
                                        </div>
                        
                                        <div class="form-date">
                                            <label for="date"style="margin-bottom: 10px;">Date:</label>
                                            <input type="date" id="date" name="date" style="width: 100%;" required>
                                        </div>
                        
                                      
                                    </form>
                                    
                                </td>
                            </tr>
                        </table>
                        <br><br>
                        <button type="button" onclick="submitForm()">Add</button>
                        <button onclick="closeModal()">Close</button>
                    </div>
            </div>
            <script>
            function openModal() {
                        document.getElementById('myModal').style.display = 'block';
                    }

                    function closeModal() {
                        document.getElementById('myModal').style.display = 'none';
                    }

                    function submitForm() {
                        // Add logic to handle form submission
                        // You can retrieve values from the form elements (e.g., document.getElementById('title').value)
                        // Perform actions like sending data to the server, updating the UI, etc.
                        alert('Form submitted!');
                        closeModal(); // Close the modal after submission (you can remove this if not needed)
                    }
            </script>
            <%!
            // Java code to get the current date in a formatted string
            String getCurrentDate() {
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
                return dateFormat.format(new Date());
            }
            
            %>
        </body>
</html>