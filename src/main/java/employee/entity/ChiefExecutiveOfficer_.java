package employee.entity;


import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ChiefExecutiveOfficer.class)
public class ChiefExecutiveOfficer_ extends Manager_ {

	public static volatile SingularAttribute<ChiefExecutiveOfficer, Manager> id;
	public static volatile SingularAttribute<ChiefExecutiveOfficer, String> sector;
}