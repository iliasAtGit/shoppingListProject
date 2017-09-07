<form id="logoutForm" method="POST" action="<c:url value='/logout' />">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button"
			        class="navbar-toggle collapsed"
				    data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1"
				    aria-expanded="false">
				<span class="sr-only">Shopping List Project</span>
				<span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value='/welcome' />">
                Shopping List Project
			</a>
		</div>

		<div class="collapse navbar-collapse"
			 id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-left">
				<li class="dropdown">
				    <a aria-expanded="false"
					   aria-haspopup="true"
                       role="button"
                       data-toggle="dropdown"
					   class="dropdown-toggle"
                       href="#">
                       <spring:message code="menu.title.product" text="default text" />
                       <span class="caret"></span>
                    </a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value='/product/addForm' />">
                            <spring:message code="form.submitBtn.add" text="default text" />
                        </a></li>
						<li><a href="<c:url value='/product/display' />">
                            <spring:message code="menu.action.display" text="default text" />
                        </a></li>
					</ul>
				</li>

				<li class="dropdown">
                    <a aria-expanded="false"
                       aria-haspopup="true"
                       role="button"
                       data-toggle="dropdown"
                       class="dropdown-toggle"
                       href="#">
                       <spring:message code="menu.title.shopDepartment" text="default text" />
                       <span class="caret"></span>
                    </a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value='/shopDepartment/addForm' />">
                            <spring:message code="form.submitBtn.add" text="default text" />
                        </a></li>
						<li><a href="<c:url value='/shopDepartment/display' />">
                            <spring:message code="menu.action.displayAll" text="default text" />
                        </a></li>
					</ul>
				</li>
				
                <li class="dropdown">
                    <a aria-expanded="false"
                       aria-haspopup="true"
                       role="button"
                       data-toggle="dropdown"
                       class="dropdown-toggle"
                       href="#">
                       <spring:message code="menu.title.measurementUnit" text="default text" />
                       <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value='/measurementUnit/addForm' />">
                            <spring:message code="form.submitBtn.add" text="default text" />
                        </a></li>
                        <li><a href="<c:url value='/measurementUnit/display' />">
                            <spring:message code="menu.action.displayAll" text="default text" />
                        </a></li>
                    </ul>
                </li>

				<li class="dropdown">
                    <a aria-expanded="false"
                       aria-haspopup="true"
                       role="button"
                       data-toggle="dropdown"
                       class="dropdown-toggle"
                       href="#">
                       <spring:message code="menu.title.shoppingNote" text="default text" />
                       <span class="caret"></span>
                    </a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value='/shoppingNote/addForm' />">
                            <spring:message code="form.submitBtn.add" text="default text" />
                        </a></li>
						<li><a href="<c:url value='/shoppingNote/dispActive' />">
                            <spring:message code="menu.action.displayCurrent" text="default text" />
                        </a></li>
						<li><a href="<c:url value='/shoppingNote/display' />">
                            <spring:message code="menu.action.display" text="default text" />
                        </a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">	
				<c:if test="<%=request.isUserInRole(\"ROLE_ADMIN\")%>">
				  <li class="dropdown">
                      <a aria-expanded="false"
	                     aria-haspopup="true"
	                     role="button"
	                     data-toggle="dropdown"
	                     class="dropdown-toggle"
	                     href="#">
	                     <span class="glyphicon glyphicon-king"></span>
	                     <spring:message code="menu.title.adminArea" />                      
	                  </a>
	                  <ul class="dropdown-menu">
	                      <li>
	                          <a href="<c:url value='/admin/registration' />">
                                <spring:message code="menu.admin.addAccount" />                               
	                          </a>
	                      </li>                       
                          <li>
                              <a href="<c:url value='/admin/usertest' />">
                                <spring:message code="menu.admin.manageAccount" />  
                              </a>
                          </li>                       
                      </ul>
                  </li>
                </c:if>
					
              <li class="dropdown pull-right">
	              <a role="button"
	                 onclick="document.forms['logoutForm'].submit()">
		              <span class="glyphicon glyphicon-log-out"></span>
		              <spring:message code="menu.action.logout" />
	              </a>
              </li>
			</ul>
		</div>
	</div>
</nav>