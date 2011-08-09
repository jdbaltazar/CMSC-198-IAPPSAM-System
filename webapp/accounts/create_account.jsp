<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.AccountType"%>
<%@page
	import="com.iappsam.managers.sessions.DivisionOfficeManagerSession"%>
<%@page import="com.iappsam.DivisionOffice"%>
<%@page import="com.iappsam.managers.DivisionOfficeManager"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Create Account</title>
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="headerBkgrnd"><img src="../images/headerbar.png"
	width="100%" height="129" /></div>
<div id="logo"><img src="../images/headerlogo.png" width="124"
	height="128" /></div>
<div id="headerName"><img src="../images/headertext.png"
	width="452" height="44" /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="100%" border="0" cellspacing="0">
	<tr>
		<td width="32%">&nbsp;</td>
		<td width="68%">
		<form id="form2" name="form2" method="post" action=""><input
			name="logoutBtn" type="submit" class="logout" id="logoutBtn"
			value="Logout" /></form>
		</td>
	</tr>
	<tr>
		<td id="navigation"><a href="../menu.jsp" target="_top" class="links">Main
		Menu</a> &gt; <a href="ViewAccounts.do" target="_top"
			class="links">Account List</a> &gt; <em><strong>Create
		Account</strong></em><strong></strong></td>
		<td>&nbsp;</td>
	</tr>
