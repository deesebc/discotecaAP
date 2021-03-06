$(function() {
		$("#grid").jqGrid({
		   	url:contexPath + "/jsonSearchBook.htm",
			datatype: 'json',
			mtype: 'POST',
		   	colNames:['Nombre', 'Serie', 'Autor', 'Identificador'],
		   	colModel:[
		   		{name:'nombre',index:'nombre', search:true, stype:'text', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}},
		   		{name:'serie',index:'serie', search:true, stype:'text', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}},
		   		{name:'autor',index:'autor', search:true, stype:'text', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}},
		   		{name:'ident',index:'ident', hidden:true}
		   	],
		   	postData: {},
			rowNum:2,
		   	rowList:[2,10,20,50],
		   	height: 240,
		   	autowidth: true,
		   	pager: '#pager',
		   	sortname: 'nombre',
		    viewrecords: true,
		    sortorder: "asc",
		    caption:"Books",
		    emptyrecords: "Empty books",
		    loadonce: false,
		    serializeGridData: function(postData) {
			    return JSON.stringify(postData);
			},
			ajaxGridOptions: { contentType: "application/json" }, //permite enviar json
		    jsonReader : {
		        root: "rows",
		        page: "page",
		        total: "total",
		        records: "records",
		        repeatitems: false,
		        cell: "cell",
		        id: "id"
		    },loadError : function(xhr,st,err) {
		    	console.log('loadError - xhr: '+xhr);
		    	console.log('loadError - st: '+st);
		    	console.log('loadError - err: '+err);
		    },loadComplete: function(data) {
		    	if(data.error != null){
			    	$('#msgbox').text('Ha ocurrido un error en la carga');
					$('#msgbox').dialog({
						title : 'Error',
						modal : true,
						buttons : {
							"Ok" : function() {
								$(this).dialog("close");
							}
						}
					});
			    }
		    }
		});
		
		$("#grid").jqGrid('navGrid','#pager',
				{edit:false, add:false, del:false, search:true},
				{}, {}, {}, 
				{ 	// search
//					sopt:['cn', 'eq', 'ne', 'lt', 'gt', 'bw', 'ew'],
					sopt:['cn'],
					groupOps: [ { op: "AND", text: "all" } ],
					closeOnEscape: true, 
					multipleSearch: true, 
					closeAfterSearch: true
				}
		);
		
		$("#grid").navButtonAdd('#pager',
				{ 	caption:"Add", 
					buttonicon:"ui-icon-plus", 
					onClickButton: addRow,
					position: "last", 
					title:"", 
					cursor: "pointer"
				} 
		);
		
		$("#grid").navButtonAdd('#pager',
				{ 	caption:"Edit", 
					buttonicon:"ui-icon-pencil", 
					onClickButton: editRow,
					position: "last", 
					title:"", 
					cursor: "pointer"
				} 
		);
		
		$("#grid").navButtonAdd('#pager',
			{ 	caption:"Delete", 
				buttonicon:"ui-icon-trash", 
				onClickButton: deleteRow,
				position: "last", 
				title:"", 
				cursor: "pointer"
			} 
		);
 	
		// Toolbar Search
		//$("#grid").jqGrid('filterToolbar',{stringResult: true,searchOnEnter : true, defaultSearch:"cn"});
	});

function addRow(){
	window.location.href = contexPath + '/create/book.htm';
}
function deleteRow(){
	//con redireccion
	var grid = jQuery('#grid');
	var sel_id = grid.jqGrid('getGridParam', 'selrow');
	var myCellData = grid.jqGrid('getCell', sel_id, 'ident');
	console.log(myCellData);
	window.location.href = contexPath + '/delete/book.htm?id=' + myCellData;
	//con json los otros ejemplos
	
}
function editRow() {
    // Redireccionar a la pagina de Edicion de Registro, con el ultimo seleccionado
	var grid = jQuery('#grid');
    var row = grid.jqGrid('getGridParam','selrow');
    var ident = grid.jqGrid('getCell', row, 'ident');
    
    if( row != null ) {
        window.location.href = contexPath + '/edit/book.htm?id=' + ident;
    } else { 
        jQuery( "#dialogSelectRow" ).dialog({
                buttons: { OK: function() {
                                    jQuery( this ).dialog( "close" );
                                }
                            }
            }
        );
    }
}