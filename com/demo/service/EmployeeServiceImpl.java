package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao edao;
	

	public EmployeeServiceImpl() {
		super();
		this.edao = new EmployeeDaoImpl();
	}

//accept details and send the data for adding in the list
	@Override
	public void addnewEmployee() {
		Scanner sc=new Scanner(System.in);
		//accept data for employee
		System.out.println("enter empid");
		int empid=sc.nextInt();
		System.out.println("enter ename");
		String nm=sc.next();
		System.out.println("enter designation");
		String desg=sc.next();
		System.out.println("enter Salary");
		double s=sc.nextDouble();
		//create employee object
		Employee e=new Employee(empid,nm,desg,s);
		//add data in the elist using dao layer
		edao.save(e);
		
	}

//get all the employee objects from the the list
	@Override
	public List<Employee> displayAll() {
		return edao.getAllEmployee();
	}

	@Override
	public Employee searchById(int id) {
		return edao.findById(id);
	}

	@Override
	public List<Employee> searchByName(String nm) {
		return edao.findByName(nm);
		
	}

	@Override
	public boolean modifyById(int id, double s) {
		return edao.updateById(id,s);
	}

	@Override
	public boolean deleteById(int id) {
		//first find the object and check with user whether to delete
		Employee ob=searchById(id);
		Scanner sc=new Scanner(System.in);
		if(ob!=null) {
			System.out.println(ob.getEmpid()+","+ob.getEname());
			String ans=sc.next();
			//if user says y then delete the object
			if(ans.equals("y"))
					return edao.removeById(id);
		}
		return false;
		
	}

	@Override
	public List<Employee> sortBySal() {
		return edao.sortBySalary();
	}

}
