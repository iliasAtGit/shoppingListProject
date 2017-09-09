usrMustNotBeEmptyObj = [ "name" ];

function toggleShopDepartmnt( id, isNew ){

	var table = $("#userDisplayTable").DataTable();
	var rowIdx = $( "#tr"+id ).index();	
	var data = table.row( rowIdx ).data();
	
	data[0] = (isNew) ? $("#tr" + id + " .name input").val() : $("#tr" + id + " .name div.originaltxt").html()

	data[1] = "<button class=\"btn btn-warning center-block btn-responsive\" " +
				"onClick=\"toggleShopDepartmnt4Edit("+ id +")\">" + $("#i18nEditTxt").val() + "</button>";

	data[2] = "<button class=\"btn btn-danger center-block btn-responsive\" " +
				"onClick=\"requestToRemoveSimply("+ id +")\">" + $("#i18nDeleteTxt").val() + "</button>"

    table.row( rowIdx ).data( data ).draw();
}

function toggleShopDepartmnt4Edit( id ){
	var table = $("#userDisplayTable").DataTable();
	var rowIdx = $("#tr" + id).index();	
	var data = table.row( rowIdx ).data();
	
	data[0] = "<input type=\"text\" " +
				"size=\"40\" " +
				"class=\"form-control toUpperCase\" " +
				"value=\""+$.trim($( "#tr" + id + " .name:nth-child(1)").html())+"\" />";
	data[0] += "<div class=\"has-error\"></div>"
	data[0] += "<div class=\"originaltxt\" style=\"display:none\">"+$.trim($( "#tr" + id + " .name:nth-child(1)").html())+"</div>"

	data[1] = "<button class=\"btn btn-success center-block btn-responsive\" " +
				"onClick=\"saveShopDepartmentA(" + id + ")\">" + $("#i18nSaveTxt").val() + "</button>";

	data[2] = "<button class=\"btn btn-warning center-block btn-responsive\" " +
				"onClick=\"toggleShopDepartmnt(" + id + ", false)\">" + $("#i18nCancelTxt").val() + "</button>"

    table.row( rowIdx ).data( data ).draw();
}

function saveShopDepartmentA(id){
	var data = {"id" : id, "name" : $.trim($( "#tr"+id+" .name input:nth-child(1)" ).val())};
	
	requestToSaveSimply(id, data, function(){ toggleShopDepartmnt(id, true) });
}

function submitShopDepAddForm(thisForm) {
	
	if (validateFormStyle1(usrMustNotBeEmptyObj))
		thisForm.submit()
}

$( document ).ready( function() {
    var userDisplayTableProp = {
        	"scrollY":        "500px",
            "scrollCollapse": true,
        	"paging":         false,
        	"ordering":       false,
        	"info":           false,
        	"responsive":     true,        	
        };
	$('#userDisplayTable').DataTable($.extend(userDisplayTableProp, calc_lang_package()));
} );

$( document ).on( 'keyup', '.toUpperCase', function() {
	 this.value = this.value.toUpperCase();
	});