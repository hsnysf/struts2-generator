<%@ taglib prefix="s" uri="/struts-tags" %>

<h4 class="pb-2 mt-4 mb-3 border-bottom">
	City Management
</h4>

<s:form id="form" action="searchCitys">
	<div class="card">
		<div class="card-header fw-bold">
			City Search
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="cityIdSearch" class="form-label">City Id</label>
						<s:textfield id="cityIdSearch" name="citySearch.id" type="tel" class="form-control is-valid" placeholder="City Id" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="cityNameSearch" class="form-label">City Name</label>
						<s:textfield id="cityNameSearch" name="citySearch.name" type="text" class="form-control is-valid name" placeholder="City Name" maxlength="100" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="cityActiveSearch" class="form-label">City Active</label>
						<s:select id="cityActiveSearch" list="#{null:'Active', true:'Yes', false:'No'}" name="citySearch.active" class="form-control is-valid" placeholder="City Active" autocomplete="off" />
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
			City List
		</div>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							City Id
						</th>
						<th>
							City Name
						</th>
						<th>
							City Active
						</th>
						<th>
							City Creation Date
						</th>
						<th>
							City Creation User
						</th>
						<th>
							City Update Date
						</th>
						<th>
							City Update User
						</th>
						<th>
							<s:a class="btn btn-dark" action="toAddCity">Add</s:a>
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="citys" status="status">
					<tr>
						<td>
							<s:property value="#status.count"/>
						</td>
						<td>
							<s:property value="id"/>
						</td>
						<td>
							<s:property value="name"/>
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
							<s:a class="btn btn-dark" action="toEditCity?city.id=%{id}">Edit</s:a>
							<s:if test="!active">
							<s:a class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#activationModal" onclick="selectCity(%{id}, true)">Activate</s:a>
							</s:if>
							<s:if test="active">
							<s:a class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#activationModal" onclick="selectCity(%{id}, false)">Deactivate</s:a>
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
					<s:if test="citySearch.pageNo != 1">
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
								<s:select name="citySearch.rowCount" list="{3, 5, 10, 15, 20}" class="form-control d-inline" onchange="first(); form.submit()"/>
							</div>
						</div>
					</label>
				</div>
				<div class="col-1 text-center">
					<label class="fw-bold pt-1">
						Total: <s:property value="citySearch.totalRows"/>
					</label>
				</div>
				<div class="col-2 text-center">
					<label class="fw-bold pt-1">
						Page <s:property value="citySearch.pageNo"/> of <s:property value="citySearch.pageCount"/>
					</label>
				</div>
				<div class="col-3 text-end">
					<s:if test="citySearch.pageNo != citySearch.pageCount">
					<s:submit class="btn btn-dark" value="Next" onclick="next()"/>
					<s:submit class="btn btn-dark" value="Last" onclick="last()"/>
					</s:if>
				</div>
			</div>
		</div>
	</div>
	<s:hidden id="pageNo" name="citySearch.pageNo" />
	<s:hidden id="pageCount" name="citySearch.pageCount" />
	
	<s:hidden id="cityId" name="city.id" />
	<s:hidden id="active" name="city.active" />
	
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
					<s:submit id="confirmBtn" class="btn btn-dark" onclick="updateCityActive()"/>
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
		
		function selectCity(cityId, active){
			
			$("#cityId").val(cityId);
			$("#active").val(active);
			
			if(active){
				
				$("#activationTitle").html("Activate City");
				$("#activationMessage").html("Are you sure to activate City");
				$("#confirmBtn").val("Activate");
				
			}else{
				
				$("#activationTitle").html("Deactivate City");
				$("#activationMessage").html("Are you sure to deactivate City");
				$("#confirmBtn").val("Deactivate");
			}
		}
		
		function updateCityActive(){
			
			$("#form").attr("action", "updateCityActive");
		}
	</script>
</s:form>