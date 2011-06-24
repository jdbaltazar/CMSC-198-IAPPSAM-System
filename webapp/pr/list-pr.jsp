<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::PR List</title>
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
		<td id="navigation"><a href="/menu" class="links">Main Menu</a>
		&gt;<em><strong>PR List </strong></em>&gt; <a href="/pr?new=pr"
			class="links">Fillup PR Form</a></td>
		<td>&nbsp;</td>
	</tr>
</table>
<div id="items_table">
<table width="100%" border="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center">
		<form id="form1" name="form1" method="post" action=""><label
			for="searchField" class="align_right">Search:</label> <input
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
		<td width="14%" class="tableheaders_forms">P.R. Number</td>
		<td width="47%" class="tableheaders_forms">Requested by</td>
		<td width="39%" class="tableheaders_forms">Prepared by</td>
	</tr>
</table>

<c:forEach var="form" items="${forms}">
	<a href="/pr?id=${form.id}">
	<div onmouseover="emphasize(this)" onmouseout="deEmphasize(this)">
	<table width="100%" style="table-layout: fixed">
		<tr class="tablerow_1">
			<td width="14%">${form.prNumber}</td>
			<td width="47%">${form.requestedBy.person.name}</td>
			<td width="39%">${form.approvedBy.person.name}</td>
		</tr>
	</table>
	</div>
	</a>
</c:forEach> 

</div>
<!--<div id="footer"></div>-->
</body>
</html>
