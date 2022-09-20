package employee.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.beanutils.BeanUtils;

@Entity
@Table(name="city")
public class City implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ct_id")
	private Integer id;
	@Column(name="ct_name")
	private String name;
	@Column(name="ct_active")
	private Boolean active;
	@Column(name="ct_creation_date")
	private Timestamp creationDate;
	@Column(name="ct_creation_user")
	private String creationUser;
	@Column(name="ct_update_date")
	private Timestamp updateDate;
	@Column(name="ct_update_user")
	private String updateUser;
	@OneToMany(mappedBy="city", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Address> addresss;
	
	@Transient
	private int pageNo = 1;
	@Transient
	private int pageCount;
	@Transient
	private int rowCount = 10;
	@Transient
	private int totalRows;
	
	public City() {
	}
	
	public City(Integer id) {
		this.id = id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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
	
	public void setAddresss(List<Address> addresss) {
		this.addresss = addresss;
	}

	public List<Address> getAddresss() {
		return addresss;
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

 		if(object != null && object instanceof City){

			City city = (City) object;

			if(city.getId() != null && getId() != null){
				return city.getId() == getId();
			}else if(city.getId() == null && getId() == null){
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