<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href=".favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Add Item</title>
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
<link href="../jquery/css/jquery-ui-1.8.13.custom.css" rel="stylesheet"
	type="text/css" />
<script src="../jquery/jquery-1.5.1.min.js"></script>
<script src="../jquery/ui/jquery.ui.core.js"></script>
<script src="../jquery/ui/jquery.ui.datepicker.js"></script>
<script src="../jquery/ui/jquery.ui.widget.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
	});
	
	
	function limitText(limitField, limitCount, limitNum) {
		if (limitField.value.length > limitNum) {
			limitField.value = limitField.value.substring(0, limitNum);
		} else {
			limitCount.value = limitNum - limitField.value.length;
		}
	}
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
    <td width="68%"><form id="form2" name="form2" method="post" action="logout">
      <input name="logoutBtn" type="submit" class="logout" id="logoutBtn" value="Logout" />
    </form></td>
  </tr>
  <tr>
    <td id="navigation"><a href="/menu" target="_top" class="links">Main Menu</a> &gt; <a href="/items" target="_top" class="links">Items List</a> &gt; <em><strong>View/Update Item</strong></em><strong></strong></td>
    <td>&nbsp;</td>
  </tr>
</table>
<div id="form_table">
	<form id="form1" name="form" method="post" action="/items">
	<input type="hidden" name="id" value="${item.id}" />
	<input type="hidden" name="update" value="item" />
  <table width="100%" frame="box" cellspacing="0" id="table">
    <tr>
      <td class="header_rows"><div class="header_1">Item Information</div></td>
    </tr>
    <tr>
      <td><table width="100%" cellspacing="9" frame="box" class="no_border_table" id="table">
        <tr>
          <td class="align_right"><br />
            Description:</td>
          <td><br /><textarea name="description" 
										onKeyDown="limitText(this.form.description,this.form.countdown,500);"
										onKeyUp="limitText(this.form.description,this.form.countdown,500);"
										class="required" id="itemDescription3"
										>${item.description}</textarea></td>
        </tr>
        <tr>
          <td class="align_right">Unit:</td>
          <td>
          <select name="unit" class="required_menulist" id="unit">
            <option selected="selected">${item.unit}</option>
            <c:forEach var="unit" items="${units}">
              <c:if test="${unit ne item.unit}">
                <option>${unit}</option>
              </c:if>
            </c:forEach>
          </select>
          </td>
        </tr>
        <tr>
          <td class="align_right">Item Category:</td>
          <td>
          <select name="itemCategory" class="required_menulist" id="category">
            <option selected="selected">${item.category}</option>
            <c:forEach var="category" items="${categories}">
              <c:if test="${category ne item.category}">
                <option>${category}</option>
              </c:if>
            </c:forEach>
          </select>
          </td> 
        </tr>
        
        <tr>
          <td class="align_right">Price:</td>
          <td>
          <input name="price" type="text" id="price"
			value="${item.price}" maxlength="50" />
          </td>
        </tr>
        
        <tr>
          <td class="align_right">Date Acquired:</td>
          <td>
          <input type="text" name="date" id="datepicker"
			value="${item.dateAcquired}" />
          </td>
        </tr>
        
        <tr>
          <td class="align_right">Stock Number:</td>
          <td><input name="stockNumber" type="text" id="stockNum"
			value="${item.stockNumber}" maxlength="45" /></td>
        </tr>
        <tr>
          <td class="align_right">Inventory Item Number:</td>
          <td><input name="inventoryItemNum" type="text"
			id="inventoryItemNum" value="${item.inventoryItemNumber}" maxlength="60" /></td>
        </tr>
        <tr>
          <td class="align_right">Property Number:</td>
          <td><input name="propertyNumber" type="text" id="propertyNumber"
			value="${item.propertyNumber}" maxlength="45" /></td>
        </tr>
        <tr>
          <td class="align_right">Item Status:</td>
          <td><select name="itemStatus" class="required_menulist" id="itemStatus">
            <option selected="selected">${item.status}</option>
            <c:forEach var="status" items="${statuses}">
              <c:if test="${status ne item.status}">
                <option>${status}</option>
              </c:if>
            </c:forEach>
          </select></td>
        </tr>
        <tr>
          <td class="align_right">Item Condition:</td>
          <td><select name="itemCondition" class="required_menulist" id="condition">
            <option selected="selected">${item.condition}</option>
            <c:forEach var="condition" items="${conditions}">
              <c:if test="${condition ne item.condition}">
                <option>${condition}</option>
              </c:if>
            </c:forEach>
          </select></td>
        </tr>
        <tr>
          <td class="align_right">&nbsp;</td>
          <td colspan="2" valign="middle" id="Update"><br />
            <input name="addBtn" type="submit" class="button" id="addBtn" value="UPDATE" />
            <br /></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td class="table_footer"></td>
    </tr>
    	<tr>
		<td class="bkgrnd_white">&nbsp;</td>
	</tr>
  </table>
  </form>
</div>

<!--<div id="footer"></div>-->
</body>
</html>