<%@ include file="../header_taglibs.jsp"%>
<%@ page session="false"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><spring:message code="product.page.title.add" /></title>
	
	<%@ include file="../header_js_n_css.jsp"%>
	<script src="<c:url value='/resources/javascript/validators/validateFormStyle1.js' />"></script>
	<script src="<c:url value='/resources/javascript/product/productEditMainFunc.js' />"></script>
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
		<h1><spring:message code="product.page.title.add" /></h1>

		<form:form method="POST" modelAttribute="product">
			<div class="panel-default">				
				<spring:bind path="name">
					<div class="row form-group ${resultClass}">
						<label class="col-sm-1 control-label">
							<spring:message	code="product.form.title.name" />
						</label>
						<div class="col-sm-2">
							<form:input path="name"
							            id="name"
							            type="text"
							            class="form-control toUpperCase" />
							<form:errors path="name" class="control-label" />
						</div>
						<input id="name.jserror"
						       type="hidden"							  
							   value="<spring:message code="product.form.validator.name" />" />			
					</div>
				</spring:bind>
				
				<spring:bind path="prodsDepartsCollection">
					<div class="row form-group">
						<label class="col-sm-1 control-label">
							<spring:message code="product.form.title.shopDepartment.name" />
						</label>
						<div class="col-sm-2">
								<form:select path="id"
								             class="form-control"
								             style="text-overflow: ellipsis; control-label">
								<form:options items="${shopDeparts}"
								              itemLabel="name"
									          itemValue="id" />
							</form:select>
							<form:errors path="id" class="control-label" />
						</div>
						<input id="id.jserror"
						       type="hidden"
						       value="<spring:message code="product.form.validator.shopDepartment" />" />
					</div>
				</spring:bind>

                <spring:bind path="prodsDepartsCollection">
                    <div class="row form-group">
                        <label class="col-sm-1 control-label">
                            <spring:message code="product.form.title.shopDepartment.name" />
                        </label>
                        <div class="col-sm-2">
                                <form:select path="id"
                                             class="form-control"
                                             style="text-overflow: ellipsis; control-label">
                                <form:options items="${units}"
                                              itemLabel="name"
                                              itemValue="id" />
                            </form:select>
                            <form:errors path="id" class="control-label" />
                        </div>
                        <input id="id.jserror"
                               type="hidden"
                               value="<spring:message code="product.form.validator.shopDepartment" />" />
                    </div>
                </spring:bind>
			</div>

			<input type="button" value="<spring:message code="form.submitBtn.add" />" onClick="submitProdAddForm(this.form)" class="btn btn-success custom-width" />
		</form:form>
		<div class="${resultClass}">${result}</div>
	</div>

</body>
</html>
