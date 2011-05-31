<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.sql.Date"%>
<%@page import="com.iappsam.entities.forms.PurchaseRequest"%>
<%@page import="com.iappsam.util.ManagerBin"%>
<%@page import="com.iappsam.entities.DivisionOffice"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
.textfields_1 {
	background-color: #EEE0E5;
	border: none;
	text-align: center;
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
	font-size: 14px;
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

#apDiv1 {
	position: absolute;
	width: 961px;
	height: 46px;
	z-index: 1;
	left: 1px;
	top: 270px;
}

#apDiv2 {
	position: absolute;
	width: 200px;
	height: 144px;
	z-index: 2;
	left: 1px;
	top: 306px;
}

#apDiv3 {
	position: absolute;
	width: 85px;
	height: 30px;
	z-index: 3;
	left: 449px;
	top: 481px;
}

#apDiv4 {
	position: absolute;
	width: 99px;
	height: 29px;
	z-index: 4;
	left: 726px;
	top: 482px;
}

#pageLabel {
	position: absolute;
	width: 200px;
	height: 46px;
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
	left: 2px;
	top: 659px;
	width: 100%;
}
#apDiv5 {
	position:absolute;
	width:97px;
	height:35px;
	z-index:16;
	top: 482px;
	left: 561px;
}
</style>
</head>
<%
	String divisionOfficeID = (String) request.getParameter("deptAndSection");

	DivisionOffice divisionOffice;
	if (divisionOfficeID != null) {
		divisionOffice = ManagerBin.doManager.getDivisionOffice(Integer.parseInt(divisionOfficeID));
		session.setAttribute("dOffice", divisionOffice);
	} else
		System.out.println("deptAndSection has returned null");

	String prDay = (String) request.getParameter("PRday");
	String prMonth = (String) request.getParameter("PRmonth");
	System.out.println("PRMonth:" + prMonth);
	String prYear = (String) request.getParameter("PRyear");
	String prNumber = (String) request.getParameter("prNumber");
	//Date prDate = Date.valueOf(prYear + '-' + prMonth + '-' + prDay);
	//session.setAttribute("prDate", prDate);
	session.setAttribute("prNumber", prNumber);

	String saiDay = (String) request.getParameter("SAIday");
	String saiMonth = (String) request.getParameter("SAImonth");
	System.out.println("SAIMonth:" + saiMonth);
	String saiYear = (String) request.getParameter("SAIyear");
	String saiNumber = (String) request.getParameter("saiNumber");
	//Date saiDate = Date.valueOf(saiYear + '-' + saiMonth + '-' + saiDay);
	//session.setAttribute("saiDate", saiDate);
	session.setAttribute("saiNumber", saiNumber);

	String alobsDay = (String) request.getParameter("ALOBSday");
	String alobsMonth = (String) request.getParameter("ALOBSmonth");
	System.out.println(alobsMonth);
	String alobsYear = (String) request.getParameter("ALOBSyear");
	String alobsNumber = (String) request.getParameter("alobsNumber");
	//Date alobsDate = Date.valueOf(alobsYear + '-' + alobsMonth + '-' + alobsDay);
	//session.setAttribute("alobsDate", alobsDate);
	session.setAttribute("alobsNumber", alobsNumber);
%>
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
	src="../../../images/header2.png" width="100%" height="115" alt="" /></div>
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
		<form id="form15" name="form15" method="post" action="pr_form.jsp">
		<input name="backBtn" type="submit" class="button" id="backBtn"
			value="Back" /></form>
		</td>
	</tr>
</table>
</div>
<div id="logoutiv" style="width: 90%">
<form id="form2" name="form2" method="post" action=""><input
	name="logout" type="submit" class="maroon" id="logout" value="Logout" />
</form>
</div>
<div id="apDiv1" style="width: 100%">
<table width="100%" border="0" cellspacing="0" class="tableheaders">
	<tr>
		<td width="7%">Quantity</td>
		<td width="9%">Unit of Issue</td>
		<td width="34%">Item Description</td>
		<td width="13%">Stock No.</td>
		<td width="13%">Estimated Unit<br />
		Cost</td>
	</tr>
</table>
</div>
<div id="apDiv2" style="width: 100%">
<table width="100%" frame="box" cellspacing="0">
	<tr class="tablerow_1">
		<td width="7%" align="center">
		<form id="form1" name="form1" method="post" action=""><input
			name="quantity_1" type="text" class="textfields_1" id="quantity_1"
			size="4" /></form>
		</td>
		<td width="9%">&nbsp;</td>
		<td width="34%">&nbsp;</td>
		<td width="13%">&nbsp;</td>
		<td width="13%" align="center"><input name="estUnitCost"
			type="text" class="textfields_1" id="estUnitCost" size="8" /></td>
		
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>

	
	</tr>
	<tr tr class="tablerow_1">
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>

	
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>

	
	</tr>
	<tr tr class="tablerow_1">
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>

	
	</tr>
</table>
</div>
<div id="apDiv3">
<form id="form2" name="form2" method="post"
	action="pr_form_additem.do"><input name="addItem"
	type="submit" class="maroon" id="addItem" value="Add Item" /></form>
</div>
<div id="apDiv4">
<form id="form3" name="form3" method="post" action="pr_form_3.do">
<input name="nextBtn" type="submit" class="maroon" id="nextBtn"
	value="Next&gt;&gt;" /></form>
</div>
<p>&nbsp;</p>
<div id="apDiv5">
  <form id="form4" name="form4" method="post" action="pr_form_remove_item.do">
    <input name="nextBtn2" type="submit" class="maroon" id="nextBtn2"
	value="Remove Items&gt;&gt;" />
  </form>
</div>
</body>
</html>

