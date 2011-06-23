<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.ContactType"%>
<%@page import="com.iappsam.Contact"%>
<%@page import="java.util.Set"%>
<%@page import="com.iappsam.Supplier"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Add Supplier</title>
<link href="css/header.css" rel="stylesheet" type="text/css" />
<link href="css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%
	Supplier supplier = (Supplier) request.getAttribute("supplier");
	if (supplier == null)
		supplier = new Supplier();
%>
<div id="headerBkgrnd"><img src="images/headerbar.png"
	width="100%" height="129" /></div>
<div id="logo"><img src="images/headerlogo.png" width="124"
	height="128" /></div>
<div id="headerName"><img src="images/headertext.png" width="452"
	height="44" /></div>
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
		<td id="navigation"><a href="menu" target="_top" class="links">Main
		Menu</a> &gt; <a href="supplier?supplier-action=view-suppliers"
			target="_top" class="links">Supplier List</a> &gt; <em><strong>Add
		Supplier</strong></em></td>
		<td>&nbsp;</td>
	</tr>
</table>
<div id="form_table">
<form id="supplierForm" name="supplierForm" method="post"
	action="supplier?supplier-action=save-supplier">
<table width="100%" border="0" cellspacing="0" id="table">
	<tr>
		<td align="right" class="bkgrnd_white"><a
			href="supplier?supplier-action=new-supplier-for-existing"
			target="_self" class="linkBtn">Add Supplier to Existing Contact
		Person</a></td>
	</tr>
	<tr>
		<td class="bkgrnd_white">&nbsp;</td>
	</tr>

	<tr class="header_rows">
		<td>
		<div class="header_1">Supplier Information</div>
		</td>
	</tr>
	<tr>
		<td>
		<table width="100%" cellspacing="9" border="0">
			<tr>
				<td class="align_right">*Supplier Name:</td>
				<td><input name="supplierName" type="text" class="required" id="supplierName"
					value="<%=supplier.getSupplierName()%>" maxlength="80"
					<%if (supplier.getSupplierName() != null) {%> <%}%>></input></td>
			</tr>
			<tr>
				<td class="align_right">*Supplier Address:</td>
				<td><input name="supplierAddress" type="text" class="required"
					id="supplierAddress"
					value="<%=supplier.getAddress()%>" maxlength="100" <%if (supplier.getAddress() != null) {%> <%}%>></input></td>
			</tr>
			<tr>
				<td class="align_right">TIN:</td>
				<td><input name="tin" type="text" id="tin" value="<%=supplier.getTin()%>" maxlength="45"
					<%if (supplier.getTin() != null) {%>
					<%}%>></input></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr class="header_rows">
		<td>
		<div class="header_1">Contact Person Information</div>
		</td>
	</tr>
	<tr>
		<td>
		<table width="100%" border="0" cellspacing="9">
			<tr>
				<td class="align_right">Title:</td>
				<td><input name="title" type="text" id="title"
					value="<%=supplier.getContactPerson().getPerson().getTitle()%>" maxlength="10"
					<%if (supplier.getContactPerson() != null&&supplier.getContactPerson().getPerson().getTitle()!=null) {%><%}%>></input></td>
			</tr>
			<tr>
				<td class="align_right">*Name:</td>
				<td><input name="name" type="text" class="required" id="name"
					value="<%=supplier.getContactPerson().getPerson().getName()%>" maxlength="80"
					<%if (supplier.getContactPerson() != null&&supplier.getContactPerson().getPerson().getName() != null) {%>
					<%}%>></input></td>
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
			<tr>
				<td class="align_right">*Designation:</td>
				<td><input name="designation" type="text" class="required" id="designation"
					value="<%=supplier.getContactPerson().getDesignation()%>" maxlength="45"
					<%if (supplier.getContactPerson() != null&&supplier.getContactPerson().getDesignation() != null) {%> <%}%>></input></td>
			</tr>
			<tr>
				<td class="align_right">Employee Number:</td>
				<td><input name="employeeNumber" type="text"
					id="employeeNumber"
					value="<%=supplier.getContactPerson().getEmployeeNumber()%>" maxlength="45"
					<%if (supplier.getContactPerson() != null&&supplier.getContactPerson().getEmployeeNumber() != null) {%> <%}%>></input></td>
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
		<table width="100%" border="0" cellspacing="9">

			<%
				Set<Contact> contacts = null;
				if (supplier.getContactPerson() != null)
					contacts = supplier.getContactPerson().getPerson().getContacts();
				String mobile = "", landline = "", email = "";
				if (contacts != null)
					for (Contact c : contacts) {
						if (c.getType().equals(ContactType.MOBILE))
							mobile = c.getData();
						if (c.getType().equals(ContactType.LANDLINE))
							landline = c.getData();
						if (c.getType().equals(ContactType.EMAIL))
							email = c.getData();
					}
			%>
			<tr>
				<td class="align_right">Mobile Number:</td>
				<td><input name="mobileNumber" type="text" id="mobileNumber"
					value="<%=mobile%>" maxlength="45" ></input></td>
			</tr>
			<tr>
				<td class="align_right">Landline:</td>
				<td><input name="landline" type="text" id="landline"
					value="<%=mobile%>" maxlength="45" /></td>
			</tr>
			<tr>
				<td class="align_right">E-mail Address:</td>
				<td><input name="emailad" type="text" id="emailad"
					value="<%=email%>" maxlength="45" /></td>
			</tr>
			<tr>
				<td class="align_right">&nbsp;</td>
				<td><input name="addBtn" type="submit" class="button"
					id="addBtn" value="ADD" /></td>
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

