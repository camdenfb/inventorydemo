<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="edu.ittc.training.model.Item, java.util.List, java.util.ArrayList" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Items</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>All Items</h2>
	<table border="1">
	<tr><td><h4>Stock ID</h4></td><td><h4>Item Name</h4></td><td><h4>Unit Price</h4></td><td><h4>On Stock</h4></td></tr>
	
	<c:forEach items="${sessionScope.listall}" var="item">
			<tr><td>${item.stockId}
			</td><td>${item.itemName}
			</td><td>${item.unitPrice}
			</td><td>${item.onStock}
			</tr>
	</c:forEach>

	</table>
	<br>
			<form action="shared-BacktoMenu" method="post">
		<input type="submit" value="Back to Menu"/>
	</form>
</body>
</html>