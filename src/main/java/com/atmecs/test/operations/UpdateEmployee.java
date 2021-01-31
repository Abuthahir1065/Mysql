package com.atmecs.test.operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.atmecs.test.entity.Employee;
import com.atmecs.test.utilities.HibernateUtility;

public class UpdateEmployee {

	public void updateRecord() {

		Scanner scan = new Scanner(System.in);
		Session session = HibernateUtility.currentSession();
		try {
			session.beginTransaction();
			System.out.println("Enter the Id you want to update");
			int id = scan.nextInt();
			Employee employee = session.get(Employee.class, id);
			System.out.println("Choose the field you want to modify:\n1.firstName\n2.lastName\n3.email\n");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the Value to be modified :");
				String firstName = scan.next();
				employee.setFirstName(firstName);
				break;
			case 2:
				System.out.println("Enter the Value to be modified :");
				String lastName = scan.next();
				employee.setLastName(lastName);
				break;
			case 3:
				System.out.println("Enter the Value to be modified :");
				String email = scan.next();
				employee.setEmail(email);
				break;
			default:
				System.out.println("Wrong Chocie");
				break;
			}
			session.getTransaction().commit();
		} catch (SessionException e) {
System.out.println(e);
		} finally {
			HibernateUtility.closeSession();
		}
	}
}
