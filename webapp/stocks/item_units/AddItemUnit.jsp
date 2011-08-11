<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Add Item Unit</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
<!--
<script src="../../js/prototype.js" type="text/javascript"></script> 
<script src="../../js/scriptaculous.js" type="text/javascript"></script> 
 
<script src="../../js/gdAlert.js" type="text/javascript"></script> 
<link href='../../css/gdAlert.css' rel='stylesheet' type='text/css' /> 
-->

<script type="text/javascript">
function validateItemUnitForm()
{
	var txt="";
	var x=document.forms["item-unit-form"]["itemUnit"].value;

  txt="There was an error on this page!\n\n";
  txt+="Make sure required fields are not left blank,\n";
  txt+="or input is valid for that field.\n\n";

if (x==null || x=="")
  {
  alert(txt);
  return false;
  }
}
</script>

</head>

<body>
	<div id='alert_message' style='display: none'> 
			<span> 
				
			</span> 
			<input type='button' value='ok' class='button' onclick='gdAlert.close()' /> 
			<br style='clear: both' /> 
	</div> 
		
	<div id="headerBkgrnd">
		<img src="../../images/headerbar.png" width="100%" height="129" />
	</div>
	<div id="logo">
		<img src="../../images/headerlogo.png" width="124" height="128" />
	</div>
	<div id="headerName">
		<img src="../../images/headertext.png" width="452" height="44" />
	</div>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<table width="100%" border="0" cellspacing="0">
		<tr>
			<td width="32%">&nbsp;</td>
			<td width="68%"><form id="form2" name="form2" method="post"
					action="/logout">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn"
						value="Logout" />
				</form>
			</td>
		</tr>
		<tr>
			<td id="navigation"><a href="../menu" target="_top" class="links">Main
					Menu</a> &gt; <a
				href="../stocks?stock-properties-action=view-stock-properties"
				target="_top" class="links">Stock Properties</a> &gt; <a
				href="../stocks/item-unit?item-unit-action=view-item-units" target="_top"
				class="links">Item Unit List</a> &gt; <em><strong>Add
						Item Unit</strong>
			</em>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="form_table">
		<form id="item-unit-form" onsubmit="return validateItemUnitForm()" name="item-unit-form" method="post" action="../stocks/item-unit">
			<table width="100%" border="0" cellspacing="0" id="table">
				<tr>
					<td class="header_rows"><div class="header_1">
							<em>New</em>
						</div>
					</td>
				</tr>
				<tr>
					<td><table width="100%" cellspacing="0" frame="box" id="table">
							<tr>
								<td class="align_right"><br /> Item Unit:<br /> <br />
								</td>
								<td><br /> <input name="itemUnit" type="text"
									class="required" id="itemUnit" maxlength="20" /> <br /> <br />
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><input name="addBtn" type="submit" class="button"
									id="addBtn" value="ADD"/> <input
									name="item-unit-action" type="hidden" value="save-item-unit" /> <br />
									<br />
								</td>
							</tr>
						</table>
					</td>
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
