<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="com.mysql.jdbc.Util"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
.texts {
	font-family: Lucida Grande;
	font-size: 16px;
	font-weight: bold;
}

#headerdiv {
	background-color: #7B1113;
	position: absolute;
	width: 578px;
	height: 25px;
	z-index: 1;
	left: 353px;
	top: 176px;
}

#background {
	position: absolute;
	width: 578px;
	height: 584px;
	z-index: 2;
	left: 353px;
	top: 202px;
}

#name {
	position: absolute;
	width: 434px;
	height: 551px;
	z-index: 3;
	left: 491px;
	top: 229px;
}

#stockNum {
	position: absolute;
	width: 435px;
	height: 25px;
	z-index: 4;
	left: 422px;
	top: 508px;
}

#unit {
	position: absolute;
	width: 200px;
	height: 28px;
	z-index: 5;
	left: 501px;
	top: 298px;
}

#description {
	position: absolute;
	width: 442px;
	height: 36px;
	z-index: 6;
	left: 440px;
	top: 344px;
}

#apDiv1 {
	position: absolute;
	width: 263px;
	height: 26px;
	z-index: 7;
	left: 496px;
	top: 410px;
}

#apDiv2 {
	position: absolute;
	width: 380px;
	height: 27px;
	z-index: 8;
	left: 420px;
	top: 460px;
}

#apDiv3 {
	position: absolute;
	width: 456px;
	height: 25px;
	z-index: 9;
	left: 397px;
	top: 552px;
}

#apDiv4 {
	position: absolute;
	width: 438px;
	height: 26px;
	z-index: 10;
	left: 399px;
	top: 596px;
}

#apDiv5 {
	position: absolute;
	width: 385px;
	height: 27px;
	z-index: 11;
	left: 447px;
	top: 644px;
}

#apDiv6 {
	position: absolute;
	width: 353px;
	height: 27px;
	z-index: 12;
	left: 418px;
	top: 686px;
}

#addDiv {
	position: absolute;
	width: 200px;
	height: 41px;
	z-index: 13;
	left: 611px;
	top: 739px;
}

#apDiv7 {
	position: absolute;
	width: 586px;
	height: 642px;
	z-index: 1;
	left: 349px;
	top: 174px;
}

#footer {
	background-color: #7B1113;
	position: absolute;
	width: 578px;
	height: 9px;
	z-index: 14;
	left: 354px;
	top: 788px;
}

#apDiv8 {
	position: absolute;
	width: 200px;
	height: 38px;
	z-index: 15;
	left: 18px;
	top: 197px;
}

#apDiv9 {
	position: absolute;
	width: 200px;
	height: 32px;
	z-index: 1;
}

#apDiv10 {
	position: absolute;
	width: 286px;
	height: 28px;
	z-index: 15;
	left: 419px;
	top: 459px;
}

#dayDiv {
	position: absolute;
	width: 62px;
	height: 27px;
	z-index: 16;
	left: 617px;
	top: 460px;
}

#yearDiv {
	position: absolute;
	width: 84px;
	height: 27px;
	z-index: 17;
	left: 682px;
	top: 460px;
}
</style>
</head>

<body>
<table width="100%" border="0">
	<tr>
		<td width="11%">
		<table width="100%" frame="below">
			<tr>
				<td
					style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">Add
				Item</td>
			</tr>
		</table>
		</td>
		<td width="85%">&nbsp;</td>
		<td width="4%"><a href="../ManageItems.html" title="Back"
			target="main_frame">Back</a></td>
	</tr>
</table>
<div id="headerdiv"
	style="text-align: left; font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold">Item
Info</div>
<div id="background" style="background-color: #EEE0E5;"></div>
<div id="name">
<form action="./createItem.do" method="post" name="form1" id="form1">
<p><label for="itemName" class="texts">Name:</label> <textarea
	name="itemName" id="itemName"></textarea></p>
