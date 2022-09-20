package employee.generator;

public class Column {

	public String name;
	public Table table;
	public String title;
	public int type;
	public int length;
	public String propertyName;
	public String propertyType;
	public String methodName;
	public String relationPropertyName;
	public String relationMethodName;
	public String inputType;
	public boolean required;
	public String inputClass;
	public String inputSearchClass;
	public String fieldModel;
	public String fieldModelGetter;
	public String checkNull;
	public boolean activeOrDateOrUser;
	
	public boolean primaryKey;
	public Table relationTable;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getRelationPropertyName() {
		return relationPropertyName;
	}
	public void setRelationPropertyName(String relationPropertyName) {
		this.relationPropertyName = relationPropertyName;
	}
	public String getRelationMethodName() {
		return relationMethodName;
	}
	public void setRelationMethodName(String relationMethodName) {
		this.relationMethodName = relationMethodName;
	}
	public String getInputType() {
		return inputType;
	}
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public String getInputClass() {
		return inputClass;
	}
	public void setInputClass(String inputClass) {
		this.inputClass = inputClass;
	}
	public String getInputSearchClass() {
		return inputSearchClass;
	}
	public void setInputSearchClass(String inputSearchClass) {
		this.inputSearchClass = inputSearchClass;
	}
	public String getFieldModel() {
		return fieldModel;
	}
	public void setFieldModel(String fieldModel) {
		this.fieldModel = fieldModel;
	}
	public String getFieldModelGetter() {
		return fieldModelGetter;
	}
	public void setFieldModelGetter(String fieldModelGetter) {
		this.fieldModelGetter = fieldModelGetter;
	}
	public boolean isPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	public Table getRelationTable() {
		return relationTable;
	}
	public void setRelationTable(Table relationTable) {
		this.relationTable = relationTable;
	}
	public String getCheckNull() {
		return checkNull;
	}
	public void setCheckNull(String checkNull) {
		this.checkNull = checkNull;
	}
	public boolean isActiveOrDateOrUser() {
		return activeOrDateOrUser;
	}
	public void setActiveOrDateOrUser(boolean activeOrDateOrUser) {
		this.activeOrDateOrUser = activeOrDateOrUser;
	}
}
