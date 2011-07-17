<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.iappsam.Employee"%>
<%@page import="com.iappsam.Person"%>
<%@page import="com.iappsam.DivisionOffice"%>
<%@page import="java.util.List"%>
<%@page
	import="com.iappsam.managers.sessions.DivisionOfficeManagerSession"%>
<%@page import="com.iappsam.managers.DivisionOfficeManager"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IAPPSAM::Add Employee</title>
<link href="../../css/header.css" rel="stylesheet" type="text/css" />
<link href="../../css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<%
		List<DivisionOffice> divisionOffices = (List<DivisionOffice>) request.getAttribute("divOffices");
		Person person = (Person) request.getAttribute("person");
		if (person == null)
			person = new Person();
		Employee[] employments = (Employee[]) request.getAttribute("employments");
		if (employments == null)
			employments = new Employee[5];
		String mobile = (String) request.getAttribute("mobile");
		if (mobile == null)
			mobile = "";
		String landline = (String) request.getAttribute("landline");
		if (landline == null)
			landline = "";
		String email = (String) request.getAttribute("email");
		if (email == null)
			email = "";
	%>
	<div id="headerBkgrnd">
		<img src="../../images/headerbar.png" width="100%" height="129" />
	</div>
	<div id="logo">
		<img src="../../images/headerlogo.png" width="124" height="128" />
	</div>
	<div id="headerName">
		<img src="../../images/headertext.png" width="452" height="44" />
	</div>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<table width="100%" border="0" cellspacing="0">
		<tr>
			<td width="32%">&nbsp;</td>
			<td width="68%">
				<form id="form2" name="form2" method="post" action="logout">
					<input name="logoutBtn" type="submit" class="logout" id="logoutBtn"
						value="Logout" />
				</form>
			</td>
		</tr>
		<tr>
			<td id="navigation"><a href="../menu" target="_top"
				class="links">Main Menu</a> &gt; <a
				href="/employee?employee-action=search-employees" target="_top"
				class="links">Employee List</a> &gt; <em><strong>Add
						Employee</strong> </em><strong></strong></td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="form_table">
		<form id="form1" name="form1" method="post" action="employee">
			<table width="100%" frame="box" cellspacing="0" id="table">
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
									String title = "";
									if (person.getTitle() != null) {
										title = person.getTitle();
									}
								%>
								<td class="align_right" id="align_right">Title:</td>
								<td><input type="text" name="title" id="title"
									value="<%=title%>" />
								</td>
							</tr>
							<tr>
								<%
									String name = "";
									if (person.getName() != null)
										name = person.getName();
								%>
								<td class="align_right" id="align_right">*Name:<br />
								</td>
								<td><input type="text" name="name" id="name"
									value="<%=name%>" /> <br />
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
									<div align="center">
										<label for="designation1"></label> <input type="text"
											name="designation1" id="designation1"
											<%if (employments[0] != null) {
				out.print("value=\"" + employments[0].getDesignation() + "\"");
			}%> />

									</div>
								</td>
								<td>
									<div align="center">
										<input name="employeeNo1" type="text" id="employeeNo1"
											size="4"
											<%if (employments[0] != null) {
				out.print("value=\"" + employments[0].getEmployeeNumber() + "\"");
			}%> />
									</div>
								</td>
								<td>
									<div align="center">
										<select name="divisionOffice1" class="required_menulist" id="divisionOffice1">
											<option value="0"></option>
											<%
												for (DivisionOffice d : divisionOffices) {
											%>
											<option value="<%="" + d.getId()%>">
												<%
													if (d.getOfficeName() != null)
															out.print(d.getDivisionName() + ": " + d.getOfficeName());
														else
															out.print(d.getDivisionName());
												%>
											</option>
											<%
												}
											%>
										</select>
									</div>
								</td>
							</tr>

							<tr>
								<td>
									<div align="center">
										<label for="designation2"></label> <input type="text"
											name="designation2" id="designation2"
											<%if (employments[1] != null) {
				out.print("value=\"" + employments[1].getDesignation() + "\"");
			}%> />

									</div>
								</td>
								<td>
									<div align="center">
										<input name="employeeNo2" type="text" id="employeeNo2"
											size="4"
											<%if (employments[1] != null) {
				out.print("value=\"" + employments[1].getEmployeeNumber() + "\"");
			}%> />
									</div>
								</td>
								<td>
									<div align="center">
										<select name="divisionOffice2" class="required_menulist" id="divisionOffice2">
											<option value="0"></option>
											<%
												for (DivisionOffice d : divisionOffices) {
											%>
											<option value="<%="" + d.getId()%>">
												<%
													if (d.getOfficeName() != null)
															out.print(d.getDivisionName() + ": " + d.getOfficeName());
														else
															out.print(d.getDivisionName());
												%>
											</option>
											<%
												}
											%>
										</select>
									</div>
								</td>
							</tr>


							<tr>
								<td>
									<div align="center">
										<label for="designation3"></label> <input type="text"
											name="designation3" id="designation3"
											<%if (employments[2] != null) {
				out.print("value=\"" + employments[2].getDesignation() + "\"");
			}%> />


									</div>
								</td>
								<td>
									<div align="center">
										<input name="employeeNo3" type="text" id="employeeNo3"
											size="4"
											<%if (employments[2] != null) {
				out.print("value=\"" + employments[2].getEmployeeNumber() + "\"");
			}%> />
									</div>
								</td>
								<td>
									<div align="center">
										<select name="divisionOffice3" class="required_menulist" id="divisionOffice3">
											<option value="0"></option>
											<%
												for (DivisionOffice d : divisionOffices) {
											%>
											<option value="<%="" + d.getId()%>">
												<%
													if (d.getOfficeName() != null)
															out.print(d.getDivisionName() + ": " + d.getOfficeName());
														else
															out.print(d.getDivisionName());
												%>
											</option>
											<%
												}
											%>
										</select>
									</div>
								</td>
							</tr>


							<tr>
								<td>
									<div align="center">
										<label for="designation4"></label> <input type="text"
											name="designation4" id="designation4"
											<%if (employments[3] != null) {
				out.print("value=\"" + employments[3].getDesignation() + "\"");
			}%> />

									</div>
								</td>
								<td>
									<div align="center">
										<input name="employeeNo4" type="text" id="employeeNo4"
											size="4"
											<%if (employments[3] != null) {
				out.print("value=\"" + employments[3].getEmployeeNumber() + "\"");
			}%> />
									</div>
								</td>
								<td>
									<div align="center">
										<select name="divisionOffice4" class="required_menulist" id="divisionOffice4">
											<option value="0"></option>
											<%
												for (DivisionOffice d : divisionOffices) {
											%>
											<option value="<%="" + d.getId()%>">
												<%
													if (d.getOfficeName() != null)
															out.print(d.getDivisionName() + ": " + d.getOfficeName());
														else
															out.print(d.getDivisionName());
												%>
											</option>
											<%
												}
											%>
										</select>
									</div>
								</td>
							</tr>


							<tr>
								<td>
									<div align="center">
										<label for="designation5"></label> <input type="text"
											name="designation5" id="designation5"
											<%if (employments[4] != null) {
				out.print("value=\"" + employments[4].getDesignation() + "\"");
			}%> />

									</div>
								</td>
								<td>
									<div align="center">
										<input name="employeeNo5" type="text" id="employeeNo5"
											size="4"
											<%if (employments[4] != null) {
				out.print("value=\"" + employments[4].getEmployeeNumber() + "\"");
			}%> />
									</div>
								</td>
								<td>
									<div align="center">
										<select name="divisionOffice5" class="required_menulist" id="divisionOffice5">
											<option value="0"></option>
											<%
												for (DivisionOffice d : divisionOffices) {
											%>
											<option value="<%="" + d.getId()%>">
												<%
													if (d.getOfficeName() != null)
															out.print(d.getDivisionName() + ": " + d.getOfficeName());
														else
															out.print(d.getDivisionName());
												%>
											</option>
											<%
												}
											%>
										</select>
									</div>
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
								<td class="align_right">Mobile Number:</td>
								<td><input type="text" name="mobileNumber"
									id="mobileNumber" value="<%=mobile%>" /></td>
							</tr>
							<tr>
								<td class="align_right">Landline:</td>
								<td><input type="text" name="landline" id="landline"
									value="<%=landline%>" />
								</td>
							</tr>
							<tr>
								<td class="align_right">Email Address:</td>
								<td><input type="text" name="email_ad" id="email_ad"
									value="<%=email%>" /></td>
							</tr>
							<tr>
								<td class="align_right">&nbsp;</td>
								<td><input name="addBtn" type="submit" class="button"
									id="addBtn" value="ADD" /> <input type="hidden"
									name="employee-action" value="save-employee" /> <br />
								</td>
							</tr>
						</table>
					</td>
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
