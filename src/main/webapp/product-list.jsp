<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>



<body>

	<%@include file="header.html"%>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Products</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Product</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>PRODUCT_CODE</th>
						<th>PRODUCT_NAME</th>
						<th>GRADE</th>
						<th>UNIT_OF_MEASUREMENT</th>
						<th>HS_CODE</th>
						<th>MANUFACTURER</th>
						<th>COUNTRY</th>
						<th>TDS</th>
						<th>MSDS</th>
						<th>FREE_TRADE_AGREEMENT</th>
						<th>IMAGE</th>
						
					</tr>
				</thead>
				<tbody>
					<!--for(Todo todo: todos){-->
					<c:forEach var="product" items="${listProduct}">

						<tr>
							<td><c:out value="${product.ID}" /></td>
							<td><c:out value="${product.PRODUCT_CODE}" /></td>
							<td><c:out value="${product.PRODUCT_NAME}" /></td>
							<td><c:out value="${product.GRADE}" /></td>
							<td><c:out value="${product.UNIT_OF_MEASUREMENT}" /></td>
							<td><c:out value="${product.HS_CODE}" /></td>
							<td><c:out value="${product.MANUFACTURER}" /></td>
							<td><c:out value="${product.COUNTRY}" /></td>
							<td><c:out value="${product.TDS}" /></td>
							<td><c:out value="${product.MSDS}" /></td>
							<td><c:out value="${product.FREE_TRADE_AGREEMENT}" /></td>
                            <td><c:out value="${product.IMAGE}" /></td>
						



							<td><a href="edit?id=<c:out value='${user.ID}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${user.ID}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
	<%@include file="footer.html"%>
</body>

</html>