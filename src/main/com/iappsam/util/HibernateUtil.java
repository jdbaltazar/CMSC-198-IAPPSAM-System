package com.iappsam.util;

import java.util.Properties;
import java.util.TimeZone;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.iappsam.entities.Account;
import com.iappsam.entities.AccountType;
import com.iappsam.entities.Building;
import com.iappsam.entities.Contact;
import com.iappsam.entities.ContactType;
import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.DivisionOfficeContact;
import com.iappsam.entities.Employee;
import com.iappsam.entities.EntityRemover;
import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Person;
import com.iappsam.entities.PersonContact;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.Supplier;
import com.iappsam.entities.SupplierContact;
import com.iappsam.entities.Unit;
import com.iappsam.entities.forms.AnnualProcurementPlan;
import com.iappsam.entities.forms.AnnualProcurementPlanLine;
import com.iappsam.entities.forms.Disposal;
import com.iappsam.entities.forms.IIRUP;
import com.iappsam.entities.forms.IIRUPLine;
import com.iappsam.entities.forms.InventoryCustodianSlip;
import com.iappsam.entities.forms.InventoryCustodianSlipLine;
import com.iappsam.entities.forms.InventoryOfEquipment;
import com.iappsam.entities.forms.InventoryOfEquipmentLine;
import com.iappsam.entities.forms.ModeOfProcurement;
import com.iappsam.entities.forms.PTRPA;
import com.iappsam.entities.forms.PTRPALine;
import com.iappsam.entities.forms.PropertyAcknowledgementReceipt;
import com.iappsam.entities.forms.PropertyAcknowledgementRecieptLine;
import com.iappsam.entities.forms.PurchaseOrder;
import com.iappsam.entities.forms.PurchaseOrderLine;
import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.entities.forms.PurchaseRequestLine;
import com.iappsam.entities.forms.RSMI;
import com.iappsam.entities.forms.RSMILine;
import com.iappsam.entities.forms.RecapitulationLine;
import com.iappsam.entities.forms.RequisitionAndIssueSlip;
import com.iappsam.entities.forms.RequisitionAndIssueSlipLine;
import com.iappsam.entities.forms.WasteMaterialsReport;
import com.iappsam.entities.forms.WasteMaterialsReportLine;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.WMRManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.managers.sessions.WMRManagerSession;

