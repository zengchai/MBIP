<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Products Page</title>

            <%@ include file="/WEB-INF/views/common/include-first.jsp" %>

                <style>
                    /* Add any custom styles for your error page here */
                    body {
                        background-color: #f4f4f4;
                    }

                    .error-container {
                        max-width: 600px;
                        margin: 50px auto;
                        padding: 20px;
                        background-color: #fff;
                        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                        border-radius: 5px;
                    }

                    h1 {
                        color: #d32f2f;
                        /* Materialize red color */
                    }
                </style>
        </head>

        <body>

            <%@ include file="/WEB-INF/views/common/header.jsp" %>


                    <div class="error-container">
                        <h1>Error Page</h1>

                        <p>An error occurred while processing your request.</p>

                        <c:if test="${not empty errorMessage}">
                            <p>Error Details: ${errorMessage}</p>
                        </c:if>

                        <a href="/">Back to Home</a>
                    </div>

                <jsp:include page="/WEB-INF/views/common/footer.jsp" />
                <%@ include file="/WEB-INF/views/common/include-last.jsp" %>
        </body>

        </html>