<%@ include file="header_taglibs.jsp"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<%@ include file="header_js_n_css.jsp"%>
</head>
<body>
<%@ include file="menu.jsp"%>

	<div class="generic-container">
	<h1>Hello world!</h1>
		<a href="<c:url value='/product/prodForm' />"
			class="btn btn-success custom-width">Add</a>
		<a href="<c:url value='/product/display' />"
			class="btn btn-warning custom-width">Display</a>
		<!-- <div><button id="tAddBtn" onClick="window.location.href='product/prodForm.html'">Add new product</button></div>
<div><button id="teditNsaveBtn" onClick="window.location.href='product/update.html'">Update</button></div>
<div><button id="toRemoveBtn" onClick="window.location.href='product/display'">prodDisplay</button></div> -->
	</div>
</body>
</html>
