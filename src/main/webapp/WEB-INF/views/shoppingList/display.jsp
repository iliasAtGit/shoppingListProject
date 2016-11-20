<%@ include file="../header_taglibs.jsp"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<%@ include file="../header_js_n_css.jsp"%>
<script src="<c:url value='/resources/javascript/shoppingList/shopListEditMainFunc.js' />"></script>
<style>
</style>
<title><spring:message code="product.form.title.display" /></title>
</head>
<body>
<%@ include file="../_bodyStart.jsp"%>

<div class="generic-container">
	<h2><spring:message code="product.form.title.display" /></h2>
	${success}
	<form>
	<table id="userDisplayTable" class="display responsive nowrap" cellspacing="0" width="100%">
        <thead>
            <tr>
				<th><spring:message code="product.form.title.name" /></th>
				<th class="col-sm-1"><spring:message code="product.form.title.quantity" /></th>
				<th class="col-sm-1"><spring:message code="unit.form.title.name" /></th>
				<th><spring:message code="product.form.title.shopDepartment.name" /></th>
				<th><spring:message code="shopList.form.title.comment" /></th>
				<th class="col-sm-1"></th>
				<th class="col-sm-1"></th>
            </tr>
        </thead>
        <tbody>
			<c:forEach items="${shoppingList}" var="shoppingListRow" varStatus="index">
				<tr id="tr${shoppingListRow.id}">
					<td class="productName">
						${shoppingListRow.productName}
					</td>
					<td class="quantity">
						${shoppingListRow.quantity}
					</td>
					<td class="unit">
						unit
					</td>					
					<td class="shopDepartment">
						${shoppingListRow.shopDepartment}
					</td>
					<td class="comment">
						${shoppingListRow.comment}
					</td>
					<td class="editNsaveBtn">
						<div class="read">
							<a class="btn btn-warning center-block btn-responsive"
							   onClick="toggleProduct4edit(${product.id})">
								<spring:message code="form.submitBtn.edit" />
							</a>
						</div>
					</td>
					<td>
						<div class="write">
							<a class="btn btn-success center-block btn-responsive"
							   onClick="savePropductA(${product.id})">
								<spring:message code="form.submitBtn.save" />
							</a>
						</div>
					</td>
				</tr>
			</c:forEach>
        </tbody>
    </table>
    </form>
	<div class="seperatePaddingDatatable">
		<a id="addRow" class="btn btn-success custom-width">
			<spring:message code="form.submitBtn.add" />
		</a>
	</div>

<div id="ajaxRecall"></div>
</div>
<%@ include file="../_bodyEnd.jsp"%>
</html>