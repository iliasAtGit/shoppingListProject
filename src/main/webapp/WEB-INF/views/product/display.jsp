<%@ include file="../header_taglibs.jsp"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<%@ include file="../header_js_n_css.jsp"%>
<script src="<c:url value='/resources/javascript/product/productEditMainFunc.js' />"></script>
<style>
</style>
<title><spring:message code="product.form.title.display" /></title>
</head>
<body>
<%@ include file="../_bodyStart.jsp"%>

<div class="generic-container">
	<h2><spring:message code="product.form.title.display" /></h2>
	${success}
	
	<table id="userDisplayTable" class="display responsive nowrap" cellspacing="0">
		<thead>
			<tr>
				<th><spring:message code="product.form.title.name" /></th>
				<th><spring:message code="product.form.title.shopDepartment.name" /></th>
				<th class="col-sm-1"></th>
				<th class="col-sm-1"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product" varStatus="index">
				<tr id="tr${product.id}">
					<td class="name">
						<div class="read">${product.name}</div>
						<div class="write">
							<input type="text"
							    name="products[${index.index}].name"
								value="${product.name}"
								size="40" class="form-control toUpperCase" />
							<form:errors path="products[${index.index}].name"
								class="control-label" />
						</div>
					</td>
					<td class="shopDepartment">
						<div class="read">${product.shopDepartment.name}</div>
						<div class="write">
							<form:select id="products[${index.index}].shopDepartment.id" path="shopDeparts" class="form-control"
								style="text-overflow: ellipsis; control-label">
								<form:options items="${shopDeparts}" itemLabel="name" itemValue="id" />
							</form:select>
						</div>
					</td>
					<td class="editNsaveBtn">
						<div class="read">
							<a class="btn btn-warning center-block btn-responsive"
							   onClick="toggleProduct4edit(${product.id})">
								<spring:message code="form.submitBtn.edit" />
							</a>
						</div>
						<div class="write">
							<a class="btn btn-success center-block btn-responsive"
							   onClick="savePropductA(${product.id})">
								<spring:message code="form.submitBtn.save" />
							</a>
						</div>
					</td>
					<td class="cancelNremoveBtn">
						<div class="read">
							<button class="btn btn-danger center-block btn-responsive"
								onClick="requestToRemoveSimply(${product.id})">
								<spring:message code="form.submitBtn.delete" />
							</button>
						</div>
						<div class="write">
							<button class="btn btn-warning center-block btn-responsive"
								onClick="toggleProduct(${product.id})">
								<spring:message code="form.submitBtn.cancel" />
							</button>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="seperatePaddingDatatable">
		<a href="<c:url value='/product/addForm' />" class="btn btn-success custom-width">
			<spring:message code="form.submitBtn.add" />
		</a>
	</div>
<div id="ajaxRecall"></div>
</div>
<%@ include file="../_bodyEnd.jsp"%>
</html>