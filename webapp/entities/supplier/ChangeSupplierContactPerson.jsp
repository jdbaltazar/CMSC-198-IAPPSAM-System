<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.Supplier"%>
<%@page import="com.iappsam.Employee"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Change Supplier  Person</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>

<%
	Supplier supplier = (Supplier) request.getAttribute("supplier");
	if (supplier == null)
		supplier = new Supplier();
	List<Employee> employees = (List<Employee>) request.getAttribute("employees");
%>
<div id="headerBkgrnd"><img src="../../images/headerbar.png"
	width="100%" height="129" /></div>
<div id="logo"><img src="../../images/headerlogo.png" width="124"
	height="128" /></div>
<div id="headerName"><img src="../../images/headertext.png" width="452"
	height="44" /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="100%" border="0" cellspacing="0">
	<tr>
		<td width="46%">&nbsp;</td>
		<td width="54%">
		<form id="form2" name="form2" method="post" action="/logout"><input
			name="logoutBtn" type="submit" class="logout" id="logoutBtn"
			value="Logout" /></form>
		</td>
	</tr>
	<tr>
		<td id="navigation"><a href="menu" target="_top" class="links">Main
		Menu</a> &gt; <a href="supplier?supplier-action=view-suppliers"
			target="_top" class="links">Supplier List</a> &gt; <a
			href="supplier?supplier-action=view-supplier&supplierID=<%=supplier.getId()%>"
			target="_top" class="links">View Supplier</a> &gt;<em><strong>Change
		Contact Person</strong></em></td>
		<td>&nbsp;</td>
	</tr>
</table>
<div id="form_table">
<form id="form1" name="form1" method="post" action="supplier">
<table width="100%" border="0" cellspacing="0" id="table">
	<tr>
		<td class="header_rows">
		<div class="header_1">Supplier Information</div>
		</td>
	</tr>
	<tr>
		<td>
		<table width="100%" cellspacing="9" border="0">
			<tr>
				<td class="align_right">Contact Person:</td>
				<td><select name="employeeID" class="required_menulist"
					id="employeeID">
					<%
						for (Employee e : employees) {
					%>
					<option value="<%="" + e.getId()%>"
					
					<%
					if(supplier.getContactPerson()!=null){
						if(supplier.getContactPerson().getId()==e.getId())
							out.print("selected");
					}
					%>
					
					><%=e.getPerson().getName() + ": " + e.getDesignation()%></option>
					<%
						}
					%>
			  </select></td>
			</tr>
			<tr>
				<td class="align_right">Supplier Name:</td>
				<td><input name="supplierName" type="text" class="required" id="supplierName"
					value="<%=supplier.getSupplierName()%>"
					<%if (supplier.getSupplierName() != null) {%> <%}%> /></td>
			</tr>
			<tr>
				<td class="align_right">Supplier Address:</td>
				<td><input name="address" class="required" id="address"
					value="<%=supplier.getAddress()%>"
					<%if (supplier.getAddress() != null) {%> <%}%> /></td>
			</tr>
			<tr>
				<td class="align_right">TIN:</td>
				<td><input name="tin" id="tin"
					<%if (supplier.getTin() != null) {%>
					value="<%=supplier.getTin()%>" <%}%> /></td>
			</tr>
			<tr>
				<td class="align_right">&nbsp;</td>
				<td><input name="updateBtn" type="submit" class="button"
					id="updateBtn" value="UPDATE" /> <input name="supplier-action"
					type="hidden" value="save-changed-supplier-cp" />
					<input name="supplierID"
					type="hidden" value="<%=supplier.getId() %>" />
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
