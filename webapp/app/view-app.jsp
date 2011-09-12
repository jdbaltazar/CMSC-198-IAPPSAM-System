<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::View APP</title>
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
			<td width="68%"><form id="form2" name="form2" method="post" action="/logout">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn" value="Logout" />
				</form>
			</td>
		</tr>
		<tr>
			<td id="navigation"><a href="../menu" target="_top" class="links">Main Menu</a> &gt; <a href="/app" target="_top" class="links">APP List</a> &gt; <em><strong>View APP</strong> </em><strong></strong>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="export">
		<span class="exportlabel_2">O</span><span class="exportlabel" style="font-weight: bold;">Export:</span> <a href="/app?export=pdf">PDF</a> <a href="/app?export=xls">Excel</a>
	</div>

	<div id="items_table">

		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td colspan="2"><table width="100%" border="0" cellspacing="0">
						<tr class="tableheaders_forms">
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
								<Script Language="JavaScript">
var totalQ = ${line.quantityQuarter1} + ${line.quantityQuarter2}+ ${line.quantityQuarter3}+ ${line.quantityQuarter4};
</Script>
								<td>${line.item.stockNumber}</td>
								<td>${line.item.description}</td>
								<td>${line.item.unit}</td>
								<td><Script Language="JavaScript">
  													document.write(totalQ);
									</Script></td>
								<td>${line.item.price}</td>
								<td>${line.quantityQuarter1}</td>
								<td>${line.amount1}</td>
								<td>${line.quantityQuarter2}</td>
								<td>${line.amount2}</td>
								<td>${line.quantityQuarter3}</td>
								<td>${line.amount3}</td>
								<td>${line.quantityQuarter4}</td>
								<td>${line.amount4}</td>
								<td>${line.amount}</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
			<tr>
				<td width="50%" align="right" class="same_width"><br />
				</td>
				<td class="same_width">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><table width="35%" border="0" align="center" cellspacing="0">
						<tr>
							<td class="other_fields_label">Year:</td>
							<td class="right_side_table">${form.year }</td>
						</tr>
						<tr>
							<td class="other_fields_label">Plan Ctrl No.:</td>
							<td class="right_side_table">${form.planControlNumber}</td>
						</tr>
						<tr>
							<td class="other_fields_label">Division/Office:</td>
							<td class="right_side_table">${form.divisionOffice}</td>
						</tr>
						<tr>
							<td class="other_fields_label">Date Scheduled:</td>
							<td class="right_side_table">${form.dateScheduled}</td>
						</tr>
						<tr>
							<td class="other_fields_label">Prepared by:</td>
							<td class="right_side_table">${form.preparedBy}</td>
						</tr>
						<tr>
							<td class="other_fields_label">Recommended by:</td>
							<td class="right_side_table">${form.recommendedBy}</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><br />
				</td>
			</tr>
		</table>

	</div>



	<!--<div id="footer"></div>-->
</body>
</html>
