<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
.maroon {
	font-size: 14px;
	font-family: Lucida Grande;
	background-color: #EEE0E5;
	color: #030;
	border-left: 1px solid lightgray;
	border-right: 1px solid lightgray;
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

.maroon:hover {
	font-weight: bold;
	color: #060;
	/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
	border-right: 1px solid #7B1113;
	border-top: 1px solid #7B1113;
	border-bottom: 1px solid #7B1113;
}

.button {
	height: 20px;
	width: 405px;
	font-size: 14px;
	font-family: Lucida Grande;
	background-color: #EEE0E5;
	color: #030;
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

.button2 {
	height: 20px;
	width: 305px;
	font-size: 14px;
	font-family: Lucida Grande;
	background-color: #EEE0E5;
	color: #030;
	border-left: 1px solid lightgray;
	border-right: 1px solid lightgray;
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

.labels {
	background-color: #CCC;
	font-family: Lucida Grande;
	font-size: 14px;
	text-align: center;
}

.button2:hover {
	font-weight: bold;
	color: #060;
	/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
	border-right: 1px solid #7B1113;
	border-top: 1px solid #7B1113;
	border-bottom: 1px solid #7B1113;
}

#formsDiv {
	position: absolute;
	width: 405px;
	height: 23px;
	z-index: 1;
	left: 494px;
	top: 262px;
}

#stocksDiv {
	position: absolute;
	width: 405px;
	height: 23px;
	z-index: 3;
	left: 496px;
	top: 373px;
}

#entitiesDiv {
	position: absolute;
	width: 405px;
	height: 23px;
	z-index: 4;
	left: 496px;
	top: 463px;
}

#accountDiv {
	position: absolute;
	width: 405px;
	height: 23px;
	z-index: 6;
	left: 498px;
	top: 637px;
}

#stocksMenuDiv {
	position: absolute;
	width: 405px;
	height: 45px;
	z-index: 7;
	left: 489px;
	top: 133px;
}

#databaseDiv {
	position: absolute;
	width: 405px;
	height: 23px;
	z-index: 9;
	left: 499px;
	top: 737px;
}

#welcomeDiv {
	position: absolute;
	width: 200px;
	height: 44px;
	z-index: 11;
	left: 16px;
	top: 179px;
}

#gap {
	position: absolute;
	width: 405px;
	height: 23px;
	z-index: 12;
	left: 83px;
	top: 363px;
}

#createNewAcctDiv {
	position: absolute;
	width: 385px;
	height: 23px;
	z-index: 14;
	left: 498px;
	top: 661px;
}

#viewAcctDiv {
	position: absolute;
	width: 200px;
	height: 23px;
	z-index: 15;
	left: 498px;
	top: 682px;
}

#viewSysLogdiv {
	position: absolute;
	width: 200px;
	height: 24px;
	z-index: 16;
	left: 499px;
	top: 761px;
}

#backupDiv {
	position: absolute;
	width: 200px;
	height: 23px;
	z-index: 17;
	left: 499px;
	top: 782px;
}

#recoverdbDiv {
	position: absolute;
	width: 200px;
	height: 23px;
	z-index: 18;
	left: 499px;
	top: 803px;
}

#itemDiv {
	position: absolute;
	width: 200px;
	height: 23px;
	z-index: 19;
	left: 494px;
	top: 286px;
}

#appDiv {
	position: absolute;
	width: 200px;
	height: 24px;
	z-index: 20;
	left: 494px;
	top: 307px;
}

#apDiv1 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 21;
}

#inventoryDiv {
	position: absolute;
	width: 200px;
	height: 23px;
	z-index: 21;
	left: 494px;
	top: 328px;
}

#stockLabelDiv {
	position: absolute;
	width: 406px;
	height: 74px;
	z-index: 22;
	left: 497px;
	top: 487px;
}

#fillupDiv {
	position: absolute;
	width: 200px;
	height: 23px;
	z-index: 23;
	left: 496px;
	top: 397px;
}

#viewFormDiv {
	position: absolute;
	width: 200px;
	height: 23px;
	z-index: 24;
	left: 496px;
	top: 418px;
}

#apDiv3 {
	position: absolute;
	width: 200px;
	height: 23px;
	z-index: 25;
	left: 596px;
	top: 488px;
}

#supplierDiv {
	position: absolute;
	width: 200px;
	height: 23px;
	z-index: 26;
	left: 596px;
	top: 509px;
}

#buildingDiv {
	position: absolute;
	width: 200px;
	height: 23px;
	z-index: 27;
	left: 961px;
	top: 337px;
}

#divisionOfficeDiv {
	position: absolute;
	width: 200px;
	height: 23px;
	z-index: 28;
	left: 596px;
	top: 536px;
}

#employeeDiv {
	position: absolute;
	width: 200px;
	height: 24px;
	z-index: 29;
	left: 596px;
	top: 557px;
}

#apDiv4 {
	position: absolute;
	width: 99px;
	height: 41px;
	z-index: 30;
	left: 496px;
	top: 488px;
}

#recordsDiv {
	position: absolute;
	width: 99px;
	height: 42px;
	z-index: 31;
	left: 496px;
	top: 536px;
}

