<!DOCTYPE html>
<%@ include file="../header_taglibs.jsp"%>
<html>

<head>
	<%@ include file="../header_js_n_css.jsp"%>
    <script src="<c:url value='/resources/javascript/shoppingNote/shoppingNoteEditMainFunc.js' />"></script>
	<script>
		$(document).ready(function() {
	   			   $.datepicker.setDefaults($.datepicker.regional[$("#locale").val()]);
		});
	</script>
</head>
<body>
	<%@ include file="../menu.jsp"%>

	<div class="generic-container">
		<h1>${titleAction}</h1>

		<form:form method="POST" modelAttribute="shoppingNote">
			<div class="panel-default">
				<form:hidden path="id" />
				
				<spring:bind path="name">
					<div class="row form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label"><spring:message
								code="shopNote.form.title.name" /></label>
						<div class="col-sm-2">
							<form:input path="name" type="text" class="form-control"
								id="name" />
							<form:errors path="name" class="control-label" />
						</div>
						<input type="hidden" id="name.jserror"
							value="<spring:message code="shopNote.form.validator.name" />" />
					</div>
				</spring:bind>

				<spring:bind path="dateStart">
					<div class="row form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label"><spring:message
								code="shopNote.form.title.dateStart" /></label>
						<div class="col-sm-2">
							<form:input path="dateStart" type="text" class="form-control"
								id="dateStart" />
							<form:errors path="dateStart" class="control-label" />
						</div>
						<input type="hidden" id="dateStart.jserror"
							value="<spring:message code="shopNote.form.validator.dateStart" />" />
					</div>
				</spring:bind>

				<spring:bind path="dateEnd">
					<div class="row form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label"><spring:message
								code="shopNote.form.title.dateEnd" /></label>
						<div class="col-sm-2">
							<form:input path="dateEnd" type="text" class="form-control"
								id="dateEnd" />
							<form:errors path="dateEnd" class="control-label" />
						</div>
						<input type="hidden" id="dateEnd.jserror"
							value="<spring:message code="shopNote.form.validator.dateEnd" />" />
					</div>
				</spring:bind>

			</div>
			<input type="hidden" name="dateFormat" id="dateFormat" value="s" />
			<input type="button" value="${submitBtn}"
				onClick="submitShopNoteAddForm(this.form)"
				class="btn btn-success custom-width" />
		</form:form>
	</div>
	<input type="hidden" id="locale" value="${currentLocale}" />
</body>

</html>