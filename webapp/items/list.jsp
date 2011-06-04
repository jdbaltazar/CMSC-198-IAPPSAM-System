<%@page import="com.iappsam.entities.Item"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<link rel="shortcut icon" href="../../favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: Items</title>
<link href="list.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="../logo.jsp" />
	<jsp:include page="../logout-button.jsp" />
	<div id="pageLabel" style="width: 100%;">
		<table width="100%" border="0">
			<tr>
				<td width="7%">
					<table width="100%" frame="below">
						<tr>
							<td style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">Items</td>
						</tr>
					</table>
				</td>
				<td width="89%">&nbsp;</td>
				<td width="4%">
					<form id="form15" name="form15" method="post" action="../menu">
						<input name="backBtn" type="submit" class="button" id="backBtn" value="Back" action="" />
					</form>
				</td>
			</tr>
		</table>
	</div>
	<div id="searchEmployeesDiv">
		<form id="form1" name="form1" method="post" action="../items/SearchAllItems.do">
			<label for="searchItemField" class="labels">Search:</label> <input name="searchItemField" type="text" id="searchItemField" size="35" /> <input
				name="goSearchBtn" type="submit" class="maroon" id="goSearchBtn" value="GO"
			/>
		</form>
	</div>
	<div id="apDiv1">
		<form id="form2" name="form2" method="post" action="../stocks/AddItem.do">
			<input name="addItemBtn" type="submit" class="maroon" id="addItemBtn" value="Add Item &gt;&gt;" />
		</form>
	</div>
	<div id="apDiv9"></div>
	<div id="logoutiv" style="width: 90%">
		<form id="form2" name="form2" method="post" action="../logout">
			<input name="logout" type="submit" class="maroon" id="logout" value="Logout" />
		</form>
	</div>
	<div id="divItemResultTable" style="width: 100%;">
		<table width="100%" cellspacing="0" frame="box" class="resultTable">

			<%
				List<Item> items = (List<Item>) request.getAttribute("items");

				int i = 0;
				for (Item item : items) {

					if (i % 2 == 0)
						out.print("<tr class=\"tablerow_1\">");
					else
						out.print("<tr>");
			%>

			<td width="46%"><%=item.getDescription()%></td>
			<td width="35%"><%=item.getItemCategory().getName()%></td>
			<td width="19%" align="center">
				<form id="form3" name="form3" method="post" action="../items/ViewItem.do">
					<input name="viewBtn" type="submit" class="viewbutton" id="viewBtn" value="View >>" /><input type="hidden" name="itemID"
						value=<%="" + item.getId()%>
					/>
				</form>
			</td>
			</tr>
			<%
				i++;
				}
			%>
		</table>
	</div>
	<p>&nbsp;</p>
	<div id="divItemTableHeader" style="width: 100%;">
		<table width="100%" border="1" cellspacing="0" class="tableheaders">
			<tr>
				<td width="46%">Item Description</td>
				<td width="35%">Item Category</td>
				<td width="19%">Action</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../copyright.jsp" />
</body>
</html>

