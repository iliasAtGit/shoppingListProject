mustNotBeEmptyObj = [ "name", "shopDepartment" ];
usrToggleTds = [ "name", "shopDepartment", "unit", "editNsaveBtn",
		"cancelNremoveBtn" ];// check
																						// for
																						// dependencies
																						// in
																						// case
																						// of
																						// reordering

function toggleProduct(id) {
	toggleElements(id, usrToggleTds);
}

function toggleHtml2SelectElem(id, className) {
	htmlValue = $("#tr" + id + " ." + className + " div:nth-child(1)").html();
	selectorIdenifier = "#tr" + id + " ." + className
			+ " div:nth-child(2) select";
	$(selectorIdenifier).val(
			$(selectorIdenifier + " option").filter(function() {
				return $(this).html() == htmlValue;
			}).val())
}

function toggleSelectElem2Html(id, className) {
	selectorIdenifier = "#tr" + id + " ." + className
			+ " div:nth-child(2) select"
	$("#tr" + id + " ." + className + " div:nth-child(1)").html(
			$(selectorIdenifier + " option:selected").text());
	return $(selectorIdenifier).val();
}

function toggleProduct4edit(id) {
	toggleHtml2SelectElem(id, usrToggleTds[1])
	toggleHtml2SelectElem(id, usrToggleTds[2])
	toggleElements(id, usrToggleTds);
}

function savePropductA(id) {
	name = $("#tr" + id + " .name div:nth-child(2) input:nth-child(1)").val();
	$("#tr" + id + " .name div:nth-child(1)").html(name);

	shopDepartmentId = toggleSelectElem2Html(id, usrToggleTds[1]);

	unitId = toggleSelectElem2Html(id, usrToggleTds[2]);

	data = {
		"id" : id,
		"name" : name,
		"shopDepartment" : {
			"id" : shopDepartmentId
		},
		"unit" : {
			"id" : unitId
		}
	};

	requestToSaveSimply(id, data, function() {
		toggleProduct(id)
	});
}

function submitProdAddForm(thisForm) {
	if (validateFormStyle1(mustNotBeEmptyObj)){thisForm.submit()}
}

$(document).ready(function() {
	$('#userDisplayTable').DataTable({
		"scrollY" : "500px",
		"scrollCollapse" : true,
		"paging" : false,
		"ordering" : false,
		"info" : false,
		"responsive" : true
	});
});

$(document).on('keyup', '.toUpperCase', function() {
	this.value = this.value.toUpperCase();
});