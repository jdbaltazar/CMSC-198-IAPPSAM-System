<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.List"%>
<%@page import="com.iappsam.entities.Account"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
.button2{
	font-size:14px;
	font-family:Lucida Grande;
	background-color:white;
	color:#7B1113;
	border-left: 1px solid lightgray;
  border-right: 1px solid lightgray;
  border-top: 1px solid lightgray;
  border-bottom: 1px solid lightgray;
}

.button2:hover{
	font-weight:bold;
	color:#060;
/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
  border-right: 1px solid #7B1113;
  border-top: 1px solid #7B1113;
  border-bottom: 1px solid #7B1113;
}
.header{
	background-color:#7B1113;
	width:578px;
	height:25px;
}

.background{
	background-color:#EEE0E5;
	width:578px;
}
.resultTable{
	font-family:Lucida Grande;
}

.tablerow_1{
	background-color:#EEE0E5;
}
.viewbutton{
	font-size:12px;
	font-family:"Courier New", Courier, monospace;
	background-color:#7B1113;
	color: white;
	border:none;
}
.viewbutton:hover{
	border:none;
	font-weight:bold;
}
.tableheaders{
	background-color:#5E2605;
	color:white;
	font-family:Lucida Grande;
	font-size:14px;
	text-align:center;
}
.maroon{
	font-size:12px;
	font-family:Lucida Grande;
	background-color:#7B1113;
	color:white;
	border-left: 1px solid lightgray;
  border-right: 1px solid lightgray;
  border-top: 1px solid lightgray;
  border-bottom: 1px solid lightgray;
}

.maroon:hover{
	font-weight:bold;
/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
  border-right: 1px solid #7B1113;
  border-top: 1px solid #7B1113;
  border-bottom: 1px solid #7B1113;
}

.labels{
	font-family:Lucida Grande;
	font-size:16px;
	font-weight:bold;
}
.button{
	font-size:14px;
	font-family:Lucida Grande;
	background-color:white;
	color:#7B1113;
	border-left: 1px solid lightgray;
  border-right: 1px solid lightgray;
  border-top: 1px solid lightgray;
  border-bottom: 1px solid lightgray;
}

.button:hover{
	font-weight:bold;
	color:#060;
/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
  border-right: 1px solid #7B1113;
  border-top: 1px solid #7B1113;
  border-bottom: 1px solid #7B1113;
}

.header{
	text-align:center;
	text-shadow:#999;
	font-family:Lucida Grande; 
	font-size:16px; 
	font-weight:bold;
}
#apDiv1 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:1;
	left: 59px;
	top: 94px;
}
#tables {
	position:absolute;
	width:500px;
	height:458px;
	z-index:1;
	left: 427px;
	top: 162px;
}
#header {
	background-color:#7B1113;
	position:absolute;
	width:778px;
	height:25px;
	z-index:2;
	left: 1px;
	top: 325px;
}
#apDiv2 {
	position:absolute;
	width:175px;
	height:30px;
	z-index:3;
	left: 620px;
	top: 661px;
}
#apDiv3 {
	position:absolute;
	width:667px;
	height:349px;
	z-index:3;
	left: -963px;
	top: 398px;
}
#apDiv4 {
	position:absolute;
	width:778px;
	height:26px;
	z-index:4;
	left: 1px;
	top: 352px;
}
#apDiv5 {
	position:absolute;
	width:777px;
	height:142px;
	z-index:5;
	left: 2px;
	top: 374px;
}
#pageLabel {
	position:absolute;
	width:200px;
	height:50px;
	z-index:1;
	top:181px;
	left: 13px;
}
#logoHeader {
	position:absolute;
	width:200px;
	height:115px;
	z-index:1;
}
#logoutiv {
	position:absolute;
	width:200px;
	height:30px;
	z-index:15;
	left: 14px;
	top: 143px;
}
#footer{
	position:absolute;
	left: -3px;
	top: 681px;
	width: 100%;
}
</style>
</head>

<body>
<div id="footer">
<table width="100%" frame="above" bordercolor="#333333" style="font-family:Verdana, Geneva, sans-serif; color:#333333; font-size:9px">
 <tr>
    <td>Copyright © 2011 All Rights Reserved</td>
  </tr>
</table>
</div>
<div id="logoHeader" style="width:100%"><img name="" src="../images/header2.png" width="100%" height="115" alt="" /></div>
<div id="pageLabel" style="width:100%;">
<table width="100%" border="0">
  <tr>
    <td width="14%"><table width="100%" frame="below">
      <tr>
        <td style="font-family:Lucida Grande; font-size:20px; font-weight:bold; color:#003300">View Accounts</td>
      </tr>
    </table></td>
    <td width="82%">&nbsp;</td>
    <td width="4%"><form id="form15" name="form15" method="post" action="../menu.jsp">
      <input name="backBtn" type="submit" class="button" id="backBtn" value="Back" />
    </form></td>
  </tr>
</table>
</div>
<div id="logoutiv" style="width:90%">
  <form id="form2" name="form2" method="post" action="">
    <input name="logout" type="submit" class="maroon" id="logout" value="Logout" />
  </form>
</div>
<table width="100%" border="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<div id="header" style="text-align:center; background-color:#7B1113; font-family:Lucida Grande; color:white; font-size:16px; font-weight:bold; width:100%;">Existing Accounts</div>
<div id="apDiv4" style="width:100%">
  <table width="100%" border="1" cellspacing="0" class="tableheaders">
    <tr>
      <td width="33%">Account Type</td>
      <td width="49%">Name</td>
      <td width="18%">Action</td>
    </tr>
  </table>
</div>
<div id="apDiv5" style="width:100%">
  <table width="100%" frame="box" cellspacing="0">
    <%
		boolean isOdd = false;
		List<Account> accounts = (List<Account>) request.getAttribute("accounts");
		for (int i = 0; i < accounts.size(); i++) {
	%>
	<tr <%if (isOdd) {%> class="tablerow_1" <%}
				isOdd = !isOdd;%>>
		<td width="33%"><%=accounts.get(i).getType().toString()%></td>
		<td width="49%"><%=accounts.get(i).getPerson().getName()%></td>
		<td width="18%" align="center">
		<form id="form1" name="form1" method="get"
			action="viewing/ViewAccount.do"><input name="viewBtn"
			type="submit" class="maroon" id="viewBtn" value="View &gt;&gt;" /> <input
			name="userName" type="hidden" value="<%=accounts.get(i).getUsername()%>"/></form>
		</td>
	</tr>
	<%
		}
	%>
  </table>
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</body>
</html>
