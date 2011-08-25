<%@page import="java.util.List"%>
<%@page import="com.iappsam.DivisionOffice"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::View Division/Office</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
<link href="../../css/item_table.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<%
		DivisionOffice dOffice = (DivisionOffice) request.getAttribute("dOffice");
		List<DivisionOffice> offices = (List<DivisionOffice>) request.getAttribute("offices");
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
				<form id="form2" name="form2" method="post" action="/logout">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn"
						value="Logout" />
				</form></td>
		</tr>
		<tr>
			<td id="navigation"><a href="menu" target="_top"
				class="links">Main Menu</a> &gt; <a href="division-office?division-office-action=view-divisions"
				target="_top" class="links">Division List</a> &gt; <em><strong>View
						Division</strong>
			</em>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="form_table">
		<table width="100%" border="0" cellspacing="0">
			<tr class="tableheaders_forms">
				<td width="85%">Division</td>
				<td width="15%">Action</td>
			</tr>
			<tr class="tablerow_1">
				<td align="center"><%=dOffice.getDivisionName()%></td>
				<td>
					<form id="form4" name="form4" method="get"
						action="division-office">
						<input name="editDivisionBtn" type="submit" class="button2"
							id="editDivisionBtn" value="Edit&gt;&gt;" /> <input
							type="hidden" name="dOfficeID" value=<%="" + dOffice.getId()%> />
							<input type="hidden" name="division-office-action" value="edit-division" />
					</form></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>
					<form id="form1" name="form1" method="get" action="division-office">
						<input name="addOfficeBtn" type="submit" class="button"
							id="addOfficeBtn" value="Add Office&gt;&gt;" /> <input
							type="hidden" name="dOfficeID" value="<%="" + dOffice.getId()%>" />
							<input type="hidden" name="division-office-action" value="add-office" />
					</form></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2">
					<table width="100%" border="0" cellspacing="0">
						<tr class="tableheaders_forms">
							<td width="85%">Office/s</td>
							<td width="15%">Action</td>
						</tr>

						<%
							int i = 0;
							for (DivisionOffice office : offices) {
						%>

						<tr
							<%if (i % 2 == 0)
					out.print("class=\"tablerow_1\"");
					else
						out.print("class=\"tablerow_2\"");
					%>>
							<td align="center"><%=office.getOfficeName()%></td>
							<td>
								<form id="form3" name="form3" method="get"
									action="division-office">
									<input name="editOfficeBtn" type="submit" class="button2"
										id="editOfficeBtn" value="Edit&gt;&gt;" /> <input
										type="hidden" name="officeID" value=<%="" + office.getId()%> />
									<input type="hidden" name="dOfficeID"
										value=<%="" + dOffice.getId()%> />
										<input type="hidden" name="division-office-action" value="edit-office" />
								</form></td>
						</tr>
						<%
							i++;
							}
						%>


					</table>
					</td>
					</tr>
					</table>
					</div> <!--<div id="footer"></div>-->
</body>
</html>

