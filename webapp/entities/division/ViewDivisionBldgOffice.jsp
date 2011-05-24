<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
.required{
	color:red;
	font-size:10px; 
	font-family:Lucida Grande;
}
.addbutton{
	font-size:15px;
	font-family:Lucida Grande;
	background-color:#7B1113;
	color:white;
	border-left: 1px solid lightgray;
  border-right: 1px solid lightgray;
  border-top: 1px solid lightgray;
  border-bottom: 1px solid lightgray;
}

.addbutton:hover{
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
.labels{
	font-family:Lucida Grande;
	font-size:16px;
	font-weight:bold;
}
.header{
	text-align:left; 
	background-color:#7B1113; 
	font-family:Lucida Grande; 
	color:white; 
	font-size:16px; 
	font-weight:bold;
}
#headerDiv {
	position:absolute;
	width:605px;
	height:25px;
	z-index:1;
	left: 385px;
	top: 165px;
}
#background {
	background-color:#EEE0E5;
	position:absolute;
	width:605px;
	height:691px;
	z-index:0;
	left: 385px;
	top: 192px;
}
#addBuildingDiv {
	position:absolute;
	width:256px;
	height:263px;
	z-index:3;
	left: 441px;
	top: 216px;
}
#newBldgNameDiv {
	position:absolute;
	width:624px;
	height:27px;
	z-index:4;
	left: 43px;
	top: 61px;
}
#newBldgAdDiv {
	position:absolute;
	width:687px;
	height:28px;
	z-index:4;
	left: 28px;
	top: 101px;
}
#apDiv1 {
	position:absolute;
	width:63px;
	height:34px;
	z-index:4;
	left: 242px;
	top: 148px;
}
#border_1 {
	position:absolute;
	width:545px;
	height:236px;
	z-index:1;
	left: 417px;
	top: 208px;
}
#newAddFormDiv {
	position:absolute;
	width:412px;
	height:251px;
	z-index:4;
	left: 506px;
	top: 460px;
}
#apDiv2 {
	position:absolute;
	width:656px;
	height:28px;
	z-index:5;
	left: -45px;
}
#apDiv3 {
	position:absolute;
	width:67px;
	height:30px;
	z-index:5;
	left: 176px;
	top: 110px;
}
#border_2 {
	position:absolute;
	width:546px;
	height:186px;
	z-index:1;
	left: 418px;
	top: 454px;
}
#newOfficeFormDiv {
	position:absolute;
	width:619px;
	height:208px;
	z-index:5;
	left: 433px;
	top: 658px;
}
#apDiv4 {
	position:absolute;
	width:513px;
	height:27px;
	z-index:6;
	left: 45px;
	top: 61px;
}
#apDiv5 {
	position:absolute;
	width:250px;
	height:30px;
	z-index:6;
	left: 119px;
	top: 105px;
}
#apDiv6 {
	position:absolute;
	width:62px;
	height:32px;
	z-index:6;
	left: 247px;
	top: 159px;
}
#border_3 {
	position:absolute;
	width:546px;
	height:255px;
	z-index:1;
	left: 420px;
	top: 653px;
}
#addNewBtnDiv {
	position:absolute;
	width:258px;
	height:34px;
	z-index:6;
	left: 738px;
	top: 918px;
}
#apDiv7 {
	position:absolute;
	width:200px;
	height:16px;
	z-index:7;
	left: 438px;
	top: 378px;
}
#apDiv8 {
	position:absolute;
	width:200px;
	height:16px;
	z-index:8;
	left: 439px;
	top: 582px;
}
#apDiv9 {
	position:absolute;
	width:200px;
	height:16px;
	z-index:9;
	left: 441px;
	top: 832px;
}
#apDiv10 {
	position:absolute;
	width:612px;
	height:750px;
	z-index:0;
	left: 382px;
	top: 162px;
}
#apDiv11 {
	background-color:#7B1113;
	position:absolute;
	width:605px;
	height:9px;
	z-index:11;
	left: 386px;
	top: 884px;
}
</style>
</head>

