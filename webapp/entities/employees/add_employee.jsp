<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.DivisionOffice"%>
<%@page import="java.util.List"%>
<%@page
	import="com.iappsam.managers.sessions.DivisionOfficeManagerSession"%>
<%@page import="com.iappsam.managers.DivisionOfficeManager"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Add Employee</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>
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
		<td id="navigation"><a href="../../menu" target="_top" class="links">Main
		Menu</a> &gt; <a href="search_employee.do" target="_top" class="links">Employee List</a>
		&gt; <em><strong>Add Employee</strong></em><strong></strong></td>
		<td>&nbsp;</td>
	</tr>
</table>
<div id="form_table">
<form id="form1" name="form1" method="post" action="AddEmployee.do">
<table width="100%" frame="box" cellspacing="0" id="table">
	<tr>
		<td class="header_rows">
		<div class="header_1">Personal Information</div>
		</td>
	</tr>
	<tr>
		<td>
		<table width="100%" cellspacing="9" frame="box"
			class="no_border_table">
			<tr>
				<td class="align_right" id="align_right"><br />
				Title:</td>
				<td><br />
				<input type="text" name="title" id="title"
					<%String title = (String) request.getAttribute("title");
			if (title != null && !title.isEmpty())
				out.print("value=" + '"' + title + '"');%> /></td>
			</tr>
			<tr>
				<td class="align_right" id="align_right">*Name:<br />
				<br />
				</td>
				<td><input type="text" name="name" id="name"
					<%String nameOK = (String) request.getAttribute("nameOK");
			String name = (String) request.getAttribute("name");
			if (nameOK != null && !nameOK.isEmpty()
					&& !nameOK.equalsIgnoreCase("false")) {
				out.print("value=" + '"' + name + '"');
			}%> />
				<%
					if (nameOK != null && !nameOK.isEmpty()
							&& nameOK.equalsIgnoreCase("false")) {
						out.print("*Invalid Input");
					}
				%> <br />
				<br />
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr class="header_rows">
		<td>
		<div class="header_1">Work Information</div>
		</td>
	</tr>
	<tr>
		<td>
		<table width="100%" cellspacing="9" frame="box"
			class="no_border_table">
			<%
				DivisionOfficeManager dManager = new DivisionOfficeManagerSession();
				List<DivisionOffice> dList = dManager.getAllDivisionOffice();
			%>
			<tr>
				<td class="align_right"><br />
				*Designation:</td>
				<td><br />
				<input type="text" name="designation" id="designation"
					<%String designation = (String) request.getAttribute("designation");
			String employeeNo = (String) request.getAttribute("employeeNo");
			String designation1OK = (String) request
					.getAttribute("designation1OK");
			if (designation != null && !designation.isEmpty()) {
				out.print("value=" + '"' + designation + '"');
			} else if (designation1OK != null)
				out.print("value=" + '"' + "**" + '"');%> /></td>
			</tr>
			<tr>
				<td class="align_right">Employee Number:</td>
				<td><input type="text" name="employeeNumber"
					id="employeeNumber"
					<%if (employeeNo != null && employeeNo != null
					&& !employeeNo.isEmpty())
				out.print("value=" + '"' + employeeNo + '"');%> /></td>
			</tr>
			<tr>
				<td class="align_right">Division/Office:<br />
				<br />
				</td>
				<td><select name="division/office" class="menulist"
					id="division/office">
					<%
						for (int i = 0; i < dList.size(); i++) {
					%>
					<option value="<%=dList.get(i).getId()%>">
					<%
						if (dList.get(i).getOfficeName() != null)
								out.print(dList.get(i).getDivisionName() + ","
										+ dList.get(i).getOfficeName());
							else
								out.print(dList.get(i).getDivisionName());
					%>
					</option>
					<%
						}
					%>
				</select> <br />
				<br />
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr class="header_rows">
		<td>
		<div class="header_1">Contact Information</div>
		</td>
	</tr>
	<tr>
		<td>
		<table width="100%" cellspacing="9" frame="box"
			class="no_border_table">
			<tr>
				<td class="align_right"><br />
				Cellphone Number:</td>
				<td><br />
				<input type="text" name="cellphoneNumber" id="cellphoneNumber"
					<%String mobileNumber = (String) request.getAttribute("mobileNumber");
			if (mobileNumber != null && !mobileNumber.isEmpty()) {
				out.print("value=" + '"' + mobileNumber + '"');
			}%> /></td>
			</tr>
			<tr>
				<td class="align_right">Landline:</td>
				<td><input type="text" name="landline" id="landline"
					<%String landline = (String) request.getAttribute("landline");
			if (landline != null && !landline.isEmpty()) {
				out.print("value=" + '"' + landline + '"');
			}%> /></td>
			</tr>
			<tr>
				<td class="align_right">E-mail Address:</td>
				<td><input type="text" name="e-mail_ad" id="e-mail_ad"
					<%String emailad = (String) request.getAttribute("emailad");
			if (emailad != null && !emailad.isEmpty()) {
				out.print("value=" + '"' + emailad + '"');
			}%> /></td>
			</tr>
			<tr>
				<td class="align_right">&nbsp;</td>
				<td><br />
				<input name="addBtn" type="submit" class="button" id="addBtn"
					value="ADD" /> <br />
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td class="table_footer"></td>
	</tr>
</table>
</form>
</div>

<!--<div id="footer"></div>-->
</body>
</html>
