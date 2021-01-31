package com.atmecs.test.operations;

import org.hibernate.cfg.Configuration;

import com.atmecs.test.entity.Employee;
import com.atmecs.test.utilities.HibernateUtility;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;

public class AddEmployee {

	public void addRecord() {
Scanner scan=new Scanner(System.in);
Session session=HibernateUtility.currentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Enter the number of records you want to insert :");
			int recordCount=scan.nextInt();
			for(int i=1;i<=recordCount;i++)
			{
				System.out.println("Enter the details of Employee "+i);
				System.out.println("Enter Id:");
				int id=scan.nextInt();
				System.out.println("Enter First Name :");
				String firstName=scan.next();
				System.out.println("Enter Last Name :");
				String lastName=scan.next();
				System.out.println("Enter Email: ");
				String email=scan.next();
				Employee employee=new Employee(id, firstName, lastName, email);
				session.save(employee);
				
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