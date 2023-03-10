<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>POTENTIAL MASTER</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
	integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>


</head>

<body>


	<%@include file="header.html"%>

	<br>
	<div class="container col-md-7">
		<div class="card">
			<div class="card-body">
				<c:if test="${product != null}">
					<form action="update" method="get">
				</c:if>
				<c:if test="${product == null}">
					<form action="insert" method="get">
				</c:if>
				<caption>
					<h2>
						<c:if test="${product != null}">
                                    Edit Product
                                </c:if>
						<c:if test="${product == null}">
                                    Add New Product
                                </c:if>
					</h2>
				</caption>
				<c:if test="${product != null}">
					<input type="hidden" name="id" value="<c:out value='${product.ID}' />" />
				</c:if>




				<fieldset >
					<label>PRODUCT_NAME</label><br/> <input type="text"
						value="<c:out value='${product.PRODUCT_NAME}' />"
						class="form-control" name="PRODUCT_NAME">
				</fieldset>

				<fieldset >
					<label>GRADE</label><br/> <input type="text"
						value="<c:out value='${product.GRADE}' />"
						class="form-control" name="GRADE">
				</fieldset>

				<fieldset class="form-group">
					<label>UNIT OF MEASUREMENT</label> <input type="text"
						value="<c:out value='${product.UNIT_OF_MEASUREMENT}' />"
						class="form-control" name="UNIT_OF_MEASUREMENT">
				</fieldset>


				<fieldset class="form-group">
					<label>HS CODE</label> <input type="text"
						value="<c:out value='${product.HS_CODE}' />"
						class="form-control" name="HS_CODE">
				</fieldset>
				<fieldset class="form-group">
					<label>MANUFACTURER</label> <input type="text"
						value="<c:out value='${product.MANUFACTURER}' />"
						class="form-control" name="MANUFACTURER">
				</fieldset>
				<fieldset class="form-group">
					<label>COUNTRY</label> <select name="city2" id="city2"
						onchange="SelectedTextValue15(this)" class="form-control">

						<option selected="selected" value=""></option>


					</select> <input type="text" id="txtcontent15" name="txtcontent15"
						value="<c:out value='${product.city}' />" />
				</fieldset>
				<fieldset class="form-group">
					<label>TDS</label> <input type="file"
						value="<c:out value='${product.TDS}' />"
						class="form-control" name="TDS">
				</fieldset>
				<fieldset class="form-group">
					<label>MSDS</label> <input type="file"
						value="<c:out value='${product.MSDS}' />" class="form-control"
						name="MSDS">
				</fieldset>


				<fieldset class="form-group">
					<label>FREE TRADE AGREEMENT</label> <input type="file"
						value="<c:out value='${product.FREE_TRADE_AGREEMENT}' />"
						class="form-control" name="FREE_TRADE_AGREEMENT">
				</fieldset>
				<fieldset class="form-group">
					<label>IMAGE</label> <input type="file"
						value="<c:out value='${product.IMAGE}' />" class="form-control"
						name="IMAGE">
				</fieldset>



				<button type="submit" onsubmit="insertProduct()"
					class="btn btn-success">Save</button>


				</form>
			</div>
		</div>
	</div>

	<script>
		function SelectedTextValue4(ele) {
			if (ele.selectedIndex > 0) {
				var selectedText = ele.options[ele.selectedIndex].innerHTML;
				var selectedValue = ele.value;
				document.getElementById("txtcontent10").value = selectedText;

			} else {
				document.getElementById("txtcontent10").value = "";
			}
		}
		function SelectedTextValue7(ele) {
			if (ele.selectedIndex > 0) {
				var selectedText = ele.options[ele.selectedIndex].innerHTML;
				var selectedValue = ele.value;
				document.getElementById("txtcontent11").value = selectedText;
			} else {
				document.getElementById("txtcontent11").value = "";
			}
		}
		function SelectedTextValue6(ele) {
			if (ele.selectedIndex > 0) {
				var selectedText = ele.options[ele.selectedIndex].innerHTML;
				var selectedValue = ele.value;
				document.getElementById("txtcontent12").value = selectedText;
			} else {
				document.getElementById("txtcontent12").value = "";
			}
		}
		function SelectedTextValue13(ele) {
			if (ele.selectedIndex > 0) {
				var selectedText = ele.options[ele.selectedIndex].innerHTML;
				var selectedValue = ele.value;
				document.getElementById("txtcontent13").value = selectedText;
			} else {
				document.getElementById("txtcontent13").value = "";
			}
		}
		function SelectedTextValue14(ele) {
			if (ele.selectedIndex > 0) {
				var selectedText = ele.options[ele.selectedIndex].innerHTML;
				var selectedValue = ele.value;
				document.getElementById("txtcontent14").value = selectedText;
			} else {
				document.getElementById("txtcontent14").value = "";
			}
		}
		function SelectedTextValue15(ele) {
			if (ele.selectedIndex > 0) {
				var selectedText = ele.options[ele.selectedIndex].innerHTML;
				var selectedValue = ele.value;
				document.getElementById("txtcontent15").value = selectedText;
			} else {
				document.getElementById("txtcontent15").value = "";
			}
		}
	</script>


	<%@include file="footer.html"%>
</body>

</html>
