<%@ include file="header_taglibs.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="principal" property="principal" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome</title>
    <%@ include file="header_js_n_css.jsp"%>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@ include file="menu.jsp"%>
<div class="container">
	<div class="row">
	    <h2>
		    <div style="float:left; width:auto;">Welcome ${principal.username}</div>
		    <div style="float:left; width:auto;">&nbsp;|&nbsp;</div>
		    <div style="float:left; width:auto;"><a href="<c:url value='/admin/registration' />">Your last actions</a></div>
	    </h2>
	</div>
</div>
</body>
</html>