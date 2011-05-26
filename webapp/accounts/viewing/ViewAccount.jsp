<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
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

.addbtn {
	border-color: white;
	background-color: #CCC;
	font-family: Lucida Grande;
	font-size: 14px;
	border-left: 1px solid lightgray;
	border-right: 1px solid lightgray;
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

.addbtn:hover {
	color: #7B1113;
	font-weight: bold;
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
	left: 396px;
	top: 317px;
}

#titleDiv {
	position: absolute;
	width: 388px;
	height: 707px;
	z-index: 3;
	left: 532px;
	top: 335px;
}

#nameDiv {
	position: absolute;
	width: 462px;
	height: 24px;
	z-index: 3;
	left: 20px;
	top: 232px;
}

#background {
	position: absolute;
	width: 578px;
	height: 566px;
	z-index: 3;
	left: 396px;
	top: 343px;
}

#designationDiv {
	position: absolute;
	width: 455px;
	height: 24px;
	z-index: 3;
	left: 720px;
	top: 100px;
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
	left: 961px;
	top: 277px;
}

#Division {
	position: absolute;
	width: 535px;
	height: 28px;
	z-index: 5;
	left: 682px;
	top: 390px;
}

#officeDiv {
	position: absolute;
	width: 426px;
	height: 25px;
	z-index: 6;
	left: 839px;
	top: 476px;
}

#accountInfoHeader {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 7;
	left: 397px;
	top: 756px;
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
	height: 75px;
	z-index: 11;
	left: 178px;
	top: 917px;
}

#employmentDiv {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 12;
	left: 397px;
	top: 466px;
}

#apDiv3 {
	position: absolute;
	width: 578px;
	height: 9px;
	z-index: 13;
	left: 396px;
	top: 907px;
}

#border {
	position: absolute;
	width: 585px;
	height: 765px;
	z-index: 1;
	left: 640px;
	top: 119px;
}

#contactInfoDiv {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 14;
	left: 397px;
	top: 550px;
}

#apDiv4 {
	position: absolute;
	width: 426px;
	height: 29px;
	z-index: 15;
	left: 824px;
	top: 557px;
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
	left: 1028px;
	top: 522px;
}

#apDiv7 {
	position: absolute;
	width: 200px;
	height: 18px;
	z-index: 18;
	left: 379px;
	top: 897px;
}

#acctTypediv {
	position: absolute;
	width: 493px;
	height: 29px;
	z-index: 19;
	left: 438px;
	top: 834px;
}

#apDiv8 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 20;
	left: -448px;
	top: -25px;
}

#apDiv9 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 1;
}

#apDiv10 {
	position: absolute;
	width: 489px;
	height: 34px;
	z-index: 1;
	left: -12px;
	top: 522px;
}

#apDiv11 {
	position: absolute;
	width: 438px;
	height: 27px;
	z-index: 15;
	left: 18px;
	top: 468px;
}

#apDiv12 {
	position: absolute;
	width: 360px;
	height: 30px;
	z-index: 15;
	left: -34px;
	top: 366px;
}

#apDiv13 {
	position: absolute;
	width: 292px;
	height: 31px;
	z-index: 15;
	left: 24px;
	top: 310px;
}

#apDiv14 {
	position: absolute;
	width: 522px;
	height: 27px;
	z-index: 15;
	left: -58px;
	top: 261px;
}

#apDiv15 {
	position: absolute;
	width: 275px;
	height: 32px;
	z-index: 15;
	left: -1px;
	top: 306px;
}

#apDiv16 {
	position: absolute;
	width: 382px;
	height: 26px;
	z-index: 15;
	left: -18px;
	top: 260px;
}

#apDiv17 {
	position: absolute;
	width: 341px;
	height: 27px;
	z-index: 15;
	left: -74px;
	top: 216px;
}

#apDiv18 {
	position: absolute;
	width: 457px;
	height: 27px;
	z-index: 15;
	left: -52px;
	top: 173px;
}

#apDiv19 {
	position: absolute;
	width: 437px;
	height: 28px;
	z-index: 15;
	left: -2px;
	top: 82px;
}

