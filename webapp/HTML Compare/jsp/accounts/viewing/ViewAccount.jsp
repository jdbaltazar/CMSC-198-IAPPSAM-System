<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
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

#personalInfo {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 1;
	left: 353px;
	top: 176px;
}

#titleDiv {
	position: absolute;
	width: 388px;
	height: 27px;
	z-index: 3;
	left: 462px;
	top: 190px;
}

#nameDiv {
	position: absolute;
	width: 462px;
	height: 24px;
	z-index: 3;
	left: 20px;
	top: 232px;
}

#background {
	position: absolute;
	width: 578px;
	height: 691px;
	z-index: 3;
	left: 353px;
	top: 202px;
}

#designationDiv {
	position: absolute;
	width: 455px;
	height: 24px;
	z-index: 3;
	left: 720px;
	top: 100px;
}

#apDiv1 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 4;
}

#empNumDiv {
	position: absolute;
	width: 447px;
	height: 25px;
	z-index: 4;
	left: 961px;
	top: 277px;
}

#Division {
	position: absolute;
	width: 535px;
	height: 28px;
	z-index: 5;
	left: 682px;
	top: 390px;
}

#officeDiv {
	position: absolute;
	width: 426px;
	height: 25px;
	z-index: 6;
	left: 839px;
	top: 476px;
}

#accountInfoHeader {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 7;
	left: 354px;
	top: 730px;
}

#apDiv2 {
	position: absolute;
	width: 397px;
	height: 23px;
	z-index: 8;
}

#userNameDiv {
	position: absolute;
	width: 483px;
	height: 25px;
	z-index: 8;
	left: 471px;
	top: 785px;
}

#passwordDiv {
	position: absolute;
	width: 462px;
	height: 24px;
	z-index: 9;
	left: 474px;
	top: 833px;
}

#reenterpassword {
	position: absolute;
	width: 469px;
	height: 24px;
	z-index: 10;
	left: 399px;
	top: 883px;
}

#sumbmitDivBtn {
	position: absolute;
	width: 90px;
	height: 75px;
	z-index: 11;
	left: 178px;
	top: 917px;
}

#employmentDiv {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 12;
	left: 353px;
	top: 321px;
}

#apDiv3 {
	position: absolute;
	width: 578px;
	height: 9px;
	z-index: 13;
	left: 353px;
	top: 894px;
}

#border {
	position: absolute;
	width: 585px;
	height: 765px;
	z-index: 1;
	left: 350px;
	top: 173px;
}

#contactInfoDiv {
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 14;
	left: 353px;
	top: 542px;
}

#apDiv4 {
	position: absolute;
	width: 426px;
	height: 29px;
	z-index: 15;
	left: 824px;
	top: 557px;
}

#apDiv5 {
	position: absolute;
	width: 302px;
	height: 25px;
	z-index: 16;
	left: 494px;
	top: 637px;
}

#apDiv6 {
	position: absolute;
	width: 422px;
	height: 25px;
	z-index: 17;
	left: 1028px;
	top: 522px;
}

#apDiv7 {
	position: absolute;
	width: 200px;
	height: 18px;
	z-index: 18;
	left: 379px;
	top: 897px;
}

#acctTypediv {
	position: absolute;
	width: 493px;
	height: 29px;
	z-index: 19;
	left: 438px;
	top: 834px;
}

#apDiv8 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 20;
	left: -448px;
	top: -25px;
}

#apDiv9 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 1;
}

#apDiv10 {
	position: absolute;
	width: 489px;
	height: 34px;
	z-index: 1;
	left: -12px;
	top: 641px;
}

#apDiv11 {
	position: absolute;
	width: 438px;
	height: 27px;
	z-index: 15;
	left: 22px;
	top: 595px;
}

#apDiv12 {
	position: absolute;
	width: 360px;
	height: 30px;
	z-index: 15;
	left: -24px;
	top: 491px;
}

#apDiv13 {
	position: absolute;
	width: 292px;
	height: 31px;
	z-index: 15;
	left: 32px;
	top: 443px;
}

#apDiv14 {
	position: absolute;
	width: 522px;
	height: 27px;
	z-index: 15;
	left: -51px;
	top: 401px;
}

#apDiv15 {
	position: absolute;
	width: 275px;
	height: 32px;
	z-index: 15;
	left: -1px;
	top: 306px;
}

#apDiv16 {
	position: absolute;
	width: 382px;
	height: 26px;
	z-index: 15;
	left: -18px;
	top: 260px;
}

#apDiv17 {
	position: absolute;
	width: 341px;
	height: 27px;
	z-index: 15;
	left: -74px;
	top: 216px;
}

