<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::View APP</title>
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
    <td id="navigation"><a href="../menu" target="_top" class="links">Main Menu</a> &gt; <a href="/app" target="_top" class="links">APP List</a> &gt; <em><strong>View APP</strong></em><strong></strong></td>
    <td>&nbsp;</td>
  </tr>
</table>
<div id="export"><span class="exportlabel_2">O</span><span class="exportlabel" style="font-weight:bold;">Export:</span>
<a href="/pr?export=pdf">PDF</a> <a href="/pr?export=xls">Excel</a></div>
<!--<form name="APPForm" method="post" action="">-->
  <div id="items_table">
    
    <table width="100%" border="0" cellspacing="0">
      <tr>
        <td colspan="2"><table width="100%" border="0" cellspacing="0">
          <tr class="tableheaders_forms">
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
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr class="tablerow_2">
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td width="50%" align="right" class="same_width"><br /></td>
        <td class="same_width">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2"><table width="27%" border="0" align="center" cellspacing="0">
          <tr>
            <td class="other_fields_label">Year:</td>
            <td class="right_side_table">&nbsp;</td>
            </tr>
          <tr>
            <td class="other_fields_label">Plan Ctrl No.:</td>
            <td class="right_side_table">&nbsp;</td>
            </tr>
          <tr>
            <td class="other_fields_label">Division/Office:</td>
            <td class="right_side_table">&nbsp;</td>
            </tr>
          <tr>
            <td class="other_fields_label">Date Scheduled:</td>
            <td class="right_side_table">&nbsp;</td>
            </tr>
          <tr>
            <td class="other_fields_label">Prepared by:</td>
            <td class="right_side_table">&nbsp;</td>
            </tr>
          <tr>
            <td class="other_fields_label">Recommended by:</td>
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
<!--</form>



<!--<div id="footer"></div>-->
</body>
</html>
