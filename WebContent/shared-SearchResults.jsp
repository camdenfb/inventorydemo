<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ittc.training.model.Item" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Details</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Item Details</h2>
	<c:set value="${sessionScope.searchresult}" var="item" scope="session"/>
	<h4>Stock ID: ${item.stockId}</h4>
	<h4>Item Name: ${item.itemName}</h4>
	<h4>Unit Price: <fmt:formatNumber type="currency" currencySymbol="Php" value="${item.unitPrice}" /></h4>
	<h4>On Stock: ${item.onStock}</h4>
	
	<form action="admin-Edit.jsp" method="post">
		<button name="button" value="search">Edit</button>
	</form>
	<form action="admin-DeleteServlet" method="post">	
		<button name="button" value="listAll">Delete</button>
	</form>
		<form action="shared-BacktoMenu" method="post">
		<input type="submit" value="Back to Menu"/>
	</form>
	
	
<%-- 	Item Code: ${item.itemCode}<br/> --%>
<%-- 	Item Name: ${item.itemName}<br/>  --%>
</body>
</html>