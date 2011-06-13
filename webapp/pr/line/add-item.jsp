<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
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

#searchEmployeesDiv {
	position: absolute;
	width: 471px;
	height: 33px;
	z-index: 1;
	left: 501px;
	top: 288px;
}

#TableHeader {
	position: absolute;
	width: 885px;
	height: 226px;
	z-index: 3;
	left: 2px;
	top: 428px;
}

#apDiv3 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 4;
}

#AddSelectedItem {
	position: absolute;
	width: 146px;
	height: 29px;
	z-index: 4;
	left: 443px;
	top: 628px;
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

#apDiv9 {
	position: absolute;
	width: 959px;
	height: 441px;
	z-index: 3;
	left: 3px;
	top: 380px;
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
	left: 134px;
	top: 17px;
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
	top: 843px;
	width: 100%;
}

#Search {
	position: absolute;
	width: 119px;
	height: 17px;
	z-index: 16;
	left: 472px;
	top: 260px;
}

#apDiv11 {
	position: absolute;
	width: 104px;
	height: 28px;
	z-index: 17;
	left: 692px;
	top: 325px;
}

#AddNewItem {
	position: absolute;
	width: 872px;
	height: 18px;
	z-index: 3;
	left: 454px;
	top: 344px;
}

#apDiv10_2 {
	position: absolute;
	width: 871px;
	height: 127px;
	z-index: 4;
	left: 1px;
	top: 449px;
}

#ItemNotFound {
	position: absolute;
	width: 200px;
	height: 29px;
	z-index: 2;
	left: 242px;
	top: 344px;
}
</style>
</head>

<body>

	<!-- Logo -->
	<div id="logoHeader" style="width: 100%">
		<img name="" src="../../images/header2.png" width="100%" height="115" alt="" />
	</div>

	<!-- Nav -->
	<div id="pageLabel" style="width: 100%;">
		<table width="100%" border="0">
			<tr>
				<td width="13%"><table width="100%" frame="below">
						<tr>
							<td style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">Add Article/s</td>
						</tr>
					</table></td>
				<td width="80%">&nbsp;</td>
				<td width="7%"><form id="form15" name="form15" method="post" action="pr_form_2.jsp">
						<input name="backBtn" type="submit" class="button" id="backBtn" value="Back" />
					</form></td>
			</tr>
		</table>
	</div>

	<!-- Logout -->
	<div id="Logout" style="width: 90%; position: absolute; left: 11px; top: 138px;">
		<form id="form2" name="form2" method="post" action="">
			<input name="logout" type="submit" class="maroon" id="logout" value="Logout" />
		</form>
	</div>

	<!-- Search -->
	<div id="Search">
		<form id="SearchForm" name="SearchForm" method="get" action="">
			<label for="SearchField" class="labels">Search:</label> <input name="q" type="text" id="SearchField" size="35" /> <input name="GoButton" type="submit" class="maroon" id="GoButton" value="GO" />
		</form>
	</div>

	<!-- Add New Item -->
	<div id="AddNewItem">
		<form id="form3" name="form3" method="get" action="/items">
			<input type="hidden" name="new" value="item" />
			 <input name="NewItemButton" type="submit" class="maroon" id="addNewItem" value="New Item" />
		</form>
	</div>
	<div id="ItemNotFound" style="font-family: Lucida Grande; font-size: 10px; color: red;">
		<em>Item Not Found?</em>
</div>

	<!-- Table Header -->
	<div id="TableHeader" style="width: 100%">
		<table width="100%" border="0" cellspacing="0" class="tableheaders">
			<tr>
				<td width="9%"></td>
				<td width="54%">Item Description</td>
				<td width="37%">Item Category</td>
			</tr>
		</table>
	</div>

	<!-- Results -->
	<div id="apDiv10_2" style="width: 100%">
		<form name="AddSelectedItem" action="/pr/line" method="post" >
		<input type="hidden" name="add" value="items"/>
		<table width="100%" cellspacing="0" frame="box" class="resultTable">
			<c:forEach var="item" items="${items}">
				<tr>
					<td width="9%" align="center"><input type="checkbox" name="itemIds" id="items" value="${item.id}" /></td>
					<td width="54%">${item.description}</td>
					<td width="37%">${item.category}</td>
				</tr>
			</c:forEach>
		</table>
		<input name="add" type="submit" class="maroon" id="addAllBtn" value="Add Selected Items &gt;&gt;" />
		</form>
	</div>

	<!-- Copyright -->
	<div id="footer">
		<table width="100%" frame="above" bordercolor="#333333" style="font-family: Verdana, Geneva, sans-serif; color: #333333; font-size: 9px">
			<tr>
				<td>Copyright � 2011 All Rights Reserved</td>
			</tr>
		</table>
	</div>
</body>
</html>