#logoHeader {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 1;
}

#apDiv2 {
	position: absolute;
	width: 200px;
	height: 30px;
	z-index: 15;
	left: 14px;
	top: 143px;
}

#footer {
	position: absolute;
	left: 1px;
	top: 918px;
	width: 100%;
}
</style>
</head>

<body>
<div id="footer">
<table width="100%" frame="above" bordercolor="#333333"
	style="font-family: Verdana, Geneva, sans-serif; color: #333333; font-size: 9px">
	<tr>
		<td>Copyright © 2011 All Rights Reserved</td>
	</tr>
</table>
</div>
<div id="logoHeader" style="width: 100%"><img name=""
	src="images/header2.png" width="100%" height="115" alt="" /></div>

<div id="databaseDiv"
	style="text-align: center; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Database</div>
<div id="accountDiv"
	style="text-align: center; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Account</div>

<div id="welcomeDiv">
<table width="100%" frame="below"
	style="color: #003300; font-family: Lucida Grande; font-size: 22px; font-weight: bold">
	<tr>
		<td>Welcome, <%
			if (session.getAttribute("userName") == null) {
				out.print(request.getAttribute("userName"));
				session.setAttribute("userName", request.getAttribute("userName"));
			}
		%>!</td>
	</tr>
</table>
</div>
<p>&nbsp;</p>

<p>&nbsp;</p>
<div id="formsDiv"
	style="background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">
<div align="center">Stocks</div>
</div>
<div id="entitiesDiv"
	style="text-align: center; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Entities</div>
<p>&nbsp;</p>
<div id="createNewAcctDiv">
<form id="form1" name="form1" method="post"
	action="accounts/CreateAccount.html"><input
	name="createNewAcctBtn" type="submit" class="button"
	id="createNewAcctBtn" value="Create New" /></form>
</div>
<div id="viewAcctDiv">
<form id="viewAcct" name="viewAcctForm" method="post"
	action="accounts/ViewAccounts.do"><input name="viewAcctsBtn"
	type="submit" class="button" id="viewAcctsBtn" value="View Accounts" />
</form>
</div>
<div id="viewSysLogdiv">
<form id="form2" name="form2" method="post" action=""><input
	name="viewSysLogBtn" type="submit" class="button" id="viewSysLogBtn"
	value="View System Log" /></form>
</div>
<div id="backupDiv">
<form id="form3" name="form3" method="post" action=""><input
	name="backupBtn" type="submit" class="button" id="backupBtn"
	value="Backup" /></form>
</div>
<div id="recoverdbDiv">
<form id="form4" name="form4" method="post" action=""><input
	name="recoverdbBtn" type="submit" class="button" id="recoverdbBtn"
	value="Recover" /></form>
</div>
<div id="itemDiv">
<form id="form5" name="form5" method="post"
	action="stocks/items/SearchItems.html"><input name="itemBtn"
	type="submit" class="button" id="itemBtn" value="Item" /></form>
</div>
<div id="appDiv">
<form id="form6" name="form6" method="post" action=""><input
	name="appBtn" type="submit" class="button" id="appBtn" value="APP" />
</form>
</div>
<div id="inventoryDiv">
<form id="form7" name="form7" method="post" action=""><input
	name="inventoryBtn" type="submit" class="button" id="inventoryBtn"
	value="Inventory" /></form>
</div>
<div id="fillupDiv">
<form id="form8" name="form8" method="post"
	action="forms/view forms/IIRUP Form.html"><input
	name="fillupBtn" type="submit" class="button" id="fillupBtn"
	value="Fillup" /></form>
</div>
<div id="viewFormDiv">
<form id="form9" name="form9" method="post" action=""><input
	name="viewFormBtn" type="submit" class="button" id="viewFormBtn"
	value="View" /></form>
</div>
<div id="apDiv3">
<form id="form10" name="form10" method="post" action=""><input
	name="stockPropBtn" type="submit" class="button2" id="stockPropBtn"
	value="Stock Properties" /></form>
</div>
<div id="divisionOfficeDiv">
<form id="form13" name="form13" method="post"
	action="entities/division/ViewDivisionBldgOffice.html"><input
	name="divisionOfficeBtn" type="submit" class="button2"
	id="divisionOfficeBtn" value="Building/Division/Office" /></form>
</div>
<div id="employeeDiv">
<form id="form14" name="form14" method="post"
	action="entities/employees/SearchEmployee.html"><input
	name="employeeBtn" type="submit" class="button2" id="employeeBtn"
	value="Employees" /></form>
</div>
<div id="apDiv4" class="labels"><br />
Stocks:</div>
<div class="labels" id="recordsDiv"><br />
Records:</div>
<div id="apDiv2">
<form id="form12" name="form12" method="post" action=""><input
	name="logoutBtn" type="submit" class="maroon" id="logoutBtn"
	value="Logout" /></form>
</div>
<p>&nbsp;</p>
<div id="stocksDiv"
	style="text-align: center; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Forms</div>
<div id="supplierDiv">
<form id="form11" name="form11" method="post" action=""><input
	name="supplierBtn" type="submit" class="button2" id="supplierBtn"
	value="Supplier" /></form>
</div>
</body>
</html>
