<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.List"%>
<%@page import="com.iappsam.entities.DivisionOffice"%>
<%@page import="com.iappsam.util.Managers"%>
<%@page import="java.util.Date"%>
<%@page import="com.iappsam.util.DateUtil"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: New Purchase Request</title>
<link href="pr.css" rel="stylesheet" type="text/css" />
<link href="../style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="/logo.jsp" />
	<jsp:include page="/logout-button.jsp" />

	<!-- Breadcrubms should be here --->

	<div id="Title" class="Form"></div>

	<div id="PageHeader" class="Form">
		<form id="form1" name="form1" method="post" action="">
			<label for="prNumber" class="labels">Department &amp; Section: <select name="deptAndSection" id="deptAndSection" style="width: 200px;">
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
			</select> <br /> PR.No.:</label> <input name="prNumber" type="text" id="prNumber" size="15" maxlength="15" /> <label for="PRmonth" class="labels">Date:</label> <select
				name="PRmonth" id="PRmonth"
			>
				<option value="1">Jan</option>
				<option value="2">Feb</option>
				<option value="3">Mar</option>
				<option value="4">Apr</option>
				<option value="5">May</option>
				<option value="6">Jun</option>
				<option value="7">Jul</option>
				<option value="8">Aug</option>
				<option value="9">Sep</option>
				<option value="10">Oct</option>
				<option value="11">Nov</option>
				<option value="12">Dec</option>
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
			</select> <br /> <label for="saiNumber3" class="labels">SAI No.:</label> <input name="saiNumber" type="text" id="saiNumber3" size="15" maxlength="15" /> <label
				for="SAImonth3" class="labels"
			>Date:</label> <select name="SAImonth" id="SAImonth3">
				<option value="1">Jan</option>
				<option value="2">Feb</option>
				<option value="3">Mar</option>
				<option value="4">Apr</option>
				<option value="5">May</option>
				<option value="6">Jun</option>
				<option value="7">Jul</option>
				<option value="8">Aug</option>
				<option value="9">Sep</option>
				<option value="10">Oct</option>
				<option value="11">Nov</option>
				<option value="12">Dec</option>
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
			</select> <br /> <label for="alobsNumber2" class="labels">ALOBS No.:</label> <input name="alobsNumber" type="text" id="alobsNumber2" size="15"
				maxlength="15"
			/> <label for="ALOBSmonth2" class="labels">Date:</label> <select name="ALOBSmonth" id="ALOBSmonth2">
				<option value="1">Jan</option>
				<option value="2">Feb</option>
				<option value="3">Mar</option>
				<option value="4">Apr</option>
				<option value="5">May</option>
				<option value="6">Jun</option>
				<option value="7">Jul</option>
				<option value="8">Aug</option>
				<option value="9">Sep</option>
				<option value="10">Oct</option>
				<option value="11">Nov</option>
				<option value="12">Dec</option>
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
					for (int i = 0; i < 38; i++) {
				%>
				<option value="<%=i%>"><%=(1900 + date.getYear() - i)%></option>
				<%
					}
				%>
			</select>
			</p>
		</form>
	</div>



	<jsp:include page="../copyright.jsp" />
	<div id="line" class="Form">
		<table width="100%" border="0" cellspacing="0" id="TableHeader">
			<tr>
				<td width="7%">Quantity</td>
				<td width="9%">Unit of Issue</td>
				<td width="34%">Item Description</td>
				<td width="13%">Stock No.</td>
				<td width="13%">Estimated Unit<br /> Cost</td>
			</tr>
		</table>

		<table width="100%" frame="box" cellspacing="0">
			<tr class="tablerow_1">
				<td width="7%" align="center"><input name="quantity_1" type="text" class="textfields_1" id="quantity_1" size="4" /></td>
				<td width="9%">&nbsp;</td>
				<td width="34%">&nbsp;</td>
				<td width="13%">&nbsp;</td>
				<td width="13%" align="center"><input name="estUnitCost" type="text" class="textfields_1" id="estUnitCost" size="8" /></td>
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

	<div id="LineAction" class="Form">
		<a href="add-item.jsp">Add Item</a> <a href="rem-item.jsp">Remove Item</a>
	</div>

	<div id="PageFooter" class="Form">

		<label for="purpose" class="labels">Purpose:</label>
		<textarea name="purpose" id="purpose"></textarea>
		<br /> <label for="requestedBy" class="labels">Requested by:</label> <select name="requestedBy" id="requestedBy">
		</select> <label for="approvedby" class="labels">Approved by:</label> <select name="approvedby" id="approvedby">
		</select>
	</div>

	<div>Save</div>
</body>
</html>
