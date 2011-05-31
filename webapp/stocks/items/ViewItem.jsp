<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.entities.Item"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: View Item</title>
<style type="text/css">
.maroon {
	font-size: 12px;
	font-family: Lucida Grande;
	background-color: #7B1113;
	color: white;
	border-left: 1px solid lightgray;
	border-right: 1px solid lightgray;
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

.maroon:hover {
	font-weight: bold;
	/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
	border-right: 1px solid #7B1113;
	border-top: 1px solid #7B1113;
	border-bottom: 1px solid #7B1113;
}

.button {
	font-size: 14px;
	font-family: Lucida Grande;
	background-color: white;
	color: #7B1113;
	border-left: 1px solid lightgray;
	border-right: 1px solid lightgray;
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

.button:hover {
	font-weight: bold;
	color: #060;
	/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
	border-right: 1px solid #7B1113;
	border-top: 1px solid #7B1113;
	border-bottom: 1px solid #7B1113;
}

.requiredLabel {
	font-family: Lucida Grande;
	font-size: 11px;
	color: red;
}

.texts {
	font-family: Lucida Grande;
	font-size: 16px;
	font-weight: bold;
}

#headerdiv {
	background-color: #7B1113;
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 1;
	left: 383px;
	top: 324px;
}

#background {
	position: absolute;
	width: 578px;
	height: 570px;
	z-index: 2;
	left: 383px;
	top: 350px;
}

#name {
	position: absolute;
	width: 434px;
	height: 55px;
	z-index: 3;
	left: 535px;
	top: 347px;
}

#stockNum {
	position: absolute;
	width: 435px;
	height: 25px;
	z-index: 4;
	left: 944px;
	top: 448px;
}

#unit {
	position: absolute;
	width: 200px;
	height: 28px;
	z-index: 5;
	left: 1035px;
	top: 239px;
}

#description {
	position: absolute;
	width: 442px;
	height: 36px;
	z-index: 6;
	left: 1012px;
	top: 337px;
}

#apDiv1 {
	position: absolute;
	width: 147px;
	height: 15px;
	z-index: 7;
	left: 398px;
	top: 742px;
}

#apDiv2 {
	position: absolute;
	width: 380px;
	height: 27px;
	z-index: 8;
	left: 420px;
	top: 460px;
}

#apDiv3 {
	position: absolute;
	width: 456px;
	height: 25px;
	z-index: 9;
	left: 933px;
	top: 507px;
}

#apDiv4 {
	position: absolute;
	width: 438px;
	height: 26px;
	z-index: 10;
	left: 936px;
	top: 567px;
}

#apDiv5 {
	position: absolute;
	width: 385px;
	height: 27px;
	z-index: 11;
	left: 943px;
	top: 618px;
}

#apDiv6 {
	position: absolute;
	width: 353px;
	height: 27px;
	z-index: 12;
	left: 1067px;
	top: 704px;
}

#addDiv {
	position: absolute;
	width: 200px;
	height: 41px;
	z-index: 13;
	left: 956px;
	top: 772px;
}

#apDiv7 {
	position: absolute;
	width: 586px;
	height: 642px;
	z-index: 1;
	left: 127px;
	top: 179px;
}

#footer {
	background-color: #7B1113;
	position: absolute;
	width: 578px;
	height: 9px;
	z-index: 14;
	left: 382px;
	top: 921px;
}

#apDiv8 {
	position: absolute;
	width: 200px;
	height: 38px;
	z-index: 15;
	left: 18px;
	top: 197px;
}

#apDiv9 {
	position: absolute;
	width: 200px;
	height: 32px;
	z-index: 1;
}

#apDiv10 {
	position: absolute;
	width: 286px;
	height: 28px;
	z-index: 15;
	left: 966px;
	top: 310px;
}

#dayDiv {
	position: absolute;
	width: 62px;
	height: 27px;
	z-index: 16;
	left: 979px;
	top: 358px;
}

#yearDiv {
	position: absolute;
	width: 84px;
	height: 27px;
	z-index: 17;
	left: 1113px;
	top: 363px;
}

#apDiv11 {
	position: absolute;
	width: 137px;
	height: 28px;
	z-index: 18;
	left: 9px;
	top: 93px;
}

#apDiv12 {
	position: absolute;
	width: 413px;
	height: 43px;
	z-index: 18;
	left: -49px;
	top: 25px;
}

#apDiv13 {
	position: absolute;
	width: 233px;
	height: 29px;
	z-index: 18;
	left: 4px;
	top: 187px;
}

#apDiv14 {
	position: absolute;
	width: 414px;
	height: 29px;
	z-index: 18;
	left: -73px;
	top: 232px;
}

#apDiv15 {
	position: absolute;
	width: 393px;
	height: 28px;
	z-index: 18;
	left: -71px;
	top: 276px;
}

#apDiv16 {
	position: absolute;
	width: 391px;
	height: 27px;
	z-index: 18;
	left: -95px;
	top: 318px;
}

#apDiv17 {
	position: absolute;
	width: 370px;
	height: 30px;
	z-index: 18;
	left: -95px;
	top: 363px;
}

#apDiv18 {
	position: absolute;
	width: 272px;
	height: 26px;
	z-index: 18;
	left: -47px;
	top: 406px;
}

#apDiv19 {
	position: absolute;
	width: 283px;
	height: 27px;
	z-index: 18;
	left: -76px;
	top: 452px;
}

#apDiv20 {
	position: absolute;
	width: 68px;
	height: 35px;
	z-index: 18;
	left: 94px;
	top: 510px;
}

