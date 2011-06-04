<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: Add Item</title>
<link href="/items/items.css" rel="stylesheet" type="text/css" />
<link href="/items/add-item.css" rel="stylesheet" type="text/css" />
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


</head>

<body>

	<jsp:include page="../logo.jsp" />
	<jsp:include page="../logout-button.jsp" />

	<div id="pageLabel" style="width: 100%;">
		<table width="100%" border="0">
			<tr>
				<td width="9%">
					<table width="100%" frame="below">
						<tr>
							<td class="title-label">Add Item</td>
						</tr>
					</table>
				</td>
				<td width="87%">&nbsp;</td>
				<td width="4%"><a class="button" href="/items">Back</a>
				</td>
			</tr>
		</table>
	</div>
	<div id="headerdiv" style="font-family: Lucida Grande; color: white; font-size: 16px; font-weight: bold"><span class="headerLabel">Item Information</span></div>
	<div id="background" style="background-color: #EEE0E5;">
		<form action="../stocks/SaveItem.do" method="post" name="form1" id="form1" <%if (finished) {%> disabled="disabled" <%}%>>
			<p>&nbsp;</p>
			<p>
			  <label for="itemDescription3" class="texts">*Description:</label>
              <textarea name="itemDescription" cols="30" id="itemDescription3" <%if (finished) {%> disabled="disabled" <%}%>></textarea>
			</p>
			<p>
			  <label for="itemUnit2" class="texts">*Unit:</label>
              <select name="itemUnit" id="itemUnit2" <%if (finished) {%> disabled="disabled" <%}%>>
                <%
						for (String s : itemUnits) {
					%>
                <option><%=s%></option>
                <%
						}
					%>
              </select>
			</p>
		  <p>
		    <label for="itemCategory2" class="texts">*Category:</label>
            <select name="itemCategory" id="itemCategory2" <%if (finished) {%> disabled="disabled"
					<%}%>
				>
              <%
						for (String s : itemCategories) {
					%>
              <option><%=s%></option>
              <%
						}
					%>
            </select>
		  </p>
		  <p>
		    <label for="itemPrice2" class="texts">Price:</label>
            <input name="itemPrice" type="text" id="itemPrice2" size="10" <%if (finished) {%>
					disabled="disabled" <%}%>
				/>
		  </p>
		  <p>
		    <label for="month2" class="texts">Date Acquired:</label>
            <select name="month" id="month2" <%if (finished) {%> disabled="disabled" <%}%>>
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
            </select>
            <select name="day" id="dayAcquired" <%if (finished) {%> disabled="disabled" <%}%>>
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
            </select>
            <select name="year" id="yearAcquired" <%if (finished) {%> disabled="disabled" <%}%>>
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
		  </p>
		  <p>
		    <label for="stockNumber3" class="texts">Stock Number:</label>
            <input name="stockNumber" type="text" id="stockNumber3" size="20" />
		  </p>
      <p>
        <label for="inventoryItemNum3" class="texts">Inv. Item Number:</label>
        <input type="text" name="inventoryItemNum" id="inventoryItemNum3"
					<%if (finished) {%> disabled="disabled" <%}%>
				/>
      </p>
		  <p>
		    <label for="itemPropertyNumber3" class="texts">Property Number:</label>
            <input type="text" name="itemPropertyNumber" id="itemPropertyNumber3"
					<%if (finished) {%> disabled="disabled" <%}%>
				/>
		  </p>
    <p>
      <label for="itemStatus3" class="texts">*Item Status:</label>
      <select name="itemStatus" id="itemStatus3" <%if (finished) {%> disabled="disabled"
					<%}%>
				>
        <%
						for (String s : itemStatuses) {
					%>
        <option><%=s%></option>
        <%
						}
					%>
      </select>
    </p>
<p>
  <label for="itemCondition3" class="texts">*Item Condition:</label>
  <select name="itemCondition" id="itemCondition3" <%if (finished) {%>
					disabled="disabled" <%}%>
				>
    <%
						for (String s : itemConditions) {
					%>
    <option><%=s%></option>
    <%
						}
					%>
  </select>
</p>
<p>
  <input type="submit" name="addItemBtn " id="addItemBtn"
					style="background-color: #7B1113; color: white; font-family: Lucida Grande; font-size: 20px;" value="Add" <%if (finished) {%> disabled="disabled"
					<%}%>
				/>
</p>
<p><em><strong>Please check your input.</strong></em></p>
<p><em>*required fields</em></p>
	  </form>
	</div>
<%
		if (validInputs != null && validInputs.equalsIgnoreCase("false")) {
	%>
<%
		}
	%>

	<jsp:include page="../copyright.jsp" />
</body>
</html>

