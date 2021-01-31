package com.atmecs.test.main;


import java.util.Scanner;

import com.atmecs.test.operations.AddEmployee;
import com.atmecs.test.operations.DeleteEmployee;
import com.atmecs.test.operations.DisplayEmployee;
import com.atmecs.test.operations.RetrieveEmployee;
import com.atmecs.test.operations.UpdateEmployee;



public class EmployeeMainClass {
	static int choice;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		do {
			System.out.println("Enter your Choice");
			System.out.println("1.Create Record\n2.Update Record\n3.Display records\n4.Delete Record\n5.Retrieve Employee Details\n6.Exit");
			System.out.println("=========================================================");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				AddEmployee add = new AddEmployee();
				add.addRecord();
				break;
			case 2:
				UpdateEmployee update = new UpdateEmployee();
				update.updateRecord();
				break;
			case 3:

				DisplayEmployee display = new DisplayEmployee();
				display.displayRecords();
				break;
			case 4:
				DeleteEmployee delete=new DeleteEmployee();
				delete.deleteRecord();
				break;
			case 5:
				RetrieveEmployee retrieve=new RetrieveEmployee();
				retrieve.retrieveRecord();
				break;
			case 6:
				System.out.println("You have pressed 3..The Program has been Ended..!!");
				System.out.println("============================================");
				break;

			default:
				System.out.println("Wrong Choice..!");
				System.out.println("============================================");

				break;
			}
		} while (choice != 6);
	}

}
