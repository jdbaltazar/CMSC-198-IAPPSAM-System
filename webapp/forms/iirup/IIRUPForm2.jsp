<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
	top: 112px;
}

#apDiv2 {
	position: absolute;
	width: 200px;
	height: 144px;
	z-index: 2;
	left: -1px;
	top: 151px;
}

#apDiv3 {
	position: absolute;
	width: 85px;
	height: 30px;
	z-index: 3;
	left: 582px;
	top: 343px;
}

#apDiv4 {
	position: absolute;
	width: 99px;
	height: 29px;
	z-index: 4;
	left: 702px;
	top: 343px;
}
</style>
</head>

<body>
<%
	String asOfField = (String) request.getParameter("asOfField");
	if (asOfField != null)
		session.setAttribute("asOfField", asOfField);

	String station = (String) request.getParameter("station");
	if (station != null)
		session.setAttribute("station", station);

	String accountableOfficer = (String) request.getParameter("accountableOfficer");
	if (accountableOfficer != null)
		session.setAttribute("accountableOfficer", accountableOfficer);

	ArrayList<String> article = (ArrayList<String>) request.getAttribute("article");
	ArrayList<String> unitCost = (ArrayList<String>) request.getAttribute("unitCost");
	ArrayList<String> propertyNo = (ArrayList<String>) request.getAttribute("propertyNo");
	ArrayList<String> dateAcquired = (ArrayList<String>) request.getAttribute("dateAcquired");
	boolean isOdd = true;
%>
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
		<form id="form15" name="form15" method="get"
			action="../iirup/IIRUPForm.jsp"><input name="backBtn"
			type="submit" class="button" id="backBtn" value="Back" /></form>
		</td>
	</tr>
</table>
<table width="100%" frame="box" cellspacing="0">
	<tr class="tableheaders">
		<td hwidth="18%">Articles</td>
		<td width="6%">Quantity</td>
		<td width="6%">Unit Cost</td>
		<td width="6%">Total Cost</td>
		<td width="7%">Property No.</td>
		<td width="8%">Date Acquired</td>
		<td width="9%">No. of<br />
		Years in Service</td>
		<td width="8%">Accumulated<br />
		Depreciation</td>
		<td width="9%">Disposition</td>
		<td width="6%">Appraisal</td>
		<td width="6%">O.R. #</td>
		<td width="5%">Amount</td>
		<td width="6%">ACTION</td>
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

		<td width="6%" align="center"><input
			name="<%out.print("quantity" + i);%>" type="text"
			class="textfields_1" id="quantity" size="5" /></td>

		<td width="6%">
		<%
			if (unitCost != null)
					out.print(unitCost.get(i));
		%>
		</td>

		<td width="6%">&nbsp;</td>
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
			type="text" class="textfields_1" id="yearsInService" size="5" /></td>
		<td width="8%" align="center"><input name="depreciation"
			type="text" class="textfields_1" id="depreciation" size="5" /></td>
		<td width="9%" align="center"><input name="disposition"
			type="text" class="textfields_1" id="disposition" size="5" /></td>
		<td width="6%" align="center"><input name="appraisal" type="text"
			class="textfields_1" id="appraisal" size="5" /></td>
		<td width="6%" align="center"><input name="orNumber" type="text"
			class="textfields_1" id="orNumber" size="5" /></td>
		<td width="5%" align="center"><input name="amount" type="text"
			class="textfields_1" id="amount" size="5" /></td>
		<td width="6%">
		<form id="form1" name="form1" method="post" action=""></form>
		</td>
		<div align="center"><input name="removeBtn" type="submit"
			title="Remove Article" style="background-color: #C00"
			class="viewbutton" id="removeBtn" value="X" /></div>
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
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>
<div id="apDiv3">
<form id="form2" name="form2" method="get"
	action="SearchIIRUPItemList.do"><input name="addItem"
	type="submit" class="maroon" id="addItem" value="Add Article" /></form>
</div>
<div id="apDiv4">
<form id="form3" name="form3" method="post" action="IIRUPForm3.jsp">
<input name="nextBtn" type="submit" class="maroon" id="nextBtn"
	value="Next&gt;&gt;" /></form>
</div>
<p>&nbsp;</p>
</body>
</html>
