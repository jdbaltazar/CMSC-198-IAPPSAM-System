<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: Add Item</title>

<%
	List<String> itemUnits = new ArrayList<String>();
	List<String> itemCategories = new ArrayList<String>();
	List<String> itemStatuses = new ArrayList<String>();
	List<String> itemConditions = new ArrayList<String>();

	String validInputs = (String) request.getAttribute("validInputForItem");
	String finishedInputting = (String) request.getAttribute("finishedInputting");
	boolean finished = false;
	if (finishedInputting != null && finishedInputting.equalsIgnoreCase("true"))
		finished = true;

	if (!finished) {
		itemUnits = (List<String>) request.getAttribute("itemUnits");
		itemCategories = (List<String>) request.getAttribute("itemCategories");
		itemStatuses = (List<String>) request.getAttribute("itemStatuses");
		itemConditions = (List<String>) request.getAttribute("itemConditions");
	}
%>

<style type="text/css">
.headerLabel {
	font-family: Lucida Grande;
	color: white;
	font-size: 16px;
	font-weight: bold;
}

.maroon {
	font-size: 12px;
	font-family: Lucida Grande;
	background-color: #7B1113;
	color: white;
	border-left: 1px solid lightgray;
	border-right: 1px solid lightgray;
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

.maroon:hover {
	font-weight: bold;
	/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
	border-right: 1px solid #7B1113;
	border-top: 1px solid #7B1113;
	border-bottom: 1px solid #7B1113;
}

.button {
	font-size: 14px;
	font-family: Lucida Grande;
	background-color: white;
	color: #7B1113;
	border-left: 1px solid lightgray;
	border-right: 1px solid lightgray;
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
}

.button:hover {
	font-weight: bold;
	color: #060;
	/*	background:#EEE0E5;;*/
	border-left: 1px solid #7B1113;
	border-right: 1px solid #7B1113;
	border-top: 1px solid #7B1113;
	border-bottom: 1px solid #7B1113;
}

.requiredLabel {
	font-family: Lucida Grande;
	font-size: 11px;
	color: red;
}

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
	left: 455px;
	top: 304px;
}

#background {
	position: absolute;
	width: 578px;
	height: 584px;
	z-index: 2;
	left: 455px;
	top: 329px;
}

#name {
	position: absolute;
	width: 434px;
	height: 55px;
	z-index: 3;
	left: 620px;
	top: 343px;
}

#stockNum {
	position: absolute;
	width: 435px;
	height: 25px;
	z-index: 4;
	left: 944px;
	top: 448px;
}

#unit {
	position: absolute;
	width: 200px;
	height: 28px;
	z-index: 5;
	left: 1035px;
	top: 239px;
}

#description {
	position: absolute;
	width: 442px;
	height: 36px;
	z-index: 6;
	left: 1012px;
	top: 337px;
}

#apDiv1 {
	position: absolute;
	width: 147px;
	height: 15px;
	z-index: 7;
	left: 484px;
	top: 857px;
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
	left: 933px;
	top: 507px;
}

#apDiv4 {
	position: absolute;
	width: 438px;
	height: 26px;
	z-index: 10;
	left: 936px;
	top: 567px;
}

#apDiv5 {
	position: absolute;
	width: 385px;
	height: 27px;
	z-index: 11;
	left: 943px;
	top: 618px;
}

#apDiv6 {
	position: absolute;
	width: 353px;
	height: 27px;
	z-index: 12;
	left: 1067px;
	top: 704px;
}

#addDiv {
	position: absolute;
	width: 200px;
	height: 41px;
	z-index: 13;
	left: 956px;
	top: 772px;
}

#apDiv7 {
	position: absolute;
	width: 586px;
	height: 642px;
	z-index: 1;
	left: 127px;
	top: 179px;
}

#footer {
	background-color: #7B1113;
	position: absolute;
	width: 578px;
	height: 9px;
	z-index: 14;
	left: 455px;
	top: 913px;
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
	left: 966px;
	top: 310px;
}

#dayDiv {
	position: absolute;
	width: 62px;
	height: 27px;
	z-index: 16;
	left: 979px;
	top: 358px;
}

#yearDiv {
	position: absolute;
	width: 84px;
	height: 27px;
	z-index: 17;
	left: 1113px;
	top: 363px;
}

#apDiv11 {
	position: absolute;
	width: 137px;
	height: 28px;
	z-index: 18;
	left: 3px;
	top: 94px;
}

#apDiv12 {
	position: absolute;
	width: 413px;
	height: 43px;
	z-index: 18;
	left: -57px;
	top: 24px;
}

