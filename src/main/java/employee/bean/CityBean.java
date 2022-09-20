package employee.bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import employee.dao.CityDao;
import employee.entity.City;

@Stateless
@LocalBean
public class CityBean {

	CityDao cityDao;
	
	EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
		cityDao = new CityDao(entityManager);
	}
	
	public List<City> searchCitys(City citySearch) throws Exception {
		
		return cityDao.searchCitys(citySearch);
	}
	
	public City getCityCount(City citySearch) throws Exception {
		
		return cityDao.getCityCount(citySearch);
	}
	
	public City getCity(City city) throws Exception {

		return cityDao.getCity(city);
	}
	
	public City saveCity(City city) throws Exception {
		
		return cityDao.saveCity(city);
	}
	
	public City updateCityActive(City city) throws Exception {
		
		return cityDao.updateCityActive(city);
	}
}