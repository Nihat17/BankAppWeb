<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title> Save Customer</title>
	
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/style.css">
		
	<link type="text/css"
		rel="stylesheet"		
		href="${pageContext.request.contextPath}/resources/add-account-style.css">
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

	 <div id="wrapper">
	 	<div id ="header">
	 		<h2>Bank App</h2>	 	
	 	</div>
	 </div>
	 
	<div id ="container">	
		<h3>Add User</h3>
		
		<form:form action="saveAccount" modelAttribute="detail" method="POST">
			
			<!-- need the associate this data with contact id -->
			<form:hidden path = "accountId" />
			
			<table>
				<tbody>
					<tr>
						<td><label>First Name: </label></td>
						<td><form:input path="firstName" /></td>
						<td><form:errors path="firstName" cssClass="error" /></td>						
					</tr>
					
					<tr>
						<td><label>Last Name: </label></td>
						<td><form:input path="lastName" /></td>
						<td><form:errors path="lastName" cssClass="error" /></td>
						
					</tr>
					
					<tr>
						<td><label>Social Security Number: </label></td>
						<td><form:input path="ssn" /></td>
						<td><form:errors path="ssn" cssClass="error" /></td>
					</tr>
					
					<tr>
						<td><label>Initial Deposit:</label></td>
						<td><form:input path="balance" /></td>
						<td><form:errors path="balance" cssClass="error" /></td>
					</tr>
					
					<tr>
						<td>Account Type:</td>
						<td><form:radiobutton path="accountType" value="checking" />Checking <form:radiobutton
							path="accountType" value="savings" />Savings</td>
						<td><form:errors path="accountType" cssClass="error" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="saveContact" /></td>						
					</tr>
					
					
				</tbody>
			</table>
		
		</form:form>
		
		<div style="clear; both;"> </div>
		<p>
			<a href="${pageContext.request.contextPath}/bankapp/home">Back to List </a>
		</p>
		
	</div> 
</body>

</html>