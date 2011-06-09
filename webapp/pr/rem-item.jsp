<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.entities.Item"%>
<%@page import="com.iappsam.util.Managers"%>
<%@page import="com.iappsam.entities.ItemCategory"%>
<%@page import="java.util.ArrayList"%>
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

#apDiv10 {
	position: absolute;
	width: 119px;
	height: 17px;
	z-index: 16;
	left: 584px;
	top: 336px;
}

#apDiv11 {
	position: absolute;
	width: 104px;
	height: 28px;
	z-index: 17;
	left: 692px;
	top: 325px;
}

#apDiv9_2 {
	position: absolute;
	width: 872px;
	height: 18px;
	z-index: 3;
	left: 0px;
	top: 429px;
}

#apDiv10_2 {
	position: absolute;
	width: 871px;
	height: 174px;
	z-index: 4;
	left: 1px;
	top: 449px;
}

#apDiv1 {
	position: absolute;
	width: 200px;
	height: 29px;
	z-index: 2;
	left: -3px;
	top: -57px;
}
</style>
</head>

<%
	ArrayList<String> itemID = (ArrayList<String>) session.getAttribute("itemList");
	ArrayList<Item> itemList = new ArrayList<Item>();
	for (int i = 0; i < itemID.size(); i++)
		itemList.add(Managers.ITEM_MANAGER.getItem(Integer.parseInt(itemID.get(i))));
%>
<body>
	<div id="logoHeader" style="width: 100%">
		<img name="" src="../../images/header2.png" width="100%" height="115" alt="" />
	</div>
	<div id="pageLabel" style="width: 100%;">
		<table width="100%" border="0">
			<tr>
				<td width="14%">
					<table width="100%" frame="below">
						<tr>
							<td style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">Remove Article/s</td>
						</tr>
					</table></td>
				<td width="82%">&nbsp;</td>
				<td width="4%">
					<form id="form15" name="form15" method="post" action="pr_form_2.jsp">
						<input name="backBtn" type="submit" class="button" id="backBtn" value="Back" />
					</form></td>
			</tr>
		</table>
	</div>
	<div id="logoutiv" style="width: 90%">
		<form id="form2" name="form2" method="post" action="">
			<input name="logout" type="submit" class="maroon" id="logout" value="Logout" />
		</form>
	</div>
	<div id="apDiv10_2" style="width: 100%">

		<form id="form2" name="form2" method="post" action="pr_form_remove_item.do">
			<div id="apDiv1">
				<input name="addAllBtn" type="submit" class="maroon" id="addAllBtn" value="Remove Selected Items &gt;&gt;" />
			</div>
			<table width="100%" cellspacing="0" frame="box" class="resultTable">
				<%
					boolean rowOdd = true;
					if (itemList != null) {
						for (int i = 0; i < itemList.size(); i++) {
				%>
				<tr <%if (rowOdd) {
						out.print("class=" + '"' + "tablerow_1" + '"');
						rowOdd = !rowOdd;
					} else
						rowOdd = !rowOdd;%>>
					<td width="9%" align="center"><input type="checkbox" name="include1" id="include1" value="<%=itemList.get(i).getId()%>" /> <label
						for="include_1"
					></label>
					</td>
					<td width="54%"><%=itemList.get(i).getDescription()%></td>
					<td width="37%"><%=itemList.get(i).getCategory().getName()%></td>
				</tr>
				<%
					}
					}
				%>
			</table>

		</form>
		<p>&nbsp;</p>
	</div>
	<p>&nbsp;</p>
	<div id="apDiv9_2" style="width: 100%">
		<table width="100%" border="0" cellspacing="0" class="tableheaders">
			<tr>
				<td width="9%">Include</td>
				<td width="54%">Item Description</td>
				<td width="37%">Item Category</td>
			</tr>
		</table>
	</div>
	<div id="footer">
		<table width="100%" frame="above" bordercolor="#333333" style="font-family: Verdana, Geneva, sans-serif; color: #333333; font-size: 9px">
			<tr>
				<td>Copyright © 2011 All Rights Reserved</td>
			</tr>
		</table>
	</div>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
</body>
</html>

