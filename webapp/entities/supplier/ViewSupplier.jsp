<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.Person"%>
<%@page import="com.iappsam.Employee"%>
<%@page import="com.iappsam.Supplier"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="../../favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: View Supplier</title>
<style type="text/css">
.headers {
	text-align: left;
	font-family: Lucida Grande;
	color: white;
	font-size: 16px;
	font-weight: bold;
}

.labels {
	font-family: Lucida Grande;
	font-size: 16px;
	font-weight: bold;
}

.maroon {
	font-size: 12px;
	font-family: Lucida Grande;
	background-color: #7B1113;
	color: white;
	border-left: 1px solid lightgray;
	border-right: 1px solid lightgray;
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

.maroon:hover {
	font-weight: bold;
	/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
	border-right: 1px solid #7B1113;
	border-top: 1px solid #7B1113;
	border-bottom: 1px solid #7B1113;
}

.button {
	font-size: 14px;
	font-family: Lucida Grande;
	background-color: white;
	color: #7B1113;
	border-left: 1px solid lightgray;
	border-right: 1px solid lightgray;
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

.button:hover {
	font-weight: bold;
	color: #060;
	/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
	border-right: 1px solid #7B1113;
	border-top: 1px solid #7B1113;
	border-bottom: 1px solid #7B1113;
}

#personalInfo {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 1;
	left: 389px;
	top: 666px;
}

#titleDiv {
	position: absolute;
	width: 388px;
	height: 910px;
	z-index: 3;
	left: 511px;
	top: 356px;
}

#nameDiv {
	position: absolute;
	width: 462px;
	height: 24px;
	z-index: 3;
	left: 461px;
	top: 278px;
}

#background {
	position: absolute;
	width: 578px;
	height: 514px;
	z-index: 3;
	left: 389px;
	top: 690px;
}

#designationDiv {
	position: absolute;
	width: 455px;
	height: 24px;
	z-index: 3;
	left: 829px;
	top: 119px;
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
	left: 671px;
	top: 378px;
}

#Division {
	position: absolute;
	width: 535px;
	height: 28px;
	z-index: 5;
	left: 459px;
	top: 451px;
}

#officeDiv {
	position: absolute;
	width: 426px;
	height: 25px;
	z-index: 6;
	left: 475px;
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
	left: 927px;
	top: 725px;
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
	left: 389px;
	top: 817px;
}

#apDiv3 {
	position: absolute;
	width: 578px;
	height: 9px;
	z-index: 13;
	left: 389px;
	top: 1205px;
}

#border {
	position: absolute;
	width: 586px;
	height: 652px;
	z-index: 1;
	left: 609px;
	top: 97px;
}

#contactInfoDiv {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 14;
	left: 389px;
	top: 965px;
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
	left: 412px;
	top: 1171px;
}

#acctTypediv {
	position: absolute;
	width: 493px;
	height: 29px;
	z-index: 19;
	left: 439px;
	top: 928px;
}

#apDiv8 {
	position: absolute;
	width: 480px;
	height: 32px;
	z-index: 19;
	left: 2px;
	top: 409px;
}

#apDiv9 {
	position: absolute;
	width: 380px;
	height: 29px;
	z-index: 19;
	top: 503px;
	left: -30px;
}

#apDiv10 {
	position: absolute;
	width: 313px;
	height: 28px;
	z-index: 19;
	left: -33px;
	top: 551px;
}

#apDiv11 {
	position: absolute;
	width: 759px;
	height: 27px;
	z-index: 19;
	left: -77px;
	top: 253px;
}

#apDiv12 {
	position: absolute;
	width: 314px;
	height: 34px;
	z-index: 19;
	left: -2px;
	top: 298px;
}

#apDiv13 {
	position: absolute;
	width: 453px;
	height: 28px;
	z-index: 19;
	left: -59px;
	top: 654px;
}

#apDiv14 {
	position: absolute;
	width: 394px;
	height: 25px;
	z-index: 19;
	left: 23px;
	top: 707px;
}

