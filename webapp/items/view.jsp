<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.entities.Item"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href=".favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: View Item</title>

</head>

<body>
	<%
		Item item = (Item) request.getAttribute("item");
		String day = (String) request.getAttribute("day");
		String month = (String) request.getAttribute("month");
		String year = (String) request.getAttribute("year");
	%>


	<div id="logoHeader" style="width: 100%">
		<img name="" src="../images/header2.png" width="100%" height="115" alt="" />
	</div>
	<div id="pageLabel" style="width: 100%;">
		<table width="100%" border="0">
			<tr>
				<td width="10%">
					<table width="100%" frame="below">
						<tr>
							<td style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">View Item</td>
						</tr>
					</table>
				</td>
				<td width="86%">&nbsp;</td>
				<td width="4%">
					<form id="form15" name="form15" method="post" action="/items/SearchAllItems.do">
						<input name="backBtn" type="submit" class="button" id="backBtn" value="Back" />
					</form>
				</td>
			</tr>
		</table>
	</div>

	<jsp:include page="/logout-button.jsp" />

	<div id="headerdiv" style="text-align: left; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Item Information</div>
	<div id="background" style="background-color: #EEE0E5;"></div>
	<div id="name">
		<form action="" method="post" name="form1" id="form1">
			<p>&nbsp;</p>
			<p>&nbsp;</p>

			<div id="apDiv12">
				<label for="itemDescription3" class="texts">Description:</label>
				<textarea name="itemDescription" cols="30" disabled="disabled" id="itemDescription3"><%=item.getDescription()%></textarea>
			</div>
			<div id="apDiv11">
				<label for="itemUnit" class="texts">Unit:</label> <select name="itemUnit" disabled="disabled" id="itemUnit">
					<option selected="selected"><%=item.getUnit()%></option>
				</select>
			</div>
			<div id="apDiv13">
				<label for="itemPrice3" class="texts">Price:</label> <input name="itemPrice" type="text" disabled="disabled" value="<%="" + item.getPrice()%>"
					id="itemPrice3" size="10"
				/>
			</div>
			<div id="apDiv14">
				<label for="month3" class="texts">Date Acquired:</label> <select name="month" disabled="disabled" id="month3">
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
				</select>
			</div>
			<p>&nbsp;</p>
			<div id="apDiv21">
				<label for="itemCategory" class="texts">Category:</label> <select name="itemCategory" disabled="disabled" id="itemCategory">
					<option><%=item.getItemCategory().getName()%></option>
				</select>
			</div>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<div id="apDiv15">
				<label for="stockNumber2" class="texts">Stock Number:</label> <input name="stockNumber" type="text" disabled="disabled"
					value="<%=item.getStockNumber()%>" id="stockNumber2" size="20"
				/>
			</div>
			<div id="apDiv16">
				<label for="inventoryItemNum2" class="texts">Inv. Item Number:</label> <input type="text" name="inventoryItemNum" disabled="disabled"
					value="<%=item.getInventoryItemNumber()%>" id="inventoryItemNum2"
				/>
			</div>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<div id="apDiv17">
				<label for="itemPropertyNumber2" class="texts">Property Number:</label> <input type="text" name="itemPropertyNumber" disabled="disabled"
					value="<%=item.getPropertyNumber()%>" id="itemPropertyNumber2"
				/>
			</div>
			<p>&nbsp;</p>
			<div id="apDiv18">
				<label for="itemStatus2" class="texts">Item Status:</label> <select name="itemStatus" disabled="disabled" id="itemStatus2">

					<option selected="selected"><%=item.getItemStatus().getName()%></option>
				</select>
			</div>
			<p>&nbsp;</p>
			<div id="apDiv19">
				<label for="itemCondition2" class="texts">Item Condition:</label> <select name="itemCondition" disabled="disabled" id="itemCondition2">
					<option selected="selected"><%=item.getItemCondition().getName()%></option>
				</select>
			</div>
			<p>&nbsp;</p>
			<div id="apDiv20">
				<input type="submit" name="addItemBtn" id="addItemBtn"
					style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;" value="Update" disabled="disabled"
				/>
			</div>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</form>
	</div>
	<jsp:include page="/copyright.jsp" />
</body>
</html>
