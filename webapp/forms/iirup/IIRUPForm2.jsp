<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.entities.DivisionOffice"%>
<%@page import="com.iappsam.util.ManagerBin"%>
<%@page import="com.iappsam.entities.forms.Disposal"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>

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
	left: -1px;
	top: 273px;
}

#apDiv2 {
	position: absolute;
	width: 200px;
	height: 144px;
	z-index: 2;
	left: -1px;
	top: 315px;
}

#apDiv3 {
	position: absolute;
	width: 85px;
	height: 30px;
	z-index: 3;
	left: 444px;
	top: 478px;
}

#apDiv4 {
	position: absolute;
	width: 99px;
	height: 29px;
	z-index: 4;
	left: 661px;
	top: 478px;
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
	left: 2px;
	top: 659px;
	width: 100%;
}

#apDiv5 {
	position: absolute;
	width: 87px;
	height: 31px;
	z-index: 16;
	left: 553px;
	top: 478px;
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
		<td width="10%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">IIRUP
				Form</td>
			</tr>
		</table>
		</td>
		<td width="86%">&nbsp;</td>
		<td width="4%">
		<form id="form15" name="form15" method="post" action="IIRUP Form.html">
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

<%
	if (session.getAttribute("asOfDate") == null || request.getParameter("asOfMonth") != null) {
		int month = Integer.parseInt(request.getParameter("asOfMonth"));
		int year = Integer.parseInt(request.getParameter("asOfYear"));
		int day = Integer.parseInt(request.getParameter("asOfDay"));
		Date date = new Date(year, month, day);
		session.setAttribute("asOfDate", date);
	}

	String station = (String) request.getParameter("station");
	System.out.println("JK's Number:"+station);
	if(station!=null){
	DivisionOffice dOffice =ManagerBin.doManager.getDivisionOffice(Integer.parseInt(station));
	session.setAttribute("station", dOffice);
	}
	String accountableOfficer = (String) request.getParameter("accountableOfficer");
	String requestedBy = (String) request.getParameter("requestedBy");
	if (accountableOfficer != null)
		session.setAttribute("accountableOfficer", accountableOfficer);

	if (requestedBy != null) {
		session.setAttribute("requestedBy", requestedBy);
	}
	ArrayList<String> article = (ArrayList<String>) request.getAttribute("article");
	if (article == null)
		article = (ArrayList<String>) session.getAttribute("article");
	session.setAttribute("article", article);

	ArrayList<String> unitCost = (ArrayList<String>) request.getAttribute("unitCost");
	if (unitCost == null)
		unitCost = (ArrayList<String>) session.getAttribute("unitCost");
	session.setAttribute("unitCost", article);

	ArrayList<String> propertyNo = (ArrayList<String>) request.getAttribute("propertyNo");
	if (propertyNo == null)
		propertyNo = (ArrayList<String>) session.getAttribute("propertyNo");
	session.setAttribute("propertyNo", article);

	ArrayList<String> dateAcquired = (ArrayList<String>) request.getAttribute("dateAcquired");
	if (dateAcquired == null)
		dateAcquired = (ArrayList<String>) session.getAttribute("dateAcquired");
	session.setAttribute("dateAcquired", article);

	boolean isOdd = true;

	ArrayList<String> quantity = (ArrayList<String>) session.getAttribute("quantity");
	ArrayList<String> yearsInService = (ArrayList<String>) session.getAttribute("yearsInService");
	ArrayList<String> depreciation = (ArrayList<String>) session.getAttribute("depreciation");
	ArrayList<String> disposition = (ArrayList<String>) session.getAttribute("disposition");
	ArrayList<String> appraisal = (ArrayList<String>) session.getAttribute("appraisal");
	ArrayList<String> orNumber = (ArrayList<String>) session.getAttribute("orNumber");
	ArrayList<String> amount = (ArrayList<String>) session.getAttribute("amount");
%>


<form id="form3" name="form3" method="post" action="IIRUPForm3.do">

