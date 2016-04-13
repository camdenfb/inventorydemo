<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Menu</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>Main Menu</h2>
	<h6>Welcome ${sessionScope.authenticatedUser.username} !</h6>
	<form action="shared-Search.html" method="post">
		<button name="button" value="search">Search</button>
	</form>
	<form action="shared-ListAllServlet" method="post">	
		<button name="button" value="listAll">List All Items</button>
	</form>
	<form action="client-shop.jsp" method="post">	
		<button name="button" value="shop">Shop</button>
	</form>
	</form>
		<form action="logoutServlet" method="post">	
		<button name="button" value="add">Logout</button>
	</form>
</body>
</html>