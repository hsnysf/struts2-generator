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

import employee.entity.Certificate;
import employee.entity.Certificate_;


import employee.entity.Employee_;
import employee.entity.Employee;
import employee.entity.Address_;
import employee.entity.Address;
import employee.entity.City_;
import employee.entity.City;

public class CertificateDao {

	EntityManager entityManager;
	
	public CertificateDao(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	public static boolean isNotEmpty(Object object){
		
		return object != null && !object.toString().trim().isEmpty() && !"0".equals(object.toString().trim());
	}
	
	public List<Certificate> searchCertificates(Certificate certificateSearch) throws Exception {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Certificate> criteria = builder.createQuery(Certificate.class);

		Root<Certificate> certificate = criteria.from(Certificate.class);
		
		Join<Certificate, Employee> employee = certificate.join(Certificate_.employee);
		Join<Employee, Address> address = employee.join(Employee_.address);
		Join<Address, City> city = address.join(Address_.city);

		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(certificateSearch != null && isNotEmpty(certificateSearch.getId())){
			predicates.add(builder.equal(certificate.get(Certificate_.id), certificateSearch.getId()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getId())){
			predicates.add(builder.equal(employee.get(Employee_.id), certificateSearch.getEmployee().getId()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getCpr())){
			predicates.add(builder.equal(employee.get(Employee_.cpr), certificateSearch.getEmployee().getCpr()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getName())){
			predicates.add(builder.equal(employee.get(Employee_.name), certificateSearch.getEmployee().getName()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getAge())){
			predicates.add(builder.equal(employee.get(Employee_.age), certificateSearch.getEmployee().getAge()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getEmail())){
			predicates.add(builder.equal(employee.get(Employee_.email), certificateSearch.getEmployee().getEmail()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getGender())){
			predicates.add(builder.equal(employee.get(Employee_.gender), certificateSearch.getEmployee().getGender()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getMobile())){
			predicates.add(builder.equal(employee.get(Employee_.mobile), certificateSearch.getEmployee().getMobile()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getSalary())){
			predicates.add(builder.equal(employee.get(Employee_.salary), certificateSearch.getEmployee().getSalary()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getId())){
			predicates.add(builder.equal(address.get(Address_.id), certificateSearch.getEmployee().getAddress().getId()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getBuilding())){
			predicates.add(builder.equal(address.get(Address_.building), certificateSearch.getEmployee().getAddress().getBuilding()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getRoad())){
			predicates.add(builder.equal(address.get(Address_.road), certificateSearch.getEmployee().getAddress().getRoad()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getBlock())){
			predicates.add(builder.equal(address.get(Address_.block), certificateSearch.getEmployee().getAddress().getBlock()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && certificateSearch.getEmployee().getAddress().getCity() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCity().getId())){
			predicates.add(builder.equal(city.get(City_.id), certificateSearch.getEmployee().getAddress().getCity().getId()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && certificateSearch.getEmployee().getAddress().getCity() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCity().getName())){
			predicates.add(builder.equal(city.get(City_.name), certificateSearch.getEmployee().getAddress().getCity().getName()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && certificateSearch.getEmployee().getAddress().getCity() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCity().getActive())){
			predicates.add(builder.equal(city.get(City_.active), certificateSearch.getEmployee().getAddress().getCity().getActive()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && certificateSearch.getEmployee().getAddress().getCity() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCity().getCreationDate())){
			predicates.add(builder.equal(city.get(City_.creationDate), certificateSearch.getEmployee().getAddress().getCity().getCreationDate()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && certificateSearch.getEmployee().getAddress().getCity() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCity().getCreationUser())){
			predicates.add(builder.equal(city.get(City_.creationUser), certificateSearch.getEmployee().getAddress().getCity().getCreationUser()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && certificateSearch.getEmployee().getAddress().getCity() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCity().getUpdateDate())){
			predicates.add(builder.equal(city.get(City_.updateDate), certificateSearch.getEmployee().getAddress().getCity().getUpdateDate()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && certificateSearch.getEmployee().getAddress().getCity() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCity().getUpdateUser())){
			predicates.add(builder.equal(city.get(City_.updateUser), certificateSearch.getEmployee().getAddress().getCity().getUpdateUser()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getActive())){
			predicates.add(builder.equal(address.get(Address_.active), certificateSearch.getEmployee().getAddress().getActive()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCreationDate())){
			predicates.add(builder.equal(address.get(Address_.creationDate), certificateSearch.getEmployee().getAddress().getCreationDate()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCreationUser())){
			predicates.add(builder.equal(address.get(Address_.creationUser), certificateSearch.getEmployee().getAddress().getCreationUser()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getUpdateDate())){
			predicates.add(builder.equal(address.get(Address_.updateDate), certificateSearch.getEmployee().getAddress().getUpdateDate()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getUpdateUser())){
			predicates.add(builder.equal(address.get(Address_.updateUser), certificateSearch.getEmployee().getAddress().getUpdateUser()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getActive())){
			predicates.add(builder.equal(employee.get(Employee_.active), certificateSearch.getEmployee().getActive()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getCreationDate())){
			predicates.add(builder.equal(employee.get(Employee_.creationDate), certificateSearch.getEmployee().getCreationDate()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getCreationUser())){
			predicates.add(builder.equal(employee.get(Employee_.creationUser), certificateSearch.getEmployee().getCreationUser()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getUpdateDate())){
			predicates.add(builder.equal(employee.get(Employee_.updateDate), certificateSearch.getEmployee().getUpdateDate()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getUpdateUser())){
			predicates.add(builder.equal(employee.get(Employee_.updateUser), certificateSearch.getEmployee().getUpdateUser()));
		}
		if(certificateSearch != null && isNotEmpty(certificateSearch.getTitle())){
			predicates.add(builder.equal(certificate.get(Certificate_.title), certificateSearch.getTitle()));
		}
		if(certificateSearch != null && isNotEmpty(certificateSearch.getYear())){
			predicates.add(builder.equal(certificate.get(Certificate_.year), certificateSearch.getYear()));
		}
		if(certificateSearch != null && isNotEmpty(certificateSearch.getActive())){
			predicates.add(builder.equal(certificate.get(Certificate_.active), certificateSearch.getActive()));
		}
		if(certificateSearch != null && isNotEmpty(certificateSearch.getCreationDate())){
			predicates.add(builder.equal(certificate.get(Certificate_.creationDate), certificateSearch.getCreationDate()));
		}
		if(certificateSearch != null && isNotEmpty(certificateSearch.getCreationUser())){
			predicates.add(builder.equal(certificate.get(Certificate_.creationUser), certificateSearch.getCreationUser()));
		}
		if(certificateSearch != null && isNotEmpty(certificateSearch.getUpdateDate())){
			predicates.add(builder.equal(certificate.get(Certificate_.updateDate), certificateSearch.getUpdateDate()));
		}
		if(certificateSearch != null && isNotEmpty(certificateSearch.getUpdateUser())){
			predicates.add(builder.equal(certificate.get(Certificate_.updateUser), certificateSearch.getUpdateUser()));
		}
				
		criteria.select(certificate).where(predicates.toArray(new Predicate[]{}));
		
		criteria.orderBy(builder.asc(certificate.get(Certificate_.id)));

		TypedQuery<Certificate> query = entityManager.createQuery(criteria);

		query.setFirstResult(certificateSearch.getOffset());
		query.setMaxResults(certificateSearch.getRowCount());

		return query.getResultList();
	}

	public Certificate getCertificateCount(Certificate certificateSearch) throws Exception {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

		Root<Certificate> certificate = criteria.from(Certificate.class);
		
		Join<Certificate, Employee> employee = certificate.join(Certificate_.employee);
		Join<Employee, Address> address = employee.join(Employee_.address);
		Join<Address, City> city = address.join(Address_.city);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(certificateSearch != null && isNotEmpty(certificateSearch.getId())){
			predicates.add(builder.equal(certificate.get(Certificate_.id), certificateSearch.getId()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getId())){
			predicates.add(builder.equal(employee.get(Employee_.id), certificateSearch.getEmployee().getId()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getCpr())){
			predicates.add(builder.equal(employee.get(Employee_.cpr), certificateSearch.getEmployee().getCpr()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getName())){
			predicates.add(builder.equal(employee.get(Employee_.name), certificateSearch.getEmployee().getName()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getAge())){
			predicates.add(builder.equal(employee.get(Employee_.age), certificateSearch.getEmployee().getAge()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getEmail())){
			predicates.add(builder.equal(employee.get(Employee_.email), certificateSearch.getEmployee().getEmail()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getGender())){
			predicates.add(builder.equal(employee.get(Employee_.gender), certificateSearch.getEmployee().getGender()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getMobile())){
			predicates.add(builder.equal(employee.get(Employee_.mobile), certificateSearch.getEmployee().getMobile()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getSalary())){
			predicates.add(builder.equal(employee.get(Employee_.salary), certificateSearch.getEmployee().getSalary()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getId())){
			predicates.add(builder.equal(address.get(Address_.id), certificateSearch.getEmployee().getAddress().getId()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getBuilding())){
			predicates.add(builder.equal(address.get(Address_.building), certificateSearch.getEmployee().getAddress().getBuilding()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getRoad())){
			predicates.add(builder.equal(address.get(Address_.road), certificateSearch.getEmployee().getAddress().getRoad()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getBlock())){
			predicates.add(builder.equal(address.get(Address_.block), certificateSearch.getEmployee().getAddress().getBlock()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && certificateSearch.getEmployee().getAddress().getCity() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCity().getId())){
			predicates.add(builder.equal(city.get(City_.id), certificateSearch.getEmployee().getAddress().getCity().getId()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && certificateSearch.getEmployee().getAddress().getCity() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCity().getName())){
			predicates.add(builder.equal(city.get(City_.name), certificateSearch.getEmployee().getAddress().getCity().getName()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && certificateSearch.getEmployee().getAddress().getCity() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCity().getActive())){
			predicates.add(builder.equal(city.get(City_.active), certificateSearch.getEmployee().getAddress().getCity().getActive()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && certificateSearch.getEmployee().getAddress().getCity() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCity().getCreationDate())){
			predicates.add(builder.equal(city.get(City_.creationDate), certificateSearch.getEmployee().getAddress().getCity().getCreationDate()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && certificateSearch.getEmployee().getAddress().getCity() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCity().getCreationUser())){
			predicates.add(builder.equal(city.get(City_.creationUser), certificateSearch.getEmployee().getAddress().getCity().getCreationUser()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && certificateSearch.getEmployee().getAddress().getCity() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCity().getUpdateDate())){
			predicates.add(builder.equal(city.get(City_.updateDate), certificateSearch.getEmployee().getAddress().getCity().getUpdateDate()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && certificateSearch.getEmployee().getAddress().getCity() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCity().getUpdateUser())){
			predicates.add(builder.equal(city.get(City_.updateUser), certificateSearch.getEmployee().getAddress().getCity().getUpdateUser()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getActive())){
			predicates.add(builder.equal(address.get(Address_.active), certificateSearch.getEmployee().getAddress().getActive()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCreationDate())){
			predicates.add(builder.equal(address.get(Address_.creationDate), certificateSearch.getEmployee().getAddress().getCreationDate()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getCreationUser())){
			predicates.add(builder.equal(address.get(Address_.creationUser), certificateSearch.getEmployee().getAddress().getCreationUser()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getUpdateDate())){
			predicates.add(builder.equal(address.get(Address_.updateDate), certificateSearch.getEmployee().getAddress().getUpdateDate()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && certificateSearch.getEmployee().getAddress() != null && isNotEmpty(certificateSearch.getEmployee().getAddress().getUpdateUser())){
			predicates.add(builder.equal(address.get(Address_.updateUser), certificateSearch.getEmployee().getAddress().getUpdateUser()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getActive())){
			predicates.add(builder.equal(employee.get(Employee_.active), certificateSearch.getEmployee().getActive()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getCreationDate())){
			predicates.add(builder.equal(employee.get(Employee_.creationDate), certificateSearch.getEmployee().getCreationDate()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getCreationUser())){
			predicates.add(builder.equal(employee.get(Employee_.creationUser), certificateSearch.getEmployee().getCreationUser()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getUpdateDate())){
			predicates.add(builder.equal(employee.get(Employee_.updateDate), certificateSearch.getEmployee().getUpdateDate()));
		}
		if(certificateSearch != null && certificateSearch.getEmployee() != null && isNotEmpty(certificateSearch.getEmployee().getUpdateUser())){
			predicates.add(builder.equal(employee.get(Employee_.updateUser), certificateSearch.getEmployee().getUpdateUser()));
		}
		if(certificateSearch != null && isNotEmpty(certificateSearch.getTitle())){
			predicates.add(builder.equal(certificate.get(Certificate_.title), certificateSearch.getTitle()));
		}
		if(certificateSearch != null && isNotEmpty(certificateSearch.getYear())){
			predicates.add(builder.equal(certificate.get(Certificate_.year), certificateSearch.getYear()));
		}
		if(certificateSearch != null && isNotEmpty(certificateSearch.getActive())){
			predicates.add(builder.equal(certificate.get(Certificate_.active), certificateSearch.getActive()));
		}
		if(certificateSearch != null && isNotEmpty(certificateSearch.getCreationDate())){
			predicates.add(builder.equal(certificate.get(Certificate_.creationDate), certificateSearch.getCreationDate()));
		}
		if(certificateSearch != null && isNotEmpty(certificateSearch.getCreationUser())){
			predicates.add(builder.equal(certificate.get(Certificate_.creationUser), certificateSearch.getCreationUser()));
		}
		if(certificateSearch != null && isNotEmpty(certificateSearch.getUpdateDate())){
			predicates.add(builder.equal(certificate.get(Certificate_.updateDate), certificateSearch.getUpdateDate()));
		}
		if(certificateSearch != null && isNotEmpty(certificateSearch.getUpdateUser())){
			predicates.add(builder.equal(certificate.get(Certificate_.updateUser), certificateSearch.getUpdateUser()));
		}
		
		criteria = criteria.select(builder.count(certificate.get(Certificate_.id)))
							.where(predicates.toArray(new Predicate[]{}));

		TypedQuery<Long> query = entityManager.createQuery(criteria);

		certificateSearch.setTotalRows(query.getSingleResult().intValue());

		return certificateSearch;
	}
	
	public Certificate getCertificate(Certificate certificate) throws Exception {

		return entityManager.find(Certificate.class, certificate.getId());
	}
	
	public Certificate saveCertificate(Certificate certificate) throws Exception {
		
		if (certificate.getEmployee().getId() == null) {

			certificate.getEmployee().setActive(true);
			certificate.getEmployee().setCreationUser("Test");
			certificate.getEmployee().setCreationDate(new Timestamp(System.currentTimeMillis()));

		} else {

			certificate.getEmployee().setUpdateUser("Test");
			certificate.getEmployee().setUpdateDate(new Timestamp(System.currentTimeMillis()));
		}
		
		
		if (certificate.getId() == null) {

			certificate.setActive(true);
			certificate.setCreationUser("Test");
			certificate.setCreationDate(new Timestamp(System.currentTimeMillis()));
			
			entityManager.persist(certificate);

		} else {

			certificate.setUpdateUser("Test");
			certificate.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			
			entityManager.merge(certificate);
		}
		
		return certificate;
	}
	
	public Certificate updateCertificateActive(Certificate certificate) throws Exception {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
        CriteriaUpdate<Certificate> criteria = builder.createCriteriaUpdate(Certificate.class);
        
        Root<Certificate> root = criteria.from(Certificate.class);
        
        criteria.set(root.get(Certificate_.updateDate), new Timestamp(System.currentTimeMillis()));
        criteria.set(root.get(Certificate_.updateUser), "Test");
        criteria.set(root.get(Certificate_.active), certificate.getActive());
        criteria.where(builder.equal(root.get(Certificate_.id), certificate.getId()));
        
        Query query = entityManager.createQuery(criteria);
        
        query.executeUpdate();
        
		return certificate;
	}
}