#apDiv21 {
	position: absolute;
	width: 200px;
	height: 28px;
	z-index: 18;
	left: -28px;
	top: 140px;
}

#pageLabel {
	position: absolute;
	width: 200px;
	height: 50px;
	z-index: 1;
	top: 181px;
	left: 13px;
}

#logoHeader {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 1;
}

#logoutiv {
	position: absolute;
	width: 200px;
	height: 30px;
	z-index: 15;
	left: 14px;
	top: 143px;
}

#footer_2 {
	position: absolute;
	left: 3px;
	top: 1001px;
	width: 100%;
}
</style>
</head>

<body>
<%
	Item item = (Item) request.getAttribute("item");
	String day = (String) request.getAttribute("day");
	String month = (String) request.getAttribute("month");
	String year = (String) request.getAttribute("year");
%>

<div id="footer_2">
<table width="100%" frame="above" bordercolor="#333333"
	style="font-family: Verdana, Geneva, sans-serif; color: #333333; font-size: 9px">
	<tr>
		<td>Copyright É 2011 All Rights Reserved</td>
	</tr>
</table>
</div>
<div id="logoHeader" style="width: 100%"><img name=""
	src="../images/header2.png" width="100%" height="115" alt="" /></div>
<div id="pageLabel" style="width: 100%;">
<table width="100%" border="0">
	<tr>
		<td width="10%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">View
				Item</td>
			</tr>
		</table>
		</td>
		<td width="86%">&nbsp;</td>
		<td width="4%">
		<form id="form15" name="form15" method="post"
			action="../items/SearchAllItems.do"><input name="backBtn"
			type="submit" class="button" id="backBtn" value="Back" /></form>
		</td>
	</tr>
</table>
</div>
<div id="logoutiv" style="width: 90%">
<form id="form2" name="form2" method="post" action="../../logout"><input
	name="logout" type="submit" class="maroon" id="logout" value="Logout" />
</form>
</div>
<div id="headerdiv"
	style="text-align: left; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Item
Information</div>
<div id="background" style="background-color: #EEE0E5;"></div>
<div id="name">
<form action="" method="post" name="form1" id="form1">
<p>&nbsp;</p>
<p>&nbsp;</p>

<div id="apDiv12"><label for="itemDescription3" class="texts">Description:</label>
<textarea name="itemDescription" cols="30" disabled="disabled"
	id="itemDescription3"><%=item.getDescription()%></textarea></div>
<div id="apDiv11"><label for="itemUnit" class="texts">Unit:</label>
<select name="itemUnit" disabled="disabled" id="itemUnit">
	<option selected="selected"><%=item.getUnit()%></option>
</select></div>
<div id="apDiv13"><label for="itemPrice3" class="texts">Price:</label>
<input name="itemPrice" type="text" disabled="disabled"
	value="<%="" + item.getPrice()%>" id="itemPrice3" size="10" /></div>
<div id="apDiv14"><label for="month3" class="texts">Date
Acquired:</label> <select name="month" disabled="disabled" id="month3">
	<%
		if (month != null) {
	%>
	<option selected="selected"><%=month%></option>
	<%
		} else {
	%>
	<option selected="selected">MM</option>
	<%
		}
	%>

</select> <select name="dayAcquired" disabled="disabled" id="dayAcquired">
	<%
		if (day != null) {
	%>
	<option selected="selected"><%=day%></option>
	<%
		} else {
	%>
	<option selected="selected">DD</option>
	<%
		}
	%>
</select> <select name="yearAcquired" disabled="disabled" id="yearAcquired">
	<%
		if (year != null) {
	%>
	<option selected="selected"><%=year%></option>
	<%
		} else {
	%>
	<option selected="selected">YYYY</option>
	<%
		}
	%>
</select></div>
<p>&nbsp;</p>
<div id="apDiv21"><label for="itemCategory" class="texts">Category:</label>
<select name="itemCategory" disabled="disabled" id="itemCategory">
	<option><%=item.getItemCategory().getName()%></option>
</select></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv15"><label for="stockNumber2" class="texts">Stock
Number:</label> <input name="stockNumber" type="text" disabled="disabled"
	value="<%=item.getStockNumber()%>" id="stockNumber2" size="20" /></div>
<div id="apDiv16"><label for="inventoryItemNum2" class="texts">Inv.
Item Number:</label> <input type="text" name="inventoryItemNum"
	disabled="disabled" value="<%=item.getInventoryItemNumber()%>"
	id="inventoryItemNum2" /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv17"><label for="itemPropertyNumber2" class="texts">Property
Number:</label> <input type="text" name="itemPropertyNumber" disabled="disabled"
	value="<%=item.getPropertyNumber()%>" id="itemPropertyNumber2" /></div>
<p>&nbsp;</p>
<div id="apDiv18"><label for="itemStatus2" class="texts">Item
Status:</label> <select name="itemStatus" disabled="disabled" id="itemStatus2">

	<option selected="selected"><%=item.getItemStatus().getName()%></option>
</select></div>
<p>&nbsp;</p>
<div id="apDiv19"><label for="itemCondition2" class="texts">Item
Condition:</label> <select name="itemCondition" disabled="disabled"
	id="itemCondition2">
	<option selected="selected"><%=item.getItemCondition().getName()%></option>
</select></div>
<p>&nbsp;</p>
<div id="apDiv20"><input type="submit" name="addItemBtn"
	id="addItemBtn"
	style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;"
	value="Update" disabled = "disabled"/></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</form>
</div>
<div id="footer"></div>
<p>&nbsp;</p>
</body>
</html>
