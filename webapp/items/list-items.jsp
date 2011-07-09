<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Item List</title>
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
<link href="../css/item_table.css" rel="stylesheet" type="text/css" />
<script>
	function emphasize(div) {
		div.style.backgroundColor = "#dbb4c2";
	}
	function deEmphasize(div) {
		div.style.backgroundColor = "#FFFFFF";
	}
	function deEmphasizeEven(div) {
		div.style.backgroundColor = "#EEE0E5";
	}
</script>
</head>

<body>

	<%
		String query = (String) request.getAttribute("query");
		if (query == null)
			query = "";
		else if (query.equalsIgnoreCase(""))
			query = "";
	%>
	<div id="headerBkgrnd">
		<img src="../images/headerbar.png" width="100%" height="129" />
	</div>
	<div id="logo">
		<img src="../images/headerlogo.png" width="124" height="128" />
	</div>
	<div id="headerName">
		<img src="../images/headertext.png" width="452" height="44" />
	</div>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<table width="100%" border="0" cellspacing="0">
		<tr>
			<td width="32%">&nbsp;</td>
			<td width="68%"><form id="form2" name="form2" method="post"
					action="logout">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn"
						value="Logout" />
				</form>
			</td>
		</tr>
		<tr>
			<td id="navigation"><a href="../../menu" target="_top"
				class="links">Main Menu</a> &gt;<em><strong>Item List
				</strong> </em>&gt; <a href="/items?new=item" target="_self" class="links">Add
					Item</a>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="items_table">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td colspan="5" align="center"><form id="form4" name="form4"
						method="get" action="/items">
						<label for="searchField" class="align_right">Search:</label> <input
							type="text" name="q" id="searchField" value="<%=query%>" /> <input
							name="search" type="submit" class="button" id="goBtn" value="GO" />
					</form>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td width="50%" class="tableheaders_forms">Item Description</td>
				<td width="10%" class="tableheaders_forms">Unit</td>
				<td width="10%" class="tableheaders_forms">Price</td>
				<td width="15%" class="tableheaders_forms">Item Category</td>
				<td width="15%" class="tableheaders_forms">Item Status</td>
			</tr>
		</table>

		<%
			int i = 0;
		%>
		<c:forEach var="item" items="${items}" varStatus="loop">
			<a href="/items?id=${item.id}">
				<div onmouseover="emphasize(this)" onmouseout="deEmphasize(this)">
					<table width="100%" cellspacing="1">

						<tr
							<%if (i % 2 == 0)
					out.println("class=\"tablerow_1\"");
				else
					out.println("class=\"tablerow_2\"");%>>
							<td width="50%">${item.description}</td>
							<td width="10%">${item.unit}</td>
							<td width="10%">${item.price}</td>
							<td width="15%">${item.condition}</td>
							<td width="15%">${item.status}</td>
						</tr>
					</table>
				</div> </a>
			<%
				i++;
			%>
		</c:forEach>

	</div>
	<!--<div id="footer"></div>-->
</body>
</html>
