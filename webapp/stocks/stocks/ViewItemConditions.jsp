<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.ArrayList"%>
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
#divTableheadr {
	position:absolute;
	width:200px;
	height:22px;
	z-index:1;
	left: 1px;
	top: 374px;
}
#pageLabel {
	position:absolute;
	width:200px;
	height:45px;
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
	top: 620px;
	width: 100%;
}
#apDiv1 {
	position:absolute;
	width:102px;
	height:26px;
	z-index:16;
	left: 840px;
	top: 289px;
}
#resultTable {
	position:absolute;
	width:521px;
	height:164px;
	z-index:17;
	left: 1px;
	top: 398px;
}
#apDiv2 {
	position:absolute;
	width:361px;
	height:31px;
	z-index:18;
	left: 443px;
	top: 287px;
}
</style>
</head>

<body>

<div id="logoHeader" style="width:100%"><img name="" src="../../images/header2.png" width="100%" height="115" alt="" /></div>
<div id="pageLabel" style="width:100%;">
<table width="100%" border="0">
  <tr>
    <td width="14%"><table width="100%" frame="below">
      <tr>
        <td style="font-family:Lucida Grande; font-size:20px; font-weight:bold; color:#003300">Item Condition</td>
      </tr>
    </table></td>
    <td width="82%">&nbsp;</td>
    <td width="4%"><form id="form15" name="form15" method="post" action="../../stocks/stocks/StockProperties.jsp">
      <input name="backBtn" type="submit" class="button" id="backBtn" value="Back" />
    </form></td>
  </tr>
</table>
</div>
<div id="logoutiv" style="width:90%">
  <form id="form2" name="form2" method="post" action="../../logout">
    <input name="logout" type="submit" class="maroon" id="logout" value="Logout" />
  </form>
</div>
<div id="divTableheadr" style="width:100%">
  <table width="100%" border="1" cellspacing="0" class="tableheaders">
    <tr>
      <td width="83%">Item Condition</td>
      <td width="17%">Action</td>
    </tr>
  </table>
</div>
<div id="apDiv1">
  <form id="form1" name="form1" method="post" action="AddItemCondition.jsp">
    <input name="addNewBtn" type="submit" class="maroon" id="addNewBtn" value="Add New &gt;&gt;" />
  </form>
</div>
<div id="resultTable" style="width:100%">
  <table width="100%" frame="box" cellspacing="0">
          	<%ArrayList<String> condition = (ArrayList<String>) request.getAttribute("itemCondition");
  	int size = condition.size();%>
  	
  	<%for(int i = 0; i < size; i++)
  	{ 
  	%>
  	<%
		if (i % 2 == 0)
				out.print("<tr class=\"tablerow_1\">");
			else
				out.print("<tr>");
	%>

      <td width="83%"><%=condition.get(i) %></td>
      <td width="17%" align="center"><form id="form4" name="form4" method="post" action="EditItemConditions.jsp">
        <input name="editBtn_1" type="submit" disabled="disabled" class="maroon" id="editBtn_1" value="Edit" />
      </form></td>
    </tr>
    <%
    }
    %>
  </table>
</div>
<div id="apDiv2">
  <form id="form3" name="form3" method="post" action="">
    <label for="searchField" class="labels">Search:</label>
    <input name="searchField" type="text" id="searchField" size="30" />
    <input name="hoSearchBtn" type="submit" class="maroon" id="hoSearchBtn" value="GO" />
  </form>
</div>
</body>
</html>
