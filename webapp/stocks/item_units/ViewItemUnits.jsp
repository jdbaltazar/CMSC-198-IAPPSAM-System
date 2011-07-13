<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.Unit"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Item Unit List</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
<link href="../../css/item_table.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%
		List<Unit> itemUnits = (List<Unit>) request.getAttribute("itemUnits");
	%>
	<div id="headerBkgrnd">
		<img src="../../images/headerbar.png" width="100%" height="129" />
	</div>
	<div id="logo">
		<img src="../../images/headerlogo.png" width="124" height="128" />
	</div>
	<div id="headerName">
		<img src="../../images/headertext.png" width="452" height="44" />
	</div>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<table width="100%" border="0" cellspacing="0">
		<tr>
			<td width="32%">&nbsp;</td>
			<td width="68%"><form id="form2" name="form2" method="post"
					action="../../logout">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn"
						value="Logout" />
				</form></td>
		</tr>
		<tr>
			<td id="navigation"><a href="../menu" target="_top"
				class="links">Main Menu</a> &gt;<a
				href="../stocks?stock-properties-action=view-stock-properties"
				target="_top" class="links">Stock Properties</a> &gt;<em><strong>Item
						Unit List </strong> </em>&gt; <a
				href="../stocks/item-unit?item-unit-action=add-item-unit"
				target="_self" class="links">Add Item Unit</a></td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="items_table">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td width="9%" class="tableheaders_forms">Action</td>
				<td width="91%" class="tableheaders_forms">Item Unit</td>
			</tr>

			<%
				int i = 0;
				for (Unit u : itemUnits) {
			%>

			<tr>
				<td align="center"
					<%if (i % 2 == 0)
					out.println("class=\"tablerow_1\"");
				else
					out.println("class=\"tablerow_2\"");%>><form
						id="form1" name="form1" method="post" action="../stocks/item-unit">
						<input name="editBtn" type="submit" class="button2" id="editBtn"
							value="Edit&gt;&gt;" /> <input type="hidden" name="itemUnitID"
							value=<%="" + u.getId()%> /> <input type="hidden"
							name="item-unit-action" value="edit-item-unit" />
					</form></td>
				<td align="center"
					<%if (i % 2 == 0)
					out.println("class=\"tablerow_1\"");
					else
					out.println("class=\"tablerow_2\"");%>><%=u.getName()%></td>
			</tr>

			<%
				i++;
				}
			%>

		</table>
	</div>
	<!--<div id="footer"></div>-->
</body>
</html>
