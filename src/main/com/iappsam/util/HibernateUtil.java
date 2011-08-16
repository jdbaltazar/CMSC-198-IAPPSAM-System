package com.iappsam.util;

import java.util.Properties;
import java.util.TimeZone;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.iappsam.Account;
import com.iappsam.Building;
import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.DivisionOffice;
import com.iappsam.DivisionOfficeContact;
import com.iappsam.Employee;
import com.iappsam.IappsamConfig;
import com.iappsam.Item;
import com.iappsam.ItemCategory;
import com.iappsam.ItemCondition;
import com.iappsam.ItemStatus;
import com.iappsam.Log;
import com.iappsam.Person;
import com.iappsam.PersonContact;
import com.iappsam.Signatory;
import com.iappsam.Supplier;
import com.iappsam.SupplierContact;
import com.iappsam.Unit;
import com.iappsam.forms.APP;
import com.iappsam.forms.APPLine;
import com.iappsam.forms.Disposal;
import com.iappsam.forms.ICS;
import com.iappsam.forms.ICSLine;
import com.iappsam.forms.IIRUP;
import com.iappsam.forms.IIRUPLine;
import com.iappsam.forms.IE;
import com.iappsam.forms.IELine;
import com.iappsam.forms.ModeOfProcurement;
import com.iappsam.forms.PAR;
import com.iappsam.forms.PARLine;
import com.iappsam.forms.PO;
import com.iappsam.forms.POLine;
import com.iappsam.forms.PR;
import com.iappsam.forms.PRLine;
import com.iappsam.forms.PTRPA;
import com.iappsam.forms.PTRPALine;
import com.iappsam.forms.RIS;
import com.iappsam.forms.RISLine;
import com.iappsam.forms.RSMI;
import com.iappsam.forms.RSMILine;
import com.iappsam.forms.RecapitulationLine;
import com.iappsam.forms.WMR;
import com.iappsam.forms.WMRLine;
import com.iappsam.servlet.filter.SecurityFilter;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";

	static {
		init();
	}

	public static void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		if (!tryToBuildSessionFactory(USERNAME, PASSWORD))
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

			conf.setProperties(p);
			conf.addAnnotatedClass(IappsamConfig.class);
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

			conf.addAnnotatedClass(APP.class);
			conf.addAnnotatedClass(APPLine.class);
			conf.addAnnotatedClass(Disposal.class);
			conf.addAnnotatedClass(IIRUP.class);
			conf.addAnnotatedClass(IIRUPLine.class);
			conf.addAnnotatedClass(ICS.class);
			conf.addAnnotatedClass(ICSLine.class);
			conf.addAnnotatedClass(IE.class);
			conf.addAnnotatedClass(IELine.class);
			conf.addAnnotatedClass(Log.class);
			conf.addAnnotatedClass(ModeOfProcurement.class);
			conf.addAnnotatedClass(PAR.class);
			conf.addAnnotatedClass(PARLine.class);
			conf.addAnnotatedClass(PTRPA.class);
			conf.addAnnotatedClass(PTRPALine.class);
			conf.addAnnotatedClass(PO.class);
			conf.addAnnotatedClass(POLine.class);
			conf.addAnnotatedClass(PR.class);
			conf.addAnnotatedClass(PRLine.class);
			conf.addAnnotatedClass(RecapitulationLine.class);
			conf.addAnnotatedClass(RIS.class);
			conf.addAnnotatedClass(RISLine.class);
			conf.addAnnotatedClass(RSMI.class);
			conf.addAnnotatedClass(RSMILine.class);
			conf.addAnnotatedClass(WMR.class);
			conf.addAnnotatedClass(WMRLine.class);

			conf.addAnnotatedClass(SecurityFilter.class);

			sessionFactory = conf.buildSessionFactory();

			return true;
		} catch (Throwable ex) {
			ex.printStackTrace();
			sessionFactory = null;
			return false;
		}
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

	public static IappsamConfig getIappsamConfig() {
		try {
			Session session = HibernateUtil.startSession();
			Transaction tx = session.beginTransaction();
			IappsamConfig config = (IappsamConfig) session.get(IappsamConfig.class, 1);
			tx.commit();
			session.close();
			return config;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void addIappsamConfig(IappsamConfig config) {
		try {
			Session session = HibernateUtil.startSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(config);
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
