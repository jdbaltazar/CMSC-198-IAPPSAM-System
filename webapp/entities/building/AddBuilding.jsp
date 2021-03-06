<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="../../../../favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Add Building</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function validateForm()
{
	var txt="";
	var x=document.forms["buildingForm"]["buildingName"].value;

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
			<td id="navigation"><a href="menu" target="_top" class="links">Main
					Menu</a> &gt; <a href="building?building-action=view-buildings"
				target="_top" class="links">Building List</a> &gt; <em><strong>Add
						Building</strong>
			</em>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="form_table">
		<form id="buildingForm" name="buildingForm" onsubmit="return validateForm()" method="post"
			action="building">
			<table width="100%" border="0" cellspacing="0" id="table">
				<tr>
					<td class="header_rows"><div class="header_1">Building
							Information</div>
					</td>
				</tr>
				<tr>
					<td><table width="100%" border="0" cellspacing="0" id="table">
							<tr>
								<td class="align_right"><br /> *Building Name:</td>
								<td><br /> <input name="buildingName" type="text" class="required"
									id="buildingName" maxlength="80" />
								</td>
							</tr>
							<tr>
								<td class="align_right"><br /> Address:<br /> <br />
								</td>
								<td><input name="address" type="text" id="address"
									maxlength="200" />
								</td>
							</tr>
							<tr>
								<td class="align_right">&nbsp;</td>
								<td><input name="addBtn" type="submit" class="button"
									id="addBtn" value="ADD" /> <input name="building-action"
									type="hidden" value="save-building" /> <br /> <br />
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
