<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.entities.Supplier"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="../../favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: Search Suppliers</title>
<style type="text/css">
.menubtn {
	height: 20px;
	width: 416px;
	font-size: 14px;
	font-family: Lucida Grande;
	background-color: #EEE0E5;
	color: #030;
	border-left: 1px solid lightgray;
	border-right: 1px solid lightgray;
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

.menubtn:hover {
	font-weight: bold;
	color: #060;
	/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
	border-right: 1px solid #7B1113;
	border-top: 1px solid #7B1113;
	border-bottom: 1px solid #7B1113;
}

.header {
	background-color: #7B1113;
	width: 578px;
	height: 25px;
}

.background {
	background-color: #EEE0E5;
	width: 578px;
}

.resultTable {
	font-family: Lucida Grande;
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

#divTableheadr {
	position: absolute;
	width: 200px;
	height: 22px;
	z-index: 1;
	left: 1px;
	top: 374px;
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
	top: 620px;
	width: 100%;
}

#apDiv1 {
	position: absolute;
	width: 102px;
	height: 26px;
	z-index: 16;
	left: 840px;
	top: 289px;
}

#resultTable {
	position: absolute;
	width: 521px;
	height: 164px;
	z-index: 17;
	left: 1px;
	top: 398px;
}

#apDiv2 {
	position: absolute;
	width: 361px;
	height: 31px;
	z-index: 18;
	left: 443px;
	top: 287px;
}
</style>
</head>

<body>

<%
	List<Supplier> suppliers = (List<Supplier>) request.getAttribute("suppliers");
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
		<td width="9%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">Suppliers</td>
			</tr>
		</table>
		</td>
		<td width="87%">&nbsp;</td>
		<td width="4%">
		<form id="form15" name="form15" method="post"
			action="../../MenuFrame.jsp"><input name="backBtn"
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
<div id="divTableheadr" style="width: 100%">
<table width="100%" border="1" cellspacing="0" class="tableheaders">
	<tr>
		<td width="41%">Supplier Name</td>
		<td width="48%">Supplier Address</td>
		<td width="11%">Action</td>
	</tr>
</table>
</div>
<div id="apDiv1">
<form id="form1" name="form1" method="post" action="AddSupplier.jsp"><input
	name="addNewBtn" type="submit" class="maroon" id="addNewBtn"
	value="Add New &gt;&gt;" /></form>
</div>
<div id="resultTable" style="width: 100%">
<table width="100%" frame="box" cellspacing="0">

	<%
		int i = 0;
		for (Supplier s : suppliers) {
			if (i % 2 == 0) {
	%>
	<tr class="tablerow_1">
		<%
			} else {
		%>
		<tr>
			<%
				}
			%>
			<td width="41%"><%=s.getSupplierName()%></td>
			<td width="48%"><%=s.getAddress()%></td>
			<td width="11%" align="center">
			<form id="form4" name="form4" method="post" action=""><input
				name="editBtn_1" type="submit" class="maroon" id="editBtn_1"
				value="Edit" /><input type="hidden" name="supplierID"
				value=<%=s.getId()%> /></form>
			</td>
		</tr>
		<%
			i++;
			}
		%>
	
</table>
</div>
<div id="apDiv2">
<form id="form3" name="form3" method="post" action=""><label
	for="searchField" class="labels">Search:</label> <input
	name="searchField" type="text" id="searchField" size="30" /> <input
	name="hoSearchBtn" type="submit" class="maroon" id="hoSearchBtn"
	value="GO" /></form>
</div>
</body>
</html>