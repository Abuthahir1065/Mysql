package com.atmecs.test.operations;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.atmecs.test.entity.Employee;
import com.atmecs.test.utilities.HibernateUtility;

public class RetrieveEmployee {
	public void retrieveRecord() {
		
	Scanner scan=new Scanner(System.in);
	Session session=HibernateUtility.currentSession();
	try {
		session.beginTransaction();
        System.out.println("Enter the id of an employee to retrieve :");
        int id=scan.nextInt();
        Employee employee = (Employee) session.get(Employee.class, id);
			System.out.println("Id :" + employee.getId());
			System.out.println("First Name : " + employee.getFirstName());
			System.out.println("Last Name :" + employee.getLastName());
			System.out.println("Email : " + employee.getEmail());
			System.out.println("===========================================");

		
		session.getTransaction().commit();
	} catch (SessionException e) {
System.out.println(e);
	} 
	finally
	{
		HibernateUtility.closeSession();
	}
}}
