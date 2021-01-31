package com.atmecs.test.operations;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.atmecs.test.entity.Employee;
import com.atmecs.test.utilities.HibernateUtility;

public class DisplayEmployee {

	public void displayRecords() {
		Session session=HibernateUtility.currentSession();
		try {
			session.beginTransaction();

			Query query = session.createQuery("from Employee employee");
			List list = query.list();
			System.out.println("Total Number of Records : " + list.size());
			Iterator itr = list.iterator();
			while (itr.hasNext()) {
				Object object = (Object) itr.next();
				Employee employee = (Employee) object;
				System.out.println("Id :" + employee.getId());
				System.out.println("First Name : " + employee.getFirstName());
				System.out.println("Last Name :" + employee.getLastName());
				System.out.println("Email : " + employee.getEmail());
				System.out.println("===========================================");

			}
			session.getTransaction().commit();
		
		} catch (SessionException e) {
System.out.println(e);
		} 
		finally
		{
			HibernateUtility.closeSession();
		}

	}

}
