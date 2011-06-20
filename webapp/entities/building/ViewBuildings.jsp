<%@page import="com.iappsam.Building"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Building List</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
<link href="../../css/item_table.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
	List<Building> buildings = (List<Building>) request.getAttribute("buildings");
%>
<div id="headerBkgrnd"><img src="../../images/headerbar.png"
	width="100%" height="129" /></div>
<div id="logo"><img src="../../images/headerlogo.png" width="124"
	height="128" /></div>
<div id="headerName"><img src="../../images/headertext.png"
	width="452" height="44" /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="100%" border="0" cellspacing="0">
	<tr>
		<td width="32%">&nbsp;</td>
		<td width="68%">
		<form id="form2" name="form2" method="post" action=""><input
			name="logoutBtn" type="submit" class="logout" id="logoutBtn"
			value="Logout" /></form>
		</td>
	</tr>
	<tr>
		<td id="navigation"><a href="../../menu" target="_top"
			class="links">Main Menu</a> &gt;<em><strong>Building
		List </strong></em>&gt; <a href="AddBuilding.do" target="_self" class="links">Add
		Building</a></td>
		<td>&nbsp;</td>
	</tr>
</table>
<div id="items_table">
<table width="100%" border="0" cellspacing="0">
	<tr>
		<td width="9%" class="tableheaders_forms">Action</td>
		<td width="91%" class="tableheaders_forms">Building Name</td>
	</tr>

	<%
		int i = 0;
		for (Building b : buildings) {
	%>
	<tr>
		<td align="center" <%if (i % 2 == 0)
					out.print("class=\"tablerow_1\"");%>>
		<form id="form1" name="form1" method="post" action="EditBuilding.do">
		<input name="editBtn" type="submit" class="button2" id="editBtn"
			value="Edit&gt;&gt;" /> <input name="buildingID" type="hidden"
			value="<%=b.getID()%>" /></form>
		</td>
		<td align="center"
			<%if (i % 2 == 0)
					out.print("class=\"tablerow_1\"");%>
			><%=b.getBuildingName()%></td>
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
