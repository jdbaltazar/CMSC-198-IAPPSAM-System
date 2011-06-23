<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="com.iappsam.managers.sessions.AccountManagerSession"%>
<%@page import="com.iappsam.managers.AccountManager"%>
<%@page import="com.iappsam.managers.sessions.PersonManagerSession"%>
<%@page import="com.iappsam.managers.PersonManager"%>
<%@page import="com.iappsam.Account"%>
<%@page import="com.iappsam.AccountType"%>
<%@page import="com.iappsam.Person"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Account for Existing</title>
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>

<%
	ArrayList<Person> persons = (ArrayList<Person>) request.getAttribute("persons");
	AccountType[] accountTypes = AccountType.values();
	System.out.println(accountTypes.length);
	String personID = (String) request.getAttribute("personSelect");
	String username = (String) request.getAttribute("username");
	String accountType = (String) request.getAttribute("accounttype");
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
		<td width="41%">&nbsp;</td>
		<td width="59%">
		<form id="form2" name="form2" method="post"
			action="create-account-for-employee.do"><input
			name="logoutBtn" type="submit" class="logout" id="logoutBtn"
			value="Logout" /></form>
		</td>
	</tr>
	<tr>
		<td id="navigation"><a href="#" target="_top" class="links">Main
		Menu</a> &gt; <a href="#" target="_top" class="links">Account List</a>
		&gt;<em><strong>Account for Existing Employee</strong></em></td>
		<td>&nbsp;</td>
	</tr>
</table>
<div id="form_table">
<form id="form1" name="form1" method="post" action="">
<table width="100%" border="0" cellspacing="0" id="table">
	<tr>
		<td class="header_rows">
		<div class="header_1">Account Information</div>
		</td>
	</tr>
	<tr>
		<td>
		<table width="100%" border="0" cellspacing="9">
			<tr>
				<td class="align_right">*Employee Name:</td>
				<td><select name="personID" class="menulist" id="personID">
					<%
						int i = 0;
						for (Person p : persons) {
							System.out.println(p.getName());
					%>

					<option value="<%=p.getId()%>"
						<%if (("" + p.getId()).equals(personID)) {%> selected="selected"
						<%}%>><%=p.getName()%></option>
					<%
						i++;
						}
					%>
				</select></td>
			</tr>
			<tr>
				<td class="align_right">*Username:</td>
				<td><input type="text" name="username" id="username" /></td>
			</tr>
			<tr>
				<td class="align_right">*Password:</td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td class="align_right">*Re-enter Password:</td>
				<td><input type="password" name="reenterPassword"
					id="reenterPassword" /></td>
			</tr>
			<tr>
				<td class="align_right">*Account Type:</td>
				<td><select name="accountType" class="menulist"
					id="accountType">
					<%
						for (int j = 0; j < accountTypes.length; j++) {
					%>
					<option <%if (accountTypes[j].toString().equals(accountType)) {%>
						selected="selected" <%}%>><%=accountTypes[j].toString()%></option>
					<%
						
						}
					%>


				</select></td>
			</tr>
			<tr>
				<td class="align_right">&nbsp;</td>
				<td><input name="createBtn" type="submit" class="button"
					id="createBtn" value="CREATE" /></td>
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
