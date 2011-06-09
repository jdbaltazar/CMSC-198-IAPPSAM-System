<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.entities.DivisionOffice"%>
<%@page import="java.util.List"%>
<%@page
	import="com.iappsam.managers.sessions.DivisionOfficeManagerSession"%>
<%@page import="com.iappsam.managers.DivisionOfficeManager"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
.tableheaders { /*background-color:#5E2605;
	color:white;*/
	font-family: Lucida Grande;
	font-size: 14px;
	text-align: center;
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
	left: 440px;
	top: 252px;
}

#titleDiv {
	position: absolute;
	width: 388px;
	height: 879px;
	z-index: 3;
	left: 555px;
	top: 287px;
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
	height: 886px;
	z-index: 3;
	left: 439px;
	top: 278px;
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
	left: 439px;
	top: 856px;
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
	left: 440px;
	top: 405px;
}

#apDiv3 {
	position: absolute;
	width: 578px;
	height: 9px;
	z-index: 13;
	left: 439px;
	top: 1164px;
}

#border {
	position: absolute;
	width: 585px;
	height: 922px;
	z-index: 1;
	left: 319px;
	top: 184px;
}

#contactInfoDiv {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 14;
	left: 438px;
	top: 654px;
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
	left: 472px;
	top: 1123px;
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
	left: -60px;
	top: 208px;
}

#apDiv11 {
	position: absolute;
	width: 706px;
	height: 27px;
	z-index: 19;
	left: -75px;
	top: 251px;
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
	top: 417px;
}

#apDiv14 {
	position: absolute;
	width: 394px;
	height: 25px;
	z-index: 19;
	left: 5px;
	top: 468px;
}

#apDiv15 {
	position: absolute;
	width: 429px;
	height: 31px;
	z-index: 19;
	left: -51px;
	top: 492px;
}

#apDiv16 {
	position: absolute;
	width: 483px;
	height: 29px;
	z-index: 19;
	left: -7px;
	top: 619px;
}

#apDiv17 {
	position: absolute;
	width: 404px;
	height: 28px;
	z-index: 19;
	left: -5px;
	top: 668px;
}

#apDiv18 {
	position: absolute;
	width: 482px;
	height: 27px;
	z-index: 19;
	left: -81px;
	top: 717px;
}

#apDiv19 {
	position: absolute;
	width: 500px;
	height: 30px;
	z-index: 19;
	left: -41px;
	top: 764px;
}

#apDiv20 {
	position: absolute;
	width: 64px;
	height: 35px;
	z-index: 19;
	left: 132px;
	top: 818px;
}

#pageLabel {
	position: absolute;
	width: 200px;
	height: 45px;
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
	top: 1234px;
	width: 100%;
}

#apDiv21 {
	position: absolute;
	width: 557px;
	height: 144px;
	z-index: 19;
	left: -106px;
	top: 155px;
}
</style>
</head>

<body>
<div id="footer">
<table width="100%" frame="above" bordercolor="#333333"
	style="font-family: Verdana, Geneva, sans-serif; color: #333333; font-size: 9px">
	<tr>
		<td>Copyright © 2011 All Rights Reserved</td>
	</tr>
</table>
</div>
<div id="logoHeader" style="width: 100%"><img name=""
	src="../images/header2.png" width="100%" height="115" alt="" /></div>
<div id="pageLabel" style="width: 100%;">
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
		<td width="4%">
		<form id="form15" name="form15" method="post" action="../menu.jsp"><input
			name="backBtn" type="submit" class="button" id="backBtn" value="Back" /></form>
		</td>
	</tr>
</table>
</div>
<div id="logoutiv" style="width: 90%">
<form id="form2" name="form2" method="post" action=""><input
	name="logout" type="submit" class="maroon" id="logout" value="Logout" />
</form>
</div>
<div id="background" style="background-color: #EEE0E5;"></div>
<div id="accountInfoHeader"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Account
Information</div>
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
<div align="center" id="personalInfo"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Personal
Information</div>
<div id="titleDiv">
<%
	DivisionOfficeManager dManager = new DivisionOfficeManagerSession();
	List<DivisionOffice> dList = dManager.getAllDivisionOffice();
