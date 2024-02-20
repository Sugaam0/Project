<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>

	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid div-color">
		<div class="row">
			<div class="col-md-2 offset-md-3"></div>
			<div class="card mt-4">
				<div class="card-header text-center text-white bg-custom">
					<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
					<h4>Registration</h4>
				</div>

				
					
					<%
						String regMsg  = (String)session.getAttribute("success");	
					if(regMsg!=null)
					{%>
					
					<div class="alert alert-success" role="alert"><%=regMsg %> Login<a href="login.jsp">Click here</a></div>
						
					<%
					session.removeAttribute("success");
					}
					%>
					
					<%
						String FailedMsg  = (String)session.getAttribute("failed");	
					if(FailedMsg!=null)
					{%>
					
					<div class="alert alert-danger" role="alert"><%=FailedMsg %></div>
						
					<%
					session.removeAttribute("failed");
					}
					%>
				<div class="card-body">
					<form action="UserServlet" method="post">
						<div class="form-group">
							<label>Enter full Name</label> <input type="text"
								class="form-control" name="fname" id="exampleInputEmail1"
								aria-describedby="emailHelp" required>
						</div>
						<div class="form-group">
							<label>Enter Email</label> <input type="email"
								class="form-control" name="uemail" id="exampleInputEmail1"
								aria-describedby="emailHelp" required>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Enter Password</label> <input
								type="password" class="form-control" name="upass"
								id="exampleInputPassword1" required>
						</div>
						<div class="form-group">
							<label>Enter Contact</label> <input type="text"
								class="form-control" name="ucontact" id="exampleInputPassword1" required>
						</div>

						<button type="submit" class="btn btn-primary badge-pill btn-block">Register</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%@include file="all_component/footer.jsp"%>
</body>
</html>