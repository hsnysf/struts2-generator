<%@ taglib prefix="s" uri="/struts-tags" %>

<h4 class="pb-2 mt-4 mb-3 border-bottom">
	Certificate Management
</h4>

<s:form id="form" action="searchCertificates">
	<div class="card">
		<div class="card-header fw-bold">
			Certificate Search
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="certificateIdSearch" class="form-label">Certificate Id</label>
						<s:textfield id="certificateIdSearch" name="certificateSearch.id" type="tel" class="form-control is-valid" placeholder="Certificate Id" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeIdSearch" class="form-label">Employee Id</label>
						<s:textfield id="employeeIdSearch" name="certificateSearch.employee.id" type="tel" class="form-control is-valid" placeholder="Employee Id" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeCprSearch" class="form-label">Employee Cpr</label>
						<s:textfield id="employeeCprSearch" name="certificateSearch.employee.cpr" type="tel" class="form-control is-valid cpr" placeholder="Employee Cpr" maxlength="9" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeNameSearch" class="form-label">Employee Name</label>
						<s:textfield id="employeeNameSearch" name="certificateSearch.employee.name" type="text" class="form-control is-valid name" placeholder="Employee Name" maxlength="255" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeAgeSearch" class="form-label">Employee Age</label>
						<s:textfield id="employeeAgeSearch" name="certificateSearch.employee.age" type="tel" class="form-control is-valid age" placeholder="Employee Age" maxlength="2" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeEmailSearch" class="form-label">Employee Email</label>
						<s:textfield id="employeeEmailSearch" name="certificateSearch.employee.email" type="text" class="form-control is-valid email" placeholder="Employee Email" maxlength="255" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeGenderSearch" class="form-label">Employee Gender</label>
						<s:textfield id="employeeGenderSearch" name="certificateSearch.employee.gender" type="text" class="form-control is-valid" placeholder="Employee Gender" maxlength="1" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeMobileSearch" class="form-label">Employee Mobile</label>
						<s:textfield id="employeeMobileSearch" name="certificateSearch.employee.mobile" type="tel" class="form-control is-valid mobile" placeholder="Employee Mobile" maxlength="8" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeSalarySearch" class="form-label">Employee Salary</label>
						<s:textfield id="employeeSalarySearch" name="certificateSearch.employee.salary" type="number" class="form-control is-valid" placeholder="Employee Salary" maxlength="17" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressIdSearch" class="form-label">Address Id</label>
						<s:textfield id="addressIdSearch" name="certificateSearch.employee.address.id" type="tel" class="form-control is-valid" placeholder="Address Id" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressBuildingSearch" class="form-label">Address Building</label>
						<s:textfield id="addressBuildingSearch" name="certificateSearch.employee.address.building" type="tel" class="form-control is-valid" placeholder="Address Building" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressRoadSearch" class="form-label">Address Road</label>
						<s:textfield id="addressRoadSearch" name="certificateSearch.employee.address.road" type="tel" class="form-control is-valid" placeholder="Address Road" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressBlockSearch" class="form-label">Address Block</label>
						<s:textfield id="addressBlockSearch" name="certificateSearch.employee.address.block" type="tel" class="form-control is-valid" placeholder="Address Block" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="cityIdSearch" class="form-label">City Id</label>
						<s:textfield id="cityIdSearch" name="certificateSearch.employee.address.city.id" type="tel" class="form-control is-valid" placeholder="City Id" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="cityNameSearch" class="form-label">City Name</label>
						<s:textfield id="cityNameSearch" name="certificateSearch.employee.address.city.name" type="text" class="form-control is-valid name" placeholder="City Name" maxlength="100" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="cityActiveSearch" class="form-label">City Active</label>
						<s:select id="cityActiveSearch" list="#{null:'Active', true:'Yes', false:'No'}" name="certificateSearch.employee.address.city.active" class="form-control is-valid" placeholder="City Active" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressActiveSearch" class="form-label">Address Active</label>
						<s:select id="addressActiveSearch" list="#{null:'Active', true:'Yes', false:'No'}" name="certificateSearch.employee.address.active" class="form-control is-valid" placeholder="Address Active" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeActiveSearch" class="form-label">Employee Active</label>
						<s:select id="employeeActiveSearch" list="#{null:'Active', true:'Yes', false:'No'}" name="certificateSearch.employee.active" class="form-control is-valid" placeholder="Employee Active" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="certificateTitleSearch" class="form-label">Certificate Title</label>
						<s:textfield id="certificateTitleSearch" name="certificateSearch.title" type="text" class="form-control is-valid" placeholder="Certificate Title" maxlength="200" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="certificateYearSearch" class="form-label">Certificate Year</label>
						<s:textfield id="certificateYearSearch" name="certificateSearch.year" type="tel" class="form-control is-valid" placeholder="Certificate Year" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="certificateActiveSearch" class="form-label">Certificate Active</label>
						<s:select id="certificateActiveSearch" list="#{null:'Active', true:'Yes', false:'No'}" name="certificateSearch.active" class="form-control is-valid" placeholder="Certificate Active" autocomplete="off" />
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
			Certificate List
		</div>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							Certificate Id
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
							Certificate Title
						</th>
						<th>
							Certificate Year
						</th>
						<th>
							Certificate Active
						</th>
						<th>
							Certificate Creation Date
						</th>
						<th>
							Certificate Creation User
						</th>
						<th>
							Certificate Update Date
						</th>
						<th>
							Certificate Update User
						</th>
						<th>
							<s:a class="btn btn-dark" action="toAddCertificate">Add</s:a>
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="certificates" status="status">
					<tr>
						<td>
							<s:property value="#status.count"/>
						</td>
						<td>
							<s:property value="id"/>
						</td>
						<td>
							<s:property value="employee.id"/>
						</td>
						<td>
							<s:property value="employee.cpr"/>
						</td>
						<td>
							<s:property value="employee.name"/>
						</td>
						<td>
							<s:property value="employee.age"/>
						</td>
						<td>
							<s:property value="employee.email"/>
						</td>
						<td>
							<s:property value="employee.gender"/>
						</td>
						<td>
							<s:property value="employee.mobile"/>
						</td>
						<td>
							<s:property value="employee.salary"/>
						</td>
						<td>
							<s:property value="employee.address.id"/>
						</td>
						<td>
							<s:property value="employee.address.building"/>
						</td>
						<td>
							<s:property value="employee.address.road"/>
						</td>
						<td>
							<s:property value="employee.address.block"/>
						</td>
						<td>
							<s:property value="employee.address.city.id"/>
						</td>
						<td>
							<s:property value="employee.address.city.name"/>
						</td>
						<td>
							<s:property value="title"/>
						</td>
						<td>
							<s:property value="year"/>
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
							<s:a class="btn btn-dark" action="toEditCertificate?certificate.id=%{id}">Edit</s:a>
							<s:if test="!active">
							<s:a class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#activationModal" onclick="selectCertificate(%{id}, true)">Activate</s:a>
							</s:if>
							<s:if test="active">
							<s:a class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#activationModal" onclick="selectCertificate(%{id}, false)">Deactivate</s:a>
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
					<s:if test="certificateSearch.pageNo != 1">
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
								<s:select name="certificateSearch.rowCount" list="{3, 5, 10, 15, 20}" class="form-control d-inline" onchange="first(); form.submit()"/>
							</div>
						</div>
					</label>
				</div>
				<div class="col-1 text-center">
					<label class="fw-bold pt-1">
						Total: <s:property value="certificateSearch.totalRows"/>
					</label>
				</div>
				<div class="col-2 text-center">
					<label class="fw-bold pt-1">
						Page <s:property value="certificateSearch.pageNo"/> of <s:property value="certificateSearch.pageCount"/>
					</label>
				</div>
				<div class="col-3 text-end">
					<s:if test="certificateSearch.pageNo != certificateSearch.pageCount">
					<s:submit class="btn btn-dark" value="Next" onclick="next()"/>
					<s:submit class="btn btn-dark" value="Last" onclick="last()"/>
					</s:if>
				</div>
			</div>
		</div>
	</div>
	<s:hidden id="pageNo" name="certificateSearch.pageNo" />
	<s:hidden id="pageCount" name="certificateSearch.pageCount" />
	
	<s:hidden id="certificateId" name="certificate.id" />
	<s:hidden id="active" name="certificate.active" />
	
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
					<s:submit id="confirmBtn" class="btn btn-dark" onclick="updateCertificateActive()"/>
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
		
		function selectCertificate(certificateId, active){
			
			$("#certificateId").val(certificateId);
			$("#active").val(active);
			
			if(active){
				
				$("#activationTitle").html("Activate Certificate");
				$("#activationMessage").html("Are you sure to activate Certificate");
				$("#confirmBtn").val("Activate");
				
			}else{
				
				$("#activationTitle").html("Deactivate Certificate");
				$("#activationMessage").html("Are you sure to deactivate Certificate");
				$("#confirmBtn").val("Deactivate");
			}
		}
		
		function updateCertificateActive(){
			
			$("#form").attr("action", "updateCertificateActive");
		}
	</script>
</s:form>