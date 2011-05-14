package com.iappsam.util;

import java.util.Properties;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.iappsam.entities.Person;

/**
 * Startup Hibernate and provide access to the singleton SessionFactory
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		try {
			// sessionFactory = new Configuration()
			// //
			// .setProperty("hibernate.connection.driver_class",
			// "com.mysql.jdbc.Driver")
			// .setProperty("hibernate.connection.url",
			// "jdbc:mysql://localhost/trial")
			// .setProperty("hibernate.connection.username", "root")
			// .setProperty("hibernate.connection.password", "123456")
			// .setProperty("hibernate.dialect",
			// "org.hibernate.dialect.MySQLDialect")
			// .setProperty("hibernate.c3p0.min_size", "5")
			// .setProperty("hibernate.c3p0.max_size", "20")
			// .setProperty("hibernate.c3p0.timeout", "300")
			// .setProperty("hibernate.c3p0.max_statements", "50")
			// .setProperty("hibernate.c3p0.idle_test_period", "3000")//
			// .addAnnotatedClass(com.trial.Person.class)//
			// .configure().buildSessionFactory();

			Properties p = new Properties();
			p.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			p.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/iappsam");
			p.setProperty("hibernate.connection.username", "root");
			p.setProperty("hibernate.connection.password", "123456");

			sessionFactory = new Configuration().setProperties(p).addAnnotatedClass(Person.class).buildSessionFactory();

		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session startSession() throws HibernateException {
		return sessionFactory.openSession();
	}

	public static void endSession() {
		sessionFactory.close();
	}
}
