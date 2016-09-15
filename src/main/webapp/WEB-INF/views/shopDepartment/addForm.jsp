<%@ include file="../header_taglibs.jsp"%>
<%@ page session="false"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><spring:message code="shopDepart.page.title.add" /></title>
<%@ include file="../header_js_n_css.jsp"%>
<script src="<c:url value='/resources/javascript/validators/validateFormStyle1.js' />"></script>
<script src="<c:url value='/resources/javascript/shopDepartment/shopDepartmentEditMainFunc.js' />"></script>
<script>
$(document).ready(function (){
	$('form').find('input[type=text],textarea,select').filter(':visible:first').focus();
	
	$('form').find('input[type=text]').keyup(function(){
	    this.value = this.value.toUpperCase();
	});
});

</script>
</head>
<body>
	<%@ include file="../menu.jsp"%>

	<div class="generic-container">
		<h1><spring:message code="shopDepart.page.title.add" /></h1>

		<form:form method="POST" modelAttribute="shopDepartment">
			<div class="panel-default">
				<spring:bind path="name">
					<div class="row form-group ${resultClass}">
						<label class="col-sm-1 control-label"> <spring:message
								code="shopDepart.form.title.name" />
						</label>
						<div class="col-sm-2">
							<form:input path="name" type="text" class="form-control" id="name" />
							<form:errors path="name" class="control-label" />
						</div>
						<input type="hidden" id="name.empty.jserror"
							value="<spring:message code="shopDepart.form.validator.name" />" />
					</div>
				</spring:bind>
			</div>

			<input type="button" value="<spring:message code="form.submitBtn.add" />"
				onClick="submitShopDepAddForm(this.form)"
				class="btn btn-success custom-width" />
		</form:form>
		<div class="${resultClass}">${result}</div>
	</div>

</body>
</html>