#apDiv15 {
	position: absolute;
	width: 429px;
	height: 19px;
	z-index: 19;
	left: -33px;
	top: 737px;
}

#apDiv16 {
	position: absolute;
	width: 483px;
	height: 29px;
	z-index: 19;
	left: -1px;
	top: 572px;
}

#apDiv17 {
	position: absolute;
	width: 404px;
	height: 28px;
	z-index: 19;
	left: 3px;
	top: 620px;
}

#apDiv18 {
	position: absolute;
	width: 482px;
	height: 27px;
	z-index: 19;
	left: -75px;
	top: 669px;
}

#apDiv19 {
	position: absolute;
	width: 500px;
	height: 30px;
	z-index: 19;
	left: -33px;
	top: 718px;
}

#apDiv20 {
	position: absolute;
	width: 66px;
	height: 37px;
	z-index: 19;
	left: 152px;
	top: 805px;
}

#pageLabel {
	position: absolute;
	width: 200px;
	height: 39px;
	z-index: 1;
	top: 181px;
	left: 13px;
}

#logoHeader {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 1;
}

#logoutiv {
	position: absolute;
	width: 200px;
	height: 30px;
	z-index: 15;
	left: 14px;
	top: 143px;
}

#footer {
	position: absolute;
	left: 2px;
	top: 1339px;
	width: 100%;
}

#background_1 {
	position: absolute;
	width: 578px;
	height: 194px;
	z-index: 0;
	left: 388px;
	top: 384px;
}

#apDiv21 {
	position: absolute;
	width: 577px;
	height: 23px;
	z-index: 20;
	left: 388px;
	top: 361px;
}

#apDiv22 {
	position: absolute;
	width: 303px;
	height: 26px;
	z-index: 21;
	left: 19px;
	top: 360px;
}

#apDiv23 {
	position: absolute;
	width: 506px;
	height: 26px;
	z-index: 21;
	left: -69px;
	top: 50px;
}

#apDiv24 {
	position: absolute;
	width: 571px;
	height: 43px;
	z-index: 21;
	left: -93px;
	top: 97px;
}

#apDiv25 {
	position: absolute;
	width: 311px;
	height: 26px;
	z-index: 21;
	left: 28px;
	top: 167px;
}

#apDiv26 {
	position: absolute;
	width: 200px;
	height: 26px;
	z-index: 21;
	left: 402px;
	top: 362px;
}

#apDiv27 {
	position: absolute;
	width: 290px;
	height: 22px;
	z-index: 22;
	left: 400px;
	top: 668px;
}

#apDiv28 {
	position: absolute;
	width: 322px;
	height: 27px;
	z-index: 23;
	left: 401px;
	top: 818px;
}

#apDiv29 {
	position: absolute;
	width: 200px;
	height: 21px;
	z-index: 24;
	left: 401px;
	top: 966px;
}

#apDiv30 {
	position: absolute;
	width: 296px;
	height: 22px;
	z-index: 25;
	left: 546px;
	top: 609px;
}
</style>
</head>

<body>

<%
	Supplier s = (Supplier) request.getAttribute("supplier");
	Employee emp = (Employee) request.getAttribute("employee");
	Person p = (Person) request.getAttribute("person");

	String mobile = (String) request.getAttribute("mobile");
	String landline = (String) request.getAttribute("landline");
	String email = (String) request.getAttribute("email");
%>
<div id="footer">
<table width="100%" frame="above" bordercolor="#333333"
	style="font-family: Verdana, Geneva, sans-serif; color: #333333; font-size: 9px">
	<tr>
		<td>Copyright � 2011 All Rights Reserved</td>
	</tr>
</table>
</div>
<div id="logoHeader" style="width: 100%"><img name=""
	src="../../images/header2.png" width="100%" height="115" alt="" /></div>
