<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Fillup WMR</title>
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
<link href="../css/item_table.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="headerBkgrnd"><img src="../images/headerbar.png" width="100%" height="129" /></div>
<div id="logo"><img src="../images/headerlogo.png" width="124" height="128" /></div>
<div id="headerName"><img src="../images/headertext.png" width="452" height="44" /></div>
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
    <td id="navigation"><a href="#" target="_top" class="links">Main Menu</a> &gt; <a href="#" target="_top" class="links">WMR List</a> &gt; <em><strong>Fillup WMR</strong></em><strong></strong></td>
    <td>&nbsp;</td>
  </tr>
</table>
<!--<form name="PRForm" method="post" action="">-->
  <div id="items_table">
    
    <table width="100%" border="0" cellspacing="0">
      <tr>
        <td colspan="2"><table width="100%" border="0" cellspacing="0" class="tableheaders_forms">
          <tr>
            <td rowspan="2"><input type="checkbox" name="selectAllItems" id="selectAllItems" /></td>
            <td rowspan="2">Quantity</td>
            <td rowspan="2">Unit</td>
            <td rowspan="2">Description</td>
            <td colspan="2"><strong>RECORD OF SALES</strong></td>
          </tr>
          <tr>
            <td>O.R. No.</td>
            <td>Amount</td>
          </tr>
          <tr class="tablerow_1">
            <td>&nbsp;</td>
            <td><input name="quantity" type="text" class="required" id="quantity" size="2" /></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><input name="ORNum" type="text" class="required" id="ORNum" size="10" /></td>
            <td>&nbsp;</td>
          </tr>
          <tr class="bkgrnd_white">
            <td width="3%">&nbsp;</td>
            <td width="7%">&nbsp;</td>
            <td width="9%">&nbsp;</td>
            <td width="54%">&nbsp;</td>
            <td width="14%">&nbsp;</td>
            <td width="13%">&nbsp;</td>
            </tr>
        </table></td>
      </tr>
      <tr>
      	<td colspan="2">&nbsp;</td>
       </tr>
       <tr>
      	<td colspan="2">&nbsp;</td>
       </tr>
      <tr>
        <td width="50%" align="right" class="same_width"><br />
          <form id="form5" name="form5" method="post" action="">
            <input name="addItemBtn" type="submit" class="button" id="addItemBtn" value="Add Item&gt;&gt;" />
          </form>
        <br /></td>
        <td align="left" class="same_width"><form id="form6" name="form6" method="post" action="">
          <input name="removeSelectedItems" type="submit" class="button" id="removeSelectedItems" value="Remove Item" />
        </form></td>
      </tr>
      <tr>
        <td colspan="2"><table width="25%" border="0" align="center" cellspacing="0">
          <tr>
            <td class="other_fields_label">Place of Storage:</td>
            <td class="right_side_table"><input type="text" name="placeOfStorage" id="placeOfStorage" /></td>
          </tr>
          <tr>
            <td class="other_fields_label">Date:</td>
            <td class="right_side_table"><input name="date" type="text" class="required" id="date" /></td>
          </tr>
          <tr>
            <td class="other_fields_label">Property Officer:</td>
            <td class="right_side_table"><select name="propertyOfficer" class="required_menulist" id="propertyOfficer">
            </select></td>
            </tr>
          <tr>
            <td class="other_fields_label">Disposal Approved:</td>
            <td class="right_side_table">&lt;?&gt;</td>
            </tr>
          <tr>
            <td class="other_fields_label">Property Inspector:</td>
            <td class="right_side_table"><select name="propertyInspector" class="required_menulist" id="propertyInspector">
            </select></td>
            </tr>
          <tr>
            <td class="other_fields_label">Witness to:</td>
            <td class="right_side_table">&lt;?&gt;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><br />
        <input name="submitBtn" type="submit" class="button" value="SUBMIT Form" /></td>
      </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
      </tr>
    </table>
    
    </div>
<!--</form>-->


<!--<div id="footer"></div>-->
</body>
</html>
