<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Fillup IE</title>
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
		$("#datePrepared").datepicker({
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
			<td id="navigation"><a href="menu" target="_top" class="links">Main
					Menu</a> &gt; <a href="ie" target="_top" class="links">IE List</a> &gt;
				<em><strong>Fillup IE</strong> </em><strong></strong>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<form name="IEForm" method="post" action="/ie">
		<div id="items_table">

			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td colspan="2"><table width="100%" border="0" cellspacing="0"
							class="tableheaders_forms">
							<tr>
								<td>
								</td>
								<td>Property No.</td>
								<td>Equipment Property</td>
								<td>Article Code</td>
								<td>Quantity</td>
								<td>Unit Value</td>
								<td>Total Value</td>
								<td>Year Acquired</td>
								<td>How Acquired</td>
								<td>Present Condition</td>
								<td>Person Accountable</td>
								<td>Remarks</td>
							</tr>

							<c:forEach var="line" items="${form.lines}" varStatus="loop">
								<tr class="tablerow_1">
									<td><input type="checkbox" name="checkedItems" id="items"
										value="${line.item.id}" /> <input type="hidden" name="items"
										value="${line.item.id}" />
									</td>
									<td>${line.item.propertyNumber}</td>
									<td>${line.item.description}</td>
									<td>${line.item.stockNumber}</td>
									<td><input name="quantity" type="text" class="required"
										id="qtyRequested" size="2" maxlength="8" />
								  </td>

									<td>${line.item.price}</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td><select name="how-acquired" id="howacquired" class="menulist">
											<c:forEach var="modeofprocurement"
												items="${mods}">
												<c:choose>
													<c:when
														test="${modeofprocurement.id eq line.howAcquired.id}">
														<option selected="selected"
															value="${modeofprocurement.id}">${modeofprocurement.name}</option>
													</c:when>
													<c:otherwise>
														<option value="${modeofprocurement.id}">${modeofprocurement.name}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>

									</select>
									</td>
									<td>&nbsp;</td>
									<td><select name="employee" id="employee" class="menulist">
											<c:forEach var="employee" items="${employees}">
												<c:choose>
													<c:when test="${employee.id eq line.employee.id}">
														<option selected="selected" value="${employee.id}">${employee.person.name}</option>
													</c:when>
													<c:otherwise>
														<option value="${employee.id}">${employee.person.name}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
									</select>
									</td>
									<td><input name="remarks" type="text" id="remarks"
										size="10" />
									</td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td width="50%" align="right" class="same_width"><br /> <input
						name="addItems" type="submit" class="button" id="addItemBtn"
						value="Add Item&gt;&gt;" /> <br /> <br />
					</td>
					<td align="left" class="same_width"><br /> <input
						name="removeItems" type="submit" class="button"
						id="removeSelectedItems" value="Remove Item" /> <br /> <br /></td>
				</tr>
				<tr>
					<td colspan="2"><table width="25%" border="0" align="center"
							cellspacing="0">
							<tr>
								<td class="other_fields_label">Division/Office:</td>
								<td class="right_side_table"><select name="division-office"
									class="required_menulist" id="division">

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
								</select>
								</td>
							</tr>
							<tr>
								<td class="other_fields_label">Building:</td>
								<td class="right_side_table"><select name="building"
									class="required_menulist" id="building">
										<c:forEach var="building" items="${buildings}">
											<c:choose>
												<c:when test="${building.id eq form.building.id}">
													<option value="${building.id}" selected="selected">
														${building.name}</option>
												</c:when>
												<c:otherwise>
													<option value="${building.id}">${building.name}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
								</select>
								</td>
							</tr>
							<tr>
								<td class="other_fields_label">Prepared by:</td>
								<td class="right_side_table"><label for="preparedBy"></label>
									<select name="prepared-by" class="required_menulist"
									id="preparedBy">
										<c:forEach var="employee" items="${employees}">
											<c:choose>
												<c:when test="${employee.id eq form.preparedBy.id}">
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
								<td class="other_fields_label">Date Prepared:</td>
								<td class="right_side_table"><input name="date-prepared"
									type="text" class="required" id="datePrepared"
									value="${form.datePrepared}" />
								</td>
							</tr>
							<tr>
								<td class="other_fields_label">Counterchecked by:</td>
								<td class="right_side_table"><select
									name="countercheck" class="required_menulist"
									id="counterchecked">
										<c:forEach var="employee" items="${employees}">
											<c:choose>
												<c:when test="${employee.id eq form.counterCheckedBy.id}">
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
								<td class="other_fields_label">Noted:</td>
								<td class="right_side_table"><select name="noted-by"
									class="required_menulist" id="noted">
										<c:forEach var="employee" items="${employees}">
											<c:choose>
												<c:when test="${employee.id eq form.notedBy.id}">
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
								<td class="other_fields_label">Committee Member 1:</td>
								<td class="right_side_table"><select name="committee1"
									class="required_menulist" id="noted">
										<c:forEach var="employee" items="${employees}">
											<c:choose>
												<c:when test="${employee.id eq form.committeeMember1.id}">
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
								<td class="other_fields_label">Committee Member 2:</td>
								<td class="right_side_table"><select name="committee2"
									class="required_menulist" id="noted">
										<c:forEach var="employee" items="${employees}">
											<c:choose>
												<c:when test="${employee.id eq form.committeeMember2.id}">
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
								<td class="other_fields_label">COA Rep.:</td>
								<td class="right_side_table"><select
									name="coa-representative" class="required_menulist" id="noted">
										<c:forEach var="employee" items="${employees}">
											<c:choose>
												<c:when test="${employee.id eq form.coaRepresentative.id}">
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

