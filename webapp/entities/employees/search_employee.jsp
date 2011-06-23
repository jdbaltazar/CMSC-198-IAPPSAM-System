<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.iappsam.managers.sessions.PersonManagerSession"%>
<%@page import="com.iappsam.managers.PersonManager"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Employee List</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
<link href="../../css/item_table.css" rel="stylesheet" type="text/css" />
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
			class="links">Main Menu</a> &gt;<em><strong>Employee
		List </strong></em>&gt; <a href="add_employee.jsp" target="_self" class="links">Add
		Employee</a></td>
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
		<td width="7%" class="tableheaders_forms">Action</td>
		<td width="35%" class="tableheaders_forms">Employee Name</td>
		<td width="30%" class="tableheaders_forms">Designation</td>
		<td width="28%" class="tableheaders_forms">Division/Office</td>
	</tr>
	<%
		PersonManager pManager = new PersonManagerSession();
		List<Employee> employeeList = pManager.getAllEmployee();
		int j = pManager.getAllEmployee().size();
		for (int i = 0; i < j; i++) {
	%>
	<tr>
		<td
			<%if (i % 2 == 0)
					out.print("class=\"tablerow_1\"");
			else
					out.print("class=\"tablerow_2\"");%>>
		<form id="employeeAction" name="employeeAction" method="get"
			action="view_employee.jsp"><input type="hidden"
			name="employeeID" value="<%=employeeList.get(i).getId()%>"></input> <input
			name="editBtn" type="submit" class="button2" id="editBtn"
			value="View&gt;&gt;" /></form>
		</td>
		<td
			<%if (i % 2 == 0)
					out.print("class=\"tablerow_1\"");
					else
					out.print("class=\"tablerow_2\"");%>>
		<%
			if (employeeList.get(i).getPerson().getTitle() != null)
					out.print(employeeList.get(i).getPerson().getTitle() + " ");
				out.print(employeeList.get(i).getPerson().getName());
		%>
		</td>
		<td
			<%if (i % 2 == 0)
					out.print("class=\"tablerow_1\"");
					else
					out.print("class=\"tablerow_2\"");%>><%=employeeList.get(i).getDesignation()%></td>
		<td
		<%if (i % 2 == 0)
					out.print("class=\"tablerow_1\"");
		else
			out.print("class=\"tablerow_2\"");
					String s = "";
					if(employeeList.get(i).getDivisionOffice()!=null&&employeeList.get(i).getDivisionOffice().getOfficeName()!=null)
						s= "/"+employeeList.get(i).getDivisionOffice().getOfficeName();
					%>
		><%if(employeeList.get(i).getDivisionOffice()!=null)
			out.print(employeeList.get(i).getDivisionOffice().getDivisionName()+s); %></td>
	</tr>
	<%
		}
	%>

</table>
</div>
<!--<div id="footer"></div>-->
</body>
</html>
