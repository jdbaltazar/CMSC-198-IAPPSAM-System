<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="com.iappsam.entities.DivisionOffice"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
.resultTable{
	font-family:Lucida Grande;
}

.tablerow_1{
	background-color:#EEE0E5;
}
.viewbutton{
	font-size:12px;
	font-family:"Courier New", Courier, monospace;
	background-color:#7B1113;
	color: white;
	border:none;
}
.viewbutton:hover{
	border:none;
	font-weight:bold;
}
.tableheaders{
	background-color:#5E2605;
	color:white;
	font-family:Lucida Grande;
	font-size:14px;
	text-align:center;
}
.maroon{
	font-size:12px;
	font-family:Lucida Grande;
	background-color:#7B1113;
	color:white;
	border-left: 1px solid lightgray;
  border-right: 1px solid lightgray;
  border-top: 1px solid lightgray;
  border-bottom: 1px solid lightgray;
}

.maroon:hover{
	font-weight:bold;
/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
  border-right: 1px solid #7B1113;
  border-top: 1px solid #7B1113;
  border-bottom: 1px solid #7B1113;
}

.labels{
	font-family:Lucida Grande;
	font-size:16px;
	font-weight:bold;
}
.button{
	font-size:14px;
	font-family:Lucida Grande;
	background-color:white;
	color:#7B1113;
	border-left: 1px solid lightgray;
  border-right: 1px solid lightgray;
  border-top: 1px solid lightgray;
  border-bottom: 1px solid lightgray;
}

.button:hover{
	font-weight:bold;
	color:#060;
/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
  border-right: 1px solid #7B1113;
  border-top: 1px solid #7B1113;
  border-bottom: 1px solid #7B1113;
}
#searchEmployeesDiv {
	position:absolute;
	width:471px;
	height:33px;
	z-index:1;
	left: 411px;
	top: 303px;
}
#apDiv1 {
	position:absolute;
	width:200px;
	height:29px;
	z-index:2;
	left: 834px;
	top: 305px;
}
#apDiv2 {
	position:absolute;
	width:885px;
	height:226px;
	z-index:3;
	left: 305px;
	top: 301px;
}
#apDiv3 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:4;
}
#apDiv4 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:4;
}
#apDiv5 {
	position:absolute;
	width:900px;
	height:115px;
	z-index:3;
	left: 270px;
	top: 282px;
}
#apDiv6 {
	position:absolute;
	width:476px;
	height:115px;
	z-index:4;
	left: 482px;
	top: 30px;
}
#apDiv7 {
	position:absolute;
	width:1629px;
	height:115px;
	z-index:3;
	left: -1548px;
	top: 241px;
}
#apDiv8 {
	position:absolute;
	width:897px;
	height:115px;
	z-index:3;
	left: 242px;
	top: 150px;
}
}
#apDiv10 {
	position:absolute;
	width:1224px;
	height:309px;
	z-index:3;
	left: 146px;
	top: 152px;
}
#apDiv11 {
	position:absolute;
	width:905px;
	height:502px;
	z-index:3;
	left: 244px;
	top: 388px;
}
#pageLabel {
	position:absolute;
	width:200px;
	height:50px;
	z-index:1;
	top:181px;
	left: 13px;
}
#logoHeader {
	position:absolute;
	width:200px;
	height:115px;
	z-index:1;
}
#logoutiv {
	position:absolute;
	width:200px;
	height:30px;
	z-index:15;
	left: 14px;
	top: 143px;
}
#footer{
	position:absolute;
	left: 1px;
	top: 887px;
	width: 100%;
}
#divItemTableHeader {
	position:absolute;
	width:872px;
	height:34px;
	z-index:3;
	left: 1px;
	top: 411px;
}
#divItemResultTable {
	position:absolute;
	width:871px;
	height:110px;
	z-index:4;
	left: 1px;
	top: 433px;
}
#apDiv12 {
	position:absolute;
	width:100%;
	height:22px;
	z-index:16;
	left: 0px;
	top: 419px;
}
#apDiv13 {
	position:absolute;
	width:100%;
	height:49px;
	z-index:17;
	left: 0px;
	top: 442px;
}
</style>
</head>

<body>
<div id="footer">
<table width="100%" frame="above" bordercolor="#333333" style="font-family:Verdana, Geneva, sans-serif; color:#333333; font-size:9px">
 <tr>
    <td>Copyright © 2011 All Rights Reserved</td>
  </tr>
</table>
</div>
<div id="logoHeader" style="width:100%"><img name="" src="../../images/header2.png" width="100%" height="115" alt="" /></div>
<div id="pageLabel" style="width:100%;">
<table width="100%" border="0">
  <tr>
    <td width="9%"><table width="100%" frame="below">
      <tr>
        <td style="font-family:Lucida Grande; font-size:20px; font-weight:bold; color:#003300"> Divisions</td>
      </tr>
    </table></td>
    <td width="87%">&nbsp;</td>
    <td width="4%"><form id="form15" name="form15" method="post" action="../../MenuFrame.jsp">
      <input name="backBtn" type="submit" class="button" id="backBtn" value="Back" />
    </form></td>
  </tr>
</table>
</div>
<div id="searchEmployeesDiv">
  <form id="form1" name="form1" method="post" action="">
    <label for="searchItemField" class="labels">Search:</label>
    <input name="searchItemField" type="text" id="searchItemField" size="35" />
    <input name="goSearchBtn" type="submit" class="maroon" id="goSearchBtn" value="GO" />
  </form>
</div>
<div id="apDiv1">
  <form id="form2" name="form2" method="post" action="AddDivision.jsp">
    <input name="addDivisionBtn" type="submit" class="maroon" id="addDivisionBtn" value="Add Division &gt;&gt;" />
  </form>
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv9"></div>
<div id="logoutiv" style="width:90%">
  <form id="form2" name="form2" method="post" action="">
    <input name="logout" type="submit" class="maroon" id="logout" value="Logout" />
  </form>
</div>
<p>&nbsp;</p>
<div id="apDiv12">
  <table width="100%" border="1" cellspacing="0" class="tableheaders">
    <tr>
      <td width="84%">Division Name</td>
      <td width="16%">Action</td>
    </tr>
  </table>
</div>
<div id="apDiv13">
  <table width="100%" frame="box" cellspacing="0">
  <%
		List<DivisionOffice> dOffices = new ArrayList<DivisionOffice>();
		dOffices = (List<DivisionOffice>) request.getAttribute("divOffices");
		int i = 0;
	%>

	<%
		for (DivisionOffice d : dOffices) {
			String officeName = d.getOfficeName();
			if (officeName == null)
				officeName = " ";
	%>
	
	<%
		if (i % 2 == 0)
				out.print("<tr class=\"tablerow_1\">");
			else
				out.print("<tr>");
	%>
      <td width="84%"><%=d.getDivisionName()%></td>
      <td width="16%" align="center"><form id="form3" name="form3" method="post" action="ViewDivisionAndOffices.do">
        <input name="viewBtn" type="submit" class="viewbutton" id="viewBtn" value="View &gt;&gt;" />
        <input type="hidden" name="dOfficeID" value=<%=""+d.getId()%> />
      </form></td>
    </tr>
    <%
		i++;
		}
	%>
  </table>
</div>
</body>
</html>

