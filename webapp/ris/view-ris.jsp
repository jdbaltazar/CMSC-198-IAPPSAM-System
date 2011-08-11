<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::View RIS</title>
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
    <td id="navigation"><a href="menu" target="_top" class="links">Main Menu</a> &gt; <a href="/ris" target="_top" class="links">RIS List</a> &gt; <em><strong>View RIS</strong></em><strong></strong></td>
    <td>&nbsp;</td>
  </tr>
</table>
    <div id="export"><span class="exportlabel_2">O</span><span class="exportlabel" style="font-weight:bold;">Export:</span>
<a href="/ris?export=pdf">PDF</a> <a href="/ris?export=xls">Excel</a></div>
<!--<form name="PRForm" method="post" action="">-->
  <div id="items_table">
    
    <table width="100%" border="0" cellspacing="0">
      <tr>
        <td colspan="2"><table width="100%" border="0" cellspacing="0" class="tableheaders_forms">
          <tr>
            <td>Stock No.</td>
            <td>Unit</td>
            <td>Description</td>
            <td>Qty. Requested</td>
            <td>Qty. Issued</td>
            <td>Remarks</td>
          </tr>
          <c:forEach var="line" items="${form.lines}" varStatus="loop">
							<tr class="tablerow_1">
								<!-- class="tablerow_1" -->
								<td>${line.item.stockNumber}</td>
								<td>${line.item.unit}</td>
								<td>${line.item.description}</td>
								<td>${line.quantityRequested}</td>
								<td>${line.quantityIssued}</td>
								<td>${line.remarks}</td>
							</tr>
						</c:forEach>
        </table></td>
      </tr>
      <tr>
        <td width="50%" align="right" class="same_width"><br /></td>
        <td align="left" class="same_width">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2"><table width="25%" border="0" align="center" cellspacing="0">
          <tr>
            <td class="other_fields_label">Division/Office:</td>
            <td class="right_side_table">${form.divisionOffice.divisionName}, ${form.divisionOffice.officeName}</td>
            </tr>
          <tr>
            <td class="other_fields_label">Responsibility Center Code.:</td>
            <td class="right_side_table">${form.rcCode}</td>
            </tr>
          <tr>
            <td class="other_fields_label">RIS No.:</td>
            <td class="right_side_table">${form.risNumber}</td>
            </tr>
          <tr>
            <td class="other_fields_label">Date:</td>
            <td class="right_side_table">${form.risDate}</td>
            </tr>
          <tr>
            <td class="other_fields_label">SAI No.:</td>
            <td class="right_side_table">${form.saiNumber}</td>
            </tr>
          <tr>
            <td class="other_fields_label">Date:</td>
            <td class="right_side_table">${form.saiDate}</td>
            </tr>
          <tr>
            <td class="other_fields_label">Purpose:</td>
            <td class="right_side_table">${form.purpose}</td>
            </tr>
          <tr>
            <td class="other_fields_label">Requested by:</td>
            <td class="right_side_table">${form.requestedBy.person.name}</td>
            </tr>
          <tr>
            <td class="other_fields_label">Date:</td>
            <td class="right_side_table">${form.requestedByDate}</td>
            </tr>
          <tr>
            <td class="other_fields_label">Approved by:</td>
            <td class="right_side_table">${form.approvedBy.person.name}</td>
          </tr>
          <tr>
            <td class="other_fields_label">Date:</td>
            <td class="right_side_table">${form.approvedByDate}</td>
            </tr>
          <tr>
            <td class="other_fields_label">Issued by:</td>
            <td class="right_side_table">${form.issuedBy.person.name}</td>
          </tr>
          <tr>
            <td class="other_fields_label">Date:</td>
            <td class="right_side_table">${form.issuedByDate}</td>
            </tr>
          <tr>
            <td class="other_fields_label">Received by:</td>
            <td class="right_side_table">${form.receivedBy.person.name}</td>
            </tr>
            <tr>
            <td class="other_fields_label">Date:</td>
            <td class="right_side_table">${form.receivedByDate}</td>
            </tr>
        </table></td>
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
