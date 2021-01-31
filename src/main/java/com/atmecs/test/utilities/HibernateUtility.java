package com.atmecs.test.utilities;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.atmecs.test.entity.Employee;



public class HibernateUtility {
public  static final SessionFactory factory;
static
{
	try
	{
		 Configuration config = new Configuration().addAnnotatedClass(Employee.class).configure();
		 factory = config.buildSessionFactory();
		

	}
	catch(Throwable e )
	{
		System.out.println("Session Factory Creation Failed..!"+e);
		throw new ExceptionInInitializerError(e);
	}
	
}
public static final ThreadLocal session = new ThreadLocal();
public static Session currentSession() throws HibernateException {
    Session s = (Session) session.get();
    // Open a new Session, if this thread has none yet
    if (s == null) {
      s = factory.openSession();
      // Store it in the ThreadLocal variable
      session.set(s);
    }
    return s;
  }

  public static void closeSession() throws HibernateException {
    Session s = (Session) session.get();
    if (s != null)
      s.close();
    session.set(null);
  }
}
