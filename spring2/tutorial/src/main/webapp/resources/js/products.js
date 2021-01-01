$(".pageNum").click(function() {
	var page = 6*(Number($(this).text())-1);
	var categoryId = Number($(location).attr('pathname').slice(-1));
	var dataTransfer = {"page":page,
						"categoryId":categoryId};
	
	$.ajax({
		url:"/category/paging", 
		type:"POST", 
		data:JSON.stringify(dataTransfer), 
		contentType: "application/json; charset=utf-8;",
	    dataType: "json",
		success:function(data) {
			paging(data);
			
		},
		error:function() {
			alert("ERROR!!");
		}
	});
});

$("#nextPage").click(function() {
	var startPageNo = Number($(".pageNum")[0].textContent);
	var lastPageNo = Number($(".pageNum")[4].textContent);
	
	var dataTransfer = {"page":Number(lastPageNo),
						"categoryId":Number($(location).attr('pathname').slice(-1))};
						
	$.ajax({
		url:"/category/paging", 
		type:"POST", 
		data:JSON.stringify(dataTransfer), 
		contentType: "application/json; charset=utf-8;",
	    dataType: "json",
		success:function(data) {
			if (lastPageNo+5 <= totalPageNo) {
				lastPageNo = lastPageNo + 5;
			}
			else {
				lastPageNo = totalPageNo;
			}
			
			var buttonHtml = "";
			buttonHtml += "<button type=\"button\" class=\"btn btn-primary\">이전</button>";
			for (var pageNo=startPageNo+5; pageNo<=lastPageNo; pageNo++) {
				buttonHtml += "<button type=\"button\" class=\"btn btn-primary pageNum\">" + pageNo + "</button>";
			}
			$("#pageButtonGroup").html(buttonHtml);
			
			paging(data);
			
		},
		error:function() {
			alert("ERROR!!");
		}
	});
});

function paging(data) {
	var html = "";
	for (var i=0; i<data.length; i++) {
		html += "<div class=\"col-lg-4 col-md-6 mb-4\">";
	    html += "<div class=\"card h-100\">";
	    html += "<a href=\"#\"><img class=\"card-img-top\" src=\"" + data[i].product_img + "\"></a>";
	    html += "<div class=\"card-body\">";
	    html += "<h4 class=\"card-title\">";
	    html += "<a href=\"#\">" + data[i].product_name + "</a>";
	    html += "</h4>";
	    html += "<h5>" + data[i].product_price + "</h5>";
	    html += "<p class=\"card-text\">" + data[i].seller + "</p>";
	    html += "</div>";
	    html += "<div class=\"card-footer\">";
	    html += "<small class=\"text-muted\">&#9733; &#9733; &#9733; &#9733; &#9734;</small>";
	    html += "</div>";
	    html += "</div>";
	    html += "</div>";
	}
	$("#productsRow").html(html);
};