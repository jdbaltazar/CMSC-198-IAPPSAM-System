<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Menu</title>
<link href="css/header.css" rel="stylesheet" type="text/css" />
<link href="css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="headerBkgrnd">
		<img src="images/headerbar.png" width="100%" height="129" />
	</div>
	<div id="logo">
		<img src="images/headerlogo.png" width="124" height="128" />
	</div>
	<div id="headerName">
		<img src="images/headertext.png" width="452" height="44" />
	</div>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<table width="100%" border="0" cellspacing="0">
		<tr>
			<td width="32%"><a href="help.html" target="_blank" class="help"><img src="images/HelpIcon.gif" width="13" height="16" /> Help</a></td>
			<td width="68%"><form id="form2" name="form2" method="post"
					action="logout">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn"
						value="Logout" />
				</form> </td>
		</tr>
		<tr>
			<td class="welcomeNote">Welcome, ${account.username}!</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="menu_1">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td colspan="2" class="main_menu_header">Stocks</td>
			</tr>
			<tr>
				<td width="80%">
					<form id="form1" name="form1" method="get" action="/items">
						<input name="itemBtn" type="submit" class="menubtn" id="itemBtn"
							value="Item" />
					</form>
				</td>
				<td width="20%">
					<form id="form1" name="form1" method="get" action="/items">
						<input name="addItemBtn" type="submit" class="button2"
							id="addItemBtn" value="Add&gt;&gt;" /> <input type="hidden"
							name="new" value="item" />
					</form></td>
			</tr>
			<tr>
				<td colspan="2"><form id="form3" name="form3" method="post"
						action="stocks">
						<input type="hidden" name="stock-properties-action"
							value="view-stock-properties" /> <input name="stocksBtn"
							type="submit" class="menubtn" id="stocksBtn"
							value="Stock Properties" />
					</form></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" class="main_menu_header">Accounts</td>
			</tr>
			<tr>
				<td colspan="2"><form id="form10" name="form10" method="post"
						action="accounts">
						<input name="createAcctBtn" type="submit" class="menubtn"
							id="createAcctBtn" value="Create New" />
						<input name="account-action" type="hidden" id="account-action" value="add-account"/>
					</form></td>
			</tr>
			<tr>
				<td><form id="form11" name="form11" method="post" action="accounts">
						<input name="viewAcctsBtn" type="submit" class="menubtn"
							id="viewAcctsBtn" value="View Accounts" />
					<input name="account-action" type="hidden" id="hidden" value="view-accounts"/>
					</form></td>
				<td><form id="form29" name="form29" method="post" action="accounts">
						<input name="myAcctBtn" type="submit" class="button2"
							id="myAcctBtn" value="My Account" />
						<input name="account-action" type="hidden" id="hidden" value="view-own-account"/>
					</form></td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3" class="main_menu_header">Database</td>
			</tr>
			<tr>
				<td colspan="3"><form id="form12" name="form12" method="post"
						action="system-logs">
						<input name="viewSysLog" type="submit" class="menubtn"
							id="viewSysLog" value="View System Log" />
							<input name="system-logs-action" type="hidden" id="hidden" value="view-system-logs"/>
					</form></td>
			</tr>
			<tr>
				<td colspan="2"><form id="form13" name="form13" method="post"
						action="database/backup.sql">
						<input name="backup" type="submit" class="menubtn" id="backup"
							value="Backup" />
					</form></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
		</table>
	</div>
	<div id="menu_2">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td colspan="3" class="main_menu_header">Forms</td>
			</tr>
			<tr>
				<td colspan="2"><form id="form14" name="form14" method="post"
						action="/app">
						<input name="appBtn2" type="submit" class="menubtn" id="appBtn2"
							value="Annual Procurement Plan" />
					</form></td>
				<td width="18%"><form id="form15" name="form15" method="post"
						action="/app?new=app">
						<input name="addAppBtn" type="submit" class="button2"
							id="addAppBtn" value="Add&gt;&gt;" />
					</form></td>
			</tr>
			<tr>
				<td colspan="2"><form id="form16" name="form16" method="post"
						action="/pr">
						<input name="prBtn" type="submit" class="menubtn" id="prBtn"
							value="Purchase Request" />
					</form></td>
				<td><form id="form17" name="form17" method="post"
						action="/pr?new=pr">
						<input name="addPr" type="submit" class="button2" id="addPr"
							value="Add&gt;&gt;" />
					</form></td>
			</tr>
			<tr>
				<td colspan="2"><form id="form18" name="form18" method="post"
						action="/po">
						<input name="purchaseOrder" type="submit" class="menubtn"
							id="purchaseOrder" value="Purchase Order" />
					</form></td>
				<td><form id="form19" name="form19" method="post"
						action="/po?new=po">
						<input name="addPo" type="submit" class="button2" id="addPo"
							value="Add&gt;&gt;" />
					</form></td>
			</tr>
			<tr>
				<td colspan="2"><form id="form20" name="form20" method="post"
						action="/ris">
						<input name="risBtn" type="submit" class="menubtn" id="risBtn"
							value="Requisition &amp; Issue Slip" />
					</form></td>
				<td><form id="form21" name="form21" method="post" action="/ris?new=ris">
						<input name="addBtn" type="submit" class="button2" id="addBtn"
							value="Add&gt;&gt;" />
					</form></td>
			</tr>
			<tr>
				<td colspan="2"><form id="form22" name="form22" method="post"
						action="/ie">
						<input name="ieBtn" type="submit" class="menubtn" id="ieBtn"
							value="Inventory of Equipment" />
					</form></td>
				<td><form id="form23" name="form23" method="post" action="/ie?new=ie">
						<input name="addIE" type="submit" class="button2" id="addIE"
							value="Add&gt;&gt;" />
					</form></td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3" class="main_menu_header">Settings</td>
			</tr>
			<tr>
				<td width="26%" rowspan="4" class="labels">Records</td>
				<td width="56%"><form id="form4" name="form4" method="post"
						action="/building">
						<input name="building-action" type="hidden" value="view-buildings" />
						<input name="buildingBtn" type="submit" class="menubtn"
							id="buildingBtn" value="Building" />
					</form></td>
				<td><form id="form7" name="form7" method="post"
						action="building">
						<input name="building-action" type="hidden" value="add-building" />
						<input name="addBuilding" type="submit" class="button2"
							id="addBuilding" value="Add&gt;&gt;" />
					</form></td>
			</tr>
			<tr>
				<td><form id="form5" name="form5" method="post"
						action="supplier">
						<input type="hidden" name="supplier-action" value="view-suppliers" />
						<input name="supplierBtn" type="submit" class="menubtn"
							id="supplierBtn" value="Supplier" />
					</form></td>
				<td><form id="form6" name="form6" method="post"
						action="supplier">
						<input type="hidden" name="supplier-action" value="new-supplier" />
						<input name="addSupplierBtn" type="submit" class="button2"
							id="addSupplierBtn" value="Add&gt;&gt;" />
					</form></td>
			</tr>
			<tr>
				<td><form id="form24" name="form24" method="post"
						action="division-office">
						<input type="hidden" name="division-office-action"
							value="view-divisions" /> <input name="divisionOfficeBtn"
							type="submit" class="menubtn" id="divisionOfficeBtn"
							value="Division/Office" />
					</form></td>
				<td><form id="form25" name="form25" method="post"
						action="division-office">
						<input type="hidden" name="division-office-action"
							value="add-division" /> <input name="addDivisionBtn"
							type="submit" class="button2" id="addDivisionBtn"
							value="Add&gt;&gt;" />
					</form></td>
			</tr>
			<tr>
				<td><form id="form26" name="form26" method="get"
						action="employee">
						<input name="employeeBtn" type="submit" class="menubtn"
							id="employeeBtn" value="Employee" /> <input type="hidden"
							name="employee-action" value="search-employees" />
					</form></td>
				<td><form id="form27" name="form27" method="post"
						action="employee">
						<input name="addEmployeeBtn" type="submit" class="button2"
							id="addEmployeeBtn" value="Add&gt;&gt;" /> <input type="hidden"
							name="employee-action" value="add-employee" />
					</form></td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
		</table>
	</div>
	<!--<div id="footer"></div>-->

</body>
</html>