<p><label for="itemUnit" class="texts">Unit:</label> <select
	name="itemUnit" id="itemUnit">
	<%
		ArrayList<String> unitList = (ArrayList<String>) request.getAttribute("unitList");
		for (int i = 0; i < unitList.size(); i++) {
			out.print("<option>" + unitList.get(i) + "</option>");
		}
	%>
</select></p>
<p><label for="itemDescription2" class="texts">Description:</label>
<textarea name="itemDescription" cols="30" id="itemDescription2"></textarea>
</p>
<p><label for="itemPrice2" class="texts">Price:</label> <input
	name="itemPrice" type="text" id="itemPrice2" size="10" /></p>
<p><label for="month2" class="texts">Date Acquired:</label> <select
	name="month" id="month2">
	<option>MM</option>
	<option>01</option>
	<option>02</option>
	<option>03</option>
	<option>04</option>
	<option>05</option>
	<option>06</option>
	<option>07</option>
	<option>08</option>
	<option>09</option>
	<option>10</option>
	<option>11</option>
	<option>12</option>
</select> <select name="dayAcquired" id="dayAcquired">
	<option>DD</option>
	<option>1</option>
	<option>2</option>
	<option>3</option>
	<option>4</option>
	<option>5</option>
	<option>6</option>
	<option>7</option>
	<option>8</option>
	<option>9</option>
	<option>10</option>
	<option>11</option>
	<option>12</option>
	<option>13</option>
	<option>14</option>
	<option>15</option>
	<option>16</option>
	<option>17</option>
	<option>18</option>
	<option>19</option>
	<option>20</option>
	<option>21</option>
	<option>22</option>
	<option>23</option>
	<option>24</option>
	<option>25</option>
	<option>26</option>
	<option>27</option>
	<option>28</option>
	<option>29</option>
	<option>30</option>
	<option>31</option>
</select> <select name="yearAcquired" id="yearAcquired">
	<option>YYYY</option>
	<%
		int year = 2000;
		Date today = new Date();
		int maxYear = Integer.parseInt((today.toString()).substring(today.toString().length() - 4, today.toString().length()));
		for (; year <= maxYear; year++) {
			out.print("<option>" + year + "</option>");
		}
	%>
</select></p>
<p><label for="stockNumber2" class="texts">Stock Number:</label> <input
	name="stockNumber" type="text" id="stockNumber2" size="20" /></p>
<p><label for="inventoryItemNum2" class="texts">Inv. Item
Number:</label> <input type="text" name="inventoryItemNum"
	id="inventoryItemNum2" /></p>
<p><label for="itemPropertyNumber2" class="texts">Property
Number:</label> <input type="text" name="itemPropertyNumber"
	id="itemPropertyNumber2" /></p>
<p><label for="itemStatus2" class="texts">Item Status:</label> <select
	name="itemStatus" id="itemStatus2">
	<%
		ArrayList<String> itemStatusList = (ArrayList<String>) request.getAttribute("itemStatusList");
		for (int i = 0; i < itemStatusList.size(); i++) {
			out.print("<option>" + itemStatusList.get(i) + "</option>");
		}
	%>
</select></p>
<p><label for="itemCondition2" class="texts">Item Condition:</label>
<select name="itemCondition" id="itemCondition2">
	<%
		ArrayList<String> itemConditionList = (ArrayList<String>) request.getAttribute("itemConditionList");
		for (int i = 0; i < itemConditionList.size(); i++) {
			out.print("<option>" + itemConditionList.get(i) + "</option>");
		}
	%>
</select></p>
<blockquote>
<blockquote>
<blockquote>
<blockquote>
<p><input type="submit" name="addItemBtn" id="addItemBtn"
	style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;"
	value="Add" /></p>
</blockquote>
</blockquote>
</blockquote>
</blockquote>
</form>
</div>
<div id="apDiv7">
<table width="100%" border="1">
	<tr>
		<td height="617">&nbsp;</td>
	</tr>
</table>
</div>
<div id="footer"></div>
<p>&nbsp;</p>
</body>
</html>
