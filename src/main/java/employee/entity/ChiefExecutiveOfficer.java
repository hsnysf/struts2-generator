package employee.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import org.apache.commons.beanutils.BeanUtils;

@Entity
@Table(name="chief_executive_officer")
@PrimaryKeyJoinColumn(name="ceo_id")
@Inheritance(strategy=InheritanceType.JOINED)
public class ChiefExecutiveOfficer extends Manager {

	private static final long serialVersionUID = 1L;
	
	@Column(name="ceo_sector")
	private String sector;
	
	@Transient
	private int pageNo = 1;
	@Transient
	private int pageCount;
	@Transient
	private int rowCount = 10;
	@Transient
	private int totalRows;
	
	public ChiefExecutiveOfficer() {
	}
	
	public ChiefExecutiveOfficer(Integer id) {
		super(id);
	}
	
	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getSector() {
		return sector;
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

 		if(object != null && object instanceof ChiefExecutiveOfficer){

			ChiefExecutiveOfficer chiefExecutiveOfficer = (ChiefExecutiveOfficer) object;

			if(chiefExecutiveOfficer.getId() != null && getId() != null){
				return chiefExecutiveOfficer.getId() == getId();
			}else if(chiefExecutiveOfficer.getId() == null && getId() == null){
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