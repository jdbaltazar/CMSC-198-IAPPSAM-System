<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::View IE</title>
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
    <td id="navigation"><a href="menu" target="_top" class="links">Main Menu</a> &gt; <a href="ie" target="_top" class="links">IE List</a> &gt; <em><strong>View IE</strong></em><strong></strong></td>
    <td>&nbsp;</td>
  </tr>
</table>
<div id="export"><span class="exportlabel_2">O</span><span class="exportlabel" style="font-weight:bold;">Export:</span>
<a href="/pr?export=pdf">PDF</a> <a href="/pr?export=xls">Excel</a></div>
<!--<form name="PRForm" method="post" action="">-->
  <div id="items_table">
    
    <table width="100%" border="0" cellspacing="0">
      <tr>
        <td colspan="2"><table width="100%" border="0" cellspacing="0" class="tableheaders_forms">
          <tr>
            <td>Property No.</td>
            <td>Equipment Property</td>
            <td>Article Code</td>
            <td>Quantity</td>
            <td>Unit Value</td>
            <td>Total Value</td>
          </tr>
          <tr class="tablerow_1">
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><input name="qtyRequested" type="text" class="required" id="qtyRequested" size="2" /></td>
            <td><label for="qtyIssued"></label></td>
            <td>&nbsp;</td>
          </tr>
          <tr class="bkgrnd_white">
            <td width="9%">&nbsp;</td>
            <td width="47%">&nbsp;</td>
            <td width="11%">&nbsp;</td>
            <td width="9%">&nbsp;</td>
            <td width="10%">&nbsp;</td>
            <td width="10%">&nbsp;</td>
            </tr>
        </table></td>
      </tr>
      <tr>
      	<td colspan="2">&nbsp;</td>
       </tr>
       <tr>
      	<td colspan="2"><table width="100%" border="0" cellspacing="0" class="tableheaders_forms">
          <tr>
            <td>Year Acquired</td>
            <td>How Acquired</td>
            <td>Present Condition</td>
            <td>Person Accountable</td>
            <td>Remarks</td>
          </tr>
          <tr class="tablerow_1">
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><label for="qtyIssued"></label></td>
          </tr>
          <tr class="bkgrnd_white">
            <td width="11%">&nbsp;</td>
            <td width="21%">&nbsp;</td>
            <td width="22%">&nbsp;</td>
            <td width="20%">&nbsp;</td>
            <td width="26%">&nbsp;</td>

            </tr>
        </table></td>
       </tr>
      <tr>
        <td width="50%" align="right" class="same_width">&nbsp;</td>
        <td align="left" class="same_width">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2"><table width="25%" border="0" align="center" cellspacing="0">
          <tr>
            <td class="other_fields_label">Division/Office:</td>
            <td class="right_side_table">&nbsp;</td>
          </tr>
          <tr>
            <td class="other_fields_label">Building:</td>
            <td class="right_side_table"><label for="building"></label></td>
          </tr>
          <tr>
            <td class="other_fields_label">Prepared by::</td>
            <td class="right_side_table"><label for="preparedBy"></label></td>
          </tr>
          <tr>
            <td class="other_fields_label">Date Prepared:</td>
            <td class="right_side_table">&nbsp;</td>
          </tr>
          <tr>
            <td class="other_fields_label">Counterchecked by:</td>
            <td class="right_side_table">&nbsp;</td>
            </tr>
          <tr>
            <td class="other_fields_label">Noted:</td>
            <td class="right_side_table">&nbsp;</td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><br /></td>
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