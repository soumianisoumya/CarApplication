<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Car Details Application</title>

<body>
	<table border="1" style="font-size:28px">
		<tr>
			<th>Model Num</th>
			<th>Model Name</th>
			<th>Price</th>
		</tr>
		<c:forEach var="car" items="${cars}">

			<tr>
				<td>${car.modelNum}</td>
				<td>${car.modelName}</td>
				<td>${car.price}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="home">Back</a>
</body>
</html>