package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	private static List<Employee> elist;
	static {
		elist=new ArrayList<>();
		elist.add(new Employee(1,"Rajan","game designer",88888));
		elist.add(new Employee(2,"revati","ux designer",99999));
		elist.add(new Employee(3,"Rajan","Analyst",7777));
	}
	
	@Override
	public void save(Employee e) {
		//add data in the ArrayList
		elist.add(e);
		
	}

	 //returns the list of employees
	@Override
	public List<Employee> getAllEmployee() {
		return elist;
	}

	//it finds one object based on id
	@Override
	public Employee findById(int id) {
		int pos=elist.indexOf(new Employee(id));
		if(pos!= -1) {
			return elist.get(pos);
		}
		return null;
	}
	//find object by id and the set the salary if found otherwise return null
	@Override
	public boolean updateById(int id, double s) {
		Employee ob=findById(id);
		if(ob!= null) {
			ob.setSal(s);
			return true;
		}
		return false;
	}
	
	//find all object with given name and if found return the list
	@Override
	public List<Employee> findByName(String nm) {
		List<Employee> findlst=new ArrayList<>();
		for(Employee  ob:elist) {
			if(ob.getEname().equals(nm)) {
				findlst.add(ob);
			}
			
		}
		if(findlst.size()>0) {
			return findlst;
		}
		return null;
	}

	@Override
	public boolean removeById(int id) {
		return elist.remove(new Employee(id));
	}

	@Override
	public List<Employee> sortBySalary() {
		List<Employee> newlist=new ArrayList<>();
		for(Employee e:elist) {
			newlist.add(e);
		}
		newlist.sort(null);
		return newlist;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
