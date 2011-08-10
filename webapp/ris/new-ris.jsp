<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Fillup RIS</title>
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
		$("#ris-date").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
		$("#sai-date").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
		$("#requested-by-date").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
		$("#approved-by-date").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
		$("#issued-by-date").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
		$("#received-by-date").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
	});
</script>
</head>

<body>
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
					action="">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn"
						value="Logout" />
				</form></td>
		</tr>
		<tr>
			<td id="navigation"><a href="menu" target="_top" class="links">Main
					Menu</a> &gt; <a href="/ris" target="_top" class="links">RIS List</a>
				&gt; <em><strong>Fillup RIS</strong> </em><strong></strong></td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<form name="RISForm" method="post" action="/ris">
	<div id="items_table">

		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td colspan="2"><table width="100%" border="0" cellspacing="0"
						class="tableheaders_forms">
						<tr>
							<td><input type="checkbox" name="selectAllItems"
								id="selectAllItems" /></td>
							<td>Stock No.</td>
							<td>Unit</td>
							<td>Description</td>
							<td>Qty. Requested</td>
							<td>Qty. Issued</td>
							<td>Remarks</td>
						</tr>

						<c:forEach var="line" items="${form.lines}" varStatus="loop">
							<tr class="tablerow_1">
								<td width="2%" align="center"><input type="checkbox"
									name="checkedItems" id="items" value="${line.item.id}" /> <input
									type="hidden" name="items" value="${line.item.id}" /></td>
								<td width="8%">${line.item.stockNumber}</td>
								<td width="8%">${line.item.unit}</td>
								<td width="50%">${line.item.description}</td>
								<td width="9%"><input name="quantity-requested" type="text"
									class="required" id="qtyRequested" size="2" value="${line.quantityRequested}"/></td>
								<td width="9%"><input name="quantity-issued" type="text"
									class="required" id="qtyIssued" size="2" value="${line.quantityIssued}"/></td>
								<td width="14%"><input name="remarks" type="text" id="remarks" maxlength="200" value="${line.remarks}" /></td>
							</tr>
						</c:forEach>
					</table></td>
			</tr>
			<tr>
				<td width="50%" align="right" class="same_width"><br />
					
						<input name="addItems" type="submit" class="button"
							id="addItemBtn" value="Add Item&gt;&gt;" />
					 <br /><br /></td>
				<td align="left" class="same_width"><br />
						<input name="removeItems" type="submit" class="button"
							id="removeSelectedItems" value="Remove Item" />
					<br/><br/></td>
			</tr>
			<tr>
				<td colspan="2"><table width="25%" border="0" align="center"
						cellspacing="0">
						<tr>
							<td class="other_fields_label">Division/Office:</td>
							<td class="right_side_table"><select name="division-office"
								id="division-office" class="required_menulist">
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
							<td class="other_fields_label">Responsibility Center Code.:</td>
							<td class="right_side_table"><input name="rc-code"
								type="text" id="respCenterCode" maxlength="80"
								value="${form.rcCode}" /></td>
						</tr>
						<tr>
							<td class="other_fields_label">RIS No.:</td>
							<td class="right_side_table"><input name="ris-number" type="text"
								class="required" id="risNo" maxlength="45"
								value="${form.risNumber}" /></td>
						</tr>
						<tr>
							<td class="other_fields_label">Date:</td>
							<td class="right_side_table"><input name="ris-date"
								type="text" class="required" id="ris-date"
								value="${form.risDate}" /></td>
						</tr>
						<tr>
							<td class="other_fields_label">SAI No.:</td>
							<td class="right_side_table"><input name="sai-number" type="text"
								id="saiNo" maxlength="80" value="${form.saiNumber}" /></td>
						</tr>
						<tr>
							<td class="other_fields_label">Date:</td>
							<td class="right_side_table"><input type="text"
								name="sai-date" id="sai-date" value="${form.saiDate}" /></td>
						</tr>
						<tr>
							<td class="other_fields_label">Purpose:</td>
							<td class="right_side_table"><input name="purpose"
								type="text" class="required" id="purpose" maxlength="200"
								value="${form.purpose}" /></td>
						</tr>
						<tr>
							<td class="other_fields_label">Requested by:</td>
							<td class="right_side_table"><select name="requested-by"
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
							</select>
							</td>
						</tr>
						<tr>
							<td class="other_fields_label">Date:</td>
							<td class="right_side_table"><input name="requested-by-date"
								type="text" class="required" id="requested-by-date" value="${form.requestedByDate}"/>
							</td>
						</tr>
						<tr>
							<td class="other_fields_label">Approved by:</td>
							<td class="right_side_table"><select name="approved-by"
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
							</select>
							</td>
						</tr>
						<tr>
							<td class="other_fields_label">Date:</td>
							<td class="right_side_table"><input name="approved-by-date"
								type="text" class="required" id="approved-by-date" value="${form.approvedByDate}"/>
							</td>
						</tr>
						<tr>
							<td class="other_fields_label">Issued by:</td>
							<td class="right_side_table"><select name="issued-by"
								id="approvedby" class="required_menulist">
									<c:forEach var="employee" items="${employees}">
										<c:choose>
											<c:when test="${employee.id eq form.issuedBy.id}">
												<option selected="selected" value="${employee.id}">${employee.person.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${employee.id}">${employee.person.name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td class="other_fields_label">Date:</td>
							<td class="right_side_table"><input name="issued-by-date"
								type="text" class="required" id="issued-by-date" value="${form.issuedByDate}"/>
							</td>
						</tr>
						<tr>
							<td class="other_fields_label">Received by:</td>
							<td class="right_side_table"><select name="received-by"
								id="approvedby2" class="required_menulist">
									<c:forEach var="employee" items="${employees}">
										<c:choose>
											<c:when test="${employee.id eq form.receivedBy.id}">
												<option selected="selected" value="${employee.id}">${employee.person.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${employee.id}">${employee.person.name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td class="other_fields_label">Date:</td>
							<td class="right_side_table"><input name="received-by-date" type="text"
								class="required" id="received-by-date" value="${form.receivedByDate}"/>
							</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><br /> <input name="saveForm"
					type="submit" class="button" value="SUBMIT Form" /></td>
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
