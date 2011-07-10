<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.forms.ModeOfProcurement"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Mode of Procurement List</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
<link href="../../css/item_table.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%
		List<ModeOfProcurement> modes = (List<ModeOfProcurement>) request.getAttribute("modes");
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
			<td width="68%">
				<form id="form2" name="form2" method="post" action="../../logout">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn"
						value="Logout" />
				</form>
			</td>
		</tr>
		<tr>
			<td id="navigation"><a href="../menu" target="_top"
				class="links">Main Menu</a> &gt;<a
				href="../stocks?stock-properties-action=view-stock-properties"
				target="_top" class="links">Stock Properties</a> &gt;<em><strong>Mode
						of Procurement List </strong> </em>&gt; <a
				href="../stocks/mode?mode-action=add-mode" target="_self"
				class="links">Add Mode of Procurement</a></td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="items_table">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td width="9%" class="tableheaders_forms">Action</td>
				<td width="91%" class="tableheaders_forms">Mode of Procurement</td>
			</tr>

			<%
				int i = 0;
				for (ModeOfProcurement mode : modes) {
			%>

			<tr>
				<td align="center"
					<%if (i % 2 == 0)
					out.println("class=\"tablerow_1\"");%>>
					<form id="form1" name="form1" method="post" action="../stocks/mode">
						<input name="editBtn" type="submit" class="button2" id="editBtn"
							value="Edit&gt;&gt;" /> <input type="hidden" name="mopID"
							value=<%="" + mode.getId()%> /> <input type="hidden"
							name="mode-action" value="edit-mode" />
					</form>
				</td>
				<td align="center"
					<%if (i % 2 == 0)
					out.println("class=\"tablerow_1\"");
					else
					out.println("class=\"tablerow_2\"");%>><%=mode.getName()%></td>
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
