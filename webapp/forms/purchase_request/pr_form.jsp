<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.List"%>
<%@page import="com.iappsam.entities.DivisionOffice"%>
<%@page import="com.iappsam.util.Managers"%>
<%@page import="java.util.Date"%>
<%@page import="com.iappsam.util.DateUtil"%>
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
	left: 583px;
	top: 305px;
}

#apDiv2 {
	position: absolute;
	width: 435px;
	height: 28px;
	z-index: 4;
	left: 49px;
	top: 11px;
}

#apDiv3 {
	position: absolute;
	width: 221px;
	height: 26px;
	z-index: 4;
	left: 407px;
	top: 319px;
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
	left: 100px;
	top: 177px;
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
	height: 53px;
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
	width: 479px;
	height: 29px;
	z-index: 16;
	left: -11px;
	top: 51px;
}

#apDiv9 {
	position: absolute;
	width: 486px;
	height: 28px;
	z-index: 16;
	left: -18px;
	top: 87px;
}

#apDiv10 {
	position: absolute;
	width: 510px;
	height: 27px;
	z-index: 16;
	left: -44px;
	top: 121px;
}

#footer {
	position: absolute;
	left: 2px;
	top: 627px;
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
		<td width="21%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">Purchase
				Request Form</td>
			</tr>
		</table>
		</td>
		<td width="75%">&nbsp;</td>
		<td width="4%">
		<form id="form15" name="form15" method="post"
			action="../../FormsMenuPage.jsp"><input name="backBtn"
			type="submit" class="button" id="backBtn" value="Back" /></form>
		</td>
	</tr>
</table>
</div>
<div id="logoutiv" style="width: 90%">
<form id="form2" name="form2" method="post" action=""><input
	name="logout" type="submit" class="maroon" id="logout" value="Logout" />
</form>
</div>
<div class="background" id="background"></div>
<div id="apDiv1">
<form id="form1" name="form1" method="post" action="PR_Form_2.html">
<p>&nbsp;</p>
<div id="apDiv2"><label for="nameOfAcctableOfficer"></label> <select
	name="deptAndSection" id="deptAndSection" style="width: 200px;">
	<%
		List<DivisionOffice> dOffice = (List<DivisionOffice>) Managers.doManager.getAllDivisionOffice();
			for (int i = 0; dOffice != null && i < dOffice.size(); i++) {
	%>
	<option value="<%=dOffice.get(i).getId()%>">
	<%
		out.print(dOffice.get(i).getDivisionName());
			if (dOffice.get(i).getOfficeName() != null && !dOffice.get(i).getOfficeName().isEmpty())
				out.print("," + dOffice.get(i).getOfficeName());
	%>
	</option>

	<%
		}
	%>
</select></div>
<p>&nbsp;</p>
<div id="apDiv6"><input name="nextBtn" type="submit"
	class="maroon" id="nextBtn" value="Next&gt;&gt;" /></div>
<p>&nbsp;</p>
<div id="apDiv8"><label for="prNumber" class="labels">PR.No.:</label>
<input name="prNumber" type="text" id="prNumber" size="15"
	maxlength="15" /> <label for="PRmonth" class="labels">Date:</label> <select
	name="PRmonth" id="PRmonth">
	<option value="<%=1%>">Jan</option>
	<option value="<%=2%>">Feb</option>
	<option value="<%=3%>">Mar</option>
	<option value="<%=4%>">Apr</option>
	<option value="<%=5%>">May</option>
	<option value="<%=6%>">Jun</option>
	<option value="<%=7%>">Jul</option>
	<option value="<%=8%>">Aug</option>
	<option value="<%=9%>">Sep</option>
	<option value="<%=10%>">Oct</option>
	<option value="<%=11%>">Nov</option>
	<option value="<%=12%>">Dec</option>


</select> <select name="PRday" id="PRday">
	<%
		for (int i = 1; i < 32; i++) {
	%>
	<option value="<%=i%>"><%=i%></option>
	<%
		}
	%>
</select> <select name="PRyear" id="PRyear">
	<%
		Date date = new Date();
		System.out.println(date.getYear());
		for (int i = 0; i < 38; i++) {
	%>
	<option value="<%=i%>"><%=(1900 + date.getYear() - i)%></option>
	<%
		}
	%>
</select></div>
<div id="apDiv9"><label for="saiNumber" class="labels">SAI
No.:</label> <input name="saiNumber" type="text" id="saiNumber" size="15"
	maxlength="15" /> <label for="SAImonth" class="labels">Date:</label> <select
	name="SAImonth" id="SAImonth">
	<option value="<%=1%>">Jan</option>
	<option value="<%=2%>">Feb</option>
	<option value="<%=3%>">Mar</option>
	<option value="<%=4%>">Apr</option>
	<option value="<%=5%>">May</option>
	<option value="<%=6%>">Jun</option>
	<option value="<%=7%>">Jul</option>
	<option value="<%=8%>">Aug</option>
	<option value="<%=9%>">Sep</option>
	<option value="<%=10%>">Oct</option>
	<option value="<%=11%>">Nov</option>
	<option value="<%=12%>">Dec</option>

</select> <select name="SAIday" id="SAIday">

	<%
		for (int i = 1; i < 32; i++) {
	%>
	<option value="<%=i%>"><%=i%></option>
	<%
		}
	%>
</select> <select name="SAIyear" id="SAIyear">

	<%
		System.out.println(date.getYear());
		for (int i = 0; i < 38; i++) {
	%>
	<option value="<%=i%>"><%=(1900 + date.getYear() - i)%></option>
	<%
		}
	%>
</select></div>
<p>&nbsp;</p>
<div id="apDiv10"><label for="alobsNumber" class="labels">ALOBS
No.:</label> <input name="alobsNumber" type="text" id="alobsNumber" size="15"
	maxlength="15" /> <label for="ALOBSmonth" class="labels">Date:</label>
<select name="ALOBSmonth" id="ALOBSmonth">

	<option value="<%=1%>">Jan</option>
	<option value="<%=2%>">Feb</option>
	<option value="<%=3%>">Mar</option>
	<option value="<%=4%>">Apr</option>
	<option value="<%=5%>">May</option>
	<option value="<%=6%>">Jun</option>
	<option value="<%=7%>">Jul</option>
	<option value="<%=8%>">Aug</option>
	<option value="<%=9%>">Sep</option>
	<option value="<%=10%>">Oct</option>
	<option value="<%=11%>">Nov</option>
	<option value="<%=12%>">Dec</option>

</select> <select name="ALOBSday" id="ALOBSday">
	<%
		for (int i = 1; i < 32; i++) {
	%>
	<option value="<%=i%>"><%=i%></option>
	<%
		}
	%>
</select> <select name="ALOBSyear" id="ALOBSyear">
	<%
		System.out.println(date.getYear());
		for (int i = 0; i < 38; i++) {
	%>
	<option value="<%=i%>"><%=(1900 + date.getYear() - i)%></option>
	<%
		}
	%>
</select></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>


</form>
</div>
<div class="labels" id="apDiv3">
<div align="right">Department &amp; Section:</div>
</div>
<div class="header" id="apDiv7"></div>
<p>&nbsp;</p>
<div class="header" id="headerDiv"></div>
</body>
</html>
