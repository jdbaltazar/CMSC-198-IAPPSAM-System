<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: Menu</title>
<link href="menu.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<jsp:include page="logo.jsp" />

	<!-- Welcome User -->
	<div id="welcome">Welcome, ${sessionScope.username}!</div>

	<jsp:include page="help-button.jsp" />
	<jsp:include page="logout-button.jsp" />

	<!-- Account Management-->
	<div id="account">
		<a href="/accounts?view=all">Accounts</a>
		<ul>
			<li><a href="/accounts?add=account">New Account</a>
			</li>
		</ul>
	</div>

	<div id="items">
		<a id="view-items" href="/items">Items</a>
		<ul>
			<li><a href="/items?new=item">New Item</a></li>
			<li><a href="/items?view=categories">Item Categories</a></li>
			<li><a href="/items?view=conditions">Item Conditions</a></li>
			<li><a href="/items?view=statuses">Item Statuses</a></li>
			<li><a href="/items?view=units">Units</a></li>
		</ul>
	</div>

	<div id="stocks">Stocks</div>
	<div id="database">Database</div>



	<div id="entitiesDiv">Settings</div>

	<div id="viewSysLogdiv">
		<form id="form2" name="form2" method="post" action="database/ViewSystemLog.jsp">
			<input name="viewSysLogBtn" type="submit" class="button" id="viewSysLogBtn" value="View System Log" />
		</form>
	</div>
	<div id="backupDiv">
		<form id="form3" name="form3" method="post"
			action="database/Notes.txt">
			<input name="backupBtn" type="submit" class="button" id="backupBtn"
				value="Backup" />
		</form>
	</div>
	<div id="recoverdbDiv">
		<form id="form4" name="form4" method="post" action="">
			<input name="recoverdbBtn" type="submit" class="button" id="recoverdbBtn" value="Recover" />
		</form>
	</div>


	<div id="apDiv3">
		<form id="form10" name="form10" method="post" action="stocks/stocks/StockProperties.jsp">
			<input name="stockPropBtn" type="submit" class="button2" id="stockPropBtn" value="Stock Properties" />
		</form>
	</div>
	<div id="divisionOfficeDiv">
		<form id="form13" name="form13" method="post" action="entities/division/SearchDivisions.do">
			<input name="divisionOfficeBtn" type="submit" class="button2" id="divisionOfficeBtn" value="Division/Office" />
		</form>
	</div>
	<div id="employeeDiv">
		<form id="form14" name="form14" method="post" action="entities/employees/SearchEmployee.do">
			<input name="employeeBtn" type="submit" class="button2" id="employeeBtn" value="Employees" />
		</form>
	</div>
	<div id="apDiv4" class="labels">
		<br /> Stocks:
	</div>
	<div class="labels" id="recordsDiv">
		<br /> Records:
	</div>



	<div id="supplierDiv">
		<form id="form11" name="form11" method="post" action="entities/supplier/SearchSuppliers.do">
			<input name="supplierBtn" type="submit" class="button2" id="supplierBtn" value="Supplier" />
		</form>
	</div>
	<div id="apDiv5">
		<form id="form15" name="form15" method="post"
			action="entities/building/ViewBuildings.do">
			<input name="buildingBtn" type="submit" class="button2"
				id="buildingBtn" value="Building" />
		</form>
	</div>

	<jsp:include page="copyright.jsp" />
</body>
</html>
