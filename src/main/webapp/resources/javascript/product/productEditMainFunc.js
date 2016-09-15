mustNotBeEmptyObj = [ "name", "shopDepartment" ];
usrToggleTds = ["name", "shopDepartment", "editNsaveBtn", "cancelNremoveBtn"];// check for dependencies in case of reordering

function toggleProduct(id){
	toggleElements(id, usrToggleTds);	
}

function toggleProduct4edit(id){
	shopDepartment = $("#tr"+id+" ."+usrToggleTds[1]+" div:nth-child(1)").html();
    selectorShopDepartment = "#tr"+id+" ."+usrToggleTds[1]+" div:nth-child(2) select";
    $(selectorShopDepartment).val(
    							$(selectorShopDepartment + " option").filter(
    									function () {
    										return $(this).html() == shopDepartment; 
    									}).val())
    toggleElements(id, usrToggleTds);
}

function savePropductA(id){
	name = $( "#tr"+id+" .name div:nth-child(2) input:nth-child(1)" ).val();
	$( "#tr"+id+" .name div:nth-child(1)" ).html(name);
	
	shopDepartmentObjSelector = "#tr"+id+" .shopDepartment div:nth-child(2) select"
	$( "#tr"+id+" .shopDepartment div:nth-child(1)" ).html($(shopDepartmentObjSelector+" option:selected").text());
	shopDepartmentId = $(shopDepartmentObjSelector).val();
	
	data = {"id" : id, "name" : name, "shopDepartment":{"id": shopDepartmentId}};
	
	requestToSaveSimply(id, data, function(){ toggleProduct(id) });
}

function submitProdAddForm(thisForm) {
	if (validateFormStyle1(mustNotBeEmptyObj))
		thisForm.submit()
}

$( document ).ready( function() {
    $('#userDisplayTable').DataTable({
    	"scrollY":        "500px",
        "scrollCollapse": true,
    	"paging":         false,
    	"ordering":       false,
    	"info":           false,
    	"responsive":     true   	
    });
} );

$( document ).on( 'keyup', '.toUpperCase', function() {
	 this.value = this.value.toUpperCase();
	});