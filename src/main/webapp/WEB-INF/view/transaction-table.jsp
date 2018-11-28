<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title> Bank App Home</title>
	
	<!-- reference our style sheet -->
	<link type = "text/css"
		rel = "stylesheet"
		href="${pageContext.request.contextPath}/resources/style.css" />
		
</head>

<body>

	<div id = "wrapper">
		<div id = "header">
			<h2>Transaction Table</h2>
		</div>
	</div>	
	
	<div id = "container">
		<div id = "content">
		
			<!-- add our html tables here -->
			
			
			<table>
			
													
				<tr>				
					<th>Transaction Type</th>
					<th>Amount</th>
					<th>Date</th>								
				</tr>
				
				<!-- loop over and print the customers -->						
				
				<c:forEach var = "transactionDetail" items = "${transactionDetail}">
					<tr>						
						<td>${transactionDetail.type} </td>
						<td>${transactionDetail.amount} </td>
						<td>${transactionDetail.dateTime} </td>
						
						<!-- display the update link -->
						
					</tr>
				
				</c:forEach>
								
			</table>							
			
		</div>
	
	</div>

</body>

</html>