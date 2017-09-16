<link rel="shortcut icon" href='<c:url value="/resources/images/favicon-shopping-cart.ico" />' type="image/x-icon" />
<link rel="icon" href='<c:url value="/resources/images/favicon-shopping-cart.ico" />' type="image/x-icon" />
<link rel="apple-touch-icon" href='<c:url value="/resources/images/favicon-shopping-cart.png" />' />

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<c:set var = "resourcesLibsPath" value = "${pageContext.request.contextPath}/resources/libs"/>

<script	src="${resourcesLibsPath}/jquery-1.12.2.min.js"></script>
<script	src="${resourcesLibsPath}/jquery-ui-1.11.4/jquery-ui.min.js"></script>
<script	src="${resourcesLibsPath}/jquery-ui-1.11.4/jquery-ui-i18n.min.js"></script>
<link rel="stylesheet" href="${resourcesLibsPath}/jquery-ui-1.11.4/jquery-ui.min.css"/>

<c:set var = "datatablesVersion" scope="request" value = "1.10.12"/>
<c:set var = "datatablesPath" scope="request" value = "${resourcesLibsPath}/datatables"/>
<script	src="${datatablesPath}/${datatablesVersion}/js/jquery.dataTables.min.js"></script>
<script	src="${datatablesPath}/${datatablesVersion}/js/dataTables.bootstrap.min.js"></script>
<link rel="stylesheet" href="${datatablesPath}/${datatablesVersion}/css/jquery.dataTables.min.css"/>
<jsp:include page="/WEB-INF/views/languageSelection.jsp"/>

<c:set var = "bootstrapAdminVersion" value = "1.0.4"/>
<c:set var = "bootstrapAdminPath" value = "${resourcesLibsPath}/startbootstrap-sb-admin-${bootstrapAdminVersion}"/>
<script	src="${resourcesLibsPath}/responsive/2.1.0/js/dataTables.responsive.min.js"></script>
<script	src="${resourcesLibsPath}/responsive/2.1.0/js/responsive.bootstrap.min.js"></script>
<link rel="stylesheet" href="${resourcesLibsPath}/responsive/1.0.7/css/responsive.dataTables.min.css"/>
<link rel="stylesheet" href="${resourcesLibsPath}/responsive/css/buttons/responsive-buttons.css"/>

<script	src="${bootstrapAdminPath}/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${bootstrapAdminPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${bootstrapAdminPath}/css/sb-admin.css" />
<link rel="stylesheet" href="${bootstrapAdminPath}/font-awesome/css/font-awesome.min.css" />

<link rel="stylesheet"href="<%=request.getContextPath()%>/resources/css/bootsrapAdj.css">
	
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->


<script	src="<%=request.getContextPath()%>/resources/javascript/generals.js"></script>

<link rel="stylesheet"href="<%=request.getContextPath()%>/resources/css/autosuggestion/autosuggest_inquisitor.css" type="text/css" media="screen" charset="utf-8" />
<script language="javascript" type="application/javascript" charset="utf-8"  src="<%=request.getContextPath()%>/resources/javascript/AutoSuggest_2_1_3.js"></script>