<div id="apDiv1" style="width: 100%">
<table width="100%" frame="box" cellspacing="0">
	<tr class="tableheaders">
		<td width="18%">Articles</td>
		<td width="6%">Quantity</td>
		<td width="6%">Unit Cost</td>
		<td width="7%">Property No.</td>
		<td width="8%">Date Acquired</td>
		<td width="9%">No. of<br />
		Years in Service</td>
		<td width="8%">Accumulated<br />
		Depreciation</td>
		<td width="9%">Disposition</td>
		<td width="6%">Appraisal</td>
		<td width="6%">O.R. #</td>
	</tr>
	<%
		for (int i = 0; article != null && i < article.size(); i++) {
	%>
	<tr
		<%if (isOdd)
					out.print("class=" + '"' + "tablerow_1" + '"');

				isOdd = !isOdd;%>>

		<td width="18%">
		<%
			if (article != null)
					out.print(article.get(i));
		%>
		</td>

		<td width="6%" align="center"><input name="quantity" type="text"
			class="textfields_1" id="quantity" size="5"
			<%if (quantity != null && !quantity.isEmpty()) {%>
			value="<%=quantity.get(i)%>" <%}%> /></td>

		<td width="6%">
		<%
			if (unitCost != null)
					out.print(unitCost.get(i));
		%>
		</td>

		<td width="7%">
		<%
			if (propertyNo != null)
					out.print(propertyNo.get(i));
		%>;</td>
		<td width="8%">
		<%
			if (propertyNo != null)
					out.print(dateAcquired.get(i));
		%>
		</td>

		<td width="9%" align="center"><input name="yearsInService"
			type="text" class="textfields_1" id="yearsInService" size="5"
			<%if (yearsInService != null && !yearsInService.isEmpty()) {%>
			value="<%=yearsInService.get(i)%>" <%}%> /></td>
		<td width="8%" align="center"><input name="depreciation"
			type="text" class="textfields_1" id="depreciation" size="5"
			<%if (depreciation != null && !depreciation.isEmpty()) {%>
			value="<%=depreciation.get(i)%>" <%}%> /></td>
		<td width="9%" align="center"><select name="disposition"
			id="disposition">
			<option value="<%=Disposal.DESTROYED%>">Destroyed</option>
			<option value="<%=Disposal.SOLD_AT_PRIVATE_SALE%>">Sold at
			Private Sale</option>
			<option value="<%=Disposal.SOLD_AT_PUBLIC_AUCTION%>">Sold at
			Public Auction</option>
			<option value="<%=Disposal.TRANSFERRED_WITHOUT_COST%>">Transferred
			Without Cost</option>
		</select></td>
		<td width="6%" align="center"><input name="appraisal" type="text"
			class="textfields_1" id="appraisal" size="5"
			<%if (appraisal != null && !appraisal.isEmpty()) {%>
			value="<%=appraisal.get(i)%>" <%}%> /></td>
		<td width="6%" align="center"><input name="orNumber" type="text"
			class="textfields_1" id="orNumber" size="5"
			<%if (orNumber != null && !orNumber.isEmpty()) {%>
			value="<%=orNumber.get(i)%>" <%}%> /></td>



	</tr>
	<%
		}
	%>
	<tr
		<%if (isOdd)
				out.print(" class=" + '"' + "tablerow_1" + '"');

			isOdd = !isOdd;%>>
		<td></td>
		<td></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>

	</tr>
</table>
</div>
<div id="apDiv4"><input name="nextBtn" type="submit"
	class="maroon" id="nextBtn" value="Next&gt;&gt;" /></div>
</form>


<div id="apDiv3">
<form id="form2" name="form2" method="get"
	action="SearchIIRUPItemList.do"><input name="addItem"
	type="submit" class="maroon" id="addItem" value="Add Article" /></form>
</div>
<p>&nbsp;</p>
<div id="apDiv5">

<form id="form4" name="form4" method="post" action="IIRUPRemoveItem.jsp"">
<input name="nextBtn2" type="submit" class="maroon" id="nextBtn2"
	value="Remove Items" /></form>
</div>
</body>
</html>