<div id="pageLabel" style="width: 100%;">
<table width="100%" border="0">
	<tr>
		<td width="12%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">View
				Supplier</td>
			</tr>
		</table>
		</td>
		<td width="84%">&nbsp;</td>
		<td width="4%">
		<form id="form15" name="form15" method="post"
			action="SearchSuppliers.do"><input name="backBtn"
			type="submit" class="button" id="backBtn" value="Back" /></form>
		</td>
	</tr>
</table>
</div>
<div id="logoutiv" style="width: 90%">
<form id="form2" name="form2" method="post" action="../../logout"><input
	name="logout" type="submit" class="maroon" id="logout" value="Logout" />
</form>
</div>
<div id="background" style="background-color: #EEE0E5;"></div>
<div id="employmentDiv"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold"></div>
<div id="apDiv3" style="text-align: left; background-color: #7B1113;"></div>
<div id="contactInfoDiv"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold"></div>
<p>&nbsp;</p>
<div id="personalInfo"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold"></div>
<div id="titleDiv">
<form id="form1" name="form1" method="post" action="">
<p>&nbsp;</p>
<div id="apDiv23"><label for="supplierName" class="labels">*Supplier
Name:</label> <input name="supplierName" type="text" id="supplierName" size="35"
	value="<%=s.getSupplierName()%>" disabled="disabled"/></div>
<p>&nbsp;</p>
<div id="apDiv24"><label for="supplierAddress" class="labels">*Supplier
Address:</label> <textarea name="supplierAddress" id="supplierAddress"disabled="disabled"><%=s.getAddress()%> </textarea></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv25"><label for="tin" class="labels">TIN:</label> <input
	name="tin" type="text" id="tin" size="25" <%if (s.getTin() != null) {%>
	value="<%=s.getTin()%>" <%}%> disabled="disabled"/></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv22"><label for="title2" class="labels">Title:</label>
<input type="text" name="title" id="title2"
	<%if (p.getTitle() != null) {%>
	value="<%=p.getTitle()%>" <%}%> disabled="disabled"/></div>
<p><label for="title"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
</label></p>

<div id="apDiv8"><label for="name"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">*Name:</label>
<input name="name" type="text" id="name" size="40"
	value="<%=p.getName()%>" disabled="disabled"/></div>

<div id="apDiv9"><label for="designation3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">*Designation:</label>
<input name="designation2" type="text" id="designation3" size="30"
	value="<%=emp.getDesignation()%>" disabled="disabled"/></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><label for="employeeNumber2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
</label></p>
<div id="apDiv10"><label for="employeeNumber3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Employee
No.:</label> <input type="text" name="employeeNumber" id="employeeNumber3"
	<%if (emp.getEmployeeNumber() != null) {%>
	value="<%=emp.getEmployeeNumber()%>" <%}%> disabled="disabled"/></div>
<p><label for="employeeNumber2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
</label></p>
<p><label for="division2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
</label> <label for="office2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
</label></p>
<p><label for="office2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
</label></p>
<p><label for="mobileNumber2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
</label></p>
<div id="apDiv13"><label for="mobileNumber3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Cellphone
Number:</label> <input name="mobileNumber" type="text" id="mobileNumber3" value = "<%=mobile %>"
	size="25" disabled="disabled"/></div>
<p><label for="mobileNumber2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
</label></p>
<div id="apDiv14"><label for="landline3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Landline:</label>
<input name="landline" type="text" id="landline3" value = "<%=landline %>" size="25" disabled="disabled"/></div>
<div id="apDiv15"><label for="emailad3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
E-mail Address:</label> <input name="emailad" type="text" id="emailad3"
value = "<%=email %>"	size="25" disabled="disabled"/></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><br />
</p>
</form>
</div>
<div id="background_1" style="background-color: #EEE0E5;"></div>
<div class="maroon" id="apDiv21"></div>
<div class="headers" id="apDiv26">Supplier Information</div>
<div class="headers" id="apDiv27">Contact Person Information</div>
<div class="headers" id="apDiv28">Work Information</div>
<div class="headers" id="apDiv29">Contact Information</div>
</body>
</html>
