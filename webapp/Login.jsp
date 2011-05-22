<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
.misc{
	color:#090;
	font-family:Lucida Grande;
	font-size:12px; 
	font-weight:bold;
}
.labels{
	font-family:Lucida Grande;
	font-size:14px; 
	font-weight:bold;
}
#header {
	position:absolute;
	width:364px;
	height:26px;
	z-index:1;
	left: 918px;
	top: 271px;
}

#apDiv1 a{
	text-decoration:none;
	color:#090;
	font-family:Lucida Grande;
	font-size:12px; 
	font-weight:bold;
}

#apDiv1 a:hover{
	text-decoration:none;
	color:#0C0;
	font-family:Lucida Grande;
	font-size:12px; 
	font-weight:bold;
}

#background {
	position:absolute;
	width:364px;
	height:255px;
	z-index:2;
	left: 918px;
	top: 297px;
}
#usernameDiv {
	position:absolute;
	width:310px;
	height:287px;
	z-index:3;
	left: 950px;
	top: 310px;
}
#pswrdDiv {
	position:absolute;
	width:345px;
	height:25px;
	z-index:4;
	left: 429px;
	top: 64px;
}
#enterDiv {
	position:absolute;
	width:79px;
	height:28px;
	z-index:5;
	left: 657px;
	top: 119px;
}
#noticeDiv {
	position:absolute;
	width:224px;
	height:21px;
	z-index:6;
	left: 928px;
	top: 454px;
}
#noteDiv {
	position:absolute;
	width:358px;
	height:57px;
	z-index:7;
	left: 927px;
	top: 488px;
}
#header2 {
	position:absolute;
	width:364px;
	height:10px;
	z-index:8;
	left: 918px;
	top: 554px;
}
#intromsgdiv {
	position:absolute;
	width:816px;
	height:118px;
	z-index:9;
	left: 38px;
	top: 358px;
}
#probDiv {
	position:absolute;
	width:199px;
	height:28px;
	z-index:10;
	left: 38px;
	top: 514px;
}
#emailDiv {
	position:absolute;
	width:158px;
	height:27px;
	z-index:11;
	left: 232px;
	top: 513px;
}
#etc {
	position:absolute;
	width:115px;
	height:21px;
	z-index:12;
	left: 372px;
	top: 513px;
}
#apDiv1 {
	position:absolute;
	width:200px;
	height:18px;
	z-index:13;
	left: 425px;
	top: 512px;
}
#apDiv2 {
	position:absolute;
	width:330px;
	height:29px;
	z-index:14;
	left: 2px;
	top: 62px;
}
#apDiv3 {
	position:absolute;
	width:79px;
	height:31px;
	z-index:14;
	left: 127px;
	top: 110px;
}
#footer{
	position:absolute;
	left: 2px;
	top: 641px;
	width: 100%;
}
</style>
</head>

<body>
<div id="logoHeader" style="width:100%"><img name="" src="images/header2.png" width="100%" height="115" alt="" /></div>
<div id="footer">
<table width="100%" frame="above" bordercolor="#333333" style="font-family:Verdana, Geneva, sans-serif; color:#333333; font-size:9px">
 <tr>
    <td>Copyright � 2011 All Rights Reserved</td>
  </tr>
</table>
</div>
<div id="header" align="center">
  <div style="text-align:center; background-color:#7B1113; font-family:Lucida Grande; color:white; font-size:18px; font-weight:bold">Login</div>
</div>
<div id="background" style="background-color:#EEE0E5;"></div>
<div id="usernameDiv">
  <form id="form1" name="form1" method="post" action="LogIn.do">
    <p>
      <label for="userName" class="labels">Username:</label>
      <input name="userName" type="text" id="userName" size="25" />
    </p>
    <p>&nbsp;</p>
    <div id="apDiv2">
      <label for="password" class="labels">Password:</label>
      <input name="password" type="password" id="password" size="25" />
      <%
      String passwordIsOK=null;
      if(request.getAttribute("passwordIsOK")==null)
    	  passwordIsOK=(String)request.getAttribute("passwordIsOK");
      %>
      <%if(passwordIsOK!=null&&passwordIsOK.equalsIgnoreCase("false")){
    	  	out.print("*Invalid Username and/or Password");}%>
    </div>
    <p>&nbsp;</p>
    <div id="apDiv3">
      <input type="submit" name="enterBtn2" id="enterBtn" style="background-color:#7B1113;color:white;font-family:Lucida Grande;font-size:16px;" value="Enter" />
    </div>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
  </form>
</div>
<div id="noticeDiv" style="font-family:Lucida Grande; color:red; font-size:12px; font-weight:bold">Important:</div>
<div id="noteDiv" style="font-family:Lucida Grande; color:black; font-size:10px;">*PASSWORD IS CASE-SENSITIVE.<br />
*DO NOT FORGET TO LOGOUT YOUR ACCOUNT ONCE YOU COMPLETED<br />
YOUR SESSION.
</div>
<div id="header2" style="background-color:#7B1113;"></div>
<div id="intromsgdiv" style="font-family:Lucida Grande; color:black; font-size:12px;">
  <p>IAPPSAMS is a web-based database system that keeps records for  the UPVTC Supply and Property  Services Office (SPSO)  and shall facilitate convenient completion and validation of processes that can span across multiple other departments/ offices in UPVTC.
    <br />
    <br />
  </p>
  <p>Please type the Username and password given to you in the appropriate Username and Password boxes at the right then click on the &quot;Enter&quot; button to enter the main menu page.</p>
</div>
<div id="probDiv" style="font-family:Lucida Grande; color:black; font-size:12px;" >If <b>problems</b> persist, email us at</div>
<div id="emailDiv" class="misc">iappsams@yahoo.com</div>
<div id="etc" style="font-family:Lucida Grande; color:black; font-size:12px;">, contact</div>
<div class="misc" id="apDiv1"><a href="http://www.facebook.com/johndavidbaltazar" target="_blank">John David S. Baltazar</a>.</div>
</body>
</html>
