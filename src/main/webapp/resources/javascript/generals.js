function focusFirstVisibleInput(){
	$('form').find('input[type=text],textarea,select').filter(':visible:first').focus();
}


/*
 * function toggleElements(id, tdClass)
 * id:      a unique id, mostly the sql record id
 * tdClass: array of td classes that contain the divs to toggle
 * 
 * Affected style
 * <tr id="tr${id}">
 *     <td class="tdClass">
 *	   		<div class="read"></div>  <!-- .read  initialized as visible -->
 *	   		<div class="write"></div> <!-- .write initialized as display: none; -->
 *	   </td>
 * </tr>
 * 
 */
function toggleElements(id, tdClass){
	if ( tdClass.length != 0) {
		newReadElementVisibility = ($( "#tr"+id+" ."+tdClass[0]+" div:nth-child(1)" ).is(':visible') === true ) ? false : true;
		
		for (i = 0; i < tdClass.length; i++){
			$( "#tr"+id+" ."+tdClass[i]+" div:nth-child(1)" ).toggle(newReadElementVisibility);
			$( "#tr"+id+" ."+tdClass[i]+" div:nth-child(2)" ).toggle(!newReadElementVisibility);
		}
	}
}

function requestToRemoveSimply(id) {
	$.ajax({
		type : "POST",
		url : "removeAjax-" + id,
		contentType : "application/json; charset=utf-8",
	    dataType : "text json",
		success : function(response) {
			if (response.serversResponse == "success")
				$("#tr" + id).remove();
			else
				alert(response.serversResponse);
		},
		error : function(jqXHR, textStatus, ex) {			
			var isJSON = true;

	       	try {
	       		var responseJSON = jQuery.parseJSON(jqXHR.responseText);
	       	}
	       	catch(err) {
	       		isJSON = false;
	       		alert(JSON.stringify(jqXHR))
	       	}  
		
			if (isJSON){
				alert(jqXHR.responseText + "\n" + textStatus + "\n" + ex);
			}
		}
	});
}

function showErrorCodesAfterRequest(id, responseJSON){
	$.each(responseJSON.fieldErrors, function(key, item){
		$( "#tr"+ id +" ."+ item.field +" div.has-error" ).html("")
	});
	
	$("td", "#tr"+ id).each(function() {
		
	
	});
	
	$.each(responseJSON.fieldErrors, function(key, item){
		$( "#tr"+ id +" ."+ item.field +" div.has-error" ).append(item.code + "<br />")
	});
}
function requestToSaveSimply(id, data, funcToExecuteOnSuccess){
	
	$.ajax({
		type : "POST",
		url : "updateAjax-" + id,
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
	    dataType : "text json",
		timeout : 5000,
		beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
		success : function(response) {
			if (response.serversResponse == "success")
				funcToExecuteOnSuccess();
			else
				alert(response.serversResponse);
		},
		error : function(jqXHR, textStatus, ex) {			
			var isJSON = true;

	       	try {
	       		var responseJSON = jQuery.parseJSON(jqXHR.responseText);
	       	}
	       	catch(err) {
	       		isJSON = false;
	       		alert(JSON.stringify(jqXHR))
	       	}  
		
			if (isJSON){
				if (responseJSON.code == "InvalidRequest")		
					showErrorCodesAfterRequest(id, responseJSON);
				else
					 alert(jqXHR.responseText + "\n" + textStatus + "\n" + ex);
			}
		}		
	});
}