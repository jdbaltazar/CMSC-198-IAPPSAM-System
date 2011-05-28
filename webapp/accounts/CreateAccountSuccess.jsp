<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
#personalInfo {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 1;
	left: 353px;
	top: 176px;
}

#titleDiv {
	position: absolute;
	width: 388px;
	height: 27px;
	z-index: 3;
	left: 460px;
	top: 222px;
}

#nameDiv {
	position: absolute;
	width: 462px;
	height: 24px;
	z-index: 3;
	left: 444px;
	top: 270px;
}

#background {
	position: absolute;
	width: 578px;
	height: 831px;
	z-index: 3;
	left: 353px;
	top: 202px;
}

#designationDiv {
	position: absolute;
	width: 455px;
	height: 24px;
	z-index: 3;
	left: 422px;
	top: 364px;
}

#apDiv1 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 4;
}

#empNumDiv {
	position: absolute;
	width: 447px;
	height: 25px;
	z-index: 4;
	left: 403px;
	top: 405px;
}

#Division {
	position: absolute;
	width: 535px;
	height: 28px;
	z-index: 5;
	left: 452px;
	top: 452px;
}

#officeDiv {
	position: absolute;
	width: 426px;
	height: 25px;
	z-index: 6;
	left: 469px;
	top: 498px;
}

#accountInfoHeader {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 7;
	left: 354px;
	top: 730px;
}

#apDiv2 {
	position: absolute;
	width: 397px;
	height: 23px;
	z-index: 8;
}

#userNameDiv {
	position: absolute;
	width: 483px;
	height: 25px;
	z-index: 8;
	left: 471px;
	top: 785px;
}

#passwordDiv {
	position: absolute;
	width: 462px;
	height: 24px;
	z-index: 9;
	left: 474px;
	top: 833px;
}

#reenterpassword {
	position: absolute;
	width: 469px;
	height: 24px;
	z-index: 10;
	left: 399px;
	top: 883px;
}

#sumbmitDivBtn {
	position: absolute;
	width: 90px;
	height: 82px;
	z-index: 11;
	left: 617px;
	top: 966px;
}

#employmentDiv {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 12;
	left: 353px;
	top: 321px;
}

#apDiv3 {
	position: absolute;
	width: 578px;
	height: 9px;
	z-index: 13;
	left: 354px;
	top: 1035px;
}

#border {
	position: absolute;
	width: 585px;
	height: 922px;
	z-index: 1;
	left: 350px;
	top: 173px;
}

#contactInfoDiv {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 14;
	left: 353px;
	top: 542px;
}

#apDiv4 {
	position: absolute;
	width: 426px;
	height: 29px;
	z-index: 15;
	left: 411px;
	top: 591px;
}

#apDiv5 {
	position: absolute;
	width: 302px;
	height: 25px;
	z-index: 16;
	left: 494px;
	top: 637px;
}

#apDiv6 {
	position: absolute;
	width: 422px;
	height: 25px;
	z-index: 17;
	left: 438px;
	top: 682px;
}

#apDiv7 {
	position: absolute;
	width: 200px;
	height: 18px;
	z-index: 18;
	left: 379px;
	top: 994px;
}

#acctTypediv {
	position: absolute;
	width: 493px;
	height: 29px;
	z-index: 19;
	left: 439px;
	top: 928px;
}
</style>
</head>

<body>
<table width="100%" border="0">
	<tr>
		<td width="19%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">Create
				New Account</td>
			</tr>
		</table>
		</td>
		<td width="77%">&nbsp;</td>
		<td width="4%"><a href="../MenuFrame.html"
			title="Back to main menu" target="main_frame">Home</a></td>
	</tr>
</table>
<div id="background" style="background-color: #EEE0E5;"></div>
<div id="designationDiv">
<form id="form3" name="form3" method="post"
	action="../accounts/accountCreate.do"><label for="designation"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">*Designation:</label>
<%
	String designation = (String) request.getAttribute("designation");
%> <%=designation%></form>
</div>
<div id="empNumDiv">
<form id="form4" name="form4" method="post" action=""><label
	for="employeeNumber"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Employee
Num:</label> <%
 	String employeeNumber = (String) request.getAttribute("employeeNumber");
 %> <%=employeeNumber%></form>
</div>
<div id="Division">
<form id="form5" name="form5" method="post" action=""><label
	for="division"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Division:</label>
<%
	String division = (String) request.getAttribute("division");
%> <%=division%></form>
</div>
<%
	String office = (String) request.getAttribute("office");
%>
<%
	if (office != null) {
%>
<div id="officeDiv">
<form id="form6" name="form6" method="post" action=""><label
	for="office"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Office:</label>

<%=office%></form>
</div>
<%
	}
%>
<div id="accountInfoHeader"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Account
Info</div>
<div id="userNameDiv">
<div>
<form id="form7" name="form7" method="post" action=""><label
	for="userName"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">*Username:</label>
<%
	String userName = (String) request.getAttribute("userName");
%> <%=userName%></form>
</div>
</div>
<div id="passwordDiv">
<div>
<form id="form8" name="form8" method="post" action=""><label
	for="password"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">*Password:</label>
<%
	String password = (String) request.getAttribute("password");
%> <%
 	for (int i = 0; i < password.length(); i++)
 		out.print("*");
 %>
</form>
</div>
</div>
<div id="sumbmitDivBtn">
<form id="form10" name="form10" method="post" action="../MenuFrame.html">
<p><input type="submit" name="submit" id="submit" value="Back"
	style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;" />
</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</form>
</div>
<div id="employmentDiv"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Work
Info</div>
<div id="apDiv3" style="text-align: left; background-color: #7B1113;"></div>
<div id="border">
<table width="100%" height="870" border="1">
	<tr>
		<td height="864">&nbsp;</td>
	</tr>
</table>
</div>
<div id="contactInfoDiv"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Contact
Info</div>
<div id="apDiv4">
<form id="form11" name="form11" method="post" action=""><label
	for="mobileNumber"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Cellphone
Number:</label> <%
 	String mobileNumber = (String) request.getAttribute("mobileNumber");
 %> <%=mobileNumber%></form>
</div>
<div id="apDiv5">
<form id="form12" name="form12" method="post" action=""><label
	for="landline"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Landline:</label>
<%
	String landline = (String) request.getAttribute("landline");
%> <%=landline%></form>
</div>
<div id="apDiv6">
<form id="form13" name="form13" method="post" action=""><label
	for="emailad"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">E-mail
Address:</label> <%
 	String emailad = (String) request.getAttribute("emailad");
 %> <%=emailad%></form>
</div>
<div id="apDiv7"
	style="font-family: Lucida Grande; color: red; font-size: 11px;"><em>*required
field</em></div>
<div id="acctTypediv">
<form id="form14" name="form14" method="post" action=""><label
	for="acctType"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">*Account
Type: </label> <%
 	String acctType = (String) request.getAttribute("acctType");
 %> <%=acctType%></form>
</div>
<p>&nbsp;</p>
<div id="personalInfo"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Personal
Info</div>
<div id="titleDiv">
<form id="form1" name="form1" method="post" action=""><label
	for="title"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Title:</label>
<%
	String title = (String) request.getAttribute("title");
%> <%=title%> <br />
</form>
</div>
<div id="nameDiv">
<form id="form2" name="form2" method="post" action=""><label
	for="name"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">*Name:</label>
<%
	String name = (String) request.getAttribute("name");
%> <%=name%></form>
</body>
</html>
