<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: Edit Item Conditions</title>
<style type="text/css">
.menubtn{
	height:20px;
	width:416px;
	font-size:14px;
	font-family:Lucida Grande;
	background-color:#EEE0E5;
	color:#030;
	border-left: 1px solid lightgray;
  border-right: 1px solid lightgray;
  border-top: 1px solid lightgray;
  border-bottom: 1px solid lightgray;
}

.menubtn:hover{
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
	left: 1px;
	top: 623px;
	width: 100%;
}
#header {
	position:absolute;
	width:445px;
	height:21px;
	z-index:1;
	left: 509px;
	top: 303px;
}
#background {
	position:absolute;
	width:446px;
	height:162px;
	z-index:16;
	left: 509px;
	top: 326px;
}
#apDiv1 {
	position:absolute;
	width:419px;
	height:131px;
	z-index:17;
	left: 568px;
	top: 351px;
}
#apDiv2 {
	position:absolute;
	width:60px;
	height:35px;
	z-index:18;
	left: 125px;
	top: 77px;
}
#apDiv3 {
	position:absolute;
	width:447px;
	height:9px;
	z-index:18;
	left: 509px;
	top: 488px;
}
</style>
</head>

<body>
<div id="footer">
<table width="100%" frame="above" bordercolor="#333333" style="font-family:Verdana, Geneva, sans-serif; color:#333333; font-size:9px">
 <tr>
    <td>Copyright � 2011 All Rights Reserved</td>
  </tr>
</table>
</div>
<div id="logoHeader" style="width:100%"><img name="" src="../../../images/header2.png" width="100%" height="115" alt="" /></div>
<div id="pageLabel" style="width:100%;">
<table width="100%" border="0">
  <tr>
    <td width="17%"><table width="100%" frame="below">
      <tr>
        <td style="font-family:Lucida Grande; font-size:20px; font-weight:bold; color:#003300">View Item Condition</td>
      </tr>
    </table></td>
    <td width="79%">&nbsp;</td>
    <td width="4%"><form id="form15" name="form15" method="post" action="ViewItemConditions.jsp">
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
<div id="header" style="background-color:#7B1113;"></div>
<div id="background" style="background-color:#EEE0E5"></div>
<div id="apDiv1">
  <form id="form1" name="form1" method="post" action="">
    <p>
      <label for="conditionField" class="labels">Condition:</label>
      <input name="conditionField" type="text" id="conditionField" disabled="disabled" size="30" />
    </p>
    <p>&nbsp;</p>
    <div id="apDiv2">
      <input type="submit" name="updateBtn" id="updateBtn" value="Update" style="background-color:#7B1113;color:white;font-family:Lucida Grande;font-size:20px;" />
    </div>
    <p>&nbsp;</p>
  </form>
</div>
<div id="apDiv3" style="background-color:#7B1113;"></div>
</body>
</html>
