package employee.action;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import employee.bean.AddressBean;
import employee.entity.Address;

@Action("address")
@Results({
	@Result(name="toSuccessUpdateAddressActive", type = "redirect", 
			location = "toSuccessUpdateAddressActive", 
			params = {"address.id", "%{address.id}","address.active", "%{address.active}"}),
	@Result(name = "toSuccessSaveAddress", type = "redirect", location = "toSuccessSaveAddress", params = {"id", "%{id}", "address.id", "%{address.id}"})
})
public class AddressAction extends CommonAction{

	private static final long serialVersionUID = 1L;
	
	private Address addressSearch = new Address();
	private Address address = new Address();
	private List<Address> addresss = new ArrayList<Address>();
	
	@EJB
	private AddressBean addressBean;
	
	private Integer id;
	
	@Action("searchAddresss")
	public String searchAddresss() throws Exception {
		
		String result = toPage("/addresss-list.jsp");
		
		addresss = addressBean.searchAddresss(addressSearch);
		
		addressSearch = addressBean.getAddressCount(addressSearch);
		
		return result;
	}
	
	@Action("updateAddressActive")
	public String updateAddressActive() throws Exception {
		
		address = addressBean.updateAddressActive(address);
		
		return "toSuccessUpdateAddressActive";
	}
	
	@Action("toSuccessUpdateAddressActive")
	public String toSuccessUpdateAddressActive() throws Exception {
		
		if(address.getActive()) {
			addActionMessage("Address " + address.getId() + " has been activated successfully");
		}else {
			addActionMessage("Address " + address.getId() + " has been deactivated successfully");
		}
		
		return searchAddresss();
	}
	
	@Action("toAddAddress")
	public String toAddAddress() throws Exception {
		
		String result = toPage("/save-address.jsp");
		
		address = new Address();
		
		return result;
	}
	
	@Action("toEditAddress")
	public String toEditAddress() throws Exception {
		
		String result = toPage("/save-address.jsp");
		
		address = addressBean.getAddress(address);
		
		return result;
	}
	
	@Action("saveAddress")
	public String saveAddress() throws Exception {
		
		id = address.getId();
		
		address = addressBean.saveAddress(address);
		
		return "toSuccessSaveAddress";
	}
	
	@Action("toSuccessSaveAddress")
	public String toSuccessSaveAddress() throws Exception {
		
		if(id == null) {
			addActionMessage("Address #" + address.getId() + " has been added successfully");
		}else {
			addActionMessage("Address #" + address.getId() + " has been updated successfully");
		}
		
		return searchAddresss();
	}
	
	public Address getAddressSearch() {
		return addressSearch;
	}
	
	public void setAddressSearch(Address addressSearch) {
		this.addressSearch = addressSearch;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Address> getAddresss() {
		return addresss;
	}
	
	public void setAddresss(List<Address> addresss) {
		this.addresss = addresss;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}