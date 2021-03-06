<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Login</title>
<link href="css/header.css" rel="stylesheet" type="text/css" />
<link href="css/form.css" rel="stylesheet" type="text/css" />
<script language='javascript' type='text/javascript'>
	function formfocus() {
		document.getElementById('username').focus();
	}
	window.onload = formfocus;
</script>
</head>
<body>
	<div id="headerBkgrnd">
		<img src="images/headerbar.png" width="100%" height="129" />
	</div>
	<div id="logo">
		<img src="images/headerlogo.png" width="124" height="128" />
	</div>
	<div id="headerName">
		<img src="images/headertext.png" width="452" height="44" />
	</div>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<form name="LoginForm" method="post" action="login">
		<table width="95%" border="0" cellspacing="0" id="logintable">
			<tr>
				<td><div
						style="font-family: Lucida Grande; color: black; font-size: 12px; margin-left: 15px">
						<p>
							IAPPSAMS is a web-based database system that keeps records for
							the UPVTC Supply and Property Services Office (SPSO) and shall
							facilitate convenient completion and validation of processes that
							can span across multiple other departments/ offices in UPVTC. <br />
							<br />
						</p>
						<p>Please type the username and password given to you in the
							appropriate Username and Password boxes at the right then click
							on the &quot;Enter&quot; button to enter the main menu page.</p>
						<p>&nbsp;</p>
						<p>
							[This site is best viewed using <a
								href="http://www.google.com/chrome/intl/fil/landing_chrome.html?hl=fil"
								title="Get Google Chrome" target="_new">Google Chrome</a>]
						</p>
					</div>
				</td>
				<td width="27%"><table width="100%" border="0" cellspacing="0"
						id="table">
						<tr>
							<td class="header_rows"><div class="header_1">Login</div>
							</td>
						</tr>
						<tr>
							<td><table width="100%" border="0" cellspacing="0">
									<tr>
										<td class="align_right" width="50%"><br /> Username:</td>
										<td width="50%"><br /> <input type="text"
											name="username" id="username" />
										</td>
									</tr>
									<tr>
										<td class="align_right" width="50%"><br /> Password:</td>
										<td width="50%"><br /> <input type="password"
											name="password" id="password" />
										</td>
									</tr>

									<%
										String passwordIsOK = null;
										if (request.getAttribute("passwordIsOK") == null)
											passwordIsOK = (String) request.getAttribute("passwordIsOK");

										if (passwordIsOK != null && passwordIsOK.equalsIgnoreCase("false")) {
											out.print("*Invalid Username and/or Password");
										}
									%>

									<tr>
										<td colspan="2" align="center"><br /> <input
											name="enterBtn" type="submit" class="button" id="enterBtn"
											value="Enter" /> <br /> <br />
										</td>
									</tr>
									<tr>
										<td id="importantNotice"><div class="importantNotice">Important:</div>
										</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td colspan="2" id="notice">
											<div class="notice">
												*USERNAME and PASSWORD ARE CASE-SENSITIVE.<br /> *DO NOT
												FORGET TO LOGOUT YOUR ACCOUNT ONCE YOU COMPLETED YOUR
												SESSION.<br /> <br />
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td class="table_footer"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
	<!--<div id="footer"></div>-->
</body>
</html>