#apDiv18 {
	position: absolute;
	width: 457px;
	height: 27px;
	z-index: 15;
	left: -52px;
	top: 173px;
}

#apDiv19 {
	position: absolute;
	width: 437px;
	height: 28px;
	z-index: 15;
	left: -2px;
	top: 82px;
}

#apDiv20 {
	position: absolute;
	width: 284px;
	height: 32px;
	z-index: 15;
	left: 9px;
	top: 32px;
}

#apDiv21 {
	position: absolute;
	width: 116px;
	height: 48px;
	z-index: 15;
	left: 140px;
	top: 747px;
}
</style>
</head>

<body>
<table width="100%" border="0">
	<tr>
		<td width="20%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">View/Update
				Account</td>
			</tr>
		</table>
		</td>
		<td width="76%">&nbsp;</td>
		<td width="4%">
		<form id="form15" name="form15" method="post"
			action="../ViewAccounts.html"><input name="backBtn"
			type="submit" class="button" id="backBtn" value="Back" /></form>
		</td>
	</tr>
</table>
<div id="background" style="background-color: #EEE0E5;"></div>
<div id="accountInfoHeader"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Account
Info</div>
<div id="employmentDiv"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Work
Info</div>
<div id="apDiv3" style="text-align: left; background-color: #7B1113;"></div>
<div id="border">
<table width="100%" height="730" border="1">
	<tr>
		<td height="724">&nbsp;</td>
	</tr>
</table>
</div>
<div id="contactInfoDiv"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Contact
Info</div>
<p>&nbsp;</p>
<div id="personalInfo"
	style="text-align: left; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Personal
Info</div>
<div id="titleDiv">
<form id="form1" name="form1" method="post" action="">
<p>&nbsp;</p>
<div id="apDiv20"><label for="title2"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Title:</label>
<input name="title" type="text" disabled="disabled" id="title2"
	size="20" /></div>
<p>&nbsp;</p>
<div id="apDiv19"><label for="name"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Name:</label>
<input name="name" type="text" disabled="disabled" id="name" size="40" />
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
  <div id="apDiv22">
      <table width="540" border="1">
        <tr>
          <th width="135" height="23" scope="col">Designation</th>
          <th width="135" scope="col">Employee Number</th>
          <th width="135" scope="col">Division</th>
          <th width="135" scope="col">Office</th>
        </tr>
      </table>
    </div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv12"><label for="emailad3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">E-mail
Address:</label> <select>
	<%
		int eNumber = ((ArrayList<String>) request.getAttribute("emailad")).size();
		ArrayList<String> emailad = (ArrayList<String>) request.getAttribute("emaild");
		if (eNumber >= 1) {
			out.print("<option select=" + '"' + "selected" + '"' + ">" + emailad.get(0) + "</option>");
			if (eNumber > 1) {
				for (int i = 1; i < eNumber; i++) {
					out.print("<option>" + emailad.get(i) + "</option>");
				}
			}
		}
	%>
</select></div>
<div id="apDiv13"><label for="landline3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Landline:</label>
<select>
	<%
		int lNumber = ((ArrayList<String>) request.getAttribute("landline")).size();
		ArrayList<String> landline = (ArrayList<String>) request.getAttribute("landline");
		if (lNumber >= 1) {
			out.print("<option select=" + '"' + "selected" + '"' + ">" + landline.get(0) + "</option>");
			if (lNumber > 1) {
				for (int i = 1; i < lNumber; i++) {
					out.print("<option>" + landline.get(i) + "</option>");
				}
			}
		}
	%>
</select></div>
<div id="apDiv14"><label for="mobileNumber3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Cellphone
Number:</label> <select>
	<%
		int mNumber = ((ArrayList<String>) request.getAttribute("mobileNumber")).size();
		ArrayList<String> mobileNumber = (ArrayList<String>) request.getAttribute("mobileNumber");
		if (mNumber >= 1) {
			out.print("<option select=" + '"' + "selected" + '"' + ">" + mobileNumber.get(0) + "</option>");
			if (mNumber > 1) {
				for (int i = 1; i < mNumber; i++) {
					out.print("<option>" + mobileNumber.get(i) + "</option>");
				}
			}
		}
	%>
</select></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv11"><label for="userName3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Username:</label>
<%=(String) request.getAttribute("userName")%></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv21"><input type="submit" name="updateBtn"
	id="updateBtn" value="Update"
	style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;" />
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><br />
</p>
</form>
<div id="apDiv10"><label for="acctType3"
	style="font-family: Lucida Grande; font-size: 16px; font-weight: bold">Account
Type: </label> <%=(String) request.getAttribute("acctType")%></div>
</div>
</body>
</html>
