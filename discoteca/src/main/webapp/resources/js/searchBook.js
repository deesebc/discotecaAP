$(function() {
		$("#grid").jqGrid({
		   	url:contexPath + "/jsonSearchBook.htm",
			datatype: 'json',
			mtype: 'POST',
		   	colNames:['Nombre', 'Autor', 'Identificador'],
		   	colModel:[
		   		{name:'nombre',index:'nombre', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}},
		   		{name:'autor',index:'autor', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}},
		   		{name:'ident',index:'ident', hidden:true}
		   	],
		   	postData: {},
			rowNum:10,
		   	rowList:[10,20,40,60],
		   	height: 240,
		   	autowidth: true,
			rownumbers: true,
		   	pager: '#pager',
		   	sortname: 'nombre',
		    viewrecords: true,
		    sortorder: "asc",
		    caption:"Books",
		    emptyrecords: "Empty books",
		    loadonce: false,
		    loadComplete: function() {},
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
		    }
		});
		
		$("#grid").jqGrid('navGrid','#pager',
				{edit:false, add:false, del:false, search:true},
				{}, {}, {}, 
				{ 	// search
					sopt:['cn', 'eq', 'ne', 'lt', 'gt', 'bw', 'ew'],
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
		$("#grid").jqGrid('filterToolbar',{stringResult: true,searchOnEnter : true, defaultSearch:"cn"});
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
    var row = jQuery("#grid").jqGrid('getGridParam','selrow');
    
    if( row != null ) {
        window.location.href = contexPath + '/edit/book.htm?id=' + row;
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