package employee.action;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import employee.bean.CertificateBean;
import employee.entity.Certificate;

@Action("certificate")
@Results({
	@Result(name="toSuccessUpdateCertificateActive", type = "redirect", 
			location = "toSuccessUpdateCertificateActive", 
			params = {"certificate.id", "%{certificate.id}","certificate.active", "%{certificate.active}"}),
	@Result(name = "toSuccessSaveCertificate", type = "redirect", location = "toSuccessSaveCertificate", params = {"id", "%{id}", "certificate.id", "%{certificate.id}"})
})
public class CertificateAction extends CommonAction{

	private static final long serialVersionUID = 1L;
	
	private Certificate certificateSearch = new Certificate();
	private Certificate certificate = new Certificate();
	private List<Certificate> certificates = new ArrayList<Certificate>();
	
	@EJB
	private CertificateBean certificateBean;
	
	private Integer id;
	
	@Action("searchCertificates")
	public String searchCertificates() throws Exception {
		
		String result = toPage("/certificates-list.jsp");
		
		certificates = certificateBean.searchCertificates(certificateSearch);
		
		certificateSearch = certificateBean.getCertificateCount(certificateSearch);
		
		return result;
	}
	
	@Action("updateCertificateActive")
	public String updateCertificateActive() throws Exception {
		
		certificate = certificateBean.updateCertificateActive(certificate);
		
		return "toSuccessUpdateCertificateActive";
	}
	
	@Action("toSuccessUpdateCertificateActive")
	public String toSuccessUpdateCertificateActive() throws Exception {
		
		if(certificate.getActive()) {
			addActionMessage("Certificate " + certificate.getId() + " has been activated successfully");
		}else {
			addActionMessage("Certificate " + certificate.getId() + " has been deactivated successfully");
		}
		
		return searchCertificates();
	}
	
	@Action("toAddCertificate")
	public String toAddCertificate() throws Exception {
		
		String result = toPage("/save-certificate.jsp");
		
		certificate = new Certificate();
		
		return result;
	}
	
	@Action("toEditCertificate")
	public String toEditCertificate() throws Exception {
		
		String result = toPage("/save-certificate.jsp");
		
		certificate = certificateBean.getCertificate(certificate);
		
		return result;
	}
	
	@Action("saveCertificate")
	public String saveCertificate() throws Exception {
		
		id = certificate.getId();
		
		certificate = certificateBean.saveCertificate(certificate);
		
		return "toSuccessSaveCertificate";
	}
	
	@Action("toSuccessSaveCertificate")
	public String toSuccessSaveCertificate() throws Exception {
		
		if(id == null) {
			addActionMessage("Certificate #" + certificate.getId() + " has been added successfully");
		}else {
			addActionMessage("Certificate #" + certificate.getId() + " has been updated successfully");
		}
		
		return searchCertificates();
	}
	
	public Certificate getCertificateSearch() {
		return certificateSearch;
	}
	
	public void setCertificateSearch(Certificate certificateSearch) {
		this.certificateSearch = certificateSearch;
	}
	
	public Certificate getCertificate() {
		return certificate;
	}
	
	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}
	
	public List<Certificate> getCertificates() {
		return certificates;
	}
	
	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}