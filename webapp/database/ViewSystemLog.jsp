<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.Log"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="../favicon.ico" />
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
<link href="../css/item_table.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM :: View System Log</title>
</head>

<body>
<div id="headerBkgrnd"><img src="../images/headerbar.png" width="100%" height="129" /></div>
<div id="logo"><img src="../images/headerlogo.png" width="124" height="128" /></div>
<div id="headerName"><img src="../images/headertext.png" width="452" height="44" /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td width="32%">&nbsp;</td>
    <td width="68%"><form id="form2" name="form2" method="post" action="logout"">
      <input name="logoutBtn" type="submit" class="logout" id="logoutBtn" value="Logout" />
    </form></td>
  </tr>
  <tr>
    <td id="navigation"><a href="menu" target="_top" class="links">Main Menu</a> &gt;<em><strong>View System Log </strong></em></td>
    <td>&nbsp;</td>
  </tr>
</table>

<div id="items_table">
  <table width="100%" border="0" cellspacing="0">
    <tr>
      <td colspan="4" align="center">&nbsp;</td>
    </tr>

    <tr>
      <td class="tableheaders_forms">Date</td>
      <td class="tableheaders_forms">Activities</td>
    </tr>
<%

	List<Log>logs = (List<Log>)request.getAttribute("logs");
%>    
        <%
    int i=0;
    for(Log l: logs){
   	%>
   	<tr <%
   	if(i%2==0)
   		out.println("class=\"tablerow_1\"");
	else
	out.println("class=\"tablerow_2\"");
   	%> align="center"> 
   	
   	<td width="26%"><%=l.getDate().toString() %></td>
      <td width="74%"><%=l.getDescription() %></td>
   	 <% 
   	 i++;
    }
    %>    
    </tr>
  </table>
</div>

</body>
</html>