#apDiv13 {
	position: absolute;
	width: 233px;
	height: 29px;
	z-index: 18;
	left: 4px;
	top: 187px;
}

#apDiv14 {
	position: absolute;
	width: 414px;
	height: 29px;
	z-index: 18;
	left: -73px;
	top: 232px;
}

#apDiv15 {
	position: absolute;
	width: 393px;
	height: 28px;
	z-index: 18;
	left: -71px;
	top: 276px;
}

#apDiv16 {
	position: absolute;
	width: 391px;
	height: 27px;
	z-index: 18;
	left: -95px;
	top: 318px;
}

#apDiv17 {
	position: absolute;
	width: 370px;
	height: 30px;
	z-index: 18;
	left: -95px;
	top: 363px;
}

#apDiv18 {
	position: absolute;
	width: 272px;
	height: 26px;
	z-index: 18;
	left: -53px;
	top: 407px;
}

#apDiv19 {
	position: absolute;
	width: 283px;
	height: 27px;
	z-index: 18;
	left: -83px;
	top: 453px;
}

#apDiv20 {
	position: absolute;
	width: 68px;
	height: 35px;
	z-index: 18;
	left: 124px;
	top: 507px;
}

#apDiv21 {
	position: absolute;
	width: 200px;
	height: 28px;
	z-index: 18;
	left: -36px;
	top: 140px;
}

#logoHeader {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 1;
}

#pageLabel {
	position: absolute;
	width: 200px;
	height: 50px;
	z-index: 1;
	top: 181px;
	left: 13px;
}

#logoutiv {
	position: absolute;
	width: 200px;
	height: 30px;
	z-index: 15;
	left: 14px;
	top: 143px;
}

#footer_2 {
	position: absolute;
	left: 4px;
	top: 990px;
	width: 100%;
}

#apDiv22 {
	position: absolute;
	width: 324px;
	height: 25px;
	z-index: 16;
	left: 471px;
	top: 305px;
}

#generalBorder {
	position: absolute;
	width: 100%;
	height: 753px;
	z-index: 0;
	left: 4px;
	top: 256px;
}

#apDiv23 {
	position: absolute;
	width: 200px;
	height: 18px;
	z-index: 7;
	font-weight: bold;
	font-style: italic;
	left: 480px;
	top: 640px;
}

#apDiv24 {
	position: absolute;
	width: 200px;
	height: 21px;
	z-index: 17;
	left: 484px;
	top: 877px;
}
</style>
</head>

