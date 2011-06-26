<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Fillup PO</title>
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
		$("#deliveryDate").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
		$("#poNoDate").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
		$("#signatoryDate").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
	});
</script>
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
    <td width="68%"><form id="form2" name="form2" method="post" action="">
      <input name="logoutBtn" type="submit" class="logout" id="logoutBtn" value="Logout" />
    </form></td>
  </tr>
  <tr>
    <td id="navigation"><a href="#" target="_top" class="links">Main Menu</a> &gt; <a href="#" target="_top" class="links">PO List</a> &gt; <em><strong>Fillup Purchase Order</strong></em><strong></strong></td>
    <td>&nbsp;</td>
  </tr>
</table>
<form name="POForm" method="post" action="/po">
  <div id="items_table">
    <table width="100%" border="0" cellspacing="0">
      <tr>
        <td colspan="2"><table width="100%" border="1" cellspacing="0" class="tableheaders_forms">
          <tr>
            <td width="4%">
              <input type="checkbox" name="selectAll" id="selectAll" />
              </td>
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
            <td width="4%" align="center">
              <input type="checkbox"  name="checkedItems"
						id="items" value="${line.item.id}" /> <input type="hidden"
						name="items" value="${line.item.id}" /></td>
            <td width="10%">${line.item.stockNumber}</td>
            <td width="8%">${line.item.unit}</td>
            <td width="50%">${line.item.description}</td>
            <td width="7%">
            <input name="quantity" type="text"
						class="required" id="Quantity"
						value="${line.quantity}" size="2" maxlength="11" /></td>
            <td width="9%">&nbsp;</td>
            <td width="12%">&nbsp;</td>
            </tr>
            </c:forEach>
        </table></td>
      </tr>
      <tr>
        <td width="50%" align="right" class="same_width">
          <br />
          <input name="addItems" type="submit" class="button" id="addItem" value="Add Item&gt;&gt;" />
          <br />
          <br />
        </td>
        <td class="same_width">
          <br />
          <input name="removeItems" type="submit" class="button" id="Remove Item" value="Remove Item" />
          <br />
          <br />
        </td>
      </tr>
      <tr>
        <td colspan="2"><table width="27%" border="0" align="center" cellspacing="0">
          <tr>
            <td class="other_fields_label">Supplier:</td>
            <td class="right_side_table"><select name="supplierList" class="menulist" id="supplierList">
            
            <c:forEach var="supplier" items="${suppliers}">
						<c:choose>
							<c:when test="${supplier.id eq form.supplier.id}">
								<option value="${supplier.id}" selected="selected">${supplier.supplierName}</option>
							</c:when>
							<c:otherwise>
								<option value="${supplier.id}">${supplier.supplierName}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
              </select></td>
            </tr>
          <tr>
            <td class="other_fields_label">P.O. No.:</td>
            <td class="right_side_table"><input type="text" name="PONum" id="PONum" value="${form.poNumber}"/></td>
            </tr>
          <tr>
            <td class="other_fields_label">Date:</td>
            <td class="right_side_table"><input type="text" name="poNoDate" id="poNoDate" value="${form.date}"/></td>
            </tr>
          <tr>
            <td class="other_fields_label">Mode of Procurement:</td>
            <td class="right_side_table"><select name="modeOfProcurement" class="menulist" id="modeOfProcurement">
            
            <c:forEach var="modeOfProcurement" items="${mops}">
						<c:choose>
							<c:when test="${modeOfProcurement.id eq form.mops.id}">
								<option value="${modeOfProcurement.id}" selected="selected">${modeOfProcurement.name}</option>
							</c:when>
							<c:otherwise>
								<option value="${modeOfProcurement.id}">${modeOfProcurement.name}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
              </select></td>
            </tr>
            
          <tr>
            <td class="other_fields_label">Delivery Place:</td>
            <td class="right_side_table">
            <select name="deliveryPlace" class="menulist" id="deliveryPlace">
            
            <c:forEach var="divisionOffice" items="${divisionoffices}">
						<c:choose>
							<c:when test="${divisionOffice.id eq form.divisionOffice.id}">
								<option value="${divisionOffice.id}" selected="selected">${divisionOffice.divisionName},
								${divisionOffice.officeName}</option>
							</c:when>
							<c:otherwise>
								<option value="${divisionOffice.id}">${divisionOffice.divisionName},
								${divisionOffice.officeName}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
              </select>
              </td>
            </tr>
          <tr>
            <td class="other_fields_label">Delivery Date:</td>
            <td class="right_side_table"><input type="text" name="deliveryDate" id="deliveryDate" value="${form.dateOfDelivery}"/></td>
            </tr>
          <tr>
            <td class="other_fields_label">Payment Term:</td>
            <td class="right_side_table"><input type="text" name="paymentTerm" id="paymentTerm" value="${form.paymentTerm}"/></td>
            </tr>
          <tr>
            <td class="other_fields_label">Supplier Rep.:</td>
            <td class="right_side_table"><select name="supplierRep" class="menulist" id="supplierRep">
            
            <c:forEach var="employee" items="${employees}">
						<c:choose>
							<c:when test="${employee.id eq form.supplierName.id}">
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
            <td class="other_fields_label">Date:</td>
            <td class="right_side_table"><input type="text" name="signatoryDate" id="signatoryDate"  value="${form.supplierDate}"/></td>
            </tr>
          <tr>
            <td class="other_fields_label">Very Truly Yours:</td>
            <td class="right_side_table"><select name="veryTrulyYours" class="menulist" id="veryTrulyYours">
            
            
            <c:forEach var="employee" items="${employees}">
						<c:choose>
							<c:when test="${employee.id eq form.dean.id}">
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
            <td class="other_fields_label">Accountant:</td>
            <td class="right_side_table"><select name="accountant" class="menulist" id="accountant">
            
            <c:forEach var="employee" items="${employees}">
						<c:choose>
							<c:when test="${employee.id eq form.accountant.id}">
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
            <td class="other_fields_label">OR No.:</td>
            <td class="right_side_table"><input type="text" name="orNum" id="orNum" value="${form.orNumber}"/></td>
            </tr>
          <tr>
            <td class="other_fields_label">Amount:</td>
            <td class="right_side_table"><input type="text" name="amount" id="amount" value="${form.amount}"/></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><br />
        <input name="submitBtn" type="submit" class="button" value="SUBMIT Form" /></td>
      </tr>
    </table>
    </div>
</form>
<!--<div id="footer"></div>-->
</body>
</html>