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
			<h2>Bank App Home</h2>
		</div>
	</div>	
	
	<div id = "container">
		<div id = "content">
		
		<!-- put new button: Add Customer -->
		<input type = "button" value="Add Account"		
			onclick="window.location.href='addAccount'; return false;"
			class="addButton"
		/>
		
			<!-- add our html tables here -->
			
			<% if(request.getAttribute("accountUserDetail") != null){ %>
			<table>
			
													
				<tr>				
					<th>First Name </th>
					<th>Last Name </th>
					<th>Account Number</th>
					<th>Balance</th>	
					<th>Action</th>									
				</tr>
				
				<!-- loop over and print the customers -->						
				
				<c:forEach var = "tempDetail" items = "${accountUserDetail}">
					<!-- construct an update link with customer id -->
					<c:url var = "depositLink" value="/transaction/depositForm">
						<c:param name="accountId" value="${tempDetail.accountId}"/>
					</c:url>
						
					<!-- construct a delete link with customer id -->
					<c:url var = "withdrawalLink" value="/transaction/withdrawForm">				
						<c:param name="accountId" value="${tempDetail.accountId}"/>
					</c:url>
				
					<c:url var = "displayAccountLink" value="/bankapp/displayAccount">
						<c:param name="accountId" value="${tempDetail.accountId}"></c:param>
					</c:url>
				
					<tr>						
						<td>${tempDetail.firstName} </td>
						<td>${tempDetail.lastName} </td>
						<td>${tempDetail.accountId} </td>
						<td>${tempDetail.balance} </td>
						
						<!-- display the update link -->
						<td>
							<a href="${depositLink}">Deposit</a>
							|
							<a href="${withdrawalLink}">Withdrawal</a>
							|
							<a href="${displayAccountLink}">Display Account</a>
						</td> 
						
					</tr>
				
				</c:forEach>
								
			</table>				
			<%} %>
			
		</div>
	
	</div>

</body>

</html>