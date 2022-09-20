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

import employee.entity.ChiefExecutiveOfficer;
import employee.entity.ChiefExecutiveOfficer_;


import employee.entity.Manager_;
import employee.entity.Manager;
import employee.entity.Employee_;
import employee.entity.Employee;
import employee.entity.Address_;
import employee.entity.Address;
import employee.entity.City_;
import employee.entity.City;

public class ChiefExecutiveOfficerDao {

	EntityManager entityManager;
	
	public ChiefExecutiveOfficerDao(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	public static boolean isNotEmpty(Object object){
		
		return object != null && !object.toString().trim().isEmpty() && !"0".equals(object.toString().trim());
	}
	
	public List<ChiefExecutiveOfficer> searchChiefExecutiveOfficers(ChiefExecutiveOfficer chiefExecutiveOfficerSearch) throws Exception {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<ChiefExecutiveOfficer> criteria = builder.createQuery(ChiefExecutiveOfficer.class);

		Root<ChiefExecutiveOfficer> chiefExecutiveOfficer = criteria.from(ChiefExecutiveOfficer.class);
		
		Join<ChiefExecutiveOfficer, Manager> manager = chiefExecutiveOfficer.join(ChiefExecutiveOfficer_.id);
		Join<Manager, Employee> employee = manager.join(Manager_.id);
		Join<Employee, Address> address = employee.join(Employee_.address);
		Join<Address, City> city = address.join(Address_.city);

		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getId())){
			predicates.add(builder.equal(employee.get(Employee_.id), chiefExecutiveOfficerSearch.getId()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getCpr())){
			predicates.add(builder.equal(employee.get(Employee_.cpr), chiefExecutiveOfficerSearch.getCpr()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getName())){
			predicates.add(builder.equal(employee.get(Employee_.name), chiefExecutiveOfficerSearch.getName()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getAge())){
			predicates.add(builder.equal(employee.get(Employee_.age), chiefExecutiveOfficerSearch.getAge()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getEmail())){
			predicates.add(builder.equal(employee.get(Employee_.email), chiefExecutiveOfficerSearch.getEmail()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getGender())){
			predicates.add(builder.equal(employee.get(Employee_.gender), chiefExecutiveOfficerSearch.getGender()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getMobile())){
			predicates.add(builder.equal(employee.get(Employee_.mobile), chiefExecutiveOfficerSearch.getMobile()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getSalary())){
			predicates.add(builder.equal(employee.get(Employee_.salary), chiefExecutiveOfficerSearch.getSalary()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getId())){
			predicates.add(builder.equal(address.get(Address_.id), chiefExecutiveOfficerSearch.getAddress().getId()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getBuilding())){
			predicates.add(builder.equal(address.get(Address_.building), chiefExecutiveOfficerSearch.getAddress().getBuilding()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getRoad())){
			predicates.add(builder.equal(address.get(Address_.road), chiefExecutiveOfficerSearch.getAddress().getRoad()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getBlock())){
			predicates.add(builder.equal(address.get(Address_.block), chiefExecutiveOfficerSearch.getAddress().getBlock()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && chiefExecutiveOfficerSearch.getAddress().getCity() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCity().getId())){
			predicates.add(builder.equal(city.get(City_.id), chiefExecutiveOfficerSearch.getAddress().getCity().getId()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && chiefExecutiveOfficerSearch.getAddress().getCity() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCity().getName())){
			predicates.add(builder.equal(city.get(City_.name), chiefExecutiveOfficerSearch.getAddress().getCity().getName()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && chiefExecutiveOfficerSearch.getAddress().getCity() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCity().getActive())){
			predicates.add(builder.equal(city.get(City_.active), chiefExecutiveOfficerSearch.getAddress().getCity().getActive()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && chiefExecutiveOfficerSearch.getAddress().getCity() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCity().getCreationDate())){
			predicates.add(builder.equal(city.get(City_.creationDate), chiefExecutiveOfficerSearch.getAddress().getCity().getCreationDate()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && chiefExecutiveOfficerSearch.getAddress().getCity() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCity().getCreationUser())){
			predicates.add(builder.equal(city.get(City_.creationUser), chiefExecutiveOfficerSearch.getAddress().getCity().getCreationUser()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && chiefExecutiveOfficerSearch.getAddress().getCity() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCity().getUpdateDate())){
			predicates.add(builder.equal(city.get(City_.updateDate), chiefExecutiveOfficerSearch.getAddress().getCity().getUpdateDate()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && chiefExecutiveOfficerSearch.getAddress().getCity() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCity().getUpdateUser())){
			predicates.add(builder.equal(city.get(City_.updateUser), chiefExecutiveOfficerSearch.getAddress().getCity().getUpdateUser()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getActive())){
			predicates.add(builder.equal(address.get(Address_.active), chiefExecutiveOfficerSearch.getAddress().getActive()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCreationDate())){
			predicates.add(builder.equal(address.get(Address_.creationDate), chiefExecutiveOfficerSearch.getAddress().getCreationDate()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCreationUser())){
			predicates.add(builder.equal(address.get(Address_.creationUser), chiefExecutiveOfficerSearch.getAddress().getCreationUser()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getUpdateDate())){
			predicates.add(builder.equal(address.get(Address_.updateDate), chiefExecutiveOfficerSearch.getAddress().getUpdateDate()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getUpdateUser())){
			predicates.add(builder.equal(address.get(Address_.updateUser), chiefExecutiveOfficerSearch.getAddress().getUpdateUser()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getActive())){
			predicates.add(builder.equal(employee.get(Employee_.active), chiefExecutiveOfficerSearch.getActive()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getCreationDate())){
			predicates.add(builder.equal(employee.get(Employee_.creationDate), chiefExecutiveOfficerSearch.getCreationDate()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getCreationUser())){
			predicates.add(builder.equal(employee.get(Employee_.creationUser), chiefExecutiveOfficerSearch.getCreationUser()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getUpdateDate())){
			predicates.add(builder.equal(employee.get(Employee_.updateDate), chiefExecutiveOfficerSearch.getUpdateDate()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getUpdateUser())){
			predicates.add(builder.equal(employee.get(Employee_.updateUser), chiefExecutiveOfficerSearch.getUpdateUser()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getDegree())){
			predicates.add(builder.equal(manager.get(Manager_.degree), chiefExecutiveOfficerSearch.getDegree()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getAllowance())){
			predicates.add(builder.equal(manager.get(Manager_.allowance), chiefExecutiveOfficerSearch.getAllowance()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getCreationDate())){
			predicates.add(builder.equal(manager.get(Manager_.creationDate), chiefExecutiveOfficerSearch.getCreationDate()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getCreationUser())){
			predicates.add(builder.equal(manager.get(Manager_.creationUser), chiefExecutiveOfficerSearch.getCreationUser()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getUpdateDate())){
			predicates.add(builder.equal(manager.get(Manager_.updateDate), chiefExecutiveOfficerSearch.getUpdateDate()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getUpdateUser())){
			predicates.add(builder.equal(manager.get(Manager_.updateUser), chiefExecutiveOfficerSearch.getUpdateUser()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getSector())){
			predicates.add(builder.equal(chiefExecutiveOfficer.get(ChiefExecutiveOfficer_.sector), chiefExecutiveOfficerSearch.getSector()));
		}
				
		criteria.select(chiefExecutiveOfficer).where(predicates.toArray(new Predicate[]{}));
		
		criteria.orderBy(builder.asc(chiefExecutiveOfficer.get(ChiefExecutiveOfficer_.id)));

		TypedQuery<ChiefExecutiveOfficer> query = entityManager.createQuery(criteria);

		query.setFirstResult(chiefExecutiveOfficerSearch.getOffset());
		query.setMaxResults(chiefExecutiveOfficerSearch.getRowCount());

		return query.getResultList();
	}

	public ChiefExecutiveOfficer getChiefExecutiveOfficerCount(ChiefExecutiveOfficer chiefExecutiveOfficerSearch) throws Exception {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

		Root<ChiefExecutiveOfficer> chiefExecutiveOfficer = criteria.from(ChiefExecutiveOfficer.class);
		
		Join<ChiefExecutiveOfficer, Manager> manager = chiefExecutiveOfficer.join(ChiefExecutiveOfficer_.id);
		Join<Manager, Employee> employee = manager.join(Manager_.id);
		Join<Employee, Address> address = employee.join(Employee_.address);
		Join<Address, City> city = address.join(Address_.city);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getId())){
			predicates.add(builder.equal(employee.get(Employee_.id), chiefExecutiveOfficerSearch.getId()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getCpr())){
			predicates.add(builder.equal(employee.get(Employee_.cpr), chiefExecutiveOfficerSearch.getCpr()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getName())){
			predicates.add(builder.equal(employee.get(Employee_.name), chiefExecutiveOfficerSearch.getName()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getAge())){
			predicates.add(builder.equal(employee.get(Employee_.age), chiefExecutiveOfficerSearch.getAge()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getEmail())){
			predicates.add(builder.equal(employee.get(Employee_.email), chiefExecutiveOfficerSearch.getEmail()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getGender())){
			predicates.add(builder.equal(employee.get(Employee_.gender), chiefExecutiveOfficerSearch.getGender()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getMobile())){
			predicates.add(builder.equal(employee.get(Employee_.mobile), chiefExecutiveOfficerSearch.getMobile()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getSalary())){
			predicates.add(builder.equal(employee.get(Employee_.salary), chiefExecutiveOfficerSearch.getSalary()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getId())){
			predicates.add(builder.equal(address.get(Address_.id), chiefExecutiveOfficerSearch.getAddress().getId()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getBuilding())){
			predicates.add(builder.equal(address.get(Address_.building), chiefExecutiveOfficerSearch.getAddress().getBuilding()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getRoad())){
			predicates.add(builder.equal(address.get(Address_.road), chiefExecutiveOfficerSearch.getAddress().getRoad()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getBlock())){
			predicates.add(builder.equal(address.get(Address_.block), chiefExecutiveOfficerSearch.getAddress().getBlock()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && chiefExecutiveOfficerSearch.getAddress().getCity() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCity().getId())){
			predicates.add(builder.equal(city.get(City_.id), chiefExecutiveOfficerSearch.getAddress().getCity().getId()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && chiefExecutiveOfficerSearch.getAddress().getCity() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCity().getName())){
			predicates.add(builder.equal(city.get(City_.name), chiefExecutiveOfficerSearch.getAddress().getCity().getName()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && chiefExecutiveOfficerSearch.getAddress().getCity() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCity().getActive())){
			predicates.add(builder.equal(city.get(City_.active), chiefExecutiveOfficerSearch.getAddress().getCity().getActive()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && chiefExecutiveOfficerSearch.getAddress().getCity() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCity().getCreationDate())){
			predicates.add(builder.equal(city.get(City_.creationDate), chiefExecutiveOfficerSearch.getAddress().getCity().getCreationDate()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && chiefExecutiveOfficerSearch.getAddress().getCity() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCity().getCreationUser())){
			predicates.add(builder.equal(city.get(City_.creationUser), chiefExecutiveOfficerSearch.getAddress().getCity().getCreationUser()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && chiefExecutiveOfficerSearch.getAddress().getCity() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCity().getUpdateDate())){
			predicates.add(builder.equal(city.get(City_.updateDate), chiefExecutiveOfficerSearch.getAddress().getCity().getUpdateDate()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && chiefExecutiveOfficerSearch.getAddress().getCity() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCity().getUpdateUser())){
			predicates.add(builder.equal(city.get(City_.updateUser), chiefExecutiveOfficerSearch.getAddress().getCity().getUpdateUser()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getActive())){
			predicates.add(builder.equal(address.get(Address_.active), chiefExecutiveOfficerSearch.getAddress().getActive()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCreationDate())){
			predicates.add(builder.equal(address.get(Address_.creationDate), chiefExecutiveOfficerSearch.getAddress().getCreationDate()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getCreationUser())){
			predicates.add(builder.equal(address.get(Address_.creationUser), chiefExecutiveOfficerSearch.getAddress().getCreationUser()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getUpdateDate())){
			predicates.add(builder.equal(address.get(Address_.updateDate), chiefExecutiveOfficerSearch.getAddress().getUpdateDate()));
		}
		if(chiefExecutiveOfficerSearch != null && chiefExecutiveOfficerSearch.getAddress() != null && isNotEmpty(chiefExecutiveOfficerSearch.getAddress().getUpdateUser())){
			predicates.add(builder.equal(address.get(Address_.updateUser), chiefExecutiveOfficerSearch.getAddress().getUpdateUser()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getActive())){
			predicates.add(builder.equal(employee.get(Employee_.active), chiefExecutiveOfficerSearch.getActive()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getCreationDate())){
			predicates.add(builder.equal(employee.get(Employee_.creationDate), chiefExecutiveOfficerSearch.getCreationDate()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getCreationUser())){
			predicates.add(builder.equal(employee.get(Employee_.creationUser), chiefExecutiveOfficerSearch.getCreationUser()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getUpdateDate())){
			predicates.add(builder.equal(employee.get(Employee_.updateDate), chiefExecutiveOfficerSearch.getUpdateDate()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getUpdateUser())){
			predicates.add(builder.equal(employee.get(Employee_.updateUser), chiefExecutiveOfficerSearch.getUpdateUser()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getDegree())){
			predicates.add(builder.equal(manager.get(Manager_.degree), chiefExecutiveOfficerSearch.getDegree()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getAllowance())){
			predicates.add(builder.equal(manager.get(Manager_.allowance), chiefExecutiveOfficerSearch.getAllowance()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getCreationDate())){
			predicates.add(builder.equal(manager.get(Manager_.creationDate), chiefExecutiveOfficerSearch.getCreationDate()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getCreationUser())){
			predicates.add(builder.equal(manager.get(Manager_.creationUser), chiefExecutiveOfficerSearch.getCreationUser()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getUpdateDate())){
			predicates.add(builder.equal(manager.get(Manager_.updateDate), chiefExecutiveOfficerSearch.getUpdateDate()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getUpdateUser())){
			predicates.add(builder.equal(manager.get(Manager_.updateUser), chiefExecutiveOfficerSearch.getUpdateUser()));
		}
		if(chiefExecutiveOfficerSearch != null && isNotEmpty(chiefExecutiveOfficerSearch.getSector())){
			predicates.add(builder.equal(chiefExecutiveOfficer.get(ChiefExecutiveOfficer_.sector), chiefExecutiveOfficerSearch.getSector()));
		}
		
		criteria = criteria.select(builder.count(chiefExecutiveOfficer.get(ChiefExecutiveOfficer_.id)))
							.where(predicates.toArray(new Predicate[]{}));

		TypedQuery<Long> query = entityManager.createQuery(criteria);

		chiefExecutiveOfficerSearch.setTotalRows(query.getSingleResult().intValue());

		return chiefExecutiveOfficerSearch;
	}
	
	public ChiefExecutiveOfficer getChiefExecutiveOfficer(ChiefExecutiveOfficer chiefExecutiveOfficer) throws Exception {

		return entityManager.find(ChiefExecutiveOfficer.class, chiefExecutiveOfficer.getId());
	}
	
	public ChiefExecutiveOfficer saveChiefExecutiveOfficer(ChiefExecutiveOfficer chiefExecutiveOfficer) throws Exception {
		
		
		
		if (chiefExecutiveOfficer.getId() == null) {

			chiefExecutiveOfficer.setActive(true);
			chiefExecutiveOfficer.setCreationUser("Test");
			chiefExecutiveOfficer.setCreationDate(new Timestamp(System.currentTimeMillis()));
			
			entityManager.persist(chiefExecutiveOfficer);

		} else {

			chiefExecutiveOfficer.setUpdateUser("Test");
			chiefExecutiveOfficer.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			
			entityManager.merge(chiefExecutiveOfficer);
		}
		
		return chiefExecutiveOfficer;
	}
	
	public ChiefExecutiveOfficer updateChiefExecutiveOfficerActive(ChiefExecutiveOfficer chiefExecutiveOfficer) throws Exception {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
        CriteriaUpdate<ChiefExecutiveOfficer> criteria = builder.createCriteriaUpdate(ChiefExecutiveOfficer.class);
        
        Root<ChiefExecutiveOfficer> root = criteria.from(ChiefExecutiveOfficer.class);
        
        criteria.set(root.get(ChiefExecutiveOfficer_.updateDate), new Timestamp(System.currentTimeMillis()));
        criteria.set(root.get(ChiefExecutiveOfficer_.updateUser), "Test");
        criteria.set(root.get(ChiefExecutiveOfficer_.active), chiefExecutiveOfficer.getActive());
        criteria.where(builder.equal(root.get(ChiefExecutiveOfficer_.id), chiefExecutiveOfficer.getId()));
        
        Query query = entityManager.createQuery(criteria);
        
        query.executeUpdate();
        
		return chiefExecutiveOfficer;
	}
}