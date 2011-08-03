<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Stock Properties</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
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
					action="../../logout">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn"
						value="Logout" />
				</form>
			</td>
		</tr>
		<tr>
			<td id="navigation"><a href="menu" target="_top" class="links">Main
					Menu</a> &gt;<em><strong>Stock Properties</strong>
			</em>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="menu_4">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td colspan="2" class="header_rows"><div class="header_2">Item
						Properties</div>
				</td>
			</tr>
			<tr>
				<td width="78%"><form id="form1" name="form1" method="post"
						action="stocks/item-unit">
						<input name="itemUnit" type="submit" class="menubtn" id="itemUnit"
							value="Item Unit" /> <input type="hidden"
							name="item-unit-action" value="view-item-units" />
					</form>
				</td>
				<td width="22%"><form id="form3" name="form3" method="get"
						action="stocks/item-unit">
						<input name="addItemUnitBtn" type="submit" class="button2"
							id="addItemUnitBtn" value="Add&gt;&gt;" /> <input type="hidden"
							name="item-unit-action" value="add-item-unit" />
					</form>
				</td>
			</tr>
			<tr>
				<td><form id="form4" name="form4" method="post"
						action="stocks/item-stat">
						<input name="itemStatus" type="submit" class="menubtn"
							id="itemStatus" value="Item Status" /> <input type="hidden"
							name="item-stat-action" value="view-item-stats" />
					</form>
				</td>
				<td><form id="form5" name="form5" method="post"
						action="stocks/item-stat">
						<input name="addItemStatus" type="submit" class="button2"
							id="addItemStatus" value="Add&gt;&gt;" /> <input type="hidden"
							name="item-stat-action" value="add-item-stat" />
					</form>
				</td>
			</tr>
			<tr>
				<td><form id="form6" name="form6" method="post"
						action="stocks/item-cat">
						<input name="itemCategory" type="submit" class="menubtn"
							id="itemCategory" value="Item Category" /> <input type="hidden"
							name="item-cat-action" value="view-item-cats" />
					</form>
				</td>
				<td><form id="form7" name="form7" method="post"
						action="stocks/item-cat">
						<input name="addCategoryBtn" type="submit" class="button2"
							id="addCategoryBtn" value="Add&gt;&gt;" /> <input type="hidden"
							name="item-cat-action" value="add-item-cat" />
					</form>
				</td>
			</tr>
			<tr>
				<td><form id="form8" name="form8" method="post"
						action="stocks/item-cond">
						<input name="itemCondition" type="submit" class="menubtn"
							id="itemCondition" value="Item Condition" /> <input
							type="hidden" name="item-cond-action" value="view-item-conds" />
					</form>
				</td>
				<td><form id="form9" name="form9" method="post"
						action="stocks/item-cond">
						<input name="addCondition" type="submit" class="button2"
							id="addCondition" value="Add&gt;&gt;" /> <input type="hidden"
							name="item-cond-action" value="add-item-cond" />
					</form>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" class="header_rows"><div class="header_2">Others</div>
				</td>
			</tr>
			<tr>
				<td><form id="form10" name="form10" method="post"
						action="stocks/disposal">
						<input name="disposal" type="submit" class="menubtn" id="disposal"
							value="Disposal" /> <input type="hidden" name="disposal-action"
							value="view-disposals" />
					</form>
				</td>
				<td><form id="form11" name="form11" method="post"
						action="stocks/disposal">
						<input name="addDisposal" type="submit" class="button2"
							id="addDisposal" value="Add&gt;&gt;" /> <input type="hidden"
							name="disposal-action" value="add-disposal" />
					</form>
				</td>
			</tr>
			<tr>
				<td><form id="form12" name="form12" method="post"
						action="stocks/mode">
						<input name="modeOfProcurement" type="submit" class="menubtn"
							id="modeOfProcurement" value="Mode of Procurement" /> <input
							type="hidden" name="mode-action" value="view-modes" />
					</form>
				</td>
				<td><form id="form13" name="form13" method="post"
						action="stocks/mode">
						<input name="addProcurement" type="submit" class="button2"
							id="addProcurement" value="Add&gt;&gt;" /> <input type="hidden"
							name="mode-action" value="add-mode" />
					</form>
				</td>
			</tr>
		</table>
	</div>
	<!--<div id="footer"></div>-->
</body>
</html>