#apDiv20 {
	position: absolute;
	width: 284px;
	height: 32px;
	z-index: 15;
	left: 9px;
	top: 32px;
}

#apDiv21 {
	position: absolute;
	width: 93px;
	height: 40px;
	z-index: 15;
	left: 135px;
	top: 610px;
}

#apDiv22 {
	position: absolute;
	width: 545px;
	height: 150px;
	z-index: 15;
	left: -92px;
	top: 185px;
}

#apDiv23 {
	position: absolute;
	width: 281px;
	height: 31px;
	z-index: 15;
	left: 592px;
	top: 506px;
}

#apDiv24 {
	position: absolute;
	width: 256px;
	height: 30px;
	z-index: 16;
	left: 720px;
	top: 701px;
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
	left: -2px;
	top: 1064px;
	width: 100%;
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
	src="../../images/header2.png" width="100%" height="115" alt="" /></div>
<div id="pageLabel" style="width: 100%;">
<table width="100%" border="0">
	<tr>
		<td width="19%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">View
				Account</td>
			</tr>
		</table>
		</td>
		<td width="77%">&nbsp;</td>
		<td width="4%">
		<form id="form15" name="form15" method="post"
			action="ViewAccounts.do"><input name="backBtn"
			type="submit" class="button" id="backBtn" value="Back" /></form>
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
<div id="apDiv23">
<form id="form2" name="form2" method="post" action="ViewWorkInformation.do"><input type="hidden" name ="name" value="<%=request.getAttribute("name") %>"/><input
	name="addWorkInfoBtn" type="submit" class="addbtn" id="addWorkInfoBtn"
	title="Click to view work info." value="Work Information &gt;&gt;" />
</form>
</div>
<div id="apDiv24">
<form id="form3" name="form3" method="post" action=""><input
	name="addContactInfoBtn" type="submit" class="addbtn"
	id="addContactInfoBtn" value="Add New Contact Info &gt;&gt;" /></form>
</div>
<p>&nbsp;</p>
<div id="personalInfo"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">
Personal Information</div>
<div id="titleDiv">
<form id="form1" name="form1" method="post" action="">
<p>&nbsp;</p>
<div id="apDiv20"><label for="title2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Title:</label>
<%=request.getAttribute("title")%></div>
<p>&nbsp;</p>
<div id="apDiv19"><label for="name"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Name:</label>
<%=request.getAttribute("name")%>
</div>

<div id="apDiv12"><label for="emailad3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">E-mail
Address:</label> <select name="emailAds" id="emailAds">
	<%
		int emailAdNum = 0;
		ArrayList<String> emailAd = (ArrayList<String>) request.getAttribute("emailad");
		emailAdNum = emailAd.size();
		for (int i = 0; i < emailAdNum; i++) {
	%>
	<option><%=emailAd.get(i)%></option>
	<%
		}
	%>
</select></div>
<div id="apDiv13"><label for="landline3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Landline:</label>

<select name="landlineNums" id="landlineNums">
	<%
		int landLineNum = 0;
		ArrayList<String> landline = (ArrayList<String>) request.getAttribute("landline");
		landLineNum = landline.size();
		for (int i = 0; i < landLineNum; i++) {
	%>
	<option><%=landline.get(i)%></option>
	<%
		}
	%>
</select></div>
<div id="apDiv14"><label for="mobileNumber3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Cellphone
Number:</label> <select name="cellNumbers" id="cellNumbers">
	<%
		int mobileNum = 0;
		ArrayList<String> mobile = (ArrayList<String>) request.getAttribute("mobileNumber");
		mobileNum = mobile.size();
		for (int i = 0; i < mobileNum; i++) {
	%>
	<option><%=mobile.get(i)%></option>
	<%
		}
	%>
</select></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv11"><label for="userName3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Username:</label>
<%=request.getAttribute("userName") %></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><br />
</p>
</form>

<div id="apDiv21"><input type="submit" name="updateBtn"
	id="updateBtn" value="Update"
	style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;" />
</div>
<div id="apDiv10"><label for="acctType3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Account
Type: </label> <%=request.getAttribute("acctType") %></div>
</div>
</body>
</html>
