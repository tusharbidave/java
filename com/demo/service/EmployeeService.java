package com.demo.service;


import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeService {

	void addnewEmployee();

	List<Employee> displayAll();

	Employee searchById(int id);

	List<Employee> searchByName(String nm);

	boolean modifyById(int id, double s);

	boolean deleteById(int id);

	List<Employee> sortBySal();

}