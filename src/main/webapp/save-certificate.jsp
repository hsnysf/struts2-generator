<%@ taglib prefix="s" uri="/struts-tags" %>

<h4 class="pb-2 mt-4 mb-3 border-bottom">
	<s:if test="certificate.id == null">
		Add Certificate
	</s:if>
	<s:if test="certificate.id != null">
		Edit Certificate
	</s:if>
</h4>

<s:form id="form" action="saveCertificate">

	<div class="card mt-4">
		<div class="card-header fw-bold">
			Certificate Details
		</div>
		<div class="card-body">
		
			<div class="row">
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="certificateTitle" class="form-label">Title</label>
						<s:textfield id="certificateTitle" name="certificate.title" type="text" class="form-control is-valid" placeholder="Title" maxlength="200" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="certificateYear" class="form-label">Year</label>
						<s:textfield id="certificateYear" name="certificate.year" type="tel" class="form-control is-valid" placeholder="Year" maxlength="10" autocomplete="off" />
					</div>
				</div>
			</div>
		
		</div>
	</div>
	
	<div class="card mt-4">
		<div class="card-header fw-bold">
			Employee Details
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeCpr" class="form-label">Cpr</label>
						<s:textfield id="employeeCpr" name="certificate.employee.cpr" type="tel" class="form-control is-valid cpr" placeholder="Cpr" maxlength="9" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeName" class="form-label">Name</label>
						<s:textfield id="employeeName" name="certificate.employee.name" type="text" class="form-control is-valid name" placeholder="Name" maxlength="255" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeAge" class="form-label">Age</label>
						<s:textfield id="employeeAge" name="certificate.employee.age" type="tel" class="form-control is-valid age" placeholder="Age" maxlength="2" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeEmail" class="form-label">Email</label>
						<s:textfield id="employeeEmail" name="certificate.employee.email" type="text" class="form-control is-valid email" placeholder="Email" maxlength="255" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeGender" class="form-label">Gender</label>
						<s:textfield id="employeeGender" name="certificate.employee.gender" type="text" class="form-control is-valid" placeholder="Gender" maxlength="1" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeMobile" class="form-label">Mobile</label>
						<s:textfield id="employeeMobile" name="certificate.employee.mobile" type="tel" class="form-control is-valid mobile" placeholder="Mobile" maxlength="8" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeSalary" class="form-label">Salary</label>
						<s:textfield id="employeeSalary" name="certificate.employee.salary" type="number" class="form-control is-valid" placeholder="Salary" maxlength="17" autocomplete="off" />
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="text-center mt-4">
		<s:a class="btn btn-dark" onclick="submitForm(); return false;">
			<s:if test="certificate.id == null">
				Add Certificate
			</s:if>
			<s:if test="certificate.id != null">
				Update Certificate
			</s:if>
		</s:a>
		<s:a class="btn btn-dark" action="/">Close</s:a>
	</div>
	
	<div class="modal fade" id="confirmModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">
						<s:if test="certificate.id == null">
							Add Certificate
						</s:if>
						<s:if test="certificate.id != null">
							Update Certificate
						</s:if>
					</h5>
					<button class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<h4>
						<s:if test="certificate.id == null">
							Are you sure to add Certificate
						</s:if>
						<s:if test="certificate.id != null">
							Are you sure to update Certificate
						</s:if>
					</h4>
				</div>
				<div class="modal-footer">
					<s:submit id="confirmBtn" class="btn btn-dark" value="%{certificate.id == null ? 'Add' : 'Update'}" />
					<a class="btn btn-dark" data-bs-dismiss="modal">Close</a>
				</div>
			</div>
		</div>
	</div>
	
	<s:hidden id="certificateId" name="certificate.id" />
	<s:hidden name="certificate.address.id" />
	
	<script>
		
		
		function submitForm(){
			
			if(isValidForm()){
				
				$("#confirmModal").modal("show");
			}
		}
		
	</script>
</s:form>