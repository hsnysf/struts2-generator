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

import employee.entity.Employee;
import employee.entity.Employee_;


import employee.entity.Address_;
import employee.entity.Address;
import employee.entity.City_;
import employee.entity.City;
import employee.entity.Certificate;

public class EmployeeDao {

	EntityManager entityManager;
	
	public EmployeeDao(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	public static boolean isNotEmpty(Object object){
		
		return object != null && !object.toString().trim().isEmpty() && !"0".equals(object.toString().trim());
	}
	
	public List<Employee> searchEmployees(Employee employeeSearch) throws Exception {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);

		Root<Employee> employee = criteria.from(Employee.class);
		
		Join<Employee, Address> address = employee.join(Employee_.address);
		Join<Address, City> city = address.join(Address_.city);

		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(employeeSearch != null && isNotEmpty(employeeSearch.getId())){
			predicates.add(builder.equal(employee.get(Employee_.id), employeeSearch.getId()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getCpr())){
			predicates.add(builder.equal(employee.get(Employee_.cpr), employeeSearch.getCpr()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getName())){
			predicates.add(builder.equal(employee.get(Employee_.name), employeeSearch.getName()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getAge())){
			predicates.add(builder.equal(employee.get(Employee_.age), employeeSearch.getAge()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getEmail())){
			predicates.add(builder.equal(employee.get(Employee_.email), employeeSearch.getEmail()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getGender())){
			predicates.add(builder.equal(employee.get(Employee_.gender), employeeSearch.getGender()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getMobile())){
			predicates.add(builder.equal(employee.get(Employee_.mobile), employeeSearch.getMobile()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getSalary())){
			predicates.add(builder.equal(employee.get(Employee_.salary), employeeSearch.getSalary()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getId())){
			predicates.add(builder.equal(address.get(Address_.id), employeeSearch.getAddress().getId()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getBuilding())){
			predicates.add(builder.equal(address.get(Address_.building), employeeSearch.getAddress().getBuilding()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getRoad())){
			predicates.add(builder.equal(address.get(Address_.road), employeeSearch.getAddress().getRoad()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getBlock())){
			predicates.add(builder.equal(address.get(Address_.block), employeeSearch.getAddress().getBlock()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && employeeSearch.getAddress().getCity() != null && isNotEmpty(employeeSearch.getAddress().getCity().getId())){
			predicates.add(builder.equal(city.get(City_.id), employeeSearch.getAddress().getCity().getId()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && employeeSearch.getAddress().getCity() != null && isNotEmpty(employeeSearch.getAddress().getCity().getName())){
			predicates.add(builder.equal(city.get(City_.name), employeeSearch.getAddress().getCity().getName()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && employeeSearch.getAddress().getCity() != null && isNotEmpty(employeeSearch.getAddress().getCity().getActive())){
			predicates.add(builder.equal(city.get(City_.active), employeeSearch.getAddress().getCity().getActive()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && employeeSearch.getAddress().getCity() != null && isNotEmpty(employeeSearch.getAddress().getCity().getCreationDate())){
			predicates.add(builder.equal(city.get(City_.creationDate), employeeSearch.getAddress().getCity().getCreationDate()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && employeeSearch.getAddress().getCity() != null && isNotEmpty(employeeSearch.getAddress().getCity().getCreationUser())){
			predicates.add(builder.equal(city.get(City_.creationUser), employeeSearch.getAddress().getCity().getCreationUser()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && employeeSearch.getAddress().getCity() != null && isNotEmpty(employeeSearch.getAddress().getCity().getUpdateDate())){
			predicates.add(builder.equal(city.get(City_.updateDate), employeeSearch.getAddress().getCity().getUpdateDate()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && employeeSearch.getAddress().getCity() != null && isNotEmpty(employeeSearch.getAddress().getCity().getUpdateUser())){
			predicates.add(builder.equal(city.get(City_.updateUser), employeeSearch.getAddress().getCity().getUpdateUser()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getActive())){
			predicates.add(builder.equal(address.get(Address_.active), employeeSearch.getAddress().getActive()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getCreationDate())){
			predicates.add(builder.equal(address.get(Address_.creationDate), employeeSearch.getAddress().getCreationDate()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getCreationUser())){
			predicates.add(builder.equal(address.get(Address_.creationUser), employeeSearch.getAddress().getCreationUser()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getUpdateDate())){
			predicates.add(builder.equal(address.get(Address_.updateDate), employeeSearch.getAddress().getUpdateDate()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getUpdateUser())){
			predicates.add(builder.equal(address.get(Address_.updateUser), employeeSearch.getAddress().getUpdateUser()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getActive())){
			predicates.add(builder.equal(employee.get(Employee_.active), employeeSearch.getActive()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getCreationDate())){
			predicates.add(builder.equal(employee.get(Employee_.creationDate), employeeSearch.getCreationDate()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getCreationUser())){
			predicates.add(builder.equal(employee.get(Employee_.creationUser), employeeSearch.getCreationUser()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getUpdateDate())){
			predicates.add(builder.equal(employee.get(Employee_.updateDate), employeeSearch.getUpdateDate()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getUpdateUser())){
			predicates.add(builder.equal(employee.get(Employee_.updateUser), employeeSearch.getUpdateUser()));
		}
				
		criteria.select(employee).where(predicates.toArray(new Predicate[]{}));
		
		criteria.orderBy(builder.asc(employee.get(Employee_.id)));

		TypedQuery<Employee> query = entityManager.createQuery(criteria);

		query.setFirstResult(employeeSearch.getOffset());
		query.setMaxResults(employeeSearch.getRowCount());

		return query.getResultList();
	}

	public Employee getEmployeeCount(Employee employeeSearch) throws Exception {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

		Root<Employee> employee = criteria.from(Employee.class);
		
		Join<Employee, Address> address = employee.join(Employee_.address);
		Join<Address, City> city = address.join(Address_.city);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(employeeSearch != null && isNotEmpty(employeeSearch.getId())){
			predicates.add(builder.equal(employee.get(Employee_.id), employeeSearch.getId()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getCpr())){
			predicates.add(builder.equal(employee.get(Employee_.cpr), employeeSearch.getCpr()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getName())){
			predicates.add(builder.equal(employee.get(Employee_.name), employeeSearch.getName()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getAge())){
			predicates.add(builder.equal(employee.get(Employee_.age), employeeSearch.getAge()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getEmail())){
			predicates.add(builder.equal(employee.get(Employee_.email), employeeSearch.getEmail()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getGender())){
			predicates.add(builder.equal(employee.get(Employee_.gender), employeeSearch.getGender()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getMobile())){
			predicates.add(builder.equal(employee.get(Employee_.mobile), employeeSearch.getMobile()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getSalary())){
			predicates.add(builder.equal(employee.get(Employee_.salary), employeeSearch.getSalary()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getId())){
			predicates.add(builder.equal(address.get(Address_.id), employeeSearch.getAddress().getId()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getBuilding())){
			predicates.add(builder.equal(address.get(Address_.building), employeeSearch.getAddress().getBuilding()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getRoad())){
			predicates.add(builder.equal(address.get(Address_.road), employeeSearch.getAddress().getRoad()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getBlock())){
			predicates.add(builder.equal(address.get(Address_.block), employeeSearch.getAddress().getBlock()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && employeeSearch.getAddress().getCity() != null && isNotEmpty(employeeSearch.getAddress().getCity().getId())){
			predicates.add(builder.equal(city.get(City_.id), employeeSearch.getAddress().getCity().getId()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && employeeSearch.getAddress().getCity() != null && isNotEmpty(employeeSearch.getAddress().getCity().getName())){
			predicates.add(builder.equal(city.get(City_.name), employeeSearch.getAddress().getCity().getName()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && employeeSearch.getAddress().getCity() != null && isNotEmpty(employeeSearch.getAddress().getCity().getActive())){
			predicates.add(builder.equal(city.get(City_.active), employeeSearch.getAddress().getCity().getActive()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && employeeSearch.getAddress().getCity() != null && isNotEmpty(employeeSearch.getAddress().getCity().getCreationDate())){
			predicates.add(builder.equal(city.get(City_.creationDate), employeeSearch.getAddress().getCity().getCreationDate()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && employeeSearch.getAddress().getCity() != null && isNotEmpty(employeeSearch.getAddress().getCity().getCreationUser())){
			predicates.add(builder.equal(city.get(City_.creationUser), employeeSearch.getAddress().getCity().getCreationUser()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && employeeSearch.getAddress().getCity() != null && isNotEmpty(employeeSearch.getAddress().getCity().getUpdateDate())){
			predicates.add(builder.equal(city.get(City_.updateDate), employeeSearch.getAddress().getCity().getUpdateDate()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && employeeSearch.getAddress().getCity() != null && isNotEmpty(employeeSearch.getAddress().getCity().getUpdateUser())){
			predicates.add(builder.equal(city.get(City_.updateUser), employeeSearch.getAddress().getCity().getUpdateUser()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getActive())){
			predicates.add(builder.equal(address.get(Address_.active), employeeSearch.getAddress().getActive()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getCreationDate())){
			predicates.add(builder.equal(address.get(Address_.creationDate), employeeSearch.getAddress().getCreationDate()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getCreationUser())){
			predicates.add(builder.equal(address.get(Address_.creationUser), employeeSearch.getAddress().getCreationUser()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getUpdateDate())){
			predicates.add(builder.equal(address.get(Address_.updateDate), employeeSearch.getAddress().getUpdateDate()));
		}
		if(employeeSearch != null && employeeSearch.getAddress() != null && isNotEmpty(employeeSearch.getAddress().getUpdateUser())){
			predicates.add(builder.equal(address.get(Address_.updateUser), employeeSearch.getAddress().getUpdateUser()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getActive())){
			predicates.add(builder.equal(employee.get(Employee_.active), employeeSearch.getActive()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getCreationDate())){
			predicates.add(builder.equal(employee.get(Employee_.creationDate), employeeSearch.getCreationDate()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getCreationUser())){
			predicates.add(builder.equal(employee.get(Employee_.creationUser), employeeSearch.getCreationUser()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getUpdateDate())){
			predicates.add(builder.equal(employee.get(Employee_.updateDate), employeeSearch.getUpdateDate()));
		}
		if(employeeSearch != null && isNotEmpty(employeeSearch.getUpdateUser())){
			predicates.add(builder.equal(employee.get(Employee_.updateUser), employeeSearch.getUpdateUser()));
		}
		
		criteria = criteria.select(builder.count(employee.get(Employee_.id)))
							.where(predicates.toArray(new Predicate[]{}));

		TypedQuery<Long> query = entityManager.createQuery(criteria);

		employeeSearch.setTotalRows(query.getSingleResult().intValue());

		return employeeSearch;
	}
	
	public Employee getEmployee(Employee employee) throws Exception {

		return entityManager.find(Employee.class, employee.getId());
	}
	
	public Employee saveEmployee(Employee employee) throws Exception {
		
		if (employee.getAddress().getId() == null) {

			employee.getAddress().setActive(true);
			employee.getAddress().setCreationUser("Test");
			employee.getAddress().setCreationDate(new Timestamp(System.currentTimeMillis()));

		} else {

			employee.getAddress().setUpdateUser("Test");
			employee.getAddress().setUpdateDate(new Timestamp(System.currentTimeMillis()));
		}
		
		for(Certificate certificate : employee.getCertificates()){
			
			certificate.setEmployee(employee);
			
			if (certificate.getId() == null) {

				certificate.setActive(true);
				certificate.setCreationUser("Test");
				certificate.setCreationDate(new Timestamp(System.currentTimeMillis()));

			} else {

				certificate.setUpdateUser("Test");
				certificate.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			}
		}
		
		if (employee.getId() == null) {

			employee.setActive(true);
			employee.setCreationUser("Test");
			employee.setCreationDate(new Timestamp(System.currentTimeMillis()));
			
			entityManager.persist(employee);

		} else {

			employee.setUpdateUser("Test");
			employee.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			
			entityManager.merge(employee);
		}
		
		return employee;
	}
	
	public Employee updateEmployeeActive(Employee employee) throws Exception {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
        CriteriaUpdate<Employee> criteria = builder.createCriteriaUpdate(Employee.class);
        
        Root<Employee> root = criteria.from(Employee.class);
        
        criteria.set(root.get(Employee_.updateDate), new Timestamp(System.currentTimeMillis()));
        criteria.set(root.get(Employee_.updateUser), "Test");
        criteria.set(root.get(Employee_.active), employee.getActive());
        criteria.where(builder.equal(root.get(Employee_.id), employee.getId()));
        
        Query query = entityManager.createQuery(criteria);
        
        query.executeUpdate();
        
		return employee;
	}
}