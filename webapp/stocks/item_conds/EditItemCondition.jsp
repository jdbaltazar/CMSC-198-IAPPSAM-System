<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.ItemCondition"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Add Item Condition</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%
		ItemCondition itemCondition = (ItemCondition) request.getAttribute("itemCondition");
	%>
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
			<td width="35%">&nbsp;</td>
			<td width="65%"><form id="form2" name="form2" method="post"
					action="../../logout">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn"
						value="Logout" />
				</form>
			</td>
		</tr>
		<tr>
			<td id="navigation"><a href="../menu" target="_top"
				class="links">Main Menu</a> &gt; <a
				href="../stocks?stock-properties-action=view-stock-properties"
				target="_top" class="links">Stock Properties</a> &gt; <a
				href="../stocks/item-cond?item-cond-action=view-item-conds"
				target="_top" class="links">Item Condition List</a> &gt; <em><strong>Edit
						Item Condition</strong> </em></td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="form_table">
		<form id="form1" name="form1" method="post"
			action="../stocks/item-cond">
			<table width="100%" border="0" cellspacing="0" id="table">
				<tr>
					<td class="header_rows"><div class="header_1">
							<em>Edit</em>
						</div>
					</td>
				</tr>
				<tr>
					<td><table width="100%" cellspacing="0" frame="box" id="table">
							<tr>
								<td class="align_right"><br /> Item Condition:<br /> <br />
								</td>
								<td><br /> <input name="itemCondition" type="text"
									class="required" id="itemCondition"
									value="<%=itemCondition.getName()%>" maxlength="45" /> <br />
									<br />
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><input name="saveBtn" type="submit" class="button"
									id="saveBtn" value="SAVE" /> <input type="hidden"
									name="itemConditionID" value=<%="" + itemCondition.getId()%> />
									<input name="item-cond-action" type="hidden"
									value="save-edited-item-cond" /> <br /> <br />
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
