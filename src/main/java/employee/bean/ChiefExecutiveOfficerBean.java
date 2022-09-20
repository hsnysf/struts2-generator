package employee.bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import employee.dao.ChiefExecutiveOfficerDao;
import employee.entity.ChiefExecutiveOfficer;

@Stateless
@LocalBean
public class ChiefExecutiveOfficerBean {

	ChiefExecutiveOfficerDao chiefExecutiveOfficerDao;
	
	EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
		chiefExecutiveOfficerDao = new ChiefExecutiveOfficerDao(entityManager);
	}
	
	public List<ChiefExecutiveOfficer> searchChiefExecutiveOfficers(ChiefExecutiveOfficer chiefExecutiveOfficerSearch) throws Exception {
		
		return chiefExecutiveOfficerDao.searchChiefExecutiveOfficers(chiefExecutiveOfficerSearch);
	}
	
	public ChiefExecutiveOfficer getChiefExecutiveOfficerCount(ChiefExecutiveOfficer chiefExecutiveOfficerSearch) throws Exception {
		
		return chiefExecutiveOfficerDao.getChiefExecutiveOfficerCount(chiefExecutiveOfficerSearch);
	}
	
	public ChiefExecutiveOfficer getChiefExecutiveOfficer(ChiefExecutiveOfficer chiefExecutiveOfficer) throws Exception {

		return chiefExecutiveOfficerDao.getChiefExecutiveOfficer(chiefExecutiveOfficer);
	}
	
	public ChiefExecutiveOfficer saveChiefExecutiveOfficer(ChiefExecutiveOfficer chiefExecutiveOfficer) throws Exception {
		
		return chiefExecutiveOfficerDao.saveChiefExecutiveOfficer(chiefExecutiveOfficer);
	}
	
	public ChiefExecutiveOfficer updateChiefExecutiveOfficerActive(ChiefExecutiveOfficer chiefExecutiveOfficer) throws Exception {
		
		return chiefExecutiveOfficerDao.updateChiefExecutiveOfficerActive(chiefExecutiveOfficer);
	}
}