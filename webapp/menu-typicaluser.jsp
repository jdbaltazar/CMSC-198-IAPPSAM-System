<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
    <td colspan="2" class="welcomeNote">Welcome, &lt;user&gt;!  </td>
  </tr>
</table>
<div id="menu_others">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td colspan="2" class="main_menu_header">Forms</td>
    </tr>
    <tr>
      <td colspan="2"><form id="form1" name="form1" method="post" action="">
        <input name="purchaseRequest" type="submit" class="menubtn" id="purchaseRequest" value="Purchase Request" />
      </form></td>
    </tr>
    <tr>
      <td colspan="2"><form id="form3" name="form3" method="post" action="">
        <input name="purchaseOrder" type="submit" class="menubtn" id="purchaseOrder" value="Purchase Order" />
      </form></td>
    </tr>
    <tr>
      <td colspan="2"><form id="form4" name="form4" method="post" action="">
        <input name="app" type="submit" class="menubtn" id="app" value="Annual Procurement Plan" />
      </form></td>
    </tr>
    <tr>
      <td colspan="2"><form id="form5" name="form5" method="post" action="">
        <input name="ris" type="submit" class="menubtn" id="ris" value="Request and Issue Slip" />
      </form></td>
    </tr>
    <tr>
      <td colspan="2"><form id="form6" name="form6" method="post" action="">
        <input name="inventoryOfEquipment" type="submit" class="menubtn" id="inventoryOfEquipment" value="Inventory of Equipment" />
      </form></td>
    </tr>
    <tr>
      <td colspan="2">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" class="main_menu_header">Account</td>
    </tr>
    <tr>
      <td width="79%"><form id="form7" name="form7" method="post" action="">
        <input name="viewAccts" type="submit" class="menubtn" id="viewAccts" value="View Accounts" />
      </form></td>
      <td width="21%"><form id="form8" name="form8" method="post" action="">
        <input name="myAcct" type="submit" class="button2" id="myAcct" value="My Account" />
      </form></td>
    </tr>
  </table>
</div>
<!--<div id="footer"></div>-->
</body>
</html>

