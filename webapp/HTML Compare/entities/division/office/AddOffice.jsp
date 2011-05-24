<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">

.labels{
	font-family:Lucida Grande;
	font-size:16px; 
	font-weight:bold;
}
#headerDiv {
	position:absolute;
	width:451px;
	height:25px;
	z-index:1;
	left: 431px;
	top: 178px;
}
#background {
	position:absolute;
	width:450px;
	height:234px;
	z-index:2;
	left: 432px;
	top: 205px;
}
#apDiv1 {
	position:absolute;
	width:413px;
	height:25px;
	z-index:3;
	left: 459px;
	top: 233px;
}
#apDiv2 {
	position:absolute;
	width:345px;
	height:25px;
	z-index:4;
	left: 487px;
	top: 277px;
}
#apDiv3 {
	position:absolute;
	width:338px;
	height:27px;
	z-index:5;
	left: 490px;
	top: 320px;
}
#apDiv4 {
	position:absolute;
	width:200px;
	height:46px;
	z-index:6;
	left: 627px;
	top: 376px;
}
#footer {
	position:absolute;
	width:451px;
	height:11px;
	z-index:7;
	left: 432px;
	top: 429px;
}
#apDiv5 {
	position:absolute;
	width:458px;
	height:271px;
	z-index:1;
	left: 428px;
	top: 174px;
}
</style>
</head>

<body>
<table width="100%" border="0">
  <tr>
    <td width="12%"><table width="100%" frame="below">
      <tr>
        <td style="font-family:Lucida Grande; font-size:20px; font-weight:bold; color:#003300">Add Office</td>
      </tr>
    </table></td>
    <td width="84%">&nbsp;</td>
    <td width="4%"><a href="../AddDivision.html" title="Back" target="main_frame">Back</a></td>
  </tr>
</table>
<div id="headerDiv" style="text-align:left; background-color:#7B1113; font-family:Lucida Grande; color:white; font-size:16px; font-weight:bold">Office Info</div>
<div id="apDiv1">
  <form id="form1" name="form1" method="post" action="">
    <label for="officeName" class="labels">Office Name:</label>
    <input name="officeName" type="text" id="officeName" size="30" />
  </form>
</div>
<div id="apDiv2">
  <form id="form2" name="form2" method="post" action="">
    <label for="officeID" class="labels">Office ID:</label>
    <input type="text" name="officeID" id="officeID" />
  </form>
</div>
<div id="apDiv4">
  <form id="form4" name="form4" method="post" action="">
    <input type="submit" name="addBtn" id="addBtn" style="background-color:#7B1113;color:white;font-family:Lucida Grande;font-size:20px;" value="Add" />
  </form>
</div>
<div id="footer" style="background-color:#7B1113;"></div>
<div id="apDiv5">
  <table width="100%" border="1">
    <tr>
      <td height="259">&nbsp;</td>
    </tr>
  </table>
</div>
<p>&nbsp;</p>
<div id="background" style="background-color:#EEE0E5;"></div>
<div id="apDiv3">
  <form id="form3" name="form3" method="post" action="">
    <label for="buildingList" class="labels">Building:</label>
    <select name="buildingList" id="buildingList">
    </select>
  </form>
</div>
</body>
</html>
