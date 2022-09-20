package employee.action;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import employee.bean.CityBean;
import employee.entity.City;

@Action("city")
@Results({
	@Result(name="toSuccessUpdateCityActive", type = "redirect", 
			location = "toSuccessUpdateCityActive", 
			params = {"city.id", "%{city.id}","city.active", "%{city.active}"}),
	@Result(name = "toSuccessSaveCity", type = "redirect", location = "toSuccessSaveCity", params = {"id", "%{id}", "city.id", "%{city.id}"})
})
public class CityAction extends CommonAction{

	private static final long serialVersionUID = 1L;
	
	private City citySearch = new City();
	private City city = new City();
	private List<City> citys = new ArrayList<City>();
	
	@EJB
	private CityBean cityBean;
	
	private Integer id;
	
	@Action("searchCitys")
	public String searchCitys() throws Exception {
		
		String result = toPage("/citys-list.jsp");
		
		citys = cityBean.searchCitys(citySearch);
		
		citySearch = cityBean.getCityCount(citySearch);
		
		return result;
	}
	
	@Action("updateCityActive")
	public String updateCityActive() throws Exception {
		
		city = cityBean.updateCityActive(city);
		
		return "toSuccessUpdateCityActive";
	}
	
	@Action("toSuccessUpdateCityActive")
	public String toSuccessUpdateCityActive() throws Exception {
		
		if(city.getActive()) {
			addActionMessage("City " + city.getId() + " has been activated successfully");
		}else {
			addActionMessage("City " + city.getId() + " has been deactivated successfully");
		}
		
		return searchCitys();
	}
	
	@Action("toAddCity")
	public String toAddCity() throws Exception {
		
		String result = toPage("/save-city.jsp");
		
		city = new City();
		
		return result;
	}
	
	@Action("toEditCity")
	public String toEditCity() throws Exception {
		
		String result = toPage("/save-city.jsp");
		
		city = cityBean.getCity(city);
		
		return result;
	}
	
	@Action("saveCity")
	public String saveCity() throws Exception {
		
		id = city.getId();
		
		city = cityBean.saveCity(city);
		
		return "toSuccessSaveCity";
	}
	
	@Action("toSuccessSaveCity")
	public String toSuccessSaveCity() throws Exception {
		
		if(id == null) {
			addActionMessage("City #" + city.getId() + " has been added successfully");
		}else {
			addActionMessage("City #" + city.getId() + " has been updated successfully");
		}
		
		return searchCitys();
	}
	
	public City getCitySearch() {
		return citySearch;
	}
	
	public void setCitySearch(City citySearch) {
		this.citySearch = citySearch;
	}
	
	public City getCity() {
		return city;
	}
	
	public void setCity(City city) {
		this.city = city;
	}
	
	public List<City> getCitys() {
		return citys;
	}
	
	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}