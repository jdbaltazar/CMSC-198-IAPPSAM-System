<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
#headerDiv {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 1;
	left: 353px;
	top: 176px;
}

#background {
	position: absolute;
	width: 578px;
	height: 197px;
	z-index: 3;
	left: 353px;
	top: 202px;
}

#nameDiv {
	position: absolute;
	width: 462px;
	height: 234px;
	z-index: 3;
	left: 460px;
	top: 223px;
}

#divisionIDdiv {
	position: absolute;
	width: 447px;
	height: 25px;
	z-index: 4;
	left: 414px;
	top: 286px;
}

#apDiv1 {
	position: absolute;
	width: 385px;
	height: 25px;
	z-index: 5;
	left: 436px;
	top: 335px;
}

#apDiv2 {
	position: absolute;
	width: 390px;
	height: 24px;
	z-index: 6;
	left: 354px;
	top: 387px;
}

#apDiv3 {
	position: absolute;
	width: 210px;
	height: 27px;
	z-index: 7;
	left: 409px;
	top: 388px;
}

#apDiv4 {
	position: absolute;
	width: 200px;
	height: 25px;
	z-index: 8;
	left: 432px;
	top: 444px;
}

#apDiv5 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 9;
	left: 601px;
	top: 431px;
}

#apDiv6 {
	position: absolute;
	width: 448px;
	height: 27px;
	z-index: 10;
	left: 444px;
	top: 440px;
}
</style>
</head>

<body>
<div id="background" style="background-color: #EEE0E5;"></div>
<table width="100%" border="0">
	<tr>
		<td width="14%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">Add
				Building</td>
			</tr>
		</table>
		</td>
		<td width="82%">&nbsp;</td>
		<td width="4%"><a href="../Building.html" title="Back"
			target="main_frame">Back</a></td>
	</tr>
</table>
<div id="headerDiv"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold"></div>
<div id="nameDiv">
<form id="form1" name="form1" method="post" action="./buildingCreate.do">
<p><label for="name"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Name</label>
<%
	if (((String) request.getAttribute("name")).equalsIgnoreCase("fail"))
		out.print("*");
%> <textarea name="name" cols="30" id="name"></textarea>
</p>
<p><label for="buildingID"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Building
ID</label> <%
 	String buildingID =""+ (String) request.getAttribute("buildingID");
 %> <input
	type="text" name="buildingID" id="buildingID" value=<%=buildingID%> />
</p>
<p><label for="address2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Address</label>
<%
	String address = (String) request.getAttribute("address");
%> <textarea
	name="address" cols="30" id="address2" value=<%=address%>></textarea>
</p>
<p>&nbsp;</p>
<blockquote>
<blockquote>
<blockquote>
<blockquote>
<p><input type="submit" name="addBtn" id="addBtn"
	style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;"
	value="Add" /></p>
</blockquote>
</blockquote>
</blockquote>
</blockquote>
</form>
</div>
<p>&nbsp;</p>
</body>
</html>
