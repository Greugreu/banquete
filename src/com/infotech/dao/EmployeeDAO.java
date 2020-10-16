 
package com.infotech.dao;

import java.util.List;

import com.infotech.model.Employee;

public interface EmployeeDAO {

	public abstract void createEmployee(Employee employee);
	public abstract Employee getEmployeeById(Integer employeeId);
	public abstract void updateEmployeeEmailById(String newEmail,Integer employeeId);
	public abstract void deleteEmployeeById(Integer employeeId);
	public abstract List<Employee> getAllEmployeesInfo();
}
