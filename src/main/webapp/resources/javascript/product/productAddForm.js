function getTbodyLen(tableId){
	return $('#' + tableId + ' tbody>tr').length;
}

function fillFirstTbodyTrLastTd(tableId, fillWith){
    $('#' + tableId).find('tbody tr:first').
					 find('td:last-child').
					 html(fillWith);
}

function addRemoveLineSignFirstRowIfNeeded(tableId){
	if (getTbodyLen(tableId) == 1)
		fillFirstTbodyTrLastTd(tableId, '<button type="button" class="btn btn-danger deleteRow">'+
		                                     '<span class="glyphicon glyphicon-minus"></span>'+
		                                '</button>');	
}

function removeRemoveLineSignFirstRowIfNeeded(tableId){
    if (getTbodyLen(tableId) == 1)
    	fillFirstTbodyTrLastTd(tableId, "");      
}

$(document).ready(function (){
	$('form').find('input[type=text],textarea,select').filter(':visible:first').focus();
	
	$('form').find('input[type=text]').keyup(function(){
	    this.value = this.value.toUpperCase();
	});
	
    $('#prodShopDepUnitTable').dataTable({"bPaginate" : false,
    	                                  "bFilter" : false,
    	                                  "ordering": false,
                                          "bInfo" : false,
                                          "resizableColumns" : true,
                                          "width" : 10});
    
    var table = $('#prodShopDepUnitTable').DataTable();
    var counter = 0;   
    $('#prodShopDepUnitTable tfoot').on( 'click', '#addRow', function () {
	    addRemoveLineSignFirstRowIfNeeded('prodShopDepUnitTable');
	    var clone = $('#prodShopDepUnitTable tbody tr:last').clone();
	    clone.attr("id", "tr_" + counter++);
	    table.row
	         .add(clone)
	         .draw()
	         .node();
    });

    $('#prodShopDepUnitTable tbody').on( 'click', '.deleteRow', function () {
	    table.row( $(this).closest('tr') )
	         .remove()
	         .draw();
	    removeRemoveLineSignFirstRowIfNeeded('prodShopDepUnitTable');
    });
});