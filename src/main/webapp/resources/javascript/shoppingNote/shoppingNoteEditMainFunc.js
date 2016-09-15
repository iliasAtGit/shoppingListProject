

function submitShopNoteAddForm(thisForm) {
	mustNotBeEmptyObj = [ "name", "dateStart", "dateEnd" ];
	if (validateFormStyle1(mustNotBeEmptyObj))
		thisForm.submit()
}

function removeShoppingNote(obj, id) {
	$.ajax({
		url : 'removeAjax-' + id,
		type: "GET",
		beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
          },
		success : function(data) {
			$('#ajaxRecall').html(data);
			$(obj).closest('tr').remove();
		}
	});
}

function toggleShoppingNote(id){
	toggleThese = ["shoppingNoteName", "shoppingNoteStartDt", "shoppingNoteEndDt", "editButtuns"];
	toggleElements(id, toggleThese);	
}

function requestToSaveShoppingNote(id, name, dateStart, dateEnd){
	var data = {id : id, name:name, dateStart:dateStart, dateEnd:dateEnd};
	
	$.ajax({
		type : "POST",
		url : "addForm",//"${home}addForm",
		data : JSON.stringify(data),
		contentType : 'application/json; charset=utf-8',
	    dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			alert("OK");
			toggleShoppingNote(id);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			alert("ERROR")
			alert(e);
		},
		done : function(e) {
			console.log("DONE");
			alert("done")
		}
	});
}

function saveShoppingNoteA(id) {
    var name = $( "#tr"+id+" .shoppingNoteName div:nth-child(2) input:nth-child(1)" ).val();
	var dateStart = $( "#tr"+id+" .shoppingNoteStartDt div:nth-child(2) input:nth-child(1)" ).val();
	var dateEnd = $( "#tr"+id+" .shoppingNoteEndDt div:nth-child(2) input:nth-child(1)" ).val();
	
	$( "#tr"+id+" .shoppingNoteName div:nth-child(1)" ).html(name);
	$( "#tr"+id+" .shoppingNoteStartDt div:nth-child(1)" ).html(dateStart);
	$( "#tr"+id+" .shoppingNoteEndDt div:nth-child(1)" ).html(dateEnd);
	
	requestToSaveShoppingNote(id, name, dateStart, dateEnd)
}


function browseShoppingNote(id){
	$.redirect('../shoppingList/display-' + id, {}, "GET");
}

function addDatePicker(){
	$.datepicker.setDefaults($.datepicker.regional[$("#locale").val()]);
	
	$("#dateStart").datepicker({
		// dateFormat: "dd/mm/yy",
		minDate : "-1w",
		onSelect : function(date) {
			var dateEnd = $('#dateEnd');
			var dateStart = $(this).datepicker('getDate');
			var minDate = $(this).datepicker('getDate');
			dateEnd.datepicker('setDate', minDate);
			dateStart.setDate(dateStart.getDate() + 30);
			//sets dateEnd element maxDate to the last day of 30 days window
			dateEnd.datepicker('option', 'maxDate', dateStart);
			dateEnd.datepicker('option', 'minDate', minDate);
			$(this).datepicker('option', 'minDate', minDate);
		}
	});
	$("#dateEnd").datepicker({
				defaultDate : "+1w",
				numberOfMonths : 2,
				onClose : function(selectedDate) {
					$("#dateStart").datepicker("option", "maxDate",
							selectedDate);
				}
			});
	$("#dateFormat").val($('#dateEnd').datepicker('option', 'dateFormat'));
}