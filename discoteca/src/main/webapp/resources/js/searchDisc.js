jQuery(document).ready(function($){
$.ajax( {
	url : contexPath + "/jsonSearchDisc2.htm",
	type : "POST",
	dataType : "json",
	success : function(data) {
		var results = data.rows;
		jQuery("#grid").jqGrid({
			url : contexPath + "/jsonSearchDisc2.htm",
			datatype : 'json',
			mtype : 'POST',
			height : 250,
			colNames : [ 'Nombre', 'Grupo'],
			colModel : [ {
				name : 'nombre',
				index : results.nombre,
				width : 130,
				sortable : false
			}, {
				name : 'grupo',
				index : results.grupo,
				width : 100,
				sortable : false
			} ],
			jsonReader : {
				repeatitems : false,
				id : "0"
			},
			multiselect : false,
			paging : true,
			rowNum : 10,
			rowList : [ 10, 20, 30 ],
			pager : $("#pager"),
			loadonce : true,
			caption : "Business Details"
		}).navGrid('#pager', {
			edit : true,
			add : false,
			del : false,
			search : false
		});
	},
	error : function(xhr, ajaxoptions, thrownError) {
		alert("my error=" + thrownError);
		alert("me error1=" + ajaxoptions);
		alert("my error2=" + xhr);
	}
});
});