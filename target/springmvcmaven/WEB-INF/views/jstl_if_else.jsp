<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>JSTL Examples</title>
        </head>

        <body>
            <h1>If-Else Example</h1>
            <h2>Example: Show a product's price in bold and red if it is greater than 100</h2>
            <h2>and in italic and green color if otherwise</h2>

            <c:forEach var="product" items="${list}">

                <label>Product Id</label>
                <b>${product.id}</b><br />

                <label>Product Name</label>
                <b>${product.name}</b><br />

                <label>Product Category</label>
                <b>${product.category}</b><br />

                <label>Price</label>

                

                <c:choose>
                    <c:when test="${product.price>100}">
                        <c:set var="style" value="color:red; font-weight:bold" ></c:set>
                    </c:when>
                    <c:otherwise>
                        <c:set var="style" value="color:green; font-style:italic" ></c:set>
                    </c:otherwise>
                </c:choose>


                <p style="${style}">${product.price}</p><br />

                <br />

            </c:forEach>


        </body>

        </html>