<%@ taglib prefix="s" uri="/struts-tags" %>

<h4 class="pb-2 mt-4 mb-3 border-bottom">
	<s:if test="address.id == null">
		Add Address
	</s:if>
	<s:if test="address.id != null">
		Edit Address
	</s:if>
</h4>

<s:form id="form" action="saveAddress">

	<div class="card mt-4">
		<div class="card-header fw-bold">
			Address Details
		</div>
		<div class="card-body">
		
			<div class="row">
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressBuilding" class="form-label">Building</label>
						<s:textfield id="addressBuilding" name="address.building" type="tel" class="form-control is-valid" placeholder="Building" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressRoad" class="form-label">Road</label>
						<s:textfield id="addressRoad" name="address.road" type="tel" class="form-control is-valid" placeholder="Road" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="addressBlock" class="form-label">Block</label>
						<s:textfield id="addressBlock" name="address.block" type="tel" class="form-control is-valid" placeholder="Block" maxlength="10" autocomplete="off" />
					</div>
				</div>
			</div>
		
		</div>
	</div>
	
	<div class="card mt-4">
		<div class="card-header fw-bold">
			City Details
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="cityName" class="form-label">Name</label>
						<s:textfield id="cityName" name="address.city.name" type="text" class="form-control is-valid name" placeholder="Name" maxlength="100" autocomplete="off" />
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="card mt-4">
		<div class="card-header fw-bold">
			Employee List
		</div>
		<div class="table-responsive">
			<table id="employeeList" class="table table-striped">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							Cpr
						</th>
						<th>
							Name
						</th>
						<th>
							Age
						</th>
						<th>
							Email
						</th>
						<th>
							Gender
						</th>
						<th>
							Mobile
						</th>
						<th>
							Salary
						</th>
						<th>
							<button type="button" class="btn btn-dark" onclick="addEmployee()">Add</button>
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="address.employees" status="status">
					<s:if test="active">
					<tr>
						<td>
							<label class="index">
								<s:property value="#status.count"/>
							</label>
							<s:hidden name="address.employees[%{#status.index}].id" />
							<s:hidden name="address.employees[%{#status.index}].active" class="employeesActives" />
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="cpr" name="address.employees[%{#status.index}].cpr" type="tel" class="form-control is-valid cpr" placeholder="Cpr" maxlength="9" autocomplete="off" />
							</div>
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="name" name="address.employees[%{#status.index}].name" type="text" class="form-control is-valid name" placeholder="Name" maxlength="255" autocomplete="off" />
							</div>
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="age" name="address.employees[%{#status.index}].age" type="tel" class="form-control is-valid age" placeholder="Age" maxlength="2" autocomplete="off" />
							</div>
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="email" name="address.employees[%{#status.index}].email" type="text" class="form-control is-valid email" placeholder="Email" maxlength="255" autocomplete="off" />
							</div>
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="gender" name="address.employees[%{#status.index}].gender" type="text" class="form-control is-valid" placeholder="Gender" maxlength="1" autocomplete="off" />
							</div>
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="mobile" name="address.employees[%{#status.index}].mobile" type="tel" class="form-control is-valid mobile" placeholder="Mobile" maxlength="8" autocomplete="off" />
							</div>
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="salary" name="address.employees[%{#status.index}].salary" type="number" class="form-control is-valid" placeholder="Salary" maxlength="17" autocomplete="off" />
							</div>
						</td>
						<th>
							<button type="button" class="btn btn-dark" onclick="addEmployee(parentNode.parentNode.rowIndex -1)">+</button>
							<button type="button" class="btn btn-dark" onclick="deleteEmployee(parentNode.parentNode.rowIndex -1)">-</button>
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
			<s:if test="address.id == null">
				Add Address
			</s:if>
			<s:if test="address.id != null">
				Update Address
			</s:if>
		</s:a>
		<s:a class="btn btn-dark" action="/">Close</s:a>
	</div>
	
	<div class="modal fade" id="confirmModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">
						<s:if test="address.id == null">
							Add Address
						</s:if>
						<s:if test="address.id != null">
							Update Address
						</s:if>
					</h5>
					<button class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<h4>
						<s:if test="address.id == null">
							Are you sure to add Address
						</s:if>
						<s:if test="address.id != null">
							Are you sure to update Address
						</s:if>
					</h4>
				</div>
				<div class="modal-footer">
					<s:submit id="confirmBtn" class="btn btn-dark" value="%{address.id == null ? 'Add' : 'Update'}" />
					<a class="btn btn-dark" data-bs-dismiss="modal">Close</a>
				</div>
			</div>
		</div>
	</div>
	
	<s:hidden id="addressId" name="address.id" />
	<s:hidden name="address.address.id" />
	
	<script>
		
		function addEmployee(index){
			
			if(index == null){
				
				index = $("#employeeList tbody tr").length;
			}
			
			var row = "";
			
			row += "<tr>";
			row += "	<td>";
			row += "		<label class='index'>" + (index + 1) + "</label>";
			row += "	</td>";
			row += "	<td>";
			row += "		<input name='address.employees[" + index + "].title' type='text' class='form-control is-valid employeesTitles required' placeholder='Title'>";
			row += "	</td>";
			row += "	<td>";
			row += "		<input name='address.employees[" + index + "].year' type='tel' class='form-control is-valid employeesYears' placeholder='Year'>";
			row += "	</td>";
			row += "	<td>";
			row += "		<input type='button' class='btn btn-dark' onclick='addEmployee(parentNode.parentNode.rowIndex - 1);' value='+' />";
			row += "		<input type='button' class='btn btn-dark' onclick='deleteEmployee(parentNode.parentNode.rowIndex - 1);' value='-' />";
			row += "	</td>";
			row += "</tr>";
			
			if(index == $("#employeeList tbody tr").length){
				$("#employeeList tbody").append(row);
			}else{
				$("#employeeList tbody tr").eq(index).before(row);
			}
			
			$("#employeeList tbody tr:visible").each(function(index){
				
				$(this).find(".index").html(index + 1);
			});
			
			$(".employeesTitles").each(function(index){
				
				$(this).attr("name", "address.employees[" + index + "].title");
			});
			
			$(".employeesYears").each(function(index){
				
				$(this).attr("name", "address.employees[" + index + "].year");
			});
		}
		
		function deleteEmployee(index){
			
			if($("#addressId").val() == ""){
				$("#employeeList tbody tr").eq(index).remove();
			}else{
				$("#employeeList tbody tr").eq(index).hide();
				$(".employeesActives").eq(index).val(false);
			}
			
			$("#employeeList tbody tr:visible").each(function(index){
				
				$(this).find(".index").html(index + 1);
			});
			
			$(".employeesTitles").each(function(index){
				
				$(this).attr("name", "address.employees[" + index + "].title");
			});
			
			$(".employeesYears").each(function(index){
				
				$(this).attr("name", "address.employees[" + index + "].year");
			});
		}
		
		$("#employeeList tbody tr:visible").each(function(index){
			
			$(this).find(".index").html(index + 1);
		});
		
		function submitForm(){
			
			if(isValidForm()){
				
				$("#confirmModal").modal("show");
			}
		}
		
	</script>
</s:form>