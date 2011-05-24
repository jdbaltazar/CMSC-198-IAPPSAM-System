<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.servlet.forms.iirup.IIRUPFormUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.iappsam.servlet.forms.iirup.IIRUPFormUtil"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
.requiredLabel {
	font-family: Lucida Grande;
	font-size: 10px;
	color: red;
}

.header {
	background-color: #7B1113;
	width: 578px;
	height: 25px;
}

.background {
	background-color: #EEE0E5;
	width: 578px;
}

.resultTable {
	font-family: Lucida Grande;
}

.tablerow_1 {
	background-color: #EEE0E5;
}

.viewbutton {
	font-size: 12px;
	font-family: "Courier New", Courier, monospace;
	background-color: #7B1113;
	color: white;
	border: none;
}

.viewbutton:hover {
	border: none;
	font-weight: bold;
}

.tableheaders {
	background-color: #5E2605;
	color: white;
	font-family: Lucida Grande;
	font-size: 18px;
	text-align: center;
}

.maroon {
	font-size: 12px;
	font-family: Lucida Grande;
	background-color: #7B1113;
	color: white;
	border-left: 1px solid lightgray;
	border-right: 1px solid lightgray;
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

.maroon:hover {
	font-weight: bold;
	/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
	border-right: 1px solid #7B1113;
	border-top: 1px solid #7B1113;
	border-bottom: 1px solid #7B1113;
}

.labels {
	font-family: Lucida Grande;
	font-size: 16px;
	font-weight: bold;
}

.button {
	font-size: 14px;
	font-family: Lucida Grande;
	background-color: white;
	color: #7B1113;
	border-left: 1px solid lightgray;
	border-right: 1px solid lightgray;
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

.button:hover {
	font-weight: bold;
	color: #060;
	/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
	border-right: 1px solid #7B1113;
	border-top: 1px solid #7B1113;
	border-bottom: 1px solid #7B1113;
}

#header {
	position: absolute;
	z-index: 1;
	left: 425px;
	top: 326px;
}

#background {
	position: absolute;
	width: 579px;
	height: 207px;
	z-index: 2;
	left: 425px;
	top: 350px;
}

#apDiv1 {
	position: absolute;
	width: 445px;
	height: 298px;
	z-index: 3;
	left: 558px;
	top: 357px;
}

#apDiv2 {
	position: absolute;
	width: 285px;
	height: 26px;
	z-index: 4;
	left: 5px;
	top: 59px;
}

#apDiv3 {
	position: absolute;
	width: 487px;
	height: 27px;
	z-index: 4;
	left: -46px;
	top: 64px;
}

#apDiv4 {
	position: absolute;
	width: 444px;
	height: 26px;
	z-index: 4;
	left: -32px;
	top: 109px;
}

#apDiv5 {
	position: absolute;
	width: 78px;
	height: 29px;
	z-index: 4;
	left: 151px;
	top: 159px;
}

#apDiv6 {
	position: absolute;
	width: 581px;
	height: 9px;
	z-index: 4;
	left: 424px;
	top: 556px;
}

#apDiv7 {
	position: absolute;
	width: 200px;
	height: 18px;
	z-index: 5;
	left: 458px;
	top: 525px;
}

#pageLabel {
	position: absolute;
	width: 200px;
	height: 50px;
	z-index: 1;
	top: 181px;
	left: 13px;
}

#logoHeader {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 1;
}

#logoutiv {
	position: absolute;
	width: 200px;
	height: 30px;
	z-index: 15;
	left: 14px;
	top: 143px;
}

#footer {
	position: absolute;
	left: 1px;
	top: 692px;
	width: 100%;
}
</style>
</head>

<body>
<div id="footer">
<table width="100%" frame="above" bordercolor="#333333"
	style="font-family: Verdana, Geneva, sans-serif; color: #333333; font-size: 9px">
	<tr>
		<td>Copyright © 2011 All Rights Reserved</td>
	</tr>
</table>
</div>
<div id="logoHeader" style="width: 100%"><img name=""
	src="../../images/header2.png" width="100%" height="115" alt="" /></div>
<div id="pageLabel" style="width: 100%;">
<table width="100%" border="0">
	<tr>
		<td width="11%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">IIRUP
				Form</td>
			</tr>
		</table>
		</td>
		<td width="85%">&nbsp;</td>
		<td width="4%">
		<form id="form15" name="form15" method="post"
			action="IIRUPForm2.jsp"><input name="backBtn" type="submit"
			class="button" id="backBtn" value="Back" /></form>
		</td>
	</tr>
</table>
</div>
<div id="logoutiv" style="width: 90%">
<form id="form2" name="form2" method="post" action=""><input
	name="logout" type="submit" class="maroon" id="logout" value="Logout" />
</form>
</div>
<div class="header" id="header"></div>
<div class="background" id="background"></div>
<div class="header" id="apDiv6"></div>
<div class="requiredLabel" id="apDiv7"><em><strong>ALL</strong>
fields are required</em></div>
<p>&nbsp;</p>
<div id="apDiv1">
<%
	String[] yearsInService = request.getParameterValues("yearsInService");
	String[] depreciation = request.getParameterValues("depreciation");
	String[] disposition = request.getParameterValues("disposition");
	String[] appraisal = request.getParameterValues("appraisal");
	String[] orNumber = request.getParameterValues("orNumber");
	String[] amount = request.getParameterValues("amount");

	session.setAttribute("yearsInService", yearsInService);
	session.setAttribute("depreciation", depreciation);
	session.setAttribute("disposition", disposition);
	session.setAttribute("appraisal", appraisal);
	session.setAttribute("orNumber", orNumber);
	session.setAttribute("amount", amount);
%>
<form id="form1" name="form1" method="post" action="../../forms/iirup/iirup.do">
<p><label for="approvedBy" class="labels">Approved by:</label> <select
	name="approvedBy" id="approvedBy" style="font-size: 10px;">
	<%
		IIRUPFormUtil get = new IIRUPFormUtil();
		ArrayList<String> name = get.getNames();
		for (int i = 0; i < name.size(); i++) {
	%>
	<optgroup label="<%=name.get(i)%>">
		<%
			ArrayList<String> designations = get.getDesignationByName(name.get(i));
				for (int j = 0; j < designations.size(); j++) {
		%><option>
		<%
			if (!designations.get(j).isEmpty())
						out.print(designations.get(j));
		%>
		</option>

		<%
			}
		%>
	</optgroup>
	<%
		}
	%>
</select></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv3"><label for="nameOfInspector" class="labels">Name
of Inspector:</label> <input name="nameOfInspector" type="text"
	id="nameOfInspector" size="30" /></div>
<p>&nbsp;</p>
<div id="apDiv4"><label for="nameOfWitness" class="labels">Name
of Witness:</label> <input name="nameOfWitness" type="text" id="nameOfWitness"
	size="30" /></div>
<p>&nbsp;</p>
<div id="apDiv5"><input name="finishBtn" type="submit"
	class="maroon" id="finishBtn" value="Finish" /></div>

</form>
</div>
</body>
</html>
