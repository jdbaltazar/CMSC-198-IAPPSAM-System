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
<title>IAPPSAM::Create Account</title>
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
			String userName = request.getParameter("username");
			if (userName == null)
				userName = (String) request.getAttribute("username");
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
				</form>
			</td>
		</tr>
		<tr>
			<td id="navigation"><a href="../menu" target="_top"
				class="links">Main Menu</a> &gt; <a
				href="accounts?account-action=view-accounts" target="_top"
				class="links">Account List</a> &gt; <em><strong>Create
						Account</strong> </em><strong></strong></td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="form_table">
		<form id="form1" name="form1" method="post" action="/accounts">
			<input type="hidden" name="username" value="<%=userName%>" /> <input
				type="hidden" name="account-action" value="save-edited-account" />
			<table width="100%" frame="box" cellspacing="0" id="table" style="table-layout:fixed">


				<tr>
					<td align="right" class="bkgrnd_white"><a
						href="create-account-for-employee.do" target="_self"
						class="linkBtn">Create Account For Existing Employee>></a></td>
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
										<%if (person.getTitle() != null) {%>
										value="<%=person.getTitle()%>" <%}%> /></td>
								</tr>
								<tr>
									<td class="align_right" id="align_right">Name:<br />
									</td>
									<td><input name="name" type="text" class="required" id="name"
										value="<%=person.getName()%>"
										<%String nameOK = (String) request.getAttribute("nameOK");
			String name = (String) request.getAttribute("name");
			if (nameOK != null && !nameOK.isEmpty() && !nameOK.equalsIgnoreCase("false")) {
				out.print("value=" + '"' + name + '"');
			} else {%> <%}%> /> <%
 	if (nameOK != null && !nameOK.isEmpty() && nameOK.equalsIgnoreCase("false")) {
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
									<td width="40%">Designation</td>
									<td width="25%">Employee No.</td>
									<td width="35%">Division/Office</td>
								</tr>
								<%
									for (int i = 0; i < employees.size(); i++) {
								%>
								<tr>
									<td>
										<div align="center">
											<label for="designation_1"></label> <input
												name="designation" type="text" class="required" id="designation_1"
												<%if (employees != null && !employees.isEmpty())
					out.print("value=" + '"' + employees.get(i).getDesignation() + '"');%> />

										</div>
									</td>
									<td>
										<div align="center">
											<input name="empNo3" type="text" id="employeeNo._1" size="4"
												<%if (employees != null && !employees.isEmpty()&&employees.get(i).getEmployeeNumber()!=null)
					out.print("value=" + '"' + employees.get(i).getEmployeeNumber() + '"');%> />
										</div>
									</td>
									<td>
										<div align="center">
											<select name="divisionOffice" class="required_menulist"
												id="divisionOffice">
												<%
													for (int j = 0; j < dList.size(); j++) {
												%>

												<option
													<%if (employees.get(i).getDivisionOffice() != null && dList.get(j).getId() == employees.get(i).getDivisionOffice().getId()) {%>
													selected="selected"
													<%}
					if (employees.get(i).getDivisionOffice() != null && employees.get(i).getDivisionOffice().getOfficeName() != null)
						string = "/" + employees.get(i).getDivisionOffice().getOfficeName();%>
													value="<%=dList.get(j).getId()%>"><%=dList.get(j).getDivisionName()%></option>
												<%
													}
												%>
												<%
													if (employees.get(i).getDivisionOffice() != null)
															out.print(employees.get(i).getDivisionOffice().getDivisionName() + string);
												%>
											</select>
										</div>
									</td>
								</tr>
								<%
									}
								%>
								<tr>
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
										id="cellphoneNumber" value=" <%=mobile.get(i).getData()%>"></input>
										<%
											}
											} else {
										%> <input name="cellphoneNumber" size="20" maxlength="20" /> <%
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
										value="<%=landline.get(i).getData()%>" size="20"
										maxlength="20"></input> <%
 	}

 	} else {
 %> <input name="landline" size="20" maxlength="20" /> <%
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
										value="<%=email.get(i).getData()%>" size="20" maxlength="20"></input>
										<%
											}

											} else {
										%> <input name="e-mail_ad" size="20" maxlength="20" /> <%
 	}
 %>
									</td>
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
									<td class="align_right">Username:</td>
									<td><input type="text" name="username" id="username2"
										input type="text" name="username" id="username"
										value="<%=account.getUsername()%>" disabled="disabled" /></td>
								</tr>
								<tr>
									<td class="align_right">New Password:</td>
									<td><input name="password" type="password" class="required" id="password"
										<%String passwordOk = (String) request.getAttribute("passwordOK");%> />
										<%
											if (passwordOk != null && !passwordOk.isEmpty() && passwordOk.equalsIgnoreCase("false")) {
												out.print("*");
											}
										%>
									</td>
								</tr>

								<tr>
									<td class="align_right">Reenter Password:</td>
									<td><input name="reenterPassword" type="password" class="required"
										id="newPassword" /> <%
 	if (passwordOk != null && !passwordOk.isEmpty() && passwordOk.equalsIgnoreCase("false")) {
 		out.print("*");
 	}
 %>
									</td>
								</tr>
								<tr>
									<td class="align_right">Account Type:</td>
									<td><select name="accountType" class="required_menulist"
										id="accountType">
											<%
												for (int i = 0; i < accountTypes.length; i++) {
											%>
											<option <%if (account.getType().equals(accountTypes[i])) {%>
												selected="selected" <%}%>><%=accountTypes[i].toString()%></option>
											<%
												}
											%>
								  </select></td>
								</tr>
								<tr>
									<td class="align_right">&nbsp;</td>
									<td><input name="createBtn" type="submit" class="button"
										id="createBtn" value="UPDATE" /></td>
								</tr>
							</table>
						</td>
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