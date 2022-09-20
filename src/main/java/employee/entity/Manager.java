package employee.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.beanutils.BeanUtils;

@Entity
@Table(name="manager")
@PrimaryKeyJoinColumn(name="mngr_id")
@Inheritance(strategy=InheritanceType.JOINED)
public class Manager extends Employee {

	private static final long serialVersionUID = 1L;
	
	@Column(name="mngr_degree")
	private Integer degree;
	@Column(name="mngr_allowance")
	private Double allowance;
	@Column(name="mngr_creation_date")
	private Timestamp creationDate;
	@Column(name="mngr_creation_user")
	private String creationUser;
	@Column(name="mngr_update_date")
	private Timestamp updateDate;
	@Column(name="mngr_update_user")
	private String updateUser;
	@OneToMany(mappedBy="employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Certificate> certificates;
	
	@Transient
	private int pageNo = 1;
	@Transient
	private int pageCount;
	@Transient
	private int rowCount = 10;
	@Transient
	private int totalRows;
	
	public Manager() {
	}
	
	public Manager(Integer id) {
		super(id);
	}
	
	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public Integer getDegree() {
		return degree;
	}
	
	public void setAllowance(Double allowance) {
		this.allowance = allowance;
	}

	public Double getAllowance() {
		return allowance;
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
	
	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	public List<Certificate> getCertificates() {
		return certificates;
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

 		if(object != null && object instanceof Manager){

			Manager manager = (Manager) object;

			if(manager.getId() != null && getId() != null){
				return manager.getId() == getId();
			}else if(manager.getId() == null && getId() == null){
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