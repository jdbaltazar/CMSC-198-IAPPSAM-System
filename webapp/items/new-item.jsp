<%@page import="com.iappsam.servlet.item.ItemAttribute"%>
<%@page import="com.iappsam.ItemCondition"%>
<%@page import="com.iappsam.ItemStatus"%>
<%@page import="com.iappsam.ItemCategory"%>
<%@page import="com.iappsam.Unit"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="/favicon.ico" />
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
		$("#dateAcquired").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
	});
</script>

<script type="text/javascript">

function validateItemForm()
{
	var txt="";
	var x=document.forms["itemform"]["description"].value;

  txt="There was an error on this page!\n\n";
  txt+="Make sure required fields are not left blank,\n";
  txt+="or input is valid for that field.\n\n";

if (x==null || x=="")
  {
  alert(txt);
  return false;
  }
}

function limitText(limitField, limitCount, limitNum) {
	if (limitField.value.length > limitNum) {
		limitField.value = limitField.value.substring(0, limitNum);
	} else {
		limitCount.value = limitNum - limitField.value.length;
	}
}

</script>
<%
	List<Unit> units = new ArrayList<Unit>();
	List<ItemCategory> categories = new ArrayList<ItemCategory>();
	List<ItemStatus> statuses = new ArrayList<ItemStatus>();
	List<ItemCondition> conditions = new ArrayList<ItemCondition>();

	units = (List<Unit>) request.getAttribute(ItemAttribute.UNITS);
	categories = (List<ItemCategory>) request.getAttribute(ItemAttribute.CATEGORIES);
	statuses = (List<ItemStatus>) request.getAttribute(ItemAttribute.STATUSES);
	conditions = (List<ItemCondition>) request.getAttribute(ItemAttribute.CONDITIONS);
%>
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
					action="logout">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn"
						value="Logout" />
				</form>
			</td>
		</tr>
		<tr>
			<td id="navigation"><a href="/menu" target="_top" class="links">Main
					Menu</a> &gt; <a href="/items" target="_top" class="links">Items
					List</a> &gt; <em><strong>Add Item</strong> </em><strong></strong>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="form_table">
		<form name="itemform" action="/items"
			onsubmit="return validateItemForm()" method="post">
			<input type="hidden" name="add" value="item" />
			<table width="100%" frame="box" cellspacing="0" id="table">
				<tr>
					<td class="header_rows"><div class="header_1">Item
							Information</div>
					</td>
				</tr>
				<tr>
					<td><table width="100%" cellspacing="9" frame="box"
							class="no_border_table" id="table">
							<tr>
								<td class="align_right"><br /> Description:</td>
								<td><br /> <textarea name="description"
										onKeyDown="limitText(this.form.description,this.form.countdown,500);"
										onKeyUp="limitText(this.form.description,this.form.countdown,500);"
										class="required" id="itemDescription3"
										></textarea>
								</td>
							</tr>
							<tr>
								<td class="align_right">Unit:</td>
								<td><select name="unit" class="required_menulist"
									id="itemUnit2">
										<%
											for (Unit s : units) {
										%>
										<option><%=s%></option>
										<%
											}
										%>
								</select>
								</td>
							</tr>
							<tr>
								<td class="align_right">Item Category:</td>
								<td><select name="itemCategory" class="required_menulist"
									id="itemCategory2">
										<%
											for (ItemCategory s : categories) {
										%>
										<option><%=s%></option>
										<%
											}
										%>
								</select>
								</td>
							</tr>
							<tr>
								<td class="align_right">Price:</td>
								<td><input name="price" type="text" id="price"
									maxlength="12" />
								</td>
							</tr>
							<tr>
								<td class="align_right">Date Acquired:</td>
								<td><input name="date" type="text" id="dateAcquired" /></td>
							</tr>
							<tr>
								<td class="align_right">Stock Number:</td>
								<td><input name="stockNumber" type="text" id="stockNumber"
									maxlength="45" />
								</td>
							</tr>
							<tr>
								<td class="align_right">Inventory Item Number:</td>
								<td><input name="inventoryItemNum" type="text"
									id="inventoryItemNum3" maxlength="60" />
								</td>
							</tr>
							<tr>
								<td class="align_right">Property Number:</td>
								<td><input name="propertyNumber" type="text"
									id="propertyNumber" maxlength="45" />
								</td>
							</tr>
							<tr>
								<td class="align_right">Item Status:</td>
								<td><select name="itemStatus" class="required_menulist"
									id="itemStatus3">
										<%
											for (ItemStatus s : statuses) {
										%>
										<option><%=s%></option>
										<%
											}
										%>
								</select>
								</td>
							</tr>
							<tr>
								<td class="align_right">Item Condition:</td>
								<td><select name="itemCondition" class="required_menulist"
									id="itemCondition3">
										<%
											for (ItemCondition s : conditions) {
										%>
										<option><%=s%></option>
										<%
											}
										%>
								</select>
								</td>
							</tr>
							<tr>
								<td class="align_right">&nbsp;</td>
								<td><br /> <input name="addItemBtn" type="submit"
									class="button" id="addItemBtn" value="ADD" /> <br />
								</td>
							</tr>
						</table>
					</td>
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
