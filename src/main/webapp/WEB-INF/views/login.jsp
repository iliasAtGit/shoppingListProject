<%@ include file="header_taglibs.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Log in with your account</title>
    <%@ include file="header_js_n_css.jsp"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" />
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="container">    
  <div id="loginbox" class="mainbox col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3"> 
    <div class="panel panel-default" >
      <div class="panel-heading">
        <div class="panel-title text-center">Shopping List</div>
      </div>     
      <div class="panel-body" >
        <form id="loginForm" method="POST" action="${contextPath}/login" class="form-signin">
          <h2 class="form-heading"><spring:message code="loginpage.login" text="default text" /></h2>
          <div class="form-group ${error != null ? 'has-error' : ''}">
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                <input name="username" type="text" class="form-control" value="" placeholder="<spring:message code="loginpage.username" text="default text" />" autofocus="true">                                       
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                <input name="password" type="password" class="form-control" placeholder="<spring:message code="loginpage.password" text="default text" />">
            </div>  
            <div>${error}</div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>                                                                
            <div class="form-group">
                <div class="col-sm-12 controls">
                    <button type="submit" href="#" class="btn btn-primary pull-right"><i class="glyphicon glyphicon-log-in"></i> <spring:message code="loginpage.login" text="default text" /></button>                          
                </div>
            </div>
          </div>
        </form>     
      </div>                     
    </div>  
  </div>
</div>
</body>
</html>