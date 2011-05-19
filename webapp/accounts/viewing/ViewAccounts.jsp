<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
.button {
	font-family: "Courier New", Courier, monospace;
	background-color: white;
	border: none;
}

.button:hover {
	color: #0F3;
	border: none;
}

.header {
	text-align: center;
	text-shadow: #999;
	font-family: Lucida Grande;
	font-size: 16px;
	font-weight: bold;
}

#apDiv1 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 1;
	left: 59px;
	top: 94px;
}

#tables {
	position: absolute;
	width: 500px;
	height: 458px;
	z-index: 1;
	left: 427px;
	top: 162px;
}

#header {
	background-color: #7B1113;
	position: absolute;
	width: 669px;
	height: 25px;
	z-index: 2;
	left: 327px;
	top: 165px;
}

#apDiv2 {
	position: absolute;
	width: 175px;
	height: 30px;
	z-index: 3;
	left: 620px;
	top: 661px;
}

#apDiv3 {
	position: absolute;
	width: 667px;
	height: 349px;
	z-index: 3;
	left: 327px;
	top: 192px;
}
</style>
</head>

<body>
<table width="100%" border="0">
	<tr>
		<td width="16%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">View
				Accounts</td>
			</tr>
		</table>
		</td>
		<td width="80%">&nbsp;</td>
		<td width="4%"><a href="../MenuFrame.html"
			title="Back to main menu" target="main_frame">Home</a></td>
	</tr>
</table>
<table width="100%" border="0">
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>
<div id="header"
	style="text-align: center; background-color: #7B1113; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Existing
Accounts</div>
<div id="apDiv3">
<table width="100%" border="1">
	<tr>
		<td width="28%" class="header">Username</td>
		<td width="24%" class="header">Account Type</td>
		<td width="32%" class="header">Name</td>
		<td width="16%" class="header">Action</td>
	</tr>
	<%
		//List<String> userName =(List<String>) request.getAttribute("userName");
		//List<String> acctType = (List<String>) request.getAttribute("acctType");
		//List<String> name = (List<String>) request.getAttribute("name");
		//int listSize = Integer.parseInt((String)request.getAttribute("listSize"));
		int listSize = 10;
		ArrayList<String> userName = new ArrayList<String>();
		ArrayList<String> acctType = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();
		for (int j = 0; j < 10; j++) {
			userName.add("user" + j);
			acctType.add("acctType" + j);
			name.add("name" + j);

		}

		for (int i = 0; i < listSize; i++) {
			out.print("<tr><td>" + userName.get(i) + "</td>" + "<td>" + acctType.get(i) + "</td>" + "<td>" + name.get(i) + "</td>" + "<td align=" + '"' + "center" + '"' + ">" + "<form id=" + '"' + "form1" + '"' + " name=+" + '"' + "form1" + '"'
					+ " method=" + '"' + "post" + '"' + " action=" + '"' + "./ViewAccount.do" + '"' + "><input type=" + '"' + "submit" + '"' + " name=" + '"' + "viewAccoutnBtn" + i + '"' + " id=" + '"' + "viewAccoutnBtn" + i + '"' + " class="
					+ '"' + "button" + '"' + " value=" + '"' + "View" + '"' + "/>" + "<%" + "request.setAttribute(" + '"' + "acctID" + '"' + "," + '"' + userName.get(i) + '"' + ")" + '%' + ">" + "</form></td></tr>");
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
