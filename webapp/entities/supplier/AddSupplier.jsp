<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Add Supplier</title>
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
    <td id="navigation"><a href="#" target="_top" class="links">Main Menu</a> &gt; <a href="#" target="_top" class="links">Supplier List</a> &gt; <em><strong>Add Supplier</strong></em></td>
    <td>&nbsp;</td>
  </tr>
</table>
<div id="form_table">
  <form id="supplierForm" name="supplierForm" method="post" action="">
    <table width="100%" border="0" cellspacing="0" id="table">
    <tr>
     <td align="right" class="bkgrnd_white"><a href="#" target="_self" class="linkBtn">Add Supplier to Existing Contact Person</a></td>
     </tr>
    <tr>
     <td class="bkgrnd_white">&nbsp;</td>
     </tr>

      <tr class="header_rows">
        <td><div class="header_1">Supplier Information</div></td>
      </tr>
      <tr>
        <td><table width="100%" cellspacing="9" border="0">
          <tr>
            <td class="align_right">*Supplier Name:</td>
            <td><input type="text" name="supplierName" id="supplierName" /></td>
          </tr>
          <tr>
            <td class="align_right">*Supplier Address:</td>
            <td><input type="text" name="supplierAddress" id="supplierAddress" /></td>
          </tr>
          <tr>
            <td class="align_right">TIN:</td>
            <td><input type="text" name="tin" id="tin" /></td>
          </tr>
        </table></td>
      </tr>
      <tr class="header_rows">
        <td><div class="header_1">Contact Person Information</div></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="9">
          <tr>
            <td class="align_right">Title:</td>
            <td><input type="text" name="title" id="title" /></td>
          </tr>
          <tr>
            <td class="align_right">*Name:</td>
            <td><input type="text" name="name" id="name" /></td>
          </tr>
        </table></td>
      </tr>
      <tr class="header_rows">
        <td><div class="header_1">Work Information</div></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="9">
          <tr>
            <td class="align_right">*Designation:</td>
            <td><input type="text" name="designation2" id="designation2" /></td>
          </tr>
          <tr>
            <td class="align_right">Employee Number:</td>
            <td><input type="text" name="employeeNumber" id="employeeNumber" /></td>
          </tr>
        </table></td>
      </tr>
      <tr class="header_rows">
        <td><div class="header_1">Contact Information</div></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="9">
          <tr>
            <td class="align_right">Mobile Number:</td>
            <td><input type="text" name="mobileNumber" id="mobileNumber" /></td>
          </tr>
          <tr>
            <td class="align_right">Landline:</td>
            <td><input type="text" name="landline" id="landline" /></td>
          </tr>
          <tr>
            <td class="align_right">E-mail Address:</td>
            <td><input type="text" name="emailad" id="emailad" /></td>
          </tr>
          <tr>
            <td class="align_right">&nbsp;</td>
            <td><input name="addBtn" type="submit" class="button" id="addBtn" value="ADD" /></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td class="table_footer"></td>
      </tr>
    </table>
  </form>
</div>
<!--<div id="footer"></div>-->
</body>
</html>

