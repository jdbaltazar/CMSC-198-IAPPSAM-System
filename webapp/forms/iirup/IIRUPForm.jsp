<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.servlet.forms.iirup.IIRUPFormUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.iappsam.servlet.forms.iirup.IIRUPFormUtil"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
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

#headerDiv {
	position: absolute;
	z-index: 1;
	left: 407px;
	top: 267px;
}

#background {
	position: absolute;
	width: 578px;
	height: 239px;
	z-index: 2;
	left: 407px;
	top: 291px;
}

#apDiv1 {
	position: absolute;
	width: 290px;
	height: 323px;
	z-index: 3;
	left: 576px;
	top: 304px;
}

#apDiv2 {
	position: absolute;
	width: 435px;
	height: 28px;
	z-index: 4;
	left: 51px;
	top: 71px;
}

#apDiv3 {
	position: absolute;
	width: 221px;
	height: 44px;
	z-index: 4;
	left: 402px;
	top: 359px;
}

#apDiv4 {
	position: absolute;
	width: 251px;
	height: 33px;
	z-index: 5;
	left: -54px;
	top: 117px;
}

#apDiv5 {
	position: absolute;
	width: 200px;
	height: 29px;
	z-index: 5;
	left: -11px;
	top: 157px;
}

#apDiv6 {
	position: absolute;
	width: 80px;
	height: 30px;
	z-index: 5;
	left: 103px;
	top: 182px;
}

#apDiv7 {
	position: absolute;
	width: 579px;
	height: 9px;
	z-index: 5;
	left: 407px;
	top: 531px;
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

#apDiv8 {
	position: absolute;
	width: 360px;
	height: 29px;
	z-index: 16;
	left: -17px;
	top: 123px;
}

#footer {
	position: absolute;
	left: 2px;
	top: 629px;
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
	<div id="logoHeader" style="width: 100%">
		<img name="" src="../../images/header2.png" width="100%" height="115"
			alt="" />
	</div>
	<div id="pageLabel" style="width: 100%;">
		<table width="100%" border="0">
			<tr>
				<td width="10%">
					<table width="100%" frame="below">
						<tr>
							<td
								style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">IIRUP
								Form</td>
						</tr>
					</table></td>
				<td width="86%">&nbsp;</td>
				<td width="4%">
					<form id="form15" name="form15" method="post"
						action="../FormsMenuPage.jsp">
						<input name="backBtn" type="submit" class="button" id="backBtn"
							value="Back" />
					</form></td>
			</tr>
		</table>
	</div>
	<div id="logoutiv" style="width: 90%">
		<form id="form2" name="form2" method="post" action="">
			<input name="logout" type="submit" class="maroon" id="logout"
				value="Logout" />
		</form>
	</div>
	<div class="background" id="background"></div>
	<div id="apDiv1">
		<form id="form1" name="form1" method="post" action="IIRUPForm2.jsp">


<%
	String asOfField = (String) session.getAttribute("asOfField");
	String station = (String) session.getAttribute("station");
	session.invalidate();
%><p><label for="asOfField" class="labels">As of:</label> <input
	type="text" name="asOfField" id="asOfField"
	<%if (asOfField != null)
				out.print("value=" + '"' + asOfField + '"');%> /></p>
<div id="apDiv2"><label for="nameOfAcctableOfficer"></label> <select
	name="accountableOfficer" id="accountableOfficer">
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
</select></div>
<p>&nbsp;</p>
<div id="apDiv6"><input name="nextBtn" type="submit"
	class="maroon" id="nextBtn" value="Next&gt;&gt;" /></div>
<p>&nbsp;</p>
<div id="apDiv8"><label for="station" class="labels">Station:</label>
<input type="text" name="station" id="station"
	<%if (station != null)
				out.print("value=" + '"' + station + '"');%> /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>


</form>
</div>
<div class="labels" id="apDiv3">
<div align="right">Name &amp; Designation of <br />
Accountable Officer:</div>
</div>
<div class="header" id="apDiv7"></div>
<p>&nbsp;</p>
<div class="header" id="headerDiv"></div>
</body>
</html>