</table>
<div id="form_table">
<form id="form1" name="form1" method="post" action="accounts">
<input type="hidden" name="account-action" value="save-account"/>
<table width="100%" frame="box" cellspacing="0" id="table">


	<tr>
		<td align="right" class="bkgrnd_white"><a
			href="/accounts" target="_self" class="linkBtn">Create
		Account For Existing Employee>></a><input type="hidden" value="create-from-existing" name="account-action2"/></td>
	</tr>

	<tr>
		<tr>
			<td class="bkgrnd_white">&nbsp;</td>
		</tr>
		<tr>
			<td class="header_rows">
			<div class="header_1">Personal Information</div>
			</td>
		</tr>
		<tr>
			<td>
			<table width="100%" cellspacing="9" frame="box"
				class="no_border_table">
				<tr>
					<%
						DivisionOfficeManager dManager = new DivisionOfficeManagerSession();
						List<DivisionOffice> dList = dManager.getAllDivisionOffice();
						AccountType[] accountTypes = AccountType.values();
					%>
					<td class="align_right" id="align_right">Title:</td>
					<td><input type="text" name="title" id="title"
						<%String title = (String) request.getAttribute("title");
			if (title != null && !title.isEmpty())
				out.print("value=" + '"' + title + '"');%> /></td>
				</tr>
				<tr>
					<td class="align_right" id="align_right">*Name:<br />
					</td>
					<td><input type="text" name="name" id="name"
						<%String nameOK = (String) request.getAttribute("nameOK");
			String name = (String) request.getAttribute("name");
			if (nameOK != null && !nameOK.isEmpty()
					&& !nameOK.equalsIgnoreCase("false")) {
				out.print("value=" + '"' + name + '"');
			}%> />
					<%
						if (nameOK != null && !nameOK.isEmpty()
								&& nameOK.equalsIgnoreCase("false")) {
							out.print("*");
						}
					%> <br />
					</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr class="header_rows">
			<td>
			<div class="header_1">Work Information</div>
			</td>
		</tr>
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="5">
				<tr align="center" class="align_center">
					<td width="40%">*Designation</td>
					<td width="25%">Employee No.</td>
					<td width="35%">*Division/Office</td>
				</tr>
				<tr>
					<td>
					<div align="center"><label for="designation_1"></label> <input
						type="text" name="designation" id="designation_1"
						<%String[] designation = (String[]) request
					.getAttribute("designation");
			String[] employeeNo = (String[]) request.getAttribute("employeeNo");
			String designation1OK = (String) request
					.getAttribute("designation1OK");
			if (designation != null && !designation[0].isEmpty()) {
				out.print("value=" + '"' + designation[0] + '"');
			} else if (designation1OK != null)
				out.print("value=" + '"' + "**" + '"');%> />

					</div>
					</td>
					<td>
					<div align="center"><input name="employeeNo" type="text"
						id="employeeNo._1" size="4"
						<%if (employeeNo != null && employeeNo[0] != null
					&& !employeeNo[0].isEmpty())
				out.print("value=" + '"' + employeeNo[0] + '"');%> /></div>
					</td>
					<td>
					<div align="center"><select name="divisionOfficeDropdown"
						id="divisionOfficeDropdown">

						<%
							for (int i = 0; i < dList.size(); i++) {
						%>
						<option value="<%=dList.get(i).getId()%>">
						<%
							if (dList.get(i).getOfficeName() != null)
									out.print(dList.get(i).getDivisionName() + ","
											+ dList.get(i).getOfficeName());
								else
									out.print(dList.get(i).getDivisionName());
						%>
						</option>
						<%
							}
						%>
					</select></div>
					</td>
				</tr>
				<tr>
					<td>
					<div align="center"><label for="designation_1"></label> <input
						type="text" name="designation" id="designation_1"
						<%String designation2OK = (String) request
					.getAttribute("designation2OK");
			if (designation != null && designation.length > 1
					&& !designation[1].isEmpty()) {
				out.print("value=" + '"' + designation[1] + '"');
			} else if (designation2OK != null)
				out.print("value=" + '"' + "*" + '"');%> /></div>
					</td>
					<td>
					<div align="center"><input name="employeeNo" type="text"
						id="employeeNo._1" size="4"
						<%if (employeeNo != null && employeeNo[1] != null
					&& !employeeNo[1].isEmpty())
				out.print("value=" + '"' + employeeNo[1] + '"');%> /></div>
					</td>
					<td>
					<div align="center"><select name="divisionOfficeDropdown"
						id="divisionOfficeDropdown">

						<%
							for (int i = 0; i < dList.size(); i++) {
						%>
						<option value="<%=dList.get(i).getId()%>">
						<%
							if (dList.get(i).getOfficeName() != null)
									out.print(dList.get(i).getDivisionName() + ","
											+ dList.get(i).getOfficeName());
								else
									out.print(dList.get(i).getDivisionName());
						%>
						</option>
						<%
							}
						%>
					</select></div>
					</td>
				</tr>
				<tr>
					<td>
					<div align="center"><label for="designation_1"></label> <input
						type="text" name="designation" id="designation_1"
						<%String designation3OK = (String) request
					.getAttribute("designation3OK");
			if (designation != null && designation.length > 2
					&& !designation[2].isEmpty()) {
				out.print("value=" + '"' + designation[2] + '"');
			} else if (designation3OK != null)
				out.print("value=" + '"' + "*" + '"');%> /></div>
					</td>
					<td>
					<div align="center"><input name="employeeNo" type="text"
						id="employeeNo._1" size="4" <%%>
						<%if (employeeNo != null && employeeNo[2] != null
					&& !employeeNo[2].isEmpty())
				out.print("value=" + '"' + employeeNo[2] + '"');%> /></div>
					</td>
					<td>
					<div align="center"><select name="divisionOfficeDropdown"
						id="divisionOfficeDropdown">

						<%
							for (int i = 0; i < dList.size(); i++) {
						%>
						<option value="<%=dList.get(i).getId()%>">
						<%
							if (dList.get(i).getOfficeName() != null)
									out.print(dList.get(i).getDivisionName() + ","
											+ dList.get(i).getOfficeName());
								else
									out.print(dList.get(i).getDivisionName());
						%>
						</option>
						<%
							}
						%>
					</select></div>
					</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr class="header_rows">
			<td>
			<div class="header_1">Contact Information</div>
			</td>
		</tr>
		<tr>
			<td>
			<table width="100%" cellspacing="9" frame="box"
				class="no_border_table">
				<tr>
					<td class="align_right">Cellphone Number:</td>
					<td><input type="text" name="cellphoneNumber"
						id="cellphoneNumber"
						<%String mobileNumber = (String) request.getAttribute("mobileNumber");
			if (mobileNumber != null && !mobileNumber.isEmpty()) {
				out.print("value=" + '"' + mobileNumber + '"');
			}%> /></td>
				</tr>
				<tr>
					<td class="align_right">Landline:</td>
					<td><input type="text" name="landline" id="landline"
						<%String landline = (String) request.getAttribute("landline");
			if (landline != null && !landline.isEmpty()) {
				out.print("value=" + '"' + landline + '"');
			}%> /></td>
				</tr>
				<tr>
					<td class="align_right">E-mail Address:</td>
					<td><input type="text" name="e-mail_ad" id="e-mail_ad"
						<%String emailad = (String) request.getAttribute("emailad");
			if (emailad != null && !emailad.isEmpty()) {
				out.print("value=" + '"' + emailad + '"');
			}%> /></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td class="header_rows">
			<div class="header_1">Account Information</div>
			</td>
		</tr>
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="9">
				<tr>
					<td class="align_right">*Username:</td>
					<td><input type="text" name="username" id="username"
						<%String usernameOk = (String) request.getAttribute("usernameOK");
			String username = (String) request.getAttribute("userName");
			if (usernameOk != null && !usernameOk.isEmpty()
					&& !usernameOk.equalsIgnoreCase("false")) {
				out.print("value=" + '"' + username + '"');
			}%> />
					<%
						if (usernameOk != null && !usernameOk.isEmpty()
								&& usernameOk.equalsIgnoreCase("false")) {
							out.print("*");
						}
					%>
					</td>
				</tr>
				<tr>
					<td class="align_right">*Password:</td>
					<td><input type="password" name="password" id="password"
						<%String passwordOk = (String) request.getAttribute("passwordOK");%> />
					<%
						if (passwordOk != null && !passwordOk.isEmpty()
								&& passwordOk.equalsIgnoreCase("false")) {
							out.print("*");
						}
					%>
					</td>
				</tr>
				<tr>
					<td class="align_right">*Re-enter Password:</td>
					<td><input type="password" name="reenterPassword"
						id="reenterPassword" /> <%
 	if (passwordOk != null && !passwordOk.isEmpty()
 			&& passwordOk.equalsIgnoreCase("false")) {
 		out.print("*");
 	}
 %>
					</td>
				</tr>
				<tr>
					<td class="align_right">*Account Type:</td>
					<td><select name="accountType" class="menulist"
						id="accountType">
						<%
							for (int i = 0; i < accountTypes.length; i++) {
						%>
						<option
						
						<%
						if(accountTypes[i].equals(AccountType.SPSO_PERSONNEL))
							out.print("selected");
						%>
						
						><%=accountTypes[i].toString()%></option>
						<%
							}
						%>
					</select></td>
				</tr>
				<tr>
					<td class="align_right">&nbsp;</td>
					<td><input name="createBtn" type="submit" class="button"
						id="createBtn" value="CREATE" /></td>
				</tr>
			</table>
			</td>
		</tr>
</table>

</form>
</div>

<!--<div id="footer"></div>-->
</body>
</html>
