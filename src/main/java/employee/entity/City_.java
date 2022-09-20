package employee.entity;

import java.sql.Timestamp;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(City.class)
public class City_ {

	public static volatile SingularAttribute<City, Integer> id;
	public static volatile SingularAttribute<City, String> name;
	public static volatile SingularAttribute<City, Boolean> active;
	public static volatile SingularAttribute<City, Timestamp> creationDate;
	public static volatile SingularAttribute<City, String> creationUser;
	public static volatile SingularAttribute<City, Timestamp> updateDate;
	public static volatile SingularAttribute<City, String> updateUser;
}