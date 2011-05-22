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
			action="../view/IIRUPForm.jsp"><input name="backBtn"
			type="submit" class="button" id="backBtn" value="Back" /></form>
		</td>
	</tr>
</table>
<div id="apDiv1" style="width: 100%">
<table width="100%" border="1" cellspacing="0" class="tableheaders">
	<tr>
		<td width="18%">Articles</td>
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
</table>
</div>
<div id="apDiv2" style="width: 100%">
<%
	String asOfField = (String) request.getParameter("asOfField");
	String station = (String) request.getParameter("station");
	int articleLength = 0;
	if ((String) request.getParameter("articleLength") != null)
		articleLength = Integer.parseInt((String) request.getParameter("articleLength"));
	ArrayList<String> articleUnitNumbers = new ArrayList<String>();
	for (int i = 0; i < articleLength; i++) {
		articleUnitNumbers.add((String) request.getParameter("articleNumber" + i));
	}
%> <input name="auAsOfField" value="<%=asOfField%>" type="hidden" /> <input
	name="auStation" value="<%=station%>" type="hidden" /> <input
	name="articleLength" value="<%="" + articleLength%>" type="hidden" />
<%
	for (int i = 0; i < articleLength; i++) {
%> <input name="<%="articleNumber" + i%>"
	value="<%=articleUnitNumbers.get(i)%>" type="hidden" /> <%
 	}
 %>
<table width="100%" frame="box" cellspacing="0">

	<tr class="tablerow_1">
		<td width="18%">&nbsp;</td>
		<td width="6%" align="center">
		<form id="form4" name="form4" method="post" action=""><input
			name="quantity" type="text" class="textfields_1" id="quantity"
			size="5" /></form>
		</td>
		<td width="6%">&nbsp;</td>
		<td width="6%">&nbsp;</td>
		<td width="7%">&nbsp;</td>
		<td width="8%">&nbsp;</td>
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
		<form id="form1" name="form1" method="post" action="">
		<div align="center"><input name="removeBtn" type="submit"
			title="Remove Article" style="background-color: #C00"
			class="viewbutton" id="removeBtn" value="X" /></div>
		</form>
		</td>
	</tr>
	<tr>
		<td>
	
		</td>
		<td>
		</td>
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
	<tr class="tablerow_1">
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
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
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
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr class="tablerow_1">
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
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>
</div>
<div id="apDiv3">
<form id="form2" name="form2" method="post"
	action="IIRUP_Add_Item_2.html"><input name="addItem"
	type="submit" class="maroon" id="addItem" value="Add Article" /></form>
</div>
<div id="apDiv4">
<form id="form3" name="form3" method="post" action="IIRUP_Form_3.html">
<input name="nextBtn" type="submit" class="maroon" id="nextBtn"
	value="Next&gt;&gt;" /></form>
</div>
<p>&nbsp;</p>
</body>
</html>
