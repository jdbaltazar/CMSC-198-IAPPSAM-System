<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.entities.ItemStatus"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="../../favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: View Item Status</title>
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
	height: 46px;
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
	left: 667px;
	top: 291px;
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
	List<ItemStatus> itemStatuses = (List<ItemStatus>) request.getAttribute("itemStatuses");
%>

<div id="logoHeader" style="width: 100%"><img name=""
	src="../../images/header2.png" width="100%" height="115" alt="" /></div>
<div id="pageLabel" style="width: 100%;">
<table width="100%" border="0">
	<tr>
		<td width="11%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">Item
				Status</td>
			</tr>
		</table>
		</td>
		<td width="85%">&nbsp;</td>
		<td width="4%">
		<form id="form15" name="form15" method="post"
			action="../../stocks/stocks/StockProperties.jsp"><input
			name="backBtn" type="submit" class="button" id="backBtn" value="Back" />
		</form>
		</td>
	</tr>
</table>
</div>
<div id="logoutiv" style="width: 90%">
<form id="form2" name="form2" method="post" action="../../logout">
<input name="logout" type="submit" class="maroon" id="logout"
	value="Logout" /></form>
</div>
<div id="divTableheadr" style="width: 100%">
<table width="100%" border="1" cellspacing="0" class="tableheaders">
	<tr>
		<td width="83%">Item Status</td>
		<td width="17%">Action</td>
	</tr>
</table>
</div>
<div id="apDiv1">
<form id="form1" name="form1" method="post" action="AddItemStatus.jsp">
<input name="addNewBtn" type="submit" class="maroon" id="addNewBtn"
	value="Add New &gt;&gt;" /></form>
</div>
<div id="resultTable" style="width: 100%">
<table width="100%" frame="box" cellspacing="0">
	<%
		int i = 0;
		for (ItemStatus itemStatus : itemStatuses) {
	%>
	<%
		if (i % 2 == 0)
				out.print("<tr class=\"tablerow_1\">");
			else
				out.print("<tr>");
	%>
	<td width="83%"><%=itemStatus.getName()%></td>
	<td width="17%" align="center">
	<form id="form4" name="form4" method="post" action="EditItemStatus.do">
	<input name="editBtn_1" type="submit" class="maroon" id="editBtn_1"
		value="Edit" /><input type="hidden" name="itemStatusID"
		value=<%="" + itemStatus.getId()%> /></form>
	</td>
	</tr>
	<%
		i++;
		}
	%>
</table>
</div>

</body>
</html>
