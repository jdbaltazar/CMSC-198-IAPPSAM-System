<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
	left: 379px;
	top: 285px;
}

#apDiv1 {
	position: absolute;
	width: 200px;
	height: 29px;
	z-index: 2;
	left: 808px;
	top: 288px;
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

#apDiv9 {
	position: absolute;
	width: 872px;
	height: 23px;
	z-index: 3;
	left: 0px;
	top: 384px;
}

#apDiv10 {
	position: absolute;
	width: 871px;
	height: 174px;
	z-index: 4;
	left: 0px;
	top: 407px;
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
</style>
</head>

<div id="logoHeader" style="width: 100%"><img name=""
	src="../../images/header2.png" width="100%" height="115" alt="" /></div>
<div id="pageLabel" style="width: 100%;">
<table width="100%" border="0">
	<tr>
		<td width="11%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">Buildings</td>
			</tr>
		</table>
		</td>
		<td width="85%">&nbsp;</td>
		<td width="4%">
		<form id="form15" name="form15" method="post"
			action="../../MenuFrame.jsp"><input name="backBtn"
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
<div id="searchEmployeesDiv">
<form id="form1" name="form1" method="post" action=""><label
	for="searchBuildingField" class="labels">Search:</label> <input
	name="searchBuildingField" type="text" id="searchBuildingField"
	size="35" /> <input name="goSearchBtn" type="submit" class="maroon"
	id="goSearchBtn" value="GO" /></form>
</div>
<div id="apDiv1">
<form id="form2" name="form2" method="post"
	action="../../entities/building/AddBuilding.jsp"><input
	name="addBuildingBtn" type="submit" class="maroon" id="addBuildingBtn"
	value="Add Building &gt;&gt;" /></form>
</div>
<div id="apDiv10" style="width: 100%">
<table width="100%" cellspacing="0" frame="box" class="resultTable">
	<%
		ArrayList<String> bldgName = (ArrayList<String>) request.getAttribute("buildingName");
		ArrayList<String> bldgAddress = (ArrayList<String>) request.getAttribute("buildingAddress");
		int size = bldgName.size();
	%>
	<%
		for (int i = 0; i < size; i++) {
	%>
	<%
		if (i % 2 == 0)
				out.print("<tr class=\"tablerow_1\">");
			else
				out.print("<tr>");
	%>

	<td width="37%"><%=bldgName.get(i)%></td>
	<td width="44%"><%=bldgAddress.get(i)%></td>
	<td width="19%" align="center">
	<form id="form3" name="form3" method="post" action=""><input
		name="viewBtn" type="submit" class="viewbutton" id="viewBtn"
		value="Edit >>" disabled="disabled" /></form>
	</td>
	</tr>
	<%
		}
	%>
</table>
<p>&nbsp;</p>
</div>
<p>&nbsp;</p>
<div id="apDiv9" style="width: 100%">
<table width="100%" border="1" cellspacing="0" class="tableheaders">
	<tr>
		<td width="37%">Building Name</td>
		<td width="44%">Address</td>
		<td width="19%">Action</td>
	</tr>
</table>
</div>
</body>
</html>

