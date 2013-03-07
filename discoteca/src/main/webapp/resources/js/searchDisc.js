$(function() {
		$("#grid").jqGrid({
		   	url:contexPath + "/jsonSearchDisc.htm",
			datatype: 'json',
			mtype: 'GET',
		   	colNames:['Nombre', 'Grupo'],
		   	colModel:[
		   		{name:'nombre',index:'nombre', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}},
		   		{name:'grupo',index:'grupo', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}},
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
		    caption:"Discs",
		    emptyrecords: "Empty discs",
		    loadonce: false,
		    loadComplete: function() {},
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