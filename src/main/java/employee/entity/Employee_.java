package employee.entity;

import java.sql.Timestamp;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Employee.class)
public class Employee_ {

	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, Integer> cpr;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, Short> age;
	public static volatile SingularAttribute<Employee, String> email;
	public static volatile SingularAttribute<Employee, String> gender;
	public static volatile SingularAttribute<Employee, Integer> mobile;
	public static volatile SingularAttribute<Employee, Double> salary;
	public static volatile SingularAttribute<Employee, Address> address;
	public static volatile SingularAttribute<Employee, Boolean> active;
	public static volatile SingularAttribute<Employee, Timestamp> creationDate;
	public static volatile SingularAttribute<Employee, String> creationUser;
	public static volatile SingularAttribute<Employee, Timestamp> updateDate;
	public static volatile SingularAttribute<Employee, String> updateUser;
}