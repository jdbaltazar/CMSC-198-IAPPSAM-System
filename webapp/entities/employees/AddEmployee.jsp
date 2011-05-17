<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.ArrayList"%>
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
	height: 340px;
	z-index: 3;
	left: 353px;
	top: 202px;
}

#nameDiv {
	position: absolute;
	width: 496px;
	height: 431px;
	z-index: 3;
	left: 436px;
	top: 230px;
}

#empNUmDiv {
	position: absolute;
	width: 447px;
	height: 25px;
	z-index: 4;
	left: 415px;
	top: 281px;
}

#apDiv1 {
	position: absolute;
	width: 385px;
	height: 25px;
	z-index: 5;
	left: 435px;
	top: 335px;
}

#apDiv2 {
	position: absolute;
	width: 390px;
	height: 24px;
	z-index: 6;
	left: 364px;
	top: 387px;
}

#apDiv3 {
	position: absolute;
	width: 210px;
	height: 27px;
	z-index: 7;
	left: 447px;
	top: 435px;
}

#apDiv4 {
	position: absolute;
	width: 200px;
	height: 25px;
	z-index: 8;
	left: 464px;
	top: 488px;
}

#apDiv5 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 9;
	left: 623px;
	top: 573px;
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
				Employee</td>
			</tr>
		</table>
		</td>
		<td width="82%">&nbsp;</td>
		<td width="4%"><a href="../Employees.html" title="Back"
			target="main_frame">Back</a></td>
	</tr>
</table>
<div id="headerDiv"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold"></div>
<div id="nameDiv">
<form id="form1" name="form1" method="post" action="./createEmployee.do">
<p><label for="name"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">
<blockquote>
<blockquote>
<p>Name <input type="text" name="name" size="45" id="name" /></p>
</blockquote>
</blockquote>
</label></p>
<p><label for="employeeID2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">
<blockquote>
<p>Employee ID <input type="text" name="employeeID2"
	id="employeeID2" /></p>
<p>Password <input name="password" type="password" id="password2"
	size="30" /></p>
<p>Confirm Password <input type="password" name="reenterPassword"
	size="30" id="reenterPassword2" /></p>
<p>Division <select name="division" id="division2">
	<%
		ArrayList<String> divOffice = (ArrayList<String>) request.getAttribute("divisionOfficeListFinal");
	%>
	<option selected="selected"><%out.print(divOffice.get(0));%></option>
	<%
		for (int i = 1; i < divOffice.size(); i++)
			out.print("<option>" + divOffice.get(i) + "</option>");
	%>
</select></p>
<p>&nbsp;</p>
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
</blockquote>
</label></p>
</form>
</div>
<p>&nbsp;</p>
</body>
</html>
