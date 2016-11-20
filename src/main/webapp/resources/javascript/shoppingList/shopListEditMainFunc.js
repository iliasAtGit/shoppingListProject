usrMustNotBeEmptyObj = [ "quantity", "productName" ];

function toggleShoppingList( id, isNew ){

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

function toggleShoppingList4Edit( id ){
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

function saveShoppingListA(id){
	data = {"id" : id, "name" : $.trim($( "#tr"+id+" .name input:nth-child(1)" ).val())};
	
	requestToSaveSimply(id, data, function(){ toggleShopDepartmnt(id, true) });
}

function submitShoppingListAddForm(thisForm) {
	
	if (validateFormStyle1(usrMustNotBeEmptyObj))
		thisForm.submit()
}

function getQuantityInput(row) {
	return "<input type=\"number\" style=\"width: 5em\" class=\"form-control\" id=\"quantity" + row + "\" />";
}

function getJSON(){
return '{ results: [{ id: "1", value: "Foobar", info: "Cheshire" },{ id: "2", value: "Foobarfly", info: "Shropshire" },{ id: "3", value: "Foobarnacle", info: "Essex" }] }'
}

function sugProduct(sugobj){	
	var options = {
		varname:"input",
		json:true,
		shownoresults: false,
		maxresults:6,
		sObj:sugobj,
		textOnFocus:sugobj.value,
		importedJson:getJSON(),
		cache:true,
		test:function(id, value) {
			$("#shopDepartment"+id).html(value.info)
		}
	};
	var as_json = new bsn.AutoSuggest(sugobj.id, options);
}

function getProductNameInput(row) {
	return "<input type=\"hidden\" id=\"hiddproductName"+row+"\"\><input type=\"text\" size=\"18\" class=\"form-control toUpperCase\" id=\""+row+"\"  onFocus=\"sugProduct(this)\" />"
}

function getShopDepartmentInput(row) {
	return "<div id=\"shopDepartment"+row+"\"></div>"
}

function getCommetnInput(row) {
	return "<input type=\"text\" size=\"14\" class=\"form-control toUpperCase\" id=\"comment"+row+"\" />"
}

function getProdStatsBtn(row) {
	return "<a onclick=\"getProdStats()\" class=\"btn btn-warning center-block btn-responsive\">"+
			"<span class=\"glyphicon glyphicon-stats\"></span>" +
			"</a>";
}

function getEditBtn(row) {
	return "<a onclick=\"getProdStats()\" class=\"btn btn-warning center-block btn-responsive\">"+
			"<span class=\"glyphicon glyphicon-save\"></span>" +
			"</a>";
}

$(document).ready(function() {
    var t = $('#userDisplayTable').DataTable();
    var row = $("#userDisplayTable > tbody > tr").length;
 
    $('#addRow').on( 'click', function () {
        t.row.add( [
            getProductNameInput(row),
            getQuantityInput(row),
            row +'.2',            
            getShopDepartmentInput(row),
            getCommetnInput(row),
            getProdStatsBtn(row),
            row +'.7'
        ] ).draw( false );
 
        row++;
    } );
 
    // Automatically add a first row of data
    $('#addRow').click();
} );
/*$( document ).ready( function() {
	$('#userDisplayTable').DataTable({
    	"scrollY":        "500px",
        "scrollCollapse": true,
    	"paging":         false,
    	"ordering":       false,
    	"info":           false,
    	"responsive":     true   	
    });
    var counter = 1;
    $('#addRow').on( 'click', function () {
        t.row.add( [
            counter +'.1',
            counter +'.2',
            counter +'.3',
            counter +'.4',
            counter +'.5'
        ] ).draw( false );
 
        counter++;
    } );
 
    // Automatically add a first row of data
    $('#addRow').click();
} );*/

$( document ).on( 'keyup', '.toUpperCase', function() {
	 this.value = this.value.toUpperCase();
	});