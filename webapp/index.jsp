<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: Login</title>
<link href="login.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div id="logoHeader" style="width: 100%">
		<img name="" src="images/header2.png" width="100%" height="115" alt="" />
	</div>
	<div id="footer">
		<table width="100%" frame="above" bordercolor="#333333" style="font-family: Verdana, Geneva, sans-serif; color: #333333; font-size: 9px">
			<tr>
				<td>Copyright � 2011 All Rights Reserved</td>
			</tr>
		</table>
	</div>
	<div id="header" align="center">
		<div style="text-align: center; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 18px; font-weight: bold">Login</div>
	</div>
	<div class="background">
		<form id="form1" name="form1" method="post" action="login">
			<div class="login-layout">
				Username <input name="userName" type="text" id="userName" size="25" />

				<p>
					Password <input name="password" type="password" id="password2" size="25" />
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
				<p>
					<input type="submit" name="enterBtn2" id="enter-button" value="Enter" />
				</p>
			</div>
		</form>
		<div class="important">
			<p>
				<span class="important-text">Important:</span> <br /> <span class="important-message"> *PASSWORD IS CASE-SENSITIVE.<br /> *DO NOT FORGET
					TO LOGOUT YOUR ACCOUNT ONCE YOU COMPLETED<br /> YOUR SESSION. </span>
			</p>
		</div>

	</div>
	<div id="header2" style="background-color: #7B1113;"></div>
	<div id="intromsgdiv" style="font-family: Lucida Grande; color: black; font-size: 12px;">
		<p>
			IAPPSAMS is a web-based database system that keeps records for the UPVTC Supply and Property Services Office (SPSO) and shall facilitate convenient
			completion and validation of processes that can span across multiple other departments/ offices in UPVTC. <br /> <br /> Please type the Username
			and password given to you in the appropriate Username and Password boxes at the right then click on the &quot;Enter&quot; button to enter the main
			menu page.
		</p>
	</div>
	<div id="probDiv" style="font-family: Lucida Grande; color: black; font-size: 12px;">
		If <b>problems</b> persist, email us at <span class="misc">iappsams@yahoo.com</span> contact <a href="http://www.facebook.com/johndavidbaltazar"
			target="_blank"
		><span class="misc">John David S. Baltazar.</span> </a>
	</div>
</body>
</html>
