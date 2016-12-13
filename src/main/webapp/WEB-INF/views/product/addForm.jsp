<%@ include file="../header_taglibs.jsp"%>
<%@ page session="false"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="product.page.title.add" /></title>

<%@ include file="../header_js_n_css.jsp"%>
<script	src="<c:url value='/resources/javascript/validators/validateFormStyle1.js' />"></script>
<script	src="<c:url value='/resources/javascript/product/productAddForm.js' />"></script>

</head>
<body>
	<%@ include file="../menu.jsp"%>
	<div class="container">
		<h1>
			<spring:message code="product.page.title.add" />
		</h1>
        
		<form:form method="POST" modelAttribute="product">
			<div class="panel-default">
				<spring:bind path="productName">
					<div class="row form-group ${resultClass}">
						<label class="col-sm-1 control-label">
						  <spring:message code="product.form.title.name" />
						</label>
						<div class="col-sm-2">
							<form:input path="productName"
							            id="productName"
							            type="text"
								        class="form-control toUpperCase" />
							<form:errors path="productName" class="control-label" />
						</div>
						<input id="productName.jserror"
						       type="hidden"
							   value="<spring:message code="product.form.validator.name" />" />
					</div>
				</spring:bind>
				<table id="prodShopDepUnitTable" class="cell-border display responsive nowrap" style="float:left" width="100%">
					<thead>
						<tr>
							<th><spring:message	code="product.form.title.shopDepartment.name" /></th>
							<th class="col-xs-2 col-sm-2"><spring:message code="unit.form.title.name" /></th>
							<th class="col-xs-1 col-sm-1"></th>
						</tr>
					</thead>
					<tfoot>
						<tr>
                            <th colspan="2"></th>
							<th style="text-align:center">
							    <button type="button"
								        id="addRow"
									    class="btn btn-success">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
							</th>
						</tr>
					</tfoot>
					<tbody>
						<tr id="tr_0">
							<td><form:select path="shopDepName"
                                             class="form-control"
									         style="text-overflow: ellipsis; control-label">
									<form:options items="${shopDeparts}"
                                                  itemLabel="name"
										          itemValue="id" />
								</form:select>
								<form:errors path="shopDepName"
								             class="control-label" />
								<input id="shopDepName.jserror"
								       type="hidden"
								       value="<spring:message code="product.form.validator.shopDepartment" />" />
							</td>
							<td><form:select path="unitName"
							                 class="form-control"
									         style="text-overflow: ellipsis; control-label">
									<form:options items="${units}"
                                                  itemLabel="name"
										          itemValue="id" />
								</form:select>
								<form:errors path="unitName"
								             class="control-label" />
								<input id="unitName.jserror"
								       type="hidden"
								       value="<spring:message code="product.form.validator.shopDepartment" />" />
							</td>
							<td style="text-align:center"></td>
						</tr>
					</tbody>
				</table>
			</div>

			<input type="button"
				   value="<spring:message code="form.submitBtn.save" />"
				   onClick="submitProdAddForm(this.form)"
				   class="btn btn-success custom-width" />
		</form:form>
		<div class="${resultClass}">${result}</div>
	</div>

</body>
</html>
