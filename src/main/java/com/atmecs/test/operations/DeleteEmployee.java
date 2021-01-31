package com.atmecs.test.operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.atmecs.test.entity.Employee;
import com.atmecs.test.utilities.HibernateUtility;

public class DeleteEmployee {

	public void deleteRecord() {
		Scanner scan = new Scanner(System.in);
		Session session=HibernateUtility.currentSession();
		try {
			session.beginTransaction();
			Employee employee = new Employee();
			System.out.println("Enter the Id you want to delete");
			int id = scan.nextInt();
			employee.setId(id);
			session.delete(employee);

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
