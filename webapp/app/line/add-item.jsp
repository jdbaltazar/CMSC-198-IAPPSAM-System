<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::List Items</title>
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
<link href="../css/item_table.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="headerBkgrnd">
		<img src="../images/headerbar.png" width="100%" height="129" />
	</div>
	<div id="logo">
		<img src="../images/headerlogo.png" width="124" height="128" />
	</div>
	<div id="headerName">
		<img src="../images/headertext.png" width="452" height="44" />
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
			<td id="navigation"><a href="/menu" target="_top" class="links">Main
					Menu</a> &gt;<em><strong>List Items </strong>
			</em>
			</td>

			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="items_table">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td colspan="3" align="center"><form id="form4" name="form4"
						method="post" action="">
						<label for="searchField"><span class="align_right">Search</span>:</label>
						<input type="text" name="searchField" id="searchField" /> <input
							name="goBtn" type="submit" class="button" id="goBtn" value="GO" />
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="3"><table width="100%" border="0" cellspacing="6">
						<tr>
							<td align="center"><span class="importantNotice"><em>Item
										Not Found?</em>
							</span>
								<form id="form3" name="form3" method="get" action="/items">
									<input type="hidden" name="new" value="item" /> <input
										name="NewItemButton" type="submit" class="smallbutton"
										id="addNewItem" value="Add New>>" />
								</form>
							</td>
						</tr>
					</table>
				</td>
			</tr>

			<tr>
				<td colspan="2"><table width="100%" border="0" cellspacing="6">

					</table>
				</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td width="7%" class="tableheaders_forms">
				</td>
				<td width="58%" class="tableheaders_forms">Item Description</td>
				<td width="35%" class="tableheaders_forms">Item Category</td>
			</tr>

			<%
				int i = 0;
			%>
			<form name="AddSelectedItem" action="/app/line" method="post">

				<input type="hidden" name="add" value="items" />
				<c:forEach var="item" items="${items}">

					<tr
						<%if (i % 2 == 0)
					out.println("class=\"tablerow_1\"");
				else
					out.println("class=\"tablerow_2\"");%>>
						<td width="9%" align="center"><input type="checkbox"
							name="itemIds" id="items" value="${item.id}" />
						</td>
						<td width="54%">${item.description}</td>
						<td width="37%">${item.category}</td>
					</tr>
					<%
						i++;
					%>
				</c:forEach>
				<tr>
					<td><input name="add" type="submit" class="smallbutton"
						id="addAllBtn" value="Add Selected Items&gt;&gt;" />
					</td>
				</tr>
			</form>


		</table>
	</div>
	<!--<div id="footer"></div>-->
</body>
</html>

