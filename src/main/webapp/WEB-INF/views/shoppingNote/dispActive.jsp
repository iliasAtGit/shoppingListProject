<!DOCTYPE html>
<%@ include file="../header_taglibs.jsp"%>
<html>
<head>
	<%@ include file="../header_js_n_css.jsp"%>
	<script	src="<%=request.getContextPath()%>/resources/javascript/jqueryRedirect.js"></script>
	<script	src="<%=request.getContextPath()%>/resources/javascript/shoppingNote/shoppingNoteEditMainFunc.js"></script>
	<script>
		$(document).ready(function() {
	   			   $.datepicker.setDefaults($.datepicker.regional[$("#locale").val()]);
		});
	</script>
	<title><spring:message code="shopNote.page.title.displayActive" /></title>
</head>
<%@ include file="../_bodyStart.jsp"%>

<!-- Page Heading -->
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">
			<spring:message code="shopNote.page.title.displayActive" />
		</h1>
	</div>
</div>
<!-- /.row -->
<div class="row">

	<div class="col-lg-6">
		<div class="table-responsive">
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th><spring:message code="shopNote.form.title.name" /></th>
						<th><spring:message code="shopNote.form.title.dateStart" /></th>
						<th><spring:message code="shopNote.form.title.dateEnd" /></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${shoppingNotes}" var="shoppingNote"
						varStatus="index">
						<tr id="tr${shoppingNote.id}">
							<td class="shoppingNoteName">
								<div class="read">${shoppingNote.name}</div>
								<div class="write">
									<input type="text"
										name="shoppingNotes[${index.index}]._name"
										value="${shoppingNote.name}" class="form-control" />
									<form:errors path="shoppingNotes[${index.index}].name"
										class="control-label" />
								</div>
							</td>
							<td class="shoppingNoteStartDt">
								<fmt:formatDate value="${shoppingNote.dateStart}"  
						             	 		type="date" 
						             	 	  	dateStyle="short"
						             		   	var="formattedDate" />											
								<div class="read">
									${formattedDate}
								</div>
								<div class="write">
									<input type="text"
										name="shoppingNotes[${index.index}].dateStart"
										id="dateStart_${shoppingNote.id}"
										value="${formattedDate}"
										class="form-control" />
									<form:errors
										path="shoppingNotes[${index.index}].dateStart"
										class="control-label" />
								</div>
							</td>
							<td class="shoppingNoteEndDt">
								<fmt:formatDate value="${shoppingNote.dateEnd}"  
						             	 		type="date" 
						             	 	  	dateStyle="short"
						             		   	var="formattedDate" />	
								<div class="read">
									${formattedDate}
								</div>
								<div class="write">
									<input type="text"
										name="shoppingNotes[${index.index}].dateEnd"
										id="endDate_${shoppingNote.id}"
										value="${formattedDate}"
										class="form-control" />
									<form:errors path="shoppingNotes[${index.index}].dateEnd"
										class="control-label" />
								</div>
							</td>											
							<td>												
								<button class="btn btn-primary"
										onClick="browseShoppingNote(${shoppingNote.id})">
										<spring:message code="form.submitBtn.browse" />
								</button>
							</td>
							<td class="editButtuns">
								<div class="read">
									<button class="btn btn-warning"
										onClick="toggleShoppingNote(${shoppingNote.id})">
										<spring:message code="form.submitBtn.edit" />
									</button>
								</div>
								<div class="write">
									<button class="btn btn-success"
										onClick="saveShoppingNoteA(${shoppingNote.id})">
										<spring:message code="form.submitBtn.save" />
									</button>
								</div>												
							</td>											
							<td>												
								<div class="read">
									<button class="btn btn-danger"
										onClick="deactivateShoppingNote(${shoppingNote.id})">
										<spring:message code="form.submitBtn.deactive" />
									</button>
								</div>
								<div class="write">
									<button class="btn btn-warning"
										onClick="activateShoppingNoteA(${shoppingNote.id})">
										<spring:message code="form.submitBtn.active" />
									</button>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<!-- /.row -->
<%@ include file="../_bodyEnd.jsp"%>
</html>
