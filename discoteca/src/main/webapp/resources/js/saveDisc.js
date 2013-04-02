$(function() {
	$("#grupo").autocomplete({
		source : contexPath + "/jsonAutoCompleteGroupName.htm",
		minLength : 3
	});
	
	$("#gridSingers").jqGrid({
		url : contexPath + "/jsonSearchSinger.htm?id="+$('#idDisc').val(),
		datatype : 'json',
		mtype : 'POST',
		colNames : [ 'Nombre', 'Instrumento', 'Ident' ],
		colModel : [ {
			name : 'nombre',
			index : 'nombre',
			width : 100,
			editable : true,
			editrules : {
				required : true
			},
			editoptions : {
				size : 10
			}
		}, {
			name : 'instrumento',
			index : 'instrumento',
			width : 100,
			editable : true,
			editrules : {
				required : true
			},
			editoptions : {
				size : 10
			}
		}, {
			name : 'ident',
			index : 'ident',
			width : 100,
			editable : false,
			editrules:{
                required:true, 
                edithidden:true
            }, 
            hidden:true,
			editoptions : {
				size : 10
			}
			
		}, ],
		postData : {},
		rowNum : 3,
		autowidth : true,
		rownumbers : true,
		pager : '#pagerSingers',
		sortname : 'nombre',
		viewrecords : true,
		sortorder : "asc",
		caption : "Singers",
		emptyrecords : "Empty singers",
		loadonce : false,
		loadComplete : function() {
		},
		serializeGridData : function(postData) {
			return JSON.stringify(postData);
		},
		ajaxGridOptions : {
			contentType : "application/json"
		}, // permite enviar json
		jsonReader : {
			root : "rows",
			page : "page",
			total : "total",
			records : "records",
			repeatitems : false,
			cell : "cell",
			id : "id"
		}
	});
	
	$("#gridSingers").jqGrid('navGrid', '#pagerSingers', {
		edit : false,
		add : false,
		del : false,
		search : false
	}, {}, {}, {}, { // search
		sopt : [ 'cn', 'eq', 'ne', 'lt', 'gt', 'bw', 'ew' ],
		closeOnEscape : true,
		multipleSearch : true,
		closeAfterSearch : true
	});

	$("#gridSingers").navButtonAdd('#pagerSingers', {
		caption : "Add",
		buttonicon : "ui-icon-plus",
		onClickButton : addSinger,
		position : "last",
		title : "",
		cursor : "pointer"
	});

	$("#gridSingers").navButtonAdd('#pagerSingers', {
		caption : "Delete",
		buttonicon : "ui-icon-trash",
		onClickButton : deleteSinger,
		position : "last",
		title : "",
		cursor : "pointer"
	});

	$("#gridSongs").jqGrid({
		url : contexPath + "/jsonSearchSong.htm?id="+$('#idDisc').val(),
		datatype : 'json',
		mtype : 'POST',
		colNames : [ 'Nombre', 'Duraci&oacute;n', 'Posici&oacute;n', 'Ident' ],
		colModel : [ {
			name : 'nombre',
			index : 'nombre',
			width : 100,
			editable : true,
			editrules : {
				required : true
			},
			editoptions : {
				size : 10
			}
		}, {
			name : 'duracion',
			index : 'duracion',
			width : 100,
			editable : true,
			editrules : {
				required : true
			},
			editoptions : {
				size : 10
			}
		}, {
			name : 'posicion',
			index : 'posicion',
			width : 100,
			editable : true,
			editrules : {
				required : true
			},
			editoptions : {
				size : 10
			}
			
		}, {
			name : 'ident',
			index : 'ident',
			width : 100,
			editable : false,
			editrules:{
                required:true, 
                edithidden:true
            }, 
            hidden:true,
			editoptions : {
				size : 10
			}
			
		}, ],
		postData : {},
		rowNum : 10,
		rowList : [ 10, 20, 40, 60 ],
		height : 240,
		autowidth : true,
		rownumbers : true,
		pager : '#pagerSongs',
		sortname : 'nombre',
		viewrecords : true,
		sortorder : "asc",
		caption : "Songs",
		emptyrecords : "Empty songs",
		loadonce : false,
		loadComplete : function() {
		},
		serializeGridData : function(postData) {
			return JSON.stringify(postData);
		},
		ajaxGridOptions : {
			contentType : "application/json"
		}, // permite
		// enviar json
		jsonReader : {
			root : "rows",
			page : "page",
			total : "total",
			records : "records",
			repeatitems : false,
			cell : "cell",
			id : "id"
		}
	});

	$("#gridSongs").jqGrid('navGrid', '#pagerSongs', {
		edit : false,
		add : false,
		del : false,
		search : false
	}, {}, {}, {}, { // search
		sopt : [ 'cn', 'eq', 'ne', 'lt', 'gt', 'bw', 'ew' ],
		closeOnEscape : true,
		multipleSearch : true,
		closeAfterSearch : true
	});

	$("#gridSongs").navButtonAdd('#pagerSongs', {
		caption : "Add",
		buttonicon : "ui-icon-plus",
		onClickButton : addSong,
		position : "last",
		title : "",
		cursor : "pointer"
	});

	$("#gridSongs").navButtonAdd('#pagerSongs', {
		caption : "Delete",
		buttonicon : "ui-icon-trash",
		onClickButton : deleteSong,
		position : "last",
		title : "",
		cursor : "pointer"
	});
});

