<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.Person"%>
<%@page import="com.iappsam.ContactType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.iappsam.Employee"%>
<%@page import="com.iappsam.managers.sessions.PersonManagerSession"%>
<%@page import="com.iappsam.managers.PersonManager"%>
<%@page import="com.iappsam.Contact"%>
<%@page import="com.iappsam.Account"%>
<%@page import="com.iappsam.managers.sessions.AccountManagerSession"%>
<%@page import="com.iappsam.managers.AccountManager"%>
<%@page import="com.iappsam.AccountType"%>
<%@page
	import="com.iappsam.managers.sessions.DivisionOfficeManagerSession"%>
<%@page import="com.iappsam.DivisionOffice"%>
<%@page import="com.iappsam.managers.DivisionOfficeManager"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::View Own Account</title>
<link href="../css/header.css" rel="stylesheet" type="text/css" />
<link href="../css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="headerBkgrnd">
		<img src="../images/headerbar.png" width="100%" height="129" />
	</div>
	<div id="logo">
		<img src="../images/headerlogo.png" width="124" height="128" />
	</div>
	<div id="headerName">
		<img src="../images/headertext.png" width="452" height="44" />
	</div>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<table width="100%" border="0" cellspacing="0">
		<%
			String userName = (String) request.getSession().getAttribute("username");
			AccountManager aManager = new AccountManagerSession();
			Account account = aManager.getAccount(userName);
			PersonManager pManager = new PersonManagerSession();
			List<Employee> employees = pManager.getEmployeeByPerson(account.getPerson().getId());
			Person person = account.getPerson();
			String string = "";
		%>
		<tr>
			<td width="32%">&nbsp;</td>
			<td width="68%">
				<form id="form2" name="form2" method="post" action="/logout">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn"
						value="Logout" />
				</form></td>
		</tr>
		<td id="navigation"><a href="../menu" target="_top" class="links">Main
				Menu</a> &gt; <a href="/accounts" target="_top" class="links">Account
				List</a> &gt; <em><strong>View Own Account</strong> </em><strong></strong>
		</td>
		<td>&nbsp;</td>
		</tr>
	</table>
	<div id="form_table">
		<form id="form1" name="form1" method="post" action="/accounts">
			<input type="hidden" name="username" value="<%=userName%>" /> <input
				type="hidden" name="account-action" value="save-own-edited-account" />
			<table width="100%" frame="box" cellspacing="0" id="table">




				<tr>
					<td class="bkgrnd_white">&nbsp;</td>
				</tr>
				<tr>
					<td class="header_rows">
						<div class="header_1">Personal Information</div></td>
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
								<td><input type="text" name="title" id="title" maxlength="19"
									<%if (person.getTitle() != null) {%>
									value="<%=person.getTitle()%>" <%}%> />
								</td>
							</tr>
							<tr>
								<td class="align_right" id="align_right">Name:<br /></td>
								<td><input name="name" type="text" class="required"
									id="name" value="<%=person.getName()%>" maxlength="79"
									<%String nameOK = (String) request.getAttribute("nameOK");
			String name = (String) request.getAttribute("name");
			if (nameOK != null && !nameOK.isEmpty() && !nameOK.equalsIgnoreCase("false")) {
				out.print("value=" + '"' + name + '"');
			}%> />
									<br /></td>
							</tr>
						</table></td>
				</tr>
				<tr class="header_rows">
					<td>
						<div class="header_1">Work Information</div></td>
				</tr>

				<tr>
					<td>
						<table width="100%" border="0" cellspacing="5">
							<tr align="center" class="align_center">
								<td width="40%">Designation</td>
								<td width="25%">Employee No.</td>
								<td width="35%">Division/Office</td>
							</tr>
							<%
								int ctr;
								int extraSpaceCtr = 0;
								for (ctr = 0; ctr < employees.size(); ctr++) {
							%>
							<tr>
								<td>
									<div align="center">
										<label for="designation_1"></label> <input
											name="designation<%=ctr + 1%>" type="text" class="required"
											id="designation_1" maxlength="44"
											<%if (employees != null && !employees.isEmpty())
					out.print("value=" + '"' + employees.get(ctr).getDesignation() + '"');%> />

									</div></td>
								<td>
									<div align="center">
										<input name="employeeNo<%=ctr + 1%>" type="text"
											id="employeeNo._1" size="4" maxlength="44"
											<%if (employees != null && !employees.isEmpty() && employees.get(ctr).getEmployeeNumber() != null)
					out.print("value=" + '"' + employees.get(ctr).getEmployeeNumber() + '"');%> />
									</div></td>
								<td>
									<div align="center">
										<select name="divisionOffice<%=ctr + 1%>"
											class="required_menulist" id="divisionOffice">
											<option></option>
											<%
												for (int ctr2 = 0; ctr2 < dList.size(); ctr2++) {
											%>

											<option
												<%if (employees.get(ctr).getDivisionOffice() != null && dList.get(ctr2).getId() == employees.get(ctr).getDivisionOffice().getId()) {%>
												selected="selected"
												<%}
					if (employees.get(ctr).getDivisionOffice() != null && employees.get(ctr).getDivisionOffice().getOfficeName() != null)
						string = "/" + employees.get(ctr).getDivisionOffice().getOfficeName();%>
												value="<%=dList.get(ctr2).getId()%>"><%=dList.get(ctr2).getDivisionName()%></option>
											<%
												}
											%>
											<%
												if (employees.get(ctr).getDivisionOffice() != null)
														out.print(employees.get(ctr).getDivisionOffice().getDivisionName() + string);
											%>
										</select>
									</div></td>
							</tr>
							<%
								extraSpaceCtr = ctr + 1;
								}
							%>
							<%
								for (; extraSpaceCtr < 5; extraSpaceCtr++) {
							%><tr>
								<td>
									<div align="center">
										<label for="designation_1"></label> <input
											name="designation<%=extraSpaceCtr + 1%>" type="text"
											class="required" id="designation_1" maxlength="44"
											<%String[] designation = (String[]) request.getAttribute("designation");
				String[] employeeNo = (String[]) request.getAttribute("employeeNo");
				String designation1OK = (String) request.getAttribute("designation1OK");
				if (designation != null && !designation[extraSpaceCtr].isEmpty()) {
					out.print("value=" + '"' + designation[extraSpaceCtr] + '"');
				}%> />

									</div></td>
								<td>
									<div align="center">
										<input name="employeeNo<%=extraSpaceCtr + 1%>" type="text"
											id="employeeNo._1" size="4" maxlength="44"
											<%if (employeeNo != null && employeeNo[extraSpaceCtr] != null && !employeeNo[extraSpaceCtr].isEmpty())
					out.print("value=" + '"' + employeeNo[extraSpaceCtr] + '"');%> />
									</div></td>
								<td>
									<div align="center">
										<select name="divisionOffice<%=extraSpaceCtr + 1%>"
											class="required_menulist" id="divisionOfficeDropdown">
											<option></option>
											<%
												for (int i = 0; i < dList.size(); i++) {
											%>
											<option value="<%=dList.get(i).getId()%>">
												<%
													if (dList.get(i).getOfficeName() != null)
																out.print(dList.get(i).getDivisionName() + "," + dList.get(i).getOfficeName());
															else
																out.print(dList.get(i).getDivisionName());
												%>
											</option>
											<%
												}
											%>
										</select>
									</div></td>
							</tr>
							<%
								}
							%>
							<tr>
							</tr>
						</table></td>
				</tr>
				<tr class="header_rows">
					<td>
						<div class="header_1">Contact Information</div></td>
				</tr>
				<tr>
					<td>
						<table width="100%" cellspacing="9" frame="box"
							class="no_border_table">
							<tr>
								<%
									Contact[] contacts = new Contact[account.getPerson().getContacts().size()];
									account.getPerson().getContacts().toArray(contacts);
									ArrayList<Contact> mobile = new ArrayList<Contact>();
									ArrayList<Contact> landline = new ArrayList<Contact>();
									ArrayList<Contact> email = new ArrayList<Contact>();
									if (contacts != null) {

										for (int i = 0; i < contacts.length; i++) {
											if (contacts[i].getType().equals(ContactType.EMAIL))
												email.add(contacts[i]);

											if (contacts[i].getType().equals(ContactType.MOBILE))
												mobile.add(contacts[i]);

											if (contacts[i].getType().equals(ContactType.LANDLINE))
												landline.add(contacts[i]);
										}
									}
								%>
								<td class="align_right">Cellphone Number:</td>
								<td>
									<%
										if (!mobile.isEmpty()) {
											for (int i = 0; i < mobile.size(); i++) {
									%> <input type="text" name="cellphoneNumber"
									id="cellphoneNumber" value="<%=mobile.get(i).getData()%>"
									maxlength="44"></input> <%
 	}
 	} else {
 %> <input name="cellphoneNumber" size="20" maxlength="44" /> <%
 	}
 %>
								</td>
							</tr>
							<tr>
								<td class="align_right">Landline:</td>
								<td>
									<%
										if (!landline.isEmpty()) {

											for (int i = 0; i < landline.size(); i++) {
									%> <input type="text" name="landline" id="landline"
									value="<%=landline.get(i).getData()%>" size="20" maxlength="44"></input>
									<%
										}

										} else {
									%> <input name="landline" size="20" maxlength="44" /> <%
 	}
 %>
								</td>
							</tr>
							<tr>
								<td class="align_right">E-mail Add:</td>
								<td>
									<%
										if (!email.isEmpty()) {

											for (int i = 0; i < email.size(); i++) {
									%> <input name="e-mail_ad" id="e-mail_ad"
									value="<%=email.get(i).getData()%>" size="20" maxlength="44"></input>
									<%
										}

										} else {
									%> <input name="e-mail_ad" size="20" maxlength="44" /> <%
 	}
 %>
								</td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<td class="header_rows">
						<div class="header_1">Account Information</div></td>
				</tr>
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="9">
							<tr>
								<td class="align_right">Username:</td>
								<td><input type="text" name="username" id="username2" input
									type="text" name="username" id="username"
									value="<%=account.getUsername()%>" disabled="disabled" />
								</td>
							</tr>

							<tr>
								<td class="align_right">Old Password:</td>
								<td><input name="password" type="password" class="required"
									id="password" maxlength="44" />
								</td>
							</tr>
							<tr>
								<td class="align_right">New Password:</td>
								<td><input name="newPassword" type="password"
									class="required" id="newPassword" maxlength="44" />
								</td>
							</tr>
							<tr>
								<td class="align_right">Reenter Password:</td>
								<td><input name="reenterPassword" type="password"
									class="required" id="reenterPassword" maxlength="44" />
								</td>
							</tr>
							<tr>
								<td class="align_right">Account Type:</td>
								<td><input name="accountType2" class="required"
									id="accountType2" value="<%=account.getType()%>"
									disabled="disabled" size="20" /> <input name="accountType"
									type="hidden" value="<%=account.getType().toString()%>" /></td>
							</tr>
							<tr>
								<td class="align_right">&nbsp;</td>
								<td><input name="createBtn" type="submit" class="button"
									id="createBtn" value="UPDATE" />
								</td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<td class="table_footer"></td>
				</tr>
				<tr>
					<td class="bkgrnd_white">&nbsp;</td>
				</tr>
			</table>

		</form>
	</div>

	<!--<div id="footer"></div>-->
</body>
</html>