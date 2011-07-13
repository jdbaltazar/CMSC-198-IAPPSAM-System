<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Fillup IIRUP</title>
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
    <td id="navigation"><a href="#" target="_top" class="links">Main Menu</a> &gt; <a href="#" target="_top" class="links">IIRUP List</a> &gt; <em><strong>Fillup IIRUP</strong></em><strong></strong></td>
    <td>&nbsp;</td>
  </tr>
</table>
<!--<form name="PRForm" method="post" action="">-->
  <div id="items_table">
    
    <table width="100%" border="0" cellspacing="0">
      <tr>
        <td colspan="2"><table width="100%" border="0" cellspacing="0" class="tableheaders_forms">
          <tr>
            <td>&nbsp;</td>
            <td colspan="8"><strong>INVENTORY</strong></td>
          </tr>
          <tr>
            <td><input type="checkbox" name="selectAllItems" id="selectAllItems" /></td>
            <td>Articles<br />
            (1)</td>
            <td>Quantity<br />
            (2)</td>
            <td>Unit Cost<br />
            (3)</td>
            <td>Total Cost<br />
            (4)</td>
            <td>Property No.<br />
              (5)</td>
            <td>Date Acquired<br />
              (6)</td>
            <td>No. of yrs in service<br />
            (7)</td>
            <td>Accumulated Depreciation<br />
              (8)</td>
          </tr>
          <tr class="tablerow_1">
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><input name="quantity" type="text" class="required" id="quantity" size="2" /></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><label for="qtyIssued"></label></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr class="bkgrnd_white">
            <td width="3%">&nbsp;</td>
            <td width="40%">&nbsp;</td>
            <td width="9%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <td width="7%">&nbsp;</td>
            <td width="9%">&nbsp;</td>
            <td width="7%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <td width="9%">&nbsp;</td>
            </tr>
        </table></td>
      </tr>
      <tr>
      	<td colspan="2">&nbsp;</td>
       </tr>
       <tr>
      	<td colspan="2"><table width="100%" border="0" cellspacing="0" class="tableheaders_forms">
          <tr>
            <td colspan="8"><strong>INSPECTION REPORT</strong></td>
          </tr>
          <tr>
            <td colspan="5">DISPOSITION</td>
            <td rowspan="2">Appraisal<br />
            (14)</td>
            <td rowspan="2">Official Receipt No.<br />
            (15)</td>
            <td rowspan="2">Amount<br />
              (16)</td>
          </tr>
          <tr>
            <td>(9)</td>
            <td>(10)</td>
            <td>(11)</td>
            <td>(12)</td>
            <td>(13)</td>
          </tr>
          <tr class="tablerow_1">
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><label for="qtyIssued"></label></td>
          </tr>
          <tr class="bkgrnd_white">
            <td width="9%">&nbsp;</td>
            <td width="9%">&nbsp;</td>
            <td width="11%">&nbsp;</td>
            <td width="11%">&nbsp;</td>
            <td width="11%">&nbsp;</td>
            <td width="20%">&nbsp;</td>
            <td width="16%">&nbsp;</td>
            <td width="13%">&nbsp;</td>

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
            <td class="other_fields_label">As of:</td>
            <td class="right_side_table"><input name="asOf" type="text" class="required" id="asOf" /></td>
          </tr>
          <tr>
            <td class="other_fields_label">Accountable Officer:</td>
            <td class="right_side_table"><select name="accountableOfficer" class="required_menulist" id="accountableOfficer">
            </select></td>
          </tr>
          <tr>
            <td class="other_fields_label">Designation:</td>
            <td class="right_side_table"><label for="designation"></label>
              <select name="designation" class="required_menulist" id="designation">
            </select></td>
          </tr>
          <tr>
            <td class="other_fields_label">Station:</td>
            <td class="right_side_table"><label for="station"></label>
              <select name="station" class="required_menulist" id="station">
            </select></td>
          </tr>
          <tr>
            <td class="other_fields_label">Approved by:</td>
            <td class="right_side_table"><select name="approvedBy" class="required_menulist" id="approvedBy">
            </select></td>
          </tr>
          <tr>
            <td class="other_fields_label">Designation:</td>
            <td class="right_side_table"><select name="approverDesignation" class="required_menulist" id="approverDesignation">
            </select></td>
            </tr>
          <tr>
            <td class="other_fields_label">Inspector:</td>
            <td class="right_side_table"><select name="inspector" class="required_menulist" id="inspector">
            </select></td>
          </tr>
          <tr>
            <td class="other_fields_label">Witness:</td>
            <td class="right_side_table"><select name="witness" class="menulist" id="witness">
            </select></td>
          </tr>
          <tr>
            <td class="other_fields_label">Date Witnessed:</td>
            <td class="right_side_table"><input name="dateWitnessed" type="text" id="dateWitnessed" /></td>
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

