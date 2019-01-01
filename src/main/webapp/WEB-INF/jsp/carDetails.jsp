<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
<title>Car Details Application</title>
</head>

<body>
<h2>${message}</h2>
	<table>
		<tr>
			<td>Model Number:</td>
			<td>${modelNum}</td>
		</tr>
		<tr>
			<td>Model Name:</td>
			<td>${modelName}</td>
		</tr>
		<tr>
			<td>Price:</td>
			<td>${price}</td>
		</tr>
	</table>
	
	<br>
	<a href="home">Back</a>

</body>
</html>