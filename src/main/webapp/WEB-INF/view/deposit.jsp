<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>

<head>
	<title> Bank App Deposit</title>
</head>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

<body>

	<div id = "wrapper">
		<div id = "header">
			<h2>Bank App Deposit</h2>		
		</div>
	</div>	
	
	<div id = "container">
		<form:form action="depositTransaction" modelAttribute="account" method="POST">
			
			<table>
				<tbody>			
								
					<tr>				
						<td><label>Enter the Amount: </label></td>
						<td><form:input path="balance" /></td>
						<td><form:errors path="balance" cssClass="error" /></td>									
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Deposit" class="depositTransaction" /></td>
					</tr>
					
				</tbody>
				
			</table>
			</form:form>
			
			<p>
				<a href="${pageContext.request.contextPath}/bankapp/home">Back to List </a>
			</p>		
	</div>

</body>
</html>