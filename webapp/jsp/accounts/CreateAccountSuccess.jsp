
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.util.*"%>
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
	height: 107px;
	z-index: 3;
	left: 446px;
	top: 206px;
}

#nameDiv {
	position: absolute;
	width: 462px;
	height: 24px;
	z-index: 3;
	left: 437px;
	top: 270px;
}

#background {
	position: absolute;
	width: 578px;
	height: 536px;
	z-index: 3;
	left: 353px;
	top: 202px;
}

#designationDiv {
	position: absolute;
	width: 455px;
	height: 193px;
	z-index: 3;
	left: 382px;
	top: 348px;
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
	left: 358px;
	top: 410px;
}

#Division {
	position: absolute;
	width: 496px;
	height: 28px;
	z-index: 5;
	left: 415px;
	top: 452px;
}

#officeDiv {
	position: absolute;
	width: 426px;
	height: 25px;
	z-index: 6;
	left: 433px;
	top: 500px;
}

#accountInfoHeader {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 7;
	left: 353px;
	top: 541px;
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
	height: 146px;
	z-index: 8;
	left: 383px;
	top: 566px;
}

#passwordDiv {
	position: absolute;
	width: 462px;
	height: 24px;
	z-index: 9;
	left: 436px;
	top: 643px;
}

#reenterpassword {
	position: absolute;
	width: 469px;
	height: 24px;
	z-index: 10;
	left: 359px;
	top: 691px;
}

#sumbmitDivBtn {
	position: absolute;
	width: 129px;
	height: 31px;
	z-index: 11;
	left: 599px;
	top: 749px;
}

#employmentDiv {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 12;
	left: 353px;
	top: 321px;
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
<form id="form3" name="form3" method="post" action="accountCreate.do">
<p><label for="designation"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Designation:
</label> <%
 	String designation = (String) request.getAttribute("designation");
 	out.print(designation);
 %>
</p>
<p><label for="employeeNumber2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Employee
Num: </label> <%
 	String employeeNumber = (String) request
 			.getAttribute("employeeNumber");
 	out.print(employeeNumber);
 %>
</p>
<p><label for="division2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Division:
</label> <%
 	String division = (String) request.getAttribute("division");
 	out.print(division);
 %>
</p>
<p><label for="office2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Office</label>
<%
	String office = (String) request.getAttribute("office");
	out.print(office);
%>
</p>
</form>
</div>
<div id="accountInfoHeader"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Account
Info</div>
<div id="userNameDiv">
<div>
<form id="form7" name="form7" method="post" action="accountCreate.do">
<p><label for="userName"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Username:
 </label> <%
 	String userName = (String) request.getAttribute("userName");
 	out.print(userName);
 %>
</p>
<p><label for="password2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Password:
</label> <%
 	StringBuffer buff = new StringBuffer();
 	for (int i = 0; i < ((String) request.getAttribute("password"))
 			.length(); i++) {
 		buff.append("*");
 	}
 	out.print(buff);
 %>
</p>
</form>
</div>
</div>
<div id="sumbmitDivBtn">
<form id="form10" name="form10" method="post" action="accountCreate.do">
<p><input type="submit" name="submit" id="submit" value="Submit"
	style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;" />
</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</form>
</div>
<div id="employmentDiv"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Employment</div>
<p>&nbsp;</p>
<div id="personalInfo"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Personal
Info</div>
<div id="titleDiv">
<form id="form1" name="form1" method="post" action="accountCreate.do">
<p><label for="title"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Title</label>
<%
	String title = (String) request.getAttribute("title");
	out.print(title);
%></p>
<p><label for="name"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Name</label>
<%
	String name = (String) request.getAttribute("name");
	out.print(name);
%><br />
</p>
</form>
</div>
</body>
</html>
