package employee.action;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import employee.bean.EmployeeBean;
import employee.entity.Employee;

@Action("employee")
@Results({
	@Result(name="toSuccessUpdateEmployeeActive", type = "redirect", 
			location = "toSuccessUpdateEmployeeActive", 
			params = {"employee.id", "%{employee.id}","employee.active", "%{employee.active}"}),
	@Result(name = "toSuccessSaveEmployee", type = "redirect", location = "toSuccessSaveEmployee", params = {"id", "%{id}", "employee.id", "%{employee.id}"})
})
public class EmployeeAction extends CommonAction{

	private static final long serialVersionUID = 1L;
	
	private Employee employeeSearch = new Employee();
	private Employee employee = new Employee();
	private List<Employee> employees = new ArrayList<Employee>();
	
	@EJB
	private EmployeeBean employeeBean;
	
	private Integer id;
	
	@Action("searchEmployees")
	public String searchEmployees() throws Exception {
		
		String result = toPage("/employees-list.jsp");
		
		employees = employeeBean.searchEmployees(employeeSearch);
		
		employeeSearch = employeeBean.getEmployeeCount(employeeSearch);
		
		return result;
	}
	
	@Action("updateEmployeeActive")
	public String updateEmployeeActive() throws Exception {
		
		employee = employeeBean.updateEmployeeActive(employee);
		
		return "toSuccessUpdateEmployeeActive";
	}
	
	@Action("toSuccessUpdateEmployeeActive")
	public String toSuccessUpdateEmployeeActive() throws Exception {
		
		if(employee.getActive()) {
			addActionMessage("Employee " + employee.getId() + " has been activated successfully");
		}else {
			addActionMessage("Employee " + employee.getId() + " has been deactivated successfully");
		}
		
		return searchEmployees();
	}
	
	@Action("toAddEmployee")
	public String toAddEmployee() throws Exception {
		
		String result = toPage("/save-employee.jsp");
		
		employee = new Employee();
		
		return result;
	}
	
	@Action("toEditEmployee")
	public String toEditEmployee() throws Exception {
		
		String result = toPage("/save-employee.jsp");
		
		employee = employeeBean.getEmployee(employee);
		
		return result;
	}
	
	@Action("saveEmployee")
	public String saveEmployee() throws Exception {
		
		id = employee.getId();
		
		employee = employeeBean.saveEmployee(employee);
		
		return "toSuccessSaveEmployee";
	}
	
	@Action("toSuccessSaveEmployee")
	public String toSuccessSaveEmployee() throws Exception {
		
		if(id == null) {
			addActionMessage("Employee #" + employee.getId() + " has been added successfully");
		}else {
			addActionMessage("Employee #" + employee.getId() + " has been updated successfully");
		}
		
		return searchEmployees();
	}
	
	public Employee getEmployeeSearch() {
		return employeeSearch;
	}
	
	public void setEmployeeSearch(Employee employeeSearch) {
		this.employeeSearch = employeeSearch;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}