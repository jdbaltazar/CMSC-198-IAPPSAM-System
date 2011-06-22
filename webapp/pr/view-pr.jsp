<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Fillup PR</title>
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
<link href="../css/item_table.css" rel="stylesheet" type="text/css" />
<link href="../jquery/css/jquery-ui-1.8.13.custom.css" rel="stylesheet" type="text/css" />
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
<div id="headerBkgrnd"> <img src="../images/headerbar.png" width="100%" height="129" /> </div>
<div id="logo"> <img src="../images/headerlogo.png" width="124" height="128" /> </div>
<div id="headerName"> <img src="../images/headertext.png" width="452" height="44" /> </div>
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
		<td id="navigation"><a href="/menu" target="_top" class="links">Main Menu</a> &gt; <a href="/pr" target="_top" class="links">PR List</a> &gt; <em><strong>View Purchase Request</strong> </em><strong></strong></td>
		<td>&nbsp;</td>
	</tr>
</table>
<!--<form name="PRForm" method="post" action="">-->
<div id="items_table">
	<table width="100%" border="0" cellspacing="0">
		<tr>
			<td colspan="2"><table width="100%" border="0" cellspacing="0">
					<tr class="tableheaders_forms">
						<td><input type="checkbox" name="selectAllItems" id="selectAllItems" /></td>
						<td>Quantity</td>
						<td>Unit of Issue</td>
						<td>Item Description</td>
						<td>Stock No.</td>
						<td>Estimated Unit Cost</td>
						<td>Estimated Cost</td>
					</tr>
					<c:forEach var="line" items="${form.lines}" varStatus="loop">
						<tr class="tablerow_1"> 
							<!-- class="tablerow_1" -->
							
							<td width="5%"><input name="quantity" type="text" class="textfields_1" id="Quantity" size="4" value="${line.quantity}" disabled="disabled" /></td>
							<td width="9%">${line.item.unit}</td>
							<td width="42%">${line.item.description}</td>
							<td width="22%">${line.item.stockNumber}</td>
							<td width="18%">${line.estimatedUnitCost}</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</c:forEach>
				</table></td>
		</tr>
		<tr>
			<td width="50%" align="right" class="same_width"><br />
				<form id="form5" name="form5" method="post" action="">
					<input name="addItemBtn" type="submit" class="button" id="addItemBtn" value="Add Item&gt;&gt;" />
				</form>
				<br /></td>
			<td align="left" class="same_width"><form id="form6" name="form6" method="post" action="">
					<input name="removeSelectedItems" type="submit" class="button" id="removeSelectedItems" value="Remove Item" />
				</form></td>
		</tr>
		<tr>
			<td colspan="2"><table width="25%" border="0" align="center" cellspacing="0">
					<tr>
						<td class="other_fields_label">Department/Section:</td>
						<td class="right_side_table"><select name="deptAndSection" id="deptAndSection" class="menulist" disabled="disabled">
								<option value="${form.divisionOffice.id}" selected="selected">${form.divisionOffice.divisionName}, ${form.divisionOffice.officeName}</option>
							</select>
							</select></td>
					</tr>
					<tr>
						<td class="other_fields_label">PR No.:</td>
						<td class="right_side_table"><input type="text" name="prNumber" id="PrNumber" maxlength="15" value="${form.prNumber}" disabled="disabled" /></td>
					</tr>
					<tr>
						<td class="other_fields_label">Date:</td>
						<td class="right_side_table"><input type="text" name="prDate" id="prDate" value="${form.prDate}" disabled="disabled" /></td>
					</tr>
					<tr>
						<td class="other_fields_label">SAI No.:</td>
						<td class="right_side_table"><input name="saiNumber" type="text" id="saiNumber" maxlength="15" value="${form.saiNumber}" disabled="disabled" /></td>
					</tr>
					<tr>
						<td class="other_fields_label">Date:</td>
						<td class="right_side_table"><input type="text" name="saiDate" id="saiDate" value="${form.saiDate}" disabled="disabled" /></td>
					</tr>
					<tr>
						<td class="other_fields_label">ALOBS No.:</td>
						<td class="right_side_table"><input name="alobsNumber" type="text" id="alobsNumber" maxlength="15" value="${form.alobsNumber}" disabled="disabled" /></td>
					</tr>
					<tr>
						<td class="other_fields_label">Date:</td>
						<td class="right_side_table"><input name="alobsDate" type="text" id="alobsDate" value="${form.alobsDate}" disabled="disabled" /></td>
					</tr>
					<tr>
						<td class="other_fields_label">Purpose:</td>
						<td class="right_side_table"><input name="purpose" id="purpose" disabled="disabled" value="${form.purpose}" /></td>
					</tr>
					<tr>
						<td class="other_fields_label">Requested by:</td>
						<td class="right_side_table"><select name="requestedBy" id="requestedBy" disabled="disabled">
								<option selected="selected" value="${form.requestedBy.id}">${form.requestedBy.person.name}</option>
							</select></td>
					</tr>
					<tr>
						<td class="other_fields_label">Prepared by:</td>
						<td class="right_side_table"><select name="approvedby" id="approvedby" disabled="disabled">
								<option selected="selected" value="${form.approvedBy.id}">${form.approvedBy.person.name}</option>
							</select></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><br />
				<input name="submitBtn" type="submit" class="button" value="SUBMIT Form" /></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
	</table>
</div>
<!--</form>--> 

<!--<div id="footer"></div>-->
</body>
</html>
