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
	height: 24px;
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
<form id="form1" name="form1" method="post" action="">
<label for="name"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Name</label>
<%String name =(String)request.getAttribute("name");
	out.print(name);%></form>
</div>
<div id="apDiv1">
<form id="form3" name="form3" method="post" action="">
<label for="building"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Building</label>
<%
	String building = (String) request.getAttribute("building");
	out.print(building);
%>
</form>
</div>
<div id="apDiv3">
<form id="form5" name="form5" method="post" action="">
<label for="currentOIC"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Current
OIC:</label> <%
 	String currentOIC = (String) request.getAttribute("currentOIC");
 	out.print(currentOIC);
 %>
</form>
</div>
<div id="apDiv5">
<form id="form7" name="form7" method="post" action="">
<input type="submit" name="addBtn" id="addBtn"
	style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;"
	value="Add" /></form>
</div>
<div id="apDiv6">
<form id="form4" name="form4" method="post" action="./divisionCreate.do"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">
Offices: N/A <input type="submit" name="addOffice" id="addOffice"
	value="Add Office" /> <input type="submit" name="editOffice"
	id="editOffice" value="Edit Office" /></form>
</div>
<p>&nbsp;</p>
<div id="divisionIDdiv">
<form id="form2" name="form2" method="post" action="">
<label for="divisionID"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Division
ID</label> <%String divisionID = (String)request.getAttribute("divisionID");
			out.print(divisionID);%></form>
</div>
</body>
</html>