function addSinger(){
	$('#gridSingers').jqGrid('editGridRow', 'new', {
		url : contexPath + "/jsonAddSinger.htm",
		editData : {
			idDisco : $('#idDisc').val()
		},
		serializeEditData : function(data) {
			data.id = 0;
			return $.param(data);
		},
		ajaxGridOptions : {
			contentType : "application/json"
		}, // permite enviar json
		recreateForm : true,
		beforeShowForm : function(form) {
			$('#pData').hide();
			$('#nData').hide();
			// $('#password',form).addClass('ui-widget-content').addClass('ui-corner-all');
		},
		beforeInitData : function(form) {
		},
		closeAfterAdd : true,
		reloadAfterSubmit : true,
		afterSubmit : function(response, postdata) {
			var result = eval('(' + response.responseText + ')');
			var errors = "";

			if (result.success == false) {
				for ( var i = 0; i < result.message.length; i++) {
					errors += result.message[i] + "<br/>";
				}
			} else {
				$('#msgbox').text('Entry has been added successfully');
				$('#msgbox').dialog({
					title : 'Success',
					modal : true,
					buttons : {
						"Ok" : function() {
							$(this).dialog("close");
						}
					}
				});
			}
			// only used for adding new records
			var newId = null;

			return [ result.success, errors, newId ];
		}
	});
}

