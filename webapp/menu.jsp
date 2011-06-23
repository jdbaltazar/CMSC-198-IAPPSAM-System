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
<div id="headerBkgrnd"><img src="images/headerbar.png" width="100%" height="129" /></div>
<div id="logo"><img src="images/headerlogo.png" width="124" height="128" /></div>
<div id="headerName"><img src="images/headertext.png" width="452" height="44" /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td width="32%">&nbsp;</td>
    <td width="68%"><form id="form2" name="form2" method="post" action="">
      <input name="logoutBtn" type="submit" class="logout" id="logoutBtn" value="Logout" />
    </form></td>
  </tr>
  <tr>
    <td class="welcomeNote">Welcome, &lt;user&gt;!</td>
    <td>&nbsp;</td>
  </tr>
</table>
<div id="menu_1">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td colspan="3" class="main_menu_header">Stocks</td>
    </tr>
    <tr>
      <td colspan="3"><form id="form1" name="form1" method="get" action="items">
        <input name="item" type="submit" class="menubtn" id="item" value="Item" />
      </form></td>
    </tr>
    <tr>
      <td colspan="3"><form id="form3" name="form3" method="post" action="">
        <input name="appBtn" type="submit" class="menubtn" id="appBtn" value="Annual Procurement Plan" />
      </form></td>
    </tr>
    <tr>
      <td colspan="3"><form id="form4" name="form4" method="post" action="">
        <input name="inventory" type="submit" class="menubtn" id="inventory" value="Inventory" />
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
      <td width="28%" rowspan="2" class="labels">Stocks</td>
      <td colspan="2"><form id="form7" name="form7" method="post" action="stocks/stocks/StockProperties.jsp">
        <input name="stockProperties" type="submit" class="menubtn" id="stockProperties" value="Stock Properties" />
      </form></td>
    </tr>
    <tr>
      <td width="54%"><form id="form5" name="form5" method="post" action="supplier">
        <input name="supplierBtn" type="submit" class="menubtn" id="supplierBtn" value="Supplier" />
        <input type="hidden" name="supplier-action" value="view-suppliers"/>
      </form></td>
      <td width="18%"><form id="form6" name="form6" method="post" action="supplier">
        <input name="addSupplierBtn" type="submit" class="button2" id="addSupplierBtn" value="Add&gt;&gt;" />
      	<input type="hidden" name="supplier-action" value="new-supplier"/>
      </form></td>
    </tr>
    <tr>
      <td colspan="3" height="2"></td>
    </tr>
    <tr>
      <td rowspan="3" class="labels">Records</td>
      <td><form id="form8" name="form8" method="post" action="entities/building/ViewBuildings.do">
        <input name="buildingBtn" type="submit" class="menubtn" id="buildingBtn" value="Building" />
      </form></td>
      <td><form id="form9" name="form9" method="post" action="entities/building/AddBuilding.do" >
        <input name="addBuildingBtn" type="submit" class="button2" id="addBuildingBtn" value="Add&gt;&gt;" />
      </form></td>
    </tr>
    <tr>
      <td><form id="form24" name="form24" method="post" action="entities/division/SearchDivisions.do">
        <input name="divisionOfficeBtn" type="submit" class="menubtn" id="divisionOfficeBtn" value="Division/Office" />
      </form></td>
      <td><form id="form25" name="form25" method="post" action="entities/division/AddDivision.jsp">
        <input name="addDivisionBtn" type="submit" class="button2" id="addDivisionBtn" value="Add&gt;&gt;" />
      </form></td>
    </tr>
    <tr>
      <td><form id="form26" name="form26" method="post" action="entities/employees/search_employee.do">
        <input name="employeeBtn" type="submit" class="menubtn" id="employeeBtn" value="Employee" />
      </form></td>
      <td><form id="form27" name="form27" method="post" action="entities/employees/add_employee.jsp">
        <input name="addEmployeeBtn" type="submit" class="button2" id="addEmployeeBtn" value="Add&gt;&gt;" />
      </form></td>
    </tr>
    <tr>
      <td colspan="3">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="3">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="3" class="main_menu_header">Accounts</td>
    </tr>
    <tr>
      <td colspan="3"><form id="form10" name="form10" method="post" action="accounts/CreateAccount.jsp">
        <input name="createNew" type="submit" class="menubtn" id="createNew" value="Create New" />
      </form></td>
    </tr>
    <tr>
      <td colspan="3"><form id="form11" name="form11" method="post" action="accounts/ViewAccounts.do">
        <input name="viewAccts" type="submit" class="menubtn" id="viewAccts" value="View Accounts" />
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
      <td colspan="3"><form id="form12" name="form12" method="post" action="">
        <input name="viewSysLog" type="submit" class="menubtn" id="viewSysLog" value="View System Log" />
      </form></td>
    </tr>
    <tr>
      <td colspan="3"><form id="form13" name="form13" method="post" action="database/backup.sql">
        <input name="backup" type="submit" class="menubtn" id="backup" value="Backup" />
      </form></td>
    </tr>
    <tr>
      <td colspan="3">&nbsp;</td>
    </tr>
  </table>
</div>
<div id="menu_1_forms">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td colspan="2" class="main_menu_header">Forms</td>
    </tr>
    <tr>
      <td width="82%"><form id="form14" name="form14" method="post" action="">
        <input name="appBtn2" type="submit" class="menubtn" id="appBtn2" value="Annual Procurement Plan" />
      </form></td>
      <td width="18%"><form id="form15" name="form15" method="post" action="">
        <input name="addAppBtn" type="submit" class="button2" id="addAppBtn" value="Add&gt;&gt;" />
      </form></td>
    </tr>
    <tr>
      <td><form id="form16" name="form16" method="post" action="/pr">
        <input name="prBtn" type="submit" class="menubtn" id="prBtn" value="Purchase Request" />
      </form></td>
      <td align="center"><form id="form17" name="form17" method="post" action="/pr?new=pr">
        <input name="addPr" type="submit" class="button2" id="addPr" value="Add&gt;&gt;" />
      </form></td>
    </tr>
    <tr>
      <td><form id="form18" name="form18" method="post" action="">
        <input name="purchaseOrder" type="submit" class="menubtn" id="purchaseOrder" value="Purchase Order" />
      </form></td>
      <td align="center"><form id="form19" name="form19" method="post" action="">
        <input name="addPo" type="submit" class="button2" id="addPo" value="Add&gt;&gt;" />
      </form></td>
    </tr>
    <tr>
      <td><form id="form20" name="form20" method="post" action="">
        <input name="risBtn" type="submit" class="menubtn" id="risBtn" value="Requisition &amp; Issue Slip" />
      </form></td>
      <td align="center"><form id="form21" name="form21" method="post" action="">
        <input name="addBtn" type="submit" class="button2" id="addBtn" value="Add&gt;&gt;" />
      </form></td>
    </tr>
    <tr>
      <td><form id="form22" name="form22" method="post" action="">
        <input name="ieBtn" type="submit" class="menubtn" id="ieBtn" value="Inventory of Equipment" />
      </form></td>
      <td align="center"><form id="form23" name="form23" method="post" action="">
        <input name="addIE" type="submit" class="button2" id="addIE" value="Add&gt;&gt;" />
      </form></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">&nbsp;</td>
    </tr>
  </table>
</div>
<!--<div id="footer"></div>-->
</body>
</html>
