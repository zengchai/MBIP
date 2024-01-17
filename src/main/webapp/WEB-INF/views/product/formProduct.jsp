<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Add Product Form</title>

    <%@ include file="/WEB-INF/views/common/include-first.jsp" %>
    
</head>

<body>

    <%@ include file="/WEB-INF/views/common/header.jsp" %>

    <div class="container">
        <h2 class="center-align">Add Product</h2>
        <c:choose>
            <c:when test="${mode eq 'add'}">
                <c:set var="action" value="/product/addProduct" />
            </c:when>
            <c:otherwise>
                <c:set var="action" value="/product/editProduct" />
            </c:otherwise>
        </c:choose>

        <form action="${action}" method="post" id="productForm">

            <input type="hidden" name="productId" id="productId" value="${product.getId()}">

            <label for="productName">Product Name</label>
            <div class="input-field">
                <input type="text" id="productName" name="productName" value="${product.getName()}">
            </div>

            <label for="productDescription">Product Description</label>
            <div class="input-field">
                <!-- Fix: Removed unnecessary aria-valuetext attribute -->
                <textarea id="productDescription" name="productDescription" class="materialize-textarea">${product.getDescription()}</textarea>
            </div>
            
            <label for="productCategory">Product Category</label>
            <div class="input-field">
                <input type="text" id="productCategory" name="productCategory" value="${product.getCategory()}">
            </div>
            
            <label for="productPrice">Product Price</label>
            <div class="input-field">
                <input type="number" id="productPrice" name="productPrice" value="${product.getPrice()}">
            </div>

            <button class="btn waves-effect waves-light" type="submit">Confirm</button>
            <button class="btn waves-effect waves-light" type="button" onclick="cancelForm()">Cancel</button>
            <button class="btn waves-effect waves-light" type="button" onclick="clearForm()">Clear</button>
        </form>
    </div>


    <%@ include file="/WEB-INF/views/common/include-last.jsp" %>

    <script src="/static/product/js/script.js"></script>

    
    
</body>

</html>
