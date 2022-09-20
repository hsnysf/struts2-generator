package employee.bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import employee.dao.ManagerDao;
import employee.entity.Manager;

@Stateless
@LocalBean
public class ManagerBean {

	ManagerDao managerDao;
	
	EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
		managerDao = new ManagerDao(entityManager);
	}
	
	public List<Manager> searchManagers(Manager managerSearch) throws Exception {
		
		return managerDao.searchManagers(managerSearch);
	}
	
	public Manager getManagerCount(Manager managerSearch) throws Exception {
		
		return managerDao.getManagerCount(managerSearch);
	}
	
	public Manager getManager(Manager manager) throws Exception {

		return managerDao.getManager(manager);
	}
	
	public Manager saveManager(Manager manager) throws Exception {
		
		return managerDao.saveManager(manager);
	}
	
	public Manager updateManagerActive(Manager manager) throws Exception {
		
		return managerDao.updateManagerActive(manager);
	}
}