<body>
	<div id="footer_2">
		<table width="100%" frame="above" bordercolor="#333333"
			style="font-family: Verdana, Geneva, sans-serif; color: #333333; font-size: 9px">
			<tr>
				<td>Copyright ï¿½ 2011 All Rights Reserved</td>
			</tr>
		</table>
	</div>
	<div id="logoHeader" style="width: 95%;">
		<img name="" src="../images/header2.png" width="1354" height="115"
			alt="" />
	</div>
	<div id="pageLabel" style="width: 100%;">
		<table width="100%" border="0">
			<tr>
				<td width="9%">
					<table width="100%" frame="below">
						<tr>
							<td
								style="font-family: Lucida Grande; font-size: 20px; font-weight: bold; color: #003300">Add
								Item</td>
						</tr>
					</table>
				</td>
				<td width="87%">&nbsp;</td>
				<td width="4%">
					<form id="form15" name="form15" method="post"
						action="../items/SearchAllItems.do">
						<input name="backBtn" type="submit" class="button" id="backBtn"
							value="Back" />
					</form>
				</td>
			</tr>
		</table>
	</div>
	<div id="headerdiv"
		style="font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold"></div>
	<div id="background" style="background-color: #EEE0E5;"></div>
	<div id="name">
		<form action="../stocks/SaveItem.do" method="post" name="form1"
			id="form1" <%if (finished) {%> disabled="disabled" <%}%>>
			<p>&nbsp;</p>
			<p>&nbsp;</p>

			<div id="apDiv12">
				<label for="itemDescription3" class="texts">*Description:</label>
				<textarea name="itemDescription" cols="30" id="itemDescription3"
					<%if (finished) {%> disabled="disabled" <%}%>></textarea>
			</div>
			<div id="apDiv11">
				<label for="itemUnit" class="texts">*Unit:</label> <select
					name="itemUnit" id="itemUnit" <%if (finished) {%>
					disabled="disabled" <%}%>>
					<%
						for (String s : itemUnits) {
					%>
					<option><%=s%></option>
					<%
						}
					%>
				</select>
			</div>

			<div id="apDiv21">
				<label for="itemCategory" class="texts">*Category:</label> <select
					name="itemCategory" id="itemCategory" <%if (finished) {%>
					disabled="disabled" <%}%>>
					<%
						for (String s : itemCategories) {
					%>
					<option><%=s%></option>
					<%
						}
					%>
				</select>
			</div>
			<div id="apDiv13">
				<label for="itemPrice3" class="texts">Price:</label> <input
					name="itemPrice" type="text" id="itemPrice3" size="10"
					<%if (finished) {%> disabled="disabled" <%}%> />
			</div>
			<div id="apDiv14">
				<label for="month3" class="texts">Date Acquired:</label> <select
					name="month" id="month3" <%if (finished) {%> disabled="disabled"
					<%}%>>
					<option value="01">Jan</option>
					<option value="02">Feb</option>
					<option value="03">Mar</option>
					<option value="04">Apr</option>
					<option value="05">May</option>
					<option value="06">Jun</option>
					<option value="07">Jul</option>
					<option value="08">Aug</option>
					<option value="09">Sep</option>
					<option value="10">Oct</option>
					<option value="11">Nov</option>
					<option value="12">Dec</option>
				</select> <select name="day" id="dayAcquired" <%if (finished) {%>
					disabled="disabled" <%}%>>
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
				</select> <select name="year" id="yearAcquired" <%if (finished) {%>
					disabled="disabled" <%}%>>
					<option>2000</option>
					<option>2001</option>
					<option>2002</option>
					<option>2003</option>
					<option>2004</option>
					<option>2005</option>
					<option>2006</option>
					<option>2007</option>
					<option>2008</option>
					<option>2009</option>
					<option>2010</option>
					<option>2011</option>
					<option>2012</option>
					<option>2013</option>
					<option>2015</option>
					<option>2016</option>
				</select>
			</div>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<div id="apDiv15">
				<label for="stockNumber2" class="texts">Stock Number:</label> <input
					name="stockNumber" type="text" id="stockNumber2" size="20" />
			</div>
			<div id="apDiv16">
				<label for="inventoryItemNum2" class="texts">Inv. Item
					Number:</label> <input type="text" name="inventoryItemNum"
					id="inventoryItemNum2" <%if (finished) {%> disabled="disabled"
					<%}%> />
			</div>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<div id="apDiv17">
				<label for="itemPropertyNumber2" class="texts">Property
					Number:</label> <input type="text" name="itemPropertyNumber"
					id="itemPropertyNumber2" <%if (finished) {%> disabled="disabled"
					<%}%> />
			</div>
			<p>&nbsp;</p>
			<div id="apDiv18">
				<label for="itemStatus2" class="texts">*Item Status:</label> <select
					name="itemStatus" id="itemStatus2" <%if (finished) {%>
					disabled="disabled" <%}%>>
					<%
						for (String s : itemStatuses) {
					%>
					<option><%=s%></option>
					<%
						}
					%>
				</select>
			</div>
			<p>&nbsp;</p>
			<div id="apDiv19">
				<label for="itemCondition2" class="texts">*Item Condition:</label> <select
					name="itemCondition" id="itemCondition2" <%if (finished) {%>
					disabled="disabled" <%}%>>
					<%
						for (String s : itemConditions) {
					%>
					<option><%=s%></option>
					<%
						}
					%>
				</select>
			</div>
			<p>&nbsp;</p>
			<div id="apDiv20">
				<input type="submit" name="addItemBtn " id="addItemBtn"
					style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;"
					value="Add" <%if (finished) {%> disabled="disabled" <%}%> />
			</div>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</form>
	</div>
	<div class="requiredLabel" id="apDiv1">
		<em>*required fields</em>
	</div>
	<div id="footer"></div>
	<p>&nbsp;</p>
	<div id="logoutiv" style="width: 90%">
		<form id="form2" name="form2" method="post" action="../logout">
			<input name="logout" type="submit" class="maroon" id="logout"
				value="Logout" />
		</form>
	</div>
	<div class="headerLabel" id="apDiv22">Item Information</div>
	<div id="generalBorder" style="width: 100%"></div>

	<%
		if (validInputs != null && validInputs.equalsIgnoreCase("false")) {
	%>
	<div class="requiredLabel" id="apDiv24">
		<em><strong>Please check your input.</strong> </em>
	</div>
	<%
		}
	%>

</body>
</html>