<body>
<table width="100%" border="0">
  <tr>
    <td width="27%"><table width="100%" frame="below">
      <tr>
        <td style="font-family:Lucida Grande; font-size:20px; font-weight:bold; color:#003300">View Building/Division/Office</td>
      </tr>
    </table></td>
    <td width="69%">&nbsp;</td>
    <td width="4%"><form id="form15" name="form15" method="post" action="SearchDivisionOffice.jsp">
      <input name="backBtn" type="submit" class="button" id="backBtn" value="Back" />
    </form></td>
  </tr>
</table>
<div class="header" id="headerDiv">Edit Building/Division/Office</div>
<div id="background"></div>
<div id="addBuildingDiv">
  <form id="form1" name="form1" method="post" action="">
    <p>
      <label for="buildingDropdown" class="labels">Bldg. Name &amp; Address:</label>
      <select name="buildingDropdown" id="buildingDropdown">
      </select>
    </p>
    <p>&nbsp;</p>
    <div id="newBldgAdDiv">
      <label for="newBldgAd" class="labels">New Bldg. Address:</label>
      <input name="newBldgAd" type="text" id="newBldgAd" size="35" />
    </div>
    <p>&nbsp;</p>
    <div id="newBldgNameDiv">
      <label for="newBldgName" class="labels">*New Bldg. Name:</label>
      <input name="newBldgName" type="text" id="newBldgName" size="35" />
    </div>
    <p>&nbsp;</p>
    <div id="apDiv1">
      <input name="saveNewBldg" type="submit" class="button" id="saveNewBldg" value="Save" />
    </div>
    <p>&nbsp;</p>
  </form>
</div>
<div id="border_1">
  <table width="100%" border="1">
    <tr>
      <td height="199">&nbsp;</td>
    </tr>
  </table>
</div>
<div id="newAddFormDiv">
  <form id="form2" name="form2" method="post" action="">
    <p>
      <label for="divisionDropdown" class="labels">Division Name:</label>
      <select name="divisionDropdown" id="divisionDropdown">
      </select>
    </p>
    <div id="apDiv2">
      <label for="newDivisionName" class="labels">*New Division Name:</label>
      <input name="newDivisionName" type="text" id="newDivisionName" size="35" />
    </div>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <div id="apDiv3">
      <input name="saveNewDivisionBtn" type="submit" class="button" id="saveNewDivisionBtn" value="Save" />
    </div>
    <p>&nbsp;</p>
  </form>
</div>
<div id="border_2">
  <table width="100%" border="1">
    <tr>
      <td height="156">&nbsp;</td>
    </tr>
  </table>
</div>
<div id="newOfficeFormDiv">
  <form id="form3" name="form3" method="post" action="">
    <p>
      <label for="officeDropdown" class="labels">Office Name &amp; Division:</label>
      <select name="officeDropdown" id="officeDropdown">
      </select>
    </p>
    <div id="apDiv4">
      <label for="newOfficeNameField" class="labels">*New Office Name:</label>
      <input name="newOfficeNameField" type="text" id="newOfficeNameField" size="35" />
    </div>
    <p>&nbsp;</p>
    <div id="apDiv5">
      <label for="newDivisionAssignment" class="labels">*Division:</label>
      <select name="newDivisionAssignment" id="newDivisionAssignment">
      </select>
    </div>
    <p>&nbsp;</p>
    <div id="apDiv6">
      <input name="saveDivisionBtn" type="submit" class="button" id="saveDivisionBtn" value="Save" />
    </div>
    <p>&nbsp;</p>
  </form>
</div>
<div id="border_3">
  <table width="100%" border="1">
    <tr>
      <td height="203">&nbsp;</td>
    </tr>
  </table>
</div>
<div id="addNewBtnDiv">
  <form id="form4" name="form4" method="post" action="AddDivision.jsp">
    <input name="addAllBtn" type="submit" class="addbutton" id="addAllBtn" value="Add Building/Division/Office &gt;&gt;" />
  </form>
</div>
<div class="required" id="apDiv7"><em>*required field</em></div>
<div class="required" id="apDiv8"><em>*required field</em></div>
<div class="required" id="apDiv9"><em>*required fields</em></div>
<div id="apDiv10">
  <table width="100%" border="1">
    <tr>
      <td height="726">&nbsp;</td>
    </tr>
  </table>
</div>
<div id="apDiv11"></div>
<p>&nbsp;</p>
</body>
</html>
