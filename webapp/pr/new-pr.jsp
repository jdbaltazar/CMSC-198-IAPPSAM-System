<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: New Purchase Request</title>
<link href="../pr/pr.css" rel="stylesheet" type="text/css" />
<link href="../style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="/logo.jsp" />
<jsp:include page="/navigation.jsp" />

<!-- Breadcrubms should be here --->
<div class="Breadcrumbs"> <a href="/menu">Menu</a> > <a href="/pr">Purchase Request List</a> > <a href="/pr?new=pr">New Purchase Request</a> </div>
<div id="Title" class="Form"></div>
<div id="PageHeader" class="Form">
	<form id="form1" name="form1" method="post" action="">
		<label for="deptAndSection" class="labels">Department &amp; Section: </label>
		<select name="deptAndSection" id="deptAndSection" style="width: 200px;">
			<c:forEach var="office" items="${offices}">
				<option value="${office.id}">${office.divisionName}, ${office.officeName}</option>
			</c:forEach>
		</select>
		<br />
		<!-- PR -->
		<label for="PrNumber" class="labels">PR.No.:</label>
		<input type="text" name="PrNumber" id="PrNumber" size="15" maxlength="15" />
		<label for="prdate" class="labels">Date:</label>
		<br/>
		<!-- SAI -->
		<label for="SaiNumber" class="labels">SAI No.:</label>
		<input name="SaiNumber" type="text" id="SaiNumber" size="15" maxlength="15" />
		<label for="SaiDate" class="labels">Date:</label>
		<input type="text" name="SaiDate" id="SaiDate"/>
		<br/>
		<!-- ALOBS -->
		<label for="alobsNumber" class="labels">ALOBS No.:</label>
		<input type="text" id="alobsNumber" size="15" maxlength="15" />
		<label for="alobsdate" class="labels">Date:</label>
		<input id="alobsdate" type="text"/>
	</form>
</div>
<div id="line" class="Form">
	<table width="100%" border="0" cellspacing="0" id="TableHeader">
		<tr class="ColumnHeader">
			<td width="7%">Quantity</td>
			<td width="9%">Unit of Issue</td>
			<td width="34%">Item Description</td>
			<td width="13%">Stock No.</td>
			<td width="13%">Estimated Unit<br />
				Cost</td>
		</tr>
		<tr class="tablerow_1">
			<td width="7%" align="center"><input name="quantity_1" type="text" class="textfields_1" id="quantity_1" size="4" /></td>
			<td width="9%">&nbsp;</td>
			<td width="34%">&nbsp;</td>
			<td width="13%">&nbsp;</td>
			<td width="13%" align="center"><input name="estUnitCost" type="text" class="textfields_1" id="estUnitCost" size="8" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr class="tablerow_1">
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>
</div>
<div id="LineAction" class="Form"> <a href="?add=item">Add Item</a> </div>
<div id="PageFooter" class="Form">
	<label for="purpose" class="labels">Purpose:</label>
	<textarea name="purpose" id="purpose"></textarea>
	<br/>
	<label for="requestedBy" class="labels">Requested by:</label>
	<select name="requestedBy" id="requestedBy">
		<c:forEach var="employee" items="${employees}">
			<option value="${employee.id}">${employee.person.name}</option>
		</c:forEach>
	</select>
	<label for="approvedby" class="labels">Approved by:</label>
	<select name="approvedby" id="approvedby">
		<c:forEach var="employee" items="${employees}">
			<option value="${employee.id}">${employee.person.name}</option>
		</c:forEach>
	</select>
</div>
<div>Save</div>
<jsp:include page="../copyright.jsp" />
</body>
</html>
