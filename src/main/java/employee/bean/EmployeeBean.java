package employee.bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import employee.dao.EmployeeDao;
import employee.entity.Employee;

@Stateless
@LocalBean
public class EmployeeBean {

	EmployeeDao employeeDao;
	
	EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
		employeeDao = new EmployeeDao(entityManager);
	}
	
	public List<Employee> searchEmployees(Employee employeeSearch) throws Exception {
		
		return employeeDao.searchEmployees(employeeSearch);
	}
	
	public Employee getEmployeeCount(Employee employeeSearch) throws Exception {
		
		return employeeDao.getEmployeeCount(employeeSearch);
	}
	
	public Employee getEmployee(Employee employee) throws Exception {

		return employeeDao.getEmployee(employee);
	}
	
	public Employee saveEmployee(Employee employee) throws Exception {
		
		return employeeDao.saveEmployee(employee);
	}
	
	public Employee updateEmployeeActive(Employee employee) throws Exception {
		
		return employeeDao.updateEmployeeActive(employee);
	}
}