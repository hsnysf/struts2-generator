<%@ taglib prefix="s" uri="/struts-tags" %>

<h4 class="pb-2 mt-4 mb-3 border-bottom">
	<s:if test="chiefExecutiveOfficer.id == null">
		Add Chief Executive Officer
	</s:if>
	<s:if test="chiefExecutiveOfficer.id != null">
		Edit Chief Executive Officer
	</s:if>
</h4>

<s:form id="form" action="saveChiefExecutiveOfficer">

	<div class="card mt-4">
		<div class="card-header fw-bold">
			Chief Executive Officer Details
		</div>
		<div class="card-body">
		
			<div class="row">
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="chiefExecutiveOfficerSector" class="form-label">Sector</label>
						<s:textfield id="chiefExecutiveOfficerSector" name="chiefExecutiveOfficer.sector" type="text" class="form-control is-valid" placeholder="Sector" maxlength="200" autocomplete="off" />
					</div>
				</div>
			</div>
		
		</div>
	</div>
	
	<div class="card mt-4">
		<div class="card-header fw-bold">
			Manager Details
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="managerDegree" class="form-label">Degree</label>
						<s:textfield id="managerDegree" name="chiefExecutiveOfficer.id.degree" type="tel" class="form-control is-valid" placeholder="Degree" maxlength="10" autocomplete="off" />
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-4">
					<div class="mb-3">
						<label for="managerAllowance" class="form-label">Allowance</label>
						<s:textfield id="managerAllowance" name="chiefExecutiveOfficer.id.allowance" type="number" class="form-control is-valid" placeholder="Allowance" maxlength="17" autocomplete="off" />
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="text-center mt-4">
		<s:a class="btn btn-dark" onclick="submitForm(); return false;">
			<s:if test="chiefExecutiveOfficer.id == null">
				Add Chief Executive Officer
			</s:if>
			<s:if test="chiefExecutiveOfficer.id != null">
				Update Chief Executive Officer
			</s:if>
		</s:a>
		<s:a class="btn btn-dark" action="/">Close</s:a>
	</div>
	
	<div class="modal fade" id="confirmModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">
						<s:if test="chiefExecutiveOfficer.id == null">
							Add ChiefExecutiveOfficer
						</s:if>
						<s:if test="chiefExecutiveOfficer.id != null">
							Update ChiefExecutiveOfficer
						</s:if>
					</h5>
					<button class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<h4>
						<s:if test="chiefExecutiveOfficer.id == null">
							Are you sure to add ChiefExecutiveOfficer
						</s:if>
						<s:if test="chiefExecutiveOfficer.id != null">
							Are you sure to update ChiefExecutiveOfficer
						</s:if>
					</h4>
				</div>
				<div class="modal-footer">
					<s:submit id="confirmBtn" class="btn btn-dark" value="%{chiefExecutiveOfficer.id == null ? 'Add' : 'Update'}" />
					<a class="btn btn-dark" data-bs-dismiss="modal">Close</a>
				</div>
			</div>
		</div>
	</div>
	
	<s:hidden id="chiefExecutiveOfficerId" name="chiefExecutiveOfficer.id" />
	<s:hidden name="chiefExecutiveOfficer.address.id" />
	
	<script>
		
		
		function submitForm(){
			
			if(isValidForm()){
				
				$("#confirmModal").modal("show");
			}
		}
		
	</script>
</s:form>