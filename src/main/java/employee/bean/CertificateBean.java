package employee.bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import employee.dao.CertificateDao;
import employee.entity.Certificate;

@Stateless
@LocalBean
public class CertificateBean {

	CertificateDao certificateDao;
	
	EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
		certificateDao = new CertificateDao(entityManager);
	}
	
	public List<Certificate> searchCertificates(Certificate certificateSearch) throws Exception {
		
		return certificateDao.searchCertificates(certificateSearch);
	}
	
	public Certificate getCertificateCount(Certificate certificateSearch) throws Exception {
		
		return certificateDao.getCertificateCount(certificateSearch);
	}
	
	public Certificate getCertificate(Certificate certificate) throws Exception {

		return certificateDao.getCertificate(certificate);
	}
	
	public Certificate saveCertificate(Certificate certificate) throws Exception {
		
		return certificateDao.saveCertificate(certificate);
	}
	
	public Certificate updateCertificateActive(Certificate certificate) throws Exception {
		
		return certificateDao.updateCertificateActive(certificate);
	}
}