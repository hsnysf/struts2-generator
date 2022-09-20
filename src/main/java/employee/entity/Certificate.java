package employee.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.beanutils.BeanUtils;

@Entity
@Table(name="certificate")
public class Certificate implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cert_id")
	private Integer id;
	@JoinColumn(name="cert_employee_id")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Employee employee;			
	@Column(name="cert_title")
	private String title;
	@Column(name="cert_year")
	private Integer year;
	@Column(name="cert_active")
	private Boolean active;
	@Column(name="cert_creation_date")
	private Timestamp creationDate;
	@Column(name="cert_creation_user")
	private String creationUser;
	@Column(name="cert_update_date")
	private Timestamp updateDate;
	@Column(name="cert_update_user")
	private String updateUser;
	
	@Transient
	private int pageNo = 1;
	@Transient
	private int pageCount;
	@Transient
	private int rowCount = 10;
	@Transient
	private int totalRows;
	
	public Certificate() {
	}
	
	public Certificate(Integer id) {
		this.id = id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getYear() {
		return year;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getActive() {
		return active;
	}
	
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}
	
	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getCreationUser() {
		return creationUser;
	}
	
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getPageCount() {
		pageCount = (int)Math.ceil((double)totalRows/(double)rowCount);
		return pageCount;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public int getRowCount() {
		return rowCount;
	}
	
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	
	public int getTotalRows() {
		return totalRows;
	}
	
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	public int getOffset() {
		return (pageNo-1) * rowCount;
	}

	public String toString() {

		try{
			return BeanUtils.describe(this).toString();
		}catch(Exception e) {
			return null;
		}
	}
	
	public boolean equals(Object object) {

 		if(object != null && object instanceof Certificate){

			Certificate certificate = (Certificate) object;

			if(certificate.getId() != null && getId() != null){
				return certificate.getId() == getId();
			}else if(certificate.getId() == null && getId() == null){
				return true;
			}else{
				return false;
			}

		} else {
			return false;
		}
	}

	public int hashCode() {
		return getId() != null ? getId() : 0;
	}
}