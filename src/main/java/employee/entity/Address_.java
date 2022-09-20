package employee.entity;

import java.sql.Timestamp;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Address.class)
public class Address_ {

	public static volatile SingularAttribute<Address, Integer> id;
	public static volatile SingularAttribute<Address, Integer> building;
	public static volatile SingularAttribute<Address, Integer> road;
	public static volatile SingularAttribute<Address, Integer> block;
	public static volatile SingularAttribute<Address, City> city;
	public static volatile SingularAttribute<Address, Boolean> active;
	public static volatile SingularAttribute<Address, Timestamp> creationDate;
	public static volatile SingularAttribute<Address, String> creationUser;
	public static volatile SingularAttribute<Address, Timestamp> updateDate;
	public static volatile SingularAttribute<Address, String> updateUser;
}