package com.demo.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;

public class TestEmployeeList {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeService es=new EmployeeServiceImpl();
		int choice=0;
		do {
		System.out.println("1. Add new Employee\n2. Display all\n 3. Disaly by id\n 4. Display by name");
		System.out.println("5. sort by sal\n 6. sort by name\n 7. modify sal\n 8. delete by id\n 9.exit");
		System.out.println("choice : ");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			es.addnewEmployee();
			break;
		case 2:
			List<Employee> list=es.displayAll();
			//java 5 
			/*for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}*/
			//using iterator
			Iterator<Employee> it=list.iterator();
			while(it.hasNext()) {
				Employee e=it.next();
				System.out.println(e);
			}
			//java 7
			/*for(Employee ob:list)
			{
				System.out.println(ob);
			}*/
			//java 8
			list.forEach(ob->{System.out.println(ob);});
			break;
		case 3:
			System.out.println("enter employee id");
			int id=sc.nextInt();
			Employee e=es.searchById(id);
			if(e!=null)
				System.out.println(e);
			else {
				System.out.println("not found");
			}
			break;
		case 4:
			System.out.println("enter employee name");
			String nm=sc.next();
			List<Employee> namelist=es.searchByName(nm);
			if (namelist!=null) {
			   namelist.forEach(a->{System.out.println(a);});
			}
			else {
				System.out.println("not found");
			}
			break;
		case 5:
			List<Employee> elist=es.sortBySal();
			elist.forEach(a->{System.out.println(a);});
		break;	
		case 7:
			System.out.println("enter employee id");
			id=sc.nextInt();
			System.out.println("enter modified salary");
			double s=sc.nextDouble();
			boolean status=es.modifyById(id,s);
			if(status) {  //status==true
				System.out.println("modified successfully....");
			}	
			else {
				System.out.println("not found");
			}
			break;
		case 8:
			System.out.println("enter employee id");
			id=sc.nextInt();
			status=es.deleteById(id);
			if(status) {  //status==true
				System.out.println("deleted successfully....");
			}	
			else {
				System.out.println("not found");
			}
			break;
		case 9:
			sc.close();
			System.out.println("Thank you for visiting.....");
			break;
		default:
				
		}
		
		}while(choice != 9);

	}

}

