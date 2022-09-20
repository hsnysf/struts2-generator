package employee.bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import employee.dao.AddressDao;
import employee.entity.Address;

@Stateless
@LocalBean
public class AddressBean {

	AddressDao addressDao;
	
	EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
		addressDao = new AddressDao(entityManager);
	}
	
	public List<Address> searchAddresss(Address addressSearch) throws Exception {
		
		return addressDao.searchAddresss(addressSearch);
	}
	
	public Address getAddressCount(Address addressSearch) throws Exception {
		
		return addressDao.getAddressCount(addressSearch);
	}
	
	public Address getAddress(Address address) throws Exception {

		return addressDao.getAddress(address);
	}
	
	public Address saveAddress(Address address) throws Exception {
		
		return addressDao.saveAddress(address);
	}
	
	public Address updateAddressActive(Address address) throws Exception {
		
		return addressDao.updateAddressActive(address);
	}
}