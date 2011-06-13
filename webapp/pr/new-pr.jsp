<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<form id="form1" name="form1" method="post" action="/pr">
	<div id="PageHeader" class="Form"> 
		<!-- Division Office -->
		<label for="deptAndSection" class="labels">Department &amp; Section: </label>
		<select name="deptAndSection" id="deptAndSection" style="width: 200px;">
			<c:forEach var="office" items="${offices}">
				<c:choose>
					<c:when test="${office.id eq form.divisionOffice.id}">
						<option value="${office.id}" selected="selected">${office.divisionName}, ${office.officeName}</option>
					</c:when>
					<c:otherwise>
						<option value="${office.id}">${office.divisionName}, ${office.officeName}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<br />
		<!-- PR -->
		<label for="prNumber" class="labels">PR.No.:</label>
		<input type="text" name="prNumber" id="PrNumber" size="15" maxlength="15" value="${form.prNumber}"/>
		<label for="prdate" class="labels">Date:</label>
		<input type="text" name="prDate" id="prDate" value="${form.prDate}"/>
		<br />
		<!-- SAI -->
		<label for="saiNumber" class="labels">SAI No.:</label>
		<input name="saiNumber" type="text" id="saiNumber" size="15" maxlength="15" value="${form.saiNumber}"/>
		<label for="saiDate" class="labels">Date:</label>
		<input type="text" name="saiDate" id="saiDate" value="${form.saiDate}" />
		<br />
		<!-- ALOBS -->
		<label for="alobsNumber" class="labels">ALOBS No.:</label>
		<input name="alobsNumber" type="text" id="alobsNumber" size="15" maxlength="15" value="${form.alobsNumber}" />
		<label for="alobsDate" class="labels">Date:</label>
		<input name="alobsDate" type="text" id="alobsDate" value="${form.alobsDate}" />
	</div>
	<div id="line">
		<table width="100%" border="0" cellspacing="0" id="TableHeader">
			<tr class="ColumnHeader">
				<td width="4%">&nbsp;</td>
				<td width="5%">Quantity</td>
				<td width="9%">Unit of Issue</td>
				<td width="42%">Item Description</td>
				<td width="22%">Stock No.</td>
				<td width="18%">Estimated Unit Cost</td>
			</tr>
			<c:forEach var="line" items="${form.lines}" varStatus="loop">
				<tr ><!-- class="tablerow_1" -->
					<td width="4%" ><input type="checkbox" name="checkedItems" id="items" value="${line.item.id}"/>
						<input type="hidden" name="items" value="${line.item.id}"/></td>
					<td width="5%" ><input name="quantity" type="text" class="textfields_1" id="Quantity" size="4" value="${line.quantity}"/></td>
					<td width="9%">${line.item.unit}</td>
					<td width="42%">${line.item.description}</td>
					<td width="22%">${line.item.stockNumber}</td>
					<td width="18%"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="LineAction" class="Form">
		<input type="submit" name="addItems" id="additem" value="Add Items" />
		<input type="submit" name="removeItems" id="removeItem" value="Remove Items" />
	</div>
	<div id="PageFooter" class="Form">
		<label for="purpose" class="labels">Purpose:</label>
		<textarea name="purpose" id="purpose" >${form.purpose}</textarea>
		<br />
		<label for="requestedBy" class="labels">Requested by:</label>
		<select name="requestedBy" id="requestedBy">
			<c:forEach var="employee" items="${employees}">
				<c:choose>
					<c:when test="${employee.id eq form.requestedBy.id}">
						<option selected="selected" value="${employee.id}">${employee.person.name}</option>
					</c:when>
					<c:otherwise>
						<option value="${employee.id}">${employee.person.name}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<label for="approvedby" class="labels">Approved by:</label>
		<select name="approvedby" id="approvedby">
			<c:forEach var="employee" items="${employees}">
				<c:choose>
					<c:when test="${employee.id eq form.approvedBy.id}">
						<option selected="selected" value="${employee.id}">${employee.person.name}</option>
					</c:when>
					<c:otherwise>
						<option value="${employee.id}">${employee.person.name}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
	</div>
	<div>Save</div>
</form>
<jsp:include page="../copyright.jsp" />
</body>
</html>
