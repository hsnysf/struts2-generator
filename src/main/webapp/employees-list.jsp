<%@ taglib prefix="s" uri="/struts-tags" %>

<h4 class="pb-2 mt-4 mb-3 border-bottom">
	Employee Management
</h4>

<s:form id="form" action="searchEmployees">
	<div class="card">
		<div class="card-header fw-bold">
			Employee Search
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeIdSearch" class="form-label">Employee Id</label>
						<s:textfield id="employeeIdSearch" name="employeeSearch.id" type="tel" class="form-control is-valid" placeholder="Employee Id" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeCprSearch" class="form-label">Employee Cpr</label>
						<s:textfield id="employeeCprSearch" name="employeeSearch.cpr" type="tel" class="form-control is-valid cpr" placeholder="Employee Cpr" maxlength="9" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeNameSearch" class="form-label">Employee Name</label>
						<s:textfield id="employeeNameSearch" name="employeeSearch.name" type="text" class="form-control is-valid name" placeholder="Employee Name" maxlength="255" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeAgeSearch" class="form-label">Employee Age</label>
						<s:textfield id="employeeAgeSearch" name="employeeSearch.age" type="tel" class="form-control is-valid age" placeholder="Employee Age" maxlength="2" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeEmailSearch" class="form-label">Employee Email</label>
						<s:textfield id="employeeEmailSearch" name="employeeSearch.email" type="text" class="form-control is-valid email" placeholder="Employee Email" maxlength="255" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeGenderSearch" class="form-label">Employee Gender</label>
						<s:textfield id="employeeGenderSearch" name="employeeSearch.gender" type="text" class="form-control is-valid" placeholder="Employee Gender" maxlength="1" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeMobileSearch" class="form-label">Employee Mobile</label>
						<s:textfield id="employeeMobileSearch" name="employeeSearch.mobile" type="tel" class="form-control is-valid mobile" placeholder="Employee Mobile" maxlength="8" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeSalarySearch" class="form-label">Employee Salary</label>
						<s:textfield id="employeeSalarySearch" name="employeeSearch.salary" type="number" class="form-control is-valid" placeholder="Employee Salary" maxlength="17" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressIdSearch" class="form-label">Address Id</label>
						<s:textfield id="addressIdSearch" name="employeeSearch.address.id" type="tel" class="form-control is-valid" placeholder="Address Id" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressBuildingSearch" class="form-label">Address Building</label>
						<s:textfield id="addressBuildingSearch" name="employeeSearch.address.building" type="tel" class="form-control is-valid" placeholder="Address Building" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressRoadSearch" class="form-label">Address Road</label>
						<s:textfield id="addressRoadSearch" name="employeeSearch.address.road" type="tel" class="form-control is-valid" placeholder="Address Road" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressBlockSearch" class="form-label">Address Block</label>
						<s:textfield id="addressBlockSearch" name="employeeSearch.address.block" type="tel" class="form-control is-valid" placeholder="Address Block" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="cityIdSearch" class="form-label">City Id</label>
						<s:textfield id="cityIdSearch" name="employeeSearch.address.city.id" type="tel" class="form-control is-valid" placeholder="City Id" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="cityNameSearch" class="form-label">City Name</label>
						<s:textfield id="cityNameSearch" name="employeeSearch.address.city.name" type="text" class="form-control is-valid name" placeholder="City Name" maxlength="100" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="cityActiveSearch" class="form-label">City Active</label>
						<s:select id="cityActiveSearch" list="#{null:'Active', true:'Yes', false:'No'}" name="employeeSearch.address.city.active" class="form-control is-valid" placeholder="City Active" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressActiveSearch" class="form-label">Address Active</label>
						<s:select id="addressActiveSearch" list="#{null:'Active', true:'Yes', false:'No'}" name="employeeSearch.address.active" class="form-control is-valid" placeholder="Address Active" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeActiveSearch" class="form-label">Employee Active</label>
						<s:select id="employeeActiveSearch" list="#{null:'Active', true:'Yes', false:'No'}" name="employeeSearch.active" class="form-control is-valid" placeholder="Employee Active" autocomplete="off" />
					</div>
				</div>
			</div>
		</div>
		<div class="card-footer text-center">
			<s:submit class="btn btn-dark" value="Search" onclick="first(); return isValidForm();"/>
		</div>
	</div>
				
	<div class="card mt-4">
		<div class="card-header fw-bold">
			Employee List
		</div>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							Employee Id
						</th>
						<th>
							Employee Cpr
						</th>
						<th>
							Employee Name
						</th>
						<th>
							Employee Age
						</th>
						<th>
							Employee Email
						</th>
						<th>
							Employee Gender
						</th>
						<th>
							Employee Mobile
						</th>
						<th>
							Employee Salary
						</th>
						<th>
							Address Id
						</th>
						<th>
							Address Building
						</th>
						<th>
							Address Road
						</th>
						<th>
							Address Block
						</th>
						<th>
							City Id
						</th>
						<th>
							City Name
						</th>
						<th>
							Employee Active
						</th>
						<th>
							Employee Creation Date
						</th>
						<th>
							Employee Creation User
						</th>
						<th>
							Employee Update Date
						</th>
						<th>
							Employee Update User
						</th>
						<th>
							<s:a class="btn btn-dark" action="toAddEmployee">Add</s:a>
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="employees" status="status">
					<tr>
						<td>
							<s:property value="#status.count"/>
						</td>
						<td>
							<s:property value="id"/>
						</td>
						<td>
							<s:property value="cpr"/>
						</td>
						<td>
							<s:property value="name"/>
						</td>
						<td>
							<s:property value="age"/>
						</td>
						<td>
							<s:property value="email"/>
						</td>
						<td>
							<s:property value="gender"/>
						</td>
						<td>
							<s:property value="mobile"/>
						</td>
						<td>
							<s:property value="salary"/>
						</td>
						<td>
							<s:property value="address.id"/>
						</td>
						<td>
							<s:property value="address.building"/>
						</td>
						<td>
							<s:property value="address.road"/>
						</td>
						<td>
							<s:property value="address.block"/>
						</td>
						<td>
							<s:property value="address.city.id"/>
						</td>
						<td>
							<s:property value="address.city.name"/>
						</td>
						<td>
							<s:property value="active ? 'Yes' : 'No'"/>
						</td>
						<td>
							<s:property value="creationDate"/>
						</td>
						<td>
							<s:property value="creationUser"/>
						</td>
						<td>
							<s:property value="updateDate"/>
						</td>
						<td>
							<s:property value="updateUser"/>
						</td>
						<td>
							<s:a class="btn btn-dark" action="toEditEmployee?employee.id=%{id}">Edit</s:a>
							<s:if test="!active">
							<s:a class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#activationModal" onclick="selectEmployee(%{id}, true)">Activate</s:a>
							</s:if>
							<s:if test="active">
							<s:a class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#activationModal" onclick="selectEmployee(%{id}, false)">Deactivate</s:a>
							</s:if>
						</td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
		<div class="card-footer">
			<div class="row">
				<div class="col-3 text-start">
					<s:if test="employeeSearch.pageNo != 1">
					<s:submit class="btn btn-dark" value="First" onclick="first()"/>
					<s:submit class="btn btn-dark" value="Previous" onclick="previous()"/>
					</s:if>
				</div>
				<div class="col-3 text-center">
					<label class="fw-bold">
						<div class="row">
							<div class="col">
								Rows:
							</div>
							<div class="col">
								<s:select name="employeeSearch.rowCount" list="{3, 5, 10, 15, 20}" class="form-control d-inline" onchange="first(); form.submit()"/>
							</div>
						</div>
					</label>
				</div>
				<div class="col-1 text-center">
					<label class="fw-bold pt-1">
						Total: <s:property value="employeeSearch.totalRows"/>
					</label>
				</div>
				<div class="col-2 text-center">
					<label class="fw-bold pt-1">
						Page <s:property value="employeeSearch.pageNo"/> of <s:property value="employeeSearch.pageCount"/>
					</label>
				</div>
				<div class="col-3 text-end">
					<s:if test="employeeSearch.pageNo != employeeSearch.pageCount">
					<s:submit class="btn btn-dark" value="Next" onclick="next()"/>
					<s:submit class="btn btn-dark" value="Last" onclick="last()"/>
					</s:if>
				</div>
			</div>
		</div>
	</div>
	<s:hidden id="pageNo" name="employeeSearch.pageNo" />
	<s:hidden id="pageCount" name="employeeSearch.pageCount" />
	
	<s:hidden id="employeeId" name="employee.id" />
	<s:hidden id="active" name="employee.active" />
	
	<div class="modal fade" id="activationModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 id="activationTitle" class="modal-title"></h5>
					<button class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<h4 id="activationMessage"></h4>
				</div>
				<div class="modal-footer">
					<s:submit id="confirmBtn" class="btn btn-dark" onclick="updateEmployeeActive()"/>
					<a class="btn btn-dark" data-bs-dismiss="modal">Close</a>
				</div>
			</div>
		</div>
	</div>
			
	<script>
	
		function first(){
			
			$("#pageNo").val(1);
		}
		
		function previous(){
			
			$("#pageNo").val(Number($("#pageNo").val()) - 1);
		}
		
		function next(){
			
			$("#pageNo").val(Number($("#pageNo").val()) + 1);
		}
		
		function last(){
			
			$("#pageNo").val($("#pageCount").val());
		}
		
		function selectEmployee(employeeId, active){
			
			$("#employeeId").val(employeeId);
			$("#active").val(active);
			
			if(active){
				
				$("#activationTitle").html("Activate Employee");
				$("#activationMessage").html("Are you sure to activate Employee");
				$("#confirmBtn").val("Activate");
				
			}else{
				
				$("#activationTitle").html("Deactivate Employee");
				$("#activationMessage").html("Are you sure to deactivate Employee");
				$("#confirmBtn").val("Deactivate");
			}
		}
		
		function updateEmployeeActive(){
			
			$("#form").attr("action", "updateEmployeeActive");
		}
	</script>
</s:form>