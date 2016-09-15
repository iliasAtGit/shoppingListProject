<%@ include file="../header_taglibs.jsp"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<%@ include file="../header_js_n_css.jsp"%>
<script src="<c:url value='/resources/javascript/shopDepartment/shopDepartmentEditMainFunc.js' />"></script>

<title><spring:message code="shopDepart.form.title.display" /></title>

</head>
<%@ include file="../_bodyStart.jsp"%>

<div class="generic-container">
	<h2><spring:message code="shopDepart.form.title.display" /></h2>
	${success}

	<table id="userDisplayTable" class="display responsive nowrap" cellspacing="0">
		<thead>
			<tr>
				<th><spring:message	code="shopDepart.form.title.name" /></th>
				<th class="col-sm-1"></th>
				<th class="col-sm-1"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${shopDepartments}" var="shopDepartment" varStatus="index">
				<tr id="tr${shopDepartment.id}">
					<td class="name">
						${shopDepartment.name}
					</td>
					<td class="editNsaveBtn">
						<a class="btn btn-warning center-block btn-responsive" onClick="toggleShopDepartmnt4Edit(${shopDepartment.id})">
							<spring:message code="form.submitBtn.edit" /></a>
					</td>
					<td class="cancelNremoveBtn">
						<button class="btn btn-danger center-block btn-responsive" onClick="requestToRemoveSimply(${shopDepartment.id})">
							<spring:message code="form.submitBtn.delete" /></button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="seperatePaddingDatatable">
		<a href="<c:url value='/shopDepartment/addForm' />"	class="btn btn-success custom-width">
			<spring:message code="form.submitBtn.add" />
		</a>
	</div>
</div>
<div id="ajaxRecall"></div>
<%@ include file="../_bodyEnd.jsp"%>
</html>