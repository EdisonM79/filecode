$(function(){
	var userDiv = $("input[name='userDiv']").val();
	lastViewDate = currentTimeDate;
	if(userDiv != '01'){
		var noReadMsgCount = $("#noReadMsgCount").val();
		if(noReadMsgCount > 0){
			$(".nav-remind").removeClass("hidden");
		}else{
			$(".nav-remind").removeClass("hidden");
			$(".nav-remind").addClass("hidden");
		}
	}
	$(".btn-detail").click(function() {
		var thisElementParent = $(this).parent().parent();
		var recordId = thisElementParent.children("input[name='recordId']").val();
		var farmId = thisElementParent.children("input[name='farmId']").val();
		var url = "/read/warning/msg";
		var params = {
			"msgId" : recordId,
			"farmId":farmId
		};
		getJson(url, params,function(resultData,status){
			if(status=='success'){
				var name = thisElementParent.children(".warning-name").text();
				var address = thisElementParent.children(".warning-address").text();
				var time = thisElementParent.children("input[name='recordTime']").val();
				var content = thisElementParent.children("input[name='recordMsg']").val();
				var count = resultData.noReadMsgCount
				showWarningDetailBox(name, time, content,address, userDiv);
				thisElementParent.find(".remind").addClass("hidden");
				if(userDiv != '01'){
					if(count > 0){
						$(".nav-remind").removeClass("hidden");
					}else{
						$(".nav-remind").removeClass("hidden");
						$(".nav-remind").addClass("hidden");
					}
				}
			}
		})
	});
	
	function showWarningDetailBox(name, time, content,address, userDiv) {
		var warningDetailBoxHtml = '<div class="modal fade" id="warningDetailBox">';
		warningDetailBoxHtml += '<div class="modal-dialog">';
		warningDetailBoxHtml += '	<div class="modal-content">';
		warningDetailBoxHtml += '	<div class="modal-header">';
		warningDetailBoxHtml += '	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>';
		warningDetailBoxHtml += '	<h4 class="modal-title">' + name + '</h4>';
		warningDetailBoxHtml += '	</div>';
		warningDetailBoxHtml += '	<div class="modal-body">';
		warningDetailBoxHtml += '	<span class="title color-title">告警时间：</span>';
		warningDetailBoxHtml += '	<span class="content">' + time + '</span><br>';
		if(userDiv != '03'){
		warningDetailBoxHtml += '	<span class="title color-title">告警农场：</span>';
		warningDetailBoxHtml += '	<span class="content">' + address + '</span><br>';
		}
		warningDetailBoxHtml += '	<span class="title color-title">告警内容：</span>';
		warningDetailBoxHtml += '	<span class="content">' + content + '</span>';
		warningDetailBoxHtml += '</div>';
		warningDetailBoxHtml += '</div>';
		warningDetailBoxHtml += '	</div>';
		warningDetailBoxHtml += '</div>';
		$("body").after(warningDetailBoxHtml);
		$('#warningDetailBox').modal('show');
		$('#warningDetailBox').on('hidden.bs.modal', function(e) {
			$(this).remove();
		});
	}
	var pagePrevious = $("#statusReportListPrevious").val();
	var pageNext = $("#statusReportListNext").val();
	var pageNumObj = $("#statusReportListPageNum");
	var pageNum = pageNumObj.val();
	var pageLi = pageNumObj.parent().find("ul.pagination>li");
	$(pageLi).each(function() {
		var pageText = $(this).children("a").text();
		if (pageNum == pageText) {
			$(this).addClass("active");
		}

		if($(this).hasClass("previous")) {
			if (pagePrevious == 'true' || pagePrevious == true) {
				$(this).click(function() {
					var goPageNum = parseInt(pageNum) - 1;
					goPage(goPageNum);
				});
			}
		}
		else if($(this).hasClass("next")) {
			if (pageNext == 'true' || pageNext == true) {
				$(this).click(function() {
					var goPageNum = parseInt(pageNum) + 1;
					goPage(goPageNum);
				});
			}
		} else {
			$(this).click(function() {
				var goPageNum = $(this).children("a").text();
				goPage(goPageNum);
			});
		}
	});
	var pageGo = pageNumObj.parent().find(".pagination-go");
	var pageGoNum = pageGo.children("input");
	var pageGoBtn = pageGo.children("button");
	pageGoBtn.click(function() {
		var goPageNum = pageGoNum.val();
		if (goPageNum != null && goPageNum != "") {
			goPage(goPageNum);
		} else {
			pageGoNum.focus();
		}
	});

	function goPage(goPageNum) {
		var url = "/warning/list";
		var params = {
			"pageNum" : goPageNum
		};
		getHtml(url, params, "wrapper_sub3");
	}
	
});