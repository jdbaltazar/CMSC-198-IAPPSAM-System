<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.entities.Item"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href=".favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: View Item</title>
<link href="/items/view.css" rel="stylesheet" type="text/css" />
<link href="../style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="/logo.jsp" />
	<jsp:include page="/logout-button.jsp" />

	<!-- Breadcrumbs -->
	<div class="Breadcrumbs">
		<a href="/menu">Menu</a> > <a href="/items">Items</a> > <a href="/items?id=${item.id}">View Item</a>
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
				<textarea name="itemDescription" cols="30" disabled="disabled" id="itemDescription3">${item.description}</textarea>
			</div>
			<div id="apDiv11">
				<label for="itemUnit" class="texts">Unit:</label> <select name="itemUnit" disabled="disabled" id="itemUnit">
					<option selected="selected">${item.unit.name}</option>
				</select>
			</div>
			<div id="apDiv13">
				<label for="itemPrice3" class="texts">Price:</label> <input name="itemPrice" type="text" disabled="disabled" value="${item.price}" id="itemPrice3"
					size="10"
				/>
			</div>
			<div id="apDiv14">
				<label for="month3" class="texts">Date Acquired:</label> <select name="month" disabled="disabled" id="month3">
					<option selected="selected">${item.dateAcquired.month}</option>


				</select> <select name="dayAcquired" disabled="disabled" id="dayAcquired">
					<option selected="selected">${item.dateAcquired.day}</option>

				</select> <select name="yearAcquired" disabled="disabled" id="yearAcquired">
					<option selected="selected">${date.dateAcquired.year}</option>
				</select>
			</div>
			<p>&nbsp;</p>
			<div id="apDiv21">
				<label for="itemCategory" class="texts">Category:</label> <select name="itemCategory" disabled="disabled" id="itemCategory">
					<option>${item.itemCategory.name}</option>
				</select>
			</div>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<div id="apDiv15">
				<label for="stockNumber2" class="texts">Stock Number:</label> <input name="stockNumber" type="text" disabled="disabled"
					value="${item.stockNumber}" id="stockNumber2" size="20"
				/>
			</div>
			<div id="apDiv16">
				<label for="inventoryItemNum2" class="texts">Inv. Item Number:</label> <input type="text" name="inventoryItemNum" disabled="disabled"
					value="${item.inventoryItemNumber}" id="inventoryItemNum2"
				/>
			</div>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<div id="apDiv17">
				<label for="itemPropertyNumber2" class="texts">Property Number:</label> <input type="text" name="itemPropertyNumber" disabled="disabled"
					value="${item.propertyNumber}" id="itemPropertyNumber2"
				/>
			</div>
			<p>&nbsp;</p>
			<div id="apDiv18">
				<label for="itemStatus2" class="texts">Item Status:</label> <select name="itemStatus" disabled="disabled" id="itemStatus2">

					<option selected="selected">${item.itemStatus.name}</option>
				</select>
			</div>
			<p>&nbsp;</p>
			<div id="apDiv19">
				<label for="itemCondition2" class="texts">Item Condition:</label> <select name="itemCondition" disabled="disabled" id="itemCondition2">
					<option selected="selected">${item.itemCondition.name}%></option>
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
