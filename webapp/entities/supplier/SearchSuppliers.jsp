<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.Supplier"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Supplier List</title>
<link href="css/header.css" rel="stylesheet" type="text/css" />
<link href="css/form.css" rel="stylesheet" type="text/css" />
<link href="css/item_table.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%
	List<Supplier> suppliers = (List<Supplier>) request.getAttribute("suppliers");
	String searchField = (String) request.getAttribute("searchField");
	
	if (searchField == null)
		searchField = "";
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
		<form id="form2" name="form2" method="post" action="/logout"><input
			name="logoutBtn" type="submit" class="logout" id="logoutBtn"
			value="Logout" /></form>
		</td>
	</tr>
	<tr>
		<td id="navigation"><a href="menu" target="_top" class="links">Main
		Menu</a> &gt;<em><strong>Supplier List </strong></em>&gt; <a
			href="supplier?supplier-action=new-supplier" target="_self"
			class="links">Add Supplier</a></td>
		<td>&nbsp;</td>
	</tr>
</table>
<div id="items_table">
<table width="100%" border="0" cellspacing="0">
	<tr>
		<td colspan="4" align="center" >
		<form id="form4" name="form4" method="post" action="supplier">
		<label for="searchField" class="align_right">Search:</label> <input
			type="text" name="searchField" id="searchField"  value="<%=searchField %>"/> <input
			name="supplier-action" type="hidden" value="search-suppliers" /> <input
			name="goBtn" type="submit" class="button" id="goBtn" value="GO" /></form>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td width="7%" class="tableheaders_forms">Action</td>
		<td width="32%" class="tableheaders_forms">Supplier Name</td>
		<td width="41%" class="tableheaders_forms">Supplier Address</td>
		<td width="20%" class="tableheaders_forms">Contact Person</td>
	</tr>

	<%
		int i = 0;
		for (Supplier s : suppliers) {
	%>
	<tr <%if (i % 2 == 0)
					out.print("class=\"tablerow_1\"");
			else
				out.print("class=\"tablerow_2\"");%>>
		<td align="center"
			<%if (i % 2 == 0)
					out.print("class=\"tablerow_1\"");%>>
		<form id="form1" name="form1" method="get" action="supplier"><input
			name="editBtn" type="submit" class="button2" id="editBtn"
			value="View&gt;&gt;" /> <input type="hidden" name="supplier-action"
			value="view-supplier" /> <input type="hidden" name="supplierID"
			value="<%=s.getId()%>" /></form>
		</td>
		<td align="center"><%=s.getSupplierName()%></td>
		<td align="center"><%=s.getAddress()%></td>
		<td align="center"><%=s.getContactPerson().getPerson().getName()%></td>
	</tr>
	<%
		i++;
		}
	%>

</table>
</div>
<!--<div id="footer"></div>-->
</body>
</html>

