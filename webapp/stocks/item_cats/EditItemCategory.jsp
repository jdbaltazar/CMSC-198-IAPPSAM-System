<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.ItemCategory"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Add Item Category</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%
		ItemCategory itemCategory = (ItemCategory) request.getAttribute("itemCategory");
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
			<td width="32%">&nbsp;</td>
			<td width="68%"><form id="form2" name="form2" method="post"
					action="/logout">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn"
						value="Logout" />
				</form></td>
		</tr>
		<tr>
			<td id="navigation"><a href="../menu" target="_top"
				class="links">Main Menu</a> &gt;<a
				href="../stocks?stock-properties-action=view-stock-properties"
				target="_top" class="links">Stock Properties</a> &gt; <a
				href="../stocks/item-cat?item-cat-action=view-item-cats" target="_top" class="links">Item
					Category List</a> &gt; <em><strong>Edit Item Category</strong> </em></td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="form_table">
		<form id="form1" name="form1" method="post"
			action="../stocks/item-cat">
			<table width="100%" border="0" cellspacing="0" id="table">
				<tr>
					<td class="header_rows"><div class="header_1">
							<em>Edit</em>
						</div></td>
				</tr>
				<tr>
					<td><table width="100%" cellspacing="0" frame="box" id="table">
							<tr>
								<td class="align_right"><br /> Item Category:<br /> <br />
								</td>
								<td><br /> <input name="itemCategory" type="text"
									class="required" id="itemCategory"
									value="<%=itemCategory.getName()%>" maxlength="200" /> <br />
									<br /></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><input name="saveBtn" type="submit" class="button"
									id="saveBtn" value="SAVE" /> <input type="hidden"
									name="itemCategoryID" value=<%="" + itemCategory.getId()%> />
									<input name="item-cat-action"
									type="hidden" value="save-edited-item-cat" />
									<br /> <br /></td>
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
