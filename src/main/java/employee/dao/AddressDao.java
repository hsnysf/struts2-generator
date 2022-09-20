package employee.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import employee.entity.Address;
import employee.entity.Address_;


import employee.entity.City_;
import employee.entity.City;
import employee.entity.Employee;

public class AddressDao {

	EntityManager entityManager;
	
	public AddressDao(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	public static boolean isNotEmpty(Object object){
		
		return object != null && !object.toString().trim().isEmpty() && !"0".equals(object.toString().trim());
	}
	
	public List<Address> searchAddresss(Address addressSearch) throws Exception {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Address> criteria = builder.createQuery(Address.class);

		Root<Address> address = criteria.from(Address.class);
		
		Join<Address, City> city = address.join(Address_.city);

		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(addressSearch != null && isNotEmpty(addressSearch.getId())){
			predicates.add(builder.equal(address.get(Address_.id), addressSearch.getId()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getBuilding())){
			predicates.add(builder.equal(address.get(Address_.building), addressSearch.getBuilding()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getRoad())){
			predicates.add(builder.equal(address.get(Address_.road), addressSearch.getRoad()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getBlock())){
			predicates.add(builder.equal(address.get(Address_.block), addressSearch.getBlock()));
		}
		if(addressSearch != null && addressSearch.getCity() != null && isNotEmpty(addressSearch.getCity().getId())){
			predicates.add(builder.equal(city.get(City_.id), addressSearch.getCity().getId()));
		}
		if(addressSearch != null && addressSearch.getCity() != null && isNotEmpty(addressSearch.getCity().getName())){
			predicates.add(builder.equal(city.get(City_.name), addressSearch.getCity().getName()));
		}
		if(addressSearch != null && addressSearch.getCity() != null && isNotEmpty(addressSearch.getCity().getActive())){
			predicates.add(builder.equal(city.get(City_.active), addressSearch.getCity().getActive()));
		}
		if(addressSearch != null && addressSearch.getCity() != null && isNotEmpty(addressSearch.getCity().getCreationDate())){
			predicates.add(builder.equal(city.get(City_.creationDate), addressSearch.getCity().getCreationDate()));
		}
		if(addressSearch != null && addressSearch.getCity() != null && isNotEmpty(addressSearch.getCity().getCreationUser())){
			predicates.add(builder.equal(city.get(City_.creationUser), addressSearch.getCity().getCreationUser()));
		}
		if(addressSearch != null && addressSearch.getCity() != null && isNotEmpty(addressSearch.getCity().getUpdateDate())){
			predicates.add(builder.equal(city.get(City_.updateDate), addressSearch.getCity().getUpdateDate()));
		}
		if(addressSearch != null && addressSearch.getCity() != null && isNotEmpty(addressSearch.getCity().getUpdateUser())){
			predicates.add(builder.equal(city.get(City_.updateUser), addressSearch.getCity().getUpdateUser()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getActive())){
			predicates.add(builder.equal(address.get(Address_.active), addressSearch.getActive()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getCreationDate())){
			predicates.add(builder.equal(address.get(Address_.creationDate), addressSearch.getCreationDate()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getCreationUser())){
			predicates.add(builder.equal(address.get(Address_.creationUser), addressSearch.getCreationUser()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getUpdateDate())){
			predicates.add(builder.equal(address.get(Address_.updateDate), addressSearch.getUpdateDate()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getUpdateUser())){
			predicates.add(builder.equal(address.get(Address_.updateUser), addressSearch.getUpdateUser()));
		}
				
		criteria.select(address).where(predicates.toArray(new Predicate[]{}));
		
		criteria.orderBy(builder.asc(address.get(Address_.id)));

		TypedQuery<Address> query = entityManager.createQuery(criteria);

		query.setFirstResult(addressSearch.getOffset());
		query.setMaxResults(addressSearch.getRowCount());

		return query.getResultList();
	}

	public Address getAddressCount(Address addressSearch) throws Exception {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

		Root<Address> address = criteria.from(Address.class);
		
		Join<Address, City> city = address.join(Address_.city);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(addressSearch != null && isNotEmpty(addressSearch.getId())){
			predicates.add(builder.equal(address.get(Address_.id), addressSearch.getId()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getBuilding())){
			predicates.add(builder.equal(address.get(Address_.building), addressSearch.getBuilding()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getRoad())){
			predicates.add(builder.equal(address.get(Address_.road), addressSearch.getRoad()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getBlock())){
			predicates.add(builder.equal(address.get(Address_.block), addressSearch.getBlock()));
		}
		if(addressSearch != null && addressSearch.getCity() != null && isNotEmpty(addressSearch.getCity().getId())){
			predicates.add(builder.equal(city.get(City_.id), addressSearch.getCity().getId()));
		}
		if(addressSearch != null && addressSearch.getCity() != null && isNotEmpty(addressSearch.getCity().getName())){
			predicates.add(builder.equal(city.get(City_.name), addressSearch.getCity().getName()));
		}
		if(addressSearch != null && addressSearch.getCity() != null && isNotEmpty(addressSearch.getCity().getActive())){
			predicates.add(builder.equal(city.get(City_.active), addressSearch.getCity().getActive()));
		}
		if(addressSearch != null && addressSearch.getCity() != null && isNotEmpty(addressSearch.getCity().getCreationDate())){
			predicates.add(builder.equal(city.get(City_.creationDate), addressSearch.getCity().getCreationDate()));
		}
		if(addressSearch != null && addressSearch.getCity() != null && isNotEmpty(addressSearch.getCity().getCreationUser())){
			predicates.add(builder.equal(city.get(City_.creationUser), addressSearch.getCity().getCreationUser()));
		}
		if(addressSearch != null && addressSearch.getCity() != null && isNotEmpty(addressSearch.getCity().getUpdateDate())){
			predicates.add(builder.equal(city.get(City_.updateDate), addressSearch.getCity().getUpdateDate()));
		}
		if(addressSearch != null && addressSearch.getCity() != null && isNotEmpty(addressSearch.getCity().getUpdateUser())){
			predicates.add(builder.equal(city.get(City_.updateUser), addressSearch.getCity().getUpdateUser()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getActive())){
			predicates.add(builder.equal(address.get(Address_.active), addressSearch.getActive()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getCreationDate())){
			predicates.add(builder.equal(address.get(Address_.creationDate), addressSearch.getCreationDate()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getCreationUser())){
			predicates.add(builder.equal(address.get(Address_.creationUser), addressSearch.getCreationUser()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getUpdateDate())){
			predicates.add(builder.equal(address.get(Address_.updateDate), addressSearch.getUpdateDate()));
		}
		if(addressSearch != null && isNotEmpty(addressSearch.getUpdateUser())){
			predicates.add(builder.equal(address.get(Address_.updateUser), addressSearch.getUpdateUser()));
		}
		
		criteria = criteria.select(builder.count(address.get(Address_.id)))
							.where(predicates.toArray(new Predicate[]{}));

		TypedQuery<Long> query = entityManager.createQuery(criteria);

		addressSearch.setTotalRows(query.getSingleResult().intValue());

		return addressSearch;
	}
	
	public Address getAddress(Address address) throws Exception {

		return entityManager.find(Address.class, address.getId());
	}
	
	public Address saveAddress(Address address) throws Exception {
		
		if (address.getCity().getId() == null) {

			address.getCity().setActive(true);
			address.getCity().setCreationUser("Test");
			address.getCity().setCreationDate(new Timestamp(System.currentTimeMillis()));

		} else {

			address.getCity().setUpdateUser("Test");
			address.getCity().setUpdateDate(new Timestamp(System.currentTimeMillis()));
		}
		
		for(Employee employee : address.getEmployees()){
			
			employee.setAddress(address);
			
			if (employee.getId() == null) {

				employee.setActive(true);
				employee.setCreationUser("Test");
				employee.setCreationDate(new Timestamp(System.currentTimeMillis()));

			} else {

				employee.setUpdateUser("Test");
				employee.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			}
		}
		
		if (address.getId() == null) {

			address.setActive(true);
			address.setCreationUser("Test");
			address.setCreationDate(new Timestamp(System.currentTimeMillis()));
			
			entityManager.persist(address);

		} else {

			address.setUpdateUser("Test");
			address.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			
			entityManager.merge(address);
		}
		
		return address;
	}
	
	public Address updateAddressActive(Address address) throws Exception {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
        CriteriaUpdate<Address> criteria = builder.createCriteriaUpdate(Address.class);
        
        Root<Address> root = criteria.from(Address.class);
        
        criteria.set(root.get(Address_.updateDate), new Timestamp(System.currentTimeMillis()));
        criteria.set(root.get(Address_.updateUser), "Test");
        criteria.set(root.get(Address_.active), address.getActive());
        criteria.where(builder.equal(root.get(Address_.id), address.getId()));
        
        Query query = entityManager.createQuery(criteria);
        
        query.executeUpdate();
        
		return address;
	}
}