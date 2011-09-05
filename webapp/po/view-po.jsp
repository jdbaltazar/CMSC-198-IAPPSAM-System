<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::View PO</title>
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
<link href="../css/item_table.css" rel="stylesheet" type="text/css" />

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
				</form></td>
		</tr>
		<tr>
			<td id="navigation"><a href="/menu" target="_top" class="links">Main
					Menu</a> &gt; <a href="/po" target="_top" class="links">PO List</a>
				&gt; <em><strong>View PO</strong> </em><strong></strong></td>
			<td>&nbsp;</td>
		</tr>
	</table>

	<div id="export">
		<span class="exportlabel_2">O</span><span class="exportlabel"
			style="font-weight: bold;">Export:</span> <a href="/po?export=pdf">PDF</a>
		<a href="/po?export=xls">Excel</a>
	</div>
	<form name="POForm" method="post" action="/po">
		<div id="items_table">
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td colspan="2"><table width="100%" border="0" cellspacing="0"
							class="tableheaders_forms">
							<tr>
								<td width="10%">Stock No.</td>
								<td width="8%">Unit</td>
								<td width="50%">Description</td>
								<td width="7%">Quantity</td>
								<td width="9%">Unit Cost</td>
								<td width="12%">Amount</td>
							</tr>
						</table></td>
				</tr>

				<tr>
					<td colspan="2"><table width="100%" border="0" cellspacing="0">

							<c:forEach var="line" items="${form.lines}" varStatus="loop">
								<tr class="tablerow_1">
									<td width="10%">${line.item.stockNumber}</td>
									<td width="8%">${line.item.unit}</td>
									<td width="50%">${line.item.description}</td>
									<td width="7%">${line.quantity}</td>
									<td width="9%">${line.item.price}</td>
									<td width="12%">${line.amount}</td>
								</tr>
							</c:forEach>
						</table></td>
				</tr>
				<tr>
					<td width="50%" align="right" class="same_width"><br />
					</td>
					<td class="same_width">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2"><table width="35%" border="0" align="center"
							cellspacing="0" style="table-layout: auto">
							<tr>
								<td class="other_fields_label">Supplier:</td>
								<td class="right_side_table">${form.supplier.supplierName}</td>
							</tr>
							<tr>
								<td class="other_fields_label">P.O. No.:</td>
								<td class="right_side_table">${form.poNumber}</td>
							</tr>
							<tr>
								<td class="other_fields_label">Date:</td>
								<td class="right_side_table">${form.date}</td>
							</tr>
							<tr>
								<td class="other_fields_label">Mode of Procurement:</td>
								<td class="right_side_table">${form.modeOfProcurement.name}</td>
							</tr>

							<tr>
								<td class="other_fields_label">Delivery Place:</td>
								<td class="right_side_table">${form.divisionOffice.divisionName}</td>
							</tr>
							<tr>
								<td class="other_fields_label">Delivery Date:</td>
								<td class="right_side_table">${form.dateOfDelivery}</td>
							</tr>
							<tr>
								<td class="other_fields_label">Payment Term:</td>
								<td class="right_side_table">${form.paymentTerm}</td>
							</tr>
							<tr>
								<td class="other_fields_label">Supplier Rep.:</td>
								<td class="right_side_table">${form.supplierName}</td>
							</tr>
							<tr>
								<td class="other_fields_label">Date:</td>
								<td class="right_side_table">${form.supplierDate}</td>
							</tr>
							<tr>
								<td class="other_fields_label">Very Truly Yours:</td>
								<td class="right_side_table">${form.dean}</td>
							</tr>
							<tr>
								<td class="other_fields_label">Date:</td>
								<td class="right_side_table">${form.deanDate}</td>
							</tr>
							<tr>
								<td class="other_fields_label">Accountant:</td>
								<td class="right_side_table">${form.accountant}</td>
							</tr>
							<tr>
								<td class="other_fields_label">Date:</td>
								<td class="right_side_table">${form.accountantDate}</td>
							</tr>
							<tr>
								<td class="other_fields_label">OR No.:</td>
								<td class="right_side_table">${form.orNumber}</td>
							</tr>
							<tr>
								<td class="other_fields_label">Amount:</td>
								<td class="right_side_table">${form.amount}</td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><br />
					</td>
				</tr>
			</table>
		</div>
	</form>
	<!--<div id="footer"></div>-->
</body>
</html>
