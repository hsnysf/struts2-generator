package employee.action;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import employee.bean.ChiefExecutiveOfficerBean;
import employee.entity.ChiefExecutiveOfficer;

@Action("chiefExecutiveOfficer")
@Results({
	@Result(name="toSuccessUpdateChiefExecutiveOfficerActive", type = "redirect", 
			location = "toSuccessUpdateChiefExecutiveOfficerActive", 
			params = {"chiefExecutiveOfficer.id", "%{chiefExecutiveOfficer.id}","chiefExecutiveOfficer.active", "%{chiefExecutiveOfficer.active}"}),
	@Result(name = "toSuccessSaveChiefExecutiveOfficer", type = "redirect", location = "toSuccessSaveChiefExecutiveOfficer", params = {"id", "%{id}", "chiefExecutiveOfficer.id", "%{chiefExecutiveOfficer.id}"})
})
public class ChiefExecutiveOfficerAction extends CommonAction{

	private static final long serialVersionUID = 1L;
	
	private ChiefExecutiveOfficer chiefExecutiveOfficerSearch = new ChiefExecutiveOfficer();
	private ChiefExecutiveOfficer chiefExecutiveOfficer = new ChiefExecutiveOfficer();
	private List<ChiefExecutiveOfficer> chiefExecutiveOfficers = new ArrayList<ChiefExecutiveOfficer>();
	
	@EJB
	private ChiefExecutiveOfficerBean chiefExecutiveOfficerBean;
	
	private Integer id;
	
	@Action("searchChiefExecutiveOfficers")
	public String searchChiefExecutiveOfficers() throws Exception {
		
		String result = toPage("/chiefExecutiveOfficers-list.jsp");
		
		chiefExecutiveOfficers = chiefExecutiveOfficerBean.searchChiefExecutiveOfficers(chiefExecutiveOfficerSearch);
		
		chiefExecutiveOfficerSearch = chiefExecutiveOfficerBean.getChiefExecutiveOfficerCount(chiefExecutiveOfficerSearch);
		
		return result;
	}
	
	@Action("updateChiefExecutiveOfficerActive")
	public String updateChiefExecutiveOfficerActive() throws Exception {
		
		chiefExecutiveOfficer = chiefExecutiveOfficerBean.updateChiefExecutiveOfficerActive(chiefExecutiveOfficer);
		
		return "toSuccessUpdateChiefExecutiveOfficerActive";
	}
	
	@Action("toSuccessUpdateChiefExecutiveOfficerActive")
	public String toSuccessUpdateChiefExecutiveOfficerActive() throws Exception {
		
		if(chiefExecutiveOfficer.getActive()) {
			addActionMessage("Chief Executive Officer " + chiefExecutiveOfficer.getId() + " has been activated successfully");
		}else {
			addActionMessage("Chief Executive Officer " + chiefExecutiveOfficer.getId() + " has been deactivated successfully");
		}
		
		return searchChiefExecutiveOfficers();
	}
	
	@Action("toAddChiefExecutiveOfficer")
	public String toAddChiefExecutiveOfficer() throws Exception {
		
		String result = toPage("/save-chiefExecutiveOfficer.jsp");
		
		chiefExecutiveOfficer = new ChiefExecutiveOfficer();
		
		return result;
	}
	
	@Action("toEditChiefExecutiveOfficer")
	public String toEditChiefExecutiveOfficer() throws Exception {
		
		String result = toPage("/save-chiefExecutiveOfficer.jsp");
		
		chiefExecutiveOfficer = chiefExecutiveOfficerBean.getChiefExecutiveOfficer(chiefExecutiveOfficer);
		
		return result;
	}
	
	@Action("saveChiefExecutiveOfficer")
	public String saveChiefExecutiveOfficer() throws Exception {
		
		id = chiefExecutiveOfficer.getId();
		
		chiefExecutiveOfficer = chiefExecutiveOfficerBean.saveChiefExecutiveOfficer(chiefExecutiveOfficer);
		
		return "toSuccessSaveChiefExecutiveOfficer";
	}
	
	@Action("toSuccessSaveChiefExecutiveOfficer")
	public String toSuccessSaveChiefExecutiveOfficer() throws Exception {
		
		if(id == null) {
			addActionMessage("Chief Executive Officer #" + chiefExecutiveOfficer.getId() + " has been added successfully");
		}else {
			addActionMessage("Chief Executive Officer #" + chiefExecutiveOfficer.getId() + " has been updated successfully");
		}
		
		return searchChiefExecutiveOfficers();
	}
	
	public ChiefExecutiveOfficer getChiefExecutiveOfficerSearch() {
		return chiefExecutiveOfficerSearch;
	}
	
	public void setChiefExecutiveOfficerSearch(ChiefExecutiveOfficer chiefExecutiveOfficerSearch) {
		this.chiefExecutiveOfficerSearch = chiefExecutiveOfficerSearch;
	}
	
	public ChiefExecutiveOfficer getChiefExecutiveOfficer() {
		return chiefExecutiveOfficer;
	}
	
	public void setChiefExecutiveOfficer(ChiefExecutiveOfficer chiefExecutiveOfficer) {
		this.chiefExecutiveOfficer = chiefExecutiveOfficer;
	}
	
	public List<ChiefExecutiveOfficer> getChiefExecutiveOfficers() {
		return chiefExecutiveOfficers;
	}
	
	public void setChiefExecutiveOfficers(List<ChiefExecutiveOfficer> chiefExecutiveOfficers) {
		this.chiefExecutiveOfficers = chiefExecutiveOfficers;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}