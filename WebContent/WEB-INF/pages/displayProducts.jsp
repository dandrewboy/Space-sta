<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Space-sta Products</title>
</head>
<body>
	<!-- Page displays a table of products from the database -->
	<table style="border: 1px solid black;">
		<tr>
			<th style="border: 1px solid black; padding: 5px;"><label>Product Name</label></th>
			<th style="border: 1px solid black; padding: 5px;"><label>Qty</label></th>
			<th style="border: 1px solid black; padding: 5px;"><label>Price</label></th>
			<th style="border: 1px solid black; padding: 5px;"><label>Desc</label></th>
			<th style="border: 1px solid black; padding: 5px;"><label>Action</label></th>
		</tr>
			<c:forEach var="product" items="${products}" varStatus="status">
				<tr>
				<td style="border: 1px solid black; padding: 5px;">${product.productName}</td>
				<td style="border: 1px solid black; padding: 5px;"><label>${product.productQuantity}</label></td>
				<td style="border: 1px solid black; padding: 5px;"><label>${product.productPrice}</label></td>
				<td style="border: 1px solid black; padding: 5px;"><label>${product.productDescription}</label></td>
				<td style="border: 1px solid black; padding: 5px;">
					<c:url var="deleteProd" value="/deleteProd">
					<c:param name="prodId" value="${product.prodId}"/>
					</c:url>
					<c:url var="updateProd" value="/updateProd">
					<c:param name="prodId" value="${product.prodId}"/>
					</c:url>
					<a href="${updateProd}">Update</a>
					<a href="${deleteProd}">Delete
					<script type="text/javascript" >
					function deleteConfirmation() {
						confirm("WARNING! n\This will permanentley remove this product from the database. n\Are you sure you wish to do this?")
					}
					</script>
					</a>
				</td>
				</tr>
			</c:forEach>
	</table>
	Add a new product? <a href="addproduct">Click here</a>!
</body>
</html>