/**
 * Startup Hibernate and provide access to the singleton SessionFactory
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		if (!tryToBuildSessionFactory("root", "123456"))
			throw new RuntimeException("connection unsuccessful");
	}

	private static boolean tryToBuildSessionFactory(String username, String password) throws ExceptionInInitializerError {
		try {
			Properties p = new Properties();
			p.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			p.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/iappsam");
			// p.setProperty("hibernate.show_sql", "true");
			p.setProperty("hibernate.connection.username", username);
			p.setProperty("hibernate.connection.password", password);
			p.setProperty("hibernate.search.default.indexBase", "./lucene-index");
			p.setProperty("hibernate.search.default.directory_provider", "filesystem");

			Configuration conf = new Configuration();

			// entities
			conf.setProperties(p);
			conf.addAnnotatedClass(Account.class);
			conf.addAnnotatedClass(Building.class);
			conf.addAnnotatedClass(Contact.class);
			conf.addAnnotatedClass(ContactType.class);
			conf.addAnnotatedClass(DivisionOffice.class);
			conf.addAnnotatedClass(DivisionOfficeContact.class);
			conf.addAnnotatedClass(Employee.class);
			conf.addAnnotatedClass(Item.class);
			conf.addAnnotatedClass(ItemCategory.class);
			conf.addAnnotatedClass(ItemCondition.class);
			conf.addAnnotatedClass(ItemStatus.class);
			conf.addAnnotatedClass(ItemCategory.class);
			conf.addAnnotatedClass(Person.class);
			conf.addAnnotatedClass(PersonContact.class);
			conf.addAnnotatedClass(Signatory.class);
			conf.addAnnotatedClass(Supplier.class);
			conf.addAnnotatedClass(SupplierContact.class);
			conf.addAnnotatedClass(Unit.class);

			// //form entities
			conf.addAnnotatedClass(AnnualProcurementPlan.class);
			conf.addAnnotatedClass(AnnualProcurementPlanLine.class);
			conf.addAnnotatedClass(Disposal.class);
			conf.addAnnotatedClass(IIRUP.class);
			conf.addAnnotatedClass(IIRUPLine.class);
			conf.addAnnotatedClass(InventoryCustodianSlip.class);
			conf.addAnnotatedClass(InventoryCustodianSlipLine.class);
			conf.addAnnotatedClass(InventoryOfEquipment.class);
			conf.addAnnotatedClass(InventoryOfEquipmentLine.class);
			conf.addAnnotatedClass(ModeOfProcurement.class);
			conf.addAnnotatedClass(PropertyAcknowledgementReceipt.class);
			conf.addAnnotatedClass(PropertyAcknowledgementRecieptLine.class);
			conf.addAnnotatedClass(PTRPA.class);
			conf.addAnnotatedClass(PTRPALine.class);
			conf.addAnnotatedClass(PurchaseOrder.class);
			conf.addAnnotatedClass(PurchaseOrderLine.class);
			conf.addAnnotatedClass(PurchaseRequest.class);
			conf.addAnnotatedClass(PurchaseRequestLine.class);
			conf.addAnnotatedClass(RecapitulationLine.class);
			conf.addAnnotatedClass(RequisitionAndIssueSlip.class);
			conf.addAnnotatedClass(RequisitionAndIssueSlipLine.class);
			conf.addAnnotatedClass(RSMI.class);
			conf.addAnnotatedClass(RSMILine.class);
			conf.addAnnotatedClass(WasteMaterialsReport.class);
			conf.addAnnotatedClass(WasteMaterialsReportLine.class);

			sessionFactory = conf.buildSessionFactory();

			addDefaulEntities();
			return true;
		} catch (Throwable ex) {
			ex.printStackTrace();
			sessionFactory = null;
			return false;
		}
	}

	private static void addDefaulEntities() throws TransactionException, DuplicateEntryException {
		addAdminAccount();
		addDisposals();
		addItemDependencies();
	}

	public static void addItemDependencies() throws TransactionException, DuplicateEntryException {
		ItemManager im = new ItemManagerSession();
		im.addUnit("PCS");
		im.addItemStatus("Not Available");
		im.addItemStatus("Available");
		im.addItemCondition("Good Condition");
		im.addItemCategory("Common Office Supplies");
		im.addItemCategory("Other Office Supplies");
		im.addItemCategory("Common Office Supplies (Exclusive Distributorship)");
		im.addItemCategory("Common Computer Supplies");
		im.addItemCategory("Common Janitorial Supplies");
		im.addItemCategory("Common Electrical/Planing Supplies");
		im.addItemCategory("Office Forms (for Purchasing)");
		im.addItemCategory("Others");
	}

	public static void addDisposals() throws TransactionException {
		WMRManager wmrm = new WMRManagerSession();
		wmrm.addDisposal("Destroyed");
		wmrm.addDisposal("Sold at private sale");
		wmrm.addDisposal("Sold at public auction");
		wmrm.addDisposal("Transferred Without Cost");
	}

	public static void addAdminAccount() throws TransactionException {
		AccountManagerSession am = new AccountManagerSession();
		am.addAccount(new Account("admin", "admin", AccountType.SYSTEM_ADMIN, new Person("admin")));
	}

	public static Session startSession() throws HibernateException {
		return sessionFactory.openSession();
	}

	public static void endSession() {
		sessionFactory.close();
	}

	public static boolean isConnected() {
		return sessionFactory != null;
	}

	public static boolean evaluate(String username, String password) {
		if (!isConnected())
			return tryToBuildSessionFactory(username, password);
		else
			return false;
	}

	public static void close() {

		if (isConnected()) {
			sessionFactory.close();
			sessionFactory = null;
		}
	}
}
