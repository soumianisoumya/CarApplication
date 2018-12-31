<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
<title>Car Details Application</title>
<script type="text/javascript">
	function validate() {
		
		document.getElementById("numErr").innerHTML="";
		document.getElementById("nameErr").innerHTML="";
		document.getElementById("priceErr").innerHTML="";
		var status;
		
		if (isNaN(document.getElementById("num").value)) {
			document.getElementById("numErr").innerHTML="Enter valid number";
			status = false;
		}
		//[a-zA-Z]*[A-Z][a-zA-Z@#$0-9]*
		
		if(!(document.getElementById("name").value.match("[a-zA-Z][a-zA-Z' '']+"))){
			document.getElementById("nameErr").innerHTML="Enter valid name";
			status = false;
		}
		
		if(!document.getElementById("pr").value.match("[0-9]+\.[0-9]*")){
			document.getElementById("priceErr").innerHTML="Enter valid price";
			status = false;
		}
		return status;
	}
</script>


</head>

<body>
	<form:form name="myCar" action="/CarApp/addcar"
		onsubmit="return validate()" method="POST">
		<table>
			<tr>
				<td><form:label path="modelNum">Model Number</form:label></td>
				<td><form:input path="modelNum" id="num" /></td>
				<td><p id="numErr" style="color:red"></p></td>
			</tr>
			<tr>
				<td><form:label path="modelName">Model Name</form:label></td>
				<td><form:input path="modelName" id="name" /></td>
				<td><p id="nameErr" style="color:red"></p></td>
			</tr>
			<tr>
				<td><form:label path="price">Price</form:label></td>
				<td><form:input path="price" id="pr" /></td>
				<td><p id="priceErr" style="color:red"></p></td>
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