<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="com.iappsam.DivisionOffice"%>
<%@page import="java.util.List"%>
<%@page import="com.iappsam.util.Managers"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="../../favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: View Employee</title>
<style type="text/css">
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
	left: 376px;
	top: 290px;
}

#titleDiv {
	position: absolute;
	width: 388px;
	height: 663px;
	z-index: 3;
	left: 497px;
	top: 326px;
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
	height: 567px;
	z-index: 3;
	left: 376px;
	top: 316px;
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
	left: 375px;
	top: 442px;
}

#apDiv3 {
	position: absolute;
	width: 578px;
	height: 9px;
	z-index: 13;
	left: 376px;
	top: 883px;
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
	left: 376px;
	top: 630px;
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
	left: 404px;
	top: 848px;
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
	left: -18px;
	top: 65px;
}

#apDiv9 {
	position: absolute;
	width: 380px;
	height: 29px;
	z-index: 19;
	top: 163px;
	left: -55px;
}

#apDiv10 {
	position: absolute;
	width: 313px;
	height: 28px;
	z-index: 19;
	left: -61px;
	top: 210px;
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
	left: -77px;
	top: 354px;
}

#apDiv14 {
	position: absolute;
	width: 394px;
	height: 25px;
	z-index: 19;
	left: 5px;
	top: 407px;
}

#apDiv15 {
	position: absolute;
	width: 429px;
	height: 19px;
	z-index: 19;
	left: -51px;
	top: 437px;
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
	left: 124px;
	top: 504px;
}

#pageLabel {
	position: absolute;
	width: 200px;
	height: 50px;
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
	left: 1px;
	top: 992px;
	width: 100%;
}
</style>
</head>

<body>
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
		<td width="13%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">Add
				Employee</td>
			</tr>
		</table>
		</td>
		<td width="83%">&nbsp;</td>
		<td width="4%">
		<form id="form15" name="form15" method="post"
			action="SearchEmployee.do"><input name="backBtn" type="submit"
			class="button" id="backBtn" value="Back" /></form>
		</td>
	</tr>
</table>
</div>
<div id="logoutiv" style="width: 90%">
<form id="form2" name="form2" method="post" action="../../logout"><input
	name="logout" type="submit" class="maroon" id="logout" value="Logout" /></form>
</div>
<div id="background" style="background-color: #EEE0E5;"></div>
<div id="employmentDiv"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Work
Information</div>
<div id="apDiv3" style="text-align: left; background-color: #7B1113;"></div>
<div id="contactInfoDiv"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Contact
Information</div>
<div id="apDiv7"
	style="font-family: Lucida Grande; color: red; font-size: 11px;"><em>*required
field</em></div>
<p>&nbsp;</p>
<div id="personalInfo"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Personal
Information</div>
<div id="titleDiv">
<form id="form1" name="form1" method="post" action="CreateEmployee.do">
<p><label for="title"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Title: <%
	String title = (String) request.getAttribute("title");
	if (title != null && !title.isEmpty()) {
%> <%=title%> <%
 	}
 %></label>

</p>

<div id="apDiv8"><label for="name"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">*Name:<%
	String name = (String) request.getAttribute("name");
	if (name != null && !name.isEmpty()) {
%> <%=name%> <%
 	}
 %></label>

</div>

<div id="apDiv9"><label for="designation3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">*Designation:<%
	String designation = (String) request.getAttribute("designation");
	if (designation != null && !designation.isEmpty()) {
%> <%=designation%> <%
 	}
 %></label>

</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><label for="employeeNumber2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
</label></p>
<div id="apDiv10"><label for="employeeNumber3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Employee
No.:</label> <%
 	String employeeNumber = (String) request.getAttribute("employeeNum");
 	if (employeeNumber != null && !employeeNumber.isEmpty()) {
 %> <%=employeeNumber%> <%
 	}
 %>
</div>
<p><label for="employeeNumber2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
</label></p>
<div id="apDiv11"><label for="division3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Division/Office:</label>
<%
	DivisionOffice division = (DivisionOffice) request.getAttribute("division");
	out.print("" + division.getDivisionName());
	if (division.getOfficeName() != null)
		out.print("," + division.getOfficeName());
%><label for="office3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"></label>
</div>
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
Number:</label> <select>
	<%
		ArrayList<String> mobileNumber = (ArrayList<String>) request.getAttribute("mobil");
		int mobileNumberNo = 0;
		if (mobileNumber != null)
			mobileNumberNo = mobileNumber.size();
	%>
	<%
		for (int i = 0; i < mobileNumberNo; i++) {
	%><option><%=mobileNumber.get(i)%></option>
	<%
		}
	%>
</select></div>
<p><label for="mobileNumber2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
</label></p>
<div id="apDiv14"><label for="landline3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Landline:</label>
<select>
	<%
		ArrayList<String> landline = (ArrayList<String>) request.getAttribute("landline");
		int landlineNo = 0;
		if (landline != null)
			landlineNo = landline.size();
	%>
	<%
		for (int i = 0; i < landlineNo; i++) {
	%><option><%=landline.get(i)%></option>
	<%
		}
	%>
</select></div>
<div id="apDiv15"><label for="emailad3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
E-mail Address:</label> <select>
	<%
		ArrayList<String> emailad = (ArrayList<String>) request.getAttribute("emailad");
		int emailNo = 0;
		if (emailad != null)
			emailNo = emailad.size();
	%>
	<%
		for (int i = 0; i < emailNo; i++) {
	%><option><%=emailad.get(i)%></option>
	<%
		}
	%>
</select></div>
<p>&nbsp;</p>
<p>&nbsp;</p>

<div id="apDiv20"><input type="submit" name="addBtn" id="addBtn"
	value="Add"
	style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;" />
</div>
<p>&nbsp;</p>
<p><br />
</p>
</form>
</div>
</body>
</html>
