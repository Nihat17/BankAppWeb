<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
	 		<h2>Account Details</h2>	 	
	 	</div>
	 </div>
	 
	<div id ="container">	
		<h3>Account Details</h3>
		
		<form:form action="updateAccount" modelAttribute="detail" method="POST">
			<!-- need the associate this data with contact id -->
			<form:hidden path = "accountId" />
			
			<c:url var = "displayTransactionLink" value="/transaction/displayTransaction">
				<c:param name="accountId" value="${detail.accountId}"/>
			</c:url>
			
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
						<td><label>Account ID:</label></td>
						<td><form:input path="accountId" readonly = "true"/></td>
						<td><form:errors path="accountId" cssClass="error" /></td>
					</tr>
					
					<tr>
						<td><label>Account Type:</label></td>
						<td><form:input path="accountType" readonly = "true"/></td>
						<td><form:errors path="accountType" cssClass="error" /></td>
					</tr>
					
					<tr>
						<td><label>Balance:</label></td>
						<td><form:input path="balance" readonly = "true"/></td>
						<td><form:errors path="balance" cssClass="error" /></td>
					</tr>
					
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Update" class="updateAccount" /></td>
									
						<td><label></label></td>
						<td></td>
					</tr>
						
						<!--  <input type = "button" value="Add Account"		
							onclick="window.location.href='displayTransactionLink'; return false;"
							class="addButton"
						/> -->
			
				</tbody>
			</table>
		
		</form:form>
		
		<form:form action="displayTransaction" modelAttribute="detail" method="POST">
			<form:hidden path = "accountId" />
		
			<c:url var = "displayTransactionLink" value="/transaction/displayTransaction">
				<c:param name="accountId" value="${detail.accountId}"/>
			</c:url>
						
			<p>
				<a href = "${displayTransactionLink}">Display Transactions</a>
			</p>
		</form:form>
		
		<div style="clear; both;"> </div>
		
		
		<p>
			<a href="${pageContext.request.contextPath}/bankapp/home">Back to List </a>
		</p>
		
	</div> 
</body>

</html>