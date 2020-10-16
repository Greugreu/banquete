package com.infotech.client;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.infotech.dao.EmployeeDAO;
import com.infotech.dao.impl.EmployeeDAOImpl;
import com.infotech.model.Employee;

public class ClientTest {
 
    public static void main(String[] args) {                //createEmployee
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee = getEmployee();
        employeeDAO.createEmployee(employee);
    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setBonus(new BigDecimal(780));
        employee.setDoj(new Date());
        employee.setEmployeeName("Martin");
        employee.setEmail("Martin@yahoo.com");
        employee.setSalary(6000000.00);
        return employee;
    }
//////////////////////////////////////////////////////////////////////////////// 
    /*
        public static void main(String[] args) {  //getAllEmployeesInfo
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        getAllEmployeesInfo(employeeDAO);
    }
    private static void getAllEmployeesInfo(EmployeeDAO employeeDAO) {
        List<Employee> empList = employeeDAO.getAllEmployeesInfo();
        empList.forEach(System.out::println);
    }   
*/
////////////////////////////////////////////////////////////////////////////////    
    
    /*  	public static void main(String[] args) {  //get Employee ById
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
 		getEmployeeById(employeeDAO);
	} 
    private static void getEmployeeById(EmployeeDAO employeeDAO) {
        Employee employee2 = employeeDAO.getEmployeeById(5);
        if (employee2 != null) {
            System.out.println(employee2);
        } else {
            System.out.println("Employee n'existe pas ..");
        }
    }   
     */
////////////////////////////////////////////////////////////////////////////////    
    
 /* 	public static void main(String[] args) {  //updateEmployeeEmailById
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.updateEmployeeEmailById("sam7@gmail.com", 5);

	} */
    
    
 /*  public static void main(String[] args) {               //deleteEmployeeById
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.deleteEmployeeById(14);
 
    }  */
    
}
