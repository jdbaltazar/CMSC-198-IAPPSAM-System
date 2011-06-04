<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: Login</title>
<link href="login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="logo.jsp" />

	<!-- Login Panel -->
	<div id="header">Login</div>

	<div class="background">
		<form id="form1" name="form1" method="post" action="login">
			<div class="login-layout">
				<label>Username</label> <input name="username" type="text" id="username" size="25" />
				<p>
					<label> Password</label> <input name="password" type="password" id="password2" size="25" />
					<%
						String passwordIsOK = null;
						if (request.getAttribute("passwordIsOK") == null)
							passwordIsOK = (String) request.getAttribute("passwordIsOK");

						if (passwordIsOK != null && passwordIsOK.equalsIgnoreCase("false")) {
							out.print("*Invalid Username and/or Password");
						}
					%>
				</p>
			</div>
			<div class="enter-div" id="enter-div">
				<input type="submit" name="enter-button" id="enter-button" value="Enter" />
			</div>
		</form>
		<div class="important">
			<span class="important-text">Important:</span> <br /> <span class="important-message"> *USERNAME and PASSWORD ARE CASE-SENSITIVE.<br />
				*DO NOT FORGET TO LOGOUT YOUR ACCOUNT ONCE YOU COMPLETED YOUR SESSION. </span>
		</div>
	</div>

	<div id="message">
		<p>
			IAPPSAMS is a web-based database system that keeps records for the UPVTC Supply and Property Services Office (SPSO) and shall facilitate convenient
			completion and validation of processes that can span across multiple other departments/ offices in UPVTC. <br /> <br /> <br /> Please type the
			Username and password given to you in the appropriate Username and Password boxes at the right then click on the &quot;Enter&quot; button to enter
			the main menu page.
		</p>
	</div>

	<jsp:include page="copyright.jsp" />
</body>
</html>
