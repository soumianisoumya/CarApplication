<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
<title>Car Details Application</title>

</head>

<body>
	<form:form name="myCar" action="/CarApp/getCarId"
		onsubmit="return validate()" method="POST">
		<table>
			<tr>
				<td><form:label path="modelNum">Model Number</form:label></td>
				<td><form:input path="modelNum" id="num" /></td>
				<td><p id="numErr" style="color:red"></p></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<br>
	<a href="home">Back</a>

</body>

</html>