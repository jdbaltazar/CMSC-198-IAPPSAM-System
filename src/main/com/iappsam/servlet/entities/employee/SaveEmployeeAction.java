package com.iappsam.servlet.entities.employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.Validator;
import com.iappsam.util.Verifier;

public class SaveEmployeeAction implements Action {

	private String title;
	private String name;
	private String[] designation = new String[5];
	private String[] employeeNo = new String[5];;
	private String[] divisionOfficeID = new String[5];
	private String mobileNumber;
	private String landline;
	private String emailad;
	private boolean validAllEmployees = true;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {

		
		System.out.println("inside save employee");
		
		title = request.getParameter("title");
		name = request.getParameter("name");
		for (int i = 1; i <= 5; i++) {
			designation[i - 1] = request.getParameter("designation" + i);
			employeeNo[i - 1] = request.getParameter("employeeNo" + i);
			divisionOfficeID[i - 1] = request.getParameter("divisionOffice" + i);
		}

		mobileNumber = request.getParameter("mobileNumber");
		landline = request.getParameter("landline");
		emailad = request.getParameter("email_ad");

		Person person = new Person();
		if (Validator.validField(title))
			person.setTitle(title.trim());
		if (Validator.validField(name))
			person.setName(name);

		if (Validator.validField(mobileNumber)) {
			person.addContact(new Contact(mobileNumber.trim(), ContactType.MOBILE));
		}

		if (Validator.validField(landline)) {
			person.addContact(new Contact(landline.trim(), ContactType.LANDLINE));
		}

		if (Validator.validField(emailad)) {
			person.addContact(new Contact(emailad.trim(), ContactType.EMAIL));
		}

		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();

		for (int i = 0; i < 5; i++) {
			if (Verifier.validEntry(designation[i]) && divisionOfficeID[i] != null) {
				Employee e = new Employee();
				e.setDesignation(designation[i].trim());
				DivisionOffice d = doManager.getDivisionOffice(Integer.parseInt(divisionOfficeID[i]));
				if (d != null) {
					e.setDivisionOffice(d);
				}
				if (Verifier.validEntry(employeeNo[i])) {
					e.setEmployeeNumber(employeeNo[i].trim());
				}
				person.addEmployment(e);
			}
		}

		// if valid all, save then view all employees
		// else, return page and show the inputs except for the wrong ones

		if (validAllEmployees) {
			
			try{
			savePerson(person, request, response);
			System.out.println("employee was saved!!!!!!!");
			return;
			
			}catch(Exception e){
				Action action = new AddEmployeeAction();
				action.process(request, response);
				return;
			}
		} else {
			// send the person (incomplete data)
			Action action = new AddEmployeeAction();
			action.process(request, response);
			return;
		}

	}

	private void savePerson(Person person, HttpServletRequest request, HttpServletResponse response) throws TransactionException, ServletException,
			IOException {
		PersonManager pManager = new PersonManagerSession();
		try {
			pManager.addPerson(person);
		} catch (DuplicateEntryException e) {
			e.printStackTrace();
		}

		Action viewAction = new SearchEmployeesAction();
		viewAction.process(request, response);
		return;
	}

}
