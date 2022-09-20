<%@ taglib prefix="s" uri="/struts-tags" %>

<h4 class="pb-2 mt-4 mb-3 border-bottom">
	<s:if test="employee.id == null">
		Add Employee
	</s:if>
	<s:if test="employee.id != null">
		Edit Employee
	</s:if>
</h4>

<s:form id="form" action="saveEmployee">

	<div class="card mt-4">
		<div class="card-header fw-bold">
			Employee Details
		</div>
		<div class="card-body">
		
			<div class="row">
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeCpr" class="form-label">Cpr</label>
						<s:textfield id="employeeCpr" name="employee.cpr" type="tel" class="form-control is-valid cpr" placeholder="Cpr" maxlength="9" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeName" class="form-label">Name</label>
						<s:textfield id="employeeName" name="employee.name" type="text" class="form-control is-valid name" placeholder="Name" maxlength="255" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeAge" class="form-label">Age</label>
						<s:textfield id="employeeAge" name="employee.age" type="tel" class="form-control is-valid age" placeholder="Age" maxlength="2" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeEmail" class="form-label">Email</label>
						<s:textfield id="employeeEmail" name="employee.email" type="text" class="form-control is-valid email" placeholder="Email" maxlength="255" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeGender" class="form-label">Gender</label>
						<s:textfield id="employeeGender" name="employee.gender" type="text" class="form-control is-valid" placeholder="Gender" maxlength="1" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeMobile" class="form-label">Mobile</label>
						<s:textfield id="employeeMobile" name="employee.mobile" type="tel" class="form-control is-valid mobile" placeholder="Mobile" maxlength="8" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeSalary" class="form-label">Salary</label>
						<s:textfield id="employeeSalary" name="employee.salary" type="number" class="form-control is-valid" placeholder="Salary" maxlength="17" autocomplete="off" />
					</div>
				</div>
			</div>
		
		</div>
	</div>
	
	<div class="card mt-4">
		<div class="card-header fw-bold">
			Address Details
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressBuilding" class="form-label">Building</label>
						<s:textfield id="addressBuilding" name="employee.address.building" type="tel" class="form-control is-valid" placeholder="Building" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressRoad" class="form-label">Road</label>
						<s:textfield id="addressRoad" name="employee.address.road" type="tel" class="form-control is-valid" placeholder="Road" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressBlock" class="form-label">Block</label>
						<s:textfield id="addressBlock" name="employee.address.block" type="tel" class="form-control is-valid" placeholder="Block" maxlength="10" autocomplete="off" />
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="card mt-4">
		<div class="card-header fw-bold">
			Certificate List
		</div>
		<div class="table-responsive">
			<table id="certificateList" class="table table-striped">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							Title
						</th>
						<th>
							Year
						</th>
						<th>
							<button type="button" class="btn btn-dark" onclick="addCertificate()">Add</button>
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="employee.certificates" status="status">
					<s:if test="active">
					<tr>
						<td>
							<label class="index">
								<s:property value="#status.count"/>
							</label>
							<s:hidden name="employee.certificates[%{#status.index}].id" />
							<s:hidden name="employee.certificates[%{#status.index}].active" class="certificatesActives" />
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="title" name="employee.certificates[%{#status.index}].title" type="text" class="form-control is-valid" placeholder="Title" maxlength="200" autocomplete="off" />
							</div>
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="year" name="employee.certificates[%{#status.index}].year" type="tel" class="form-control is-valid" placeholder="Year" maxlength="10" autocomplete="off" />
							</div>
						</td>
						<th>
							<button type="button" class="btn btn-dark" onclick="addCertificate(parentNode.parentNode.rowIndex -1)">+</button>
							<button type="button" class="btn btn-dark" onclick="deleteCertificate(parentNode.parentNode.rowIndex -1)">-</button>
						</th>
					</tr>
					</s:if>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="text-center mt-4">
		<s:a class="btn btn-dark" onclick="submitForm(); return false;">
			<s:if test="employee.id == null">
				Add Employee
			</s:if>
			<s:if test="employee.id != null">
				Update Employee
			</s:if>
		</s:a>
		<s:a class="btn btn-dark" action="/">Close</s:a>
	</div>
	
	<div class="modal fade" id="confirmModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">
						<s:if test="employee.id == null">
							Add Employee
						</s:if>
						<s:if test="employee.id != null">
							Update Employee
						</s:if>
					</h5>
					<button class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<h4>
						<s:if test="employee.id == null">
							Are you sure to add Employee
						</s:if>
						<s:if test="employee.id != null">
							Are you sure to update Employee
						</s:if>
					</h4>
				</div>
				<div class="modal-footer">
					<s:submit id="confirmBtn" class="btn btn-dark" value="%{employee.id == null ? 'Add' : 'Update'}" />
					<a class="btn btn-dark" data-bs-dismiss="modal">Close</a>
				</div>
			</div>
		</div>
	</div>
	
	<s:hidden id="employeeId" name="employee.id" />
	<s:hidden name="employee.address.id" />
	
	<script>
		
		function addCertificate(index){
			
			if(index == null){
				
				index = $("#certificateList tbody tr").length;
			}
			
			var row = "";
			
			row += "<tr>";
			row += "	<td>";
			row += "		<label class='index'>" + (index + 1) + "</label>";
			row += "	</td>";
			row += "	<td>";
			row += "		<input name='employee.certificates[" + index + "].title' type='text' class='form-control is-valid certificatesTitles required' placeholder='Title'>";
			row += "	</td>";
			row += "	<td>";
			row += "		<input name='employee.certificates[" + index + "].year' type='tel' class='form-control is-valid certificatesYears' placeholder='Year'>";
			row += "	</td>";
			row += "	<td>";
			row += "		<input type='button' class='btn btn-dark' onclick='addCertificate(parentNode.parentNode.rowIndex - 1);' value='+' />";
			row += "		<input type='button' class='btn btn-dark' onclick='deleteCertificate(parentNode.parentNode.rowIndex - 1);' value='-' />";
			row += "	</td>";
			row += "</tr>";
			
			if(index == $("#certificateList tbody tr").length){
				$("#certificateList tbody").append(row);
			}else{
				$("#certificateList tbody tr").eq(index).before(row);
			}
			
			$("#certificateList tbody tr:visible").each(function(index){
				
				$(this).find(".index").html(index + 1);
			});
			
			$(".certificatesTitles").each(function(index){
				
				$(this).attr("name", "employee.certificates[" + index + "].title");
			});
			
			$(".certificatesYears").each(function(index){
				
				$(this).attr("name", "employee.certificates[" + index + "].year");
			});
		}
		
		function deleteCertificate(index){
			
			if($("#employeeId").val() == ""){
				$("#certificateList tbody tr").eq(index).remove();
			}else{
				$("#certificateList tbody tr").eq(index).hide();
				$(".certificatesActives").eq(index).val(false);
			}
			
			$("#certificateList tbody tr:visible").each(function(index){
				
				$(this).find(".index").html(index + 1);
			});
			
			$(".certificatesTitles").each(function(index){
				
				$(this).attr("name", "employee.certificates[" + index + "].title");
			});
			
			$(".certificatesYears").each(function(index){
				
				$(this).attr("name", "employee.certificates[" + index + "].year");
			});
		}
		
		$("#certificateList tbody tr:visible").each(function(index){
			
			$(this).find(".index").html(index + 1);
		});
		
		function submitForm(){
			
			if(isValidForm()){
				
				$("#confirmModal").modal("show");
			}
		}
		
	</script>
</s:form>