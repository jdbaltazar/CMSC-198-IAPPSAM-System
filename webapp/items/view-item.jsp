<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href=".favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: View Item</title>
<link href="../style.css" rel="stylesheet" type="text/css" />
<link href="../form.css" rel="stylesheet" type="text/css" />
<link href="../items/view-item.css" rel="stylesheet" type="text/css" />
<link href="../jquery/css/jquery-ui-1.8.13.custom.css" rel="stylesheet"
	type="text/css" />
<script src="../jquery/jquery-1.5.1.min.js"></script>
<script src="../jquery/ui/jquery.ui.core.js"></script>
<script src="../jquery/ui/jquery.ui.datepicker.js"></script>
<script src="../jquery/ui/jquery.ui.widget.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
	});
</script>
</head>

<body>
<jsp:include page="/logo.jsp" />
<jsp:include page="/navigation.jsp" />

<!-- Breadcrumbs -->
<div class="Breadcrumbs"><a href="/menu">Menu</a> > <a
	href="/items">Items</a> > <a href="/items?id=${item.id}">View Item</a>
</div>

<div id="tableheader_2">Item Information</div>


<!--<div id="headerBkgrnd"><img src="../images/headerbar.png" width="100%" height="129" /></div>
<div id="logo"><img src="../images/headerlogo.png" width="124" height="128" /></div>
<div id="headerName"><img src="../images/headertext.png" width="452" height="44" /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td width="32%">&nbsp;</td>
    <td width="68%"><form id="form2" name="form2" method="post" action="">
      <input name="logoutBtn" type="submit" class="logout" id="logoutBtn" value="Logout" />
    </form></td>
  </tr>
  <tr>
    <td id="navigation"><a href="/menu" target="_top" class="links">Main Menu</a> &gt; <a href="/items" target="_top" class="links">Items List</a> &gt; <em><strong>Add Item</strong></em><strong></strong></td>
    <td>&nbsp;</td>
  </tr>
</table>
<div id="form_table">
	<form action="/items" method="post"  name="form">
  <table width="100%" frame="box" cellspacing="0" id="table">
    <tr>
      <td class="header_rows"><div class="header_1">Item Information</div></td>
    </tr>
    <tr>
-->


<div id="form_table">
<form id="form1" name="form1" method="post" action=""><input
	type="hidden" name="id" value="${item.id}" />
<table width="100%" cellspacing="7" id="table">
	<tr>
		<td class="align_right">Description:</td>
		<td><input type="text" name="description" id="description"
			class="required" value="${item.description}" /></td>
	</tr>
	<tr>
		<td class="align_right">Unit:</td>
		<td><select name="unit" class="required" id="unit">
			<option selected="selected">${item.unit}</option>
			<c:forEach var="unit" items="${units}">
				<c:if test="${unit ne item.unit}">
					<option>${unit}</option>
				</c:if>
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td class="align_right">Item Category:</td>
		<td><select name="itemCategory" class="required" id="category">
			<option selected="selected">${item.category}</option>
			<c:forEach var="category" items="${categories}">
				<c:if test="${category ne item.category}">
					<option>${category}</option>
				</c:if>
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td class="align_right">Price:</td>
		<td><input type="text" name="price" id="price"
			value="${item.price}" /></td>
	</tr>
	<tr>
		<td class="align_right">Date Acquired:</td>
		<td><input type="text" name="date" id="datepicker"
			value="${item.dateAcquired}" /></td>
	</tr>
	<tr>
		<td class="align_right">Stock Number:</td>
		<td><input type="text" name="stockNum" id="stockNum"
			value="${item.stockNumber}" /></td>
	</tr>
	<tr>
		<td class="align_right">Inventory Item Number:</td>
		<td><input type="text" name="inventoryItemNum"
			id="inventoryItemNum" value="${item.inventoryItemNumber}" /></td>
	</tr>
	<tr>
		<td class="align_right">Property Number:</td>
		<td><input type="text" name="propertyNumber" id="propertyNumber"
			value="${item.propertyNumber}" /></td>
	</tr>
	<tr>
		<td class="align_right">Item Status:</td>
		<td><select name="itemStatus" class="required" id="itemStatus">
			<option selected="selected">${item.status}</option>
			<c:forEach var="status" items="${statuses}">
				<c:if test="${status ne item.status}">
					<option>${status}</option>
				</c:if>
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td class="align_right">Item Condition:</td>
		<td><select name="itemCondition" class="required" id="condition">
			<option selected="selected">${item.condition}</option>
			<c:forEach var="condition" items="${conditions}">
				<c:if test="${condition ne item.condition}">
					<option>${condition}</option>
				</c:if>
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td colspan="2" valign="middle" id="Update"><input name="addBtn"
			type="submit" class="button" id="addBtn" value="Update" /></td>
	</tr>
</table>
</form>
</div>

<jsp:include page="/copyright.jsp" />
</body>
</html>
