<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::View IE</title>
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
<link href="../css/item_table.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="headerBkgrnd"><img src="../images/headerbar.png" width="100%" height="129" /></div>
<div id="logo"><img src="../images/headerlogo.png" width="124" height="128" /></div>
<div id="headerName"><img src="../images/headertext.png" width="452" height="44" /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td width="32%">&nbsp;</td>
    <td width="68%"><form id="form2" name="form2" method="post" action="/logout">
      <input name="logoutBtn" type="submit" class="logout" id="logoutBtn" value="Logout" />
    </form></td>
  </tr>
  <tr>
    <td id="navigation"><a href="menu" target="_top" class="links">Main Menu</a> &gt; <a href="ie" target="_top" class="links">IE List</a> &gt; <em><strong>View IE</strong></em><strong></strong></td>
    <td>&nbsp;</td>
  </tr>
</table>
<div id="export"><span class="exportlabel_2">O</span><span class="exportlabel" style="font-weight:bold;">Export:</span>
<a href="/ie?export=pdf">PDF</a> <a href="/ie?export=xls">Excel</a></div>
<!--<form name="PRForm" method="post" action="">-->
  <div id="items_table">
    
    <table width="100%" border="0" cellspacing="0">
      <tr>
        <td colspan="2"><table width="100%" border="0" cellspacing="0" class="tableheaders_forms">
          							<tr>
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
									<td>${line.item.propertyNumber}</td>
									<td>${line.item.description}</td>
									<td>${line.item.stockNumber}</td>
									<td>${line.quantity}</td>
									<td>${line.item.price}</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>${line.howAcquired.name}</td>
									<td>&nbsp;</td>
									<td>${line.employee.person.name}</td>
									<td>${line.remarks}</td>
								</tr>
							</c:forEach>        
				</table>
				</td>
       </tr>
      <tr>
        <td width="50%" align="right" class="same_width">&nbsp;</td>
        <td align="left" class="same_width">&nbsp;</td>
      </tr>
      <tr>
					<td colspan="2"><table width="35%" border="0" align="center"
							cellspacing="0">
							<tr>
								<td class="other_fields_label">Division/Office:</td>
								<td class="right_side_table">${form.divisionOffice.divisionName}, ${form.divisionOffice.officeName}</td>
							</tr>
							<tr>
								<td class="other_fields_label">Building:</td>
								<td class="right_side_table">${form.building.name}</td>
							</tr>
							<tr>
								<td class="other_fields_label">Prepared by:</td>
								<td class="right_side_table">${form.preparedBy.person.name}</td>
							</tr>
							<tr>
								<td class="other_fields_label">Date Prepared:</td>
								<td class="right_side_table">${form.datePrepared}
								</td>
							</tr>
							<tr>
								<td class="other_fields_label">Counterchecked by:</td>
								<td class="right_side_table">${form.counterCheckedBy.person.name}</td>
							</tr>

							<tr>
								<td class="other_fields_label">Noted:</td>
								<td class="right_side_table">${form.notedBy.person.name}</td>
							</tr>

							<tr>
								<td class="other_fields_label">Committee Member 1:</td>
								<td class="right_side_table">${form.committeeMember1.person.name}</td>
							</tr>

							<tr>
								<td class="other_fields_label">Committee Member 2:</td>
								<td class="right_side_table">${form.committeeMember2.person.name}</td>
							</tr>

							<tr>
								<td class="other_fields_label">COA Rep.:</td>
								<td class="right_side_table">${form.coaRepresentative.person.name}</td>
							</tr>
        </table>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center"><br /></td>
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