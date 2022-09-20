<%@ taglib prefix="s" uri="/struts-tags" %>

<h4 class="pb-2 mt-4 mb-3 border-bottom">
	<s:if test="city.id == null">
		Add City
	</s:if>
	<s:if test="city.id != null">
		Edit City
	</s:if>
</h4>

<s:form id="form" action="saveCity">

	<div class="card mt-4">
		<div class="card-header fw-bold">
			City Details
		</div>
		<div class="card-body">
		
			<div class="row">
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="cityName" class="form-label">Name</label>
						<s:textfield id="cityName" name="city.name" type="text" class="form-control is-valid name" placeholder="Name" maxlength="100" autocomplete="off" />
					</div>
				</div>
			</div>
		
		</div>
	</div>
	
	
	<div class="card mt-4">
		<div class="card-header fw-bold">
			Address List
		</div>
		<div class="table-responsive">
			<table id="addressList" class="table table-striped">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							Building
						</th>
						<th>
							Road
						</th>
						<th>
							Block
						</th>
						<th>
							<button type="button" class="btn btn-dark" onclick="addAddress()">Add</button>
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="city.addresss" status="status">
					<s:if test="active">
					<tr>
						<td>
							<label class="index">
								<s:property value="#status.count"/>
							</label>
							<s:hidden name="city.addresss[%{#status.index}].id" />
							<s:hidden name="city.addresss[%{#status.index}].active" class="addresssActives" />
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="building" name="city.addresss[%{#status.index}].building" type="tel" class="form-control is-valid" placeholder="Building" maxlength="10" autocomplete="off" />
							</div>
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="road" name="city.addresss[%{#status.index}].road" type="tel" class="form-control is-valid" placeholder="Road" maxlength="10" autocomplete="off" />
							</div>
						</td>
						<td>
							<div class="mb-3">
								<s:textfield id="block" name="city.addresss[%{#status.index}].block" type="tel" class="form-control is-valid" placeholder="Block" maxlength="10" autocomplete="off" />
							</div>
						</td>
						<th>
							<button type="button" class="btn btn-dark" onclick="addAddress(parentNode.parentNode.rowIndex -1)">+</button>
							<button type="button" class="btn btn-dark" onclick="deleteAddress(parentNode.parentNode.rowIndex -1)">-</button>
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
			<s:if test="city.id == null">
				Add City
			</s:if>
			<s:if test="city.id != null">
				Update City
			</s:if>
		</s:a>
		<s:a class="btn btn-dark" action="/">Close</s:a>
	</div>
	
	<div class="modal fade" id="confirmModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">
						<s:if test="city.id == null">
							Add City
						</s:if>
						<s:if test="city.id != null">
							Update City
						</s:if>
					</h5>
					<button class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<h4>
						<s:if test="city.id == null">
							Are you sure to add City
						</s:if>
						<s:if test="city.id != null">
							Are you sure to update City
						</s:if>
					</h4>
				</div>
				<div class="modal-footer">
					<s:submit id="confirmBtn" class="btn btn-dark" value="%{city.id == null ? 'Add' : 'Update'}" />
					<a class="btn btn-dark" data-bs-dismiss="modal">Close</a>
				</div>
			</div>
		</div>
	</div>
	
	<s:hidden id="cityId" name="city.id" />
	<s:hidden name="city.address.id" />
	
	<script>
		
		function addAddress(index){
			
			if(index == null){
				
				index = $("#addressList tbody tr").length;
			}
			
			var row = "";
			
			row += "<tr>";
			row += "	<td>";
			row += "		<label class='index'>" + (index + 1) + "</label>";
			row += "	</td>";
			row += "	<td>";
			row += "		<input name='city.addresss[" + index + "].title' type='text' class='form-control is-valid addresssTitles required' placeholder='Title'>";
			row += "	</td>";
			row += "	<td>";
			row += "		<input name='city.addresss[" + index + "].year' type='tel' class='form-control is-valid addresssYears' placeholder='Year'>";
			row += "	</td>";
			row += "	<td>";
			row += "		<input type='button' class='btn btn-dark' onclick='addAddress(parentNode.parentNode.rowIndex - 1);' value='+' />";
			row += "		<input type='button' class='btn btn-dark' onclick='deleteAddress(parentNode.parentNode.rowIndex - 1);' value='-' />";
			row += "	</td>";
			row += "</tr>";
			
			if(index == $("#addressList tbody tr").length){
				$("#addressList tbody").append(row);
			}else{
				$("#addressList tbody tr").eq(index).before(row);
			}
			
			$("#addressList tbody tr:visible").each(function(index){
				
				$(this).find(".index").html(index + 1);
			});
			
			$(".addresssTitles").each(function(index){
				
				$(this).attr("name", "city.addresss[" + index + "].title");
			});
			
			$(".addresssYears").each(function(index){
				
				$(this).attr("name", "city.addresss[" + index + "].year");
			});
		}
		
		function deleteAddress(index){
			
			if($("#cityId").val() == ""){
				$("#addressList tbody tr").eq(index).remove();
			}else{
				$("#addressList tbody tr").eq(index).hide();
				$(".addresssActives").eq(index).val(false);
			}
			
			$("#addressList tbody tr:visible").each(function(index){
				
				$(this).find(".index").html(index + 1);
			});
			
			$(".addresssTitles").each(function(index){
				
				$(this).attr("name", "city.addresss[" + index + "].title");
			});
			
			$(".addresssYears").each(function(index){
				
				$(this).attr("name", "city.addresss[" + index + "].year");
			});
		}
		
		$("#addressList tbody tr:visible").each(function(index){
			
			$(this).find(".index").html(index + 1);
		});
		
		function submitForm(){
			
			if(isValidForm()){
				
				$("#confirmModal").modal("show");
			}
		}
		
	</script>
</s:form>