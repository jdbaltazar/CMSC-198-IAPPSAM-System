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
	height: 295px;
	z-index: 3;
	left: 353px;
	top: 202px;
}

#nameDiv {
	position: absolute;
	width: 462px;
	height: 332px;
	z-index: 3;
	left: 460px;
	top: 230px;
}

#divisionIDdiv {
	position: absolute;
	width: 447px;
	height: 25px;
	z-index: 4;
	left: 416px;
	top: 282px;
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
	left: 600px;
	top: 535px;
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
				Division</td>
			</tr>
		</table>
		</td>
		<td width="82%">&nbsp;</td>
		<td width="4%"><a href="../Division.html" title="Back"
			target="main_frame">Back</a></td>
	</tr>
</table>
<div id="headerDiv"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold"></div>
<div id="nameDiv">
<form id="form1" name="form1" method="post" action="./divisionCreate.do">
<p><label for="name"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Name<%
	String name = (String) request.getAttribute("name");
	if (((String) request.getAttribute("nameOK")).equalsIgnoreCase("fail")){
		out.print("*");
		name=" ";
	}
%> </label> <input type="text" name="name" size="40" id="name" value=<%=name%> /></p>
<p><label for="divisionID"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Division
ID</label> <%
 	int divisionID = Integer.parseInt((String) request.getAttribute("divisionID"));
 %><input type="text" name="divisionID" id="divisionID"
	value=<%=divisionID%> /></p>
<p><label for="building2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Building<%
	String building = (String) request.getAttribute("building");
	if (((String) request.getAttribute("buildingOK")).equalsIgnoreCase("fail")){
		out.print("*");
		building=" ";
	}
%> </label> <input name="building" type="text" id="building2" size="30"
	value=<%=building%> /></p>
<p><label for="currentOIC2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Current
OIC</label> <select name="currentOIC" id="currentOIC2">
	<option>HEAD</option>
	<option>Janitor</option>
	<option selected="selected">Mr. Wong</option>
	<optgroup label="CurrentOIC">
		<option>HEAD</option>
	</optgroup>
</select></p>
<p><span
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Offices:
N/A <input type="submit" name="addOffice" id="addOffice"
	value="Add Office" disabled="disabled" /> <input type="submit"
	name="editOffice" id="editOffice" value="Edit Office"
	disabled="disabled" /> </span></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<blockquote>
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
</blockquote>
</form>
</div>
<p>&nbsp;</p>
</body>
</html>