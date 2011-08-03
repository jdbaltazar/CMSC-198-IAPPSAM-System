<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Fillup APP</title>
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
<link href="../css/item_table.css" rel="stylesheet" type="text/css" />
<link href="../jquery/css/jquery-ui-1.8.13.custom.css" rel="stylesheet" type="text/css" />
<script src="../jquery/jquery-1.5.1.min.js"></script>
<script src="../jquery/ui/jquery.ui.core.js"></script>
<script src="../jquery/ui/jquery.ui.datepicker.js"></script>
<script src="../jquery/ui/jquery.ui.widget.js"></script>
<script>
	$(function() {
		$("#dateScheduled").datepicker({
			dateFormat : "yy-mm-dd",
			numberOfMonths : 1,
			showButtonPanel : true
		});
	});
</script>
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
    <td id="navigation"><a href="#" target="_top" class="links">Main Menu</a> &gt; <a href="#" target="_top" class="links">APP List</a> &gt; <em><strong>Fillup APP</strong></em><strong></strong></td>
    <td>&nbsp;</td>
  </tr>
</table>
<!--<form name="APPForm" method="post" action="">-->
  <div id="items_table">
    
    <table width="100%" border="0" cellspacing="0">
      <tr>
        <td colspan="2"><table width="100%" border="0" cellspacing="0">
          <tr class="tableheaders_forms">
            <td rowspan="2"><form id="form1" name="form1" method="post" action="">
              <input type="checkbox" name="selectAll" id="selectAll" />
              <label for="selectAll"></label>
              </form></td>
            <td rowspan="2">Stock No.</td>
            <td rowspan="2">ARTICLES &amp; SPECIFICATIONS</td>
            <td rowspan="2">Unit</td>
            <td rowspan="2">Qty</td>
            <td rowspan="2">Price</td>
            <td colspan="2">1st</td>
            <td colspan="2">2nd</td>
            <td colspan="2">3rd</td>
            <td colspan="2">4th</td>
            <td rowspan="2">Amount</td>
            </tr>
          <tr class="tableheaders_forms">
            <td>Qty.</td>
            <td>Amount</td>
            <td>Qty.</td>
            <td>Amount</td>
            <td>Qty.</td>
            <td>Amount</td>
            <td>Qty.</td>
            <td>Amount</td>
            </tr>
          <tr class="tablerow_1">
            <td align="center"><form id="form3" name="form3" method="post" action="">
              <input type="checkbox" name="selectThis" id="selectThis" />
              </form></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><input name="qty" type="text" class="required" id="qty" size="2" /></td>
            <td>&nbsp;</td>
            <td><input name="qty1" type="text" class="required" id="qty1" size="2" /></td>
            <td>&nbsp;</td>
            <td><input name="qty2" type="text" class="required" id="qty2" size="2" /></td>
            <td>&nbsp;</td>
            <td><input name="qty3" type="text" class="required" id="qty3" size="2" /></td>
            <td>&nbsp;</td>
            <td><input name="qty4" type="text" class="required" id="qty4" size="2" /></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr class="tablerow_2">
            <td align="center"><form id="form4" name="form4" method="post" action="">
              <input type="checkbox" name="selctThis" id="selctThis" />
              </form></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><input name="qty5" type="text" class="required" id="qty5" size="2" /></td>
            <td>&nbsp;</td>
            <td><input name="qty6" type="text" class="required" id="qty6" size="2" /></td>
            <td>&nbsp;</td>
            <td><input name="qty7" type="text" class="required" id="qty7" size="2" /></td>
            <td>&nbsp;</td>
            <td><input name="qty8" type="text" class="required" id="qty8" size="2" /></td>
            <td>&nbsp;</td>
            <td><input name="qty9" type="text" class="required" id="qty9" size="2" /></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td width="50%" align="right" class="same_width"><br />
          <form id="form5" name="form5" method="post" action="">
            <input name="addItem" type="submit" class="button" id="addItem" value="Add Item" />
          </form>
        <br /></td>
        <td class="same_width"><form id="form6" name="form6" method="post" action="">
          <input name="removeItem" type="submit" class="button" id="removeItem" value="Remove Item" />
        </form></td>
      </tr>
      <tr>
        <td colspan="2"><table width="27%" border="0" align="center" cellspacing="0">
          <tr>
            <td class="other_fields_label">Year:</td>
            <td class="right_side_table"><input name="year" type="text" class="required" id="year" /></td>
            </tr>
          <tr>
            <td class="other_fields_label">Plan Ctrl No.:</td>
            <td class="right_side_table"><input type="text" name="planCtrlNum" id="planCtrlNum" /></td>
            </tr>
          <tr>
            <td class="other_fields_label">Division/Office:</td>
            <td class="right_side_table"><select name="division/office" class="required_menulist" id="division/office">
            </select></td>
            </tr>
          <tr>
            <td class="other_fields_label">Date Scheduled:</td>
            <td class="right_side_table"><input type="text" name="dateScheduled" id="dateScheduled" /></td>
            </tr>
          <tr>
            <td class="other_fields_label">Prepared by:</td>
            <td class="right_side_table"><select name="preparedBy" class="required_menulist" id="preparedBy">
            </select></td>
            </tr>
          <tr>
            <td class="other_fields_label">Recommended by:</td>
            <td class="right_side_table"><select name="recommendedBy" class="required_menulist" id="recommendedBy">
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
<!--</form>



<!--<div id="footer"></div>-->
</body>
</html>
