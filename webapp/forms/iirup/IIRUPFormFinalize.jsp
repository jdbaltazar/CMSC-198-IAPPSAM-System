<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.util.Managers"%>
<%@page import="com.iappsam.entities.forms.Disposal"%>
<%@page import="com.iappsam.entities.forms.IIRUPLine"%>
<%@page import="java.util.Set"%>
<%@page import="com.iappsam.entities.forms.IIRUP"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="../../favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: IIRUP Form</title>
<style type="text/css">
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
#form5 {
	text-align: right;
}
#form6 blockquote p #exportToPDF {
	text-align: left;
}
#form6 blockquote p {
	text-align: center;
}
#form7 p {
	text-align: center;
}
</style>
</head>

<body>
<table width="100%" border="0" cellspacing="0">
	<tr>
		<td width="4%">
		<form id="form5" name="form5" method="post" action="SearchIIRUPForm.do">
		  <input
			name="backBtn" type="submit" class="button" id="backBtn" value="Back" />
		  <span id="form5"></span>
		</form>
		</td>
	</tr>
</table>
<div id="apDiv1"></div>
<br />
<table width="122%" border="1">
	<%
		IIRUP iirupForm = (IIRUP) request.getAttribute("iirupForm");
			if (iirupForm == null) {
		String iirupID = (String) request.getParameter("iirupID");
		if(iirupID==null)
			iirupID=(String)request.getAttribute("iirupID");
		request.setAttribute("iirupID",iirupID);
		iirupForm = Managers.iirupManager.getIIRUP(Integer.parseInt(iirupID));
			}
			Set<IIRUPLine> iirupLines = iirupForm.getLines();

			int maxLines = iirupLines.size();
	%>
	<tr>
		<td>
		<p align="center"><strong>INVENTORY AND INSPECTION REPORT
		OF UNSERVICEABLE PROPERTY</strong><br />
		As of <input name="asOf" type="text" id="asOf" readonly="readonly"
			value="<%=iirupForm.getAsOfDate().toString()%>" /></p>
		<table width="100%" border="0">
			<tr>
				<td width="19%" align="left">
				<div align="center"><strong>UP Visayas Tacloban
				College</strong><br />
				</div>
				</td>
				<td width="28%" rowspan="2">
				<div align="center">
				<form id="form1" name="form1" method="post" action=""><input
					name="acctableOfficer" type="text" id="acctableOfficer" size="30"
					readonly="readonly"
					value="<%out.print(iirupForm.getAccountableOfficer().getPerson().getTitle() + " " + iirupForm.getAccountableOfficer().getPerson().getName());%>" />
				<br />
				(Name of Accountable Officer)</form>
				</div>
				</td>
				<td width="25%" rowspan="2">
				<div align="center">
				<form id="form2" name="form2" method="post" action=""><input
					name="designation" type="text" id="designation" size="30"
					readonly="readonly"
					value="<%out.print(iirupForm.getAccountableOfficer().getDesignation());%>" />
				<br />
				(Designation)</form>
				</div>
				</td>
				<td width="28%" rowspan="2">
				<div align="center">
				<form id="form3" name="form3" method="post" action=""><input
					name="station" type="text" id="station" size="30"
					readonly="readonly" value="<%=iirupForm.getStation()%>" /> <br />
				(Station)</form>
				</div>
				</td>
			</tr>
			<tr>
				<td align="left">
				<div align="center">(Agency)</div>
				</td>
			</tr>
		</table>
		<table width="100%" border="1">
			<tr>
				<th colspan="8" scope="col">INVENTORY</th>
				<th colspan="8" scope="col">INSPECTION REPORT</th>
			</tr>
			<tr>
				<td width="14%" rowspan="2">
				<div align="center">Articles<br />
				(1)</div>
				</td>
				<td width="5%" rowspan="2">
				<div align="center">Quantity<br />
				(2)</div>
				</td>
				<td width="5%" rowspan="2">
				<div align="center">Unit Cost<br />
				(3)</div>
				</td>
				<td width="5%" rowspan="2">
				<div align="center">Total Cost<br />
				(4)</div>
				</td>
				<td width="6%" rowspan="2">
				<div align="center">Property No.<br />
				(5)</div>
				</td>
				<td width="6%" rowspan="2">
				<div align="center">Date<br />
				Acquired<br />
				(6)</div>
				</td>
				<td width="6%" rowspan="2">
				<div align="center">No. of years<br />
				in service<br />
				(7)</div>
				</td>
				<td width="7%" rowspan="2">
				<div align="center">Accumulated<br />
				Depreciation<br />
				(8)</div>
				</td>
				<td colspan="5">
				<div align="center">DISPOSITION</div>
				</td>
				<td width="9%" rowspan="2" align="center">Appraisal<br />
				(14)</td>
				<td width="7%" rowspan="2" align="center">Official<br />
				Receipt<br />
				Number<br />
				(15)</td>
				<td width="9%" rowspan="2" align="center">Amount<br />
				(16)</td>
			</tr>
			<tr>
				<td>
				<div align="center" style="font-size: 8">Destroyed</div>
				</td>
				<td>
				<div align="center" style="font-size: 8">Sold</div>
				</td>
				<td>
				<div align="center" style="font-size: 8">Continued Service</div>
				</td>
				<td>
				<div align="center" style="font-size: 8">To Be Salvaged</div>
				</td>
				<td>
				<div align="center" style="font-size: 8">Total</div>
				</td>
			</tr>

			<%
				for (IIRUPLine line : iirupLines) {
			%>
			<tr>
				<td>
				<div align="center"><input name="article" type="text"
					id="article" size="30" readonly="readonly"
					value="<%=line.getItem().getDescription()%>" /></div>
				</td>
				<td>
				<div align="center"><input name="quantity" type="text"
					id="quantity" size="5" readonly="readonly"
					value="<%=line.getQuantity()%>" /></div>
				</td>
				<td>
				<div align="center"><input name="unitCost" type="text"
					id="unitCost" size="7" readonly="readonly"
					value="<%=line.getItem().getPrice()%>" /></div>
				</td>
				<td>
				<div align="center"><input name="totalCost" type="text"
					id="totalCost" size="7" readonly="readonly"
					value="<%out.print("" + line.getItem().getPrice() * line.getQuantity());%>" /></div>
				</td>
				<td>
				<div align="center"><input name="propertyNumber" type="text"
					id="propertyNumber" size="5" readonly="readonly"
					value="<%=line.getItem().getPropertyNumber()%>" /></div>
				</td>
				<td>
				<div align="center"><input name="dateAcquired" type="text"
					id="dateAcquired" size="7" readonly="readonly"
					value="<%if (line.getItem().getDateAcquired() != null)
					out.print(line.getItem().getDateAcquired().toString());
				else
					out.print("N/A ");%>" /></div>
				</td>
				<td>
				<div align="center"><input name="yearsInService" type="text"
					id="yearsInService" size="5" readonly="readonly"
					value="<%=line.getYearsInService()%>" /></div>
				</td>
				<td>
				<div align="center"><input name="accumulatedDepreciation"
					type="text" id="accumulatedDepreciation" size="7"
					readonly="readonly" value="<%=line.getAccumulatedDepreciation()%>" /></div>
				</td>
				<td width="4%">
				<div align="center"><input name="disposition9" type="text"
					id="disposition9" size="2" readonly="readonly"
					value="<%if (line.getDisposal().getName().equalsIgnoreCase(Disposal.DESTROYED))
					out.print("X");%>" /></div>
				</td>
				<td width="4%">
				<div align="center"><input name="disposition10" type="text"
					id="disposition10" size="2" readonly="readonly"
					value="<%if (line.getDisposal().getName().equalsIgnoreCase(Disposal.SOLD_AT_PRIVATE_SALE))
					out.print("X");%>" /></div>
				</td>
				<td width="4%">
				<div align="center"><input name="disposition11" type="text"
					id="disposition11" size="2" readonly="readonly"
					value="<%if (line.getDisposal().getName().equalsIgnoreCase(Disposal.SOLD_AT_PUBLIC_AUCTION))
					out.print("X");%>" /></div>
				</td>
				<td width="4%">
				<div align="center"><input name="disposition12" type="text"
					id="disposition12" size="2" readonly="readonly"
					value="<%if (line.getDisposal().getName().equalsIgnoreCase(Disposal.TRANSFERRED_WITHOUT_COST))
					out.print("X");%>" /></div>
				</td>
				<td width="5%">
				<div align="center"><input name="disposition13" type="text"
					id="disposition13" size="2" readonly="readonly"
					value="<%=line.getQuantity()%>" /></div>
				</td>
				<td>
				<div align="center"><input name="appraisal" type="text"
					id="appraisal" size="8" readonly="readonly"
					value="<%=line.getAppraisal()%>" /></div>
				</td>
				<td>
				<div align="center"><input name="orNumber" type="text"
					id="orNumber" size="8" readonly="readonly"
					value="<%=line.getOrNumber()%>" /></div>
				</td>
				<td>
				<div align="center"><input name="amount" type="text"
					id="amount" size="5" readonly="readonly"
					value="<%out.print("" + line.getItem().getPrice() * line.getQuantity());%>" /></div>
				</td>
			</tr>

			<%
				}
			%>
		</table>
		<table width="101%" border="0">
			<tr>
				<td width="37%">
				<blockquote>I HEREBY request inspection, and
				disposition pursuant to section 79 of PD 1445, of the property
				enumerated above</blockquote>
				</td>
				<td width="27%">
				<blockquote>I CERTIFY that I have inspected each and
				every article enumerated in this report and that the disposition
				made thereof was, in my judgment, the best for the public interest.</blockquote>
				</td>
				<td width="36%">
				<blockquote>I CERTIFY that I have witnessed the
				disposition of the articles enumerated<br />
				on this <input name="dayCertified" type="text" id="dayCertified"
					size="3" readonly="readonly"
					value="<%=iirupForm.getAsOfDate().getDay()%>" /> day of <input
					name="monthCertified" type="text" id="monthCertified" size="10"
					readonly="readonly" value="<%=iirupForm.getAsOfDate().getMonth()%>" />
				, <input name="yearCertified" type="text" id="yearCertified"
					size="5" readonly="readonly"
					value="<%=iirupForm.getAsOfDate().getYear()%>" /> .</blockquote>
				</td>
			</tr>
		</table>
		<table width="100%" border="0">
			<tr>
				<td width="33%"><strong>Requested by:</strong></td>
				<td width="29%"><strong>Approved by:</strong></td>
				<td width="20%">&nbsp;</td>
				<td width="18%">&nbsp;</td>
			</tr>
			<tr>
				<td align="center"><%=iirupForm.getRequestedBy().getPerson().getName()%></td>
				<td align="center">
				<form id="form4" name="form4" method="post" action=""><input
					name="approvedByName" type="text" id="approvedByName" size="35"
					readonly="readonly"
					value="<%=iirupForm.getApprovedBy().getPerson().getName()%>" /></form>
				</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align="center">(Signature of Accountable Officer)</td>
				<td align="center">(Name and Signature)</td>
				<td align="center"><input name="inspector" type="text"
					id="inspector" size="35" readonly="readonly"
					value="<%=iirupForm.getInspector().getPerson().getName()%>" /></td>
				<td align="center"><input name="witness" type="text"
					id="witness" size="35" readonly="readonly"
					value="<%=iirupForm.getWitness().getPerson().getName()%>" /></td>
			</tr>
			<tr>
				<td align="center">&nbsp;</td>
				<td align="center">&nbsp;</td>
				<td align="center">(Name and Signature of Inspector)</td>
				<td align="center">(Name and Signature of Witness)</td>
			</tr>
			<tr>
				<td align="center"><%=iirupForm.getRequestedBy().getPerson().getName()%></td>
				<td align="center"><input name="approvedBy_designation"
					type="text" id="approvedBy_designation" size="35"
					readonly="readonly"
					value="<%=iirupForm.getApprovedBy().getDesignation()%>" /></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align="center">(Signature of Accountable Officer)</td>
				<td align="center">(Designation)</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<p>&nbsp;</p>
<table width="100%" border="0" cellspacing="0">
	<tr>
		<td width="40%">&nbsp;</td>
		<td width="18%"><form id="form7" name="form7" method="post" action="IIRPExport.do">
		  <p>
		    <span style="text-align: center"></span>
		    <span style="text-align: center"></span>
		    <input type="hidden" name="exportType" value="pdf"/>
		    <input
			name="exportBtn2" type="submit" class="maroon" id="exportBtn2"
			style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;"
			value="Export to PDF" export="Export"" />
	      <span style="text-align: center"></span>	      <span style="text-align: center"></span> </p>
        </form></td>
		<td width="18%" align="center">
		<form id="form6" name="form6" method="post" action="IIRUPExport.do">
		  <blockquote>
		    <p>
		      <label for="exportToPDF"></label>
		      
		    <input type="hidden" name="exportType" value="excel"/>
		      <span style="text-align: center"></span>
		      <input
			name="exportBtn" type="submit" class="maroon" id="exportBtn"
			style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;"
			value="Export to Excel" Export" />
		    </p>
	      </blockquote>
		</form>
	  </td>
		<td width="24%">&nbsp;</td>
	</tr>
</table>
</body>
</html>
