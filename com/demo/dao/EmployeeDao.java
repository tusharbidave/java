package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeDao {

	void save(Employee e);

	List<Employee> getAllEmployee();

	Employee findById(int id);

	List<Employee> findByName(String nm);

	boolean updateById(int id, double s);

	boolean removeById(int id);

	List<Employee> sortBySalary();

}

