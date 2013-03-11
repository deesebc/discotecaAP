$(function(){
    $("#grupo").autocomplete({
        source: contexPath + "/jsonAutoCompleteGroupName.htm", 
        minLength: 3
    });
});