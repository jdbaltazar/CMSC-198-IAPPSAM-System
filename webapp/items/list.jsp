<%@page import="com.iappsam.servlet.item.ItemAttribute"%>
<%@page import="com.iappsam.entities.Item"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<link rel="shortcut icon" href="/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: Items</title>
<link href="/items/items.css" rel="stylesheet" type="text/css" />
<link href="../style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="/logo.jsp" />
	<jsp:include page="/logout-button.jsp" />

	<!-- Breadcrumbs -->
	<div class="Breadcrumbs">
		<a href="/menu">Menu</a> > <a href="/items">Items</a>
	</div>

	<div id="search">
		<form id="form1" name="form1" method="get" action="/items">
			<label for="searchItemField" class="labels">Search:</label> <input name="q" type="text" id="searchItemField" size="35" /> <input name="search"
				type="submit" class="maroon" value="GO"
			/>
		</form>
	</div>

	<div id="apDiv1">
		<a href="/items?new=item">Add Item >></a>
	</div>

	<div class="ItemTableHeader">
		<table width="100%" border="1" cellspacing="0" class="header">
			<tr>
				<td width="29%">Item Description</td>
				<td width="7%">Unit</td>
				<td width="11%">Price</td>
				<td width="34%">Item Category</td>
				<td width="19%">Item Status</td>
			</tr>
		</table>
	</div>

	<div class="result-table" style="width: 100%;">

		<%
			List<Item> items = (List<Item>) request.getAttribute(ItemAttribute.ITEMS);
			int i = 0;
			for (Item item : items) {
		%>

		<a href="/items?id=<%=item.getId()%>"> <%
 	if (i % 2 == 0)
 			out.print("<div class=\"tablerow_1\">");
 		else
 			out.print("<div>");
 %>
			<table class="result">
				<tr>
					<td class=title-label width="29%"><%=item.getDescription()%></td>
					<td class=title-label width="7%"><%=item.getUnit()%></td>
					<td class=title-label width="11%"><%=item.getPrice()%></td>
					<td class=title-label width="34%"><%=item.getItemCategory()%></td>
					<td class=title-label width="19%"><%=item.getItemStatus()%></td>
				</tr>
			</table>
	</div>
	</a>
	<%
		i++;
		}
	%>

	</div>


	<jsp:include page="/copyright.jsp" />
</body>
</html>

