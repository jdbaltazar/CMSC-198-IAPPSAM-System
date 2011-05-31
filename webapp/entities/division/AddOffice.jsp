<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.entities.DivisionOffice"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="../../favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Add Office</title>
<style type="text/css">
.headers {
	font-family: Lucida Grande;
	color: white;
	font-size: 16px;
	font-weight: bold;
}

.tablerow_1 {
	background-color: #EEE0E5;
}

.viewbutton {
	font-size: 12px;
	font-family: "Courier New", Courier, monospace;
	background-color: #7B1113;
	color: white;
	border: none;
}

.viewbutton:hover {
	border: none;
	font-weight: bold;
}

.tableheaders {
	background-color: #5E2605;
	color: white;
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

.labels {
	font-family: Lucida Grande;
	font-size: 16px;
	font-weight: bold;
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

#searchEmployeesDiv {
	position: absolute;
	width: 471px;
	height: 33px;
	z-index: 1;
	left: 411px;
	top: 303px;
}

#apDiv1 {
	position: absolute;
	width: 200px;
	height: 29px;
	z-index: 2;
	left: 837px;
	top: 306px;
}

#apDiv2 {
	position: absolute;
	width: 885px;
	height: 226px;
	z-index: 3;
	left: 305px;
	top: 301px;
}

#apDiv3 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 4;
}

#apDiv4 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 4;
}

#apDiv5 {
	position: absolute;
	width: 900px;
	height: 115px;
	z-index: 3;
	left: 270px;
	top: 282px;
}

#apDiv6 {
	position: absolute;
	width: 476px;
	height: 115px;
	z-index: 4;
	left: 482px;
	top: 30px;
}

#apDiv7 {
	position: absolute;
	width: 1629px;
	height: 115px;
	z-index: 3;
	left: -1548px;
	top: 241px;
}

#apDiv8 {
	position: absolute;
	width: 897px;
	height: 115px;
	z-index: 3;
	left: 242px;
	top: 150px;
}

}
#apDiv10 {
	position: absolute;
	width: 1224px;
	height: 309px;
	z-index: 3;
	left: 146px;
	top: 152px;
}

#apDiv11 {
	position: absolute;
	width: 905px;
	height: 502px;
	z-index: 3;
	left: 244px;
	top: 388px;
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
	left: 0px;
	top: 702px;
	width: 100%;
}

#divItemTableHeader {
	position: absolute;
	width: 872px;
	height: 34px;
	z-index: 3;
	left: 1px;
	top: 411px;
}

#divItemResultTable {
	position: absolute;
	width: 871px;
	height: 110px;
	z-index: 4;
	left: 1px;
	top: 433px;
}

#apDiv12 {
	position: absolute;
	width: 100%;
	height: 100%;
	z-index: 16;
	left: 12px;
	top: 226px;
}

#apDiv13 {
	position: absolute;
	width: 448px;
	height: 25px;
	z-index: 17;
	left: 510px;
	top: 58px;
}

#apDiv14 {
	position: absolute;
	width: 482px;
	height: 26px;
	z-index: 1;
	left: 475px;
	top: 89px;
}

#apDiv15 {
	position: absolute;
	width: 408px;
	height: 28px;
	z-index: 2;
	left: 260px;
	top: 185px;
}

#apDiv16 {
	position: absolute;
	width: 482px;
	height: 28px;
	z-index: 2;
	left: 475px;
	top: 115px;
}

#apDiv17 {
	position: absolute;
	width: 480px;
	height: 26px;
	z-index: 3;
	left: 475px;
	top: 234px;
}

#apDiv18 {
	position: absolute;
	width: 480px;
	height: 49px;
	z-index: 4;
	left: 476px;
	top: 261px;
}

#apDiv19 {
	position: absolute;
	width: 200px;
	height: 22px;
	z-index: 5;
	left: 492px;
	top: 92px;
}

#apDiv20 {
	position: absolute;
	width: 200px;
	height: 23px;
	z-index: 6;
	left: 491px;
	top: 237px;
}

#apDiv21 {
	position: absolute;
	width: 200px;
	height: 28px;
	z-index: 7;
	left: 474px;
	top: 163px;
}

#apDiv22 {
	position: absolute;
	width: 104px;
	height: 22px;
	z-index: 8;
	left: 861px;
	top: 92px;
}

#apDiv23 {
	position: absolute;
	width: 74px;
	height: 22px;
	z-index: 9;
	left: 860px;
	top: 236px;
}

#apDiv24 {
	position: absolute;
	width: 483px;
	height: 128px;
	z-index: 6;
	left: 475px;
	top: 115px;
}

#apDiv25 {
	position: absolute;
	width: 443px;
	height: 95px;
	z-index: 7;
	left: 519px;
	top: 128px;
}

#apDiv26 {
	position: absolute;
	width: 392px;
	height: 25px;
	z-index: 17;
	left: 15px;
	top: 64px;
}

#apDiv27 {
	position: absolute;
	width: 79px;
	height: 32px;
	z-index: 17;
	left: 179px;
	top: 64px;
}

#apDiv28 {
	position: absolute;
	width: 482px;
	height: 11px;
	z-index: 8;
	left: 475px;
	top: 243px;
}
</style>
</head>

<body>

<%
	System.out.println("inside addoffice.jsp........");
	DivisionOffice dOffice=(DivisionOffice)request.getAttribute("dOffice");
%>
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
		<td width="10%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">Add
				Office</td>
			</tr>
		</table>
		</td>
		<td width="86%">&nbsp;</td>
		<td width="4%">
		<form id="form15" name="form15" method="post"
			action="ViewDivisionAndOffices.do"><input name="backBtn"
			type="submit" class="button" id="backBtn" value="Back" /> <input
			type="hidden" name="dOfficeID" value=<%=""+dOffice.getId()%> /></form>
		</td>
	</tr>
</table>
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv9"></div>
<div id="logoutiv" style="width: 90%">
<form id="form2" name="form2" method="post" action="../../logout"><input
	name="logout" type="submit" class="maroon" id="logout" value="Logout" />
</form>
</div>
<p>&nbsp;</p>
<div id="apDiv12">
<div class="viewbutton" id="apDiv14"></div>
<div class="headers" id="apDiv19"><%=dOffice.getDivisionName()%></div>
<div class="tablerow_1" id="apDiv24"></div>
<div id="apDiv25">
<form id="form1" name="form1" method="post" action="SaveOffice.do">
<p><label for="officeName" class="labels">Office Name:</label> <input
	name="officeName" type="text" id="officeName" size="35" maxlength="80" /></p>
<div id="apDiv27"><input type="submit" name="addBtn" id="addBtn"
	style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;"
	value="Add" /></div>
<p>&nbsp;</p>
<input type="hidden"
				name="dOfficeID" value=<%="" + dOffice.getId()%>></input>
</form>
</div>
<div class="maroon" id="apDiv28"></div>
</div>
</body>
</html>
