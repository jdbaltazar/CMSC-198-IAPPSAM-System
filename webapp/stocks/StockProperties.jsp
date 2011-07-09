<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Stock Properties</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="headerBkgrnd"><img src="../../images/headerbar.png" width="100%" height="129" /></div>
<div id="logo"><img src="../../images/headerlogo.png" width="124" height="128" /></div>
<div id="headerName"><img src="../../images/headertext.png" width="452" height="44" /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td width="32%">&nbsp;</td>
    <td width="68%"><form id="form2" name="form2" method="post" action="../../logout">
      <input name="logoutBtn" type="submit" class="logout" id="logoutBtn" value="Logout" />
    </form></td>
  </tr>
  <tr>
    <td id="navigation"><a href="menu" target="_top" class="links" >Main Menu</a> &gt;<em><strong>Stock Properties</strong></em></td>
    <td>&nbsp;</td>
  </tr>
</table>
<div id="menu_2">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2" class="header_rows"><div class="header_2">Item Properties</div></td>
    </tr>
    <tr>
      <td width="78%"><form id="form1" name="form1" method="get" action="stocks/item-unit">
        <input name="itemUnit" type="submit" class="menubtn" id="itemUnit" value="Item Unit" />
        <input type="hidden" name="item-unit-action" value="view-item-units" />
      </form></td>
      <td width="22%"><form id="form3" name="form3" method="get" action="stocks/item-unit">
        <input name="addItemUnitBtn" type="submit" class="button2" id="addItemUnitBtn" value="Add&gt;&gt;" />
        <input type="hidden" name="item-unit-action" value="add-item-unit" />
      </form></td>
    </tr>
    <tr>
      <td><form id="form4" name="form4" method="post" action="ViewItemStatuses.do">
        <input name="itemStatus" type="submit" class="menubtn" id="itemStatus" value="Item Status" />
      </form></td>
      <td><form id="form5" name="form5" method="post" action="AddItemStatus.jsp">
        <input name="addItemStatus" type="submit" class="button2" id="addItemStatus" value="Add&gt;&gt;" />
      </form></td>
    </tr>
    <tr>
      <td><form id="form6" name="form6" method="post" action="ViewItemCategories.do">
        <input name="itemCategory" type="submit" class="menubtn" id="itemCategory" value="Item Category" />
      </form></td>
      <td><form id="form7" name="form7" method="post" action="AddItemCategory.jsp">
        <input name="addCategoryBtn" type="submit" class="button2" id="addCategoryBtn" value="Add&gt;&gt;" />
      </form></td>
    </tr>
    <tr>
      <td><form id="form8" name="form8" method="post" action="ViewItemConditions.do">
        <input name="itemCondition" type="submit" class="menubtn" id="itemCondition" value="Item Condition" />
      </form></td>
      <td><form id="form9" name="form9" method="post" action="AddItemCondition.jsp">
        <input name="addCondition" type="submit" class="button2" id="addCondition" value="Add&gt;&gt;" />
      </form></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" class="header_rows"><div class="header_2">Others</div></td>
    </tr>
    <tr>
      <td><form id="form10" name="form10" method="post" action="ViewDisposals.do">
        <input name="disposal" type="submit" class="menubtn" id="disposal" value="Disposal" />
      </form></td>
      <td><form id="form11" name="form11" method="post" action="AddDisposal.jsp">
        <input name="addDisposal" type="submit" class="button2" id="addDisposal" value="Add&gt;&gt;" />
      </form></td>
    </tr>
    <tr>
      <td><form id="form12" name="form12" method="post" action="ViewModesOfProcurement.do">
        <input name="modeOfProcurement" type="submit" class="menubtn" id="modeOfProcurement" value="Mode of Procurement" />
      </form></td>
      <td><form id="form13" name="form13" method="post" action="AddModeOfProc.jsp">
        <input name="addProcurement" type="submit" class="button2" id="addProcurement" value="Add&gt;&gt;" />
      </form></td>
    </tr>
  </table>
</div>
<!--<div id="footer"></div>-->
</body>
</html>
