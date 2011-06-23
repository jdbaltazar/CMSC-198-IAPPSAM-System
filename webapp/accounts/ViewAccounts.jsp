<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.Account"%>
<%@page import="java.util.List"%>
<%@page import="com.iappsam.managers.AccountManager"%>
<%@page import="com.iappsam.managers.sessions.AccountManagerSession"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Account List</title>
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
<link href="../css/item_table.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%
	List<Account> accounts = (List<Account>) request.getAttribute("accounts");
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
		Menu</a> &gt;<em><strong>Account List </strong></em>&gt; <a
			href="create_account.jsp" target="_self" class="links">Create
		Account</a></td>
		<td>&nbsp;</td>
	</tr>
</table>
<div id="items_table">
<table width="100%" border="0" cellspacing="0">
	<tr>
		<td colspan="4" align="center">
		<form id="form4" name="form4" method="post" action=""><label
			for="searchField"><span class="align_right">Search</span>:</label> <input
			type="text" name="searchField" id="searchField" /> <input
			name="goBtn" type="submit" class="button" id="goBtn" value="GO" /></form>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td width="5%" class="tableheaders_forms">Action</td>
		<td width="20%" class="tableheaders_forms">Account Type</td>
		<td width="20%" class="tableheaders_forms">Username</td>
		<td width="55%" class="tableheaders_forms">Name</td>

	</tr>
	<%
		boolean isODD = true;
		for (Account a : accounts) {
	%>
	<tr>
		<td align="center" <%if (isODD) {%> class="tablerow_1" <%}%>
			<%if (!isODD) {%> class="tablerow_2" <%}%>>
		<form id="form1" name="form1" method="post" action="view_account.jsp"><input
			name="editBtn" type="submit" class="button2" id="editBtn"
			value="View&gt;&gt;" /> <input type="hidden" name="username"
			value="<%=a.getUsername()%>" /></form>
		</td>
		<td <%if (isODD) {%> class="tablerow_1" <%}%> <%if (!isODD) {%>
			class="tablerow_2" <%}%>><%=a.getType().toString()%></td>
		<td <%if (isODD) {%> class="tablerow_1" <%}%> <%if (!isODD) {%>
			class="tablerow_2" <%}%>><%=a.getPerson().getName() %>
		</td>
		<td <%if (isODD) {%> class="tablerow_1" <%}%> <%if (!isODD) {%>
			class="tablerow_2" <%}%>><%=a.getPerson().getName() %></td>

	</tr>
	<%
		isODD = !isODD;
		}
	%>
</table>
</div>
<!--<div id="footer"></div>-->
</body>
</html>