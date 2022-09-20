package employee.generator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Table {

	public String name;
	public String title;
	public String className;
	public String propertyName;
	public boolean hasSqlDate;
	public boolean hasSqlTimestamp;
	public boolean hasSqlTime;
	public boolean hasBigDecimal;
	public boolean hasSqlArray;
	
	public Column primaryColumn;
	public boolean hasImportedKeys;
	
	public Table parentTable;
	public boolean hasChildTables;
	
	public Map<String, Column> columns = new LinkedHashMap<String, Column>();
	public List<Column> nestedColumns = new ArrayList<Column>();
	public List<Column> importedKeys = new ArrayList<Column>();
	public List<Column> nestedImportedKeys = new ArrayList<Column>();
	public List<Column> exportedKeys = new ArrayList<Column>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public boolean isHasSqlDate() {
		return hasSqlDate;
	}
	public void setHasSqlDate(boolean hasSqlDate) {
		this.hasSqlDate = hasSqlDate;
	}
	public boolean isHasSqlTimestamp() {
		return hasSqlTimestamp;
	}
	public void setHasSqlTimestamp(boolean hasSqlTimestamp) {
		this.hasSqlTimestamp = hasSqlTimestamp;
	}
	public boolean isHasSqlTime() {
		return hasSqlTime;
	}
	public void setHasSqlTime(boolean hasSqlTime) {
		this.hasSqlTime = hasSqlTime;
	}
	public boolean isHasBigDecimal() {
		return hasBigDecimal;
	}
	public void setHasBigDecimal(boolean hasBigDecimal) {
		this.hasBigDecimal = hasBigDecimal;
	}
	public boolean isHasSqlArray() {
		return hasSqlArray;
	}
	public void setHasSqlArray(boolean hasSqlArray) {
		this.hasSqlArray = hasSqlArray;
	}
	public Column getPrimaryColumn() {
		return primaryColumn;
	}
	public void setPrimaryColumn(Column primaryColumn) {
		this.primaryColumn = primaryColumn;
	}
	public boolean isHasImportedKeys() {
		return hasImportedKeys;
	}
	public void setHasImportedKeys(boolean hasImportedKeys) {
		this.hasImportedKeys = hasImportedKeys;
	}
	public Table getParentTable() {
		return parentTable;
	}
	public void setParentTable(Table parentTable) {
		this.parentTable = parentTable;
	}
	public boolean isHasChildTables() {
		return hasChildTables;
	}
	public void setHasChildTables(boolean hasChildTables) {
		this.hasChildTables = hasChildTables;
	}
	public Map<String, Column> getColumns() {
		return columns;
	}
	public void setColumns(Map<String, Column> columns) {
		this.columns = columns;
	}
	public List<Column> getImportedKeys() {
		return importedKeys;
	}
	public void setImportedKeys(List<Column> importedKeys) {
		this.importedKeys = importedKeys;
	}
	public List<Column> getExportedKeys() {
		return exportedKeys;
	}
	public void setExportedKeys(List<Column> exportedKeys) {
		this.exportedKeys = exportedKeys;
	}

	public List<Column> getNestedColumns() {
		return nestedColumns;
	}
	public void setNestedColumns(List<Column> nestedColumns) {
		this.nestedColumns = nestedColumns;
	}
	
	public List<Column> getNestedImportedKeys() {
		return nestedImportedKeys;
	}
	public void setNestedImportedKeys(List<Column> nestedImportedKeys) {
		this.nestedImportedKeys = nestedImportedKeys;
	}
}
