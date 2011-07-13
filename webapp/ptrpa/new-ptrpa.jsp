<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Fillup PTRPA</title>
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
    <td id="navigation"><a href="#" target="_top" class="links">Main Menu</a> &gt; <a href="#" target="_top" class="links">PTRPA List</a> &gt; <em><strong>Fillup PTRPA</strong></em><strong></strong></td>
    <td>&nbsp;</td>
  </tr>
</table>
<!--<form name="PRForm" method="post" action="">-->
  <div id="items_table">
    
    <table width="100%" border="0" cellspacing="0">
      <tr>
        <td colspan="2"><table width="100%" border="0" cellspacing="0" class="tableheaders_forms">
          <tr>
            <td><input type="checkbox" name="selectAllItems" id="selectAllItems" /></td>
            <td>ARE/MR Number</td>
            <td>Property Number</td>
            <td>Quantity</td>
            <td>Unit</td>
            <td>Description</td>
            <td>Date Purchased</td>
            <td>Unit Value</td>
            <td>Total</td>
            <td>REMARKS</td>
          </tr>
          <tr class="tablerow_1">
            <td>&nbsp;</td>
            <td><input name="aremrNum" type="text" class="required" id="aremrNum" size="2" /></td>
            <td>&nbsp;</td>
            <td><input name="quantity" type="text" class="required" id="quantity" size="2" /></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><input type="text" name="remarks" id="remarks" width="100%" /></td>
          </tr>
          <tr class="bkgrnd_white">
            <td width="3%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <td width="7%">&nbsp;</td>
            <td width="6%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <td width="30%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <td width="7%">&nbsp;</td>
            <td width="6%">&nbsp;</td>
            <td width="17%">&nbsp;</td>
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
            <td class="other_fields_label">UP Ctrl No.:</td>
            <td class="right_side_table"><input type="text" name="upCtrlNum" id="upCtrlNum" /></td>
          </tr>
          <tr>
            <td class="other_fields_label">From:</td>
            <td class="right_side_table"><select name="from" class="required_menulist" id="from">
            </select></td>
            </tr>
          <tr>
            <td class="other_fields_label">To:</td>
            <td class="right_side_table"><select name="to" class="required_menulist" id="to">
            </select></td>
            </tr>
          <tr>
            <td class="other_fields_label">Transferred by:</td>
            <td class="right_side_table"><select name="transferredBy" class="required_menulist" id="transferredBy">
            </select></td>
          </tr>
          <tr>
            <td class="other_fields_label">Dated:</td>
            <td class="right_side_table"><input name="transferDate" type="text" class="required" id="transferDate" /></td>
            </tr>
          <tr>
            <td class="other_fields_label">Accepted by:</td>
            <td class="right_side_table"><select name="acceptedBy" class="required_menulist" id="acceptedBy">
            </select></td>
            </tr>
          <tr>
            <td class="other_fields_label">Date Accepted:</td>
            <td class="right_side_table"><input name="dateAccepted" type="text" class="required" id="dateAccepted" /></td>
          </tr>
          <tr>
            <td class="other_fields_label">Witnessed by:</td>
            <td class="right_side_table"><select name="witnessedBy" class="required_menulist" id="witnessedBy">
            </select></td>
          </tr>
          <tr>
            <td class="other_fields_label">Dated:</td>
            <td class="right_side_table"><input name="dateWitnessed" type="text" class="required" id="dateWitnessed" /></td>
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
