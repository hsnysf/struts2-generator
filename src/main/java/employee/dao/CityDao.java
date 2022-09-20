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
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import employee.entity.City;
import employee.entity.City_;


import employee.entity.Address;

public class CityDao {

	EntityManager entityManager;
	
	public CityDao(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	public static boolean isNotEmpty(Object object){
		
		return object != null && !object.toString().trim().isEmpty() && !"0".equals(object.toString().trim());
	}
	
	public List<City> searchCitys(City citySearch) throws Exception {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<City> criteria = builder.createQuery(City.class);

		Root<City> city = criteria.from(City.class);
		

		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(citySearch != null && isNotEmpty(citySearch.getId())){
			predicates.add(builder.equal(city.get(City_.id), citySearch.getId()));
		}
		if(citySearch != null && isNotEmpty(citySearch.getName())){
			predicates.add(builder.equal(city.get(City_.name), citySearch.getName()));
		}
		if(citySearch != null && isNotEmpty(citySearch.getActive())){
			predicates.add(builder.equal(city.get(City_.active), citySearch.getActive()));
		}
		if(citySearch != null && isNotEmpty(citySearch.getCreationDate())){
			predicates.add(builder.equal(city.get(City_.creationDate), citySearch.getCreationDate()));
		}
		if(citySearch != null && isNotEmpty(citySearch.getCreationUser())){
			predicates.add(builder.equal(city.get(City_.creationUser), citySearch.getCreationUser()));
		}
		if(citySearch != null && isNotEmpty(citySearch.getUpdateDate())){
			predicates.add(builder.equal(city.get(City_.updateDate), citySearch.getUpdateDate()));
		}
		if(citySearch != null && isNotEmpty(citySearch.getUpdateUser())){
			predicates.add(builder.equal(city.get(City_.updateUser), citySearch.getUpdateUser()));
		}
				
		criteria.select(city).where(predicates.toArray(new Predicate[]{}));
		
		criteria.orderBy(builder.asc(city.get(City_.id)));

		TypedQuery<City> query = entityManager.createQuery(criteria);

		query.setFirstResult(citySearch.getOffset());
		query.setMaxResults(citySearch.getRowCount());

		return query.getResultList();
	}

	public City getCityCount(City citySearch) throws Exception {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

		Root<City> city = criteria.from(City.class);
		
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(citySearch != null && isNotEmpty(citySearch.getId())){
			predicates.add(builder.equal(city.get(City_.id), citySearch.getId()));
		}
		if(citySearch != null && isNotEmpty(citySearch.getName())){
			predicates.add(builder.equal(city.get(City_.name), citySearch.getName()));
		}
		if(citySearch != null && isNotEmpty(citySearch.getActive())){
			predicates.add(builder.equal(city.get(City_.active), citySearch.getActive()));
		}
		if(citySearch != null && isNotEmpty(citySearch.getCreationDate())){
			predicates.add(builder.equal(city.get(City_.creationDate), citySearch.getCreationDate()));
		}
		if(citySearch != null && isNotEmpty(citySearch.getCreationUser())){
			predicates.add(builder.equal(city.get(City_.creationUser), citySearch.getCreationUser()));
		}
		if(citySearch != null && isNotEmpty(citySearch.getUpdateDate())){
			predicates.add(builder.equal(city.get(City_.updateDate), citySearch.getUpdateDate()));
		}
		if(citySearch != null && isNotEmpty(citySearch.getUpdateUser())){
			predicates.add(builder.equal(city.get(City_.updateUser), citySearch.getUpdateUser()));
		}
		
		criteria = criteria.select(builder.count(city.get(City_.id)))
							.where(predicates.toArray(new Predicate[]{}));

		TypedQuery<Long> query = entityManager.createQuery(criteria);

		citySearch.setTotalRows(query.getSingleResult().intValue());

		return citySearch;
	}
	
	public City getCity(City city) throws Exception {

		return entityManager.find(City.class, city.getId());
	}
	
	public City saveCity(City city) throws Exception {
		
		
		for(Address address : city.getAddresss()){
			
			address.setCity(city);
			
			if (address.getId() == null) {

				address.setActive(true);
				address.setCreationUser("Test");
				address.setCreationDate(new Timestamp(System.currentTimeMillis()));

			} else {

				address.setUpdateUser("Test");
				address.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			}
		}
		
		if (city.getId() == null) {

			city.setActive(true);
			city.setCreationUser("Test");
			city.setCreationDate(new Timestamp(System.currentTimeMillis()));
			
			entityManager.persist(city);

		} else {

			city.setUpdateUser("Test");
			city.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			
			entityManager.merge(city);
		}
		
		return city;
	}
	
	public City updateCityActive(City city) throws Exception {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
        CriteriaUpdate<City> criteria = builder.createCriteriaUpdate(City.class);
        
        Root<City> root = criteria.from(City.class);
        
        criteria.set(root.get(City_.updateDate), new Timestamp(System.currentTimeMillis()));
        criteria.set(root.get(City_.updateUser), "Test");
        criteria.set(root.get(City_.active), city.getActive());
        criteria.where(builder.equal(root.get(City_.id), city.getId()));
        
        Query query = entityManager.createQuery(criteria);
        
        query.executeUpdate();
        
		return city;
	}
}