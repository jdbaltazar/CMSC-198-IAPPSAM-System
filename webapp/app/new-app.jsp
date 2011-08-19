<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Fillup APP</title>
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
		$("#date-scheduled").datepicker({
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
					action="/logout">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn"
						value="Logout" />
				</form>
			</td>
		</tr>
		<tr>
			<td id="navigation"><a href="../menu" target="_top"
				class="links">Main Menu</a> &gt; <a href="/app" target="_top"
				class="links">APP List</a> &gt; <em><strong>Fillup APP</strong>
			</em><strong></strong>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<form name="APPForm" method="post" action="/app">
	<div id="items_table">

		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td colspan="2"><table width="100%" border="0" cellspacing="0">
						<tr class="tableheaders_forms">
							<td rowspan="2">
									
							</td>
							<td rowspan="2">Stock No.</td>
							<td rowspan="2">ARTICLES &amp; SPECIFICATIONS</td>
							<td rowspan="2">Unit</td>
							<td rowspan="2">Qty</td>
							<td rowspan="2">Price</td>
							<td colspan="2">1st</td>
							<td colspan="2">2nd</td>
							<td colspan="2">3rd</td>
							<td colspan="2">4th</td>
							<td rowspan="2">Amount</td>
						</tr>

						<tr class="tableheaders_forms">
							<td>Qty.</td>
							<td>Amount</td>
							<td>Qty.</td>
							<td>Amount</td>
							<td>Qty.</td>
							<td>Amount</td>
							<td>Qty.</td>
							<td>Amount</td>
						</tr>

						<c:forEach var="line" items="${form.lines}" varStatus="loop">
							<tr class="tablerow_1">
								<td><input type="checkbox" name="checkedItems" id="items"
									value="${line.item.id}" /> <input type="hidden" name="items"
									value="${line.item.id}" />
								</td>
								<td>${line.item.stockNumber}</td>
								<td>${line.item.description}</td>
								<td>${line.item.unit}</td>
								<td>&nbsp;</td>
								<td>${line.item.price}</td>
								<td><input name="q1" type="text"
									class="required" id="qty1" size="2" maxlength="8" />
							  </td>
								<td>&nbsp;</td>
								<td><input name="q2" type="text"
									class="required" id="qty2" size="2" maxlength="8" />
							  </td>
								<td>&nbsp;</td>
								<td><input name="q3" type="text"
									class="required" id="qty3" size="2" maxlength="8" />
							  </td>
								<td>&nbsp;</td>
								<td><input name="q4" type="text"
									class="required" id="qty4" size="2" maxlength="8" />
							  </td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
						</c:forEach>

					</table>
				</td>
			</tr>
			<tr>
				<td width="50%" align="right" class="same_width"><br /> <input
					name="addItems" type="submit" class="button" id="addItem"
					value="Add Item>>" /> <br /> <br />
				</td>
				<td class="same_width"><br /> <input name="removeItems"
					type="submit" class="button" id="removeItem" value="Remove Item" />
					<br /> <br />
				</td>
			</tr>
			<tr>
				<td colspan="2"><table width="27%" border="0" align="center"
						cellspacing="0">
						<tr>
							<td class="other_fields_label">Year:</td>
							<td class="right_side_table"><input name="year" type="text"
								class="required" id="year" maxlength="4" value="${form.year}" />
							</td>
						</tr>
						<tr>
							<td class="other_fields_label">Plan Ctrl No.:</td>
							<td class="right_side_table"><input name="plan-control-number"
								type="text" id="planCtrlNum" maxlength="45"
								value="${form.planControlNumber}" />
							</td>
						</tr>
						<tr>
							<td class="other_fields_label">Division/Office:</td>
							<td class="right_side_table"><select name="division-office"
								class="required_menulist" id="division/office">
									<c:forEach var="office" items="${offices}">
										<c:choose>
											<c:when test="${office.id eq form.divisionOffice.id}">
												<option value="${office.id}" selected="selected">${office}</option>
											</c:when>
											<c:otherwise>
												<option value="${office.id}">${office}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td class="other_fields_label">Date Scheduled:</td>
							<td class="right_side_table"><input type="text"
								name="date-scheduled" id="date-scheduled"
								value="${form.dateScheduled}" />
							</td>
						</tr>
						<tr>
							<td class="other_fields_label">Prepared by:</td>
							<td class="right_side_table"><select name="prepared-by"
								class="required_menulist" id="preparedBy">
									<c:forEach var="employee" items="${employees}">
										<c:choose>
											<c:when test="${employee.id eq form.preparedBy.id}">
												<option selected="selected" value="${employee.id}">${employee}</option>
											</c:when>
											<c:otherwise>
												<option value="${employee.id}">${employee}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td class="other_fields_label">Recommended by:</td>
							<td class="right_side_table"><select name="recommended-by"
								class="required_menulist" id="recommendedBy">
								<c:forEach var="employee" items="${employees}">
										<c:choose>
											<c:when test="${employee.id eq form.recommendedBy.id}">
												<option selected="selected" value="${employee.id}">${employee}</option>
											</c:when>
											<c:otherwise>
												<option value="${employee.id}">${employee}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><br /> <input name="saveForm"
					type="submit" class="button" value="SUBMIT Form" />
				</td>
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
