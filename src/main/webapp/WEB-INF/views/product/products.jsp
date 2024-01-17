<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="ISO-8859-1">
			<title>Products Page</title>

			<%@ include file="/WEB-INF/views/common/include-first.jsp" %>
		</head>

		<body>

			<%@ include file="/WEB-INF/views/common/header.jsp" %>


				<div class="container">
					<h2 class="center-align">Product List</h2>

					<table class="highlight">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Description</th>
								<th>Category</th>
								<th>Price</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${products}">
								<tr class="colored hoverable">
									<td>${product.getId()}</td>
									<td>${product.getName()}</td>
									<td>${product.getDescription()}</td>
									<td>${product.getCategory()}</td>
									<td>${product.getPrice()}</td>
									<td>
										<a class="btn-floating waves-effect waves-light btn-small" href="/product/formEditProduct?id=${product.getId()}">
											<i class="material-icons"  >create</i>
										</a>
										<a class="btn-floating waves-effect waves-light btn-small" href="/product/deleteProduct?id=${product.getId()}">
											<i class="material-icons"  >delete</i>
										</a>
									</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a class="btn waves-effect waves-light right" href="/product/formAddProduct">Add Product</a>
				</div>



				<jsp:include page="/WEB-INF/views/common/footer.jsp" />
				<%@ include file="/WEB-INF/views/common/include-last.jsp" %>
		</body>

		</html>