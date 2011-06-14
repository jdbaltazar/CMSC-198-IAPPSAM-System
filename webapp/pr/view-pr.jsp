<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: New Purchase Request</title>
<link href="../pr/pr.css" rel="stylesheet" type="text/css" />
<link href="../style.css" rel="stylesheet" type="text/css" />
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
<jsp:include page="/logo.jsp" />
<jsp:include page="/navigation.jsp" />

<!-- Breadcrubms should be here --->
<div class="Breadcrumbs"><a href="/menu">Menu</a> > <a href="/pr">Purchase
  Request List</a> > View Purchase Request</div>
<div id="Title" class="Form"></div>
<form id="form1" name="form1" method="post" action="/pr">
  <div id="PageHeader" class="Form"><!-- Division Office --> Department &amp; Section:
    </label>
    <select name="deptAndSection" id="deptAndSection" style="width: 200px;" disabled="disabled">
      <option value="${form.divisionOffice.id}" selected="selected">${form.divisionOffice.divisionName}, ${form.divisionOffice.officeName}</option>
    </select>
    <br />
    <!-- PR -->
    <label for="prNumber" class="labels">PR.No.:</label>
    <input
	type="text" name="prNumber" id="PrNumber" size="15" maxlength="15"
	value="${form.prNumber}"  disabled="disabled"/>
    <label for="prdate" class="labels">Date:</label>
    <input type="text" name="prDate" id="prDate" value="${form.prDate}"  disabled="disabled"/>
    <br />
    <!-- SAI -->
    <label for="saiNumber" class="labels">SAI No.:</label>
    <input
	name="saiNumber" type="text" id="saiNumber" size="15" maxlength="15"
	value="${form.saiNumber}" disabled="disabled" />
    <label for="saiDate" class="labels">Date:</label>
    <input type="text" name="saiDate" id="saiDate" value="${form.saiDate}"  disabled="disabled"/>
    <br />
    <!-- ALOBS -->
    <label for="alobsNumber" class="labels">ALOBS
      No.:</label>
    <input name="alobsNumber" type="text" id="alobsNumber" size="15"
	maxlength="15" value="${form.alobsNumber}"  disabled="disabled"/>
    <label for="alobsDate"
	class="labels">Date:</label>
    <input name="alobsDate" type="text"
	id="alobsDate" value="${form.alobsDate}"  disabled="disabled"/>
  </div>
  <div id="line">
    <table width="100%" border="0" cellspacing="0" id="TableHeader">
      <tr class="ColumnHeader">
        <td width="4%">&nbsp;</td>
        <td width="5%">Quantity</td>
        <td width="9%">Unit of Issue</td>
        <td width="42%">Item Description</td>
        <td width="22%">Stock No.</td>
        <td width="18%">Estimated Unit Cost</td>
      </tr>
      <c:forEach var="line" items="${form.lines}" varStatus="loop">
        <tr> 
          <!-- class="tablerow_1" -->
          
          <td width="5%"><input name="quantity" type="text"
				class="textfields_1" id="Quantity" size="4" value="${line.quantity}"  disabled="disabled"/></td>
          <td width="9%">${line.item.unit}</td>
          <td width="42%">${line.item.description}</td>
          <td width="22%">${line.item.stockNumber}</td>
          <td width="18%">${line.estimatedUnitCost}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
  <div id="LineAction" class="Form"></div>
  <div id="PageFooter" class="Form">
    <label for="purpose"
	class="labels">Purpose:</label>
    <textarea name="purpose" id="purpose" disabled="disabled">${form.purpose}</textarea>
    <br />
    <label for="requestedBy" class="labels">Requested by:</label>
    <select name="requestedBy" id="requestedBy" disabled="disabled">
      <option selected="selected" value="${form.requestedBy.id}">${form.requestedBy.person.name}</option>
    </select>
    <label for="approvedby" class="labels">Approved by:</label>
    <select	name="approvedby" id="approvedby" disabled="disabled">
      <option selected="selected" value="${form.approvedBy.id}">${form.approvedBy.person.name}</option>
    </select>
  </div>
</form>
<jsp:include page="../copyright.jsp" />
</body>
</html>
