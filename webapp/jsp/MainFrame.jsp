<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
#formsDiv {
	position: absolute;
	width: 405px;
	height: 23px;
	z-index: 1;
	left: 457px;
	top: 101px;
}

#formsMenuDiv {
	position: absolute;
	width: 405px;
	height: 30px;
	z-index: 2;
	left: 457px;
	top: 126px;
}

#formsMenuDiv a {
	text-decoration: none;
	font-family: Verdana, Geneva, sans-serif;
	font-size: 12px;
	background-color: transparent;
	color: #003300;
}

#formsMenuDiv a:hover {
	font-family: Verdana, Geneva, sans-serif;
	font-weight: bold;
	font-size: 14px;
	background-color: transparent;
}

#stocksDiv {
	position: absolute;
	width: 405px;
	height: 23px;
	z-index: 3;
	left: 457px;
	top: 169px;
}

#entitiesDiv {
	position: absolute;
	width: 405px;
	height: 23px;
	z-index: 4;
	left: 457px;
	top: 254px;
}

#entitiesMenuDiv {
	position: absolute;
	width: 405px;
	height: 78px;
	z-index: 5;
	left: 457px;
	top: 277px;
}

#entitiesMenuDiv a {
	text-decoration: none;
	font-family: Verdana, Geneva, sans-serif;
	font-size: 12px;
	background-color: transparent;
	color: #003300;
}

#entitiesMenuDiv a:hover {
	font-family: Verdana, Geneva, sans-serif;
	font-weight: bold;
	font-size: 14px;
	background-color: transparent;
}

#accountDiv {
	position: absolute;
	width: 405px;
	height: 23px;
	z-index: 6;
	left: 457px;
	top: 356px;
}

#stocksMenuDiv {
	position: absolute;
	width: 405px;
	height: 58px;
	z-index: 7;
	left: 457px;
	top: 194px;
}

#stocksMenuDiv a {
	text-decoration: none;
	font-family: Verdana, Geneva, sans-serif;
	font-size: 12px;
	background-color: transparent;
	color: #003300;
}

#stocksMenuDiv a:hover {
	font-family: Verdana, Geneva, sans-serif;
	font-weight: bold;
	font-size: 14px;
	background-color: transparent;
}

#accountMenuDiv {
	position: absolute;
	width: 405px;
	height: 58px;
	z-index: 8;
	left: 457px;
	top: 381px;
}

#accountMenuDiv a {
	text-decoration: none;
	font-family: Verdana, Geneva, sans-serif;
	font-size: 12px;
	background-color: transparent;
	color: #003300;
}

#accountMenuDiv a:hover {
	font-family: Verdana, Geneva, sans-serif;
	font-weight: bold;
	font-size: 14px;
	background-color: transparent;
}

#databaseDiv {
	position: absolute;
	width: 405px;
	height: 23px;
	z-index: 9;
	left: 457px;
	top: 439px;
}

#databaseMenuDiv {
	position: absolute;
	width: 405px;
	height: 58px;
	z-index: 10;
	left: 457px;
	top: 463px;
}

#databaseMenuDiv a {
	text-decoration: none;
	font-family: Verdana, Geneva, sans-serif;
	font-size: 12px;
	background-color: transparent;
	color: #003300;
}

#databaseMenuDiv a:hover {
	font-family: Verdana, Geneva, sans-serif;
	font-weight: bold;
	font-size: 14px;
	background-color: transparent;
}

#welcomeDiv {
	position: absolute;
	width: 200px;
	height: 44px;
	z-index: 11;
	left: 22px;
	top: 22px;
}

#gap {
	position: absolute;
	width: 405px;
	height: 23px;
	z-index: 12;
	left: 457px;
	top: 520px;
}

#logout {
	position: absolute;
	width: 405px;
	height: 20px;
	z-index: 13;
	left: 457px;
	top: 545px;
}

#logout a {
	text-decoration: none;
	font-family: Verdana, Geneva, sans-serif;
	font-size: 12px;
	background-color: transparent;
	color: #003300;
}

#logout a:hover {
	font-family: Verdana, Geneva, sans-serif;
	font-weight: bold;
	font-size: 14px;
	background-color: transparent;
}
</style>
</head>

<body>
<div id="databaseDiv"
	style="text-align: center; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Database</div>
<div id="accountDiv"
	style="text-align: center; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Account</div>
<div id="databaseMenuDiv">
<div align="center" style="background-color: #EEE0E5;"><a href="#"
	title="viewLogLink">View System Log</a><br />
<a href="#" title="backup">Back-up</a> <br />
<a href="#" title="restore">Restore</a></div>
</div>
<div id="welcomeDiv">
<table width="100%" frame="below"
	style="color: #003300; font-family: Lucida Grande; font-size: 22px; font-weight: bold">
	<tr>
		<td>Welcome, <%=(String) request.getAttribute("name")%></td>
	</tr>
</table>
</div>
<p>&nbsp;</p>
<div id="formsDiv"
	style="background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">
<div align="center">Forms</div>
</div>
<div id="entitiesDiv"
	style="text-align: center; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Entities</div>
<div id="entitiesMenuDiv">
<div align="center" style="background-color: #EEE0E5;"><a href="#"
	title="employeeLink">Employee</a><br />
<a href="#" title="divisionLink">Division</a> <br />
<a href="#" title="supplierLink">Supplier</a> <br />
<a href="#" title="bldgLink">Building</a></div>
</div>
<div id="accountMenuDiv">
<div align="center" style="background-color: #EEE0E5;"><a
	href="accounts/CreateAccount.html" title="createNewLink"
	target="main_frame">Create New</a><br />
<a href="#" title="searchLink">Search</a> <br />
<a href="#" title="editAcctLink">Edit Account</a></div>
</div>
<p>&nbsp;</p>
<div id="gap"
	style="text-align: center; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold"></div>
<p>&nbsp;</p>
<div id="stocksDiv"
	style="text-align: center; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Stocks</div>
<div id="formsMenuDiv" align="center" style="background-color: #EEE0E5;"><a
	href="forms/Fillup.html" title="fillup" target="main_frame">Fill-up</a><br />
<a href="#" title="viewForms" target="_self">View</a></div>
<div id="stocksMenuDiv">
<div align="center" style="background-color: #EEE0E5;"><a href="#"
	title="manageItemsLink">Manage Items</a><br />
<a href="#" title="manProdCatLink">Manage Product Categories</a><br />
<a href="#" title="manageUnitsLink">Manage Units</a> <br />
</div>
</div>
<div id="logout">
<div align="center" style="background-color: #EEE0E5;"><a href="#"
	title="logout">Logout</a></div>
</div>
</body>
</html>