<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Fillup RIS</title>
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
    <td id="navigation"><a href="menu" target="_top" class="links">Main Menu</a> &gt; <a href="/ris" target="_top" class="links">RIS List</a> &gt; <em><strong>Fillup RIS</strong></em><strong></strong></td>
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
            <td>Stock No.</td>
            <td>Unit</td>
            <td>Description</td>
            <td>Qty. Requested</td>
            <td>Qty. Issued</td>
            <td>Remarks</td>
          </tr>
          <tr class="tablerow_1">
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><input name="qtyRequested" type="text" class="required" id="qtyRequested" size="2" /></td>
            <td><label for="qtyIssued"></label>
            <input name="qtyIssued" type="text" class="required" id="qtyIssued" size="2" /></td>
            <td>&nbsp;</td>
          </tr>
          <tr class="bkgrnd_white">
            <td width="2%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <td width="50%">&nbsp;</td>
            <td width="9%">&nbsp;</td>
            <td width="9%">&nbsp;</td>
            <td width="14%">&nbsp;</td>
            </tr>
        </table></td>
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
            <td class="other_fields_label">Division/Office:</td>
            <td class="right_side_table"><select name="department/section" class="required_menulist" id="department/section">
            </select></td>
            </tr>
          <tr>
            <td class="other_fields_label">Responsibility Center Code.:</td>
            <td class="right_side_table"><input type="text" name="respCenterCode" id="respCenterCode" /></td>
            </tr>
          <tr>
            <td class="other_fields_label">RIS No.:</td>
            <td class="right_side_table"><input name="risNo" type="text" class="required" id="risNo" /></td>
            </tr>
          <tr>
            <td class="other_fields_label">Date:</td>
            <td class="right_side_table"><input name="risDate" type="text" class="required" id="risDate" /></td>
            </tr>
          <tr>
            <td class="other_fields_label">SAI No.:</td>
            <td class="right_side_table"><input type="text" name="saiNo" id="saiNo" /></td>
            </tr>
          <tr>
            <td class="other_fields_label">Date:</td>
            <td class="right_side_table"><input type="text" name="saiNoDate" id="saiNoDate" /></td>
            </tr>
          <tr>
            <td class="other_fields_label">Purpose:</td>
            <td class="right_side_table"><input name="purpose" type="text" class="required" id="purpose" /></td>
            </tr>
          <tr>
            <td class="other_fields_label">Requested by:</td>
            <td class="right_side_table"><select name="requestedBy" class="required_menulist" id="requestedBy">
            </select></td>
            </tr>
          <tr>
            <td class="other_fields_label">Approved by:</td>
            <td class="right_side_table"><select name="approvedBy" class="required_menulist" id="approvedBy">
            </select></td>
          </tr>
          <tr>
            <td class="other_fields_label">Issued by:</td>
            <td class="right_side_table"><select name="issuedBy" class="required_menulist" id="issuedBy">
            </select></td>
          </tr>
          <tr>
            <td class="other_fields_label">Received by:</td>
            <td class="right_side_table"><select name="receivedBy" class="required_menulist" id="receivedBy">
            </select></td>
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

