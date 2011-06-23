<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.ContactType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.iappsam.Contact"%>
<%@page import="java.util.Set"%>
<%@page import="com.iappsam.managers.ContactManager"%>
<%@page import="com.iappsam.managers.sessions.ContactManagerSession"%>
<%@page import="java.util.List"%>
<%@page import="com.iappsam.Employee"%>
<%@page import="com.iappsam.Person"%>
<%@page import="com.iappsam.managers.sessions.PersonManagerSession"%>
<%@page import="com.iappsam.managers.PersonManager"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::View Employee</title>
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
		<td id="navigation"><a href="../../menu" target="_top"
			class="links">Main Menu</a> &gt; <a href="search_employee.do"
			target="_top" class="links">Employee List</a> &gt; <em><strong>View
		Employee</strong></em><strong></strong></td>
		<td>&nbsp;</td>
	</tr>
</table>
<div id="form_table">
<%
	String employeeID = request.getParameter("employeeID");
	if (employeeID == null)
		employeeID = (String) request.getAttribute("employeeID");
	PersonManager pManager = new PersonManagerSession();
	Employee employee = pManager.getEmployee(Integer.parseInt(employeeID));
	Person person = employee.getPerson();
%>
<form id="form1" name="form1" method="post" action="">
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
				<td class="align_right" id="align_right">Title:</td>
				<td><input type="text" name="title" id="title"
					disabled="disabled" <%if (person.getTitle() != null) {%>
					value="<%=person.getTitle()%>" <%}%> /></td>
			</tr>
			<tr>
				<td class="align_right" id="align_right">*Name:<br />
				</td>
				<td><input type="text" name="name" id="name"
					value="<%=person.getName()%>" disabled="disabled" /> <br />
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
		<table width="100%" border="0" cellspacing="9">
			<tr align="center" class="align_center">
				<td width="40%">*Designation</td>
				<td width="25%">Employee No.</td>
				<td width="35%">*Division/Office</td>
			</tr>

			<tr>
				<td align="center"><input type="text" name="deignation"
					id="deignation" disabled="disabled"
					value="<%=employee.getDesignation().toString()%>" /></td>
				<td align="center"><input name="empNo3" type="text" id="empNo3"
					size="15" disabled="disabled"
					<%if (employee.getEmployeeNumber() != null) {%>
					value="<%=employee.getEmployeeNumber()%>" <%}%> /></td>
				<td align="center"><input name="divisionOffice4"
					class="menulist" id="divisionOffice4" disabled="disabled"
					<%String s = "";
			if (employee.getDivisionOffice().getOfficeName() != null)
				s = "/"+employee.getDivisionOffice().getOfficeName();%>
					value="<%=""+employee.getDivisionOffice().getDivisionName()+s%>"> </input></td>
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
		<%
			Contact[] contacts = new Contact[employee.getPerson().getContacts().size()];
			employee.getPerson().getContacts().toArray(contacts);
			ArrayList<Contact> mobile = new ArrayList<Contact>();
			ArrayList<Contact> landline = new ArrayList<Contact>();
			ArrayList<Contact> email = new ArrayList<Contact>();
			if (contacts != null) {

				for (int i = 0; i < contacts.length; i++) {
					if (contacts[i].getType().equals(ContactType.EMAIL))
						email.add(contacts[i]);

					if (contacts[i].getType().equals(ContactType.MOBILE))
						mobile.add(contacts[i]);

					if (contacts[i].getType().equals(ContactType.LANDLINE))
						landline.add(contacts[i]);
				}
			}
		%>
		<td>
		<table width="100%" cellspacing="9" frame="box"
			class="no_border_table">
			<tr>
				<td class="align_right">Cellphone Number:</td>
				<td>
				<%
					if (!mobile.isEmpty()) {
				%><select name="cellphoneNumber" id="cellphoneNumber">
					<%
						for (int i = 0; i < mobile.size(); i++) {
					%>
					<option><%=mobile.get(i).getData()%></option>
					<%
						}
					%>
				</select> <%
 	} else {
 %> <input name="dummy" disabled="disabled" size="15" maxlength="15" />
				<%
					}
				%>
				</td>
			</tr>
			<tr>
				<td class="align_right">Landline:</td>
				<td>
				<%
					if (!landline.isEmpty()) {
				%><select name="landline" id="landline">
					<%
						for (int i = 0; i < landline.size(); i++) {
					%>
					<option><%=landline.get(i).getData()%></option>
					<%
						}
					%>
				</select> <%
 	} else {
 %> <input name="dummy" disabled="disabled" size="15" maxlength="15" />
				<%
					}
				%>
				</td>
			</tr>
			<tr>
				<td class="align_right">E-mail Address:</td>
				<td>
				<%
					if (!email.isEmpty()) {
				%><select name="e-mail_ad" id="e-mail_ad">
					<%
						for (int i = 0; i < email.size(); i++) {
					%>
					<option><%=email.get(i).getData()%></option>
					<%
						}
					%>
				</select> <%
 	} else {
 %> <input name="dummy" disabled="disabled" size="15" maxlength="15" />
				<%
					}
				%>
				</td>
			</tr>
			<tr>
				<td class="align_right">&nbsp;</td>
				<td><input name="addBtn" type="submit" class="button"
					id="addBtn" value="Update" /> <br />
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
