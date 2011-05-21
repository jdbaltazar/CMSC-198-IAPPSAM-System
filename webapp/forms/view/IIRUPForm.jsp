<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.servlet.forms.IIRUPFormUtil"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	ArrayList<String> articleName = (ArrayList<String>) request.getAttribute("articleName");
	ArrayList<String> quantity = (ArrayList<String>) request.getAttribute("quantity");
	ArrayList<String> unitCost = (ArrayList<String>) request.getAttribute("unitCost");
	ArrayList<String> totalCost = (ArrayList<String>) request.getAttribute("totalCost");
	ArrayList<String> propertyNo = (ArrayList<String>) request.getAttribute("propertyNo");
	ArrayList<String> dateAcquired = (ArrayList<String>) request.getAttribute("dateAcquired");
	ArrayList<String> noOfYearsInService = (ArrayList<String>) request.getAttribute("noOfYearsInService");
	ArrayList<String> accumulatedDepreciation = (ArrayList<String>) request.getAttribute("accumulatedDepreciation");
	ArrayList<String> disposition = (ArrayList<String>) request.getAttribute("disposition");
	ArrayList<String> appraisal = (ArrayList<String>) request.getAttribute("appraisal");
	ArrayList<String> orNumber = (ArrayList<String>) request.getAttribute("orNumber");
	ArrayList<String> amount = (ArrayList<String>) request.getAttribute("amount");
	if (articleName == null || articleName.isEmpty())
		request.setAttribute("articleName", articleName);
	if (quantity == null || quantity.isEmpty())
		request.setAttribute("quantity", quantity);
	if (unitCost == null || unitCost.isEmpty())
		request.setAttribute("unitCost", unitCost);
	if (totalCost == null || totalCost.isEmpty())
		request.setAttribute("totalCost", totalCost);
	if (propertyNo == null || propertyNo.isEmpty())
		request.setAttribute("propertyNo", propertyNo);
	if (dateAcquired == null || dateAcquired.isEmpty())
		request.setAttribute("dateAcquired", dateAcquired);
	if (noOfYearsInService == null || noOfYearsInService.isEmpty())
		request.setAttribute("noOfYearsInService", noOfYearsInService);
	if (accumulatedDepreciation == null || accumulatedDepreciation.isEmpty())
		request.setAttribute("accumulatedDepreciation", accumulatedDepreciation);
	if (disposition == null || disposition.isEmpty())
		request.setAttribute("disposition", disposition);
	if (appraisal == null || appraisal.isEmpty())
		request.setAttribute("appraisal", appraisal);
	if (orNumber == null || orNumber.isEmpty())
		request.setAttribute("orNumber", orNumber);
	if (amount == null || amount.isEmpty())
		request.setAttribute("amount", amount);
%>
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
	left: 398px;
	top: 143px;
}

#background {
	position: absolute;
	width: 578px;
	height: 256px;
	z-index: 2;
	left: 398px;
	top: 169px;
}

#apDiv1 {
	position: absolute;
	width: 290px;
	height: 309px;
	z-index: 3;
	left: 556px;
	top: 178px;
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
	width: 185px;
	height: 44px;
	z-index: 4;
	left: 418px;
	top: 235px;
}

#apDiv4 {
	position: absolute;
	width: 429px;
	height: 33px;
	z-index: 5;
	left: -54px;
	top: 117px;
}

#apDiv5 {
	position: absolute;
	width: 386px;
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
	left: 104px;
	top: 208px;
}

#apDiv7 {
	position: absolute;
	width: 579px;
	height: 9px;
	z-index: 5;
	left: 398px;
	top: 426px;
}
</style>
</head>
<%
	IIRUPFormUtil get = new IIRUPFormUtil();
%>
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
		<form id="form15" name="form15" method="post"
			action="../../MenuFrame.html"><input name="backBtn"
			type="submit" class="button" id="backBtn" value="Back" /></form>
		</td>
	</tr>
</table>
<div class="background" id="background"></div>
<div id="apDiv1">
<form id="form1" name="form1" method="post" action="../IIRUPForm2.jsp">
<p><label for="asOfField" class="labels">As of:</label> <input
	type="text" name="asOfField" id="asOfField" /></p>
<div id="apDiv2"><label for="nameOfAcctableOfficer"></label> <input
	name="nameOfAcctableOfficer" type="text" id="nameOfAcctableOfficer"
	size="35"
	value="<%out.print(request.getAttribute("nameOfAcctableOfficer"));
	if (request.getAttribute("nameOfAcctableOfficer") != null)
				out.print(request.getAttribute("nameOfAcctableOfficer"));%>" /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv4"><label for="designation" class="labels">Designation:</label>
<select name="designation" id="designation">
	<%
		ArrayList<String> designationName = get.getdesignationName();
		for (int i = 0; i < designationName.size(); i++) {
	%><option><%=designationName.get(i)%><option />
	<%
		}
	%>
	
</select></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv5"><label for="station" class="labels">Station:</label>
<input name="station" type="text" id="station" size="30" /></div>
<div id="apDiv6"><input name="nextBtn" type="submit"
	class="maroon" id="nextBtn" value="Next&gt;&gt;" /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>

</form>
</div>
<div class="labels" id="apDiv3">
<div align="right">Name of <br />
Accountable Officer:</div>
</div>
<div class="header" id="apDiv7"></div>
<p>&nbsp;</p>
<div class="header" id="headerDiv"></div>
</body>
</html>
