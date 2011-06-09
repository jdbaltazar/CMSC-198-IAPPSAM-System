<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.managers.PersonManager"%>
<%@page import="com.iappsam.managers.sessions.PersonManagerSession"%>
<%@page import="com.iappsam.entities.Employee"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
.headers {
	background-color: #7B1113;
	color: white;
	font-family: Lucida Grande;
	font-size: 14px;
	font-weight: bold;
	text-align: center;
}

.button {
	font-size: 14px;
	font-family: Lucida Grande;
	background-color: white;
	color: #7B1113;
	border-left: 1px solid lightgray;
	border-right: 1px solid lightgray;
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

.button:hover {
	font-weight: bold;
	color: #060;
	/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
	border-right: 1px solid #7B1113;
	border-top: 1px solid #7B1113;
	border-bottom: 1px solid #7B1113;
}

#apDiv1 {
	position: absolute;
	width: 956px;
	height: 230px;
	z-index: 1;
	left: 8px;
	top: 98px;
}
</style>
</head>
<%
	String personID = request.getParameter("personID");
	PersonManager pManager = new PersonManagerSession();

	List<Employee> empList = pManager.getEmployeeByPerson(Integer.parseInt(personID));

	System.out.println(personID);
	if (empList == null) {
		System.out.println("heyo");
	}
%>
<body>
<table width="100%" border="0">
	<tr>
		<td width="17%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">Work
				Information</td>
			</tr>
		</table>
		</td>
		<td width="79%">&nbsp;</td>
		<td width="4%">
		<form id="form15" name="form15" method="get"
			action="ViewAccount.do"><input name="backBtn" type="submit"
			class="button" id="backBtn" value="Back" /> <input name="userName"
			type="hidden" value="<%=request.getParameter("username")%>"></input></form>
		</td>
	</tr>
</table>
<p>&nbsp;</p>
<div id="apDiv1" style="width: 100%;">
<table width="100%" border="1">
	<tr class="headers">
		<td width="27%">Designation</td>
		<td width="14%">Employee No.</td>
		<td width="25%">Division</td>
		<td width="22%">Office</td>
		<td width="12%">Action</td>
	</tr>
	<%
		for (int i = 0; i < empList.size(); i++) {
	%>
	<tr>
		<td>
		<div align="center"><%=empList.get(i).getDesignation()%></div>
		</td>
		<td>
		<div align="center"><%=empList.get(i).getEmployeeNumber()%></div>
		</td>
		<td>
		<div align="center"><%=empList.get(i).getDivisionOffice().getDivisionName()%></div>
		</td>
		<td>
		<div align="center">
		<%
			if (empList.get(i).getDivisionOffice().getOfficeName() != null)
					out.print(empList.get(i).getDivisionOffice().getOfficeName());
		%>
		</div>
		</td>
		<td>
		<form id="form1" name="form1" method="post" action="">
		<div align="center">
		<blockquote>
		<blockquote><input name="employee" type="hidden"
			value="<%=empList.get(i).getId()%>" /> <input name="button"
			type="submit" class="button" id="button" value="Edit" /></blockquote>
		</blockquote>
		</div>
		</form>
		</td>
		<%
			}
		%>
	</tr>
</table>
<form id="form2" name="form2" method="post" action="">
<p align="center"><input name="button2" type="submit" class="button"
	id="button2" value="Add New Work Information" /></p>
</form>
</div>
</body>
</html>
