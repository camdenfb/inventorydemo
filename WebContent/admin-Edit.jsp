<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.ittc.training.model.Item" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Edit Item</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Edit Item</h2>
	<c:set value="${sessionScope.searchresult}" var="item" scope="session"/>
	<h4>Stock ID: ${item.stockId}</h4>
	<h4>Item Name: ${item.itemName}</h4>
<form action="admin-EditServlet" method="post">	
	<input type="hidden" name="stockId" value="${item.stockId}">
	<input type="hidden" name="itemName" value="${item.itemName}">
	<h4>Unit Price:
	<input type="text" name="unitPrice" value="${item.unitPrice}"></h4>
	<h4>On Stock:
	<input type="text" name="onStock" value="${item.onStock}"></h4><br>
	<input type="submit" value="Save">
</form>
</body>
</html>