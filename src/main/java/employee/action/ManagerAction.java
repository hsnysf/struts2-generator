package employee.action;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import employee.bean.ManagerBean;
import employee.entity.Manager;

@Action("manager")
@Results({
	@Result(name="toSuccessUpdateManagerActive", type = "redirect", 
			location = "toSuccessUpdateManagerActive", 
			params = {"manager.id", "%{manager.id}","manager.active", "%{manager.active}"}),
	@Result(name = "toSuccessSaveManager", type = "redirect", location = "toSuccessSaveManager", params = {"id", "%{id}", "manager.id", "%{manager.id}"})
})
public class ManagerAction extends CommonAction{

	private static final long serialVersionUID = 1L;
	
	private Manager managerSearch = new Manager();
	private Manager manager = new Manager();
	private List<Manager> managers = new ArrayList<Manager>();
	
	@EJB
	private ManagerBean managerBean;
	
	private Integer id;
	
	@Action("searchManagers")
	public String searchManagers() throws Exception {
		
		String result = toPage("/managers-list.jsp");
		
		managers = managerBean.searchManagers(managerSearch);
		
		managerSearch = managerBean.getManagerCount(managerSearch);
		
		return result;
	}
	
	@Action("updateManagerActive")
	public String updateManagerActive() throws Exception {
		
		manager = managerBean.updateManagerActive(manager);
		
		return "toSuccessUpdateManagerActive";
	}
	
	@Action("toSuccessUpdateManagerActive")
	public String toSuccessUpdateManagerActive() throws Exception {
		
		if(manager.getActive()) {
			addActionMessage("Manager " + manager.getId() + " has been activated successfully");
		}else {
			addActionMessage("Manager " + manager.getId() + " has been deactivated successfully");
		}
		
		return searchManagers();
	}
	
	@Action("toAddManager")
	public String toAddManager() throws Exception {
		
		String result = toPage("/save-manager.jsp");
		
		manager = new Manager();
		
		return result;
	}
	
	@Action("toEditManager")
	public String toEditManager() throws Exception {
		
		String result = toPage("/save-manager.jsp");
		
		manager = managerBean.getManager(manager);
		
		return result;
	}
	
	@Action("saveManager")
	public String saveManager() throws Exception {
		
		id = manager.getId();
		
		manager = managerBean.saveManager(manager);
		
		return "toSuccessSaveManager";
	}
	
	@Action("toSuccessSaveManager")
	public String toSuccessSaveManager() throws Exception {
		
		if(id == null) {
			addActionMessage("Manager #" + manager.getId() + " has been added successfully");
		}else {
			addActionMessage("Manager #" + manager.getId() + " has been updated successfully");
		}
		
		return searchManagers();
	}
	
	public Manager getManagerSearch() {
		return managerSearch;
	}
	
	public void setManagerSearch(Manager managerSearch) {
		this.managerSearch = managerSearch;
	}
	
	public Manager getManager() {
		return manager;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public List<Manager> getManagers() {
		return managers;
	}
	
	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}