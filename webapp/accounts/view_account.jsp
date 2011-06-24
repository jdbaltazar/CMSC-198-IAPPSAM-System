<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.ContactType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.iappsam.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.iappsam.Contact"%>
<%@page import="com.iappsam.managers.sessions.PersonManagerSession"%>
<%@page import="com.iappsam.managers.PersonManager"%>
<%@page import="com.iappsam.Account"%>
<%@page import="com.iappsam.managers.sessions.AccountManagerSession"%>
<%@page import="com.iappsam.managers.AccountManager"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Create Account</title>
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%
	String userName = request.getParameter("username");
if(userName==null)
	userName=(String)request.getAttribute("userName");
	AccountManager aManager = new AccountManagerSession();
	Account account = aManager.getAccount(userName);
	Contact[] contacts = new Contact[account.getPerson().getContacts()
			.size()];
	account.getPerson().getContacts().toArray(contacts);
	PersonManager pManager = new PersonManagerSession();
	List<Employee> employees = pManager.getEmployeeByPerson(account
			.getPerson().getId());
	ArrayList<Contact> mobile = new ArrayList<Contact>();
	ArrayList<Contact> email = new ArrayList<Contact>();
	ArrayList<Contact> landline = new ArrayList<Contact>();

	for (int i = 0; i < contacts.length; i++) {
		if (contacts[i].getType().equals(ContactType.EMAIL))
			email.add(contacts[i]);

		if (contacts[i].getType().equals(ContactType.LANDLINE))
			landline.add(contacts[i]);

		if (contacts[i].getType().equals(ContactType.MOBILE))
			mobile.add(contacts[i]);
	}
%>
<div id="headerBkgrnd"><img src="../images/headerbar.png"
	width="100%" height="129" /></div>
<div id="logo"><img src="../images/headerlogo.png" width="124"
	height="128" /></div>
<div id="headerName"><img src="../images/headertext.png"
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
		<td id="navigation"><a href="../menu" target="_top" class="links">Main
		Menu</a> &gt; <a href="ViewAccounts.do" target="_top" class="links">Account List</a>
		&gt; <em><strong>View Account</strong></em><strong></strong></td>
		<td>&nbsp;</td>
	</tr>
</table>
<div id="form_table">
<form id="form1" name="form1" method="post" action="">
<table width="100%" frame="box" cellspacing="0" id="table">
		<tr>
			<td class="bkgrnd_white">&nbsp;</td>
		</tr>
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
						<%if (account.getPerson().getTitle() != null) {%>
						value="<%=account.getPerson().getTitle()%>" <%}%>
						disabled="disabled" /></td>
				</tr>
				<tr>
					<td class="align_right" id="align_right">Name:<br />
					</td>
					<td><input type="text" name="name" id="name"
						value="<%=account.getPerson().getName()%>" disabled="disabled" />
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
			<table width="100%" border="0" cellspacing="5">
				<tr align="center" class="align_center">
					<td width="40%">*Designation</td>
					<td width="25%">Employee No.</td>
					<td width="35%">*Division/Office</td>
				</tr>
				<%
					for (int i = 0; i < 4 && i < employees.size(); i++) {
				%>
				<tr>
					<td align="center"><input type="text" name="designation"
						id="designation"
						value="<%=employees.get(i).getDesignation().toString()%>"
						disabled="disabled" /></td>
					<td align="center"><input name="employeeNo" type="text"
						id="employeeNo" size="15"
						<%if (employees.get(i).getEmployeeNumber() != null) {%>
						value="<%=employees.get(i).getEmployeeNumber()%>" <%}%>
						disabled="disabled" /></td>
					<td align="center"><input name="divisionOffice"
						class="menulist" id="divisionOffice" size="15"
						value="<%=employees.get(i).getDivisionOffice().toString()%>"
						disabled="disabled" /></td>
				</tr>
				<%
					}
				%>
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
					<td class="align_right">Cellphone Number:</td>
					<td><select name="cellphoneNumber" id="cellphoneNumber">
						<%
							for (int i = 0; i < mobile.size(); i++) {
						%>
						<option><%=mobile.get(i).getData()%></option>
						<%
							}
						%>
					</select></td>
				</tr>
				<tr>
					<td class="align_right">Landline:</td>
					<td><select name="landline" id="landline">
						<%
							for (int i = 0; i < landline.size(); i++) {
						%>
						<option><%=landline.get(i).getData()%></option>
						<%
							}
						%>
					</select></td>
				</tr>
				<tr>
					<td class="align_right">E-mail Address:</td>
					<td><select name="e-mail_ad" id="e-mail_ad">
						<%
							for (int i = 0; i < email.size(); i++) {
						%>
						<option><%=email.get(i).getData()%></option>
						<%
							}
						%>
					</select></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td class="header_rows">
			<div class="header_1">Account Information</div>
			</td>
		</tr>
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="9">
				<tr>
					<td class="align_right">Username:</td>
					<td><input type="text" name="username" id="username"
						value="<%=account.getUsername()%>" disabled="disabled" /></td>
				</tr>
				<tr>
					<td class="align_right">Account Type:</td>
					<td><input name="accountType" class="menulist"
						id="accountType" value="<%=account.getType().toString()%>"
						disabled="disabled" /></td>
				</tr>
				<tr>
					<td class="align_right">&nbsp;</td>
					<td><input name="createBtn" type="submit" class="button"
						id="createBtn" value="UPDATE" /></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td class="table_footer"></td>
		</tr>
</table>
<input type="hidden" value="<%=userName%>" name="username" /></form>
</div>

<!--<div id="footer"></div>-->
</body>
</html>