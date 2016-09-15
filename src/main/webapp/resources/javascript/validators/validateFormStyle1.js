/*
 * validateFormStyle1
 * ==============================================
 * The purpose is to imitate Spring error highlight
 * 
 * The function is applicable for the following DOM tree
 * 
 * <spring:bind path="objId">
 *  <div class="has-error">
 *  <label">Label</label>
 *  <div class="col-sm-3">
 *  <input name="objId" id="objId">
 *      (<span id="objId.errors"></span>)
 *  </div>
 *  </div>
 * </spring:bind>
 * 
 * if objName's value is empty a span with id objName.errors will
 * be appended in case it does not exist
 *  
 *
*/
function validateFormStyle1(mustNotBeEmptyObj) {
	returnVal = true;
	
	for (i = 0; i < mustNotBeEmptyObj.length; i++) {
		originalObjName = mustNotBeEmptyObj[i]
		spanErrorId = originalObjName + ".errors"
		
		//the selector has problems with the dot character
		//so we have to replace it in a save way
		mustNotBeEmptyObj[i] = originalObjName.replace(/\./g,'\\.')
		
		mnbeObj = $("#" + mustNotBeEmptyObj[i]);
		
		//init
		mnbeObj.parent().parent().removeClass("has-error");
		$('span[id="' + spanErrorId + '"]').html("");
		
		if (mnbeObj.val() == "") {
			highlightTheError(mnbeObj, spanErrorId);
			
			returnVal = false;
		}
	}
	
	if (!returnVal)
		$("#" + mustNotBeEmptyObj[0]).focus();
	
	return returnVal;
}

function highlightTheError(theObj, theSpanId){
	theObj.parent().parent().addClass("has-error");
	
	if (!$('span[id="' + theSpanId + '"]').length) {
		theObj.parent().append('<span id="'+ theSpanId +'" class="control-label"></span>');
	}
	
	$('span[id="' + theSpanId + '"]').html($('input[id="' + theObj.attr('id') + '.empty.jserror"]').val())
}