function deleteSinger(){
	var row = $('#gridSingers').jqGrid('getGridParam', 'selrow');

	// A pop-up dialog will appear to confirm the selected action
	if (row != null)
		$('#gridSingers').jqGrid('delGridRow',	row,{
					url : contexPath + "/jsonDeleteSinger.htm",
					recreateForm : true,
					beforeShowForm : function(form) {
						// Change title
						$(".delmsg").replaceWith('<span style="white-space: pre;">Delete selected record?</span>');
						// hide arrows
						$('#pData').hide();
						$('#nData').hide();
					},
					reloadAfterSubmit : true,
					closeAfterDelete : true,
					serializeDelData : function(postdata) {
						var rowdata = $('#gridSingers').getRowData(postdata.id);
						// append postdata with any information
						return {
							id : rowdata.ident,
							oper : postdata.oper,
							idDisco : $('#idDisc').val()
						};
					},
					afterSubmit : function(response, postdata) {
						var result = eval('(' + response.responseText + ')');
						var errors = "";

						if (result.success == false) {
							for ( var i = 0; i < result.message.length; i++) {
								errors += result.message[i] + "<br/>";
							}
						} else {
							$('#msgbox').text('Entry has been deleted successfully');
							$('#msgbox').dialog({
								title : 'Success',
								modal : true,
								buttons : {
									"Ok" : function() {
										$(this).dialog("close");
									}
								}
							});
						}
						// only used for adding new records
						var newId = null;

						return [ result.success, errors, newId ];
					}
				});
	else {
		$('#msgbox').text('You must select a record first!');
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

function addSong() {
	// $("#gridSongs").jqGrid('setColProp', 'username', {editoptions:{readonly:false,
	// size:10}});
	// $("#gridSongs").jqGrid('setColProp', 'password', {hidden: false});
	// $("#gridSongs").jqGrid('setColProp', 'password', {editrules:{required:true}});

	// Get the currently selected row
	$('#gridSongs').jqGrid('editGridRow', 'new', {
		url : contexPath + "/jsonAddSong.htm",
		editData : {
			idDisco : $('#idDisc').val()
		},
		serializeEditData : function(data) {
			data.id = 0;
			return $.param(data);
		},
		ajaxGridOptions : {
			contentType : "application/json"
		}, // permite enviar json
		recreateForm : true,
		beforeShowForm : function(form) {
			$('#pData').hide();
			$('#nData').hide();
			// $('#password',form).addClass('ui-widget-content').addClass('ui-corner-all');
		},
		beforeInitData : function(form) {
		},
		closeAfterAdd : true,
		reloadAfterSubmit : true,
		afterSubmit : function(response, postdata) {
			var result = eval('(' + response.responseText + ')');
			var errors = "";

			if (result.success == false) {
				for ( var i = 0; i < result.message.length; i++) {
					errors += result.message[i] + "<br/>";
				}
			} else {
				$('#msgbox').text('Entry has been added successfully');
				$('#msgbox').dialog({
					title : 'Success',
					modal : true,
					buttons : {
						"Ok" : function() {
							$(this).dialog("close");
						}
					}
				});
			}
			// only used for adding new records
			var newId = null;

			return [ result.success, errors, newId ];
		}
	});

	// $("#gridSongs").jqGrid('setColProp', 'password', {hidden: true});
} // end of addRow

function deleteSong(obj, args) {
	// Get the currently selected row
	var row = $('#gridSongs').jqGrid('getGridParam', 'selrow');

	// A pop-up dialog will appear to confirm the selected action
	if (row != null)
		$('#gridSongs').jqGrid('delGridRow',	row,{
					url : contexPath + "/jsonDeleteSong.htm",
					recreateForm : true,
					beforeShowForm : function(form) {
						// Change title
						$(".delmsg").replaceWith('<span style="white-space: pre;">Delete selected record?</span>');
						// hide arrows
						$('#pData').hide();
						$('#nData').hide();
					},
					reloadAfterSubmit : true,
					closeAfterDelete : true,
					serializeDelData : function(postdata) {
						var rowdata = $('#gridSongs').getRowData(postdata.id);
						// append postdata with any information
						return {
							id : rowdata.ident,
							oper : postdata.oper,
							idDisco : $('#idDisc').val()
						};
					},
					afterSubmit : function(response, postdata) {
						var result = eval('(' + response.responseText + ')');
						var errors = "";

						if (result.success == false) {
							for ( var i = 0; i < result.message.length; i++) {
								errors += result.message[i] + "<br/>";
							}
						} else {
							$('#msgbox').text('Entry has been deleted successfully');
							$('#msgbox').dialog({
								title : 'Success',
								modal : true,
								buttons : {
									"Ok" : function() {
										$(this).dialog("close");
									}
								}
							});
						}
						// only used for adding new records
						var newId = null;

						return [ result.success, errors, newId ];
					}
				});
	else {
		$('#msgbox').text('You must select a record first!');
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
