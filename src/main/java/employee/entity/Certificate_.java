package employee.entity;

import java.sql.Timestamp;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Certificate.class)
public class Certificate_ {

	public static volatile SingularAttribute<Certificate, Integer> id;
	public static volatile SingularAttribute<Certificate, Employee> employee;
	public static volatile SingularAttribute<Certificate, String> title;
	public static volatile SingularAttribute<Certificate, Integer> year;
	public static volatile SingularAttribute<Certificate, Boolean> active;
	public static volatile SingularAttribute<Certificate, Timestamp> creationDate;
	public static volatile SingularAttribute<Certificate, String> creationUser;
	public static volatile SingularAttribute<Certificate, Timestamp> updateDate;
	public static volatile SingularAttribute<Certificate, String> updateUser;
}