%>
<form id="form1" name="form1" method="post" action="CreateAccount.do">
<p><label for="title"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Title:</label>
<input name="title" type="text" id="title" size="20" /></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv8"><label for="name"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">*Name:</label>
<input name="name" type="text" id="name" size="40" /></div>
<p><label for="employeeNumber2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
</label></p>
<p>&nbsp;</p>
<div id="apDiv21">
<table width="100%" border="1" text-align="center" cellspacing="0">
	<tr class="tableheaders">
		<td width="37%">*Designation</td>
		<td width="13%">Employee No.</td>
		<td width="50%">Division/Office</td>
	</tr>
	<tr>
		<td>
		<div align="center"><label for="designation_1"></label> <input
			type="text" name="designation" id="designation_1" /></div>
		</td>
		<td>
		<div align="center"><input name="employeeNo" type="text"
			id="employeeNo._1" size="4" /></div>
		</td>
		<td>
		<div align="center"><select name="divisionOfficeDropdown"
			id="divisionOfficeDropdown">

			<%
				for (int i = 0; i < dList.size(); i++) {
			%>
			<option value="<%=dList.get(i).getId()%>">
			<%
				if (dList.get(i).getOfficeName() != null)
						out.print(dList.get(i).getDivisionName() + "," + dList.get(i).getOfficeName());
					else
						out.print(dList.get(i).getDivisionName());
			%>
			</option>
			<%
				}
			%>
		</select></div>
		</td>
	</tr>
	<tr>
		<td>
		<div align="center"><label for="designation_1"></label> <input
			type="text" name="designation" id="designation_1" /></div>
		</td>
		<td>
		<div align="center"><input name="employeeNo" type="text"
			id="employeeNo._1" size="4" /></div>
		</td>
		<td>
		<div align="center"><select name="divisionOfficeDropdown"
			id="divisionOfficeDropdown">

			<%
				for (int i = 0; i < dList.size(); i++) {
			%>
			<option value="<%=dList.get(i).getId()%>">
			<%
				if (dList.get(i).getOfficeName() != null)
						out.print(dList.get(i).getDivisionName() + "," + dList.get(i).getOfficeName());
					else
						out.print(dList.get(i).getDivisionName());
			%>
			</option>
			<%
				}
			%>
		</select></div>
		</td>
	</tr>
	<tr>
		<td>
		<div align="center"><label for="designation_1"></label> <input
			type="text" name="designation" id="designation_1" /></div>
		</td>
		<td>
		<div align="center"><input name="employeeNo" type="text"
			id="employeeNo._1" size="4" /></div>
		</td>
		<td>
		<div align="center"><select name="divisionOfficeDropdown"
			id="divisionOfficeDropdown">

			<%
				for (int i = 0; i < dList.size(); i++) {
			%>
			<option value="<%=dList.get(i).getId()%>">
			<%
				if (dList.get(i).getOfficeName() != null)
						out.print(dList.get(i).getDivisionName() + "," + dList.get(i).getOfficeName());
					else
						out.print(dList.get(i).getDivisionName());
			%>
			</option>
			<%
				}
			%>
		</select></div>
		</td>
	</tr>
</table>
</div>
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
Number:</label> <input name="mobileNumber" type="text" id="mobileNumber3"
	size="25"
	<%String mobileNumber = (String) request.getAttribute("mobileNumber");
			if (mobileNumber != null && !mobileNumber.isEmpty()) {
				out.print("value=" + '"' + mobileNumber + '"');
			}%> /></div>
<p><label for="mobileNumber2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
</label></p>
<div id="apDiv14"><label for="landline3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Landline:</label>
<input name="landline" type="text" id="landline3" size="25"
	<%String landline = (String) request.getAttribute("landline");
			if (landline != null && !landline.isEmpty()) {
				out.print("value=" + '"' + landline + '"');
			}%> /></div>
<div id="apDiv15"><label for="emailad3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold"><br />
E-mail Address:</label> <input name="emailad" type="text" id="emailad3"
	size="25"
	<%String emailad = (String) request.getAttribute("emailad");
			if (emailad != null && !emailad.isEmpty()) {
				out.print("value=" + '"' + emailad + '"');
			}%> /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv16"><label for="userName3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">*Username:</label>
<input name="username" type="text" id="userName3" size="35"
	<%String usernameOk = (String) request.getAttribute("usernameOK");
			String username = (String) request.getAttribute("username");
			if (usernameOk != null && !usernameOk.isEmpty() && !usernameOk.equalsIgnoreCase("false")) {
				out.print("value=" + '"' + username + '"');
			}%> />
<%
	if (usernameOk != null && !usernameOk.isEmpty() && usernameOk.equalsIgnoreCase("false")) {
		out.print("*Invalid Input");
	}
%>
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv17"><label for="password3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">*Password:</label>
<input name="password" type="password" id="password3" size="30"
	<%String passwordOk = (String) request.getAttribute("passwordOK");%> />
<%
	if (passwordOk != null && !passwordOk.isEmpty() && passwordOk.equalsIgnoreCase("false")) {
		out.print("*Invalid Input");
	}
%>
</div>
<p>&nbsp;</p>
<div id="apDiv18"><label for="reenterPassword3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">*Re-enter
Password:</label> <input name="reenterPassword" type="password"
	id="reenterPassword3" size="30" /> <%
 	if (passwordOk != null && !passwordOk.isEmpty()&& passwordOk.equalsIgnoreCase("false")) {
 		out.print("*Invalid Input");
 	}
 %>
</div>
<p>&nbsp;</p>
<div id="apDiv19"><label for="acctType3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">*Account
Type: </label> <select name="acctType" id="acctType3">
	<option>Non-SPSO Personnel (Employee)</option>
	<option>Non-SPSO Personnel (Head)</option>
	<option>SPSO Personnel</option>
	<option>System Admin</option>
</select></div>
<p>&nbsp;</p>
<div id="apDiv20"><input type="submit" name="submit" id="submit"
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
