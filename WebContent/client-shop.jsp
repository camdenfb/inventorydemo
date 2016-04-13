<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>Shopping Cart</h2><br/>
	
	<i>${sessionScope.message}</i>
	 
	<form action="client-purchase" method="post">
		<h5>Item ID: <input type="text" name="item"><br>
		Quantity: <input type="text" name="qnty"></h5>
		<input type="submit" value="Save to Cart"/>
	</form>
	
	<br/><c:if test="${fn:length(sessionScope.cart.list) > 0}"><br/>
	
	<table border="1">
	<tr><td><h4>Item Name</h4></td><td><h4>Quantity</h4></td><td><h4>Unit Price</h4></td><td><h4>On Stock</h4></td><td><h4>Amount</h4></td></tr>
	<c:set var="total" scope="session" value="${0}"/>
	<c:forEach items="${sessionScope.cart.list}" var="item">
		<tr>
		<c:forEach items="${original}" var="orig">
		 <c:if test="${orig.stockId eq item.itemId}">
		 
		<c:choose>
		 <c:when test="${orig.onStock<item.noItems}">
		 <td><font color="red">${item.itemName}</font></td>
		<td><font color="red">${item.noItems}</font></td>
		<td><font color="red"><fmt:formatNumber type="currency" currencySymbol="Php" value="${item.unitPrice}" /></font></td>
		 <td><font color="red">${orig.onStock}</font></td>
		 <td><font color="red"><fmt:formatNumber type="currency" currencySymbol="Php" value="${item.unitPrice*item.noItems}" /></font></td>
		  </c:when>
		  
		  <c:otherwise>
		  <td>${item.itemName}</td>
		<td>${item.noItems}</td>
		<td><fmt:formatNumber type="currency" currencySymbol="Php" value="${item.unitPrice}" /></td>
		 <td>${orig.onStock}</td>
		 <td><fmt:formatNumber type="currency" currencySymbol="Php" value="${item.unitPrice*item.noItems}" /></td>
		  </c:otherwise>
		 </c:choose>
		 <c:set var="total" scope="session" value="${total + item.unitPrice*item.noItems}"/>
		 </c:if>
		</c:forEach>
		</tr>
	</c:forEach>
	<tr><td></td><td></td><td></td><td><b>TOTAL</b></td><td><b><fmt:formatNumber type="currency" currencySymbol="Php" value="${total}" /></b></td></tr>
	</table>
	
	<br/>
	<form action="client-checkout" method="post">
		<input type="submit" value="Checkout Items"/>
	</form>
	<form action="client-cancel" method="post">
		<input type="submit" value="Cancel Orders"/>
	</form>
	</c:if>
	<form action="shared-BacktoMenu" method="post">
		<input type="submit" value="Back to Menu"/>
	</form>
</body>
</html>