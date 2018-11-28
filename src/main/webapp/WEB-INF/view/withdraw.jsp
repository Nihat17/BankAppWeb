<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>

<head>
	<title> Bank App Withdraw</title>
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
			<h2>Bank App Withdraw</h2>		
		</div>
	</div>	
	
	<%if(request.getAttribute("withdrawError") != null){ %>
			<h5>The requested amount doesn't exist in account</h5>
	
	<%} %>
	
	<div id = "container">
		<form:form action="withdrawTransaction" modelAttribute="account" method="POST">
			
			<table>
				<tbody>			
								
					<tr>				
						<td><label>Enter the Amount: </label></td>
						<td><form:input path="balance" /></td>
						<td><form:errors path="balance" cssClass="error" /></td>									
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Withdraw" class="withdrawTransaction" /></td>
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