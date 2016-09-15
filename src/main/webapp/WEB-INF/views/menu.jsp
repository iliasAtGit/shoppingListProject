<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Shopping List Project</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a aria-expanded="false"
					aria-haspopup="true" role="button" data-toggle="dropdown"
					class="dropdown-toggle" href="#">Product<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value='/product/addForm' />">Add</a></li>
						<li><a href="<c:url value='/product/display' />">Display</a></li>
					</ul></li>

				<li class="dropdown"><a aria-expanded="false"
					aria-haspopup="true" role="button" data-toggle="dropdown"
					class="dropdown-toggle" href="#">Shop Department<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value='/shopDepartment/addForm' />">Add</a></li>
						<li><a href="<c:url value='/shopDepartment/display' />">Display All</a></li>
					</ul></li>

				<li class="dropdown"><a aria-expanded="false"
					aria-haspopup="true" role="button" data-toggle="dropdown"
					class="dropdown-toggle" href="#">ShoppingNote<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value='/shoppingNote/addForm' />">Add</a></li>
						<li><a href="<c:url value='/shoppingNote/dispActive' />">Display Active</a></li>
						<li><a href="<c:url value='/shoppingNote/display' />">Display All</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>
<!--
<style>
.dropdown:hover .dropdown-menu {
	display: block;
	margin-top: 0;
}
</style> -->