<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
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
	font-size:18px;
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
	left: 0px;
	top: 688px;
	width: 100%;
}
#border {
	position:absolute;
	width:200px;
	height:336px;
	z-index:16;
	left: 2px;
	top: 266px;
}
#divCategory {
	position:absolute;
	width:200px;
	height:22px;
	z-index:1;
	left: 507px;
	top: 77px;
}
#divUnit {
	position:absolute;
	width:200px;
	height:23px;
	z-index:2;
	left: 507px;
	top: 98px;
}
#divModOfProc {
	position:absolute;
	width:200px;
	height:23px;
	z-index:3;
	left: 507px;
	top: 206px;
}
#divItemStatus {
	position:absolute;
	width:200px;
	height:23px;
	z-index:4;
	left: 507px;
	top: 119px;
}
#divItemCond {
	position:absolute;
	width:200px;
	height:23px;
	z-index:5;
	left: 507px;
	top: 140px;
}
#divDisposal {
	position:absolute;
	width:200px;
	height:23px;
	z-index:6;
	left: 507px;
	top: 227px;
}
#apDiv1 {
	position:absolute;
	width:416px;
	height:16px;
	z-index:7;
	left: 507px;
	top: 60px;
}
#apDiv2 {
	position:absolute;
	width:416px;
	height:16px;
	z-index:8;
	left: 507px;
	top: 189px;
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
<div id="logoHeader" style="width:100%"><img name="" src="../../images/header2.png" width="100%" height="115" alt="" /></div>
<div id="pageLabel" style="width:100%;">
<table width="100%" border="0">
  <tr>
    <td width="15%"><table width="100%" frame="below">
      <tr>
        <td style="font-family:Lucida Grande; font-size:20px; font-weight:bold; color:#003300">Stock Properties</td>
      </tr>
    </table></td>
    <td width="81%">&nbsp;</td>
    <td width="4%"><form id="form15" name="form15" method="post" action="../../MenuFrame.jsp">
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
<div id="border" align="center" style="width:100%">
  <div id="divCategory">
    <form id="form1" name="form1" method="post" action="SearchAllItemCategories.do">
      <input name="categoryBtn" type="submit" class="menubtn" id="categoryBtn" value="Item Category" />
    </form>
  </div>
  <div id="divUnit">
    <form id="form3" name="form3" method="post" action="SearchAllItemUnits.do">
      <input name="unitBtn" type="submit" class="menubtn" id="unitBtn" value="Item Unit" />
    </form>
  </div>
  <div id="divModOfProc">
    <form id="form4" name="form4" method="post" action="SearchAllModes.do">
      <input name="modOfProc" type="submit" class="menubtn" id="modOfProc" value="Mode of Procurement" />
    </form>
  </div>
  <div id="divItemStatus">
    <form id="form5" name="form5" method="post" action="SearchAllItemStatus.do">
      <input name="itemStatus" type="submit" class="menubtn" id="itemStatus" value="Item Status" />
    </form>
  </div>
  <div id="divItemCond">
    <form id="form6" name="form6" method="post" action="SearchAllItemConditions.do">
      <input name="itemConditionBtn" type="submit" class="menubtn" id="itemConditionBtn" value="Item Condition" />
    </form>
  </div>
  <div id="divDisposal">
    <form id="form7" name="form7" method="post" action="SearchAllDisposal.do">
      <input name="disposalBtn" type="submit" class="menubtn" id="disposalBtn" value="Disposal" />
    </form>
  </div>
  <div class="header" id="apDiv1"></div>
  <div class="header" id="apDiv2"></div>
</div>
</body>
</html>
