<%@ taglib prefix="s" uri="/struts-tags" %>

<h4 class="pb-2 mt-4 mb-3 border-bottom">
	<s:if test="manager.id == null">
		Add Manager
	</s:if>
	<s:if test="manager.id != null">
		Edit Manager
	</s:if>
</h4>

<s:form id="form" action="saveManager">

	<div class="card mt-4">
		<div class="card-header fw-bold">
			Manager Details
		</div>
		<div class="card-body">
		
			<div class="row">
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="managerDegree" class="form-label">Degree</label>
						<s:textfield id="managerDegree" name="manager.degree" type="tel" class="form-control is-valid" placeholder="Degree" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="managerAllowance" class="form-label">Allowance</label>
						<s:textfield id="managerAllowance" name="manager.allowance" type="number" class="form-control is-valid" placeholder="Allowance" maxlength="17" autocomplete="off" />
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
						<s:textfield id="employeeCpr" name="manager.id.cpr" type="tel" class="form-control is-valid cpr" placeholder="Cpr" maxlength="9" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeName" class="form-label">Name</label>
						<s:textfield id="employeeName" name="manager.id.name" type="text" class="form-control is-valid name" placeholder="Name" maxlength="255" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeAge" class="form-label">Age</label>
						<s:textfield id="employeeAge" name="manager.id.age" type="tel" class="form-control is-valid age" placeholder="Age" maxlength="2" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeEmail" class="form-label">Email</label>
						<s:textfield id="employeeEmail" name="manager.id.email" type="text" class="form-control is-valid email" placeholder="Email" maxlength="255" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeGender" class="form-label">Gender</label>
						<s:textfield id="employeeGender" name="manager.id.gender" type="text" class="form-control is-valid" placeholder="Gender" maxlength="1" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeMobile" class="form-label">Mobile</label>
						<s:textfield id="employeeMobile" name="manager.id.mobile" type="tel" class="form-control is-valid mobile" placeholder="Mobile" maxlength="8" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="employeeSalary" class="form-label">Salary</label>
						<s:textfield id="employeeSalary" name="manager.id.salary" type="number" class="form-control is-valid" placeholder="Salary" maxlength="17" autocomplete="off" />
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
							Employee Id
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
					<s:iterator value="manager.certificates" status="status">
					<s:if test="active">
					<tr>
						<td>
							<label class="index">
								<s:property value="#status.count"/>
							</label>
							<s:hidden name="manager.certificates[%{#status.index}].id" />
							<s:hidden name="manager.certificates[%{#status.index}].active" class="certificatesActives" />
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="employeeId" name="manager.certificates[%{#status.index}].employeeId" type="tel" class="form-control is-valid" placeholder="Employee Id" maxlength="10" autocomplete="off" />
							</div>
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="title" name="manager.certificates[%{#status.index}].title" type="text" class="form-control is-valid" placeholder="Title" maxlength="200" autocomplete="off" />
							</div>
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="year" name="manager.certificates[%{#status.index}].year" type="tel" class="form-control is-valid" placeholder="Year" maxlength="10" autocomplete="off" />
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
			<s:if test="manager.id == null">
				Add Manager
			</s:if>
			<s:if test="manager.id != null">
				Update Manager
			</s:if>
		</s:a>
		<s:a class="btn btn-dark" action="/">Close</s:a>
	</div>
	
	<div class="modal fade" id="confirmModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">
						<s:if test="manager.id == null">
							Add Manager
						</s:if>
						<s:if test="manager.id != null">
							Update Manager
						</s:if>
					</h5>
					<button class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<h4>
						<s:if test="manager.id == null">
							Are you sure to add Manager
						</s:if>
						<s:if test="manager.id != null">
							Are you sure to update Manager
						</s:if>
					</h4>
				</div>
				<div class="modal-footer">
					<s:submit id="confirmBtn" class="btn btn-dark" value="%{manager.id == null ? 'Add' : 'Update'}" />
					<a class="btn btn-dark" data-bs-dismiss="modal">Close</a>
				</div>
			</div>
		</div>
	</div>
	
	<s:hidden id="managerId" name="manager.id" />
	<s:hidden name="manager.address.id" />
	
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
			row += "		<input name='manager.certificates[" + index + "].title' type='text' class='form-control is-valid certificatesTitles required' placeholder='Title'>";
			row += "	</td>";
			row += "	<td>";
			row += "		<input name='manager.certificates[" + index + "].year' type='tel' class='form-control is-valid certificatesYears' placeholder='Year'>";
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
				
				$(this).attr("name", "manager.certificates[" + index + "].title");
			});
			
			$(".certificatesYears").each(function(index){
				
				$(this).attr("name", "manager.certificates[" + index + "].year");
			});
		}
		
		function deleteCertificate(index){
			
			if($("#managerId").val() == ""){
				$("#certificateList tbody tr").eq(index).remove();
			}else{
				$("#certificateList tbody tr").eq(index).hide();
				$(".certificatesActives").eq(index).val(false);
			}
			
			$("#certificateList tbody tr:visible").each(function(index){
				
				$(this).find(".index").html(index + 1);
			});
			
			$(".certificatesTitles").each(function(index){
				
				$(this).attr("name", "manager.certificates[" + index + "].title");
			});
			
			$(".certificatesYears").each(function(index){
				
				$(this).attr("name", "manager.certificates[" + index + "].year");
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