package employee.entity;

import java.sql.Timestamp;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Manager.class)
public class Manager_ extends Employee_ {

	public static volatile SingularAttribute<Manager, Employee> id;
	public static volatile SingularAttribute<Manager, Integer> degree;
	public static volatile SingularAttribute<Manager, Double> allowance;
	public static volatile SingularAttribute<Manager, Timestamp> creationDate;
	public static volatile SingularAttribute<Manager, String> creationUser;
	public static volatile SingularAttribute<Manager, Timestamp> updateDate;
	public static volatile SingularAttribute<Manager, String> updateUser;
}