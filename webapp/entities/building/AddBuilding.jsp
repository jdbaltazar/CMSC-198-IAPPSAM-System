<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Add Building</title>
<style type="text/css">
.headerLabel{
	font-family:Lucida Grande; 
	color:white;
	 font-size:16px;
	 font-weight:bold;
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
#headerDiv {
	position:absolute;
	width:578px;
	height:25px;
	z-index:1;
	left: 423px;
	top: 333px;
}
#background {
	position:absolute;
	width:578px;
	height:198px;
	z-index:3;
	left: 423px;
	top: 357px;
}
#nameDiv {
	position:absolute;
	width:462px;
	height:268px;
	z-index:3;
	left: 561px;
	top: 371px;
}
#divisionIDdiv {
	position:absolute;
	width:447px;
	height:25px;
	z-index:4;
	left: 414px;
	top: 286px;
}
#apDiv1 {
	position:absolute;
	width:192px;
	height:25px;
	z-index:5;
	left: 460px;
	top: 516px;
}
#apDiv2 {
	position:absolute;
	width:390px;
	height:24px;
	z-index:6;
	left: 354px;
	top: 387px;
}
#apDiv3 {
	position:absolute;
	width:210px;
	height:27px;
	z-index:7;
	left: 409px;
	top: 388px;
}
#apDiv4 {
	position:absolute;
	width:200px;
	height:25px;
	z-index:8;
	left: 432px;
	top: 444px;
}
#apDiv5 {
	position:absolute;
	width:69px;
	height:41px;
	z-index:9;
	left: 1049px;
	top: 500px;
}
#apDiv6 {
	position:absolute;
	width:448px;
	height:27px;
	z-index:10;
	left: 444px;
	top: 440px;
}
#footer {
	background-color:#7B1113;
	position:absolute;
	width:578px;
	height:9px;
	z-index:10;
	left: 425px;
	top: 556px;
}
#border {
	position:absolute;
	width:859px;
	height:216px;
	z-index:1;
	left: 139px;
	top: 90px;
}
#apDiv7 {
	position:absolute;
	width:585px;
	height:247px;
	z-index:1;
	left: 119px;
	top: 89px;
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
#footer_2{
	position:absolute;
	left: 1px;
	top: 662px;
	width: 100%;
}
#apDiv8 {
	position:absolute;
	width:471px;
	height:25px;
	z-index:16;
	left: -13px;
	top: 72px;
}
#apDiv9 {
	position:absolute;
	width:63px;
	height:42px;
	z-index:16;
	left: 141px;
	top: 125px;
}
#apDiv10 {
	position:absolute;
	width:200px;
	height:22px;
	z-index:16;
	left: 439px;
	top: 334px;
}
#apDiv11 {
	position:absolute;
	width:100%;
	height:80%;
	z-index:0;
	left: 14px;
	top: 273px;
}
</style>
</head>

<body>
<div id="footer_2">
<table width="100%" frame="above" bordercolor="#333333" style="font-family:Verdana, Geneva, sans-serif; color:#333333; font-size:9px">
 <tr>
    <td>Copyright � 2011 All Rights Reserved</td>
  </tr>
</table>
</div>
<div id="logoHeader" style="width:100%"><img name="" src="../../images/header2.png" width="100%" height="115" alt="" /></div>
<div id="pageLabel" style="width:100%;">
<table width="100%" border="0">
  <tr>
    <td width="12%"><table width="100%" frame="below">
      <tr>
        <td style="font-family:Lucida Grande; font-size:20px; font-weight:bold; color:#003300">Add Building</td>
      </tr>
    </table></td>
    <td width="84%">&nbsp;</td>
    <td width="4%"><form id="form15" name="form15" method="post" action="SearchBuildings.jsp">
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
<div id="background"  style="background-color:#EEE0E5;"></div>
<div id="headerDiv" style="text-align:left; background-color:#7B1113; font-family:Lucida Grande; color:white; font-size:16px; font-weight:bold"></div>
<div id="nameDiv">
  <form id="form1" name="form1" method="post" action="saveBuilding.do">
    <p>
      <label for="name" style="font-family:Lucida Grande; font-size:16px; font-weight:bold">*Name:</label>
      <input name="name" type="text" id="name" value="" size="30" maxlength="80" />
    </p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <div id="apDiv8">
      <label for="address" style="font-family:Lucida Grande; font-size:16px; font-weight:bold">Address:</label>
      <input name="address" type="text" id="address" value="" size="30" maxlength="200" />
    </div>
    <p>&nbsp;</p>
    <div id="apDiv9">
      <input type="submit" name="addBtn" id="addBtn"  style="background-color:#7B1113;color:white;font-family:Lucida Grande;font-size:20px;" value="Add" />
    </div>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
  </form>
</div>
<div id="apDiv1" style="font-family:Lucida Grande; font-size:11px; color:red;">
  <form id="form3" name="form3" method="post" action="">
    <em>*required field</em>
  </form>
</div>
<div id="footer"></div>
<p>&nbsp;</p>
<div class="headerLabel" id="apDiv10" >Building Information</div>
<div id="apDiv11"></div>
</body>
</html>

