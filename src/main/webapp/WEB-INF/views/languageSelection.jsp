<script>
function getDataTabelLanguage(){
	var responseLocale = "${pageContext.response.locale}";
	var languageMap = {
			           "de": "German",
			           "el": "Greek",
			           "en": "English",
			          };

    return languageMap[(responseLocale in languageMap) ? responseLocale : "en"];
}

function calcDataTabelLangPackage(){
	var dataTableLanguage = getDataTabelLanguage();
	if (dataTableLanguage == "English")
		   return "";
	else
		   return {"language": { 
			          "url":
			              "${datatablesPath}/${datatablesVersion}/language_files/" + dataTableLanguage + ".json"
			          }
	              };
}
</script>