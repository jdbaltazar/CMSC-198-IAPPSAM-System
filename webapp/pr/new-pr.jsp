<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Fillup PR</title>
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
<link href="../css/item_table.css" rel="stylesheet" type="text/css" />
<link href="../jquery/css/jquery-ui-1.8.13.custom.css" rel="stylesheet"
	type="text/css" />
<script src="../jquery/jquery-1.5.1.min.js"></script>
<script src="../jquery/ui/jquery.ui.core.js"></script>
<script src="../jquery/ui/jquery.ui.datepicker.js"></script>
<script src="../jquery/ui/jquery.ui.widget.js"></script>
<script>
	$(function() {
		$("#prDate").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
		$("#saiDate").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
		$("#alobsDate").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
	});
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
		<form id="form2" name="form2" method="post" action="../logout"><input
			name="logoutBtn" type="submit" class="logout" id="logoutBtn"
			value="Logout" /></form>
		</td>
	</tr>
	<tr>
		<td id="navigation"><a href="/menu" target="_top" class="links">Main
		Menu</a> &gt; <a href="/pr" target="_top" class="links">PR List</a> &gt; <em><strong>Fillup
		Purchase Request</strong></em><strong></strong></td>
		<td>&nbsp;</td>
	</tr>
</table>
<form name="PRForm" method="post" action="/pr">
<div id="items_table">

<table width="100%" border="0" cellspacing="0">
	<tr>
		<td colspan="2">
		<table width="100%" border="0" cellspacing="0">
			<tr class="tableheaders_forms">
				<td><input type="checkbox" name="selectAllItems"
					id="selectAllItems" /></td>
				<td>Quantity</td>
				<td>Unit of Issue</td>
				<td>Item Description</td>
				<td>Stock No.</td>
				<td>Estimated Unit Cost</td>
				<td>Estimated Cost</td>
			</tr>
			<c:forEach var="line" items="${form.lines}" varStatus="loop">
				<tr class="tablerow_1">
					<td width="4%"><input type="checkbox" name="checkedItems"
						id="items" value="${line.item.id}" /> <input type="hidden"
						name="items" value="${line.item.id}" /></td>
					<td width="5%"><input name="quantity" type="text"
						class="required" id="Quantity"
						value="${line.quantity}" size="2" maxlength="11" /></td>
					<td width="9%">${line.item.unit}</td>
					<td width="42%">${line.item.description}</td>
					<td width="22%">${line.item.stockNumber}</td>
					<td width="18%">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</c:forEach>
		</table>
		</td>
	</tr>
	<tr>
		<td width="50%" align="right" class="same_width"><br />
		<input type="submit" name="addItems" id="additem" class="button"
			value="Add Item&gt;&gt;" /> <br />
		</td>
		<td align="left" class="same_width">
		<p><br />
		<input type="submit" name="removeItems" id="removeItem" class="button"
			value="Remove Item" /></p>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<table width="25%" border="0" align="center" cellspacing="0">
			<tr>
				<td class="other_fields_label">Department/Section:</td>
				<td class="right_side_table"><select name="deptAndSection"
					id="deptAndSection" class="required_menulist">
					<c:forEach var="office" items="${offices}">
						<c:choose>
							<c:when test="${office.id eq form.divisionOffice.id}">
								<option value="${office.id}" selected="selected">${office.divisionName},
								${office.officeName}</option>
							</c:when>
							<c:otherwise>
								<option value="${office.id}">${office.divisionName},
								${office.officeName}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			  </select></td>
			</tr>
			<tr>
				<td class="other_fields_label">PR No.:</td>
				<td class="right_side_table"><input type="text" name="prNumber"
					id="PrNumber" maxlength="45" value="${form.prNumber}" /></td>
			</tr>
			<tr>
				<td class="other_fields_label">Date:</td>
				<td class="right_side_table"><input type="text" name="prDate"
					id="prDate" value="${form.prDate}" /></td>
			</tr>
			<tr>

				<td class="other_fields_label">SAI No.:</td>
				<td class="right_side_table"><input name="saiNumber"
					type="text" id="saiNumber" maxlength="45" value="${form.saiNumber}" /></td>
			</tr>
			<tr>
				<td class="other_fields_label">Date:</td>
				<td class="right_side_table"><input type="text" name="saiDate"
					id="saiDate" value="${form.saiDate}" /></td>
			</tr>
			<tr>

				<td class="other_fields_label">ALOBS No.:</td>
				<td class="right_side_table"><input name="alobsNumber"
					type="text" id="alobsNumber" maxlength="45"
					value="${form.alobsNumber}" /></td>
			</tr>
			<tr>
				<td class="other_fields_label">Date:</td>
				<td class="right_side_table"><input name="alobsDate"
					type="text" id="alobsDate" value="${form.alobsDate}" /></td>
			</tr>
            <tr>
            	<td class="other_fields_label">Purpose:</td>
            	<td class="right_side_table"><input name="purpose" class="required" id="purpose" value="${form.purpose}" maxlength="200"/></td>
            </tr>
			<tr>
				<td class="other_fields_label">Requested by:</td>
				<td class="right_side_table"><select name="requestedBy"
					id="requestedBy" class="required_menulist">
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
			  </select></td>
			</tr>
			<tr>
				<td class="other_fields_label">Approved by:</td>
				<td class="right_side_table"><select name="approvedby"
					id="approvedby" class="required_menulist">
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
			  </select></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><br />
		<input type="submit" name="saveForm" class="button"
			value="SUBMIT Form" /></td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
</table>

</div>
</form>


<!--<div id="footer"></div>-->
</body>
</html>
