<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.forms.Disposal"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Add Disposal</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%
	Disposal disposal = (Disposal) request.getAttribute("disposal");
%>
<div id="headerBkgrnd"><img src="../../images/headerbar.png" width="100%" height="129" /></div>
<div id="logo"><img src="../../images/headerlogo.png" width="124" height="128" /></div>
<div id="headerName"><img src="../../images/headertext.png" width="452" height="44" /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td width="32%">&nbsp;</td>
    <td width="68%"><form id="form2" name="form2" method="post" action="">
      <input name="logoutBtn" type="submit" class="logout" id="logoutBtn" value="Logout" />
    </form></td>
  </tr>
  <tr>
    <td id="navigation"><a href="../../menu" target="_top" class="links">Main Menu</a> &gt;<a href="StockProperties.jsp" target="_top" class="links">Stock Properties</a> &gt; <a href="ViewDisposals.do" target="_top" class="links">Disposal List</a> &gt; <em><strong>Edit Disposal</strong></em></td>
    <td>&nbsp;</td>
  </tr>
</table>
<div id="form_table">
  <form id="form1" name="form1" method="post" action="SaveEditedDisposal.do">
    <table width="100%" border="0" cellspacing="0" id="table">
      <tr>
        <td class="header_rows"><div class="header_1"><em>Edit</em></div></td>
      </tr>
      <tr>
        <td><table width="100%" cellspacing="0" frame="box" id="table">
          <tr>
            <td class="align_right"><br />
              Disposal:<br />
              <br /></td>
            <td><br />              <input name="disposalField" type="text" class="required" id="disposal" value="<%=disposal.getName()%>" maxlength="80"/>
            <input type="hidden"
	name="disposalID" value=<%="" + disposal.getId()%> />
              <br />
              <br /></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><input name="saveBtn" type="submit" class="button" id="saveBtn" value="SAVE" />
              <br />
              <br /></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td class="table_footer"></td>
      </tr>
    </table>
  </form>
</div>
<!--<div id="footer"></div>-->
</body>
</html>
