package employee.generator;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class DatabaseReader {

	//Get Connection to Postgres Database
	public static Connection getConnection() throws Exception{
		
		Class.forName("org.postgresql.Driver");
		
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
	}
	
	//Initialize Postgres Database Metadata
	static DatabaseMetaData databaseMetaData;

	static {

		try {

			Connection connection = getConnection();

			databaseMetaData = connection.getMetaData();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	//Get Table Name Configuration Mapping
	public static Map<String, Table> getTableMap() throws Exception {

		Map<String, Table> tableMap = new LinkedHashMap<String, Table>();
		
		//Get All Tables in Database
		ResultSet result = databaseMetaData.getTables(null, null, null, new String[] {"TABLE"});
		
		while (result.next()) {
			
			//Create Table Configuration Object
			Table table = new Table();
			
			//Get Table Name
			table.name = result.getString("table_name");
			//Get Table Title Equivalent example: person_details to Person Details
			table.title = getTableTitle(table.name);
			//Get Table Class Name Equivalent example: person_details to PersonDetails
			table.className = getTableClassName(table.name);
			//Get Table Class Object Name Equivalent example: person_details to personDetails
			table.propertyName = getTablePropertyName(table.name);
			
			//Get All Columns for Table Name
			ResultSet columnSet = databaseMetaData.getColumns(null, null, table.name, null);
			
			while (columnSet.next()) {
				
				Column column = new Column();
				
				//Get Column Name
				column.name = columnSet.getString("column_name");
				//Get Column Table
				column.table = table;
				//Get Column Types per java example: VARCHAR to String
				column.type = columnSet.getInt("data_type");
				//Get Column Title Equivalent example: prsn_last_name to Last Name
				column.title = getColumnTitle(column.name);
				//Get Column Method Name Equivalent example: prsn_last_name to LastName
				column.methodName = getColumnMethodName(column.name);
				//Get Column Property Name Equivalent example: prsn_last_name to lastName
				column.propertyName = getColumnPropertyName(column.name);
				//Get Property Data Type for Column Types per java
				column.propertyType = getColumnPropertyType(column.type);
				//Get Column Relation Property Name Equivalent example: prsn_home_address_id to homeAddress
				column.relationPropertyName = getRelationColumnPropertyName(column.name);
				//Get Column Relation Method Name Equivalent example: prsn_home_address_id to HomeAddress
				column.relationMethodName = getRelationColumnMethodName(column.name);
				//Get Column Property Name Equivalent example: prsn_last_name to lastName
				column.fieldModel = getColumnPropertyName(column.name);
				//Get Column Property Name Equivalent example: prsn_last_name to getLastName
				column.fieldModelGetter = "get" + column.methodName + "()";
				//Get Column Relation Property Name Equivalent example: prsn_home_address_id to homeAddress
				column.relationPropertyName = getRelationColumnPropertyName(column.name);
				//Get Column Length
				column.length = columnSet.getInt("column_size");
				//Get Column HTML Input type
				column.inputType = getColumnInputType(column.type);
				//Get Column Is Null value
				column.required = "NO".equals(columnSet.getString("is_nullable"));
				//Get Column Length
				column.length = getColumnLength(column);
				//Get Column HTML Input CSS Class for form
				column.inputClass = getColumnClassList(column, false);
				//Get Column HTML Input CSS Class for search
				column.inputSearchClass = getColumnClassList(column, true);
				
				if(column.propertyName.equals("creationDate")
						|| column.propertyName.equals("creationUser")
						|| column.propertyName.equals("updateDate")
						|| column.propertyName.equals("updateUser")
						|| column.propertyName.equals("active")) {
					column.activeOrDateOrUser = true;
				}
				
				//Check if column type is date so mark table as has column with date type
				if(column.type == Types.DATE) {
					table.hasSqlDate = true;
				//Check if column type is timestamp so mark table as has column with timestamp type
				}else if(column.type == Types.TIMESTAMP) {
					table.hasSqlTimestamp = true;
					//Check if column type is time so mark table as has column with time type
				}else if(column.type == Types.TIME) {
					table.hasSqlTime = true;
					//Check if column type is array so mark table as has column with array type
				}else if(column.type == Types.ARRAY) {
					table.hasSqlArray = true;
					//Check if column type is decimal so mark table as has column with decimal type
				}else if(column.type == Types.DECIMAL) {
					table.hasBigDecimal = true;
				//Check if column type is decimal so mark table as has column with decimal type
				}else if(column.type == Types.NUMERIC) {
					table.hasBigDecimal = true;
				}
				
				//Add Column Configuration To Table Column List
				table.columns.put(column.name, column);
			}
			
			//Add Table Configuration To List
			tableMap.put(table.name, table);
		}
		
		//Get Primary Key Column for each table
		for(Table table : tableMap.values()) {
			
			//Get Table Primary Key Column
			ResultSet primarySet = databaseMetaData.getPrimaryKeys(null, null, table.name);

			if (primarySet.next()) {

				String primaryColumn = primarySet.getString("column_name");
				
				//Get Column Configuration for Primary Key
				Column column = table.columns.get(primaryColumn);
				
				//Mark Column as Primary Key for Table
				column.primaryKey = true;
				
				//Mark Column as Primary Key for Table
				table.primaryColumn = column;
			}
			
			//Get Foreign Keys Columns for Table
			ResultSet importedKeysSet = databaseMetaData.getImportedKeys(null, null, table.name);
			
			while(importedKeysSet.next()) {
				
				//Get Current Table Foreign Column
				String columnName = importedKeysSet.getString("fkcolumn_name");
				
				//Get Relation Primary Table
				String relationTable = importedKeysSet.getString("pktable_name");
				
				//Get Current Table Foreign Column
				Column column = table.columns.get(columnName);
				
				//Point Relation Table of Foreign Column to Primary Key Table
				column.relationTable = tableMap.get(relationTable);
				
				//Mark Table as has Foreign keys with other tables only if Foreign columns are not primary
				if(!column.primaryKey) {
					table.hasImportedKeys = true;
				}
				
				table.importedKeys.add(column);
			}
		}
		
		//Get Primary Key Column for each table
		for(Table table : tableMap.values()) {
			
			//Mark Other Table as Parent of Current Table if Primary Key refer to that Table
			table.parentTable = table.primaryColumn.relationTable;
			
			//Get Foreign Keys Columns from other Tables
			ResultSet exportedKeysSet = databaseMetaData.getExportedKeys(null, null, table.name);

			while (exportedKeysSet.next()) {
				
				//Get Relation Primary Table
				String relationtable = exportedKeysSet.getString("fktable_name");
				//Get Relation Table Foreign Column
				String column = exportedKeysSet.getString("fkcolumn_name");
				
				//Get Relation Table Configuration
				Table relationTable = tableMap.get(relationtable);
				//Get Relation Table Foreign Column Configuration
				Column relationColumnConfig = relationTable.columns.get(column);
				
				//Mark Current Table with has Child Tables if Primary Column of Exported Table refer to Current Table
				if(relationTable.primaryColumn.relationTable == table) {
					table.hasChildTables = true;
				}else {
					//Get Relation Table & Column To Current Table Exported Relations if Column is not primary
					table.exportedKeys.add(relationColumnConfig);
				}
			}
		}
		
		//Get Primary Key Column for each table
		for(Table table : tableMap.values()) {
			
			table.nestedImportedKeys = getNestedImportedKeys(table);
			
			table.nestedColumns = getNestedColumns(table, "", table.propertyName + "Search.");
			
			if(table.parentTable != null) {
				
				table.exportedKeys.addAll(table.parentTable.exportedKeys);
			}
		}
				
		return tableMap;
	}
	
	//Get Table Class Name Equivalent example: person_details to Person Details
	public static String getTableTitle(String name) {

		char[] chars = name.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (i == 0 || chars[i - 1] == '_') {
				chars[i] = Character.toUpperCase(chars[i]);
			} else {
				chars[i] = Character.toLowerCase(chars[i]);
			}
		}

		name = new String(chars);
		name = name.replaceAll("_", " ");

		return name;
	}
	
	//Get Table Class Name Equivalent example: person_details to PersonDetails
	public static String getTableClassName(String name) {

		char[] chars = name.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (i == 0 || chars[i - 1] == '_') {
				chars[i] = Character.toUpperCase(chars[i]);
			} else {
				chars[i] = Character.toLowerCase(chars[i]);
			}
		}

		name = new String(chars);
		name = name.replaceAll("_", "");

		return name;
	}
	
	//Get Table Property Name Equivalent example: person_details to personDetails
	public static String getTablePropertyName(String name) {

		char[] chars = name.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (i == 0 || chars[i - 1] != '_') {
				chars[i] = Character.toLowerCase(chars[i]);
			} else {
				chars[i] = Character.toUpperCase(chars[i]);
			}
		}

		name = new String(chars);
		name = name.replaceAll("_", "");

		return name;
	}
	
	//Get Column Title Equivalent example: prsn_last_name to Last Name
	public static String getColumnTitle(String name) {

		int index = name.indexOf("_");

		if (index != -1) {
			name = name.substring(index + 1);
		}

		char[] chars = name.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (i == 0 || chars[i - 1] == '_') {
				chars[i] = Character.toUpperCase(chars[i]);
			} else {
				chars[i] = Character.toLowerCase(chars[i]);
			}
		}

		name = new String(chars);
		name = name.replaceAll("_", " ");

		return name;
	}
	
	public static int getColumnLength(Column column) {
		
		if (column.propertyName.toUpperCase().contains("CPR")) {
			return 9;
		} else if (column.propertyName.toUpperCase().contains("MOBILE")) {
			return 8;
		} else if (column.propertyName.toUpperCase().contains("AGE")) {
			return 2;
		}
		
		return column.length;
	}
	
	//Get Column Property Name Equivalent example: prsn_last_name to lastName
	public static String getColumnPropertyName(String name) {

		int index = name.indexOf("_") + 1;

		if (index != 0) {
			name = name.substring(index);
		}

		char[] chars = name.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (i != 0 && chars[i - 1] == '_') {
				chars[i] = Character.toUpperCase(chars[i]);
			} else {
				chars[i] = Character.toLowerCase(chars[i]);
			}
		}

		name = new String(chars);
		name = name.replaceAll("_", "");

		return name;
	}
	
	//Get Column Method Name Equivalent example: prsn_last_name to LastName
	public static String getColumnMethodName(String name) {

		int index = name.indexOf("_");

		if (index != -1) {
			name = name.substring(index + 1);
		}

		char[] chars = name.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (i == 0 || chars[i - 1] == '_') {
				chars[i] = Character.toUpperCase(chars[i]);
			} else {

				chars[i] = Character.toLowerCase(chars[i]);
			}
		}

		name = new String(chars);
		name = name.replaceAll("_", "");

		return name;
	}
	
	//Get Relation Column Method Name Equivalent example: prsn_home_address_id to HomeAddress
	public static String getRelationColumnMethodName(String name) {

		int index = name.indexOf("_");

		if (index != -1) {
			name = name.substring(index + 1);
		}

		int lastIndex = name.lastIndexOf("_");

		if (lastIndex != -1) {
			name = name.substring(0, lastIndex);
		}

		char[] chars = name.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (i == 0 || chars[i - 1] == '_') {
				chars[i] = Character.toUpperCase(chars[i]);
			} else {
				chars[i] = Character.toLowerCase(chars[i]);
			}
		}

		name = new String(chars);
		name = name.replaceAll("_", "");

		return name;
	}
	
	//Get Column Property Type Equivalent Data Type example: VARCHAR to String
	public static String getColumnPropertyType(int columnType) {

		if (columnType == Types.VARCHAR) {
			return "String";
		}else if (columnType == Types.CHAR) {
			return "String";
		}else if (columnType == Types.SMALLINT) {
			return "Short";
		}else if (columnType == Types.INTEGER) {
			return "Integer";
		} else if (columnType == Types.BIGINT) {
			return "Long";
		}else if (columnType == Types.FLOAT) {
			return "Float";
		}else if (columnType == Types.REAL) {
			return "Float";
		}else if (columnType == Types.DOUBLE) {
			return "Double";
		}else if (columnType == Types.DECIMAL) {
			return "BigDecimal";
		}else if (columnType == Types.NUMERIC) {
			return "BigDecimal";
		}else if (columnType == Types.DATE) {
			return "Date";
		} else if (columnType == Types.TIMESTAMP) {
			return "Timestamp";
		}else if (columnType == Types.TIME) {
			return "Time";
		} else if (columnType == Types.BOOLEAN) {
			return "Boolean";
		} else if (columnType == Types.BIT) {
			return "Boolean";
		} else if (columnType == Types.ARRAY) {
			return "Array";
		} else {
			return "String";
		}
	}
	
	//Get Relation Column Property Name Equivalent example: prsn_home_address_id to homeAddress
	public static String getRelationColumnPropertyName(String name) {

		int index = name.indexOf("_");

		if (index != -1) {
			name = name.substring(index + 1);
		}

		int lastIndex = name.lastIndexOf("_");

		if (lastIndex != -1) {
			name = name.substring(0, lastIndex);
		}

		char[] chars = name.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (i != 0 && chars[i - 1] == '_') {
				chars[i] = Character.toUpperCase(chars[i]);
			} else {
				chars[i] = Character.toLowerCase(chars[i]);
			}
		}

		name = new String(chars);
		name = name.replaceAll("_", "");

		return name;
	}
	
	//Get Column Property Type Equivalent Data Type example: VARCHAR to String
	public static String getColumnInputType(int columnType) {

		if (columnType == Types.VARCHAR) {
			return "text";
		}else if (columnType == Types.CHAR) {
			return "text";
		}else if (columnType == Types.SMALLINT) {
			return "tel";
		}else if (columnType == Types.INTEGER) {
			return "tel";
		} else if (columnType == Types.BIGINT) {
			return "tel";
		}else if (columnType == Types.FLOAT) {
			return "number";
		}else if (columnType == Types.REAL) {
			return "number";
		}else if (columnType == Types.DOUBLE) {
			return "number";
		}else if (columnType == Types.DECIMAL) {
			return "number";
		}else if (columnType == Types.NUMERIC) {
			return "number";
		}else if (columnType == Types.DATE) {
			return "text";
		} else if (columnType == Types.TIMESTAMP) {
			return "text";
		}else if (columnType == Types.TIME) {
			return "text";
		} else if (columnType == Types.BOOLEAN) {
			return "text";
		} else if (columnType == Types.BIT) {
			return "text";
		} else if (columnType == Types.ARRAY) {
			return "text";
		} else {
			return "text";
		}
	}
	
	public static String getColumnClassList(Column column, boolean search) {

		String className = "";

		List<String> classList = new ArrayList<String>();

		classList.add("form-control");
		classList.add("is-valid");

		if (column.propertyName.toUpperCase().contains("CPR")) {
			classList.add("cpr");
		} else if (column.propertyName.toUpperCase().contains("NAME")) {
			classList.add("name");
		}else if (column.propertyName.toUpperCase().contains("EMAIL")) {
			classList.add("email");
		} else if (column.propertyName.toUpperCase().contains("MOBILE")) {
			classList.add("mobile");
		} else if (column.propertyName.toUpperCase().contains("AGE")) {
			classList.add("age");
		}

		if (column.required && !search) {
			classList.add("required");
		}

		for (int i = 0; i < classList.size(); i++) {

			className += classList.get(i);

			if (i != classList.size() - 1) {
				className += " ";
			}
		}

		return className;
	}
	
	public static List<Column> getNestedImportedKeys(Table table) throws Exception{
		
		List<Column> nestedImportedKeys = new ArrayList<Column>();
		
		for(Column column : table.importedKeys) {
			
			nestedImportedKeys.add(column);
			
			nestedImportedKeys.addAll(getNestedImportedKeys(column.relationTable));
		}
		
		return nestedImportedKeys;
	}
	
	public static List<Column> getNestedColumns(Table table, String propertyName, String getterName) throws Exception{
		
		List<Column> columns = new ArrayList<Column>();
		
		for(Column column : table.columns.values()) {
			
			if(column.relationTable != null) {
				
				if(column.primaryKey) {
					
					columns.addAll(getNestedColumns(table.parentTable, propertyName, getterName));
				
				}else {
					
					String relationPropertyName = propertyName + column.relationPropertyName + ".";
					String relationGetterName = getterName + "get" + column.relationMethodName + "().";

					columns.addAll(getNestedColumns(column.relationTable, relationPropertyName, relationGetterName));
				}
				
			}else {
				
				Column copy = (Column) BeanUtils.cloneBean(column);
				copy.title = table.title + " " + copy.title;
				copy.fieldModel = propertyName + copy.propertyName;
				copy.fieldModelGetter = getterName + "get" + copy.methodName + "()";
				
				String tokens[] = copy.fieldModelGetter.split("\\.");
				
				copy.checkNull = "";
				
				String token = "";
				
				for(int i=0; i<tokens.length-1; i++) {
					
					if(i != 0) {
						copy.checkNull += " && ";
						token += ".";
					}
					
					token += tokens[i];
					
					copy.checkNull += (token + " != null");
				}
				
				columns.add(copy);
			}
		}
		
		return columns;
	}
}
