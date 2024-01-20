<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EL Examples</title>
</head>
<body>
    <h1>Examples: Accessing Data</h1>
    <!-- type1 -->
    <h2>1. using jsp:UseBean</h2>
    <jsp:useBean  id="product" scope="request" class ="my.utm.ip.jstl.Product" />

    <label>Product Id</label>
    <b><jsp:getProperty name="product" property="id"/> </b><br/>

    <label>Product Name</label>
    <b><jsp:getProperty name="product" property="name"/> </b><br/>

    <label>Product Category</label>
    <b><jsp:getProperty name="product" property="category"/> </b><br/>
    

    <br/>
    <!-- type2 -->
    <h2>2. using  EL's Dot operator</h2>
    
    <label>Product Id</label>
    <b>${product.id}</b><br/>

    <label>Product Name</label>
    <b>${product.name}</b><br/>

    <label>Product Category</label>
    <b>${product.category}</b><br/>

    <!-- type3 -->
    <br/>
    <h2>3. using EL's square operator</h2>
    <label>Product Id</label>
    <b>${product["id"]}</b><br/>

    <label>Product Name</label>
    <b>${product["name"]}</b><br/>

    <label>Product Category</label>
    <b>${product['category']}</b><br/>

    





</body>
</html>