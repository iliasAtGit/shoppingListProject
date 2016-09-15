<!DOCTYPE html>
<%@ include file="../header_taglibs.jsp"%>
<html>
<head>
	<%@ include file="../header_js_n_css.jsp"%>
	<title><spring:message code="shopNote.page.title.display" /></title>
</head>
<%@ include file="../_bodyStart.jsp"%>

<!-- Page Heading -->
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">
			<spring:message code="shopNote.page.title.display" />
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
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${shoppingNotes}" var="shoppingNote"
						varStatus="index">
						<tr id="tr${shoppingNote.id}" class="${shoppingNote.isActive=='1' ? "success" : ""}">
							<td class="shoppingNoteName">
								${shoppingNote.name}
							</td>
							<td class="shoppingNoteStartDt">
								<fmt:formatDate value="${shoppingNote.dateStart}"  
						             	 		type="date" 
						             	 	  	dateStyle="short" />
							</td>
							<td class="shoppingNoteEndDt">
								<fmt:formatDate value="${shoppingNote.dateEnd}"  
						             	 		type="date" 
						             	 	  	dateStyle="short"/>
						    </td>
							<td>
								<button class="btn btn-${shoppingNote.isActive=='1' ? "success" : "primary"}"
										onClick="browseShoppingNote(${shoppingNote.id})">
										<spring:message code="form.submitBtn.browse" />
								</button>
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
