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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.beanutils.BeanUtils;

@Entity
@Table(name="employee")
@Inheritance(strategy=InheritanceType.JOINED)
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Integer id;
	@Column(name="emp_cpr")
	private Integer cpr;
	@Column(name="emp_name")
	private String name;
	@Column(name="emp_age")
	private Short age;
	@Column(name="emp_email")
	private String email;
	@Column(name="emp_gender")
	private String gender;
	@Column(name="emp_mobile")
	private Integer mobile;
	@Column(name="emp_salary")
	private Double salary;
	@JoinColumn(name="emp_address_id")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Address address;			
	@Column(name="emp_active")
	private Boolean active;
	@Column(name="emp_creation_date")
	private Timestamp creationDate;
	@Column(name="emp_creation_user")
	private String creationUser;
	@Column(name="emp_update_date")
	private Timestamp updateDate;
	@Column(name="emp_update_user")
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
	
	public Employee() {
	}
	
	public Employee(Integer id) {
		this.id = id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void setCpr(Integer cpr) {
		this.cpr = cpr;
	}

	public Integer getCpr() {
		return cpr;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setAge(Short age) {
		this.age = age;
	}

	public Short getAge() {
		return age;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}
	
	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public Integer getMobile() {
		return mobile;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getSalary() {
		return salary;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
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

 		if(object != null && object instanceof Employee){

			Employee employee = (Employee) object;

			if(employee.getId() != null && getId() != null){
				return employee.getId() == getId();
			}else if(employee.getId() == null && getId() == null){
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